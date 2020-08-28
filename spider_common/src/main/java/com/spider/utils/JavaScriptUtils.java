package com.spider.utils;

import com.spider.javascript.Entry;
import com.spider.javascript.ImgEntry;
import com.spider.javascript.TwicedEntry;
import com.spider.javascript.ValidEntry;

import javax.script.*;

/**
 * java执行javaScript代码的工具类
 *
 * @author gongmengen
 */
public class JavaScriptUtils {

    public String entry(String str,String javaScript) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String result = "";

            // 传入FileReader对象读取js文件
                engine.eval(javaScript);
            if (engine instanceof Invocable) {
                Invocable invocable = (Invocable) engine;
                Entry executeMethod = invocable.getInterface(Entry.class);
                result = executeMethod.entry(str);
            }

        return result;
    }

    //质量检查脚本
    public String validEntry(String title,String appDate,String numTxt,String depcode,String deptName,String dbsType,String AttachStr,String src_code,String txt,String txt_code,String javaScript) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String result = "";

        // 传入FileReader对象读取js文件
        engine.eval(javaScript);
        if (engine instanceof Invocable) {
            Invocable invocable = (Invocable) engine;
            ValidEntry executeMethod = invocable.getInterface(ValidEntry.class);
            result = executeMethod.validEntry(title,appDate,numTxt,depcode,deptName,dbsType,AttachStr,src_code,txt,txt_code);
        }

        return result;
    }

    //二次检查脚本
    public String twicedEntry(String title,String appDate,String numTxt,String depcode,String deptName,String dbsType,String AttachStr,String src_code,String txt,String javaScript) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String result = "";

        // 传入FileReader对象读取js文件
        engine.eval(javaScript);
        if (engine instanceof Invocable) {
            Invocable invocable = (Invocable) engine;
            TwicedEntry executeMethod = invocable.getInterface(TwicedEntry.class);
            result = executeMethod.twicedEntry(title,appDate,numTxt,depcode,deptName,dbsType,AttachStr,src_code,txt);
        }

        return result;
    }

    //二次检查脚本
    public String imgEntry(String title,String appDate,String numTxt,String depcode,String deptName,String dbsType,String AttachStr,String src_code,String txt,String txt_code,String javaScript) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String result = "";

        // 传入FileReader对象读取js文件
        engine.eval(javaScript);
        if (engine instanceof Invocable) {
            Invocable invocable = (Invocable) engine;
            ImgEntry executeMethod = invocable.getInterface(ImgEntry.class);
            result = executeMethod.imgEntry(title,appDate,numTxt,depcode,deptName,dbsType,AttachStr,src_code,txt,txt_code);
        }

        return result;
    }

}
