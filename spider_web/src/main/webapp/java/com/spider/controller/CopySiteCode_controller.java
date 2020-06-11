package com.spider.controller;

import com.spider.bean.TWxAdapterWithBLOBs;
import com.spider.bean.TXwInformation;
import com.spider.bean.TXwInformationWithBLOBs;
import com.spider.bean.TXwWebsite;
import com.spider.service.TWxAdapter_service;
import com.spider.service.TXwInformation_service;
import com.spider.service.TXwWebsite_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CopySiteCode_controller {
    @Autowired
    private TXwWebsite_service website_service;
    @Autowired
    private TXwInformation_service information_service;
    @Autowired
    private TWxAdapter_service adapter_service;
    @RequestMapping("chooseWebsite/{siteids}")
    public String chooseWebsite(@PathVariable(value = "siteids")String ids, Model model){
        List<TXwWebsite> apaterWebsiteList = website_service.isApaterWebsiteList();
        List<TXwInformation> websiteidList = information_service.getWebsiteidList();
        setWebsiteIstatus(apaterWebsiteList,websiteidList);
        model.addAttribute("websiteList",apaterWebsiteList);
        model.addAttribute("siteids",ids);
        return "isApaterWebsiteList_copy";
    }
    @RequestMapping("copyCode/{websiteid}/{websiteids}")
    public String copyCode(@PathVariable(value = "websiteid")int id, @PathVariable(value = "websiteids")String ids,Model model){
        //传递逻辑
        TWxAdapterWithBLOBs adapterWithSiteid = adapter_service.getAdapterWithSiteid(id);//获取已适配网站的对象
        String[] websiteids = ids.split(",");
        for (int i =0;i<websiteids.length;i++){
            adapterWithSiteid.setSiteid(Integer.valueOf(websiteids[i]));
            adapterWithSiteid.setId(null);
            adapterWithSiteid.setCreatetime(null);
            adapter_service.insertAdapterCode(adapterWithSiteid);
        }
        //传递完成 数据渲染
        List<String> results = new ArrayList<String>();
        List<TXwWebsite> websiteList = new ArrayList<TXwWebsite>();
        for (int i =0;i<websiteids.length;i++){
            TXwInformationWithBLOBs tXwInformationWithBLOBs = information_service.getInformationListWithWebsiteId(Integer.parseInt(websiteids[i])).get(0);
            try {
                results.add(adapter_service.regNews(tXwInformationWithBLOBs, Integer.parseInt(websiteids[i])));
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            //获取website对象
            TXwWebsite websiteByid = website_service.findWebsiteByid(tXwInformationWithBLOBs.getWebsiteid());
            websiteByid.setUserid(tXwInformationWithBLOBs.getId());//使用userid字段 存放 informationid
            websiteList.add(websiteByid);
        }
        model.addAttribute("resultList",results);
        model.addAttribute("websiteList",websiteList);
        return "regNews_pin_board";
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
