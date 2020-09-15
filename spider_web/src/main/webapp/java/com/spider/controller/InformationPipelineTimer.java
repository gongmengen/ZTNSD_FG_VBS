package com.spider.controller;


import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.lawstar.basic.util.Tools;
import com.spider.elemente.JavaScript_static;
import com.spider.exception.OverOutputExistException;
import com.spider.utils.HttpsUtils;
import com.spider.bean.*;
import com.spider.elemente.ErrorPram;
import com.spider.elemente.TimerParm;
import com.spider.service.*;
import com.spider.utils.DistinctMainPramUtil;
import com.spider.utils.NioFileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

//法规抓取新闻预处理
@Controller
public class InformationPipelineTimer {
    @Autowired
    private TXwInformation_service information_service;
    @Autowired
    private TWxAdapter_service adapter_service;
    @Autowired
    private InformationPipeline_service informationPipeline_service;
    @Autowired
    private Main_service main_service;
    @Autowired
    private MainCHLandLAR_service mainCHLandLAR_service;
    @Autowired
    private ErrorLog_service errorLog_service;
    @Autowired
    private TXwWebsite_service website_service;
    @RequestMapping("basicTimer")
    @ResponseBody
    public synchronized String  basicTimer(HttpServletRequest request) {

//--------------------------------------------------------------------------参数
        //导出txt
        String username = TimerParm.username;// 由配置文件中读取
        DecimalFormat df = new DecimalFormat("000");
        String destDir = request.getRealPath(TimerParm.destDir);
        String copyDir = request.getRealPath(TimerParm.copyDir);

        //保存附件
        String attachmentPATH = request.getRealPath(TimerParm.attachmentPATH);
        Map downLoadResult = null;

        List<InformationPipelineWithBLOBs> informationPipelineList = new ArrayList<InformationPipelineWithBLOBs>();

//--------------------------------------------------------------------------获取待处理新闻
        List<TXwInformationWithBLOBs> informationList = new ArrayList<TXwInformationWithBLOBs>();
        //获取法规新闻 中央（ 10篇 ）
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        informationList = information_service.getTenTXwInformationPipelineIsZero();

        //获取法规新闻 地方（ 10篇 ）
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        List<TXwInformationWithBLOBs> informationListlar = information_service.getTenTXwInformationPipelineIsZero();
        //合并集合
        informationList.addAll(informationListlar);
        if (informationList.size()==0){

            return "没有需要处理的数据";
        }
        //修改本次清洗数据的状态为 已清洗
        try {
            for (TXwInformationWithBLOBs information:informationList
                    ) {
                if (information.getXwcolumn()==100002){
                    //切换会主数据源 中央
                    DynamicDataSourceHolder.clearCustomerType();
                    DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
                    information_service.updatePipelineStatusForOne(information);
                }else if (information.getXwcolumn()==100003) {
                    //切换主数据源 地方
                    DynamicDataSourceHolder.clearCustomerType();
                    DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
                    information_service.updatePipelineStatusForOne(information);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
//--------------------------------------------------------------------------开始处理数据
        //执行js
        for (TXwInformationWithBLOBs information:informationList
             ) {

            //返回informationPipeline
            if(information.getXwcolumn()==100002){
                DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
                DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
            }else if (information.getXwcolumn()==100003){
                DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
                DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
            }
            Map map = adapter_service.getInformationPipelineRegJs(information, request);

            InformationPipelineWithBLOBs informationPipeline = (InformationPipelineWithBLOBs)map.get("result");
            informationPipelineList.add(informationPipeline);
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
            errorLog_service.insert((List<TblErrorLog>) map.get("errorlogs"));
        }
//-------------------------------------------------------
        //生成txt、附件 切换到。6 tmp
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        for (InformationPipelineWithBLOBs informationPipeline:informationPipelineList){
            ///---------------------------

            //获取filename
            Map<String, Integer> maxRjs8 = getMaxRjs8ForInformationPipeline(username);
            int beginNum = maxRjs8.get("beginNum");
            int endNum = maxRjs8.get("endNum");
            if(endNum<999) {
                endNum++;
            }else {
                beginNum++;
                endNum=1;
            }
            String fileName = username+df.format(beginNum)+"s"+df.format(endNum)+".txt";
//            写出txt文件
            writeTxt(destDir+File.separator+username+df.format(beginNum)+"s"+df.format(endNum),copyDir,fileName,informationPipeline.getNewscontent()==null?"":informationPipeline.getNewscontent());
            String localAttachmentPATH = attachmentPATH+File.separator+username+df.format(beginNum)+"s"+df.format(endNum);
//            保存附件
            try {
                downLoadResult = HttpsUtils.saveUrlAs(informationPipeline.getSource(), informationPipeline.getAttachment(), localAttachmentPATH,informationPipeline.getInformationId(),Integer.parseInt(informationPipeline.getXwcolumn()));
                if (downLoadResult!=null&&downLoadResult.get(0).equals("false")){
                    //错误日志
                    if(downLoadResult.get(1)!=null&&!downLoadResult.get(1).equals("")){
                        informationPipeline.setFjian(""+downLoadResult.get(1));
                    }
                    errorLog_service.insert((List<TblErrorLog>) downLoadResult.get(2));
                }else {
                    informationPipeline.setFjian(downLoadResult.get(1)+"");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            informationPipeline.setFilename(fileName);


            //和chl、lar数据库比较判断重复
                if (informationPipeline.getXwcolumn().equals("100002")) {
                    DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
                    DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);//切换到中央
                    isDistinct(informationPipeline);

                } else if (informationPipeline.getXwcolumn().equals("100003")) {
                    DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
                    DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_LAR);//切换到地方
                    isDistinct(informationPipeline);
                }



            DynamicDataSourceHolder.clearCustomerType();//换回tmp
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
            //检查是否有字段超过数据库限制
            checkInformationPipeline(informationPipeline,errorLog_service);

            if (informationPipeline.getXwcolumn().equals("100003")){
                DynamicDataSourceHolder.clearCustomerType();
                DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
            }else if (informationPipeline.getXwcolumn().equals("100002")){
                DynamicDataSourceHolder.clearCustomerType();
                DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
            }

                //通过informationid获取website的source
                TXwInformationWithBLOBs information = information_service.getInformation(informationPipeline.getInformationId());
                TXwWebsite website = website_service.findWebsiteByid(information.getWebsiteid());
                String websiteaddress = "";
                if (website!=null){
                    websiteaddress = website.getWebsiteaddress();
                }

                informationPipeline.setWebsitesource(websiteaddress);


                //切换会主数据源
                DynamicDataSourceHolder.clearCustomerType();
                DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
                //检查是否重复
                informationPipeline_service.checkInformationExist(informationPipeline);


                //判断是否含有错误日志
                List<TblErrorLog> errorLogListByInformationID = errorLog_service.getErrorLogListByInformationID(informationPipeline.getInformationId(),Integer.parseInt(informationPipeline.getXwcolumn()));
                if (errorLogListByInformationID==null||errorLogListByInformationID.size()==0){
                    informationPipeline.setErrorStatus(0);
                }else {
                    informationPipeline.setErrorStatus(1);
                }
                //附件个数
                String fjian = informationPipeline.getFjian();
                if (fjian!=null&&!"".equals(fjian)){
                    informationPipeline.setFjcount(fjian.split("\\|").length);
                }else {
                    informationPipeline.setFjcount(0);
                }



            //存放到tmp数据库
            informationPipeline_service.insertList(informationPipeline);



        }
//---------------------------------------------------


/*        for (InformationPipeline informationPipeline:informationPipelineList
             ) {


        }*/


        //正常执行完 改回open状态
        //TimerParm.TIMER_STATUS = "open";
        return "ok";
    }

    //根据website表 refmain = 2 将预处理信息直接推送到 chl 数据库
    @RequestMapping("basicTimerForCHL")
    @ResponseBody
    public synchronized String  basicTimerForCHL(HttpServletRequest request) {

        //获取information_pipeline 新闻 ref_main = 2
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        List<TXwWebsite> websiteList = website_service.getidsByRefmain2();
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        List<TXwWebsite> websiteList_lar = website_service.getidsByRefmain2();
        websiteList.addAll(websiteList_lar);
        String ids = "";
        for (TXwWebsite website:websiteList
             ) {
            ids+= website.getId()+" ";
        }
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        List<InformationPipelineWithBLOBs> informationPipelineList = informationPipeline_service.getInformationPipelineListWithRefmain2(ids.trim().replaceAll(" ",","));
        //error > 0  则放弃
        if (informationPipelineList.size() > 0){
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);
        for (InformationPipelineWithBLOBs information:informationPipelineList
             ) {
                //入正式库

                intoCHL(information,request);
        }
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        for (InformationPipelineWithBLOBs information:informationPipelineList
             ) {
            //修改导出状态
            InformationPipelineWithBLOBs i = new InformationPipelineWithBLOBs();
            i.setIstatus(1);
            informationPipeline_service.updateIstatus(i,information.getId());
        }
        }else {
            return "没有需要推送到正式库的数据！";
        }

        return "ok";
    }

    //根据website表 refmain = 3 将预处理信息直接推送到 tmp 数据库
    @RequestMapping("basicTimerForTMP")
    @ResponseBody
    public synchronized String  basicTimerForTMP(HttpServletRequest request) {

        //获取information_pipeline 新闻 ref_main = 2
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        List<TXwWebsite> websiteList = website_service.getidsByRefmain3();
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        List<TXwWebsite> websiteList_lar = website_service.getidsByRefmain3();
        websiteList.addAll(websiteList_lar);
        String ids = "";
        for (TXwWebsite website:websiteList
                ) {
            ids+= website.getId()+" ";
        }
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        List<InformationPipelineWithBLOBs> informationPipelineList = informationPipeline_service.getInformationPipelineListWithRefmain3(ids.trim().replaceAll(" ",","));
        //error > 0  则放弃
        if (informationPipelineList.size() > 0){

            for (InformationPipelineWithBLOBs information:informationPipelineList
                    ) {
                //入临时库
                intoTMP(information,request);
            }
            for (InformationPipelineWithBLOBs information:informationPipelineList
                    ) {
                //修改导出状态
                InformationPipelineWithBLOBs i = new InformationPipelineWithBLOBs();
                i.setIstatus(1);
                informationPipeline_service.updateIstatus(i,information.getId());
            }
        }else {
            return "没有需要推送到临时库的数据！";
        }

        return "ok";
    }
    @RequestMapping("openTimer")
    @ResponseBody
    public String openTimer(){
        //修改为 open
        TimerParm.setTimerStatus("open");
        return "定时器已启动";

    }

    @RequestMapping("closeTimer")
    @ResponseBody
    public String closeTimer(){
        //修改为 close
        TimerParm.setTimerStatus("close");
        return "定时器已关闭";
    }

    //导出
    @RequestMapping("output")
    @ResponseBody
    public String output(@RequestParam("ids")String ids,@RequestParam("name")String name,HttpServletRequest request){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        DecimalFormat df = new DecimalFormat("000");
        //获取user

        HttpSession session = request.getSession();
        UserTask user =(UserTask) session.getAttribute("user");

        //main表信息添加状态
        boolean status = true;
        //文件移动状态
        boolean filestatus = false;
        //导出成功条数
        int successcount = 0;
        //导出失败条数
        int defeatedcount = 0;
        //文件移动工具
        NioFileUtil fileUtil = new NioFileUtil();


/*        //导出txt
        String username = "difang";// 由配置文件中读取
        DecimalFormat df = new DecimalFormat("000");
        String destDir = "tmptxt";
        String copyDir = "tmptxt/hting";

        //保存附件
        String fujianDir = "fujian/tmp";
        URI resource = null;
        try {
            resource = this.getClass().getClassLoader().getResource(fujianDir).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        File file = new File(resource);
        String attachmentPATH = file.getAbsolutePath();
        String[] downLoadResult = null;*/



        List<InformationPipelineWithBLOBs> informationPipelineList = informationPipeline_service.getInformationPipelineByIds(ids.trim().split(" "));
        //添加到192.168.0.6/tmp/main表

        //切换会主数据源
/*        DynamicDataSourceHolder.clearCustomerType();
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);*/

        //测试
        for (InformationPipelineWithBLOBs information:informationPipelineList
             ) {


            //---------------



            //---------------







            String txtPath = information.getFilename();
            String dirPath = txtPath.substring(0,txtPath.indexOf("."));
            String oldFileName = information.getFilename();
/*            ///---------------------------
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
            //获取filename
            Map<String, Integer> maxRjs8 = getMaxRjs8(username);
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
            int beginNum = maxRjs8.get("beginNum");
            int endNum = maxRjs8.get("endNum");
            if(endNum<999) {
                endNum++;
            }else {
                beginNum++;
                endNum=1;
            }
            String fileName = username+df.format(beginNum)+"s"+df.format(endNum)+".txt";
//            写出txt文件
            writeTxt(destDir,copyDir,fileName,information.getNewscontent());
//            保存附件
            String localAttachmentPATH = attachmentPATH+"\\"+username+df.format(beginNum)+"s"+df.format(endNum);
            downLoadResult = saveUrlAs(information.getSource(), information.getAttachment(), localAttachmentPATH);
//
//
//            /---------------------------
            information.setFilename(fileName);
            information.setFjian(downLoadResult[1]);*/
//----------------------------------------------------------------------------------------------------------------------
            Map<String, Integer> maxRjs8 = getMaxRjs8ForMain(name);//统一导出到aaa 账户
            int beginNum = maxRjs8.get("beginNum");
            int endNum = maxRjs8.get("endNum");
            if(endNum<999) {
                endNum++;
            }else {
                beginNum++;
                endNum=1;
            }


            //------

            MainWithBLOBs main = new MainWithBLOBs();
            main.setRjs0(information.getNewstitle());
            main.setRjs4(information.getDeptcode());
            main.setRjs5(information.getReleasetime());
            main.setRjs6(information.getExtend1());
            main.setRjs7(information.getXwcolumn().equals("100002")?"chl":"lar");
            main.setRjs8(name+df.format(beginNum)+"s"+df.format(endNum)+".txt"); //filename 保存文件的文件名
            main.setRjs9((short)1);
            main.setRjs10(information.getDeptname());
            main.setRjs12(information.getFilenum());
            main.setAppuser(name);
            main.setLinksource(information.getSource());
            main.setRid((long)information.getInformationId());

            main.setFjian(information.getFjian()!=null?information.getFjian().replaceAll("\\u200b","").replaceAll("\\u200c",""):null); //附件名
            main.setPre_distinct(information.getPreDistinct()); //重复状态

            main.setRjs1(information.getRjs1());
            main.setKword(information.getKeyword());
            main.setLawlevel(5);
            main.setAppdate(new Date());
            main.setRjs14(information.getRjs14());
            main.setRjs15(information.getRjs15());

            try {
                //如果已导出的数据中存在相同的id则放弃导出

                if(informationPipeline_service.checkOverOutPutExistId(information.getInformationId())){
                    throw new OverOutputExistException("该新闻已被导出！    新闻id："+information.getInformationId());
                }
                main_service.insert(main);
                /*                DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
                DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);*/


                //切换会主数据源
/*                DynamicDataSourceHolder.clearCustomerType();
                DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);*/

            }catch (Exception e){
                e.printStackTrace();
                status = false;
            }



            //------

            if (status) {
                //如果成功 添加到回溯表


                try {
                    //先重命名
                    NioFileUtil.reNameFile(request.getRealPath(TimerParm.attachmentPATH) + File.separator + information.getFilename().substring(0, information.getFilename().indexOf(".")), name + df.format(beginNum) + "s" + df.format(endNum));
                    //附件移动到。5挂载文件夹下

                    Path start = Paths.get(request.getRealPath(TimerParm.attachmentPATH) + File.separator + name + df.format(beginNum) + "s" + df.format(endNum));
                    Path target = Paths.get(TimerParm.fjPath5);
                    //移动附件之前先判断目标地址中是否存在重名文件夹 如果存在则先删除掉目标文件夹
                    NioFileUtil.deleteIfExists(Paths.get(TimerParm.fjPath5 + File.separator + name + df.format(beginNum) + "s" + df.format(endNum)));
                    //在移动
                    fileUtil.operateDir(true, start, target, StandardCopyOption.REPLACE_EXISTING);


                    //txt移动到。5挂载文件夹下
                    Path start1 = Paths.get(request.getRealPath(TimerParm.destDir) + File.separator + dirPath);
                    Path target2 = Paths.get(TimerParm.txtPath5);
                    fileUtil.operateDir(true, start1, target2, StandardCopyOption.REPLACE_EXISTING);
                    //先重命名文件
                    String newfileName = name + df.format(beginNum) + "s" + df.format(endNum) + ".txt";
                    NioFileUtil.reNameFile(TimerParm.txtPath5 + File.separator + dirPath + File.separator + oldFileName, newfileName);
                    //再重命名文件夹
                    File f = new File(TimerParm.txtPath5 + File.separator + name);
                    if (f.exists()) {
                        //如果已经存在就做文件位移
                        Path start4 = Paths.get(TimerParm.txtPath5 + File.separator + dirPath + File.separator + newfileName);
                        Path target4 = Paths.get(TimerParm.txtPath5 + File.separator + name + File.separator + newfileName);
                        NioFileUtil.moveFile(start4, target4, StandardCopyOption.REPLACE_EXISTING);
                        NioFileUtil.deleteIfExists(Paths.get(TimerParm.txtPath5 + File.separator + dirPath));
                    } else {
                        //不存在则将移动过来的文件夹重命名
                        NioFileUtil.reNameFile(TimerParm.txtPath5 + File.separator + dirPath, name);
                    }

                    //txtcopy移动到。5挂载文件夹下
                    Path start3 = Paths.get(request.getRealPath(TimerParm.copyDir) + File.separator + information.getFilename());
                    Path target3 = Paths.get(TimerParm.txtCopyPath5 + File.separator + information.getFilename());
                    fileUtil.moveFile(start3, target3, StandardCopyOption.REPLACE_EXISTING);
                    NioFileUtil.reNameFile(TimerParm.txtCopyPath5 + File.separator + oldFileName, name + df.format(beginNum) + "s" + df.format(endNum) + ".txt");

                    filestatus = true;

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else {
                //入main表失败
                defeatedcount++;
                continue;

            }

            if (filestatus) {
                successcount++;
                InformationPipelineWithBLOBs informationPipeline = new InformationPipelineWithBLOBs();
                informationPipeline.setIstatus(1);
                informationPipeline_service.updateIstatus(informationPipeline, information.getId());
            }else {
                defeatedcount++;
            }

            }


            String resultMeg = "导入条数："+ids.trim().split(" ").length+"   成功："+successcount+"   失败："+defeatedcount;

            return resultMeg;

    }

    //删除
    @RequestMapping("deleteAll")
    @ResponseBody
    public String deleteAll(@RequestParam("ids")String ids,HttpServletRequest request){

        //delete information_pipeline表数据
        String[] id = ids.trim().split(" ");
        try {
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
            //删除错误日志
            List<InformationPipelineWithBLOBs> informationPipelineByIds = informationPipeline_service.getInformationPipelineByIds(id);
            for (InformationPipeline nformationPipeline:informationPipelineByIds
                    ) {
                String xwcolumn = nformationPipeline.getXwcolumn();
                errorLog_service.deleteByInformationId(nformationPipeline.getInformationId(),Integer.parseInt(xwcolumn));
            }
            //删除informationpipeline
            informationPipeline_service.deleteAllByIds(id,request);
            return "删除成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "删除失败";
        }


    }

    //调用脚本下载图片 中央
    @RequestMapping("imgDownload")
    @ResponseBody
    public String imgDownload(@RequestParam("ids")String ids,HttpServletRequest request){

        String[] id = ids.trim().split(" ");

        DynamicDataSourceHolder.clearCustomerType();
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        List<InformationPipelineWithBLOBs> informationPipelineByIds = informationPipeline_service.getInformationPipelineByIds(id);


        for (InformationPipelineWithBLOBs informationPipeline:informationPipelineByIds
                ) {
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
            TXwInformationWithBLOBs information = information_service.getInformation(informationPipeline.getInformationId());
            String imgPath = adapter_service.get_IMG_URL_By_Js(informationPipeline.getNewstitle(),informationPipeline.getReleasetime(),informationPipeline.getFilenum(),informationPipeline.getDeptcode(),informationPipeline.getDeptname(),informationPipeline.getXwcolumn().equals("100002")?"chl":"lar",informationPipeline.getAttachment(),information.getNewscontentnotupdate(),informationPipeline.getNewscontent(),informationPipeline.getExtend2(), JavaScript_static.LAWSTARLIB_JS +JavaScript_static.LAWSTAR_IMG);
            //将 附件全部重新下载一遍
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);


            //追加之前判断是否已经存在
            String attachment = "";
            if (StringUtils.isNotBlank(imgPath)){
                String[] img = imgPath.split("##");
                attachment = informationPipeline.getAttachment();
                for (String s : img) {
                    if (attachment.indexOf(s)>-1){
                        break;
                    }else {
                       attachment = attachment+s+"##";
                    }
                }

            }


            InformationPipelineWithBLOBs informationPipeline1 = new InformationPipelineWithBLOBs();
            informationPipeline1.setAttachment(attachment);



            //根据下载地址下载 img
            String localAttachmentPATH = request.getRealPath(TimerParm.attachmentPATH)+File.separator+(informationPipeline.getFilename().substring(0,informationPipeline.getFilename().indexOf(".")));
            //保存附件
            try {
                Map downLoadResult = HttpsUtils.saveUrlAs(informationPipeline.getSource(), informationPipeline1.getAttachment(), localAttachmentPATH, informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn()));
                if (downLoadResult!=null&&downLoadResult.get(0).equals("false")){

                }else {
                    informationPipeline1.setFjian(downLoadResult.get(1)+"");
                    //附件个数
                    String fjian = informationPipeline1.getFjian();
                    if (fjian!=null&&!"".equals(fjian)){
                        informationPipeline1.setFjcount(fjian.split("\\|").length);
                    }else {
                        informationPipeline1.setFjcount(0);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //维护数据库
            informationPipeline_service.updateIstatus(informationPipeline1,informationPipeline.getId());
        }

            return "下载成功";

    }
    //调用脚本下载图片 地方
    @RequestMapping("imgDownload_lar")
    @ResponseBody
    public String imgDownload_lar(@RequestParam("ids")String ids,HttpServletRequest request){

        String[] id = ids.trim().split(" ");

        DynamicDataSourceHolder.clearCustomerType();
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        List<InformationPipelineWithBLOBs> informationPipelineByIds = informationPipeline_service.getInformationPipelineByIds(id);


        for (InformationPipelineWithBLOBs informationPipeline:informationPipelineByIds
                ) {
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
            TXwInformationWithBLOBs information = information_service.getInformation(informationPipeline.getInformationId());
            String imgPath = adapter_service.get_IMG_URL_By_Js(informationPipeline.getNewstitle(),informationPipeline.getReleasetime(),informationPipeline.getFilenum(),informationPipeline.getDeptcode(),informationPipeline.getDeptname(),informationPipeline.getXwcolumn().equals("100002")?"chl":"lar",informationPipeline.getAttachment(),information.getNewscontentnotupdate(),informationPipeline.getNewscontent(),informationPipeline.getExtend2(), JavaScript_static.LAWSTARLIB_JS +JavaScript_static.LAWSTAR_IMG);
            //将 附件全部重新下载一遍
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);


            //追加之前判断是否已经存在
            String attachment = "";
            if (StringUtils.isNotBlank(imgPath)){
                String[] img = imgPath.split("##");
                attachment = informationPipeline.getAttachment();
                for (String s : img) {
                    if (attachment.indexOf(s)>-1){
                        break;
                    }else {
                        attachment = attachment+s+"##";
                    }
                }

            }


            InformationPipelineWithBLOBs informationPipeline1 = new InformationPipelineWithBLOBs();
            informationPipeline1.setAttachment(attachment);



            //根据下载地址下载 img
            String localAttachmentPATH = request.getRealPath(TimerParm.attachmentPATH)+File.separator+(informationPipeline.getFilename().substring(0,informationPipeline.getFilename().indexOf(".")));
            //保存附件
            try {
                Map downLoadResult = HttpsUtils.saveUrlAs(informationPipeline.getSource(), informationPipeline1.getAttachment(), localAttachmentPATH, informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn()));
                if (downLoadResult!=null&&downLoadResult.get(0).equals("false")){

                }else {
                    informationPipeline1.setFjian(downLoadResult.get(1)+"");
                    //附件个数
                    String fjian = informationPipeline1.getFjian();
                    if (fjian!=null&&!"".equals(fjian)){
                        informationPipeline1.setFjcount(fjian.split("\\|").length);
                    }else {
                        informationPipeline1.setFjcount(0);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //维护数据库
            informationPipeline_service.updateIstatus(informationPipeline1,informationPipeline.getId());
        }

        return "下载成功";

    }

    //重置
    @RequestMapping("restart")
    @ResponseBody
    public String restart(@RequestParam("ids")String ids,@RequestParam("xwcolumn")String xwcolumn,HttpServletRequest request){

        //获取informationid
        DynamicDataSourceHolder.clearCustomerType();
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        List<InformationPipelineWithBLOBs> informationPipelineByIds = informationPipeline_service.getInformationPipelineByIds(ids.trim().split(" "));


        //根据所属库 切换数据源
        if (xwcolumn.equals("100003")){
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        }else {
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        }
        //修改information状态为 未处理
        information_service.updatePipelineStatusForZero(informationPipelineByIds);

        //delete information_pipeline表数据
        try {
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
            //删除错误日志
            for (InformationPipeline nformationPipeline:informationPipelineByIds
                    ) {
                String xwcolumn1 = nformationPipeline.getXwcolumn();
                errorLog_service.deleteByInformationId(nformationPipeline.getInformationId(),Integer.parseInt(xwcolumn1));
            }
            //删除informationpipeline
            informationPipeline_service.deleteAllByIds(ids.trim().split(" "),request);
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
            return "重置成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "重置失败";
        }


    }

    //写出txt文件
    public void writeTxt(String destDir,String copyDir,String fileName,String executString){
        //写出txt文件 判断desDir 是否存在不存在则创建
        File f = new File(destDir);
        if (!f.exists()){
            f.mkdir();
        }
        File txt=new File(destDir,fileName);
        if(!txt.exists()){
            try {
                txt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //判断copyDir 是否存在不存在则创建
        File f1 = new File(copyDir);
        if (!f1.exists()){
            f1.mkdir();
        }
        File copytxt=new File(copyDir,fileName);
        if(!copytxt.exists()){
            try {
                copytxt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txt),"GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            writer.write(executString);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter copyWriter = null;
        try {
            copyWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(copytxt),"GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            copyWriter.write(executString);
            copyWriter.flush();
            copyWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    //查询已导出的法规数据txt文件的最大值 informationPipeline表
    public Map<String,Integer> getMaxRjs8ForInformationPipeline(String username) {
        Map<String,Integer> resu = new HashMap<String,Integer>();

        //String rjs8 = main_service.getMaxRjs8(username);
        String rjs8 = informationPipeline_service.getMaxRjs8(username);
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

    public  String[] saveUrlAs(String baseUrl, String url, String localFilePath)

    {
        String regxUrl = "";
        String remoteFileUrl = "";
        String attachListStr = "";
        String fileName = "";
        String[] retArr = new String[2];
        boolean b = false;
        String[] attachArr={""};
        if (url!=null){
             attachArr = url.split("##");
        }
        com.lawstar.law.util.HttpsUtils.delDir(new File(localFilePath));
        Tools.mkDir(localFilePath);

        for (String attachStr : attachArr)
            if (attachStr.trim().length() > 0) {

                //获取下载链接 、 附件名称 链接中自带http/https 直接返回链接，不带http/https的链接 通过原链接和 '//'前半部分拼接得到
                if (attachStr.lastIndexOf("//") != -1) {
                    remoteFileUrl = attachStr.substring(0, attachStr.lastIndexOf("//"));
                    fileName = attachStr.substring(attachStr.lastIndexOf("//") + 2);
                }

                if (fileName.indexOf(".") < 0) {
                    int ext_pos = remoteFileUrl.lastIndexOf(".");
                    if (ext_pos > -1) {
                        fileName = fileName + remoteFileUrl.substring(ext_pos);
                    }
                }
                if (fileName.indexOf("(") != -1) {
                    int ext_pos = fileName.lastIndexOf("(");
                    fileName = fileName.substring(0,ext_pos).trim();

                }

                String baseUrl_tmp = baseUrl.substring(0,baseUrl.lastIndexOf("/")+1);
                if ((remoteFileUrl.length() > 0) && (remoteFileUrl.charAt(0) == '/')) {
                    int first_idx = baseUrl.indexOf("//");
                    first_idx = baseUrl.indexOf("/", first_idx + 2);
                    if (first_idx > -1) {
                        baseUrl_tmp = baseUrl.substring(0, first_idx);
                    }

                }
                if ((remoteFileUrl.length() > 0) && (remoteFileUrl.charAt(0) == '.')) {
                    int first_idx = baseUrl.lastIndexOf("/");
                    int idx = remoteFileUrl.lastIndexOf("/");
                    if (first_idx > -1) {
                        baseUrl_tmp = baseUrl_tmp.substring(0, first_idx);
                    }
                    if (idx > -1) {
                        remoteFileUrl = remoteFileUrl.substring(idx+1);
                    }

                }

                if (regxUrl.equals(remoteFileUrl))
                {
                    if (!remoteFileUrl.contains("http")) {
                        remoteFileUrl = baseUrl_tmp + remoteFileUrl;
                    }
                }
                else {

                    if ("".equals(regxUrl)){
                        remoteFileUrl = baseUrl_tmp + "/" + remoteFileUrl;
                    }else {
                        remoteFileUrl = baseUrl_tmp + "/" + regxUrl;
                    }

                }

                String newFilePath = localFilePath + File.separator + fileName;
                //System.out.println("附件保存地址" + newFilePath);
                int index = remoteFileUrl.lastIndexOf("/");
                String result = remoteFileUrl.substring(0, index + 1);
                String temp = remoteFileUrl.substring(index + 1);
                String encode = null;
                try {
                    encode = URLEncoder.encode(temp, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                //System.out.println(encode);
                encode = encode.replace("%3D", "=");
                encode = encode.replace("%2F", "/");
                encode = encode.replace("+", "%20");
                encode = encode.replace("%26", "&");
                result = result + encode;
                remoteFileUrl = result;

                //System.out.println(result);
                //System.out.println("remoteFileUrl=" + remoteFileUrl);
                try {
                    b = HttpsUtils.executeDownloadFile(null, remoteFileUrl, newFilePath, "UTF-8", true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
/*                if (!b) {
                    Thread.currentThread();
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        b = HttpsUtils.executeDownloadFile(null, remoteFileUrl, newFilePath, "UTF-8", true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
                if (!b) break;
                if (fileName.indexOf(".") < 0) fileName = fileName + com.lawstar.law.util.HttpsUtils.ext;
                if (attachListStr.length() == 0) attachListStr = fileName; else
                    attachListStr = attachListStr + "|" + fileName;
            }
        retArr[0] = b+"";
        retArr[1] = attachListStr;
        return retArr;
    }

    public InformationPipeline checkInformationPipeline(InformationPipeline informationPipeline,ErrorLog_service errorLog_service){
        List<TblErrorLog> errorLogs = new ArrayList<TblErrorLog>();
        //标题
        if (informationPipeline.getNewstitle().length()>255){
            informationPipeline.setNewstitle("");
            errorLogs.add(new TblErrorLog(10013, ErrorPram.getErrorPram().get(10013),informationPipeline.getInformationId(),Integer.parseInt(informationPipeline.getXwcolumn())));
        }
        //发布日期
        if (informationPipeline.getReleasetime()!=null&&informationPipeline.getReleasetime().length()>255){
            informationPipeline.setReleasetime("");
            errorLogs.add(new TblErrorLog(10043, ErrorPram.getErrorPram().get(10043),informationPipeline.getInformationId(),Integer.parseInt(informationPipeline.getXwcolumn())));
        }
        //实施日期
        if (informationPipeline.getImptime().length()>255){
            informationPipeline.setImptime("");
            errorLogs.add(new TblErrorLog(10053, ErrorPram.getErrorPram().get(10053),informationPipeline.getInformationId(),Integer.parseInt(informationPipeline.getXwcolumn())));
        }
        //文号
        if (informationPipeline.getFilenum().length()>80){
            informationPipeline.setFilenum("");
            errorLogs.add(new TblErrorLog(10033, ErrorPram.getErrorPram().get(10033),informationPipeline.getInformationId(),Integer.parseInt(informationPipeline.getXwcolumn())));
        }
/*        //附件名 (变更数据库类型 取消该限制)
        if (informationPipeline.getFjian()!=null&&informationPipeline.getFjian().length()>255){
            informationPipeline.setFjian("");
            errorLogs.add(new TblErrorLog(10063, ErrorPram.getErrorPram().get(10063),informationPipeline.getInformationId(),Integer.parseInt(informationPipeline.getXwcolumn())));
        }*/
        errorLog_service.insert(errorLogs);
        return informationPipeline;
    }

    //判断重复 : 所有的条件condition合并的结果集一旦出现不为null或者size>0的情况则视为重复
    public void isDistinct(InformationPipeline informationPipeline){
        //pram
        DistinctMainPramUtil distinctMainPramUtil = new DistinctMainPramUtil();
        String sqlTitle = distinctMainPramUtil.getSQLTitle(informationPipeline.getNewstitle());
        String[] releaseTime = distinctMainPramUtil.getReleaseTime(informationPipeline.getReleasetime());
        String rjs12 = distinctMainPramUtil.getWenHao(informationPipeline.getFilenum());
        //condition
        List<Main_CHLandLAR> mainListWithRjs0 = new ArrayList<Main_CHLandLAR>();
        List<Main_CHLandLAR> mainListWithRjs12 = new ArrayList<Main_CHLandLAR>();
        List<Main_CHLandLAR> mainListWithRjs0NotLike = new ArrayList<Main_CHLandLAR>();
        List<Main_CHLandLAR> mainListWithRjs12NotLike = new ArrayList<Main_CHLandLAR>();
        //结果集
        List<Main_CHLandLAR> resu = new ArrayList<Main_CHLandLAR>();
        ArrayList<TblErrorLog> tblErrorLogs = new ArrayList<>();
            try {
                a:while (true) {
                    mainListWithRjs0NotLike = mainCHLandLAR_service.getMainListWithRjs0NotLike(getDeptcode(informationPipeline.getDeptcode(),"="),informationPipeline.getNewstitle(), releaseTime[0], releaseTime[1]);
                    if (mainListWithRjs0NotLike.size() > 0){
                        tblErrorLogs.add(new TblErrorLog(1007, ErrorPram.errorPram.get(1007) + "select * from main where RJS5 >= "+releaseTime[0]+" AND  RJS5 <= "+releaseTime[1]+" and RJS0 ='"+informationPipeline.getNewstitle()+"' and (RJS4 = "+getDeptcode(informationPipeline.getDeptcode(),"=")+")", informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn())));
                        break a;
                    }

                    mainListWithRjs0 = mainCHLandLAR_service.getMainListWithRjs0(getDeptcode(informationPipeline.getDeptcode(),"like"),sqlTitle, releaseTime[0], releaseTime[1]);
                    if (mainListWithRjs0.size() > 0) {
                        tblErrorLogs.add(new TblErrorLog(1007, ErrorPram.errorPram.get(1007) + "select * from main where RJS5 >= "+releaseTime[0]+" AND  RJS5 <= "+releaseTime[1]+" and RJS0 "+sqlTitle+" and (RJS4 LIKE "+getDeptcode(informationPipeline.getDeptcode(),"like")+")", informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn())));
                        break a;
                    }
                    if (!"".equals(informationPipeline.getFilenum())) {
                        mainListWithRjs12NotLike = mainCHLandLAR_service.getMainListWithRjs12NotLike(informationPipeline.getFilenum(), getDeptcode(informationPipeline.getDeptcode(),"="), releaseTime[0], releaseTime[1]);
                        if (mainListWithRjs12NotLike.size() > 0){
                            tblErrorLogs.add(new TblErrorLog(1007, ErrorPram.errorPram.get(1007) + " select * from main where  RJS5 >= "+releaseTime[0]+" AND  RJS5 <= "+releaseTime[1]+" and RJS12 = '"+rjs12+"' AND (RJS4 = "+getDeptcode(informationPipeline.getDeptcode(),"=")+")", informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn())));
                            break a;
                        }
                    }
                    if (!"".equals(rjs12)) {
                        mainListWithRjs12 = mainCHLandLAR_service.getMainListWithRjs12(rjs12, getDeptcode(informationPipeline.getDeptcode(),"like"), releaseTime[0], releaseTime[1]);
                        if (mainListWithRjs12.size() > 0){
                            tblErrorLogs.add(new TblErrorLog(1007, ErrorPram.errorPram.get(1007) + " select * from main where  RJS5 >= "+releaseTime[0]+" AND  RJS5 <= "+releaseTime[1]+" and RJS12 like '%"+rjs12+"%' AND (RJS4 like "+getDeptcode(informationPipeline.getDeptcode(),"like")+")", informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn())));
                            break a;
                        }
                    }
                    break a;
                }
            }catch (Exception e){
                System.out.println("判断重复执行异常");
            }
        //合并
        resu.addAll(mainListWithRjs0);
        resu.addAll(mainListWithRjs12);
        resu.addAll(mainListWithRjs0NotLike);
        resu.addAll(mainListWithRjs12NotLike);


            if (resu!=null&&resu.size()>0){
                informationPipeline.setPreDistinct(1);

                //重复数据
                StringBuilder distinctStr = new StringBuilder();
                int count = 1;
                for (Main_CHLandLAR main:resu
                        ) {
                    if (count>10){
                        tblErrorLogs.add(new TblErrorLog(10081,ErrorPram.errorPram.get(10081),informationPipeline.getInformationId(),Integer.parseInt(informationPipeline.getXwcolumn())));
                        break;
                    }
                    distinctStr.append("\r\n标题："+main.getRjs0());
                    distinctStr.append("\r\n部门："+main.getRjs10());
                    distinctStr.append("\r\n部门代码："+main.getRjs4());
                    distinctStr.append("\r\n文号："+main.getRjs12());
                    distinctStr.append("\r\n发布日期："+main.getRjs5());
                    distinctStr.append("\r\n文件名："+main.getRjs8());
                    distinctStr.append("\r\n唯一标识："+main.getRid());

                    count++;
                }
                tblErrorLogs.add(new TblErrorLog(1008,ErrorPram.errorPram.get(1008)+distinctStr,informationPipeline.getInformationId(),Integer.parseInt(informationPipeline.getXwcolumn())));

            }else {
                informationPipeline.setPreDistinct(0);
            }
        //存放到tmp数据库
        DynamicDataSourceHolder.clearCustomerType();//换回tmp
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        errorLog_service.insert(tblErrorLogs);
        }
    public String getDeptcode(String str,String condition){
        String prestr = "";
        if (!condition.equals("=")){//不为直等的查询不需要使用 %
            prestr =  "%";
        }
        String[] deptcodes = str.split("/");
        if (deptcodes.length>2){
            StringBuilder resu = new StringBuilder();
            for (String deptcode:deptcodes
                    ) {
                if ("".equals(deptcode)) {
                    continue;
                }
                resu.append(" or RJS4 "+condition+" '"+prestr+"/"+deptcode+prestr+"' ");
            }
            String sql = resu.toString();
            String delete = " or RJS4 "+condition;
            sql = sql.substring(sql.indexOf(delete)+delete.length()+1);
            return sql;
        }else {
            return "'"+prestr+str+prestr+"'";
        }
    }

    //过滤新闻中不存在error——log 的新闻 直接进入正式库
    public void intoCHL(InformationPipelineWithBLOBs informationPipeline,HttpServletRequest request){
        //--------------------------------------------------------------------------参数
        //导出txt
        String username = informationPipeline.getXwcolumn().equals("100002")?"zyzd":"dfzd";// 中央和地方区分开
        DecimalFormat df = new DecimalFormat("000");

        //文件移动工具
        NioFileUtil fileUtil = new NioFileUtil();
//-------------------------------------------------------
            String txtPath = informationPipeline.getFilename();
            String dirPath = txtPath.substring(0,txtPath.indexOf("."));
            String oldFileName = informationPipeline.getFilename();




            Map<String, Integer> maxRjs8 = getMaxRjs8ForMain(username);//统一导出到aaa 账户
            int beginNum = maxRjs8.get("beginNum");
            int endNum = maxRjs8.get("endNum");
            if(endNum<999) {
                endNum++;
            }else {
                beginNum++;
                endNum=1;
            }

            String dirname = df.format(beginNum);

            Main_CHLandLAR main = new Main_CHLandLAR();
            main.setRjs0(informationPipeline.getNewstitle());
            main.setRjs4(informationPipeline.getDeptcode());
            main.setRjs5(informationPipeline.getReleasetime());
            main.setRjs6(informationPipeline.getExtend1());
            main.setRjs7(informationPipeline.getXwcolumn().equals("100002")?"chl":"lar");
            main.setRjs8(username+df.format(beginNum)+"s"+df.format(endNum)+".txt"); //filename 保存文件的文件名
            main.setRjs9((short)1);
            main.setRjs10(informationPipeline.getDeptname());
            main.setRjs12(informationPipeline.getFilenum());
            main.setAppuser("zyzd");
            main.setLinksource(informationPipeline.getSource());
            main.setFjian(informationPipeline.getFjian()); //附件名

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            main.setUpdatetime(Integer.parseInt(simpleDateFormat.format(new Date())));//当前日期
            main.setAppdate(new Date());

            main.setRjs1(informationPipeline.getRjs1());
            main.setKword(informationPipeline.getKeyword());
            main.setLawlevel(5);
            main.setTruetag(1);
            mainCHLandLAR_service.insert(main);


            try {
                //先重命名
                NioFileUtil.reNameFile(request.getRealPath(TimerParm.attachmentPATH) + File.separator + informationPipeline.getFilename().substring(0, informationPipeline.getFilename().indexOf(".")), username + df.format(beginNum) + "s" + df.format(endNum));
                //附件移动到。5挂载文件夹下

                Path start = Paths.get(request.getRealPath(TimerParm.attachmentPATH) + File.separator + username + df.format(beginNum) + "s" + df.format(endNum));
                Path target = Paths.get(TimerParm.fjPath5);
                //移动附件之前先判断目标地址中是否存在重名文件夹 如果存在则先删除掉目标文件夹
                NioFileUtil.deleteIfExists(Paths.get(TimerParm.fjPath5 + File.separator + username + df.format(beginNum) + "s" + df.format(endNum)));
                //在移动
                fileUtil.operateDir(true, start, target, StandardCopyOption.REPLACE_EXISTING);


                //txt移动到。5挂载文件夹下
                Path start1 = Paths.get(request.getRealPath(TimerParm.destDir) + File.separator + dirPath);
                //Path target2 = Paths.get(TimerParm.txtPath5);


                Path target2 = Paths.get(TimerParm.txt_chlPath);//
                fileUtil.operateDir(true, start1, target2, StandardCopyOption.REPLACE_EXISTING);
                //先重命名文件
                String newfileName = username + df.format(beginNum) + "s" + df.format(endNum) + ".txt";
                NioFileUtil.reNameFile(TimerParm.txt_chlPath + File.separator + dirPath + File.separator + oldFileName, newfileName);
                //再重命名文件夹
                File f = new File(TimerParm.txt_chlPath + File.separator+dirname);
                if (f.exists()) {
                    //如果已经存在就做文件位移
                    Path start4 = Paths.get(TimerParm.txt_chlPath + File.separator + dirPath + File.separator + newfileName);
                    Path target4 = Paths.get(TimerParm.txt_chlPath + File.separator + dirname + File.separator + newfileName);
                    NioFileUtil.moveFile(start4, target4, StandardCopyOption.REPLACE_EXISTING);
                    NioFileUtil.deleteIfExists(Paths.get(TimerParm.txt_chlPath + File.separator + dirPath));
                } else {
                    //不存在则将移动过来的文件夹重命名
                    NioFileUtil.reNameFile(TimerParm.txt_chlPath + File.separator + dirPath, dirname);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    //过滤新闻中不存在error——log 的新闻 直接进入临时库
    public void intoTMP(InformationPipelineWithBLOBs informationPipeline,HttpServletRequest request){
        //--------------------------------------------------------------------------参数
        //导出txt
        String username = informationPipeline.getXwcolumn().equals("100002")?"zyzd":"dfzd";// 中央和地方区分开
        DecimalFormat df = new DecimalFormat("000");

        //文件移动工具
        NioFileUtil fileUtil = new NioFileUtil();
//-------------------------------------------------------
        String txtPath = informationPipeline.getFilename();
        String dirPath = txtPath.substring(0,txtPath.indexOf("."));
        String oldFileName = informationPipeline.getFilename();




        Map<String, Integer> maxRjs8 = getMaxRjs8ForMain(username);//统一导出到aaa 账户
        int beginNum = maxRjs8.get("beginNum");
        int endNum = maxRjs8.get("endNum");
        if(endNum<999) {
            endNum++;
        }else {
            beginNum++;
            endNum=1;
        }

        MainWithBLOBs main = new MainWithBLOBs();
        main.setRjs0(informationPipeline.getNewstitle());
        main.setRjs4(informationPipeline.getDeptcode());
        main.setRjs5(informationPipeline.getReleasetime());
        main.setRjs6(informationPipeline.getExtend1());
        main.setRjs7(informationPipeline.getXwcolumn().equals("100002")?"chl":"lar");
        main.setRjs8(username+df.format(beginNum)+"s"+df.format(endNum)+".txt"); //filename 保存文件的文件名
        main.setRjs9((short)1);
        main.setRjs10(informationPipeline.getDeptname());
        main.setRjs12(informationPipeline.getFilenum());
        main.setAppuser(username);
        main.setLinksource(informationPipeline.getSource());
        main.setRid((long)informationPipeline.getInformationId());

        main.setFjian(informationPipeline.getFjian()!=null?informationPipeline.getFjian().replaceAll("\\u200b","").replaceAll("\\u200c",""):null); //附件名
        main.setPre_distinct(informationPipeline.getPreDistinct()); //重复状态

        main.setRjs1(informationPipeline.getRjs1());
        main.setKword(informationPipeline.getKeyword());
        main.setLawlevel(5);
        main.setAppdate(new Date());
        main.setRjs14(informationPipeline.getRjs14());
        main.setRjs15(informationPipeline.getRjs15());
        main_service.insert(main);


        try {
            //先重命名
            NioFileUtil.reNameFile(request.getRealPath(TimerParm.attachmentPATH) + File.separator + informationPipeline.getFilename().substring(0, informationPipeline.getFilename().indexOf(".")), username + df.format(beginNum) + "s" + df.format(endNum));
            //附件移动到。5挂载文件夹下

            Path start = Paths.get(request.getRealPath(TimerParm.attachmentPATH) + File.separator + username + df.format(beginNum) + "s" + df.format(endNum));
            Path target = Paths.get(TimerParm.fjPath5);
            //移动附件之前先判断目标地址中是否存在重名文件夹 如果存在则先删除掉目标文件夹
            NioFileUtil.deleteIfExists(Paths.get(TimerParm.fjPath5 + File.separator + username + df.format(beginNum) + "s" + df.format(endNum)));
            //在移动
            fileUtil.operateDir(true, start, target, StandardCopyOption.REPLACE_EXISTING);


            //txt移动到。5挂载文件夹下
            Path start1 = Paths.get(request.getRealPath(TimerParm.destDir) + File.separator + dirPath);
            Path target2 = Paths.get(TimerParm.txtPath5);
            fileUtil.operateDir(true, start1, target2, StandardCopyOption.REPLACE_EXISTING);
            //先重命名文件
            String newfileName = username + df.format(beginNum) + "s" + df.format(endNum) + ".txt";
            NioFileUtil.reNameFile(TimerParm.txtPath5 + File.separator + dirPath + File.separator + oldFileName, newfileName);
            //再重命名文件夹
            File f = new File(TimerParm.txtPath5 + File.separator + username);
            if (f.exists()) {
                //如果已经存在就做文件位移
                Path start4 = Paths.get(TimerParm.txtPath5 + File.separator + dirPath + File.separator + newfileName);
                Path target4 = Paths.get(TimerParm.txtPath5 + File.separator + username + File.separator + newfileName);
                NioFileUtil.moveFile(start4, target4, StandardCopyOption.REPLACE_EXISTING);
                NioFileUtil.deleteIfExists(Paths.get(TimerParm.txtPath5 + File.separator + dirPath));
            } else {
                //不存在则将移动过来的文件夹重命名
                NioFileUtil.reNameFile(TimerParm.txtPath5 + File.separator + dirPath, username);
            }

            //txtcopy移动到。5挂载文件夹下
            Path start3 = Paths.get(request.getRealPath(TimerParm.copyDir) + File.separator + informationPipeline.getFilename());
            Path target3 = Paths.get(TimerParm.txtCopyPath5 + File.separator + informationPipeline.getFilename());
            fileUtil.moveFile(start3, target3, StandardCopyOption.REPLACE_EXISTING);
            NioFileUtil.reNameFile(TimerParm.txtCopyPath5 + File.separator + oldFileName, username + df.format(beginNum) + "s" + df.format(endNum) + ".txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
