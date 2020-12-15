package com.spider.controller;

import com.lawstar.basic.util.Tools;
import com.spider.elemente.JavaScript_static;
import com.spider.utils.Tool_file;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.*;


@Controller
public class AdapterCommon_controller {

    //标题加载
    @RequestMapping("/lawstar_title_update")
    public String lawstar_title_update(Model model){
        model.addAttribute("lawstar_title", JavaScript_static.LAWSTAR_TITLE);
        return "_js_update/_lawstar_title_update";
    }
    //标题修改
    @RequestMapping(value = "/lawstar_title_update_upd",method = RequestMethod.POST)
    public String lawstar_title_update_upd(@RequestParam("title") String title,Model model){
        Tool_file toolFile = new Tool_file();
        try {
            String filePath = toolFile.getFilePathUseProjectUri("js/lawstar-title1.25.js");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath,false),"UTF-8");
            writer.write(title);
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();

        }
        JavaScript_static javaScriptStatic = new JavaScript_static();
        try {
            //重新加载js文件
            javaScriptStatic.setLawstar_title();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("lawstar_title",JavaScript_static.LAWSTAR_TITLE);
        return "_js_update/_lawstar_title_update";
    }
    //正文加载
    @RequestMapping("/lawstar_content_update")
    public String lawstar_content_update(Model model){
        model.addAttribute("lawstar_newsContent", JavaScript_static.LAWSTAR_CONTENT);
        return "_js_update/_lawstar_content_update";
    }
    //正文修改
    @RequestMapping(value = "/lawstar_content_update_upd",method = RequestMethod.POST)
    public String lawstar_content_update_upd(@RequestParam("title") String title,Model model){
        boolean flag = true;
        Tool_file toolFile = new Tool_file();
        try {
            String filePath = toolFile.getFilePathUseProjectUri("js/lawstar-content1.25.js");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath,false),"UTF-8");
            writer.write(title);
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        JavaScript_static javaScriptStatic = new JavaScript_static();
        try {
            //重新加载js文件
            javaScriptStatic.setLawstar_content();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("lawstar_newsContent",JavaScript_static.LAWSTAR_CONTENT);
        return "_js_update/_lawstar_content_update";
    }
    //发布日期加载
    @RequestMapping("/lawstar_appdate_update")
    public String lawstar_appdate_update(Model model){
        model.addAttribute("lawstar_releaseDate", JavaScript_static.LAWSTAR_APPDATE);
        return "_js_update/_lawstar_appdate_update";
    }
    //发布日期修改
    @RequestMapping(value = "/lawstar_appdate_update_upd",method = RequestMethod.POST)
    public String lawstar_appdate_update_upd(@RequestParam("title") String title,Model model){
        boolean flag = true;
        Tool_file toolFile = new Tool_file();
        try {
            String filePath = toolFile.getFilePathUseProjectUri("js/lawstar-appdate1.25.js");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath,false),"UTF-8");
            writer.write(title);
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        JavaScript_static javaScriptStatic = new JavaScript_static();
        try {
            //重新加载js文件
            javaScriptStatic.setLawstar_appdate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("lawstar_releaseDate",JavaScript_static.LAWSTAR_APPDATE);
        return "_js_update/_lawstar_appdate_update";
    }
    //实施日期加载
    @RequestMapping("/lawstar_implmentdate_update")
    public String lawstar_implmentdate_update(Model model){
        model.addAttribute("lawstar_releaseDate", JavaScript_static.LAWSTAR_APPDATE);
        return "_js_update/_lawstar_implmentdate_update";
    }
    //实施日期修改
    @RequestMapping(value = "/lawstar_implmentdate_update_upd",method = RequestMethod.POST)
    public String lawstar_implmentdate_update_upd(@RequestParam("title") String title,Model model){
        boolean flag = true;
        Tool_file toolFile = new Tool_file();
        try {
            String filePath = toolFile.getFilePathUseProjectUri("js/lawstar-appdate1.25.js");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath,false),"UTF-8");
            writer.write(title);
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        JavaScript_static javaScriptStatic = new JavaScript_static();
        try {
            //重新加载js文件
            javaScriptStatic.setLawstar_appdate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("lawstar_releaseDate",JavaScript_static.LAWSTAR_APPDATE);
        return "_js_update/_lawstar_implmentdate_update";
    }
    //文号加载
    @RequestMapping("/lawstar_wenhao_update")
    public String lawstar_wenhao_update(Model model){
        model.addAttribute("lawstar_newNum", JavaScript_static.LAWSTAR_WENHAO);
        return "_js_update/_lawstar_wenhao_update";
    }
    //文号修改
    @RequestMapping(value = "/lawstar_wenhao_update_upd",method = RequestMethod.POST)
    public String lawstar_wenhao_update_upd(String title,Model model){
        boolean flag = true;
        Tool_file toolFile = new Tool_file();
        try {
            String filePath = toolFile.getFilePathUseProjectUri("js/lawstar-wenhao1.25.js");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath,false),"UTF-8");
            writer.write(title);
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        JavaScript_static javaScriptStatic = new JavaScript_static();
        try {
            //重新加载js文件
            javaScriptStatic.setLawstar_wenhao();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("lawstar_newNum",JavaScript_static.LAWSTAR_WENHAO);
        return "_js_update/_lawstar_wenhao_update";
    }
    //附件加载
    @RequestMapping("/lawstar_attments_update")
    public String lawstar_attments_update(Model model){
        model.addAttribute("lawstar_attachment", JavaScript_static.LAWSTAR_ATTMENTS);
        return "_js_update/_lawstar_attments_update";
    }
    //附件修改
    /*
    下一步
    写出到js文件中 覆盖

    新功能 记录脚本代码到session中 由用户决定是否加载session中的脚本
    */
    @RequestMapping(value = "/lawstar_attments_update_upd",method = RequestMethod.POST)
    public String lawstar_attments_update_upd(@RequestParam("title") String title,Model model){
        boolean flag = true;
        Tool_file toolFile = new Tool_file();
        try {
            String filePath = toolFile.getFilePathUseProjectUri("js/lawstar_attments.js");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath,false),"UTF-8");
            writer.write(title);
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        JavaScript_static javaScriptStatic = new JavaScript_static();
        try {
            //重新加载js文件
            javaScriptStatic.setLawstar_attments();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("lawstar_attachment",JavaScript_static.LAWSTAR_ATTMENTS);
        return "_js_update/_lawstar_attments_update";
    }

    @RequestMapping("/lawstar_common_update")
    public String lawstar_common_update(Model model){
        model.addAttribute("lawstar_common", JavaScript_static.LAWSTARLIB_JS);
        return "_js_update/_lawstar_common_update";
    }
    @RequestMapping(value = "/lawstar_common_update_upd",method = RequestMethod.POST)
    public String lawstar_common_update_upd(@RequestParam("title") String title,Model model){
        boolean flag = true;
        Tool_file toolFile = new Tool_file();
        try {
            String filePath = toolFile.getFilePathUseProjectUri("js/lawstarlib.js");
/*            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath,false),"UTF-8");
            writer.write(title);
            writer.close();*/
            Tools.writeFile(filePath,title,"UTF-8");
        }catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        JavaScript_static javaScriptStatic = new JavaScript_static();
        try {
            //重新加载js文件
            javaScriptStatic.setLawstarlibJs();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("lawstar_common",JavaScript_static.LAWSTARLIB_JS);
        return "_js_update/_lawstar_common_update";
    }
}
