package com.spider.controller;

import com.ifeng.auto.we_provider.common.db.DynamicDataSource;
import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.*;
import com.spider.elemente.TimerParm;
import com.spider.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class InformationPipeline_controller {
    @Autowired
    private TXwInformation_service information_service;

    @Autowired
    private InformationPipeline_service informationPipelineService;

    @Autowired
    private TXwWebsite_service website_service;

    @Autowired
    private ErrorLog_service errorLog_service;

    @Autowired
    private UserTask_service userTask_service;


        //查询temp数据库得到js处理后的新闻数据 已导出
    @RequestMapping("/outOverInformationDetail/{id}/{flag}")
    public String getOutOverInformationDetail(@PathVariable(value = "id")int id,@PathVariable(value = "flag")int xwcolumn, Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        UserTask user = (UserTask) session.getAttribute("user");
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);//切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
        //返回imformationPipeline
        InformationPipeline informationPipeline = informationPipelineService.findInformationPipelineById(id,xwcolumn);
        model.addAttribute("informationPipeline",informationPipeline);

        //获取websiteid
        String websiteids = userTask_service.getUserTaskWebsiteids(user.getName());
        int lastid = informationPipelineService.getOutOverLastInformationId(id,xwcolumn,websiteids,user.getLevel());
        int nextid = informationPipelineService.getOutOverNextInformationId(id,xwcolumn,websiteids,user.getLevel());
        model.addAttribute("lastid",lastid);
        model.addAttribute("nextid",nextid);
        //切换会主数据源
        DynamicDataSourceHolder.clearCustomerType();
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        return "spiderInformationOutOverDetail";
    }
    //已导入
    @RequestMapping("outPutOver/{xwColumn}")
    public String outPutOverList(@PathVariable("xwColumn")int xwColumn,HttpServletRequest request,Model model){

        HttpSession session = request.getSession();
        UserTask user =(UserTask) session.getAttribute("user");
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);


        String userTaskWebsiteids = userTask_service.getUserTaskWebsiteids(user.getName());
        List<InformationPipeline> informationPipelineList = informationPipelineService.getOutPutOverInformationPipelineList(xwColumn,userTaskWebsiteids,user.getLevel());
        //添加列表页
