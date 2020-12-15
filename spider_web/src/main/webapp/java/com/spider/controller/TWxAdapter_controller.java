package com.spider.controller;

import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.InformationPipelineWithBLOBs;
import com.spider.bean.TWxAdapterWithBLOBs;
import com.spider.bean.TXwInformationWithBLOBs;
import com.spider.service.TWxAdapter_service;
import com.spider.service.TXwInformation_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TWxAdapter_controller {
    @Autowired
    private TWxAdapter_service adapter_service;
    @Autowired
    private TXwInformation_service information_service;

    //继续验证十篇
    @RequestMapping("nextReg/{id}")

    public String nextReg(@PathVariable("id")int informationid,Model model,HttpServletRequest request){
        int websiteid = information_service.getWebsiteidByInformationid(informationid);
        List<TXwInformationWithBLOBs> informationList = information_service.getNextTenInformationList(informationid,websiteid);
        try {
            model.addAttribute("resultList",adapter_service.regRandomNews(informationList,websiteid,request));
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        TXwInformationWithBLOBs information = information_service.getInformation(informationid);
        model.addAttribute("information",information);
        //获取继续验证得条件id
        model.addAttribute("nextRegID",informationList.size()==10?informationList.get(informationList.size()-1).getId():-1);
        return "_adapter/_pin_board";
    }

    //验证一篇新闻 带重置功能
    @RequestMapping("regsinglenewsWithReset/{id}/{xwcolumn}")

    public String regsinglenewsWithReset(@PathVariable("id")int informationid,@PathVariable("xwcolumn")int xwcolumn,HttpServletRequest request,Model model){
        if (xwcolumn == 100003){
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
        }else {
            DynamicDataSourceHolder.clearCustomerType();
            DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        }
        HttpSession session = request.getSession();
        session.setAttribute("xwcolumn",xwcolumn);
        InformationPipelineWithBLOBs informationPipelineWithBLOBs = adapter_service.regSingleNews(informationid);
        model.addAttribute("informationPipeline",informationPipelineWithBLOBs);
        // model.addAttribute("websiteid",informationPipelineWithBLOBs.getId());
        return "_search/_informationDetailWithReset";
    }
    //验证一篇新闻
    @RequestMapping("regsinglenews/{informationid}")

    public String regsinglenews(@PathVariable(value = "informationid") String informationid,Model model,HttpServletRequest request){
        String[] split = informationid.split("@");

        if (split.length>1){
            if (split[1].equals("100002")){
                DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
                DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
            }else if (split[1].equals("100003")){
                DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
                DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT_LAR);
            }
            InformationPipelineWithBLOBs informationPipelineWithBLOBs = adapter_service.regSingleNews(Integer.parseInt(split[0]));
            model.addAttribute("informationPipeline",informationPipelineWithBLOBs);
        }else {
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
            InformationPipelineWithBLOBs informationPipelineWithBLOBs = adapter_service.regSingleNews(Integer.parseInt(informationid));
            model.addAttribute("informationPipeline",informationPipelineWithBLOBs);
        }

        return "_adapter/_informationDetail";
    }


    //1.测试单个脚本(ajax)
    @RequestMapping("regsinglecode")
    @ResponseBody
    public String testCode(TWxAdapterWithBLOBs adapter,int informationid,int codetype){
        TXwInformationWithBLOBs information = information_service.getInformation(informationid);
/*        TWxAdapterWithBLOBs adapter = new TWxAdapterWithBLOBs();
        adapter.setTitle(title);*/

        adapter.setSiteid(information.getWebsiteid());
        String s = null;
        try {
            s = adapter_service.regSingleCode(information.getNewscontentnotupdate(), adapter, codetype);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return s;
    }
/*    //2.添加脚本
    @RequestMapping("addCode")
    public int insertCode(TWxAdapterWithBLOBs adapter){
        return adapter_service.insertAdapterCode(adapter);
    }*/

    //3.随机十篇验证
    @RequestMapping("regten/{websiteid}/{informationid}")
    public String regten(@PathVariable(value = "websiteid")int websiteid,@PathVariable(value = "informationid")int informationid, Model model,HttpServletRequest request){
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

        List<TXwInformationWithBLOBs> informationList = information_service.getTenInformationList(websiteid);
        try {
            model.addAttribute("resultList",adapter_service.regRandomNews(informationList,websiteid,request));
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        TXwInformationWithBLOBs information = information_service.getInformation(informationid);
        model.addAttribute("information",information);
        //获取继续验证得条件id
        model.addAttribute("nextRegID",informationList.get(informationList.size()-1).getId());
        return "_adapter/_pin_board";
    }

    //收藏脚本
    @RequestMapping("saveToSession")
    @ResponseBody
    public String saveToSession(String title, int codeType,HttpServletRequest request){
        HttpSession session = request.getSession();
        switch (codeType){
            case 1:
/*                String title_session = (String)session.getAttribute("title");
                if (title_session)*/
                session.setAttribute("title",title);
                break;
            case 2:
                session.setAttribute("content",title);
                break;
            case 3:
                session.setAttribute("releaseDate",title);
                break;
            case 4:
                session.setAttribute("newNum",title);
                break;
            case 5:
                session.setAttribute("implementDate",title);
                break;
            case 6:
                session.setAttribute("attachment",title);
                break;
        }
        return "ok";
    }


    //加载收藏脚本
    @RequestMapping("loadSession")
    @ResponseBody
    public String loadSession(int codeType,HttpServletRequest request){
        HttpSession session = request.getSession();
        String code = null;
        switch (codeType){
            case 1:
/*                String title_session = (String)session.getAttribute("title");
                if (title_session)*/
                code =(String) session.getAttribute("title");
                break;
            case 2:
                code =(String)  session.getAttribute("content");
                break;
            case 3:
                code =(String) session.getAttribute("releaseDate");
                break;
            case 4:
                code =(String) session.getAttribute("newNum");
                break;
            case 5:
                code =(String) session.getAttribute("implementDate");
                break;
            case 6:
                code =(String) session.getAttribute("attachment");
                break;
        }
        return code;
    }

}
