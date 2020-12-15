package com.spider.controller;

import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.UserTask;
import com.spider.bean.Userdb;
import com.spider.service.UserTask_service;
import com.spider.service.User_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class Login_controller {
    @Autowired
    private UserTask_service userService;

    //go登陆
    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }
    //go注册
    @RequestMapping("/goRegister")
    public String goRegister(){
        return "register";
    }
    //注册
    @RequestMapping("/register")
    public void register(@RequestParam(value = "name")String name, @RequestParam(value = "password")String password, Model model, HttpServletResponse response){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        userService.addUserTask(name,password);
        try {
            response.sendRedirect("/goLogin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //登陆
    @RequestMapping("/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, Model model, HttpServletRequest request){
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        UserTask login = userService.login(username, password);
        //登陆的结果放到session中
        request.getSession().setAttribute("user",login);
        //切换会主数据源
        DynamicDataSourceHolder.clearCustomerType();
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        if (login!=null){

            return "_index";
        }
        model.addAttribute("status","error");
        return "login";
    }


    //拦截到login
    @RequestMapping("/index")
    public String index(HttpServletRequest request,Model model){
/*        HttpSession session = request.getSession();
        model.addAttribute("user",(UserTask)session.getAttribute("user"));*/
        return "_index";
    }
    @RequestMapping("/_index")
    public String _index(HttpServletRequest request,Model model){
/*        HttpSession session = request.getSession();
        model.addAttribute("user",(UserTask)session.getAttribute("user"));*/
        return "_index";
    }
    //退出系统
    @RequestMapping("/outSys")
    public String outSys(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        session.setAttribute("user",null);
        return "login";
    }
}
