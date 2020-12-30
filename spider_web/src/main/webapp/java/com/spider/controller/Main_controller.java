package com.spider.controller;

import cn.hutool.core.io.FileUtil;
import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.InformationPipelineWithBLOBs;
import com.spider.bean.MainWithBLOBs;
import com.spider.bean.Main_CHLandLAR;
import com.spider.bean.MarkdetailMainWithBLOBs;
import com.spider.elemente.TimerParm;
import com.spider.service.ErrorLog_service;
import com.spider.service.MainCHLandLAR_service;
import com.spider.service.Main_service;
import com.spider.service.TXwInformation_service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Main_controller
 * </p>
 *
 * @author msi-
 * @package: com.spider.controller
 * @description: 正式库Main表维护
 * @date: Created in 2020-12-28 14:55
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: msi-
 */
@Controller
@RequestMapping("main")
public class Main_controller {

    @Autowired
    private Main_service main_service;

    @Autowired
    private MainCHLandLAR_service mainCHLandLAR_service;

    //正式库数据列表
    @RequestMapping("search")
    public String search(@RequestParam Map<String, String> params, Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);

        List<Main_CHLandLAR> mainList = mainCHLandLAR_service.search(params);

        model.addAttribute("mainList",mainList);
        model.addAttribute("params",params);
        return "_main/_mainList";
    }


    //正式库数据列表
    @RequestMapping("list")
    public String getInformationPipelinemarkList(Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);

        List<Main_CHLandLAR> mainList = mainCHLandLAR_service.findAll();

        model.addAttribute("mainList",mainList);
        return "_main/_mainList";
    }

    //详情
    @RequestMapping("detail/{rid}")
    public String detail(@PathVariable(value = "rid")String rid, Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);

        //获取地方库新闻数据
        Main_CHLandLAR main = mainCHLandLAR_service.selectByPrimaryKey(Long.parseLong(rid));
        String content = readTxt("chl",main.getRjs8());


//-------------------------------------------------------------------------------------attachment
        //附件集合返回对象

        ArrayList<HashMap> attachmentList = new ArrayList<HashMap>();


        //获取附件信息

        String attachmentPath = TimerParm.fjPath5_chl+File.separator+"chl"+File.separator+(main.getRjs8().substring(0,main.getRjs8().indexOf(".")));

        //文件路径
        List<File> files = FileUtil.loopFiles(attachmentPath);
        if (files.size()>0){
            for (File file : files) {
                HashMap attachment = new HashMap();
                attachment.put("filename",file.getName());
                attachment.put("size",(file.length()/1024)+"kb");
                attachment.put("status","原始文件");

                attachmentList.add(attachment);
            }
        }
