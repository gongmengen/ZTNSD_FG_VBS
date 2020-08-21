package com.spider.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.*;
import com.spider.elemente.TimerParm;
import com.spider.service.*;
import com.spider.utils.NioFileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * ManCheck_controller
 * </p>
 *
 * @author msi-
 * @package: com.spider.controller
 * @description: 人工审查模块
 * @date: Created in 2020-07-30 9:14
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: msi-
 */
@Controller
@RequestMapping("manCheck")
public class ManCheck_controller {

    @Autowired
    private Main_service main_service;

    @Autowired
    private MainCHLandLAR_service mainCHLandLAR_service;


    //重命名附件
    @RequestMapping("resetFileName")
    @ResponseBody
    public boolean resetFileName(@RequestParam(value = "filename")String filename,@RequestParam(value = "oldname")String oldname,@RequestParam(value = "number")long number) throws UnsupportedEncodingException {
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        MainWithBLOBs mainByNumber = main_service.getMainByNumber(number);

        //附件重命名
        String attachmentPATH = TimerParm.fjPath5 + File.separator + mainByNumber.getRjs8().substring(0,mainByNumber.getRjs8().indexOf("."))+ File.separator + URLDecoder.decode(URLDecoder.decode(oldname,"UTF-8"),"UTF-8");
        FileUtil.rename(new File(attachmentPATH),URLDecoder.decode(URLDecoder.decode(filename,"UTF-8"),"UTF-8"),true);

        //数据库字段回填
        MainWithBLOBs main = new MainWithBLOBs();
        main.setFjian(mainByNumber.getFjian().replace(URLDecoder.decode(URLDecoder.decode(oldname,"UTF-8"),"UTF-8"),URLDecoder.decode(URLDecoder.decode(filename,"UTF-8"),"UTF-8")));
        main.setNumber(mainByNumber.getNumber());

        return main_service.update(main);

    }