/*        for (InformationPipeline informationPipeline:informationPipelineList
                ) {
            //通过informationid获取website的source
            TXwInformationWithBLOBs information = information_service.getInformation(informationPipeline.getInformationId());
            TXwWebsite website = website_service.findWebsiteByid(information.getWebsiteid());
            String websiteaddress = "";
            if (website!=null){
                websiteaddress = website.getWebsiteaddress();
            }

            informationPipeline.setWebsiteAddress(websiteaddress);

            //判断是否含有错误日志
            //切换会主数据源
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
            List<TblErrorLog> errorLogListByInformationID = errorLog_service.getErrorLogListByInformationID(informationPipeline.getInformationId());
            //切换会主数据源
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
            if (errorLogListByInformationID==null||errorLogListByInformationID.size()==0){
                informationPipeline.setIsErrorStatus(0);
            }else {
                informationPipeline.setIsErrorStatus(1);
            }
            //附件个数
            String fjian = informationPipeline.getFjian();
            if (fjian!=null&&!"".equals(fjian)){
                informationPipeline.setFjcount(fjian.split("\\|").length);
            }else {
                informationPipeline.setFjcount(0);
            }
        }*/
        for (InformationPipeline informationPipeline:informationPipelineList
                ) {
            List<TblErrorLog> errorLogList = errorLog_service.getErrorLogListByInformationID(informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn()));
            int status = informationPipeline.getPreDistinct();
            if (status == 1){//正式库重复
                for (TblErrorLog error:errorLogList
                        ) {
                    if (error.getErrorcode()==1007){
                        if (error.getErrordetails().indexOf("like")>-1){
                            informationPipeline.setPreDistinct(12);
                        }else {
                            informationPipeline.setPreDistinct(11);
                        }
                    }
                }

            }else if (status == 2){//抓取库重复
                for (TblErrorLog error:errorLogList
                        ) {
                    if (error.getErrorcode()==1007){
                        if (error.getErrordetails().indexOf("like")>-1){
                            informationPipeline.setPreDistinct(14);
                        }else {
                            informationPipeline.setPreDistinct(13);
                        }
                    }
                }
            }
        }
        model.addAttribute("informationList",informationPipelineList);


        if (xwColumn==100002){
            return "informationPipelineOutPutOver_chl";
        }else {
            return "informationPipelineOutPutOver_lar";
        }
        //return "informationPipelineList";
    }

    //附件下载
    @RequestMapping("downLoadAttachment/{id}/{fjName}")
    @ResponseBody
    public String downLoadAttachment(@PathVariable("id")int id,@PathVariable("fjName")String fjName, HttpServletRequest request, HttpServletResponse response){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        InformationPipelineWithBLOBs information = informationPipelineService.findInformationPipelineByID(id);
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);

        String attachmentPATH = request.getRealPath(TimerParm.attachmentPATH);
        attachmentPATH = attachmentPATH+File.separator+information.getFilename().substring(0,information.getFilename().indexOf("."));

        String[] split = information.getFjian().split("\\|");

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
    public String downloadFJ(@RequestParam(value = "id")int id,HttpServletRequest request){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        InformationPipelineWithBLOBs information = informationPipelineService.findInformationPipelineByID(id);
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        StringBuilder resu = new StringBuilder();
        //link
        String link = TimerParm.attachmentPATH+ File.separator+information.getFilename().substring(0,information.getFilename().indexOf("."));
        //name
        String fjian = information.getFjian();
        String[] split = fjian.split("\\|");
        int count = 0;
        for (String fjName:split
             ) {
            resu.append("<p><a id=\"fjian"+count+"\" href=\"javascript:void(0);\" onclick=\"downLoadAttachment("+id+","+count+")\">"+fjName+"</a></p>");
            count++;
        }

        return resu.toString();


    }

    //获取数据清洗过程中的错误日志
    @RequestMapping("findErrorLog1007")
    @ResponseBody
    public String findErrorLog1007(@RequestParam(value = "informationid")int informationid,@RequestParam(value = "column")int column){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        List<TblErrorLog> errorLogListByInformationID = errorLog_service.getErrorLogListByInformationID(informationid,column);
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        StringBuilder resu = new StringBuilder();
        if (errorLogListByInformationID.size()>0) {
            for (TblErrorLog errorlog : errorLogListByInformationID
                    ) {
                if (errorlog.getErrorcode()==1008) {
                    resu.append(errorlog.getErrordetails() + "\r\n");
                }
            }
        }
        return resu.toString();
    }

    //获取数据清洗过程中的错误日志
    @RequestMapping("findErrorLog")
    @ResponseBody
    public String findErrorLog(@RequestParam(value = "informationid")int informationid,@RequestParam(value = "column")int column){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        List<TblErrorLog> errorLogListByInformationID = errorLog_service.getErrorLogListByInformationID(informationid,column);
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        StringBuilder resu = new StringBuilder();
        if (errorLogListByInformationID.size()>0) {
            for (TblErrorLog errorlog : errorLogListByInformationID
                    ) {
                resu.append(errorlog.getErrordetails() + "\r\n");
            }
        }
        return resu.toString();
    }
    //展示50条处理后的新闻  地方
    @RequestMapping("/informationPipelinelar")
    public String getInformationPipelineListlar(HttpServletRequest request,Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);

        HttpSession session = request.getSession();
        UserTask user = (UserTask) session.getAttribute("user");
        //中央 or 地方
        session.setAttribute("xwcolumn",100003);
        String userTaskWebsiteids = userTask_service.getUserTaskWebsiteids(user.getName());
        List<InformationPipeline> informationPipelineList = informationPipelineService.findInformationPipelineListLar(user.getLevel(),userTaskWebsiteids);


        //添加列表页
/*        for (InformationPipeline informationPipeline:informationPipelineList
                ) {
            //通过informationid获取website的source
            TXwInformationWithBLOBs information = information_service.getInformation(informationPipeline.getInformationId());
            TXwWebsite website = website_service.findWebsiteByid(information.getWebsiteid());
            String websiteaddress = "";
            if (website!=null){
                websiteaddress = website.getWebsiteaddress();
            }

            informationPipeline.setWebsiteAddress(websiteaddress);

            //判断是否含有错误日志
            //切换会主数据源
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
            List<TblErrorLog> errorLogListByInformationID = errorLog_service.getErrorLogListByInformationID(informationPipeline.getInformationId());
            //切换会主数据源
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
            if (errorLogListByInformationID==null||errorLogListByInformationID.size()==0){
                informationPipeline.setIsErrorStatus(0);
            }else {
                informationPipeline.setIsErrorStatus(1);
            }
            //附件个数
            String fjian = informationPipeline.getFjian();
            if (fjian!=null&&!"".equals(fjian)){
                informationPipeline.setFjcount(fjian.split("\\|").length);
            }else {
                informationPipeline.setFjcount(0);
            }
        }*/
        for (InformationPipeline informationPipeline:informationPipelineList
                ) {
            List<TblErrorLog> errorLogList = errorLog_service.getErrorLogListByInformationID(informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn()));
            int status = informationPipeline.getPreDistinct();
            if (status == 1){//正式库重复
                for (TblErrorLog error:errorLogList
                        ) {
                    if (error.getErrorcode()==1007){
                        if (error.getErrordetails().indexOf("like")>-1){
                            informationPipeline.setPreDistinct(12);
                        }else {
                            informationPipeline.setPreDistinct(11);
                        }
                    }
                }

            }else if (status == 2){//抓取库重复
                for (TblErrorLog error:errorLogList
                        ) {
                    if (error.getErrorcode()==1007){
                        if (error.getErrordetails().indexOf("like")>-1){
                            informationPipeline.setPreDistinct(14);
                        }else {
                            informationPipeline.setPreDistinct(13);
                        }
                    }
                }
            }
        }
        model.addAttribute("informationList",informationPipelineList);



        return "informationPipelineListlar";
    }


    //展示50条处理后的新闻  中央
    @RequestMapping("/informationPipeline")
    public String getInformationPipelineList(HttpServletRequest request,Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);

        HttpSession session = request.getSession();
        UserTask user = (UserTask) session.getAttribute("user");
        //中央 or 地方
        session.setAttribute("xwcolumn",100002);
        String userTaskWebsiteids = userTask_service.getUserTaskWebsiteids(user.getName());
        List<InformationPipeline> informationPipelineList = informationPipelineService.findInformationPipelineList(user.getLevel(),userTaskWebsiteids);
        //添加列表页
