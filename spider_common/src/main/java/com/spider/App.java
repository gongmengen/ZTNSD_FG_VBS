package com.spider;

import com.spider.javascript.Entry;
import com.spider.utils.JavaScriptUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        String javaScript = "//lawstar basic js lib for law deal 2019-7-14 by yjs ,Beijing.\n" +
                "/*\n" +
                "v1.03 针对税务局优化脚本。\n" +
                "v1.04 40263 国家发展和改革委员会。 优化部门\n" +
                "v1.05 40308 国家财政部。 优化部门\n" +
                "v1.06 40308 国家财政部。 不同栏目\n" +
                "v1.07 40369 生态环境部。 不同栏目、\n" +
                "v1.08 40362 商务部。 不同栏目\n" +
                "v1.09 交通运输部。 不同栏目\n" +
                "v1.10 自然资源部\n" +
                "v1.10.03 重新适配税务局，使用新的代码，13.42-14.10,=22分钟，。\n" +
                "v1.11 科技部，17.10-17.23=13分钟，。\n" +
                "v1.12 民政部，13.53-14.12=19分钟。\n" +
                "v1.13 农业部，17.15-17.50=30分钟，。正文排版\n" +
                "v1.14 四川省人民政府办公厅，2019-8-26 11.46-\n" +
                "v1.15 上海市人民政府办公厅，2019-8-26 18.00-\n" +
                "v1.16 广西人民政府办公厅，2019-8-26 18.08- 17\n" +
                "v1.17 陕西人民政府办公厅，2019-8-27 16.39-\n" +
                "v1.18 河北省人民政府，2019-8-28 17.42\n" +
                "v1.19 宁夏回族自治区人民政府 2019-8-30 17.50-17.56\n" +
                "v1.20 青岛政务网 2019-9-3 11.41- 51, 10分钟。\n" +
                "v1.21 贵州生人民政府 2019-9-4 17.12-22 , 10分钟。\n" +
                "v1.22 教育部 2019-9-17 18.18-29 , 10分钟。\n" +
                "v1.23 人力资源部 2019-9-19 18.12- , 10分钟。\n" +
                "v1.23 市场监管总局 2019-9-29 15.35- , 10分钟。\n" +
                "*/\n" +
                "//36格子\n" +
                "var space_36 = \"                                    \";\n" +
                "//6格子\n" +
                "var space_6 = \"      \";\n" +
                "//4格子\n" +
                "var space_4 = \"    \";\n" +
                "//2格子\n" +
                "var space_2 = \"  \";\n" +
                "var br_str = \"\\r\\n\";\n" +
                "\n" +
                "//入口函数,全部使用小写字母\n" +
                "function entry(str) {\n" +
                "    \n" +
                "   // str = str.toLowerCase();\n" +
                "    str =getContent(str)  //  getTitle_fgw getAppdate_sfb getreleaseDate_useAppdate wenhao getContent  getAttach\n" +
                "    // getAppdate   getTitle_fgw getreleaseDate wenhao  wenhao_special  getContent getContent_jtb  getAttach getAttach_before getTitle  // getAppdate_sfb    getContent   getAttach_qd\n" +
                "    return str; \n" +
                "}\n" +
                "\n" +
                "String.prototype.replaceAll = function (s1, s2) {\n" +
                "    return this.replace(new RegExp(s1, \"gm\"), s2);\n" +
                "}\n" +
                "//字符串对象添加一个toCharArray的方法\n" +
                "String.prototype.indexOf_lawstar = function (tag, attrib,start_idx) {//查找标签 和属性\n" +
                "    var find_idx=-1;\n" +
                "    var str = this;\n" +
                "    start_idx = typeof  start_idx != 'undefined' ?  start_idx : 0;\n" +
                "    if(str==null || tag==null ||attrib==null || str.length==0  || tag.length==0 || attrib.length==0) return find_idx;\n" +
                "    \n" +
                "    var start_pos_tag = str.indexOf(tag,start_idx);\n" +
                "    while(start_pos_tag>-1) {\n" +
                "        var end_pos_tag = str.indexOf(\">\",start_pos_tag);\n" +
                "        if(end_pos_tag>-1){\n" +
                "              var searchStr = str.substring(start_pos_tag,end_pos_tag+1);\n" +
                "              var attrib_pos = searchStr.indexOf(attrib);\n" +
                "             // console.log(\"find searchStr = \"+searchStr);\n" +
                "              if(attrib_pos>-1){\n" +
                "                //  console.log(\"find attrib_pos = \"+attrib_pos);\n" +
                "                  find_idx = start_pos_tag;\n" +
                "                  break;\n" +
                "              }\n" +
                "        }\n" +
                "        start_pos_tag = str.indexOf(tag,start_pos_tag+1);\n" +
                "    }\n" +
                "    return find_idx;\n" +
                "}\n" +
                "String.prototype.lastIndexOf_lawstar = function (tag, attrib,start_idx) {//查找最后标签 和属性\n" +
                "    var find_idx=-1\n" +
                "    var str = this;\n" +
                "    start_idx = typeof  start_idx != 'undefined' ?  start_idx : 0;\n" +
                "    if(str==null || tag==null ||attrib==null || str.length==0  || tag.length==0 || attrib.length==0) return find_idx;\n" +
                "    \n" +
                "    var start_pos_tag = start_idx;\n" +
                "\n" +
                "    while((start_pos_tag=str.indexOf(tag,start_pos_tag))>-1) {\n" +
                "        var end_pos_tag = str.indexOf(\">\",start_pos_tag);\n" +
                "        if(end_pos_tag>-1){\n" +
                "              var searchStr = str.substring(start_pos_tag,end_pos_tag+1);\n" +
                "              var attrib_pos = searchStr.indexOf(attrib);\n" +
                "              if(attrib_pos>-1){\n" +
                "                //  console.log(\"find attrib_pos = \"+attrib_pos);\n" +
                "                  find_idx = start_pos_tag;\n" +
                "                  \n" +
                "              }\n" +
                "        }\n" +
                "        start_pos_tag++;\n" +
                "    }\n" +
                "    return find_idx;\n" +
                "}\n" +
                "\n" +
                "String.prototype.replace_lawstar = function (tag, attrib,rpStr) {//查找并替换标签 和属性，并替换该标签\n" +
                "    var find_idx=-1;\n" +
                "    var str = this;\n" +
                "    if(str==null || tag==null ||attrib==null || str.length==0  || tag.length==0 || attrib.length==0) return str;\n" +
                "   \n" +
                "    var start_pos_tag = str.indexOf(tag);\n" +
                "    if(start_pos_tag>-1) {\n" +
                "        var end_pos_tag = str.indexOf(\">\",start_pos_tag);\n" +
                "        if(end_pos_tag>-1){\n" +
                "              var searchStr = str.substring(start_pos_tag,end_pos_tag+1);\n" +
                "             \n" +
                "              var attrib_pos = searchStr.indexOf(attrib);\n" +
                "              if(attrib_pos>-1){\n" +
                "                \n" +
                "                  str =str.substring(0,start_pos_tag)+rpStr+str.substring(end_pos_tag+1);\n" +
                "                   \n" +
                "              }\n" +
                "        }\n" +
                "    }\n" +
                "    return str;\n" +
                "}\n" +
                "String.prototype.replaceAll_lawstar = function (tag, attrib,rpStr) {//查找并替换所有标签 和属性，并替换该标签\n" +
                "    var find_idx=-1;\n" +
                "    var str = this;\n" +
                "   // console.log(\"this==\"+this)\n" +
                "    //console.log(\"this position==\"+this.indexOf(\"<p align=\\\"right\\\"\"));\n" +
                "    if(str==null || tag==null ||attrib==null || str.length==0  || tag.length==0 || attrib.length==0) return find_idx;\n" +
                "    var start_pos_tag = -1;\n" +
                "    while((start_pos_tag=str.indexOf(tag,start_pos_tag))>-1) {\n" +
                "        var end_pos_tag = str.indexOf(\">\",start_pos_tag);\n" +
                "        if(end_pos_tag>-1){\n" +
                "            var searchStr = str.substring(start_pos_tag,end_pos_tag+1);\n" +
                "           // console.log(\"find searchStr = \"+searchStr);\n" +
                "            var attrib_pos = searchStr.indexOf(attrib);\n" +
                "            if(attrib_pos>-1){\n" +
                "             //   console.log(\"find attrib_pos = \"+attrib_pos);\n" +
                "                str =str.substring(0,start_pos_tag)+rpStr+str.substring(end_pos_tag+1);\n" +
                "               // console.log(\"str= \"+str);\n" +
                "                 }\n" +
                "          }\n" +
                "        start_pos_tag++;\n" +
                "       // console.log(\"start_pos_tag==\"+start_pos_tag)\n" +
                "    }\n" +
                "    return str;\n" +
                "}\n" +
                "\n" +
                "//查找开始标签和结束标签,返回匹配的标签位置\n" +
                "String.prototype.findTagPostion = function (tag_start, attrib,tag_end) {//查找标签 和属性,结束标签\n" +
                "    var start_pos_tag=-1;\n" +
                "    var tag_end_find_idx=-1;//结束标签位置\n" +
                "    var idx_arr  =new Array(2);\n" +
                "    idx_arr[0] = start_pos_tag;\n" +
                "    idx_arr[1] = tag_end_find_idx;\n" +
                "    var str = this;\n" +
                "  \n" +
                "    if(str==null || tag_start==null ||attrib==null || tag_end==null || str.length==0  || tag_start.length==0 || attrib.length==0 || tag_end.length==0) return idx_arr;\n" +
                "  \n" +
                "    start_pos_tag = str.indexOf(tag_start);\n" +
                "   \n" +
                "    while(start_pos_tag>-1) {\n" +
                "        var end_pos_tag = str.indexOf(\">\",start_pos_tag);\n" +
                "        if(end_pos_tag>-1){\n" +
                "              var searchStr = str.substring(start_pos_tag,end_pos_tag+1);\n" +
                "              var attrib_pos = searchStr.indexOf(attrib);\n" +
                "              if(attrib_pos>-1){\n" +
                "               //   console.log(\"find attrib_pos = \"+attrib_pos);\n" +
                "                  find_idx = start_pos_tag;\n" +
                "                  break;\n" +
                "              }\n" +
                "        }\n" +
                "        start_pos_tag = str.indexOf(tag_start,start_pos_tag+1);\n" +
                "    }\n" +
                "    if(start_pos_tag>-1){\n" +
                "          //寻找匹配标签，基本算法，找到结束标签，查看这段字符是否有相等的开始标签和结束标签，有，找到结果，没有，继续\n" +
                "        tag_end_find_idx = str.indexOf(tag_end,start_pos_tag);\n" +
                "        while(tag_end_find_idx>-1) {\n" +
                "            //统计这这段字符的开始标签和结束标签\n" +
                "            var searchStr = str.substring(start_pos_tag,tag_end_find_idx+tag_end.length);\n" +
                "            //console.log(\"searchStr = \"+searchStr);\n" +
                "            var count_start_tag = countStr(searchStr,tag_start);\n" +
                "           // console.log(\"count_start_tag = \"+count_start_tag);\n" +
                "            var count_end_tag = countStr(searchStr,tag_end);\n" +
                "           // console.log(\"count_end_tag = \"+count_end_tag);\n" +
                "            if(count_start_tag==count_end_tag){\n" +
                "               // console.log(\"find tag_end = \"+tag_end_find_idx);\n" +
                "                break;\n" +
                "            }\n" +
                "            tag_end_find_idx = str.indexOf(tag_end,tag_end_find_idx+1);\n" +
                "        }\n" +
                "    } \n" +
                "    idx_arr[0] = find_idx;\n" +
                "    idx_arr[1] = tag_end_find_idx;\n" +
                "    return idx_arr;\n" +
                "}\n" +
                "String.prototype.toCharArray = function () {\n" +
                "    var arr = new Array();\n" +
                "    for (var index = 0; index < this.length; index++) {\n" +
                "        arr[index] = this.charAt(index);\n" +
                "    }\n" +
                "    return arr;\n" +
                "}\n" +
                "//标题,\n" +
                "function getTitle(str) {  \n" +
                "    start_token = \"名称</td>\";\n" +
                "    end_token = \"</td>\";\n" +
                "    var idx = str.indexOf(start_token);\n" +
                "    var idx_2 = str.indexOf(end_token, idx+start_token.length);\n" +
                "    var title = \"\";\n" +
                "    if(idx>-1 && idx_2>-1 ){\n" +
                "        title = str.substring(idx + start_token.length, idx_2);\n" +
                "        title = replaceAllHtlm(title);\n" +
                "    }\n" +
                "    \n" +
                "    return title.trim();\n" +
                "}\n" +
                "//标题,发改委，标题里面有文号，处理掉\n" +
                "function getTitle_fgw(str) {  \n" +
                "    start_token = \"<div class=\\\"ctitle\\\">\";\n" +
                "    end_token = \"</div>\";\n" +
                "    var idx = str.indexOf(start_token);\n" +
                "    var idx_2 = str.indexOf(end_token, idx);\n" +
                "    var title = \"\";\n" +
                "    if(idx>-1 && idx_2>-1 ){\n" +
                "        title = str.substring(idx + start_token.length, idx_2);\n" +
                "        title = replaceAllHtlm(title);\n" +
                "        if(title.length>0){\n" +
                "            idx = title.search(\"- 中华人民共和国教育部\");\n" +
                "            if(idx>0){\n" +
                "                title = title.substring(0,idx);\n" +
                "                title = title.replaceAll(br_str,\"\");\n" +
                "                title = title.trim();\n" +
                "               // idx = title.indexOf(\"省\");\n" +
                "                //if(idx==0){\n" +
                "               //     title = \"贵州\"+title;\n" +
                "                //}\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "    }\n" +
                "    \n" +
                "    return title.trim();\n" +
                "}\n" +
                "//发布日期\n" +
                "function formatDateStr(str){\n" +
                "\n" +
                "    if((str.indexOf(\"年\")>-1 && str.indexOf(\"月\")>-1 && str.indexOf(\"日\")>-1)  ||str.indexOf(\"-\")>-1){\n" +
                "        var dateArr  = getDigit(str);\n" +
                "        \n" +
                "        if(dateArr[1].length==1) dateArr[1] = \"0\"+dateArr[1];\n" +
                "        if(dateArr[2].length==1) dateArr[2] = \"0\"+dateArr[2];\n" +
                "        datestr =  dateArr[0]+dateArr[1]+dateArr[2];\n" +
                "        str = datestr;\n" +
                "       // return datestr;\n" +
                "    }\n" +
                "   str = str.replace(\"年\", \"\");\n" +
                "    str = str.replace(\"月\", \"\");\n" +
                "    str = str.replace(\"日\", \"\");\n" +
                "    str = str.replaceAll(\"-\", \"\");\n" +
                "    return str;\n" +
                "}\n" +
                "function getAppdate(str) {\n" +
                "    start_token = \"发布时间：\";\n" +
                "    end_token = \"</div>\";\n" +
                "    idx = str.indexOf(start_token)\n" +
                "    idx_2 = str.indexOf(end_token, idx+start_token.length)\n" +
                "    var dateStr=\"\";\n" +
                "    if(idx>-1 && idx_2>-1 ){\n" +
                "        dateStr = str.substring(idx + start_token.length, idx_2)\n" +
                "        dateStr = replaceAllHtlm(dateStr);\n" +
                "        dateStr = formatDateStr(dateStr);\n" +
                "    }\n" +
                "    \n" +
                "   \n" +
                "    return dateStr.trim();\n" +
                "}\n" +
                "//发布日期 商务部\n" +
                "function getAppdate_sfb(str) {\n" +
                "    start_token = \"<p \";\n" +
                "    var start_token_atrrib = \"\";\n" +
                "    end_token = \"</p>\";\n" +
                "    str = str.toLowerCase();\n" +
                "    //验证是否存在\" align=\\\"right\\\"\"\n" +
                "    if(str.indexOf(\"align=\\\"right\\\"\")>-1){\n" +
                "        start_token_atrrib=\" align=\\\"right\\\"\";\n" +
                "    }else{\n" +
                "        start_token_atrrib=\" align=\\\"center\\\"\";\n" +
                "    }\n" +
                "    idx = str.lastIndexOf_lawstar(start_token,start_token_atrrib)\n" +
                "    idx_2 = str.indexOf(end_token, idx);\n" +
                "    str = str.substring(idx, idx_2)\n" +
                "    //console.log(\"sss\"+str)\n" +
                "    str = replaceAllHtlm(str);\n" +
                "    var datestr =\"\";\n" +
                "    if(str.indexOf(\"年\")>-1 && str.indexOf(\"月\")>-1 && str.indexOf(\"日\")>-1  ){\n" +
                "        var dateArr  = getDigit(str);\n" +
                "        \n" +
                "        if(dateArr[1].length==1) dateArr[1] = \"0\"+dateArr[1];\n" +
                "        if(dateArr[2].length==1) dateArr[2] = \"0\"+dateArr[2];\n" +
                "        datestr =  dateArr[0]+dateArr[1]+dateArr[2];\n" +
                "       // return datestr;\n" +
                "    }\n" +
                "    \n" +
                "\n" +
                "    datestr = datestr.replace(\"年\", \"\");\n" +
                "    datestr = datestr.replace(\"月\", \"\");\n" +
                "    datestr = datestr.replace(\"日\", \"\");\n" +
                "    datestr = datestr.replaceAll(\"-\", \"\");\n" +
                "    return datestr.trim();\n" +
                "}\n" +
                "\n" +
                "//发布日期 trs编辑器\n" +
                "function getAppdate_trs(str) {\n" +
                "    str = getContent_trs_NoDealtxt(str);\n" +
                "    start_token = \"<p \";\n" +
                "    start_token_atrrib=\"right\";\n" +
                "    end_token = \"</p>\";\n" +
                "    str = str.toLowerCase();\n" +
                "    idx = str.lastIndexOf_lawstar(start_token,start_token_atrrib)\n" +
                "    idx_2 = str.indexOf(end_token, idx);\n" +
                "    str = str.substring(idx, idx_2)\n" +
                "    \n" +
                "    str = replaceAllHtlm(str);\n" +
                "    var datestr =\"\";\n" +
                "    if(str.indexOf(\"年\")>-1 && str.indexOf(\"月\")>-1 && str.indexOf(\"日\")>-1  ){\n" +
                "        var dateArr  = getDigit(str);\n" +
                "        if(dateArr[1].length==1) dateArr[1] = \"0\"+dateArr[1];\n" +
                "        if(dateArr[2].length==1) dateArr[2] = \"0\"+dateArr[2];\n" +
                "        datestr =  dateArr[0]+dateArr[1]+dateArr[2];\n" +
                "       // return datestr;\n" +
                "    }\n" +
                "    \n" +
                "\n" +
                "    datestr = datestr.replace(\"年\", \"\");\n" +
                "    datestr = datestr.replace(\"月\", \"\");\n" +
                "    datestr = datestr.replace(\"日\", \"\");\n" +
                "    datestr = datestr.replaceAll(\"-\", \"\");\n" +
                "    return datestr.trim();\n" +
                "}\n" +
                "//发布日期 财政部\n" +
                "function getAppdate_czb(str) {\n" +
                "    start_token = \"<p align=\\\"right\\\"\";\n" +
                "    end_token = \"</p>\";\n" +
                "    str = str.toLowerCase();\n" +
                "    idx = str.lastIndexOf(start_token)\n" +
                "    idx_2 = str.indexOf(end_token, idx)\n" +
                "    str = str.substring(idx + start_token.length, idx_2)\n" +
                "    str = replaceAllHtlm(str);\n" +
                "    var datestr =\"\";\n" +
                "    if(str.indexOf(\"年\")>-1 && str.indexOf(\"月\")>-1 && str.indexOf(\"日\")>-1  ){\n" +
                "        var dateArr  = getDigit(str);\n" +
                "        \n" +
                "        if(dateArr[1].length==1) dateArr[1] = \"0\"+dateArr[1];\n" +
                "        if(dateArr[2].length==1) dateArr[2] = \"0\"+dateArr[2];\n" +
                "        datestr =  dateArr[0]+dateArr[1]+dateArr[2];\n" +
                "       // return datestr;\n" +
                "    }\n" +
                "    \n" +
                "\n" +
                "    datestr = datestr.replace(\"年\", \"\");\n" +
                "    datestr = datestr.replace(\"月\", \"\");\n" +
                "    datestr = datestr.replace(\"日\", \"\");\n" +
                "    datestr = datestr.replaceAll(\"-\", \"\");\n" +
                "    return datestr.trim();\n" +
                "}\n" +
                "//实施日期\n" +
                "function getreleaseDate(str) {\n" +
                "    start_token = \"<td><b>成文日期：</b></td>\";\n" +
                "    end_token = \"<td><b>标　　题：</b></td>\";\n" +
                "    str = str.toLowerCase();\n" +
                "    idx = str.lastIndexOf(start_token)\n" +
                "    idx_2 = str.indexOf(end_token, idx)\n" +
                "    str = str.substring(idx + start_token.length, idx_2)\n" +
                "  //  console.log(\"-----------\"+idx,idx_2,str)\n" +
                "    str = replaceAllHtlm(str);\n" +
                "    var datestr =\"\";\n" +
                "    if(str.indexOf(\"年\")>-1 && str.indexOf(\"月\")>-1 && str.indexOf(\"日\")>-1  ){\n" +
                "        var dateArr  = getDigit(str);\n" +
                "        \n" +
                "        if(dateArr[1].length==1) dateArr[1] = \"0\"+dateArr[1];\n" +
                "        if(dateArr[2].length==1) dateArr[2] = \"0\"+dateArr[2];\n" +
                "        datestr =  dateArr[0]+dateArr[1]+dateArr[2];\n" +
                "       // return datestr;\n" +
                "    }\n" +
                "    \n" +
                "\n" +
                "    datestr = datestr.replace(\"年\", \"\");\n" +
                "    datestr = datestr.replace(\"月\", \"\");\n" +
                "    datestr = datestr.replace(\"日\", \"\");\n" +
                "    datestr = datestr.replaceAll(\"-\", \"\");\n" +
                "    return datestr.trim();\n" +
                "\n" +
                "}\n" +
                " \n" +
                "//实施日期\n" +
                "function getreleaseDate_useAppdate(str) {\n" +
                "     return getAppdate(str);\n" +
                "\n" +
                "}\n" +
                "//文号 发改委\n" +
                "function wenhao_fffff(str) { \n" +
                "    start_token = \"<div><span>文　　号</span>\";\n" +
                "    end_token = \"</div>\";\n" +
                "    var idx = str.indexOf(start_token);\n" +
                "    var idx_2 = str.indexOf(end_token, idx);\n" +
                "    var wenHao_str = \"\";\n" +
                "    if(idx>-1 && idx_2>-1 ){\n" +
                "        wenHao_str = str.substring(idx + start_token.length, idx_2);\n" +
                "        wenHao_str = replaceAllHtlm(wenHao_str);\n" +
                "        if(wenHao_str.length>0){\n" +
                "            idx = wenHao_str.search(\"\\\\(发改办*\");\n" +
                "            if(idx>0){\n" +
                "                wenHao_str = wenHao_str.substring(idx+1,wenHao_str.length-1);\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "    }\n" +
                "    return wenHao_str.trim();\n" +
                "}\n" +
                "\n" +
                "function deal_wenhao(str){\n" +
                "    str = str.replaceAll(\"〔\",\"[\");\n" +
                "    str = str.replaceAll(\"〕\",\"]\");\n" +
                "    str = str.replaceAll(br_str,\"\");\n" +
                "    str = str.replaceAll(\"\\n\",\"\");\n" +
                "    str = str.replaceAll(\"、\",\" \");\n" +
                "    str = replaceAllHtlm(str);\n" +
                "    return str;\n" +
                "}\n" +
                "//文号税务局\n" +
                "function wenhao(str) { \n" +
                "    // str = iGetInnerText(str);\n" +
                "    start_token = \"第\";\n" +
                "    end_token = \"号\";\n" +
                "    var idx = str.indexOf(start_token);\n" +
                "    var idx_2 = str.indexOf(end_token, idx+start_token.length);\n" +
                "    var wenHao_str = \"\";\n" +
                "    if(idx>-1 && idx_2>-1){\n" +
                "        wenHao_str = str.substring(idx+start_token.length-1, idx_2+1);\n" +
                "        wenHao_str = replaceAllHtlm(wenHao_str);\n" +
                "        wenHao_str= wenHao_str.replace(\"无\",\"\");\n" +
                "        wenHao_str= wenHao_str.replaceAll(\" \",\"\");\n" +
                "       // wenHao_str= wenHao_str.replaceAll(\"\t\",\"\");\n" +
                "        wenHao_str = deal_wenhao(wenHao_str);\n" +
                "    }\n" +
                "   \n" +
                "    return wenHao_str.trim();\n" +
                "}\n" +
                "//文号农业部\n" +
                "function wenhao_nyb(str) { \n" +
                "    str = getTitle_fgw(str);\n" +
                "    start_token = \"中华人民共和国农业农村部\";\n" +
                "    end_token = \"号\";\n" +
                "    var idx = str.indexOf(start_token);\n" +
                "    var idx_2 = str.indexOf(end_token, idx+start_token.length);\n" +
                "    var wenHao_str = \"\";\n" +
                "    if(idx>-1 && idx_2>-1){\n" +
                "        wenHao_str = str;\n" +
                "        wenHao_str = replaceAllHtlm(wenHao_str);\n" +
                "        wenHao_str= wenHao_str.replace(\"无\",\"\");\n" +
                "        wenHao_str = deal_wenhao(wenHao_str);\n" +
                "    }\n" +
                "   \n" +
                "    return wenHao_str.trim();\n" +
                "}\n" +
                "//发布日期 特殊处理\n" +
                "function wenhao_special(str) {\n" +
                "    first_token =\"<p style=\\\"text-align:center;\\\">\";\n" +
                "    first_idx = str.indexOf(first_token);\n" +
                "    if(first_idx==-1) return \"\";\n" +
                "    start_token = \"<strong>\";\n" +
                "    start_token_atrrib=\"\";\n" +
                "    end_token = \"</strong>\";\n" +
                "    idx = str.indexOf_lawstar(start_token,start_token_atrrib,first_idx);\n" +
                "    idx_2 = str.indexOf(end_token, idx);\n" +
                "     if(idx==-1 || idx_2==-1) {\n" +
                "         return\"\" ;\n" +
                "    }\n" +
                "\n" +
                "   \n" +
                "    str_tmp = str.substring(idx, idx_2)\n" +
                "   //console.log(\"sss\"+str)\n" +
                "   str_tmp = replaceAllHtlm(str_tmp);\n" +
                "    var datestr =\"\";\n" +
                "    if(str_tmp.indexOf(\"号\")>-1 ){\n" +
                "        datestr = str_tmp;\n" +
                "    } \n" +
                "    return datestr.trim();\n" +
                "}\n" +
                "//发布日期 商务部 民政部\n" +
                "function wenhao_mzb(str) {\n" +
                "    str = str.toLowerCase();\n" +
                "    first_token =\"<p \";\n" +
                "    //first_idx = str.indexOf(first_token);\n" +
                "    first_idx = str.indexOf_lawstar(first_token,\"id=\\\"zoom\\\"\",0);\n" +
                "   \n" +
                "    if(first_idx==-1) return \"\";\n" +
                "    start_token = \"<p \";\n" +
                "    start_token_atrrib=\"center\";\n" +
                "    end_token = \"</p>\";\n" +
                "    idx = str.indexOf_lawstar(start_token,start_token_atrrib,first_idx);\n" +
                "   // console.log(idx)\n" +
                "    idx_2 = str.indexOf(end_token, idx)\n" +
                "    if(idx==-1 || idx_2==-1) return \"\";\n" +
                "    str = str.substring(idx, idx_2)\n" +
                "   // console.log(\"sss\"+str)\n" +
                "    str = replaceAllHtlm(str);\n" +
                "    var datestr =\"\";\n" +
                "    if(str.indexOf(\"号\")>-1 ){\n" +
                "        datestr = str;\n" +
                "        datestr = deal_wenhao(datestr);\n" +
                "    }\n" +
                "    return datestr.trim();\n" +
                "}\n" +
                "\n" +
                "//发布日期 商务部 民政部\n" +
                "function wenhao_trs(str) {\n" +
                "    str = str.toLowerCase();\n" +
                "    first_token =\"<div \";\n" +
                "    //first_idx = str.indexOf(first_token);\n" +
                "    first_idx = str.indexOf_lawstar(first_token,\"xlcontainer\",0);\n" +
                "   \n" +
                "    if(first_idx==-1) return \"\";\n" +
                "    start_token = \"<p \";\n" +
                "    start_token_atrrib=\"center\";\n" +
                "    end_token = \"</p>\";\n" +
                "    idx = str.indexOf_lawstar(start_token,start_token_atrrib,first_idx);\n" +
                "   // console.log(idx)\n" +
                "    idx_2 = str.indexOf(end_token, idx)\n" +
                "    if(idx==-1 || idx_2==-1) return \"\";\n" +
                "    str = str.substring(idx, idx_2)\n" +
                "   // console.log(\"sss\"+str)\n" +
                "    str = replaceAllHtlm(str);\n" +
                "    var datestr =\"\";\n" +
                "    if(str.indexOf(\"号\")>-1 ){\n" +
                "        datestr = str;\n" +
                "        datestr = deal_wenhao(datestr);\n" +
                "    }\n" +
                "    return datestr.trim();\n" +
                "}\n" +
                "//正文 发改委\n" +
                "function getContent(str) {\n" +
                "    start_token =\"<div class=\\\"ccontent center\\\" id=\\\"con_con\\\"\";\n" +
                "    end_token = \"</div>\";\n" +
                "    idx = str.indexOf(start_token)\n" +
                "    idx_2 = str.indexOf(end_token, idx + start_token.length);\n" +
                "    //console.log(\"2222\"+idx_2);\n" +
                "    str = str.substring(idx, idx_2);\n" +
                "    \n" +
                "\n" +
                "\n" +
                "    return deal_all_text(str);\n" +
                "\n" +
                "}\n" +
                "\n" +
                "//正文，交通部，标签区间方法\n" +
                "function getContent_jtb(str) {\n" +
                "    var start_token =\"<div\";\n" +
                "    var attach_str=\"Zoom\";\n" +
                "    var end_token = \"</div>\";\n" +
                "    var idx_arr = str.findTagPostion(start_token,attach_str,end_token);\n" +
                "    idx = idx_arr[0];\n" +
                "    idx_2 = idx_arr[1];\n" +
                "   // console.log(\"idx=\" + idx_arr[0]);\n" +
                "   // console.log(\"idx _end=\" + idx_arr[1]);\n" +
                "    str = str.substring(idx, idx_2);\n" +
                "  // console.log(\"bbbb=\"+str)\n" +
                "    return deal_all_text(str);\n" +
                "}\n" +
                "\n" +
                "//正文，交通部，标签区间方法 使用trs编辑器\n" +
                "function getContent_trs(str) {\n" +
                "    var start_token =\"<div\";\n" +
                "    var attach_str=\"arc_body\";\n" +
                "    var end_token = \"</div>\";\n" +
                "    var idx_arr = str.findTagPostion(start_token,attach_str,end_token);\n" +
                "    idx = idx_arr[0];\n" +
                "    idx_2 = idx_arr[1];\n" +
                "   // console.log(\"idx=\" + idx_arr[0]);\n" +
                "   // console.log(\"idx _end=\" + idx_arr[1]);\n" +
                "    str = str.substring(idx, idx_2);\n" +
                "    return deal_all_text(str);\n" +
                "}\n" +
                "//正文，交通部，标签区间方法 使用trs编辑器,未排版\n" +
                "function getContent_trs_NoDealtxt(str) {\n" +
                "    var start_token =\"<div\";\n" +
                "    var attach_str=\"TRS_Editor\";\n" +
                "    var end_token = \"</div>\";\n" +
                "    var idx_arr = str.findTagPostion(start_token,attach_str,end_token);\n" +
                "    idx = idx_arr[0];\n" +
                "    idx_2 = idx_arr[1];\n" +
                "   // console.log(\"idx=\" + idx_arr[0]);\n" +
                "   // console.log(\"idx _end=\" + idx_arr[1]);\n" +
                "    str = str.substring(idx, idx_2);\n" +
                "    return str;\n" +
                "}\n" +
                "//附件\n" +
                "function getAttach(str) {\n" +
                "    start_token = \"附件\";\n" +
                "    end_token = \"</div>\";\n" +
                "    var attach_str = \"\";\n" +
                "    idx = str.indexOf(start_token)\n" +
                "    idx_2 = str.indexOf(end_token, idx + start_token.length)\n" +
                "    if(idx>-1 && idx_2>-1){\n" +
                "        str = str.substring(idx + start_token.length, idx_2)\n" +
                "        var start_token = \"href=\\\"\";\n" +
                "        var end_token = \"\\\"\";\n" +
                "        var firstA = \">\";\n" +
                "        var lastA = \"</a>\";\n" +
                "        while ((idx = str.indexOf(start_token)) > -1) {\n" +
                "            idx_2 = str.indexOf(end_token, idx + start_token.length);\n" +
                "            link = str.substring(idx + start_token.length, idx_2);\n" +
                "            str = str.substring(idx_2 + end_token.length);\n" +
                "            idx_3 = str.indexOf(firstA,start_token);\n" +
                "            idx_4 = str.indexOf(lastA);\n" +
                "            name = str.substring(idx_3+1, idx_4);\n" +
                "            str = str.substring(idx_3 + lastA.length);\n" +
                "            attach_str = attach_str + link + \"//\" + name + \"##\"\n" +
                "\n" +
                "        }\n" +
                "    }\n" +
                "    attach_str = replaceAllHtlm(attach_str);\n" +
                "    return attach_str.trim();\n" +
                "}\n" +
                "//附件在a标签后面的\n" +
                "\n" +
                "function getAttach_before(str) {\n" +
                "    start_token = \"附件\";\n" +
                "    end_token = \"</div>\";\n" +
                "    var attach_str = \"\";\n" +
                "    idx = str.indexOf(start_token)\n" +
                "    idx_2 = str.indexOf(end_token, idx + start_token.length)\n" +
                "    if(idx>-1 && idx_2>-1){\n" +
                "        str = str.substring(idx-100 + start_token.length, idx_2)\n" +
                "        var start_token = \"href=\\\"\";\n" +
                "        var end_token = \"\\\"\";\n" +
                "        var firstA = \">\";\n" +
                "        var lastA = \"</a>\";\n" +
                "        while ((idx = str.indexOf(start_token)) > -1) {\n" +
                "            idx_2 = str.indexOf(end_token, idx + start_token.length);\n" +
                "            link = str.substring(idx + start_token.length, idx_2);\n" +
                "            str = str.substring(idx_2 + end_token.length);\n" +
                "            idx_3 = str.indexOf(firstA,start_token);\n" +
                "            idx_4 = str.indexOf(lastA);\n" +
                "            name = str.substring(idx_3+1, idx_4);\n" +
                "            str = str.substring(idx_3 + lastA.length);\n" +
                "            attach_str = attach_str + link + \"//\" + name + \"##\"\n" +
                "\n" +
                "        }\n" +
                "    }\n" +
                "    attach_str = replaceAllHtlm(attach_str);\n" +
                "    return attach_str.trim();\n" +
                "}\n" +
                "//附件 青岛\n" +
                "function getAttach_qd(str) {\n" +
                "    start_token = \"附件\";\n" +
                "    end_token = \"</div>\";\n" +
                "    var attach_str = \"\";\n" +
                "    idx = str.indexOf(start_token)\n" +
                "    idx_2 = str.indexOf(end_token, idx + start_token.length)\n" +
                "    if(idx>-1 && idx_2>-1){\n" +
                "        str = str.substring(idx + start_token.length, idx_2)\n" +
                "        var start_token = \"src=\\\"\";\n" +
                "        var end_token = \"\\\"\";\n" +
                "        var firstA = \">\";\n" +
                "        var lastA = \"</p>\";\n" +
                "        var count =1;\n" +
                "        while ((idx = str.indexOf(start_token)) > -1) {\n" +
                "            idx_2 = str.indexOf(end_token, idx + start_token.length);\n" +
                "            link = str.substring(idx + start_token.length, idx_2);\n" +
                "            str = str.substring(idx_2 + end_token.length);\n" +
                "            idx_3 = str.indexOf(firstA,start_token);\n" +
                "            idx_4 = str.indexOf(lastA);\n" +
                "            name = str.substring(idx_3+1, idx_4);\n" +
                "            str = str.substring(idx_3 + lastA.length);\n" +
                "            if(name.length==0) name = \"附件\"+count++;\n" +
                "            attach_str = attach_str + link + \"//\" + name + \"##\"\n" +
                "\n" +
                "        }\n" +
                "    }\n" +
                "    attach_str = replaceAllHtlm(attach_str);\n" +
                "    return attach_str.trim();\n" +
                "}\n" +
                "\n" +
                "//居中标签适配\n" +
                "//<p style=\"text-align: center\">\n" +
                "/*\n" +
                "function align_center(txt){\n" +
                "    txt = txt.replace(\"<p align=justify>      \", \"\");//发改委处理空6个空格问题\n" +
                "    txt = txt.replace(\"<p align=\\\"justify\\\">      \", \"\");//发改委处理空6个空格问题\n" +
                "    txt = txt.replaceAll(\"<p align=center>\", space_6);\n" +
                "    txt = txt.replaceAll(\"<p align='center>'\", space_6);\n" +
                "    txt = txt.replaceAll(\"<p align=\\\"center\\\">\", space_6);\n" +
                "    txt = txt.replaceAll(\"<div align=center>\", space_6);\n" +
                "    txt = txt.replaceAll(\"<div align=center>\", space_6);\n" +
                "    txt = txt.replaceAll(\"<p style=\\\"text-align: center\\\">\", \"<p style=\\\"text-align:center\\\">\");\n" +
                "    txt = txt.replaceAll(\"<p style=\\\"text-align:center\\\">\",space_6);\n" +
                "    return txt;\n" +
                "}\n" +
                "*/\n" +
                "\n" +
                "//替换标签\n" +
                "function replaceAllHtlm(str) {\n" +
                "    var reTag = /<(?:.|\\s)*?>/g;\n" +
                "    str = str.replaceAll(\"&nbsp;\", \" \");\n" +
                "    str = str.replaceAll(\"</br>\", \"\\r\\n\");\n" +
                "    str = str.replaceAll(\"<br />\", \"\\r\\n\");\n" +
                "    str = str.replaceAll(\"<p>\", \"\\r\\n\");\n" +
                "    str = str.replaceAll(\"<br>\", \"\\r\\n\");\n" +
                "    str = str.replaceAll(\"</p>\", \"\\r\\n\");\n" +
                "    str = str.replace(/<script.*?>.*?<\\/script>/ig, '');\n" +
                "    str = str.replace(/<script[^>]*>([\\s\\S](?!<script))*?<\\/script>/ig, '');\n" +
                "    str = str.replace(/<style[^>]*>([\\s\\S](?!<style))*?<\\/style>/ig, '');\n" +
                "    str = str.replaceAll(\"&#8220;\", \"“\");\n" +
                "    str = str.replaceAll(\"&#8221;\", \"”\");\n" +
                "    str = str.replaceAll(\"　\", \"  \");\n" +
                "    str = str.replaceAll(\"&ldquo;\", \"“\");\n" +
                "    str = str.replaceAll(\"&rdquo;\", \"”\");\n" +
                "    str =str.replace(reTag, \"\")\n" +
                "    str = str.replaceAll(\"-->\", \"\");\n" +
                "    return str;\n" +
                "}\n" +
                "//替换居中、居右标签，同时增加前置空格\n" +
                "function replaceBlock(txt,start_token,end_token,spaceX,removeHtmlTag){\n" +
                "    removeHtmlTag = typeof  removeHtmlTag != 'undefined' ?  removeHtmlTag : true;\n" +
                "    var last_pos = -1;\n" +
                "    var current_pos = -1;\n" +
                "    var first_add = false;\n" +
                "    var last_add = false;\n" +
                "    while ((current_pos = txt.indexOf(start_token, current_pos)) > -1) {\n" +
                "      //  console.log(\"current_pos--\"+current_pos)\n" +
                "        endLine_pos = txt.indexOf(end_token, current_pos)\n" +
                "        //新的部门处理\n" +
                "        if (endLine_pos> 1) { //发现，去标签，增加空格\n" +
                "            var newStr = txt.substring(current_pos, endLine_pos);\n" +
                "            if (removeHtmlTag){\n" +
                "                newStr = replaceAllHtlm(newStr); //移除标签\n" +
                "                newStr = spaceX+newStr;\n" +
                "                txt = txt.substring(0,current_pos)+newStr+txt.substring(endLine_pos+end_token.length);\n" +
                "            }else{\n" +
                "                newStr = spaceX+newStr;\n" +
                "                txt = txt.substring(0,current_pos)+newStr+txt.substring(endLine_pos);\n" +
                "            }\n" +
                "\n" +
                "        }\n" +
                "       current_pos = current_pos + start_token.length;\n" +
                "\n" +
                "    }\n" +
                "    return txt;\n" +
                "}\n" +
                "\n" +
                "//替换居中、居右标签，同时增加前置空格\n" +
                "function removeBlock(txt,start_token,end_token,spaceX){\n" +
                "    var last_pos = -1;\n" +
                "    var current_pos = -1;\n" +
                "    var first_add = false;\n" +
                "    var last_add = false;\n" +
                "    while ((current_pos = txt.indexOf(start_token, current_pos)) > -1) {\n" +
                "        endLine_pos = txt.indexOf(end_token, current_pos)\n" +
                "        //新的部门处理\n" +
                "        if (endLine_pos> 1) { //发现，去标签，增加空格\n" +
                "            var newStr = txt.substring(current_pos, endLine_pos);\n" +
                "            newStr = spaceX;   \n" +
                "           // console.log(\"--\"+newStr)\n" +
                "            txt = txt.substring(0,current_pos)+newStr+txt.substring(endLine_pos+end_token.length);\n" +
                "\n" +
                "        }\n" +
                "       current_pos = current_pos + start_token.length;\n" +
                "\n" +
                "    }\n" +
                "    return txt;\n" +
                "}\n" +
                "// 插入函数\n" +
                "//参数说明：strSrc表示原字符串变量，addStr表示要插入的字符串，pos表示要插入的位置\n" +
                "function insertStr(strSrc, addStr, pos) {\n" +
                "    if (pos > strSrc.length) return strSrc + addStr;\n" +
                "    if (pos <= 0) return addStr + strSrc;\n" +
                "    strSrc = strSrc.substring(0, pos) + addStr + strSrc.substring(pos);\n" +
                "    return strSrc;\n" +
                "}\n" +
                "// 统计字符串数量函数\n" +
                "//参数说明：strSrc表示原字符串变量，searchStr表示要统计的字符串\n" +
                "function countStr(strSrc, searchStr) {\n" +
                "    var pos = 0;\n" +
                "    var count = 0;\n" +
                "    while ((pos = strSrc.indexOf(searchStr, pos)) > -1) {\n" +
                "        pos = pos + searchStr.length;\n" +
                "        count++;\n" +
                "    }\n" +
                "\n" +
                "    return count;\n" +
                "}\n" +
                "//取字符窜里的数字到整形数组里\n" +
                "function getDigit(str) {\n" +
                "    var tempStrArr = new Array();\n" +
                "    var chr = str.toCharArray();\n" +
                "    var tempV = new Object();\n" +
                "    tempV.add = function (key, value) { this[key] = value }\n" +
                "    tempV.get = function (key) { return this[key] }\n" +
                "    tempV.size = function () { return Object.keys(tempV).length - 3 }\n" +
                "    var tempStr = \"\";\n" +
                "    var bl = false;\n" +
                "    var idx = 0;\n" +
                "    for (var i = 0; i < chr.length; i++) {\n" +
                "        if (isDigit(chr[i])) {\n" +
                "            if (!bl) {\n" +
                "                if (tempStr.length > 0) {\n" +
                "                    tempV.add(idx++, tempStr);\n" +
                "                }\n" +
                "                tempStr = \"\";\n" +
                "                tempStr = chr[i];\n" +
                "                bl = true;\n" +
                "            }\n" +
                "            else {\n" +
                "                tempStr += chr[i];\n" +
                "            }\n" +
                "        }\n" +
                "        else {\n" +
                "            bl = false;\n" +
                "\n" +
                "        }\n" +
                "    }\n" +
                "    //最后再添加\n" +
                "    if ((tempStr.length > 0)) {\n" +
                "        tempV.add(idx++, tempStr);\n" +
                "    }\n" +
                "    tempStrArr = new Array(tempV.size());\n" +
                "    for (var j = 0; j < tempV.size(); j++) {\n" +
                "        tempStrArr[j] = tempV.get(j);\n" +
                "    }\n" +
                "    return tempStrArr;\n" +
                "}\n" +
                "//9、判断是否为数字类型\n" +
                "function isDigit(value) {\n" +
                "    var patrn = /^[0-9]*$/;\n" +
                "    if (patrn.exec(value) == null || value == \"\") {\n" +
                "        return false\n" +
                "    } else {\n" +
                "        return true\n" +
                "    }\n" +
                "}\n" +
                "/**\n" +
                "   *把数字转换成大写汉字\n" +
                "   * @param c 需要转换的字符\n" +
                "   * @return 成功返回对应的整数汉字\n" +
                "   */\n" +
                "function ToChineseDigit(c) {\n" +
                "    var result = \"\";\n" +
                "    switch (c) {\n" +
                "        case '0':\n" +
                "            result = \"零\";\n" +
                "            break;\n" +
                "        case '1':\n" +
                "            result = \"一\";\n" +
                "            break;\n" +
                "        case '2':\n" +
                "            result = \"二\";\n" +
                "            break;\n" +
                "        case '3':\n" +
                "            result = \"三\";\n" +
                "            break;\n" +
                "        case '4':\n" +
                "            result = \"四\";\n" +
                "            break;\n" +
                "        case '5':\n" +
                "            result = \"五\";\n" +
                "            break;\n" +
                "        case '6':\n" +
                "            result = \"六\";\n" +
                "            break;\n" +
                "        case '7':\n" +
                "            result = \"七\";\n" +
                "            break;\n" +
                "        case '8':\n" +
                "            result = \"八\";\n" +
                "            break;\n" +
                "        case '9':\n" +
                "            result = \"九\";\n" +
                "            break;\n" +
                "    }\n" +
                "    return result;\n" +
                "}\n" +
                "/**\n" +
                " * 乘权运算反运算 100 --》百\n" +
                " * @param  需要转换的整形\n" +
                " * @return 中文单位\n" +
                " */\n" +
                "function intToChar(dd) {\n" +
                "    var result = \"\";\n" +
                "    switch (dd) {\n" +
                "        case 10:\n" +
                "            result = \"十\";\n" +
                "            break;\n" +
                "        case 100:\n" +
                "            result = \"百\";\n" +
                "            break;\n" +
                "        case 1000:\n" +
                "            result = \"千\";\n" +
                "            break;\n" +
                "        case 10000:\n" +
                "            result = \"万\";\n" +
                "            break;\n" +
                "\n" +
                "    }\n" +
                "    return result;\n" +
                "}\n" +
                "\n" +
                "function toInt(number) {\n" +
                "    return number * 1 | 0 || 0;\n" +
                "}\n" +
                "/**\n" +
                "   * 数字转换成对应大写整数 101 -->一百零一\n" +
                "   * @param dd\n" +
                "   * @return\n" +
                "   */\n" +
                "function DigitToTxt(dd) {\n" +
                "    if (dd >= 10 && dd < 20) { //如果是在10-19之间特殊处理\n" +
                "        if (dd == 10) {\n" +
                "            return \"十\";\n" +
                "        }\n" +
                "        else {\n" +
                "            return \"十\" +\n" +
                "                ToChineseDigit((dd + \"\").charAt(1));\n" +
                "        }\n" +
                "    }\n" +
                "    var ddStr = dd + \"\";\n" +
                "    var result = \"\";\n" +
                "    var zeroStr = \"\";\n" +
                "    for (var i = 0; i < ddStr.length; i++) {\n" +
                "\n" +
                "        if (ddStr.charAt(ddStr.length - 1 - i) == '0') {\n" +
                "            if (i != 0 && !result.equals(\"\")) {\n" +
                "                zeroStr = \"零\";\n" +
                "            }\n" +
                "            continue;\n" +
                "        }\n" +
                "        result = ToChineseDigit(ddStr.charAt(ddStr.length - 1 - i)) + intToChar(toInt(Math.pow(10.0, i))) + zeroStr + result;\n" +
                "        zeroStr = \"\";\n" +
                "    }\n" +
                "    return result;\n" +
                "}\n" +
                "\n" +
                "// 字符串转16进制\n" +
                "function str2hex(str){\n" +
                "    if(str === \"\"){\n" +
                "      return \"\";\n" +
                "    }\n" +
                "    var arr = [];\n" +
                "    arr.push(\"0x\");\n" +
                "    for(var i=0;i<str.length;i++){\n" +
                "      arr.push(str.charCodeAt(i).toString(16));\n" +
                "    }\n" +
                "    return arr.join('');\n" +
                "  }\n" +
                "// 16进制转字符串\n" +
                "// \n" +
                "function hex2str(hex) {\n" +
                "    　　var trimedStr = hex.trim();\n" +
                "    　　var rawStr = trimedStr.substr(0,2).toLowerCase() === \"0x\" ? trimedStr.substr(2) : trimedStr;\n" +
                "    　　var len = rawStr.length;\n" +
                "    　　if(len % 2 !== 0) {\n" +
                "    　　　　alert(\"Illegal Format ASCII Code!\");\n" +
                "    　　　　return \"\";\n" +
                "    　　}\n" +
                "    　　var curCharCode;\n" +
                "    　　var resultStr = [];\n" +
                "    　　for(var i = 0; i < len;i = i + 2) {\n" +
                "    　　　　curCharCode = parseInt(rawStr.substr(i, 2), 16);\n" +
                "    　　　　resultStr.push(String.fromCharCode(curCharCode));\n" +
                "    　　}\n" +
                "    　　return resultStr.join(\"\");\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "//正文预处理\n" +
                "function deal_prepared(txt){\n" +
                "  //  txt = txt.toLowerCase();\n" +
                "   // txt = txt.replaceAll(\"四川省人民政府<br>\"+br_str+\"<br>\"+br_str, \"四川省人民政府\");\n" +
                "    txt = txt.replaceAll(\"　\", \"  \");\n" +
                "    txt = txt.replaceAll(\"   \", \"    \");\n" +
                "    txt = txt.replaceAll(\" \", \" \");\n" +
                "  //  txt = txt.replaceAll(\"    \", \"\");\n" +
                "    txt = txt.replaceAll(\"\\n\", br_str);\n" +
                "    txt = txt.replaceAll(\"&nbsp;\", \" \");\n" +
                "\n" +
                "    txt = txt.replaceAll(hex2str(\"0x09\"), \"    \");\n" +
                "    txt = replaceBlock(txt,\"<p style=\",\"</p>\",br_str,false);// p 前面增加回车换行\n" +
                "    txt = replaceBlock(txt,\"<div \",\"</div>\",br_str,false);// p 前面增加回车换行\n" +
                "    return txt;\n" +
                "}\n" +
                "//查询日期，判断是否是日期类型行\n" +
                "function isDateStr(str){\n" +
                "    var start_y = str.indexOf(\"年\");\n" +
                "    var start_m = str.indexOf(\"月\");\n" +
                "    var start_d = str.indexOf(\"日\");\n" +
                "    if(start_y>-1 && start_m>-1 && start_d>-1){\n" +
                "        return true;\n" +
                "    }else{\n" +
                "        return false;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "//多行居中标签替换，包括BR等。\n" +
                "function align_center_moreLine(txt,start_token,end_token){\n" +
                "    var  start_token_idx = txt.lastIndexOf(start_token);\n" +
                "    if(start_token_idx>0){\n" +
                "        var  end_token_idx = txt.indexOf(end_token,start_token_idx+1);\n" +
                "        if (end_token_idx>0){\n" +
                "            align_str = txt.substring(start_token_idx,end_token_idx);\n" +
                "           // console.log(\"align_str=\"+align_str)\n" +
                "             align_str = replaceAllHtlm(align_str);\n" +
                "            var tmp_str_arr = align_str.split(br_str);\n" +
                "            align_str =\"\";\n" +
                "            for (var xx = 0; xx < tmp_str_arr.length; xx++) {\n" +
                "                tmp_str_arr [xx] =  space_6 +tmp_str_arr[xx].trim()+br_str;\n" +
                "                align_str = align_str+tmp_str_arr [xx];\n" +
                "            }\n" +
                "            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx);\n" +
                "        }\n" +
                "\n" +
                "    }\n" +
                "    return txt; \n" +
                "    \n" +
                "}\n" +
                "//多行居中标签替换，包括BR等。\n" +
                "function align_center_moreLineAll(txt,start_token,end_token){\n" +
                "    var  start_token_idx = txt.indexOf(start_token);\n" +
                "    while(start_token_idx>-1){\n" +
                "      //  console.log(\"txte=\"+txt)\n" +
                "        var  end_token_idx = txt.indexOf(end_token,start_token_idx+1);\n" +
                "       \n" +
                "        if (end_token_idx>0){\n" +
                "            align_str = txt.substring(start_token_idx,end_token_idx);\n" +
                "           // console.log(\"align_str=\"+align_str)\n" +
                "             align_str = replaceAllHtlm(align_str);\n" +
                "            var tmp_str_arr = align_str.split(br_str);\n" +
                "            align_str =\"\";\n" +
                "            for (var xx = 0; xx < tmp_str_arr.length; xx++) {\n" +
                "                tmp_str_arr [xx] =  space_6 +tmp_str_arr[xx].trim()+br_str;\n" +
                "                align_str = align_str+tmp_str_arr [xx];\n" +
                "            }\n" +
                "            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx);\n" +
                "        }\n" +
                "        start_token_idx = txt.indexOf(start_token,start_token_idx+1);\n" +
                "    }\n" +
                "    return txt; \n" +
                "    \n" +
                "}\n" +
                "//居中标签适配\n" +
                "//<p style=\"text-align: center\">\n" +
                "function align_center(txt){\n" +
                "  \n" +
                "    txt = align_center_moreLine(txt,\"<p align=\\\"center\\\">\",\"</p>\");//多行居右处理\n" +
                "    txt = align_center_moreLineAll(txt,\"<p style=\\\"TEXT-ALIGN: center\\\">\",\"</p>\");//多行居右处理\n" +
                "    txt = txt.replaceAll(\"<p align=center>\", space_6);\n" +
                "    txt = txt.replaceAll(\"<p align='center>'\", space_6);\n" +
                "    txt = txt.replaceAll(\"<h3 style=\\\"margin-bottom:14px;\\\">\", space_6);//自然资源部\n" +
                "   \n" +
                "    txt = txt.replaceAll(\"<p align=\\\"center\\\">\", space_6);\n" +
                "    txt = txt.replaceAll(\"<div align=center>\", space_6);\n" +
                "    txt = txt.replaceAll(\"<div align=center>\", space_6);\n" +
                "    txt = txt.replaceAll(\"<p style=\\\"text-align: center\\\">\", \"<p style=\\\"text-align:center\\\">\");\n" +
                "    txt = txt.replaceAll(\"<p style=\\\"text-align:center\\\">\",space_6);\n" +
                "    txt = replaceBlock(txt,\"<p align=\\\"center\\\"\",\"</p>\",space_6);\n" +
                "    txt = txt.replaceAll_lawstar(\"<p \",\"center\",space_6);\n" +
                "    txt = txt.replaceAll_lawstar(\"<div \",\"center\",space_6);\n" +
                "    txt = txt.replaceAll_lawstar(\"<p \",\"mso-char-indent-count\",space_4);\n" +
                "    return txt;\n" +
                "}\n" +
                "//段落开头标签适配 一般空四个\n" +
                "//<p style=\"text-align: center\">\n" +
                "function align_left(txt){\n" +
                "    txt = txt.replaceAll_lawstar(\"<p \",\"mso-char-indent-count\",space_4);\n" +
                "    txt = txt.replaceAll_lawstar(\"<p \",\"text-indent\",space_4);\n" +
                "    txt = replaceBlock(txt,\"<p align=\\\"justify\\\">\",\"</p>\",br_str);\n" +
                "   // console.log(\"txt===========\"+txt)\n" +
                "    txt = replaceBlock(txt,\"<p class\",\"</p>\",br_str);\n" +
                "    txt = replaceBlock(txt,\"<p style=\",\"</p>\",br_str);\n" +
                "    return txt;\n" +
                "}\n" +
                "//多行居右标签替换，包括BR等。\n" +
                "function align_right_moreLine(txt,start_token,end_token){\n" +
                "    var  start_token_idx = txt.indexOf(start_token);\n" +
                "    if(start_token_idx>0){\n" +
                "        var  end_token_idx = txt.indexOf(end_token,start_token_idx);\n" +
                "        if (end_token_idx>0){\n" +
                "            align_str = txt.substring(start_token_idx,end_token_idx);\n" +
                "             align_str = replaceAllHtlm(align_str);\n" +
                "            var tmp_str_arr = align_str.split(br_str);\n" +
                "            align_str =\"\";\n" +
                "            for (var xx = 0; xx < tmp_str_arr.length; xx++) {\n" +
                "                tmp_str_arr [xx] =  space_36 +tmp_str_arr[xx].trim()+br_str;\n" +
                "                align_str = align_str+tmp_str_arr [xx];\n" +
                "            }\n" +
                "            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx);\n" +
                "        }\n" +
                "\n" +
                "    }\n" +
                "    return txt; \n" +
                "    \n" +
                "}\n" +
                "//多行居右标签替换，包括BR等。替换所有\n" +
                "function align_right_moreLineAll(txt,start_token,end_token){\n" +
                "    var  start_token_idx = txt.indexOf(start_token);\n" +
                "    while(start_token_idx>0){\n" +
                "        var  end_token_idx = txt.indexOf(end_token,start_token_idx);\n" +
                "        if (end_token_idx>0){\n" +
                "            align_str = txt.substring(start_token_idx,end_token_idx);\n" +
                "             align_str = replaceAllHtlm(align_str);\n" +
                "            var tmp_str_arr = align_str.split(br_str);\n" +
                "            align_str =\"\";\n" +
                "            for (var xx = 0; xx < tmp_str_arr.length; xx++) {\n" +
                "                tmp_str_arr [xx] =  space_36 +tmp_str_arr[xx].trim()+br_str;\n" +
                "                align_str = align_str+tmp_str_arr [xx];\n" +
                "            }\n" +
                "            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx);\n" +
                "        }\n" +
                "        start_token_idx = txt.indexOf(start_token,start_token_idx+1);\n" +
                "    }\n" +
                "    return txt; \n" +
                "    \n" +
                "}\n" +
                "//多行居右标签替换，包括BR等。替换所有,属性关键字查找\n" +
                "function align_right_moreLineAll_TAG(txt,start_token_tag,end_token,attribStr){\n" +
                "   // console.log(\"  find =\"+start_token_tag);\n" +
                "    var  start_token_idx = txt.indexOf(start_token_tag);\n" +
                "    //console.log(\"  find =\"+start_token_idx);\n" +
                "    while(start_token_idx>-1){\n" +
                "        var close_tag_idx = txt.indexOf(\">\",start_token_idx);\n" +
                "      //  console.log(\"  close_tag_idx =\"+close_tag_idx);\n" +
                "        if(close_tag_idx >-1){\n" +
                "            align_str = txt.substring(start_token_idx,close_tag_idx+1);\n" +
                "            \n" +
                "            if(align_str.search(attribStr)==-1){\n" +
                "               \n" +
                "                start_token_idx = txt.indexOf(start_token_tag,start_token_idx+1);\n" +
                "               // console.log(\"  start_token_idx ccc =\"+start_token_idx);\n" +
                "                continue;\n" +
                "            }\n" +
                "        }\n" +
                "        var  end_token_idx = txt.indexOf(end_token,close_tag_idx);\n" +
                "        if (end_token_idx>0){\n" +
                "            align_str = txt.substring(start_token_idx,end_token_idx);\n" +
                "            \n" +
                "             align_str = replaceAllHtlm(align_str);\n" +
                "            var tmp_str_arr = align_str.split(br_str);\n" +
                "            align_str =\"\";\n" +
                "            for (var xx = 0; xx < tmp_str_arr.length; xx++) {\n" +
                "                tmp_str_arr [xx] =  space_36 +tmp_str_arr[xx].trim()+br_str;\n" +
                "                align_str = align_str+tmp_str_arr [xx];\n" +
                "            }\n" +
                "            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx);\n" +
                "        }\n" +
                "        start_token_idx = txt.indexOf(start_token_tag,start_token_idx+2);\n" +
                "        //console.log(\"  start_token_idx =\"+start_token_idx);\n" +
                "\n" +
                "\n" +
                "    }\n" +
                "    return txt; \n" +
                "    \n" +
                "}\n" +
                "//一行居右标签替换，包括BR等。\n" +
                "function align_right_oneLine(txt,start_token,end_token){\n" +
                "    var  start_token_idx = txt.indexOf(start_token);\n" +
                "    if(start_token_idx>0){\n" +
                "        var  end_token_idx = txt.indexOf(end_token,start_token_idx);\n" +
                "        if (end_token_idx>0){\n" +
                "            align_str = txt.substring(start_token_idx,end_token_idx);\n" +
                "            align_str = replaceAllHtlm(align_str);\n" +
                "            var tmp_str_arr = align_str.split(br_str);\n" +
                "            align_str =\"\";\n" +
                "            for (var xx = 0; xx < tmp_str_arr.length; xx++) {            \n" +
                "                align_str = align_str+tmp_str_arr[xx].trim();\n" +
                "            }\n" +
                "             \n" +
                "           if(align_str.length>0){\n" +
                "                align_str =space_36+ align_str+br_str;\n" +
                "            }\n" +
                "            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx);\n" +
                "        }\n" +
                "\n" +
                "    }\n" +
                "    return txt; \n" +
                "    \n" +
                "}\n" +
                "// 居右标签适配\n" +
                "//<p style=\"text-align: center\">\n" +
                "function align_right(txt){\n" +
                "    txt = align_right_moreLineAll_TAG(txt,\"<p \",\"</p>\",\"align=[\\\"']?right[\\\"']?\");//多行居右处理\n" +
                "    txt = align_right_moreLineAll_TAG(txt,\"<P \",\"</P>\",\"align=[\\\"']?right[\\\"']?\");//多行居右处理\n" +
                "    txt = align_right_moreLineAll_TAG(txt,\"<div \",\"</div>\",\"right\");//多行居右处理\n" +
                "    //txt = align_right_moreLineAll_TAG(txt,\"<P \",\"</P>\",\"right\");//多行居右处理\n" +
                "    txt = align_right_moreLineAll_TAG(txt,\"<DIV \",\"</DIV>\",\"right\");//多行居右处理\n" +
                "    //txt = align_right_oneLine(txt,\"<p style=\\\"text-align:right;\\\">\",\"</p>\");//一行居右处理\n" +
                "    /*  txt = align_right_moreLine(txt,\"<p align=\\\"right\\\">\",\"</p>\");//多行居右处理\n" +
                "    txt = txt.replaceAll(\"<p align=right>\", space_36);\n" +
                "    txt = txt.replaceAll(\"<p align='right'>\", space_36);\n" +
                "    txt = txt.replaceAll(\"<p align=\\\"right\\\">\", space_36);\n" +
                "    txt = txt.replaceAll(\"<div align=right>\", space_36);\n" +
                "    txt = txt.replace(\"<p align=justify>            \", \"\");\n" +
                "    txt = txt.replaceAll(\"text-align: right\",\"text-align:right\");\n" +
                "    txt = txt.replaceAll(\"<p style=\\\"text-align: right\\\">\",\"<p style=\\\"text-align:right\\\">\");\n" +
                "    txt = txt.replaceAll(\"<p style=\\\"text-align: right;\\\">\",\"<p style=\\\"text-align:right\\\">\");\n" +
                "    \n" +
                "    txt = align_right_moreLine(txt,\"<p style=\\\"text-align:right\\\">\",\"</p>\");//多行居右处理\n" +
                "    txt = align_right_oneLine(txt,\"<p style=\\\"text-align:right\\\">\",\"</p>\");//一行居右处理\n" +
                "     //可以多次处理，调用这个方法\n" +
                "    //居右处理,以空格\n" +
                "    var start36_token=\"<p style=\\\"text-align: right\\\" align=\\\"right\\\">\";\n" +
                "    var end36_token=\"</p>\";\n" +
                "    txt = align_right_moreLine(txt,start36_token,end36_token);//多行居右处理\n" +
                "    txt = align_right_oneLine(txt,start36_token,end36_token);//一行居右处理\n" +
                "    start36_token=\"<p style=\\\"TEXT-ALIGN: right\\\">\";\n" +
                "    end36_token=\"</p>\";\n" +
                "  // txt =align_right_moreLineAll(txt,start36_token,end36_token);//\n" +
                "    //居右处理,以空格\n" +
                "     start36_token=\"<p style=\\\"TEXT-ALIGN: right\\\">\";\n" +
                "     end36_token=\"</p>\";\n" +
                "    txt = align_right_moreLine(txt,start36_token,end36_token);//多行居右处理\n" +
                "\n" +
                "    txt = txt.replaceAll(\"<p style=\\\"text-align:right\\\">\",space_36);\n" +
                "    txt = txt.replaceAll_lawstar(\"<p \",\"align:right\",space_36);\n" +
                "    txt = txt.replaceAll_lawstar(\"<div \",\"align:right\",space_36);\n" +
                "    txt = txt.replaceAll_lawstar(\"<p \",\"align=right\",space_36);\n" +
                "    txt = txt.replaceAll_lawstar(\"<div \",\"align=right\",space_36);\n" +
                "    */\n" +
                "    return txt;\n" +
                "}\n" +
                "//处理正文附件标题\n" +
                "function deal_attach_titles(txt){\n" +
                "    var fujian_token=\"附件：\";\n" +
                "    var end_token = \"</div>\";\n" +
                "    var start_2  = txt.indexOf(fujian_token);\n" +
                "     \n" +
                "    if (start_2 >= 0) {\n" +
                "       var start_3 = txt.indexOf(end_token, start_2);\n" +
                "        if (start_3 >= 0) {\n" +
                "            var tmp_str = txt.substring(start_2, start_3);\n" +
                "            var tmp_str_bak = tmp_str;\n" +
                "            tmp_str = replaceAllHtlm(tmp_str);\n" +
                "            var tmp_str_arr = tmp_str.split(br_str);\n" +
                "            var tmp_str_ok = \"\";\n" +
                "            for (var xx = 0; xx < tmp_str_arr.length; xx++) {\n" +
                "                if (tmp_str_arr[xx].trim().length > 0) {\n" +
                "                    if(xx==0){\n" +
                "                        tmp_str_ok = tmp_str_arr[xx].trim() + br_str;\n" +
                "                    }else{\n" +
                "                        tmp_str_ok = tmp_str_ok  + space_4+tmp_str_arr[xx].trim() + br_str;\n" +
                "                    }\n" +
                "                    \n" +
                "                }\n" +
                "\n" +
                "            }\n" +
                "            tmp_str_ok = tmp_str_ok.replaceAll(\"[*]\", \"×\");\n" +
                " \n" +
                "            var fj_pos = tmp_str_ok.indexOf(fujian_token);\n" +
                "            if(fj_pos>-1){\n" +
                "                tmp_str_ok =  insertStr(tmp_str_ok,br_str+space_4,fj_pos+fujian_token.length)\n" +
                "            }\n" +
                "            \n" +
                "             txt = txt.replaceAll(tmp_str_bak, tmp_str_ok);\n" +
                "          } \n" +
                "       \n" +
                "    }//end 处理 附件\n" +
                "    return txt;\n" +
                "}\n" +
                "//处理正文章节条函数\n" +
                "function deal_paragraph(txt){\n" +
                "      /*\n" +
                "      处理基本算法， \n" +
                "      1、如果是目录，跳过，目录基本判断，连续是章节，中间没有正文\n" +
                "      2、章节的处理。6个空格，上下空行，基本判断 第字开头， 章 或者 节 空格，中间文字不超过 5个字符，第一百四十五条\n" +
                "      3、条的处理 前面空4个，后面 空2个\n" +
                "      4、最后在处理目录问题，如果发现连续出现章节的，已经排版好的，删除空行\n" +
                "      */\n" +
                "\n" +
                "     //console.log(\"bbb txt\"+txt);\n" +
                "     var tmp_str_arr = txt.split(br_str);\n" +
                "     txt = \"\";\n" +
                "     var maxLen =6;//第字 和章节条之间的字符数量\n" +
                "     //处理\n" +
                "     /*strtiao = Replace(strtiao, \"条　\", \"条  \")\n" +
                "      strtiao = Replace(strtiao, \"章　\", \"章  \")\n" +
                "      strtiao = Replace(strtiao, \"章 \", \"章  \")\n" +
                "      strtiao = Replace(strtiao, \"章   \", \"章  \")*/\n" +
                "      var str_di=\"第\";\n" +
                "      var str_zhang=\"章\";\n" +
                "      var str_jie=\"节\";\n" +
                "      var str_tiao=\"条\";\n" +
                "      var MaxStrLen = 5;//中间文字不超过 5个字符，第一百四十五条\n" +
                "     for (var xx = 0; xx < tmp_str_arr.length; xx++) {\n" +
                "         if (tmp_str_arr[xx].trim().length > 0) {\n" +
                "         //    console.log(\"-----------\"+tmp_str_arr[xx])\n" +
                "            //先看章\n" +
                "            var start_di =tmp_str_arr[xx].indexOf(str_di);\n" +
                "            var start_zhang =tmp_str_arr[xx].indexOf(str_zhang);\n" +
                "            var start_jie =tmp_str_arr[xx].indexOf(str_jie);\n" +
                "            var start_tiao =tmp_str_arr[xx].indexOf(str_tiao);\n" +
                "            //先完成开发，然后在考虑优化，\n" +
                "            if(start_di>0){//有第字\n" +
                "               if(start_zhang>0 && start_di<start_zhang && (start_zhang-start_di)<=MaxStrLen&&  start_zhang>start_jie && start_zhang>start_tiao  ){//章处理，有章字 章 字 必须在节 和条的前面，才算，而且中间不能大于字符  &&  tmp_str_arr[xx].substring(start_di,start_zhang).length>MaxStrLen\n" +
                "                 // console.log(\"有第 MM 章\");\n" +
                "                  //在章后面加上2个英文空格\n" +
                "                  var str_z_tmp = tmp_str_arr[xx].substring(0,start_zhang+1);\n" +
                "                  tmp_str_arr[xx] = str_z_tmp +space_2+tmp_str_arr[xx].substring(start_zhang+1).trim();\n" +
                "                  //看看后面是否有空行，有就不用增加\n" +
                "                  if((xx+1)<tmp_str_arr.length &&  tmp_str_arr[xx+1].trim().length==0){//有换行，不加\n" +
                "                    tmp_str_arr[xx] = tmp_str_arr[xx].trim() ;//先删除空格，在补充  //然后6空格， \n" +
                "                  }else{\n" +
                "                    tmp_str_arr[xx] = tmp_str_arr[xx].trim() + br_str;//先删除空格，在补充  //然后6空格，前后空行\n" +
                "                  }\n" +
                "                 \n" +
                "                  //看看前面是否已经有空行了，有就不用添加\n" +
                "                  if((xx-1)>=0 &&  tmp_str_arr[xx-1].trim().length==0){//有换行，不加\n" +
                "                    tmp_str_arr[xx] = space_6 + tmp_str_arr[xx];\n" +
                "                  }else{\n" +
                "                    tmp_str_arr[xx] = br_str+space_6 + tmp_str_arr[xx];\n" +
                "                  }\n" +
                "                  \n" +
                "\n" +
                "               }else if(start_jie>0  && start_di<start_jie && (start_jie-start_di)<=MaxStrLen && start_jie>start_tiao){//有节字\n" +
                "                  // console.log(\"有第 MM 节\");\n" +
                "                   //在节后面加上2个英文空格\n" +
                "                  var str_z_tmp = tmp_str_arr[xx].substring(0,start_jie+1);\n" +
                "                  tmp_str_arr[xx] = str_z_tmp +space_2+tmp_str_arr[xx].substring(start_jie+1).trim();\n" +
                "                  tmp_str_arr[xx] = tmp_str_arr[xx].trim() + br_str;//先删除空格，在补充  //然后6空格\n" +
                "                  tmp_str_arr[xx] = br_str+space_6 + tmp_str_arr[xx];\n" +
                "               }else if(start_tiao>0  && start_di<start_tiao && (start_tiao-start_di)<=MaxStrLen ){//有条字\n" +
                "                  // console.log(\"有第 MM 条\");\n" +
                "                   //在条后面加上2个英文空格\n" +
                "                  var str_z_tmp = tmp_str_arr[xx].substring(0,start_tiao+1);\n" +
                "                  tmp_str_arr[xx] = str_z_tmp +space_2+tmp_str_arr[xx].substring(start_tiao+1).trim();\n" +
                "                  tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格，在补充  //然后4空格\n" +
                "                  tmp_str_arr[xx] = space_4 + tmp_str_arr[xx];\n" +
                "               }\n" +
                "\n" +
                "            }\n" +
                "\n" +
                "             txt = txt + tmp_str_arr[xx] + br_str;\n" +
                " \n" +
                "         }else{\n" +
                "           txt = txt + tmp_str_arr[xx] + br_str;\n" +
                "         }\n" +
                " \n" +
                "     }\n" +
                "     //处理完成章节，查看 如果连续两个第一章，认为是目录。\n" +
                "     //处理空行\n" +
                "     var first_zhang =   txt.indexOf(\"      第一章\");\n" +
                "     var last_zhang =txt.lastIndexOf(\"      第一章\");\n" +
                "    if(first_zhang>-1 && last_zhang>0 && last_zhang>first_zhang){//有目录\n" +
                "        var str_mulu_tmp = txt.substring(first_zhang,last_zhang);\n" +
                "        str_mulu_tmp = str_mulu_tmp.replaceAll(\"\\r\\n\\r\\n\",\"\");\n" +
                "        txt=txt.substring(0,first_zhang)+str_mulu_tmp+br_str+txt.substring(last_zhang);\n" +
                "    }\n" +
                "\n" +
                "   // console.log(\"aaaa txt=\"+txt);\n" +
                "    return (txt);\n" +
                "}\n" +
                "// 处理空行，以及针对空格处理换行\n" +
                "function deal_lines(txt){\n" +
                "    var tmp_str_arr = txt.split(br_str);\n" +
                "    txt = \"\";\n" +
                "    //处理空行\n" +
                "    for (var xx = 0; xx < tmp_str_arr.length; xx++) {\n" +
                "\n" +
                "        if (tmp_str_arr[xx].trim().length > 0) {\n" +
                "           // console.log(\"-----------\"+tmp_str_arr[xx])\n" +
                "            //处理多余空格\n" +
                "            //先36空格\n" +
                "            if (tmp_str_arr[xx].indexOf(space_6) > -1 && (tmp_str_arr[xx].length - tmp_str_arr[xx].trim().length) > 20) {\n" +
                "                tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格，在补充\n" +
                "                tmp_str_arr[xx] = space_36 + tmp_str_arr[xx];  //换行专门处理\n" +
                "            } else if (tmp_str_arr[xx].indexOf(space_6) > -1 && (tmp_str_arr[xx].length - tmp_str_arr[xx].trim().length) >= 6) {\n" +
                "                //console.log(\"-----------\"+tmp_str_arr[xx])\n" +
                "                tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格，在补充  //然后6空格\n" +
                "                tmp_str_arr[xx] = space_6 + tmp_str_arr[xx]+ br_str;\n" +
                "               // console.log(\"---ll--------\"+tmp_str_arr[xx])\n" +
                "            } else if (tmp_str_arr[xx].indexOf(space_2) > -1 && (tmp_str_arr[xx].length - tmp_str_arr[xx].trim().length) >= 2) {\n" +
                "               \n" +
                "                tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格，在补充  //最后4空格\n" +
                "                tmp_str_arr[xx] = space_4 + tmp_str_arr[xx];\n" +
                "            }else{//顶格\n" +
                "                //console.log(\"---2222222222222--------\"+tmp_str_arr[xx])\n" +
                "                tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格， \n" +
                "                tmp_str_arr[xx] = tmp_str_arr[xx];\n" +
                "            }\n" +
                "\n" +
                "            txt = txt + tmp_str_arr[xx] + br_str;\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "    }\n" +
                "    return txt;\n" +
                "}\n" +
                "//处理日期，包括日期转换为中文\n" +
                "function  deal_appDate(txt){\n" +
                "    var start_36 = 0;\n" +
                "    while ((start_36 = txt.indexOf(space_36, start_36)) > -1) {\n" +
                "\n" +
                "        var start_36_end = txt.indexOf(br_str, start_36);\n" +
                "\n" +
                "        if (start_36_end > -1) {\n" +
                "            var str_36 = txt.substring(start_36 + space_36.length, start_36_end);\n" +
                "\n" +
                "            var start_year = str_36.indexOf(\"年\");\n" +
                "            var start_mm = str_36.indexOf(\"月\", start_year);\n" +
                "            var start_dd = str_36.indexOf(\"日\", start_mm);\n" +
                "            if (start_year > -1 && start_mm > start_year && start_dd > start_mm) {//&& str_36.length()<20\n" +
                "                var digit_arr = getDigit(str_36);\n" +
                "\n" +
                "                if (digit_arr.length == 3) {\n" +
                "\n" +
                "                    //处理年\n" +
                "                    var str_36_new = \"\";\n" +
                "                    try {\n" +
                "                        //var digit_data = Integer.parseInt(digit_arr[0]);\n" +
                "                        for (var pp = 0; pp < digit_arr[0].length; pp++) {\n" +
                "                            str_36_new = str_36_new + ToChineseDigit(digit_arr[0].charAt(pp));\n" +
                "                        }\n" +
                "                        str_36_new = str_36_new + \"年\";\n" +
                "                        str_36_new = str_36_new.replaceAll(\"零\", \"○\");\n" +
                "                        //月\n" +
                "                        str_36_new = str_36_new + DigitToTxt(digit_arr[1]) + \"月\";\n" +
                "                        //日\n" +
                "                        str_36_new = str_36_new + DigitToTxt(digit_arr[2]) + \"日\";\n" +
                "                        \n" +
                "                        //加上后面的字符\n" +
                "                        var last_idx = str_36.lastIndexOf(\"日\");\n" +
                "                       \n" +
                "                        if(last_idx>0){\n" +
                "                            str_36_new = str_36_new+str_36.substr(last_idx+1);\n" +
                "                        }\n" +
                "                        txt = txt.replaceAll(str_36, str_36_new);\n" +
                "\n" +
                "                    } catch (e) {\n" +
                "                        // TODO Auto-generated catch block\n" +
                "                    }\n" +
                "\n" +
                "                }\n" +
                "\n" +
                "\n" +
                "            }\n" +
                "        }\n" +
                "        start_36++;\n" +
                "    }\n" +
                "    return txt;\n" +
                "}\n" +
                "//处理部门上下换行问题，多个部门和日期之间的换行问题\n" +
                "function deal_space36_lines(txt){\n" +
                "    var last_pos = -1;\n" +
                "    var current_pos = -1;\n" +
                "    var first_add = false;\n" +
                "    var last_add = false;\n" +
                "    while ((current_pos = txt.indexOf(space_36, current_pos)) > -1) {\n" +
                "        if (!first_add) {\n" +
                "            txt = insertStr(txt, br_str, current_pos);\n" +
                "            first_add = true;\n" +
                "            last_pos = current_pos;\n" +
                "          continue;\n" +
                "        }\n" +
                "        //新的部门处理\n" +
                "        if (current_pos - last_pos > 1) {\n" +
                "            //count br_str >=2\n" +
                "            var count_br = countStr(txt.substring(last_pos, current_pos),br_str);\n" +
                "            if (count_br >= 2) {\n" +
                "                var endLine_pos = txt.indexOf(space_36, last_pos);\n" +
                "                if (endLine_pos > -1) {\n" +
                "                    endLine_pos = txt.indexOf(br_str, endLine_pos);\n" +
                "                    if (endLine_pos > 0) {\n" +
                "                        txt = insertStr(txt, br_str, endLine_pos);\n" +
                "                        first_add = false;// 下一组\n" +
                "                        last_add = true;\n" +
                "                        current_pos = endLine_pos;\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "\n" +
                "        }\n" +
                "        last_pos = current_pos;\n" +
                "        current_pos = current_pos + space_36.length;\n" +
                "\n" +
                "    }\n" +
                "    if (first_add && !last_add) {//添加头，也需要添加尾巴\n" +
                "        current_pos = txt.indexOf(br_str, last_pos);\n" +
                "        if (current_pos > 0) txt = insertStr(txt, br_str, current_pos);\n" +
                "    }\n" +
                "    return txt;\n" +
                "}\n" +
                "\n" +
                "function deal_department_space(txt){\n" +
                "    var tmp_str_arr = txt.split(br_str);\n" +
                "    txt = \"\";\n" +
                "    //处理空行\n" +
                "    for (var xx = 0; xx < tmp_str_arr.length; xx++) {\n" +
                "\n" +
                "        if (tmp_str_arr[xx].trim().length > 0) {\n" +
                "            \n" +
                "            //36空格\n" +
                "            if (tmp_str_arr[xx].indexOf(space_36) > -1 && !isDateStr(tmp_str_arr[xx].trim())) {//排除日期\n" +
                "               // console.log(\"-----------\"+tmp_str_arr[xx])\n" +
                "                var department_arr =  tmp_str_arr[xx].trim().split(\" \");//如果是空格或者一个字符，全部数组，合并\n" +
                "                var is_find = false;\n" +
                "                var new_department_str=\"\";\n" +
                "                for(var yy=0;yy<department_arr.length;yy++){\n" +
                "                   if(department_arr[yy].length<=1){\n" +
                "                      new_department_str = new_department_str+department_arr[yy].trim();\n" +
                "                   //   console.log(\"-----------\"+new_department_str)\n" +
                "                      is_find= true;\n" +
                "                   }else{\n" +
                "                    is_find= false;\n" +
                "                    break;\n" +
                "                   }\n" +
                "                }\n" +
                "                if(is_find)  tmp_str_arr[xx] = new_department_str;\n" +
                "                tmp_str_arr[xx] = space_36 + tmp_str_arr[xx].trim();  //换行专门处理\n" +
                "            }\n" +
                "        }\n" +
                "        txt = txt + tmp_str_arr[xx] + br_str;\n" +
                "    }\n" +
                "    return txt;\n" +
                "}\n" +
                "//处理开头空行问题\n" +
                "function deal_firstLineNull(txt){\n" +
                "     //删除开头空格\n" +
                "     for (var mm = 0; mm < 10; mm++) {\n" +
                "        var start_3 = txt.indexOf(\"\\n\");\n" +
                "        if (start_3 == 0) {\n" +
                "            txt = txt.substring(start_3 + 1);\n" +
                "        }\n" +
                "        start_3 = txt.indexOf(br_str);\n" +
                "        if (start_3 == 0) {\n" +
                "            txt = txt.substring(start_3 + 2);\n" +
                "        }\n" +
                "    }\n" +
                "    return txt;\n" +
                "}\n" +
                "//发改委正文特殊处理,部门在后面居中处理\n" +
                "function deal_special_department(txt){\n" +
                "    var tmp_str_arr = txt.split(br_str);\n" +
                "    txt = \"\";\n" +
                "     //反过来处理部门居右问题\n" +
                "    var xx = tmp_str_arr.length-1;\n" +
                "    //最后一行有日期，且有6空格，居中标示\n" +
                "   // console.log(\"ll=\"+tmp_str_arr[xx])\n" +
                "    if(tmp_str_arr[xx]!=null &&  tmp_str_arr[xx].trim().length==0){//去掉最后一行\n" +
                "      xx =xx-1;\n" +
                "    }\n" +
                "    if(tmp_str_arr[xx]!=null && tmp_str_arr[xx].trim().length>0 &&  tmp_str_arr[xx].indexOf(space_6)>-1 && tmp_str_arr[xx].indexOf(\"年\")>-1 &&  tmp_str_arr[xx].indexOf(\"月\")>-1 &&  tmp_str_arr[xx].indexOf(\"日\")>-1 ){\n" +
                "        tmp_str_arr[xx]   =space_36+ tmp_str_arr[xx].trim();\n" +
                "        for (xx = xx-1; xx >=0; xx--) {\n" +
                "            if (tmp_str_arr[xx].trim().length > 0 &&  tmp_str_arr[xx].indexOf(space_6)>-1 ) {\n" +
                "                tmp_str_arr[xx]   =space_36+ tmp_str_arr[xx].trim();\n" +
                "            }else{\n" +
                "                break;\n" +
                "            }\n" +
                "            \n" +
                "        }\n" +
                "    }\n" +
                "    //重新组合正文\n" +
                "    for (var xx =0; xx < tmp_str_arr.length; xx++) {\n" +
                "        if (tmp_str_arr[xx].trim().length > 0) {\n" +
                "            txt =   txt+tmp_str_arr[xx]+br_str;\n" +
                "        }\n" +
                "        \n" +
                "    }\n" +
                "    return txt;\n" +
                "}\n" +
                "//处理开始标题折行问题，连续三行居中，前面两行合并为标题\n" +
                "function deal_titles(txt){\n" +
                "    var tmp_str_arr = txt.split(br_str);\n" +
                "    txt = \"\";\n" +
                "    //处理开始标题折行问题，连续三行居中，前面两行合并为标题\n" +
                "    var start =0;\n" +
                "    while((tmp_str_arr[start].trim().length==0 || tmp_str_arr[start].indexOf(space_6)>-1) && start<5){\n" +
                "       // console.log(\"-----\"+tmp_str_arr[start]);\n" +
                "        if(tmp_str_arr[start].trim().length==0)  {start++;continue;}\n" +
                "        if(tmp_str_arr[start].charAt(tmp_str_arr[start].length-1)!='号'){\n" +
                "           if(txt.length==0) txt = space_6;\n" +
                "            txt = txt+tmp_str_arr[start].trim();\n" +
                "        }else{\n" +
                "            txt = txt+br_str+br_str;\n" +
                "            break;\n" +
                "        }\n" +
                "        start++;\n" +
                "    }\n" +
                " \n" +
                "  \n" +
                "    for (var xx =start; xx < tmp_str_arr.length; xx++) {\n" +
                "            txt =   txt+tmp_str_arr[xx]+br_str;\n" +
                "    }\n" +
                "    return txt;\n" +
                "}\n" +
                "//正文后处理\n" +
                "function deal_last(txt){\n" +
                "    \n" +
                "  txt = removeBlock(txt,\"抄送：\",br_str,\"\");\n" +
                "  txt = removeBlock(txt,\"分送：\",br_str,\"\");\n" +
                "  txt = removeBlock(txt,\"链接：\",br_str,\"\");\n" +
                "  txt = removeBlock(txt,\"网站纠错\",br_str,\"\");\n" +
                "  txt = removeBlock(txt,\"附件.pdf\",br_str,\"\");\n" +
                "  txt = txt.replaceAll(\"（此件主动公开）\",\"\");\n" +
                "  txt = txt.replaceAll(\"（此件公开发布）\",\"\");\n" +
                "  txt = txt.replaceAll(\".此件公开发布.\",\"\");\n" +
                "  txt = txt.replaceAll(\".此件主动公开.\",\"\");\n" +
                "\n" +
                "  //txt = txt.replaceAll(\"四川省人民政府办公厅\"+br_str+br_str,\"四川省人民政府办公厅\");\n" +
                "\n" +
                "   return txt;\n" +
                "}\n" +
                "function deal_all_text(txt) {//国家税务局\n" +
                "    //1、替换标签，居中 空6个，居右 空36个，行首加4个空格。替换br 正则表达式\n" +
                "    //先找居中的标题，文号，空6格\n" +
                "    //接着找居右的 36格                                \n" +
                "    if (txt==null || txt.length==0) return \"\";\n" +
                "    //正文预处理\n" +
                "    txt = deal_prepared(txt);\n" +
                "     //附件处理，包括排版\n" +
                "    txt = deal_attach_titles(txt);\n" +
                "    //居中标签处理P\n" +
                "    txt = align_center(txt);\n" +
                "    //居右标签处理\n" +
                " //   console.log(\"bbbb=\"+txt)\n" +
                "    txt = align_right(txt);\n" +
                "    //居左\n" +
                "    txt = align_left(txt);\n" +
                "    //替换网页标签\n" +
                "    txt = replaceAllHtlm(txt);\n" +
                "    \n" +
                "    //删除空行以及根据空格补充回车换行\n" +
                "  \n" +
                "    //发改委正文特殊处理 ，部门居中，从后面排版\n" +
                "    txt = deal_special_department(txt);\n" +
                "   // 处理空行，以及针对空格处理换行\n" +
                "    txt = deal_lines(txt);\n" +
                "    //console.log(\"bbbb=\"+txt)\n" +
                "    //处理开头三行居中，合并标题问题，四川省政府模式\n" +
                "    txt = deal_titles(txt);\n" +
                "    //处理章节，条的格式（参考VB）\n" +
                "    txt = deal_paragraph(txt);\n" +
                "    //处理空行36个格的日期问题，由原来的数字年份转换为一般的中文数字年份。2015年1月2日    二零一五年二月十一日\n" +
                "    txt = deal_appDate(txt);\n" +
                "    //删除开头空格\n" +
                "    txt = deal_firstLineNull(txt);\n" +
                "     //处理部门日期换行问题，36格子换行\n" +
                "    txt = deal_space36_lines(txt);\n" +
                "    //处理部门中间空格问题，如果单个字，合并\n" +
                "    txt = deal_department_space(txt);\n" +
                "    txt = deal_last(txt);\n" +
                "    return txt;\n" +
                "}\n" +
                "\n" +
                "function iGetInnerText(testStr) {\n" +
                "\n" +
                "    var resultStr = testStr.replace(/[\\r\\n]/g, \"\"); //去掉空格\n" +
                "    //resultStr = resultStr.replace(/\\ +/g, \"\");    //去掉空格\n" +
                "    resultStr =  resultStr.replace(/\\s+/g, \"\");//去掉回车换行\n" +
                "    return resultStr;\n" +
                "}";
        String str = "\n" +
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "\t<meta name=\"viewport\" content=\"width=1040\" />\n" +
                "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n" +
                "\t<meta name=\"description\" content=\"最高人民法院政务网站,最高人民法院网，最高人民法院，最高人民法院网是人民群众了解和联系最高人民法院的重要窗口，承载着司法公开、法治宣传、服务群众、接受监督等重要使命。是最高人民法院的政务网站，是最高人民法院在互联网上唯一的正式身份。\" />\n" +
                "\t<meta name=\"keywords\" content=\"司法解释，重大案件，权威发布，新闻发布会，法院资讯，院长信箱，审判流程公开，执行信息公开，裁判文书公开，开庭公告，法院，法庭，法官\" />\n" +
                "\t<script type=\"text/javascript\" src=\"/style/system/js/jquery.min.js\"></script>\t\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/style/system/css/css.css?2019100810\" />\n" +
                "<script type=\"text/javascript\" src=\"/style/system/js/jquery.jqprint.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/style/system/js/jquery.textUI.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/style/system/js/jquery.chinacourtUI.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"http://yhxwfx.court.gov.cn/910001/gs.js\"></script>\n" +
                "<title>庆祝中华人民共和国成立70周年暨最高人民法院建院70周年座谈会发言摘登 - 中华人民共和国最高人民法院</title>\t\n" +
                "\t\t\t\t\t</head>\n" +
                "<body>\n" +
                "\t<!--顶部开始-->\t\n" +
                "    <div class=\"topbanner\"></div>\n" +
                "\t<div class=\"top\">\n" +
                "\t\t<div id=\"container\" class=\"clearfix\">\n" +
                "\t\t\t<ul class=\"fl clearfix lf_sd\">\n" +
                "\t\t\t\t<li class=\"fl language\">[ <a href=\"http://www.court.gov.cn/\">中文版</a> ]&nbsp;&nbsp;&nbsp;[ <a target=\"_blank\" href=\"http://english.court.gov.cn/\">English</a> ]</li>\n" +
                "\t\t\t\t<li class=\"fl\" id=\"showtime\"></li>\t\n" +
                "\t\t\t</ul>\n" +
                "\t\t\t<ul class=\"fr clearfix rt_sd\">\n" +
                "            \n" +
                "\t\t\t\t<li class=\"fl xmt\">\n" +
                "\t\t\t\t\t\n" +
                "                    <span class=\"fl gz\">关注：</span>\n" +
                "\t\t\t\t\t<a class=\"fl sina\" href=\"http://www.weibo.com/zuigaofa\" target=\"_blank\" alt=\"最高人民法院新浪微博\" title=\"最高人民法院新浪微博\"></a>\n" +
                "\t\t\t\t\t<a class=\"fl tencent\" href=\"http://e.t.qq.com/court\" target=\"_blank\" alt=\"最高人民法院腾讯微博\" title=\"最高人民法院腾讯微博\"></a>\n" +
                "\t\t\t\t\t<a class=\"fl people\" href=\"http://t.people.com.cn/zuigaofa\" target=\"_blank\" alt=\"最高人民法院人民微博\" title=\"最高人民法院人民微博\"></a>\n" +
                "\t\t\t\t\t<a class=\"fl wechat\" href=\"javascript:;\" alt=\"最高人民法院官方微信\" title=\"最高人民法院官方微信\"><i></i></a>\n" +
                "                    <a class=\"fl sohu\" href=\"javascript:;\" alt=\"最高人民法院搜狐新闻客户端\" title=\"最高人民法院搜狐新闻客户端\"><i></i></a>\n" +
                "                    \n" +
                "   \t\t   <span class=\"fl app\"><a target=\"_blank\" style=\"display: block;\" href=\"/kehuduan.html\">手机客户端</a></span>\t\n" +
                "\t\t\t\t<a class=\"fl ios\" href=\"javascript:;\" alt=\"ios版手机客户端\" title=\"ios版手机客户端\"><i></i></a>\n" +
                "                    <a class=\"fl android\" href=\"javascript:;\" alt=\"android版手机客户端\" title=\"android版手机客户端\"><i></i></a>\n" +
                "                    \n" +
                "\t\t\t\t</li>\n" +
                "\t\t\t\t<li class=\"fl\"><a class=\"lg_em\" target=\"_blank\" href=\"http://mail.court.gov.cn/\">登录邮箱系统</a></li>\n" +
                "\t\t\t\t<li class=\"fl search\">\n" +
                "\t\t\t\t<form name=\"content\" action=\"/search.html\" method=\"get\">\t\t\t\t<input class=\"sc\" type=\"text\" id=\"keyword\"  name=\"content\" value=\"\"/>\n" +
                "\t\t\t\t<input class=\"btn\" id=\"article_content\" type=\"submit\" />\n" +
                "\t\t\t\t</form>\t\t\t\t\t\n" +
                "\t\t\t\t</li>\t\n" +
                "\t\t\t</ul>\t\n" +
                "\t\t</div>\t\t\n" +
                "\t</div>\n" +
                "\t<!--顶部结束-->\n" +
                "\n" +
                "\t<!--logo开始-->\n" +
                "\t<div class=\"header\">\n" +
                "\t\t<div class=\"logo\"></div>\n" +
                "        <div class=\"festival\"></div>\n" +
                "\t\t<div class=\"nav\">\n" +
                "\t\t\t<div id=\"container\">\n" +
                "\t\t\t\t\t<ul id=\"yw1\">\n" +
                "<li class=\"fl home\"><a href=\"/index.html\">首页</a></li>\n" +
                "<li class=\"fl\"><a href=\"/xinshidai-gengduo-762.html\">学习新时代</a></li>\n" +
                "<li class=\"fl\"><a href=\"/jigou.html\">机构设置</a></li>\n" +
                "<li class=\"fl active\"><a href=\"/zixun.html\">法院资讯</a></li>\n" +
                "<li class=\"fl\"><a href=\"/fabu.html\">权威发布</a></li>\n" +
                "<li class=\"fl\"><a target=\"_blank\" href=\"http://gongbao.court.gov.cn\">公报</a></li>\n" +
                "<li class=\"fl\"><a href=\"/wenshu.html\">裁判文书</a></li>\n" +
                "<li class=\"fl\"><a href=\"/shenpan.html\">审判业务</a></li>\n" +
                "<li class=\"fl\"><a href=\"/jianshe.html\">法院建设</a></li>\n" +
                "<li class=\"fl\"><a href=\"/fuwu.html\">办事服务</a></li>\n" +
                "<li class=\"fl\"><a href=\"/hudong.html\">公众互动</a></li>\n" +
                "<li class=\"fl\"><a href=\"/xunhui.html\">巡回法庭</a></li>\n" +
                "<li class=\"fl\"><a href=\"/zhongjiwei.html\">驻院纪检监察组</a></li>\n" +
                "<li class=\"fl last\"><a href=\"/guanyu.html\">关于我们</a></li>\n" +
                "</ul>\t\t\t</div>\n" +
                "\t\t</div>\t\n" +
                "\t</div>\n" +
                "\t<!--logo结束-->\n" +
                "\n" +
                "\t<!--内容开始-->\n" +
                "\t\t<div class=\"location\">\n" +
                "\t\t<div id=\"container\">\n" +
                "\t\t\t<span class=\"fl\">所在位置：</span>\n" +
                "\t\t\t<span class=\"fl\">\n" +
                "<a href=\"/index.html\">首页</a> <font>></font> <a href=\"/zixun.html\">法院资讯</a> <font>></font> <span>最高人民法院新闻</span></span>\t\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t<div id=\"container\">\n" +
                "\t\t\n" +
                "<div class=\"detail\">\n" +
                "\t<div class=\"title\"><span>庆祝中华人民共和国成立70周年暨最高人民法院建院70周年座谈会发言摘登</span></div>\n" +
                "\t<div class=\"clearfix detail_mes\">\n" +
                "\t\t<ul class=\"clearfix fl message\">\n" +
                "\t\t\t<li class=\"fl\">来源：人民法院新闻传媒总社</li>\n" +
                "\t\t\t<li class=\"fl\">发布时间：2019-10-17 08:55:29</li>\n" +
                "\t\t</ul>\n" +
                "\t\t<ul class=\"clearfix fr handle\">\n" +
                "\t\t\t<li class=\"fl word_size\">\n" +
                "\t\t\t\t<span>字号：</span>\n" +
                "\t\t\t\t<a class=\"smaller\" href=\"#\">小</a>\n" +
                "\t\t\t\t<a class=\"bigger\"href=\"#\">大</a>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li class=\"fl print\"><a href=\"javascript:;\" id=\"print_article\">打印本页</a></li>\n" +
                "\t\t</ul>\n" +
                "\t</div>\n" +
                "\t<div class=\"txt big\">\n" +
                "\t\t<div class=\"txt_txt\" id=\"zoom\"><p style=\"text-align:center;\">\n" +
                "\t<strong>珍惜成绩 开创未来</strong>\n" +
                "</p>\n" +
                "<p style=\"text-align:center;\">\n" +
                "\t最高人民法院原经济审判庭副庭长 &nbsp;费宗祎\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　参加庆祝中华人民共和国成立70周年和最高人民法院建院70周年的座谈会，心情十分激动。来之前的两三个晚上，我都是辗转反侧，回忆往事，历历在目，不由得感慨万千。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　1950年，我由国家分配进入最高人民法院，到1998年退休，除了其间有几年被下放到长春企业当职员外，一头一尾在最高人民法院工作了整30年。最高人民法院是我改造思想的学校，也是锤炼成长的熔炉。恩情长久，不敢遗忘。所以，我要为最高人民法院的七十华诞，表示最诚挚的祝贺。同时，追忆过去，我要对教育过我、帮助和鼓励过我的尊敬的领导、前辈，与我朝夕相处、相濡以沫的亲爱的同事、挚友，在创建和开展司法建设中所作的努力表示崇高的敬意！\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　最高人民法院走过的这70年，是一个法治与人治反复较量的、十分曲折的历程。其中有春风、阳光，也有凄风、苦雨，给我们留下了许多经验和深刻的教训。这是我们非常难得的重要财富，必须加以珍惜。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　第一，以民为本、司法为民。人民法院是人民的法院，为人民服务，维护人民的权利，保护人民的利益，是人民法院的天职，是司法工作的根本、灵魂，一刻也不能忘记，也一丝一毫都不能偏离。第二，实事求是、严肃执法。要尊重事实，敬畏法律，敢于抗拒外来压力，善于排除各种干扰，执法必严，违法必究，不枉不纵，有错必纠。第三，法官应该正大光明、廉洁奉公。法官的灵魂应当是纯洁的，品格是高尚的，手跟嘴应该是干净的，做事应该是公正的，这是对每一个法官最起码的要求。第四，服务大局，综合治理，一定要以审判为中心。治疗社会疾病，要靠各种力量协同作战，而司法审判仍处于中心位置。第五，也是最重要的，一定要坚持在党的领导下依法独立行使审判权。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　党的十一届三中全会拨乱反正，提出以社会主义经济建设为中心，实行改革开放政策，人民法院得以复兴，司法得以发展。我也是在那个时候归队回到最高人民法院，觉得有这样一个机会，重新全身心地投入到工作中，心情非常愉快和高兴。20世纪80年代，最高人民法院的业务工作得到了非常广泛的开拓，开拓了更多领域，也发挥了更大作用。党的十八大以来，司法改革加紧实施，人民法院的政治建设、组织建设和业务建设不断得到加强，作为国家重器，其保证社会稳定、推进经济发展方面发挥的作用日益彰显。我认为现在是人民法院历史上条件最好的时代，也是一个继往开来的起点，人民法院大有可为、也大有作为。我衷心希望和祝愿最高人民法院在中国特色社会主义新时代，继往开来，学习外来的，坚持本来的，实践自己的，走一条有中国社会主义特色的道路。率领全国各级人民法院为实现我国“两个一百年”的奋斗目标，为实现中华民族伟大复兴的中国梦，作出更大贡献！\n" +
                "</p>\n" +
                "<p style=\"text-align:center;\">\n" +
                "\t<strong>为党和国家发展大局作出更大贡献</strong>\n" +
                "</p>\n" +
                "<p style=\"text-align:center;\">\n" +
                "\t最高人民法院民四庭副庭长 &nbsp;高晓力\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　七十年的历史告诉我们：\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　党的领导是人民司法事业发展的根本保障。党领导国家从“社会主义法制”到“社会主义法治”，从“有法可依、有法必依、执法必严、违法必究”到“科学立法、严格执法、公正司法、全民守法”的发展历程，使我深刻感悟到法治在我们党治国理政中的地位上的变化，看到了走中国特色社会主义法治道路所蕴含的历史逻辑、理论逻辑和实践逻辑，深切认识到社会主义法治建设必须牢牢坚持中国共产党的领导的必然，党的领导是依法治国的根本保障。人民法院是党领导下的国家审判机关，具有鲜明的政治属性。在工作中，我们必须牢牢坚持党的领导！\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　国家发展大局是人民司法事业发展的坚实依托。拿我最熟悉的涉外民商事审判工作来说，新中国成立初期，我国长期处于被封锁的状态，主要的经济往来是和苏联、东欧一些国家，经济交往少，涉外民商事纠纷就更少了。改革开放后，跨境往来增多，生产要素开始流通，涉外民商事纠纷开始涌现。涉外民商事审判工作成为改革开放兴国之需。经过了20世纪80年代打基础时期、90年代巩固提高时期，2000年特别是2001年中国加入世界贸易组织后，涉外民商事审判工作迎来了飞速发展的时期。最高人民法院整合审判资源，成立了专门从事涉外民商事和海事海商审判工作的业务庭，专业化的审判队伍不断发展壮大。涉外民商事案件量逐年上升，案件类型不断丰富，涉及国际贸易、国际投资、国际支付、国际运输、国际保险等各个领域，产出了一批批有国际影响力的案例，为国际法的发展作出了积极贡献。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　人民司法事业要为党和国家发展大局作出更大贡献。具体到涉外审判，人民法院充分尊重当事人意思自治，积极适用国际条约、国际惯例，正确适用中外法律，平等保护中外当事人的合法权益，营造法治营商环境，积极推动我国全方位对外开放格局的构建。通过支持和监督国际商事仲裁、国际商事调解等多元纠纷解决机制的发展，提供优质高效的法律服务，满足国际民商事交往当事人多元纠纷解决需求。通过充分发挥审判职能，为“一带一路”建设、海洋强国建设、自贸试验区以及自由贸易港的建设等提供全方位司法服务和保障。通过制定司法解释，确保国家法律和对我国生效的国际条约在全国范围内统一实施，统一裁判尺度。此外，我院积极配合立法机关不断完善涉外民商事领域立法，特别是完成涉外民事关系法律适用法；配合外交部、商务部进行相关领域国际条约的谈判工作，提出专业务实的咨询意见，切实维护国家的司法主权和重大利益；配合中国国际商会等，参与国际惯例的修订完善，积极参与国际规则的制定。\n" +
                "</p>\n" +
                "<p style=\"text-align:center;\">\n" +
                "\t<strong>三十年的法院情怀</strong>\n" +
                "</p>\n" +
                "<p style=\"text-align:center;\">\n" +
                "\t北京知识产权法院党组成员、副院长 &nbsp;宋鱼水\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　今天，我们在此隆重集会，共同回首美好岁月，展望光明未来。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　我们是一支朝气蓬勃的队伍，践行着青春的理想。我毕业那年，一大批青年大学生奔向祖国最基层的岗位，我当时所在的法院也招收了十几位高校毕业生。从那时起，我们投身火热的审判工作，如饥似渴地研究问题，接受各种问题的考验。法院党组也把培养、锻炼青年干警作为最重要的工作之一，使我们有机会在司法实践的舞台更好地发挥作用，把青春的激情和理想融入人民群众的法律需求当中。回想法院青年由小分队到大部队的蓬勃发展过程，岁月如歌，青年人在迅速成长，在新时代大显身手。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　我们是一支纾解矛盾的大军，守护着公正的司法文化。法庭上面对红色的国徽，身着黑色的法袍，那庄严肃穆的感觉彰显着我们神圣的职责和使命。从法律体系初步形成到人民群众喜爱法治、信仰法治，从规则文化促进国内发展到探索世界规则的参与权、话语权、主动权，全面依法治国彰显了我国的制度自信，共和国的司法裁判者始终在案件中恪守规则，以调、判两种解决问题的方式回报党、国家和人民——那些在司法战线扛起司法改革大旗的邹碧华法官们，那些为捍卫法治勇于进行伟大斗争的马彩云法官们，那些积劳成疾用生命讴歌法治时代的谭彦法官们，还有更多获得人民法院工作三十年“荣誉天平奖章”默默奉献的干警们！虽然难掩思念情怀，但是司法的精神足以消除前进中的困难，广大司法战线干警从未像今天这样不怕牺牲，奋勇向前！\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　伴随智慧和经验的双成长，司法需要沉稳与创新。司法在自身建设方面，既受内部发展规律制约，又受社会发展阶段制约，司法是理想更是现实。由于案件的非常规增长，人才培养的周期性等因素，新时期司法面临着全新挑战。我们需要用法治科学规划司法的发展。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　站在新的起点上，回首来时路，70年来，法治与新中国共成长；30年来，我与知识产权审判事业共成长。在“最美奋斗者”颁奖典礼上，我是这样表达的：\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　“我是一名从事知识产权审判的法官。从没有知识产权庭到建设知识产权庭再到建设知识产权法院，我和同事们共同见证了共和国法律的健全和知识产权审判体系的快速发展。2014年11月6日，北京知识产权法院成立了。建院以来，北京知识产权法院审理了大量有影响的案件。有人说，知识产权保护的春天来了，有的外国当事人说，打官司就到北京知识产权法院。科技日新月异，我国企业越来越强大，人们越来越喜爱中国品牌。新中国70岁，我们走进知识产权创造、运用、保护和管理的新时代！”\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　荣誉是集体的荣誉，为我们这个集体骄傲和自豪！荣誉也是职业的荣誉，为党、国家和法治的事业，司法者坚守着职业忠诚的使命。我们要“不忘初心、牢记使命”，奋勇向前！\n" +
                "</p>\n" +
                "<p style=\"text-align:center;\">\n" +
                "\t<strong>最高人民法院是我成长的摇篮</strong>\n" +
                "</p>\n" +
                "<p style=\"text-align:center;\">\n" +
                "\t国家法官学院原教务长 &nbsp;孙世光\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　我1941年出生，生在旧社会、长在红旗下。没有党，我根本不可能读大学，不可能到最高人民法院工作。我们家兄弟姐妹八个，我刚读大学的时候，父亲有病，家里困难，我要回去照顾家里。当时年级主任找到我说，有困难，组织可以给你解决。我享受助学金，才完成学业。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　最高人民法院是我成长的摇篮。1964年7月，我在学校入了党。当时我是满怀激情，意气风发，为实现自己的入党誓言，来到最高人民法院的。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　我感到很幸运，最高人民法院有好的院风、好的传统，领导和老一辈同志处处给我们做表率，面对面、心贴心、手把手地教我们如何做人，如何工作。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　记得我们带着行李刚到最高人民法院的时候，司法行政厅的黄杰同志帮我们拿着行李一直送到在前门附近的招待所。住下来之后，曾汉周庭长到宿舍来看我们，给我们介绍最高人民法院的情况。后来我生病了，第二天人事处的余迪同志就去医院看我，让我感到像回到家一样。来院后，我们都想见见谢觉哉院长。谢老在夫人和秘书的搀扶下，一个人一个人的问了我们的情况。这些事都让我十分感动。最高人民法院对同志也是严格要求的。参加“四清工作队”的时候，有一名同志迟到了，何兰阶庭长严肃地批评了他。这也教育了我，不管干什么，都要遵守纪律，严格要求自己。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　分到研究室工作后，安排我负责统计。当时统计报表，有三十几张大表，数字密密麻麻的，计算靠算盘，我又没学过算盘，算了5次都不一样，心里很烦躁，工作也有些不安心。在一次党小组会上，我谈自己的思想问题，党小组的同志们都帮我分析思想根源。会后，研究室领导找我谈话，使我认识到无论什么工作，干好工作就是为人民服务，从此思想认识有了提高。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　最高人民法院是我演绎人生的舞台。我从1964年8月来到最高人民法院，2001年退休，在最高人民法院工作了37年。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　传承最高人民法院人的精神、最高人民法院的院风，要认真踏实地做好组织上分配给自己的每一项工作，干一行爱一行，学一行钻一行。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　在留守处工作，对待留守处的孩子们，自己能像父辈、老师对待自己的孩子、学生一样，关心照顾他们的学习生活，让他们的家长在“五七”干校放心。在研究室统计处，自己对数字工作不再厌烦而是认真对待，对比分析、写出统计分析报告，在法律业大学习与辅导班上开设统计知识讲座，开办全国法院统计员培训班，有效推动全国法院的统计工作。在法律业大和国家法官学院工作，担任秘书长和教务长，认真制订教学计划，聘请专家老师，培养青年教师，为法官教育尽心尽力。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　30多年的工作，受到了党组织和领导、同志们的肯定和好评，先后被评为最高人民法院先进工作者，国家工委和最高人民法院的先进党务工作者，并享受国务院政府特殊津贴。\n" +
                "</p>\n" +
                "<p style=\"text-align:center;\">\n" +
                "\t<strong>让法治日益成为信仰的70年</strong>\n" +
                "</p>\n" +
                "<p style=\"text-align:center;\">\n" +
                "\t最高人民法院新闻局综合处副处长 &nbsp;张蓓蓓\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　人民法院的70年是人民法官的工作日益感动群众的70年。10年前，在云南大理一个距离县城50多公里的高寒贫困村，我在昏黄的路灯下读着一本已经泛黄的日记，日记里有一句话，至今记忆犹新：“即使永远僻居乡野，亦无所谓。”这是全国优秀法官龙进品的日记。他是村里的第一个本科生，走出大山却又走了回来，在云南大理南涧县的基层法庭任职17年。那一天，我带领着20余家媒体记者组成采访团，几经周转，在晚上9点半抵达了龙进品所在的有14个少数民族杂居的小村庄。“公郎像口锅，出门就爬坡”，这个山村山高坡陡，交通极为不便，但几十位乡亲知道北京的记者们要来，争先恐后要讲讲他们眼中的“小龙”。记者们被眼前的场景深深地感动了，扒了几口凉饭，就在村里昏黄的路灯下开始了集体采访。那天夜里，大家一直眼含热泪采访到了凌晨两点半。 龙进品们的生活是那么清贫，但因为有了对正义的坚守和对人民的热爱，他们的内心却格外地丰盈富足。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　人民法院的70年是让法治日益成为信仰的70年。5年前，我经历了人生中的第一次深夜接机，等待落地的主人公是张高平、张辉，他们是那一年备受关注的新闻人物——蒙冤十年的当事人张氏叔侄。根据领导安排，我负责邀请他们参加12月4日举办的最高人民法院公众开放日活动。当天的公众开放日活动非常成功，张氏叔侄在现场见证了法官们向宪法宣誓，还在舞台上讲述了自己的故事。张高平在现场说：“我相信法律。法院是一个讲法律的地方，咱们没干坏事，为什么怕来法院？”听到这句话时，法官们都鼓起掌来。我还记得，那一年公众开放日的主题是：“让法治成为信仰”。正如人民大学陈卫东教授所言，让张氏叔侄表达他们朴素的法治信仰，“昭示着最高人民法院坚守正义的信心，体现了法院的开明和开放，对整个社会都是一种信心的提振”。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　人民法院的70年是人民司法工作日益赢得群众理解的70年。一年前，为了充分发挥“基本解决执行难”新闻宣传第二战场的作用，按照院领导的要求，我们和执行局共同策划，借助创新发展的网络新媒体，开展了“决胜执行难”全媒体直播活动。一年多来，我们的直播坚持了63期，据不完全统计，观看量已超11亿人次，“教科书式执法”多次引发千万点赞。网友们会为奔波了一夜却一无所获的执行法官心疼，要“抱一抱”他们；会要求为酷暑下执行法官湿透了的制服拍特写，也会给霸气喊话“让违法建筑从地球消失”的女执行局长点赞。如今我们已经拥有了一支由100多家媒体组成的直播队伍，今年我们还首次引入了5G+VR直播，多次登上了微博热搜榜。中国社科院研究员、国际问题专家张国庆评价说：“全媒体直播实现了法院、媒体、公众的多赢，更重要的是，整个社会都被动员起来，从旁观者变成参与者、支持者及宣传者，这本身就推动了社会进步，意义深远。”\n" +
                "</p>\n" +
                "<p style=\"text-align:center;\">\n" +
                "\t<strong>奋力推进人民司法壮阔伟业</strong>\n" +
                "</p>\n" +
                "<p style=\"text-align:center;\">\n" +
                "\t重庆市高级人民法院党组副书记、副院长 &nbsp;黄明耀\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　新中国成立70年来，中国共产党领导人民逐步建立形成了中国特色社会主义法治。最高人民法院一路参与和推动新中国的法治进步，审判理念、体系和制度实现了从无到有并逐步健全完善的伟大历史跨越。特别是党的十八大以来，在以习近平同志为核心的党中央坚强领导下，最高人民法院带领全国法院坚持服务大局、司法为民、公正司法，推进司法改革和信息化“两翼齐飞”，打赢“基本解决执行难”这场硬仗，全面建设现代化诉讼服务体系，让人民群众以看得见的方式实现公平正义，谱写了一曲曲新时代法治中国的华美乐章。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　重庆法院与全国其他地方法院一样，在最高人民法院的有力指导下，开拓进取、砥砺奋进，各项工作实现了跨越发展。入职法院33年来，我分别在地方三级法院，在不同岗位和层级贡献、共享人民司法事业的累累硕果，把个人成长同人民法院的奋进历程融为一体，对此深感荣幸、倍感振奋、备受鼓舞！\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　党的十八大以来，习近平总书记对政法工作作了系列重大擘画，对重庆提出“两点”定位、“两地”“两高”目标、发挥“三个作用”和营造良好政治生态的重要指示要求，为我们做好工作提供了根本遵循。重庆法院干警始终沿着总书记指引的方向，紧跟中央决策部署和最高人民法院指导步伐，扎实推动各项职责落地，奋力推动人民司法的壮阔伟业。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t　　工作中，我们牢牢抓住执法办案这个中心，严格公正司法，依法惩治犯罪、定分止争、畅通市场、为民解忧，实现办案量质提升，坚决守住防范冤假错案底线，维护社会公平正义最后一道防线。始终服务改革发展这个大局，通过司法重整让百年重钢涅槃重生，成立全国第一家覆盖自贸区全域的法院，推动建立以铁路提单为重心的陆上贸易规则，构建“1+X”民营经济司法保护体系，首发民营企业法律风险提示书和法治化营商环境司法评估指数体系，在维护生态环境安全权益等方面强化“上游意识”、担起“上游责任”。精准践行司法为民这个宗旨，全面落实立案登记制，落实推进一站式多元解纷机制、一站式诉讼服务中心建设，和全国法院一道如期实现“基本解决执行难”这个阶段性目标，为群众依法维护自身权益敞开大门，获得群众广泛认可。充分施展司法改革和信息化这“两翼”，全面落实司法责任制、司法人员分类管理、人财物市级统管以及司法人员职业保障制度改革要求，坚持把非诉讼纠纷解决机制挺在前面，着力推进“分调裁审”，构建“易诉、易解、易审、易达和法智云中心”等“4+1”智慧法院新生态，推动现代科技与法院工作深度融合，让正义的实现进一步提速。\n" +
                "</p></div>\n" +
                "\t\t<div class=\"txt_etr\"><span class=\"fr\">责任编辑：韩绪光</span></div>\n" +
                "\t</div>\n" +
                "\t<!--分享-->\n" +
                "\t<div class=\"share\"></div>\n" +
                "\t<!--相关报道-->\t\t\n" +
                "\t<div class=\"clearfix interfix\">\n" +
                "\t\t<div class=\"fl report\">\n" +
                "\t\t\t<div class=\"title\">相关报道</div>\n" +
                "\t\t\t<div class=\"list\">\n" +
                "\t\t\t\t\t\t\t\t\t<li><a title=\"第三届市场化破产国际研讨会召开 刘贵祥出席\" target=\"_blank\" href=\"/zixun-xiangqing-190921.html\">第三届市场化破产国际研讨会召开 刘贵祥出席</a></li>\n" +
                "\t\t\t\t\t\t\t\t\t<li><a title=\"最高法国际海事司法浙江基地成立\" target=\"_blank\" href=\"/zixun-xiangqing-190931.html\">最高法国际海事司法浙江基地成立</a></li>\n" +
                "\t\t\t\t\t\t\t\t\t<li><a title=\"最高人民法院建院70周年座谈会发言摘登\" target=\"_blank\" href=\"/zixun-xiangqing-190941.html\">最高人民法院建院70周年座谈会发言摘登</a></li>\n" +
                "\t\t\t\t\t\t\t\t\t<li><a title=\"胡云腾会见第十期蒙古国法官研修班成员\" target=\"_blank\" href=\"/zixun-xiangqing-190641.html\">胡云腾会见第十期蒙古国法官研修班成员</a></li>\n" +
                "\t\t\t\t\t\t\t\t\t<li><a title=\"最高法印发学习宣传李庆军同志先进事迹的通知\" target=\"_blank\" href=\"/zixun-xiangqing-190611.html\">最高法印发学习宣传李庆军同志先进事迹的通知</a></li>\n" +
                "\t\t\t\t\t\t\t\t\t<li><a title=\"李庆军同志先进事迹报告会在西南政法大学举行\" target=\"_blank\" href=\"/zixun-xiangqing-190601.html\">李庆军同志先进事迹报告会在西南政法大学举行</a></li>\n" +
                "\t\t\t\t\t\t\t\t\t<li><a title=\"最高法邀请31位全国人大代表视察重庆法院\" target=\"_blank\" href=\"/zixun-xiangqing-190631.html\">最高法邀请31位全国人大代表视察重庆法院</a></li>\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"fl img_txt\">\n" +
                "\t\t\t\t<div class=\"img\"><a title=\"中华人民共和国成立70周年庆祝活动总结会举行\" target=\"_blank\" href=\"/zixun-xiangqing-190721.html\"><img width=\"200\" height=\"134\" src=\"/upload/image/2019/10/16/19/32/20191016193221_83209.jpg\" alt=\"中华人民共和国成立70周年庆祝活动总结会举行\" /></a></div>\n" +
                "\t\t\t\t<div class=\"txt\"><a title=\"中华人民共和国成立70周年庆祝活动总结会举行\" target=\"_blank\" href=\"/zixun-xiangqing-190721.html\">中华人民共和国成立70周年庆祝活动总结会举行</a></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\n" +
                "\t\t\t\t\t<div class=\"fl img_txt\">\n" +
                "\t\t\t\t<div class=\"img\"><a title=\"习近平会见尼泊尔总统班达里\" target=\"_blank\" href=\"/zixun-xiangqing-189651.html\"><img width=\"200\" height=\"134\" src=\"/upload/image/2019/10/13/08/42/20191013084243_30385.jpg\" alt=\"习近平会见尼泊尔总统班达里\" /></a></div>\n" +
                "\t\t\t\t<div class=\"txt\"><a title=\"习近平会见尼泊尔总统班达里\" target=\"_blank\" href=\"/zixun-xiangqing-189651.html\">习近平会见尼泊尔总统班达里</a></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\n" +
                "\t\t\t</div>\t\t\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<script>\n" +
                "/*\tfunction fonts(n){\n" +
                "\t\tzfont = document.getElementById(\"zoom\");\n" +
                "\t\tzfont.className = \"fontsize\"+n;\n" +
                "\t}*/\n" +
                "</script>\n" +
                "\t\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t<!--法院相关链接结束-->\n" +
                "\n" +
                "\t<!--友情链接开始-->\n" +
                "    <div class=\"links\">\n" +
                "\t\t\t\t<a href=\"http://cpc.people.com.cn\" target=\"_blank\" title=\"中国共产党新闻网\">中国共产党新闻网</a>\n" +
                "\t\t\t\t<font>|</font>\n" +
                "\t\t\t\t<a href=\"http://www.gov.cn\" target=\"_blank\" title=\"中国政府网\">中国政府网</a>\n" +
                "\t\t\t\t<font>|</font>\n" +
                "\t\t\t\t<a href=\"http://www.npc.gov.cn\" target=\"_blank\" title=\"中国人大网\">中国人大网</a>\n" +
                "\t\t\t\t<font>|</font>\n" +
                "\t\t\t\t<a href=\"http://www.cppcc.gov.cn\" target=\"_blank\" title=\"中国政协网\">中国政协网</a>\n" +
                "\t\t\t\t<font>|</font>\t\n" +
                "\t\t\t\t<a href=\"http://www.chinacourt.org\" target=\"_blank\" title=\"中国法院网\">中国法院网</a>\n" +
                "\t\t\t\t<font>|</font>\t\n" +
                "\t\t\t\t<a href=\"http://www.spp.gov.cn\" target=\"_blank\" title=\"最高人民检察院\">最高人民检察院</a>\n" +
                "                <font>|</font>\t\n" +
                "\t\t\t\t<a href=\"http://zygjjg.12388.gov.cn/\" target=\"_blank\" title=\"中央国家机关举报网站\">中央国家机关举报网站</a>\n" +
                "\t</div>\n" +
                "\t<!--友情链接结束-->\n" +
                "\n" +
                "\t<!--地址 版权开始-->\n" +
                "\t<div class=\"ft\">\n" +
                "\t\t<ul class=\"contact\">\n" +
                "        \t<li class=\"clearfix\">\n" +
                "                <!--法院相关链接-->\n" +
                "                <a href=\"http://www.court.gov.cn/zscq\" target=\"_blank\" title=\"人民法院知识产权审判网 \">人民法院知识产权审判网 </a>\t\n" +
                "                <font>|</font>\n" +
                "                <a href=\"http://www.rmfysszc.gov.cn\" target=\"_blank\" title=\"人民法院诉讼资产网\">人民法院诉讼资产网</a>\t\n" +
                "                <font>|</font>\n" +
                "                <a href=\"http://ipr.court.gov.cn\" target=\"_blank\" title=\"中国知识产权裁判文书网\">中国知识产权裁判文书网</a>\t\n" +
                "                <font>|</font>\n" +
                "                <a href=\"http://wzzx.71.cn\" target=\"_blank\" title=\"中央国家机关理论武装在线\">中央国家机关理论武装在线</a>\n" +
                "                \n" +
                "                <br />\n" +
                "\t\t\t\t<span name=\"3af1cd50bc001f9f506fed4214b766ca\"></span>\t\t\t\n" +
                "\t\t\t\t<span>地址：北京市东城区东交民巷27号</span>\n" +
                "\t\t\t\t<span>邮编：100745</span>\n" +
                "\t\t\t\t<span>总机：67550114</span>\n" +
                "\t\t\t\t<span>举报电话：67556131</span>\n" +
                "\t\t\t</li>\t\n" +
                "\t\t\t<li>中华人民共和国最高人民法院  版权所有</li>\t\n" +
                "\t\t\t<li>京ICP备05023036号</li>\t\n" +
                "\t\t\t<li><script type=\"text/javascript\">document.write(unescape(\"%3Cspan id='_ideConac' %3E%3C/span%3E%3Cscript src='http://dcs.conac.cn/js/33/000/0000/40672309/CA330000000406723090002.js' type='text/javascript'%3E%3C/script%3E\"));</script></li>\n" +
                "            \n" +
                "\t\t</ul>\t\t\t\n" +
                "\t</div>\n" +
                "\t<!--地址 版权结束-->\n" +
                "\t<script>\n" +
                "var _hmt = _hmt || [];\n" +
                "(function() {\n" +
                "  var hm = document.createElement(\"script\");\n" +
                "  hm.src = \"//hm.baidu.com/hm.js?9e03c161142422698f5b0d82bf699727\";\n" +
                "  var s = document.getElementsByTagName(\"script\")[0]; \n" +
                "  s.parentNode.insertBefore(hm, s);\n" +
                "})();\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "/*<![CDATA[*/\n" +
                "jQuery(function($) {\n" +
                "\n" +
                "$(\"#print_article\").click(function(){\n" +
                "\t\t\t$(\".txt_txt\").jqprint();\n" +
                "\n" +
                "\t\t});\n" +
                "\n" +
                "\n" +
                "$(\".word_size a\").click(function(){\n" +
                "\t\t var element = $(\".txt_txt\").css(\"font-size\");\n" +
                "\t\t size =  parseFloat(element , 10);\n" +
                "\t\t \n" +
                "\t\t var className = $(this).attr(\"class\");\n" +
                "\t\t if(className == \"bigger\"){\n" +
                "\t\t \tsize +=2;\t\n" +
                "\t\t }else if(className == \"smaller\"){\n" +
                "\t\t \tsize -=2;\n" +
                "\t\t \tif (size<3){\n" +
                "\t\t \t\tsize = 10;\n" +
                "\t\t \t}\n" +
                "\t\t }\n" +
                "\t\t var suffix = element.slice(-2);\n" +
                "//\t\t alert($(\".txt_txt\").text());\n" +
                "//\t\t $(\".txt_txt\").text($(\".txt_txt\").text())\n" +
                "\t\t $(\".txt_txt\").css(\"font-size\", size+\"px\")\n" +
                "\t}\n" +
                "\t);\n" +
                "\n" +
                "\n" +
                "\t$(\"#keyword\").textUI();\n" +
                "\t$(\"#showtime\").jclock({dateLebal:[\"年\",\"月\",\"日\"]});\n" +
                "\t\n" +
                "\t$(\".btn\").click(function(){\n" +
                "\t\tvar str = $(\"form input:eq(0)\").val();\n" +
                "\t\tstr = str.replace(/\\s+/g, \"\");\n" +
                "\t\tif(str == \"\" || str == \"请输入关键字\"){\n" +
                "\t\t\talert(\"搜索字符不能为空\");\n" +
                "\t\t\treturn false;\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\tif(str.length<2){\n" +
                "\t\t\talert(\"不能小于两个字符\");\n" +
                "\t\t\treturn false;\n" +
                "\t\t}\n" +
                "\t});\n" +
                "\t\n" +
                "\n" +
                "});\n" +
                "/*]]>*/\n" +
                "</script>\n" +
                "</body>\n" +
                "\n" +
                "\n" +
                "</html>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n";
        JavaScriptUtils javaScriptUtils = new JavaScriptUtils();
        String entry = null;
        try {
            entry = javaScriptUtils.entry(str,javaScript);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println(entry);
    }

    public String entry(String str){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String result = "";
        try {
            String path = "C:\\Users\\Public\\Nwt\\cache\\recv\\宫蒙恩\\";
            // FileReader的参数为所要执行的js文件的路径
            engine.eval(new FileReader(path + "lawstarbasic1.24.js"));
            if (engine instanceof Invocable) {
                Invocable invocable = (Invocable) engine;
                Entry executeMethod = invocable.getInterface(Entry.class);
                result = executeMethod.entry(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
