package com.spider.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.*;
import com.spider.elemente.TimerParm;
import com.spider.service.*;
import com.spider.utils.NioFileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * KeyWord_controller
 * </p>
 *
 * @author msi-
 * @package: com.spider.controller
 * @description: 人工审查模块
 * @date: Created in 2020-07-30 9:14
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: msi-
 */
@Controller

public class KeyWord_controller {

    @Autowired
    private Main_service main_service;
    @Autowired
    private Keyword_service keyword_service;

    @Autowired
    private MainCHLandLAR_service mainCHLandLAR_service;


    //展示所有 zyzd
    @RequestMapping("/keyWor/list")
    public String getInformationPipelineList(HttpServletRequest request,Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);

        //获取Newcode数据
        List<Newcode> mainList = keyword_service.getListNewcode();
        model.addAttribute("mainList",mainList);

        return "_keyword/_keyWordList";
    }
    
    //展示所有 zyzd
    @RequestMapping("/NewKeyword")
    public String getKeyword(HttpServletRequest request,Model model){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);

        //获取Newcode数据
        List<Newcode> mainList = keyword_service.getListNewcode();
        model.addAttribute("mainList",mainList);

        return "";
    }
    
    //获取数据清洗过程中的错误日志   @RequestParam当属性名与表单中的name不一致，做映射
    @RequestMapping("toUpdateKey")
    @ResponseBody
    public String toUpdateKey(@RequestParam(value = "code")String code){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);
        StringBuilder resu = new StringBuilder();
        Newcode newcode=keyword_service.getNewcode(code);
        String nString=newcode.getKword();
        System.out.println("code="+nString);
        resu.append(nString);
        return resu.toString();
    }
    
    //获取数据清洗过程中的错误日志   如果标记了@ResponseBody，就会按照流的方式返回到页面
    @RequestMapping("UpdateKey")
    @ResponseBody
    public String UpdateKey(@RequestParam(value = "code")String code,@RequestParam(value = "information")String information){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_CHL);
        StringBuilder resu = new StringBuilder();
        Newcode newcode=keyword_service.getNewcode(code);
        String nString=newcode.getKword();
        Newcode ncode=new Newcode();
        ncode.setCode(code);
        ncode.setKword(information);
        System.out.println("2020="+code);
        System.out.println("2020="+information);
        keyword_service.updateNewcode(ncode);
        return resu.toString();
    }
   
    
   
}