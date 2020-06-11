package com.spider.controller;

import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.TWxAdapter;
import com.spider.bean.TWxAdapterWithBLOBs;
import com.spider.bean.TXwInformationWithBLOBs;
import com.spider.elemente.JavaScript_static;
import com.spider.service.TWxAdapter_service;
import com.spider.service.TXwInformation_service;
import com.spider.service.TXwWebsite_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Page_controller {
    @Autowired
    private TXwInformation_service information_service;
    @Autowired
    private TWxAdapter_service adapter_service;
    @Autowired
    private TXwWebsite_service  website_service;


    @RequestMapping("/search/goSearchPage")
    public String goSearchPage(){

        return "search_result";
    }
    @RequestMapping("/rememberSelectLength")
    @ResponseBody
    public String rememberSelectLength(@RequestParam(value = "length")int length, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("selectLength",length);
        return length+"";
    }
    //进行页面跳转
    @RequestMapping("nextPage/{page}/{informationid}")
    public String nextPage(@PathVariable(value = "page")int page, @PathVariable(value = "informationid")int id, Model model,HttpServletRequest request){

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

        String result = "";
        TXwInformationWithBLOBs information = information_service.getInformation(id);
        TWxAdapterWithBLOBs adapterWithSiteid = adapter_service.getAdapterWithSiteid(information.getWebsiteid());
        model.addAttribute("information",information);
        model.addAttribute("adapter",adapterWithSiteid);
        String pageFor = "";
        switch (page){
            case 1:
                //标题脚本页
                pageFor = "title_editor";
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
                break;
            case 2:
                //正文脚本页
                pageFor = "newsContent_editor";
                //添加通用正文脚本
                model.addAttribute("lawstar_newsContent", JavaScript_static.LAWSTAR_CONTENT);
                //titleStatus|newsnumStatus状态
                model.addAttribute("website",website_service.findWebsiteByid(information.getWebsiteid()));

                break;
            case 3:
                //发布日期脚本页
                pageFor = "releaseDate_editor";
                //添加通用发布日期脚本
                model.addAttribute("lawstar_releaseDate", JavaScript_static.LAWSTAR_APPDATE);
                //适配预处理
                if (adapterWithSiteid.getReleasedate()!=null&&!adapterWithSiteid.getReleasedate().equals("")){
                    try {
                        result = adapter_service.regSingleCode(information.getNewscontentnotupdate(), adapterWithSiteid, 3);
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
                }else {
                    adapterWithSiteid.setReleasedate(JavaScript_static.LAWSTAR_APPDATE);
                    adapterWithSiteid.setSiteid(information.getWebsiteid());
                    try {
                        result = adapter_service.regSingleCode(information.getNewscontentnotupdate(), adapterWithSiteid, 3);
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
                }

                model.addAttribute("result",result);
                break;
            case 4:
                //文号脚本页
                pageFor = "newNum_editor";
                //添加通用文号脚本
                model.addAttribute("lawstar_newNum", JavaScript_static.LAWSTAR_WENHAO);
                //适配预处理
                if (adapterWithSiteid.getNewnum()!=null&&!adapterWithSiteid.getNewnum().equals("")){
                    try {
                        result = adapter_service.regSingleCode(information.getNewscontentnotupdate(), adapterWithSiteid, 4);
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
                }else {
                    adapterWithSiteid.setNewnum(JavaScript_static.LAWSTAR_WENHAO);
                    adapterWithSiteid.setSiteid(information.getWebsiteid());
                    try {
                        result = adapter_service.regSingleCode(information.getNewscontentnotupdate(), adapterWithSiteid, 4);
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
                }

                model.addAttribute("result",result);
                break;
            case 5:
                //实施日期脚本页
                pageFor = "implementDate_editor";
                break;
            case 6:
                //附件脚本页
                pageFor = "attachment_editor";
                //添加通用附件脚本
                model.addAttribute("lawstar_attachment", JavaScript_static.LAWSTAR_ATTMENTS);
                //适配预处理
                if (adapterWithSiteid.getAttachment()!=null&&!adapterWithSiteid.getAttachment().equals("")){
                    try {
                        result = adapter_service.regSingleCode(information.getNewscontentnotupdate(), adapterWithSiteid, 6);
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
                }else {
                    adapterWithSiteid.setAttachment(JavaScript_static.LAWSTAR_ATTMENTS);
                    adapterWithSiteid.setSiteid(information.getWebsiteid());
                    try {
                        result = adapter_service.regSingleCode(information.getNewscontentnotupdate(), adapterWithSiteid, 6);
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
                }

                model.addAttribute("result",result);
                break;
            case 7:
                //随机验证十篇新闻
                pageFor = "pin_board";

                break;
        }
        return pageFor;
    }
}