    //上传附件 (加锁  避免数据库维护失败)
    @RequestMapping("upload")
    @ResponseBody
    public synchronized boolean upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("number") long number,
            HttpServletRequest request) {

        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        MainWithBLOBs mainByNumber = main_service.getMainByNumber(number);
        String path = TimerParm.fjPath5 + File.separator + mainByNumber.getRjs8().substring(0,mainByNumber.getRjs8().indexOf(".")) ;

        //判断file数组不能为空并且长度大于0
        if(file!=null){
            MultipartFile files = file;
            //保存文件
            saveFile(files, path);

            //维护数据库
            String fjian = "";
            if (StringUtils.isNotBlank(mainByNumber.getFjian())) {
                //已有附件  拼接在已有字符串后面
                fjian = mainByNumber.getFjian() + "|" + files.getOriginalFilename();


            } else {
                //没有附件  直接set
                fjian = files.getOriginalFilename();
            }
            MainWithBLOBs main = new MainWithBLOBs();
            main.setFjian(fjian);
            main.setNumber(mainByNumber.getNumber());
            main_service.update(main);


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
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        //删除附件
        MainWithBLOBs mainByNumber = main_service.getMainByNumber(number);
        String attachmentPATH = TimerParm.fjPath5 + File.separator + mainByNumber.getRjs8().substring(0,mainByNumber.getRjs8().indexOf("."))+ File.separator + URLDecoder.decode(URLDecoder.decode(filename,"UTF-8"),"UTF-8");
        FileUtil.del(attachmentPATH);
        //维护数据库信息
        String newsfjian = "";
        String[] attachments = mainByNumber.getFjian().split("\\|");
        for (String attachment : attachments) {
            if (attachment.equals(URLDecoder.decode(URLDecoder.decode(filename,"UTF-8"),"UTF-8"))){
                continue;
            }
            newsfjian+=attachment+"|";
        }

        MainWithBLOBs main = new MainWithBLOBs();
        main.setFjian(newsfjian.substring(0,newsfjian.length()-1));
        main.setNumber(mainByNumber.getNumber());





        return main_service.update(main);

    }
    //修改
    @RequestMapping("update")

    public void update(InformationPipelineWithBLOBs information, HttpServletResponse response,Model model) throws IOException {
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);

        //为了获取正文不得不通过  informationPipeline 转换一下

        MainWithBLOBs main = new MainWithBLOBs(Long.parseLong(information.getExtend2()),information.getNewstitle(),information.getDeptcode(),information.getReleasetime(),information.getImptime(),information.getDeptname(),information.getFilenum());
        if (main_service.update(main)){
            //正文按照页面上 的数据写回到txt中
            String contextPath = TimerParm.txtPath5 + File.separator + information.getExtend3() + File.separator +information.getFilename();
            FileUtil.writeString(information.getNewscontent(),contextPath,"GBK");
            //正文按照页面上 的数据写回到 hting/txt中(兼容旧法规工具)
            String contextCopyPath = TimerParm.txtCopyPath5 + File.separator +information.getFilename();
            FileUtil.writeString(information.getNewscontent(),contextCopyPath,"GBK");

            response.sendRedirect("detail/"+information.getExtend2());

        }

    }

    //附件下载
    @RequestMapping("downLoadAttachment/{id}/{fjName}")
    @ResponseBody
    public String downLoadAttachment(@PathVariable("id")long id,@PathVariable("fjName")String fjName, HttpServletRequest request, HttpServletResponse response){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        MainWithBLOBs mainByNumber = main_service.getMainByNumber(id);


        String attachmentPATH = TimerParm.fjPath5 + File.separator + mainByNumber.getRjs8().substring(0,mainByNumber.getRjs8().indexOf("."));

        String[] split = mainByNumber.getFjian().split("\\|");

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

    //返回附件下载地址
    @RequestMapping("downloadFJ")
    @ResponseBody
    public String downloadFJ(@RequestParam(value = "id")long id,HttpServletRequest request){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        MainWithBLOBs mainByNumber = main_service.getMainByNumber(id);

        StringBuilder resu = new StringBuilder();
        //link
        String link = TimerParm.fjPath5 + File.separator + mainByNumber.getRjs8().substring(0,mainByNumber.getRjs8().indexOf("."));
        //name
        String fjian = mainByNumber.getFjian();
        String[] split = fjian.split("\\|");
        int count = 0;
        for (String fjName:split
                ) {
            resu.append("<p><a id=\"fjian"+count+"\" href=\"javascript:void(0);\" onclick=\"downLoadAttachment('"+id+"','"+count+"')\">"+fjName+"</a></p>");
            count++;
        }

        return resu.toString();


    }
    //人工审查的新闻可以从 tmp临时库  导入到  chl正式库
    @RequestMapping("output")
    @ResponseBody
    public String output(@RequestParam("ids")String ids,HttpServletRequest request){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        String[] id = ids.trim().split(" ");
        //获取地方库新闻数据
        List<MainWithBLOBs> tmpMainList = main_service.getMainByNumbers(id);

        //导出到chl
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);

        boolean flag = true;
        for (MainWithBLOBs mainWithBLOBs : tmpMainList) {
            if (intoCHL(mainWithBLOBs,request)) {
                String[] numbers = {mainWithBLOBs.getNumber() + ""};
                DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
                DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
                flag = main_service.deleteByNumbers(numbers);
            }else {
                flag = false;
            }
        }

        return flag == true?"导出成功":"导出失败";
    }
    //详情
    @RequestMapping("detail/{number}")
    public String detail(@PathVariable(value = "number")String number,Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);

        //获取地方库新闻数据
        MainWithBLOBs main = main_service.getMainByNumber(Long.parseLong(number));
        String content = readTxt(main.getAppuser(),main.getRjs8());


