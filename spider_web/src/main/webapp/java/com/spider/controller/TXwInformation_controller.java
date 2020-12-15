package com.spider.controller;

import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.*;
import com.spider.elemente.JavaScript_static;
import com.spider.service.TWxAdapter_service;
import com.spider.service.TXwInformation_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TXwInformation_controller {
    @Autowired
    private TXwInformation_service information_service;
    @Autowired
    private TWxAdapter_service adapter_service;

    //update pipeline_status = 0
    @RequestMapping("resetPipelineStatus")
    @ResponseBody
    public String resetPipelineStatus(@RequestParam("ids")String ids){
        List<InformationPipelineWithBLOBs> informationList = new ArrayList<InformationPipelineWithBLOBs>();
        InformationPipelineWithBLOBs information = new InformationPipelineWithBLOBs();
        information.setInformationId(Integer.parseInt(ids));
        informationList.add(information);
        information_service.updatePipelineStatusForZero(informationList);
        return "重置成功！";
    }
    //步骤一：加载新闻列表
    //中央
    @RequestMapping("informationList_chl/{websiteid}/{pageid}")
    public String findWebsiteidList_lar(@PathVariable(value = "websiteid")int websiteid,@PathVariable(value = "pageid")int pageid, Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        findWebsiteidList(websiteid,pageid,model);
        return "_adapter/_informationList";
    }
    //地方
    @RequestMapping("informationList_lar/{websiteid}/{pageid}")
    public String findWebsiteidList_chl(@PathVariable(value = "websiteid")int websiteid,@PathVariable(value = "pageid")int pageid, Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        findWebsiteidList(websiteid,pageid,model);
        return "_adapter/_informationList_lar";
    }

    public void findWebsiteidList(int websiteid,int pageid,Model model){


        model.addAttribute("informationList",information_service.getInformationListWithWebsiteId_fast(websiteid));
        if(pageid == 0){
            model.addAttribute("pageid",0);
        }else if (pageid == 1){
            model.addAttribute("pageid",1);
        }else {
            model.addAttribute("pageid",2);
        }

    }
    //步骤二：选取一篇新闻进行适配
    //地方
    @RequestMapping("getInformation_lar/{id}")
    public String getInformation_lar(@PathVariable(value = "id")int id,Model model,HttpServletRequest request){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        findInformation(id,model);

        return "_editor/_title_editor";
    }

    //中央
    @RequestMapping("getInformation_chl/{id}")
    public String getInformation_chl(@PathVariable(value = "id")int id,Model model,HttpServletRequest request){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        findInformation(id,model);

        return "_editor/_title_editor";
    }

    public void findInformation(int id,Model model){

        String result = "";
        TXwInformationWithBLOBs information = information_service.getInformation(id);
        model.addAttribute("information",information);
        TWxAdapterWithBLOBs adapterWithSiteid = adapter_service.getAdapterWithSiteid(information.getWebsiteid());
        model.addAttribute("adapter",adapterWithSiteid);
        //添加通用标题脚本
        model.addAttribute("lawstar_title", JavaScript_static.LAWSTAR_TITLE);
        //适配预处理
        if (adapterWithSiteid.getTitle()!=null&&!adapterWithSiteid.getTitle().equals("")){
            try {
                result = adapter_service.regSingleCode(information.getNewscontentnotupdate(), adapterWithSiteid, 1);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }else {
            adapterWithSiteid.setTitle(JavaScript_static.LAWSTAR_TITLE);
            adapterWithSiteid.setSiteid(information.getWebsiteid());
            try {
                result = adapter_service.regSingleCode(information.getNewscontentnotupdate(), adapterWithSiteid, 1);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("result",result);

    }

}
