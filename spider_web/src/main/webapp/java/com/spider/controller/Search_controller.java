package com.spider.controller;

import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.TXwInformation;
import com.spider.service.TXwInformation_service;
import com.spider.service.TXwWebsite_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Search_controller {
    @Autowired
    private TXwWebsite_service website_service;

    @Autowired
    private TXwInformation_service information_service;

    //检索url
    @RequestMapping("/search/searchResult")
    public String searchResult(@RequestParam(value = "keyword")String keyword, Model model){
        int xwcolumn = 100002;
        //中央检索
        DynamicDataSourceHolder.clearCustomerType();
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        List<TXwInformation> information= information_service.getInformationBySource(keyword);
        //中央检索
        DynamicDataSourceHolder.clearCustomerType();
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        List<TXwInformation> information_lar= information_service.getInformationBySource(keyword);
        information.addAll(information_lar);
        model.addAttribute("informationList",information);
        if (information_lar.size()>0){
            xwcolumn = 100003;
        }
        model.addAttribute("xwcolumn",xwcolumn);
        return "_search/_search_result";
    }
}