//-------------------------------------------------------------------------------------attachment
        //附件集合返回对象

        ArrayList<HashMap> attachmentList = new ArrayList<HashMap>();


        //获取附件信息

        String attachmentPath = TimerParm.fjPath5+File.separator+(main.getRjs8().substring(0,main.getRjs8().indexOf(".")));

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

        return "informationTmpManCheckDetail";
    }

    private String readTxt(String appuser,String filename) {
        String contextPath = TimerParm.txtPath5 + File.separator + appuser + File.separator +filename;
        try {
            String resu = FileUtil.readString(contextPath,"GBK");
            return resu;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }

    }

    //展示随机二十五篇新闻 中央
    @RequestMapping("randomTwentyFive")
    public String randomTwentyFive(@RequestParam(value = "informationIds")String informationIds, Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);

        //获取中央库新闻数据
        List<MainWithBLOBs> mainList = main_service.getRandomListByAppuser("zyzd");

        for (MainWithBLOBs mainWithBLOBs : mainList) {
            mainWithBLOBs.setContentSize(readTxt(mainWithBLOBs.getAppuser(),mainWithBLOBs.getRjs8()).length());
        }

        mainList = priorityRex(mainList,informationIds);



        for (MainWithBLOBs mainWithBLOBs : mainList) {
            if (StringUtils.isNotBlank(mainWithBLOBs.getFjian())) {
                String[] fj = mainWithBLOBs.getFjian().split("\\|");
                mainWithBLOBs.setFj_count(fj.length);
            }else {
                mainWithBLOBs.setFj_count(0);
            }
        }
        model.addAttribute("mainList",mainList);

        return "informationTmpManCheckRandomList";
    }



    //展示随机二十五篇新闻 地方
    @RequestMapping("randomTwentyFive_lar")
    public String randomTwentyFive_lar(@RequestParam(value = "informationIds")String informationIds,Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);

        //获取地方库新闻数据
        List<MainWithBLOBs> mainList = main_service.getRandomListByAppuser("dfzd");

        for (MainWithBLOBs mainWithBLOBs : mainList) {
            mainWithBLOBs.setContentSize(readTxt(mainWithBLOBs.getAppuser(),mainWithBLOBs.getRjs8()).length());
        }

        mainList = priorityRex(mainList,informationIds);



        for (MainWithBLOBs mainWithBLOBs : mainList) {
            if (StringUtils.isNotBlank(mainWithBLOBs.getFjian())) {
                String[] fj = mainWithBLOBs.getFjian().split("\\|");
                mainWithBLOBs.setFj_count(fj.length);
            }else {
                mainWithBLOBs.setFj_count(0);
            }
        }
        model.addAttribute("mainList",mainList);


        return "informationTmpManCheckRandomList_lar";
    }
    //删除
    @RequestMapping("delete")
    @ResponseBody
    public boolean delete(@RequestParam("ids")String ids){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);

        String[] id = ids.trim().split(" ");

        if(main_service.deleteByNumbers(id)){

            return true;
        }else {

            return false;
        }

    }

    //展示所有 zyzd
    @RequestMapping("list")
    public String getInformationPipelineList(HttpServletRequest request,Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);

        //获取地方库新闻数据
        List<MainWithBLOBs> mainList = main_service.getListByAppuser("zyzd");
        for (MainWithBLOBs mainWithBLOBs : mainList) {
            if (StringUtils.isNotBlank(mainWithBLOBs.getFjian())) {
                String[] fj = mainWithBLOBs.getFjian().split("\\|");
                mainWithBLOBs.setFj_count(fj.length);
            }else {
                mainWithBLOBs.setFj_count(0);
            }
        }


        model.addAttribute("mainList",mainList);

        return "informationTmpManCheckList";
    }


    //展示所有 dfzd
    @RequestMapping("list_lar")
    public String getInformationPipelineListlar(HttpServletRequest request,Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);

        //获取地方库新闻数据
        List<MainWithBLOBs> mainList = main_service.getListByAppuser("dfzd");
        for (MainWithBLOBs mainWithBLOBs : mainList) {
            if (StringUtils.isNotBlank(mainWithBLOBs.getFjian())) {
                String[] fj = mainWithBLOBs.getFjian().split("\\|");
                mainWithBLOBs.setFj_count(fj.length);
            }else {
                mainWithBLOBs.setFj_count(0);
            }
        }
        model.addAttribute("mainList",mainList);

        return "informationTmpManCheckList_lar";
    }


    public boolean intoCHL(MainWithBLOBs tmpmain,HttpServletRequest request){
        //--------------------------------------------------------------------------参数


        DecimalFormat df = new DecimalFormat("000");

        //文件移动工具
        NioFileUtil fileUtil = new NioFileUtil();


        String txtPath = tmpmain.getRjs8();
        String dirPath = txtPath.substring(0,txtPath.indexOf("."));// E:\\target\\tmptxt\\zyzd005s074
        String oldFileName = tmpmain.getRjs8();

        String chlFileNamePrefix = tmpmain.getAppuser().equals("zyzd")?"chl":"lar";


        Map<String, Integer> maxRjs8 = getMaxRjs8ForMain(chlFileNamePrefix);//统一导出到aaa 账户
        int beginNum = maxRjs8.get("beginNum");
        int endNum = maxRjs8.get("endNum");
        if(endNum<999) {
            endNum++;
        }else {
            beginNum++;
            endNum=1;
        }

        String dirname = df.format(beginNum);

        String chlFileName = chlFileNamePrefix+df.format(beginNum)+"s"+df.format(endNum)+".txt";
        String chlFileDir = chlFileNamePrefix+df.format(beginNum)+"s"+df.format(endNum);

        Main_CHLandLAR main = new Main_CHLandLAR();
        main.setRjs0(tmpmain.getRjs0());
        main.setRjs4(tmpmain.getRjs4());
        main.setRjs5(tmpmain.getRjs5());
        main.setRjs6(tmpmain.getRjs6());
        main.setRjs7(tmpmain.getRjs7());
        main.setRjs8(chlFileNamePrefix+df.format(beginNum)+"s"+df.format(endNum)+".txt"); //filename 保存文件的文件名
        main.setRjs9((short)1);
        main.setRjs10(tmpmain.getRjs10());
        main.setRjs12(tmpmain.getRjs12());
        main.setAppuser(tmpmain.getAppuser());
        main.setLinksource(tmpmain.getLinksource());
        main.setFjian(tmpmain.getFjian()); //附件名

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        main.setUpdatetime(Integer.parseInt(simpleDateFormat.format(new Date())));//当前日期
        main.setAppdate(new Date());

        main.setRjs1(tmpmain.getRjs1());
        main.setKword(tmpmain.getKword());
        main.setLawlevel(5);
        main.setTruetag(1);
        mainCHLandLAR_service.insert(main);


        try {

            //先重命名文件夹
            NioFileUtil.reNameFile(TimerParm.fjPath5 + File.separator + dirPath, chlFileDir);//zyzd001s001 == > zyzd

            //附件文件夹移动到。5挂载文件夹下
            Path start = Paths.get(TimerParm.fjPath5 + File.separator + chlFileDir);
            Path target = Paths.get(TimerParm.fjPath5_chl+ File.separator +chlFileNamePrefix);
            //移动附件之前先判断目标地址中是否存在重名文件夹 如果存在则先删除掉目标文件夹
            NioFileUtil.deleteIfExists(Paths.get(TimerParm.fjPath5_chl + File.separator + chlFileNamePrefix + File.separator +chlFileDir));
            //在移动
            fileUtil.operateDir(true, start, target, StandardCopyOption.REPLACE_EXISTING);


            //txt移动到  正式 文件夹下
            //重命名文件

            NioFileUtil.reNameFile(TimerParm.txtPath5 + File.separator + tmpmain.getAppuser() + File.separator +oldFileName, chlFileName);

            File start1 = new File(TimerParm.txtPath5 + File.separator + tmpmain.getAppuser() + File.separator +chlFileName);
            File target2 = new File(TimerParm.txt_chlPath+ File.separator + chlFileNamePrefix+File.separator +dirname);
            //移动之前先判断目标地址中是否存在重名文件 如果存在则先删除掉目标文件
            NioFileUtil.deleteIfExists(Paths.get(TimerParm.txt_chlPath + File.separator + chlFileNamePrefix + File.separator +dirname+File.separator +chlFileName));

            //生成文件夹
            File chlTxtDir = new File(TimerParm.txt_chlPath + File.separator + chlFileNamePrefix + File.separator +dirname);
            if (!chlTxtDir.exists()){
                chlTxtDir.mkdir();
            }
            //移动
            FileUtil.move(start1,target2,true);


            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //查询已导出的法规数据txt文件的最大值 main表
    public Map<String,Integer> getMaxRjs8ForMain(String username) {
        Map<String,Integer> resu = new HashMap<String,Integer>();

        String rjs8 = main_service.getMaxRjs8(username);
        //String rjs8 = informationPipeline_service.getMaxRjs8(username);
        int beginNum = 1;
        int endNum = 0;
        if (rjs8!=null) {
            String maxTxtName = rjs8;
            if (maxTxtName != null) {
                maxTxtName = maxTxtName.replaceAll(username, "");
                maxTxtName = maxTxtName.replaceAll(".txt", "");
                if (maxTxtName.matches("\\d{3}s\\d{3}")) {
                    String[] arr = maxTxtName.split("s");
                    int tempNum = Integer.valueOf(arr[0] + arr[1]);
                    beginNum = tempNum / 1000;
                    endNum = tempNum % 1000;
                }
            }
        }
        resu.put("beginNum",beginNum);
        resu.put("endNum",endNum);
        return resu;
    }

    private List<MainWithBLOBs> priorityRex(List<MainWithBLOBs> mainList,String informationIds) {

        //选中得新闻
        String[] _informationIds = {};
        if (StringUtils.isNotBlank(informationIds)) {
            _informationIds = informationIds.split(" ");
        }
        //初始化得分


        String[] deptCodes = {"/1","/2","/3", "/6", "/7"};
        for (MainWithBLOBs mainWithBLOB : mainList) {
            int score = 0;
            //1、优先抽查以下部门代码/1 /2 /3 /6 /7 ;
            for (String deptCode : deptCodes) {
                if (mainWithBLOB.getRjs4().equals(deptCode)){
                    score += 1;
                }
            }
            //2、没有附件的数据。

            if (mainWithBLOB.getFjian()==null){
                score += 1;
            }

            //3、优先抽查文字小于100个

            if (mainWithBLOB.getContentSize()<100){
                score += 1;
            }
            //4、步骤一页面 选中得新闻
            for (String number : _informationIds) {
                if (mainWithBLOB.getNumber().equals(Long.parseLong(number))){
                    score += 1;
                }
            }
            mainWithBLOB.setCompare_score(score);
        }

        Collections.sort(mainList, Main.MAIN_BY_SCORE);

        return mainList;


    }

}