//-------------------------------------------------------------------------------------attachment
        model.addAttribute("main",main);
        model.addAttribute("content",content);
        model.addAttribute("attachmentList",attachmentList);

        return "_main/_mainDetail";
    }


    //重命名附件
    @RequestMapping("resetFileName")
    @ResponseBody
    public boolean resetFileName(@RequestParam(value = "filename")String filename,@RequestParam(value = "oldname")String oldname,@RequestParam(value = "number")long number) throws UnsupportedEncodingException {
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);
        Main_CHLandLAR main = mainCHLandLAR_service.selectByPrimaryKey(number);

        //附件重命名
        String attachmentPATH = TimerParm.fjPath5_chl+File.separator+"chl"+File.separator+(main.getRjs8().substring(0,main.getRjs8().indexOf(".")))+ File.separator + URLDecoder.decode(URLDecoder.decode(oldname,"UTF-8"),"UTF-8");

        FileUtil.rename(new File(attachmentPATH),URLDecoder.decode(URLDecoder.decode(filename,"UTF-8"),"UTF-8"),true);

        //数据库字段回填

        main.setFjian(main.getFjian().replace(URLDecoder.decode(URLDecoder.decode(oldname,"UTF-8"),"UTF-8"),URLDecoder.decode(URLDecoder.decode(filename,"UTF-8"),"UTF-8")));


        return mainCHLandLAR_service.updateFjian(main);

    }


    //上传附件 (加锁  避免数据库维护失败)
    @RequestMapping("upload")
    @ResponseBody
    public synchronized boolean upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("number") long number,
            HttpServletRequest request) {

        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);
        Main_CHLandLAR main = mainCHLandLAR_service.selectByPrimaryKey(number);
        String path = TimerParm.fjPath5_chl+File.separator+"chl"+File.separator+(main.getRjs8().substring(0,main.getRjs8().indexOf(".")));

        //判断file数组不能为空并且长度大于0
        if(file!=null){
            MultipartFile files = file;
            //保存文件
            saveFile(files, path);

            //维护数据库
            String fjian = "";
            if (StringUtils.isNotBlank(main.getFjian())) {
                //已有附件  拼接在已有字符串后面
                fjian = main.getFjian() + "|" + files.getOriginalFilename();


            } else {
                //没有附件  直接set
                fjian = files.getOriginalFilename();
            }

            main.setFjian(fjian);

            mainCHLandLAR_service.updateFjian(main);


        }
        // 重定向
        return true;
    }

    private boolean saveFile(MultipartFile file, String path) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                File filepath = new File(path);
                if (!filepath.exists())
                    filepath.mkdirs();
                // 文件保存路径
                String savePath = path +File.separator+ file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(savePath));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //删除附件
    @RequestMapping("delAttachment")
    @ResponseBody
    public boolean delAttachment(@RequestParam(value = "filename")String filename,@RequestParam(value = "number")long number) throws UnsupportedEncodingException {
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);
        //删除附件
        Main_CHLandLAR main = mainCHLandLAR_service.selectByPrimaryKey(number);
        String attachmentPATH = TimerParm.fjPath5_chl+File.separator+"chl"+File.separator+(main.getRjs8().substring(0,main.getRjs8().indexOf(".")))+ File.separator + URLDecoder.decode(URLDecoder.decode(filename,"UTF-8"),"UTF-8");
        FileUtil.del(attachmentPATH);
        //维护数据库信息
        String newsfjian = "";
        String[] attachments = main.getFjian().split("\\|");
        for (String attachment : attachments) {
            if (attachment.equals(URLDecoder.decode(URLDecoder.decode(filename,"UTF-8"),"UTF-8"))){
                continue;
            }
            newsfjian+=attachment+"|";
        }

        main.setFjian(newsfjian.substring(0,newsfjian.length()-1));
        return mainCHLandLAR_service.updateFjian(main);

    }

    //修改
    @RequestMapping("update")
    @ResponseBody
    public Boolean update(InformationPipelineWithBLOBs information, HttpServletResponse response, Model model) throws IOException {
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);

        //为了获取正文不得不通过  informationPipeline 转换一下

        Main_CHLandLAR main = new Main_CHLandLAR(Long.parseLong(information.getExtend2()),information.getNewstitle(),information.getDeptcode(),information.getReleasetime(),information.getImptime(),information.getDeptname(),information.getFilenum(),information.getRjs1(),information.getKeyword());
        if (mainCHLandLAR_service.update(main)){
            //正文按照页面上 的数据写回到txt中

            String contextPath = TimerParm.txt_chlPath + File.separator + "chl" + File.separator +information.getFilename().substring(3,6)+File.separator +information.getFilename();
            FileUtil.writeString(information.getNewscontent(),contextPath,"GBK");

            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    //附件下载
    @RequestMapping("downLoadAttachment/{id}/{fjName}")
    @ResponseBody
    public String downLoadAttachment(@PathVariable("id")long id,@PathVariable("fjName")String fjName, HttpServletRequest request, HttpServletResponse response){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);
        Main_CHLandLAR main = mainCHLandLAR_service.selectByPrimaryKey(id);


        String attachmentPATH = TimerParm.fjPath5_chl+File.separator+"chl"+File.separator+(main.getRjs8().substring(0,main.getRjs8().indexOf(".")));

        String[] split = main.getFjian().split("\\|");

        // 下载本地文件
        fjName = fjName.replaceAll("-",".");
        String fileName = attachmentPATH+File.separator+fjName; // 文件的默认保存名
        // 读到流中
        InputStream inStream = null;// 文件的存放路径
        try {
            inStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 设置输出的格式
        response.reset();
        response.setContentType("bin");

        try {
            response.addHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fjName, "utf-8") + "\"");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 循环取出流中的数据
        byte[] b = new byte[1024];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String readTxt(String appuser,String filename) {
        String contextPath = TimerParm.txt_chlPath + File.separator + appuser + File.separator +filename.substring(3,6)+File.separator +filename;
        try {
            String resu = FileUtil.readString(contextPath,"GBK");
            return resu;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }

    }
}