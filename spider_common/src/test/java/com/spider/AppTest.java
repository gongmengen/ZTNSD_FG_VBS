package com.spider;

import static org.junit.Assert.assertTrue;

import com.lawstar.basic.util.Tools;
import com.spider.utils.Tool_file;
import org.junit.Test;

import java.net.URISyntaxException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws URISyntaxException {
        Tool_file toolFile = new Tool_file();
        String filePath = "D:\\test\\dome.txt";
        //String filePathUseProjectUri = toolFile.getFilePathUseProjectUri("js/lawstarlib.js");
        String str = "//lawstar function  basic js lib for law deal 2019-7-14 by yjs ,Beijing.\n" +
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
                "v2.1 BASE  function lib  2019-10-18\n" +
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
                "String.prototype.replaceAll = function (s1, s2) {\n" +
                "    return this.replace(new RegExp(s1, \"gm\"), s2);\n" +
                "}\n" +
                "//字符串对象添加一个toCharArray的方法\n" +
                "String.prototype.indexOf_lawstar = function (tag, attrib,start_idx) {//查找标签 和属性\n" +
                "    var find_idx=-1;\n" +
                "    var str = this;\n" +
                "    start_idx = typeof  start_idx != 'undefined' ?  start_idx : 0;\n" +
                "    if(str==null || tag==null ||attrib==null || str.length==0  || tag.length==0 || attrib.length==0) return find_idx;\n" +
                "\n" +
                "    var start_pos_tag = str.indexOf(tag,start_idx);\n" +
                "    while(start_pos_tag>-1) {\n" +
                "        var end_pos_tag = str.indexOf(\">\",start_pos_tag);\n" +
                "        if(end_pos_tag>-1){\n" +
                "            var searchStr = str.substring(start_pos_tag,end_pos_tag+1);\n" +
                "            var attrib_pos = searchStr.indexOf(attrib);\n" +
                "            // console.log(\"find searchStr = \"+searchStr);\n" +
                "            if(attrib_pos>-1){\n" +
                "                //  console.log(\"find attrib_pos = \"+attrib_pos);\n" +
                "                find_idx = start_pos_tag;\n" +
                "                break;\n" +
                "            }\n" +
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
                "\n" +
                "    var start_pos_tag = start_idx;\n" +
                "\n" +
                "    while((start_pos_tag=str.indexOf(tag,start_pos_tag))>-1) {\n" +
                "        var end_pos_tag = str.indexOf(\">\",start_pos_tag);\n" +
                "        if(end_pos_tag>-1){\n" +
                "            var searchStr = str.substring(start_pos_tag,end_pos_tag+1);\n" +
                "            var attrib_pos = searchStr.indexOf(attrib);\n" +
                "            if(attrib_pos>-1){\n" +
                "                //  console.log(\"find attrib_pos = \"+attrib_pos);\n" +
                "                find_idx = start_pos_tag;\n" +
                "\n" +
                "            }\n" +
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
                "\n" +
                "    var start_pos_tag = str.indexOf(tag);\n" +
                "    if(start_pos_tag>-1) {\n" +
                "        var end_pos_tag = str.indexOf(\">\",start_pos_tag);\n" +
                "        if(end_pos_tag>-1){\n" +
                "            var searchStr = str.substring(start_pos_tag,end_pos_tag+1);\n" +
                "\n" +
                "            var attrib_pos = searchStr.indexOf(attrib);\n" +
                "            if(attrib_pos>-1){\n" +
                "\n" +
                "                str =str.substring(0,start_pos_tag)+rpStr+str.substring(end_pos_tag+1);\n" +
                "\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "    return str;\n" +
                "}\n" +
                "String.prototype.replaceAll_lawstar = function (tag, attrib,rpStr) {//查找并替换所有标签 和属性，并替换该标签\n" +
                "    var find_idx=-1;\n" +
                "    var str = this;\n" +
                "    // console.log(\"this==\"+this)\n" +
                "    //console.log(\"this position==\"+this.indexOf(\"<p align=\\\"right\\\"\"));\n" +
                "    if(str==null || tag==null ||attrib==null || str.length==0  || tag.length==0 || attrib.length==0) return find_idx;\n" +
                "    var start_pos_tag = -1;\n" +
                "    while((start_pos_tag=str.indexOf(tag,start_pos_tag))>-1) {\n" +
                "        var end_pos_tag = str.indexOf(\">\",start_pos_tag);\n" +
                "        if(end_pos_tag>-1){\n" +
                "            var searchStr = str.substring(start_pos_tag,end_pos_tag+1);\n" +
                "            // console.log(\"find searchStr = \"+searchStr);\n" +
                "            var attrib_pos = searchStr.indexOf(attrib);\n" +
                "            if(attrib_pos>-1){\n" +
                "                //   console.log(\"find attrib_pos = \"+attrib_pos);\n" +
                "                str =str.substring(0,start_pos_tag)+rpStr+str.substring(end_pos_tag+1);\n" +
                "                // console.log(\"str= \"+str);\n" +
                "            }\n" +
                "        }\n" +
                "        start_pos_tag++;\n" +
                "        // console.log(\"start_pos_tag==\"+start_pos_tag)\n" +
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
                "\n" +
                "    if(str==null || tag_start==null ||attrib==null || tag_end==null || str.length==0  || tag_start.length==0 || attrib.length==0 || tag_end.length==0) return idx_arr;\n" +
                "\n" +
                "    start_pos_tag = str.indexOf(tag_start);\n" +
                "\n" +
                "    while(start_pos_tag>-1) {\n" +
                "        var end_pos_tag = str.indexOf(\">\",start_pos_tag);\n" +
                "        if(end_pos_tag>-1){\n" +
                "            var searchStr = str.substring(start_pos_tag,end_pos_tag+1);\n" +
                "            var attrib_pos = searchStr.indexOf(attrib);\n" +
                "            if(attrib_pos>-1){\n" +
                "                //   console.log(\"find attrib_pos = \"+attrib_pos);\n" +
                "                find_idx = start_pos_tag;\n" +
                "                break;\n" +
                "            }\n" +
                "        }\n" +
                "        start_pos_tag = str.indexOf(tag_start,start_pos_tag+1);\n" +
                "    }\n" +
                "    if(start_pos_tag>-1){\n" +
                "        //寻找匹配标签，基本算法，找到结束标签，查看这段字符是否有相等的开始标签和结束标签，有，找到结果，没有，继续\n" +
                "        tag_end_find_idx = str.indexOf(tag_end,start_pos_tag);\n" +
                "        while(tag_end_find_idx>-1) {\n" +
                "            //统计这这段字符的开始标签和结束标签\n" +
                "            var searchStr = str.substring(start_pos_tag,tag_end_find_idx+tag_end.length);\n" +
                "            //console.log(\"searchStr = \"+searchStr);\n" +
                "            var count_start_tag = countStr(searchStr,tag_start);\n" +
                "            // console.log(\"count_start_tag = \"+count_start_tag);\n" +
                "            var count_end_tag = countStr(searchStr,tag_end);\n" +
                "            // console.log(\"count_end_tag = \"+count_end_tag);\n" +
                "            if(count_start_tag==count_end_tag){\n" +
                "                // console.log(\"find tag_end = \"+tag_end_find_idx);\n" +
                "                break;\n" +
                "            }\n" +
                "            tag_end_find_idx = str.indexOf(tag_end,tag_end_find_idx+1);\n" +
                "        }\n" +
                "    }\n" +
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
                "//发布日期\n" +
                "function formatDateStr(str){\n" +
                "\n" +
                "    if((str.indexOf(\"年\")>-1 && str.indexOf(\"月\")>-1 && str.indexOf(\"日\")>-1)  ||str.indexOf(\"-\")>-1){\n" +
                "        var dateArr  = getDigit(str);\n" +
                "\n" +
                "        if(dateArr[1].length==1) dateArr[1] = \"0\"+dateArr[1];\n" +
                "        if(dateArr[2].length==1) dateArr[2] = \"0\"+dateArr[2];\n" +
                "        datestr =  dateArr[0]+dateArr[1]+dateArr[2];\n" +
                "        str = datestr;\n" +
                "        // return datestr;\n" +
                "    }\n" +
                "    str = str.replace(\"年\", \"\");\n" +
                "    str = str.replace(\"月\", \"\");\n" +
                "    str = str.replace(\"日\", \"\");\n" +
                "    str = str.replaceAll(\"-\", \"\");\n" +
                "    return str;\n" +
                "}\n" +
                "\n" +
                "\n" +
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
                "        //  console.log(\"current_pos--\"+current_pos)\n" +
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
                "        current_pos = current_pos + start_token.length;\n" +
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
                "            newStr = spaceX;\n" +
                "            // console.log(\"--\"+newStr)\n" +
                "            txt = txt.substring(0,current_pos)+newStr+txt.substring(endLine_pos+end_token.length);\n" +
                "\n" +
                "        }\n" +
                "        current_pos = current_pos + start_token.length;\n" +
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
                " *把数字转换成大写汉字\n" +
                " * @param c 需要转换的字符\n" +
                " * @return 成功返回对应的整数汉字\n" +
                " */\n" +
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
                " * 数字转换成对应大写整数 101 -->一百零一\n" +
                " * @param dd\n" +
                " * @return\n" +
                " */\n" +
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
                "        return \"\";\n" +
                "    }\n" +
                "    var arr = [];\n" +
                "    arr.push(\"0x\");\n" +
                "    for(var i=0;i<str.length;i++){\n" +
                "        arr.push(str.charCodeAt(i).toString(16));\n" +
                "    }\n" +
                "    return arr.join('');\n" +
                "}\n" +
                "// 16进制转字符串\n" +
                "// \n" +
                "function hex2str(hex) {\n" +
                "    var trimedStr = hex.trim();\n" +
                "    var rawStr = trimedStr.substr(0,2).toLowerCase() === \"0x\" ? trimedStr.substr(2) : trimedStr;\n" +
                "    var len = rawStr.length;\n" +
                "    if(len % 2 !== 0) {\n" +
                "        alert(\"Illegal Format ASCII Code!\");\n" +
                "        return \"\";\n" +
                "    }\n" +
                "    var curCharCode;\n" +
                "    var resultStr = [];\n" +
                "    for(var i = 0; i < len;i = i + 2) {\n" +
                "        curCharCode = parseInt(rawStr.substr(i, 2), 16);\n" +
                "        resultStr.push(String.fromCharCode(curCharCode));\n" +
                "    }\n" +
                "    return resultStr.join(\"\");\n" +
                "}\n" +
                "\n" +
                "\n" +
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
                "            // console.log(\"align_str=\"+align_str)\n" +
                "            align_str = replaceAllHtlm(align_str);\n" +
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
                "    return txt;\n" +
                "\n" +
                "}\n" +
                "//多行居中标签替换，包括BR等。\n" +
                "function align_center_moreLineAll(txt,start_token,end_token){\n" +
                "    var  start_token_idx = txt.indexOf(start_token);\n" +
                "    while(start_token_idx>-1){\n" +
                "        //  console.log(\"txte=\"+txt)\n" +
                "        var  end_token_idx = txt.indexOf(end_token,start_token_idx+1);\n" +
                "\n" +
                "        if (end_token_idx>0){\n" +
                "            align_str = txt.substring(start_token_idx,end_token_idx);\n" +
                "            // console.log(\"align_str=\"+align_str)\n" +
                "            align_str = replaceAllHtlm(align_str);\n" +
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
                "    return txt;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "//多行居右标签替换，包括BR等。\n" +
                "function align_right_moreLine(txt,start_token,end_token){\n" +
                "    var  start_token_idx = txt.indexOf(start_token);\n" +
                "    if(start_token_idx>0){\n" +
                "        var  end_token_idx = txt.indexOf(end_token,start_token_idx);\n" +
                "        if (end_token_idx>0){\n" +
                "            align_str = txt.substring(start_token_idx,end_token_idx);\n" +
                "            align_str = replaceAllHtlm(align_str);\n" +
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
                "    return txt;\n" +
                "\n" +
                "}\n" +
                "//多行居右标签替换，包括BR等。替换所有\n" +
                "function align_right_moreLineAll(txt,start_token,end_token){\n" +
                "    var  start_token_idx = txt.indexOf(start_token);\n" +
                "    while(start_token_idx>0){\n" +
                "        var  end_token_idx = txt.indexOf(end_token,start_token_idx);\n" +
                "        if (end_token_idx>0){\n" +
                "            align_str = txt.substring(start_token_idx,end_token_idx);\n" +
                "            align_str = replaceAllHtlm(align_str);\n" +
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
                "    return txt;\n" +
                "\n" +
                "}\n" +
                "//多行居右标签替换，包括BR等。替换所有,属性关键字查找\n" +
                "function align_right_moreLineAll_TAG(txt,start_token_tag,end_token,attribStr){\n" +
                "    // console.log(\"  find =\"+start_token_tag);\n" +
                "    var  start_token_idx = txt.indexOf(start_token_tag);\n" +
                "    //console.log(\"  find =\"+start_token_idx);\n" +
                "    while(start_token_idx>-1){\n" +
                "        var close_tag_idx = txt.indexOf(\">\",start_token_idx);\n" +
                "        //  console.log(\"  close_tag_idx =\"+close_tag_idx);\n" +
                "        if(close_tag_idx >-1){\n" +
                "            align_str = txt.substring(start_token_idx,close_tag_idx+1);\n" +
                "\n" +
                "            if(align_str.search(attribStr)==-1){\n" +
                "\n" +
                "                start_token_idx = txt.indexOf(start_token_tag,start_token_idx+1);\n" +
                "                // console.log(\"  start_token_idx ccc =\"+start_token_idx);\n" +
                "                continue;\n" +
                "            }\n" +
                "        }\n" +
                "        var  end_token_idx = txt.indexOf(end_token,close_tag_idx);\n" +
                "        if (end_token_idx>0){\n" +
                "            align_str = txt.substring(start_token_idx,end_token_idx);\n" +
                "\n" +
                "            align_str = replaceAllHtlm(align_str);\n" +
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
                "    return txt;\n" +
                "\n" +
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
                "            for (var xx = 0; xx < tmp_str_arr.length; xx++) {\n" +
                "                align_str = align_str+tmp_str_arr[xx].trim();\n" +
                "            }\n" +
                "\n" +
                "            if(align_str.length>0){\n" +
                "                align_str =space_36+ align_str+br_str;\n" +
                "            }\n" +
                "            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx);\n" +
                "        }\n" +
                "\n" +
                "    }\n" +
                "    return txt;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "\n" +
                "//处理正文章节条函数\n" +
                "function deal_paragraph(txt){\n" +
                "    /*\n" +
                "    处理基本算法，\n" +
                "    1、如果是目录，跳过，目录基本判断，连续是章节，中间没有正文\n" +
                "    2、章节的处理。6个空格，上下空行，基本判断 第字开头， 章 或者 节 空格，中间文字不超过 5个字符，第一百四十五条\n" +
                "    3、条的处理 前面空4个，后面 空2个\n" +
                "    4、最后在处理目录问题，如果发现连续出现章节的，已经排版好的，删除空行\n" +
                "    */\n" +
                "\n" +
                "    //console.log(\"bbb txt\"+txt);\n" +
                "    var tmp_str_arr = txt.split(br_str);\n" +
                "    txt = \"\";\n" +
                "    var maxLen =6;//第字 和章节条之间的字符数量\n" +
                "    //处理\n" +
                "    /*strtiao = Replace(strtiao, \"条　\", \"条  \")\n" +
                "     strtiao = Replace(strtiao, \"章　\", \"章  \")\n" +
                "     strtiao = Replace(strtiao, \"章 \", \"章  \")\n" +
                "     strtiao = Replace(strtiao, \"章   \", \"章  \")*/\n" +
                "    var str_di=\"第\";\n" +
                "    var str_zhang=\"章\";\n" +
                "    var str_jie=\"节\";\n" +
                "    var str_tiao=\"条\";\n" +
                "    var MaxStrLen = 5;//中间文字不超过 5个字符，第一百四十五条\n" +
                "    for (var xx = 0; xx < tmp_str_arr.length; xx++) {\n" +
                "        if (tmp_str_arr[xx].trim().length > 0) {\n" +
                "            //    console.log(\"-----------\"+tmp_str_arr[xx])\n" +
                "            //先看章\n" +
                "            var start_di =tmp_str_arr[xx].indexOf(str_di);\n" +
                "            var start_zhang =tmp_str_arr[xx].indexOf(str_zhang);\n" +
                "            var start_jie =tmp_str_arr[xx].indexOf(str_jie);\n" +
                "            var start_tiao =tmp_str_arr[xx].indexOf(str_tiao);\n" +
                "            //先完成开发，然后在考虑优化，\n" +
                "            if(start_di>0){//有第字\n" +
                "                if(start_zhang>0 && start_di<start_zhang && (start_zhang-start_di)<=MaxStrLen&&  start_zhang>start_jie && start_zhang>start_tiao  ){//章处理，有章字 章 字 必须在节 和条的前面，才算，而且中间不能大于字符  &&  tmp_str_arr[xx].substring(start_di,start_zhang).length>MaxStrLen\n" +
                "                    // console.log(\"有第 MM 章\");\n" +
                "                    //在章后面加上2个英文空格\n" +
                "                    var str_z_tmp = tmp_str_arr[xx].substring(0,start_zhang+1);\n" +
                "                    tmp_str_arr[xx] = str_z_tmp +space_2+tmp_str_arr[xx].substring(start_zhang+1).trim();\n" +
                "                    //看看后面是否有空行，有就不用增加\n" +
                "                    if((xx+1)<tmp_str_arr.length &&  tmp_str_arr[xx+1].trim().length==0){//有换行，不加\n" +
                "                        tmp_str_arr[xx] = tmp_str_arr[xx].trim() ;//先删除空格，在补充  //然后6空格，\n" +
                "                    }else{\n" +
                "                        tmp_str_arr[xx] = tmp_str_arr[xx].trim() + br_str;//先删除空格，在补充  //然后6空格，前后空行\n" +
                "                    }\n" +
                "\n" +
                "                    //看看前面是否已经有空行了，有就不用添加\n" +
                "                    if((xx-1)>=0 &&  tmp_str_arr[xx-1].trim().length==0){//有换行，不加\n" +
                "                        tmp_str_arr[xx] = space_6 + tmp_str_arr[xx];\n" +
                "                    }else{\n" +
                "                        tmp_str_arr[xx] = br_str+space_6 + tmp_str_arr[xx];\n" +
                "                    }\n" +
                "\n" +
                "\n" +
                "                }else if(start_jie>0  && start_di<start_jie && (start_jie-start_di)<=MaxStrLen && start_jie>start_tiao){//有节字\n" +
                "                    // console.log(\"有第 MM 节\");\n" +
                "                    //在节后面加上2个英文空格\n" +
                "                    var str_z_tmp = tmp_str_arr[xx].substring(0,start_jie+1);\n" +
                "                    tmp_str_arr[xx] = str_z_tmp +space_2+tmp_str_arr[xx].substring(start_jie+1).trim();\n" +
                "                    tmp_str_arr[xx] = tmp_str_arr[xx].trim() + br_str;//先删除空格，在补充  //然后6空格\n" +
                "                    tmp_str_arr[xx] = br_str+space_6 + tmp_str_arr[xx];\n" +
                "                }else if(start_tiao>0  && start_di<start_tiao && (start_tiao-start_di)<=MaxStrLen ){//有条字\n" +
                "                    // console.log(\"有第 MM 条\");\n" +
                "                    //在条后面加上2个英文空格\n" +
                "                    var str_z_tmp = tmp_str_arr[xx].substring(0,start_tiao+1);\n" +
                "                    tmp_str_arr[xx] = str_z_tmp +space_2+tmp_str_arr[xx].substring(start_tiao+1).trim();\n" +
                "                    tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格，在补充  //然后4空格\n" +
                "                    tmp_str_arr[xx] = space_4 + tmp_str_arr[xx];\n" +
                "                }\n" +
                "\n" +
                "            }\n" +
                "\n" +
                "            txt = txt + tmp_str_arr[xx] + br_str;\n" +
                "\n" +
                "        }else{\n" +
                "            txt = txt + tmp_str_arr[xx] + br_str;\n" +
                "        }\n" +
                "\n" +
                "    }\n" +
                "    //处理完成章节，查看 如果连续两个第一章，认为是目录。\n" +
                "    //处理空行\n" +
                "    var first_zhang =   txt.indexOf(\"      第一章\");\n" +
                "    var last_zhang =txt.lastIndexOf(\"      第一章\");\n" +
                "    if(first_zhang>-1 && last_zhang>0 && last_zhang>first_zhang){//有目录\n" +
                "        var str_mulu_tmp = txt.substring(first_zhang,last_zhang);\n" +
                "        str_mulu_tmp = str_mulu_tmp.replaceAll(\"\\r\\n\\r\\n\",\"\");\n" +
                "        txt=txt.substring(0,first_zhang)+str_mulu_tmp+br_str+txt.substring(last_zhang);\n" +
                "    }\n" +
                "\n" +
                "    // console.log(\"aaaa txt=\"+txt);\n" +
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
                "            // console.log(\"-----------\"+tmp_str_arr[xx])\n" +
                "            //处理多余空格\n" +
                "            //先36空格\n" +
                "            if (tmp_str_arr[xx].indexOf(space_6) > -1 && (tmp_str_arr[xx].length - tmp_str_arr[xx].trim().length) > 20) {\n" +
                "                tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格，在补充\n" +
                "                tmp_str_arr[xx] = space_36 + tmp_str_arr[xx];  //换行专门处理\n" +
                "            } else if (tmp_str_arr[xx].indexOf(space_6) > -1 && (tmp_str_arr[xx].length - tmp_str_arr[xx].trim().length) >= 6) {\n" +
                "                //console.log(\"-----------\"+tmp_str_arr[xx])\n" +
                "                tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格，在补充  //然后6空格\n" +
                "                tmp_str_arr[xx] = space_6 + tmp_str_arr[xx]+ br_str;\n" +
                "                // console.log(\"---ll--------\"+tmp_str_arr[xx])\n" +
                "            } else if (tmp_str_arr[xx].indexOf(space_2) > -1 && (tmp_str_arr[xx].length - tmp_str_arr[xx].trim().length) >= 2) {\n" +
                "\n" +
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
                "\n" +
                "                        //加上后面的字符\n" +
                "                        var last_idx = str_36.lastIndexOf(\"日\");\n" +
                "\n" +
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
                "            continue;\n" +
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
                "\n" +
                "            //36空格\n" +
                "            if (tmp_str_arr[xx].indexOf(space_36) > -1 && !isDateStr(tmp_str_arr[xx].trim())) {//排除日期\n" +
                "                // console.log(\"-----------\"+tmp_str_arr[xx])\n" +
                "                var department_arr =  tmp_str_arr[xx].trim().split(\" \");//如果是空格或者一个字符，全部数组，合并\n" +
                "                var is_find = false;\n" +
                "                var new_department_str=\"\";\n" +
                "                for(var yy=0;yy<department_arr.length;yy++){\n" +
                "                    if(department_arr[yy].length<=1){\n" +
                "                        new_department_str = new_department_str+department_arr[yy].trim();\n" +
                "                        //   console.log(\"-----------\"+new_department_str)\n" +
                "                        is_find= true;\n" +
                "                    }else{\n" +
                "                        is_find= false;\n" +
                "                        break;\n" +
                "                    }\n" +
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
                "    //删除开头空格\n" +
                "    for (var mm = 0; mm < 10; mm++) {\n" +
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
                "    //反过来处理部门居右问题\n" +
                "    var xx = tmp_str_arr.length-1;\n" +
                "    //最后一行有日期，且有6空格，居中标示\n" +
                "    // console.log(\"ll=\"+tmp_str_arr[xx])\n" +
                "    if(tmp_str_arr[xx]!=null &&  tmp_str_arr[xx].trim().length==0){//去掉最后一行\n" +
                "        xx =xx-1;\n" +
                "    }\n" +
                "    if(tmp_str_arr[xx]!=null && tmp_str_arr[xx].trim().length>0 &&  tmp_str_arr[xx].indexOf(space_6)>-1 && tmp_str_arr[xx].indexOf(\"年\")>-1 &&  tmp_str_arr[xx].indexOf(\"月\")>-1 &&  tmp_str_arr[xx].indexOf(\"日\")>-1 ){\n" +
                "        tmp_str_arr[xx]   =space_36+ tmp_str_arr[xx].trim();\n" +
                "        for (xx = xx-1; xx >=0; xx--) {\n" +
                "            if (tmp_str_arr[xx].trim().length > 0 &&  tmp_str_arr[xx].indexOf(space_6)>-1 ) {\n" +
                "                tmp_str_arr[xx]   =space_36+ tmp_str_arr[xx].trim();\n" +
                "            }else{\n" +
                "                break;\n" +
                "            }\n" +
                "\n" +
                "        }\n" +
                "    }\n" +
                "    //重新组合正文\n" +
                "    for (var xx =0; xx < tmp_str_arr.length; xx++) {\n" +
                "        if (tmp_str_arr[xx].trim().length > 0) {\n" +
                "            txt =   txt+tmp_str_arr[xx]+br_str;\n" +
                "        }\n" +
                "\n" +
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
                "        // console.log(\"-----\"+tmp_str_arr[start]);\n" +
                "        if(tmp_str_arr[start].trim().length==0)  {start++;continue;}\n" +
                "        if(tmp_str_arr[start].charAt(tmp_str_arr[start].length-1)!='号'){\n" +
                "            if(txt.length==0) txt = space_6;\n" +
                "            txt = txt+tmp_str_arr[start].trim();\n" +
                "        }else{\n" +
                "            txt = txt+br_str+br_str;\n" +
                "            break;\n" +
                "        }\n" +
                "        start++;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    for (var xx =start; xx < tmp_str_arr.length; xx++) {\n" +
                "        txt =   txt+tmp_str_arr[xx]+br_str;\n" +
                "    }\n" +
                "    return txt;\n" +
                "}\n" +
                "//处理正文附件标题\n" +
                "function deal_attach_titles(txt){\n" +
                "    var fujian_token=\"附件：\";\n" +
                "    var end_token = \"</div>\";\n" +
                "    var start_2  = txt.indexOf(fujian_token);\n" +
                "\n" +
                "    if (start_2 >= 0) {\n" +
                "        var start_3 = txt.indexOf(end_token, start_2);\n" +
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
                "\n" +
                "                }\n" +
                "\n" +
                "            }\n" +
                "            tmp_str_ok = tmp_str_ok.replaceAll(\"[*]\", \"×\");\n" +
                "\n" +
                "            var fj_pos = tmp_str_ok.indexOf(fujian_token);\n" +
                "            if(fj_pos>-1){\n" +
                "                tmp_str_ok =  insertStr(tmp_str_ok,br_str+space_4,fj_pos+fujian_token.length)\n" +
                "            }\n" +
                "\n" +
                "            txt = txt.replaceAll(tmp_str_bak, tmp_str_ok);\n" +
                "        }\n" +
                "\n" +
                "    }//end 处理 附件\n" +
                "    return txt;\n" +
                "}";
        Tools.writeFile(filePath,str,"UTF-8");
    }
}
