package com.spider.controller;

import com.ifeng.auto.we_provider.common.db.DynamicDataSource;
import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.TXwInformation;
import com.spider.bean.TXwWebsite;
import com.spider.bean.UserTask;
import com.spider.elemente.JavaScript_static;
import com.spider.service.TXwInformation_service;
import com.spider.service.TXwWebsite_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TXwWebsite_controller {
    @Autowired
    private TXwWebsite_service website_service;

    @Autowired
    private TXwInformation_service information_service;


    //保存标题、文号状态
    @RequestMapping("saveTitleAndNewsnumStatus")
    @ResponseBody
    public String saveTitleAndNewsnumStatus(@RequestParam(value = "title")int title,@RequestParam(value = "newsnum")int newsnum,@RequestParam(value = "id")int id,HttpServletRequest request){
        int xwcolumn = (int) request.getSession().getAttribute("xwcolumn");
        if (xwcolumn == 100002){
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        }else if (xwcolumn == 100003){
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        }else {
            return "error";
        }
        //修改
        try {

            website_service.updateTitleAndNewsnumStatus(id,title,newsnum);

            return "保存成功！";
        }catch (Exception e){
            return "保存失败！";
        }


    }

    //取消推送
    @RequestMapping("rollbackSendPipeline")
    @ResponseBody
    public String rollbackSendPipeline(@RequestParam(value = "ids")String ids,HttpServletRequest request){
        int xwcolumn = (int) request.getSession().getAttribute("xwcolumn");
        if (xwcolumn == 100002){
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        }else if (xwcolumn == 100003){
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        }else {
            return "error";
        }
        //修改refmain == 0
        website_service.updateRefmainToZero(ids.trim().split(" "));

        return "取消成功！";
    }
    //推送到正式库
    @RequestMapping("sendTMP")
    @ResponseBody
    public String sendTMP(@RequestParam(value = "ids")String ids, Model model,HttpServletRequest request){
        int xwcolumn = (int) request.getSession().getAttribute("xwcolumn");
        if (xwcolumn == 100002){
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        }else if (xwcolumn == 100003){
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        }else {
            return "error";
        }
        //修改refmain == 2
        website_service.updateRefmainToThree(ids.trim().split(" "));
/*        //重置所有新闻状态为1
        information_service.updatePipelineStatusWithRefmainToOne(ids.trim().split(" "));
        //修改新闻状态
        information_service.updatePipelineStatusWithRefmainToZero(ids.trim().split(" "),"twenty");*/

        return "推送成功！";
    }
    //推送到正式库
    @RequestMapping("sendCHL")
    @ResponseBody
    public String sendCHL(@RequestParam(value = "ids")String ids, Model model,HttpServletRequest request){
        int xwcolumn = (int) request.getSession().getAttribute("xwcolumn");
        if (xwcolumn == 100002){
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        }else if (xwcolumn == 100003){
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        }else {
            return "error";
        }
        //修改refmain == 2
        website_service.updateRefmainToTwo(ids.trim().split(" "));
/*        //重置所有新闻状态为1
        information_service.updatePipelineStatusWithRefmainToOne(ids.trim().split(" "));
        //修改新闻状态
        information_service.updatePipelineStatusWithRefmainToZero(ids.trim().split(" "),"twenty");*/

        return "推送成功！";
    }
    //推送到预处理
    @RequestMapping("sendPipeline")
    @ResponseBody
    public String sendPipeline(@RequestParam(value = "flag")String flag,@RequestParam(value = "ids")String ids, Model model,HttpServletRequest request){
        int xwcolumn = (int) request.getSession().getAttribute("xwcolumn");
        if (xwcolumn == 100002){
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        }else if (xwcolumn == 100003){
            DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        }else {
            return "error";
        }
        //修改refmain == 1
        website_service.updateRefmainToOne(ids.trim().split(" "));
        //重置所有新闻状态为1
        information_service.updatePipelineStatusWithRefmainToOne(ids.trim().split(" "));
        //修改新闻状态
        information_service.updatePipelineStatusWithRefmainToZero(ids.trim().split(" "),flag);

        return "推送成功！";
    }

    //地方
    @RequestMapping("/websiteList_lar")

    public String findWebSiteListLar(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserTask user = (UserTask)session.getAttribute("user");
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);


        List<TXwWebsite> tXwWebsiteList = website_service.getTXwWebsiteList(user.getName());
        List<TXwInformation> websiteidList = information_service.getWebsiteidList();
        setWebsiteIstatus(tXwWebsiteList,websiteidList);

        model.addAttribute("websiteList",tXwWebsiteList);
        //存储中央、地方标识
        request.getSession().setAttribute("xwcolumn",100003);
        return "table_data_tables_lar";
    }
    //中央
    @RequestMapping("/websiteList")

    public String findWebSiteList(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserTask user = (UserTask)session.getAttribute("user");
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);


        List<TXwWebsite> tXwWebsiteList = website_service.getTXwWebsiteList(user.getName());
        List<TXwInformation> websiteidList = information_service.getWebsiteidList();
        setWebsiteIstatus(tXwWebsiteList,websiteidList);

        model.addAttribute("websiteList",tXwWebsiteList);

        //存储中央、地方标识
        request.getSession().setAttribute("xwcolumn",100002);
        return "table_data_tables";
    }

    @RequestMapping("/isApaterWebsiteList")
    public String isApaterWebsiteList(Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);


        List<TXwWebsite> apaterWebsiteList = website_service.isApaterWebsiteList();
        List<TXwInformation> websiteidList = information_service.getWebsiteidList();
        setWebsiteIstatus(apaterWebsiteList,websiteidList);
        model.addAttribute("websiteList",apaterWebsiteList);
        return "isApaterWebsiteList";
    }
    @RequestMapping("/isNotApaterWebsiteList")
    public String isNotApaterWebsiteList(Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);


        List<TXwWebsite> notApaterWebsiteList = website_service.isNotApaterWebsiteList();
        List<TXwInformation> websiteidList = information_service.getWebsiteidList();
        setWebsiteIstatus(notApaterWebsiteList,websiteidList);
        model.addAttribute("websiteList",notApaterWebsiteList);
        return "isNotApaterWebsiteList";
    }

    public void setWebsiteIstatus(List<TXwWebsite> tXwWebsiteList,List<TXwInformation> websiteidList){
        for (TXwWebsite tXwWebsite : tXwWebsiteList) {
            boolean flag = false;
            a:for (TXwInformation tXwInformation : websiteidList) {
                if (tXwWebsite.getId() .equals(tXwInformation.getWebsiteid())){
                    flag = true;
                    break a;
                }
            }
            if (flag){
                tXwWebsite.setIstatus(1);
            }else {
                tXwWebsite.setIstatus(0);
            }
        }
    }
}