/*        for (InformationPipeline informationPipeline:informationPipelineList
                ) {
            //通过informationid获取website的source
            TXwInformationWithBLOBs information = information_service.getInformation(informationPipeline.getInformationId());
            TXwWebsite website = website_service.findWebsiteByid(information.getWebsiteid());
            String websiteaddress = "";
            if (website!=null){
                websiteaddress = website.getWebsiteaddress();
            }

            informationPipeline.setWebsiteAddress(websiteaddress);

            //判断是否含有错误日志
            //切换会主数据源
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
            List<TblErrorLog> errorLogListByInformationID = errorLog_service.getErrorLogListByInformationID(informationPipeline.getInformationId());
            //切换会主数据源
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
            if (errorLogListByInformationID==null||errorLogListByInformationID.size()==0){
                informationPipeline.setIsErrorStatus(0);
            }else {
                informationPipeline.setIsErrorStatus(1);
            }
            //附件个数
            String fjian = informationPipeline.getFjian();
            if (fjian!=null&&!"".equals(fjian)){
                informationPipeline.setFjcount(fjian.split("\\|").length);
            }else {
                informationPipeline.setFjcount(0);
            }
        }*/
        for (InformationPipeline informationPipeline:informationPipelineList
             ) {
            List<TblErrorLog> errorLogList = errorLog_service.getErrorLogListByInformationID(informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn()));
            int status = informationPipeline.getPreDistinct();
            if (status == 1){//正式库重复
                for (TblErrorLog error:errorLogList
                     ) {
                    if (error.getErrorcode()==1007){
                        if (error.getErrordetails().indexOf("like")>-1){
                            informationPipeline.setPreDistinct(12);
                        }else {
                            informationPipeline.setPreDistinct(11);
                        }
                    }
                }

            }else if (status == 2){//抓取库重复
                for (TblErrorLog error:errorLogList
                        ) {
                    if (error.getErrorcode()==1007){
                        if (error.getErrordetails().indexOf("like")>-1){
                            informationPipeline.setPreDistinct(14);
                        }else {
                            informationPipeline.setPreDistinct(13);
                        }
                    }
                }
            }
        }
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        for (InformationPipeline informationPipeline:informationPipelineList
                ) {

            informationPipeline.setPersonincharge(website_service.getPersonChargeByID(informationPipeline.getImptime()));
        }
        model.addAttribute("informationList",informationPipelineList);



        return "informationPipelineList";
    }
    //查询temp数据库得到js处理后的新闻数据
    @RequestMapping("/informationDetail/{id}/{flag}")
    public String getinformationDetail(@PathVariable(value = "id")int id,@PathVariable(value = "flag")int xwcolumn, Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        UserTask user = (UserTask) session.getAttribute("user");
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);//切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
        //返回imformationPipeline
        InformationPipeline informationPipeline = informationPipelineService.findInformationPipelineById(id,xwcolumn);
        model.addAttribute("informationPipeline",informationPipeline);

        //获取websiteid
        String websiteids = userTask_service.getUserTaskWebsiteids(user.getName());
        int lastid = informationPipelineService.getLastInformationId(id,websiteids,user.getLevel(),xwcolumn);
        int nextid = informationPipelineService.getNextInformationId(id,websiteids,user.getLevel(),xwcolumn);
        model.addAttribute("lastid",lastid);
        model.addAttribute("nextid",nextid);
        //切换会主数据源
        DynamicDataSourceHolder.clearCustomerType();
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        return "spiderInformationDetail";
    }
}
