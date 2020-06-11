package com.spider.controller;

import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.TXwInformation;
import com.spider.bean.TXwWebsite;
import com.spider.bean.UserTask;
import com.spider.service.TXwInformation_service;
import com.spider.service.TXwWebsite_service;
import com.spider.service.UserTask_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("task")
public class Task_controller {
    @Autowired
    private TXwWebsite_service website_service;
    @Autowired
    private TXwInformation_service information_service;
    @Autowired
    private UserTask_service userTask_service;

    //地方
    @RequestMapping("/list_lar")

    public String taskListLar(Model model, HttpServletRequest request){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        List<TXwWebsite> tXwWebsiteList = website_service.getTXwWebsiteList("root");
        List<TXwInformation> websiteidList = information_service.getWebsiteidList();
        setWebsiteIstatus(tXwWebsiteList,websiteidList);
        model.addAttribute("websiteList",tXwWebsiteList);
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        //获取可分配用户列表
        List<UserTask> userTaskList = userTask_service.getUserTaskList();
        model.addAttribute("userTaskList",userTaskList);
        return "taskList_lar";
    }
    //中央
    @RequestMapping("/list")

    public String taskList(Model model, HttpServletRequest request){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        List<TXwWebsite> tXwWebsiteList = website_service.getTXwWebsiteList("root");
        List<TXwInformation> websiteidList = information_service.getWebsiteidList();
        setWebsiteIstatus(tXwWebsiteList,websiteidList);
        model.addAttribute("websiteList",tXwWebsiteList);
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        //获取可分配用户列表
        List<UserTask> userTaskList = userTask_service.getUserTaskList();
        model.addAttribute("userTaskList",userTaskList);
        return "taskList";
    }
//地方
    @RequestMapping("/addLar")

    public void taskAddLar(@RequestParam(value = "websiteids")String websiteids, @RequestParam(value = "username")String username, Model model, HttpServletRequest request, HttpServletResponse response){
        //切换到25修改网站负责人
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        website_service.updateTaskName(websiteids.trim().split(" "),username);
        //切换到tmp 新增负责人对应栏目
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        userTask_service.addUserTaskWithWebsiteid(websiteids.trim().split(" "),username);
        try {
            response.sendRedirect("/task/list_lar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//中央
    @RequestMapping("/add")

    public void taskAdd(@RequestParam(value = "websiteids")String websiteids, @RequestParam(value = "username")String username, Model model, HttpServletRequest request, HttpServletResponse response){
        //切换到25修改网站负责人
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        website_service.updateTaskName(websiteids.trim().split(" "),username);
        //切换到tmp 新增负责人对应栏目
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        userTask_service.addUserTaskWithWebsiteid(websiteids.trim().split(" "),username);
        try {
            response.sendRedirect("/task/list");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
