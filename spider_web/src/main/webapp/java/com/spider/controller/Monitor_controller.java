package com.spider.controller;

import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.TXwInformation;
import com.spider.bean.TXwWebsite;
import com.spider.service.TXwInformation_service;
import com.spider.service.TXwWebsite_service;
import com.spider.service.UserTask_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("monitor")
public class Monitor_controller {
    @Autowired
    private TXwWebsite_service website_service;
    @Autowired
    private TXwInformation_service information_service;
    @Autowired
    private UserTask_service userTask_service;
    //中央
    @RequestMapping("informationList_chl")
    public @ResponseBody ModelAndView findWebsiteidList_lar(@RequestParam(value = "websiteid")int websiteid, @RequestParam(value = "start",required = false)String start, @RequestParam(value = "end",required = false)String end,ModelAndView m) throws IOException, ServletException {
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        m.addObject("informationList",information_service.getInformationListWithWebsiteIdAndUpdateTime(websiteid,start,end));
        m.setViewName("_monitor/_spider_informationlist_chl_monitor");
        return m;
    }
    //地方
    @RequestMapping("informationList_lar")
    public @ResponseBody ModelAndView findWebsiteidList_chl(@RequestParam(value = "websiteid")int websiteid,@RequestParam(value = "start",required = false)String start,@RequestParam(value = "end",required = false)String end,ModelAndView m) throws IOException, ServletException {
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        m.addObject("informationList",information_service.getInformationListWithWebsiteIdAndUpdateTime(websiteid,start,end));
        m.setViewName("_monitor/_spider_informationlist_lar_monitor");
        return m;
    }
    //地方
    @RequestMapping("/list_lar")

    public String taskListLar(@RequestParam(value = "start",required = false)String start, Model model, HttpServletRequest request) throws ParseException {
        int all = 0;
        String end = null;
        if (start==null){
            SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            start = dd.format(new Date());
            start = start.replace(start.substring(start.indexOf(" ")+1),"00:00:00");
        }
        if (start!=null){

            //日期格式
            SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateTime = dd.parse(start);
            end = dd.format(new Date(dateTime.getTime() + 1 * 24 * 60 * 60 * 1000L));
            System.out.println(end);

        }

        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        //全部网站列表
        List<TXwWebsite> tXwWebsiteList = website_service.getTXwWebsiteListWithMonitorDate();
        //根据网站获取新闻数量
        List<TXwWebsite> spiderCountByWebsiteid = information_service.getSpiderCountByWebsiteid(start,end);
        //获取网站最后更新日期
        List<TXwWebsite> lastUpdateTimeList = information_service.getLastUpdateTime();
        for (TXwWebsite website:tXwWebsiteList
             ) {
            for (TXwWebsite wesitewithspidercount:spiderCountByWebsiteid
                 ) {
                if (website.getId().equals(wesitewithspidercount.getId())){
                    website.setSpidercount(wesitewithspidercount.getSpidercount());

                    all += wesitewithspidercount.getSpidercount();
                    break;
                }
            }
            for (TXwWebsite lastUpdateTime:lastUpdateTimeList
                    ) {
                if (website.getId().equals(lastUpdateTime.getId())){
                    int hour = getNotUpdateTime(lastUpdateTime.getLasttime());
                    int day = hour/24;
                    int yu_hour = hour % 24;

                    website.setLasttime(lastUpdateTime.getLasttime());
                    website.setNotUpdateTime(hour);
                    website.setNotUpdateDay(day+"天"+yu_hour+"小时");
                    break;
                }
            }
        }

        model.addAttribute("websiteList",tXwWebsiteList);
        model.addAttribute("start",start);
        model.addAttribute("end",end);
        model.addAttribute("all",all);
        return "_monitor/_spider_information_lar_monitor";
    }
    //中央
    @RequestMapping("/list")

    public String taskList(@RequestParam(value = "start",required = false)String start,Model model, HttpServletRequest request) throws ParseException {
        int all = 0;

        String end = null;
        if (start==null){
            SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            start = dd.format(new Date());
            start = start.replace(start.substring(start.indexOf(" ")+1),"00:00:00");
            System.out.println(start);
        }

        if (start!=null){

            //日期格式
            SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateTime = dd.parse(start);
            end = dd.format(new Date(dateTime.getTime() + 1 * 24 * 60 * 60 * 1000L));
            System.out.println(end);

        }

        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        //全部网站列表
        List<TXwWebsite> tXwWebsiteList = website_service.getTXwWebsiteListWithMonitorDate();
        //根据网站获取新闻数量
        List<TXwWebsite> spiderCountByWebsiteid = information_service.getSpiderCountByWebsiteid(start, end);
        //获取网站最后更新日期
        List<TXwWebsite> lastUpdateTimeList = information_service.getLastUpdateTime();
        for (TXwWebsite website:tXwWebsiteList
                ) {
            for (TXwWebsite wesitewithspidercount:spiderCountByWebsiteid
                    ) {
                if (website.getId().equals(wesitewithspidercount.getId())){
                    website.setSpidercount(wesitewithspidercount.getSpidercount());
                    all += wesitewithspidercount.getSpidercount();
                    break;
                }
            }
            for (TXwWebsite lastUpdateTime:lastUpdateTimeList
                    ) {
                if (website.getId().equals(lastUpdateTime.getId())){
                    int hour = getNotUpdateTime(lastUpdateTime.getLasttime());
                    int day = hour/24;
                    int yu_hour = hour % 24;

                    website.setLasttime(lastUpdateTime.getLasttime());
                    website.setNotUpdateTime(hour);
                    website.setNotUpdateDay(day+"天"+yu_hour+"小时");
                    break;
                }
            }
        }

        model.addAttribute("websiteList",tXwWebsiteList);
        model.addAttribute("start",start);
        model.addAttribute("end",end);
        model.addAttribute("all",all);
        return "_monitor/_spider_information_chl_monitor";
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

    public int getNotUpdateTime(Date lasttime){
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
             // 将日期和时间的字符串表示形式转换为其等效的 DateTime。
            // date.getTime() 返回时间的毫秒数值
            //int year = (int) ((date.getTime() - d.getTime()) / (1000 * 60 * 60 * 24)) / 365; // 计算年
            //int day = (int) ((date.getTime() - lasttime.getTime()) / (1000 * 60 * 60 * 24)); // 计算天
            int hour = (int) ((date.getTime() - lasttime.getTime()) / (1000 * 60 * 60 )); // 计算天

return hour;
    }

}
