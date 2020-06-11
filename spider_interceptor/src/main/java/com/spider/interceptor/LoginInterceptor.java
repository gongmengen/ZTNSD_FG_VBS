package com.spider.interceptor;


import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.*;
import com.spider.elemente.ErrorPram;
import com.spider.elemente.JavaScript_static;
import com.spider.elemente.TimerParm;
import com.spider.mapper.TblErrorMapper;
import com.spider.utils.LocalHostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 登录认证的拦截器 
*/
public class LoginInterceptor implements HandlerInterceptor {



   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      //System.out.println("拦截器..");
      HttpSession session = request.getSession();
      UserTask user = (UserTask) session.getAttribute("user");
      if (user==null) {
         request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
         //response.sendRedirect("");
         return false;
      }
      System.out.println(request.getRemoteAddr());
      return true;
   }

   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

   }

   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

   }
}