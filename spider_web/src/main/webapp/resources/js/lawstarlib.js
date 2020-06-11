//lawstar function  basic js lib for law deal 2019-7-14 by yjs ,Beijing.
/*
v1.03 针对税务局优化脚本。
v1.04 40263 国家发展和改革委员会。 优化部门
v1.05 40308 国家财政部。 优化部门
v1.06 40308 国家财政部。 不同栏目
v1.07 40369 生态环境部。 不同栏目、
v1.08 40362 商务部。 不同栏目
v1.09 交通运输部。 不同栏目
v1.10 自然资源部
v1.10.03 重新适配税务局，使用新的代码，13.42-14.10,=22分钟，。
v1.11 科技部，17.10-17.23=13分钟，。
v1.12 民政部，13.53-14.12=19分钟。
v1.13 农业部，17.15-17.50=30分钟，。正文排版
v1.14 四川省人民政府办公厅，2019-8-26 11.46-
v1.15 上海市人民政府办公厅，2019-8-26 18.00-
v1.16 广西人民政府办公厅，2019-8-26 18.08- 17
v1.17 陕西人民政府办公厅，2019-8-27 16.39-
v1.18 河北省人民政府，2019-8-28 17.42
v1.19 宁夏回族自治区人民政府 2019-8-30 17.50-17.56
v1.20 青岛政务网 2019-9-3 11.41- 51, 10分钟。
v1.21 贵州生人民政府 2019-9-4 17.12-22 , 10分钟。
v1.22 教育部 2019-9-17 18.18-29 , 10分钟。
v1.23 人力资源部 2019-9-19 18.12- , 10分钟。
v1.23 市场监管总局 2019-9-29 15.35- , 10分钟。
v2.1 BASE  function lib  2019-10-18
v2.2 修正发布部门替换多个居中换行问题，删除</p>标签
v2.2.1 修正开头空格才能处理的居中、居右等。
v2.2.2 增加剧中 居右同意函数
v2.3 优化居中 、居右 通用函数 支持正则表达式 2019-10-24 

v 2020-3-23 优化发布日期转换、表格居中问题。
2020-3-25  bug 升级 tabReg_global.lastIndex=0;//test 方法使用使用/g参数会移动搜索位置，所以每次要重置开始的位置。
*/
//36格子
var space_36 = "                                    ";
//6格子
var space_6 = "      ";
//4格子
var space_4 = "    ";
//2格子
var space_2 = "  ";
var br_str = "\r\n";

String.prototype.replaceAll = function (s1, s2) {
    return this.replace(new RegExp(s1, "gm"), s2);
}
//字符串对象添加一个toCharArray的方法
String.prototype.indexOf_lawstar = function (tag, attrib,start_idx) {//查找标签 和属性
    var find_idx=-1;
    var str = this;
    start_idx = typeof  start_idx != 'undefined' ?  start_idx : 0;
    if(str==null || tag==null ||attrib==null || str.length==0  || tag.length==0 || attrib.length==0) return find_idx;
    
    var start_pos_tag = str.indexOf(tag,start_idx);
    while(start_pos_tag>-1) {
        var end_pos_tag = str.indexOf(">",start_pos_tag);
        if(end_pos_tag>-1){
              var searchStr = str.substring(start_pos_tag,end_pos_tag+1);
              var attrib_pos = searchStr.indexOf(attrib);
             // console.log("find searchStr = "+searchStr);
              if(attrib_pos>-1){
                //  console.log("find attrib_pos = "+attrib_pos);
                  find_idx = start_pos_tag;
                  break;
              }
        }
        start_pos_tag = str.indexOf(tag,start_pos_tag+1);
    }
    return find_idx;
}
String.prototype.lastIndexOf_lawstar = function (tag, attrib,start_idx) {//查找最后标签 和属性
    var find_idx=-1
    var str = this;
    start_idx = typeof  start_idx != 'undefined' ?  start_idx : 0;
    if(str==null || tag==null ||attrib==null || str.length==0  || tag.length==0 || attrib.length==0) return find_idx;
    
    var start_pos_tag = start_idx;

    while((start_pos_tag=str.indexOf(tag,start_pos_tag))>-1) {
        var end_pos_tag = str.indexOf(">",start_pos_tag);
        if(end_pos_tag>-1){
              var searchStr = str.substring(start_pos_tag,end_pos_tag+1);
              var attrib_pos = searchStr.indexOf(attrib);
              if(attrib_pos>-1){
                //  console.log("find attrib_pos = "+attrib_pos);
                  find_idx = start_pos_tag;
                  
              }
        }
        start_pos_tag++;
    }
    return find_idx;
}

String.prototype.replace_lawstar = function (tag, attrib,rpStr) {//查找并替换标签 和属性，并替换该标签
    var find_idx=-1;
    var str = this;
    if(str==null || tag==null ||attrib==null || str.length==0  || tag.length==0 || attrib.length==0) return str;
   
    var start_pos_tag = str.indexOf(tag);
    if(start_pos_tag>-1) {
        var end_pos_tag = str.indexOf(">",start_pos_tag);
        if(end_pos_tag>-1){
              var searchStr = str.substring(start_pos_tag,end_pos_tag+1);
             
              var attrib_pos = searchStr.indexOf(attrib);
              if(attrib_pos>-1){
                
                  str =str.substring(0,start_pos_tag)+rpStr+str.substring(end_pos_tag+1);
                   
              }
        }
    }
    return str;
}
String.prototype.replaceAll_lawstar = function (tag, attrib,rpStr) {//查找并替换所有标签 和属性，并替换该标签
    var find_idx=-1;
    var str = this;
   // console.log("this=="+this)
    //console.log("this position=="+this.indexOf("<p align=\"right\""));
    if(str==null || tag==null ||attrib==null || str.length==0  || tag.length==0 || attrib.length==0) return find_idx;
    var start_pos_tag = -1;
    while((start_pos_tag=str.indexOf(tag,start_pos_tag))>-1) {
        var end_pos_tag = str.indexOf(">",start_pos_tag);
        if(end_pos_tag>-1){
            var searchStr = str.substring(start_pos_tag,end_pos_tag+1);
           // console.log("find searchStr = "+searchStr);
            var attrib_pos = searchStr.indexOf(attrib);
            if(attrib_pos>-1){
             //   console.log("find attrib_pos = "+attrib_pos);
                str =str.substring(0,start_pos_tag)+rpStr+str.substring(end_pos_tag+1);
               // console.log("str= "+str);
                 }
          }
        start_pos_tag++;
       // console.log("start_pos_tag=="+start_pos_tag)
    }
    return str;
}

//查找开始标签和结束标签,返回匹配的标签位置
String.prototype.findTagPostion = function (tag_start, attrib,tag_end) {//查找标签 和属性,结束标签
    var start_pos_tag=-1;
    var tag_end_find_idx=-1;//结束标签位置
    var idx_arr  =new Array(2);
    idx_arr[0] = start_pos_tag;
    idx_arr[1] = tag_end_find_idx;
    var find_idx =-1;
    var str = this;
  
    if(str==null || tag_start==null ||attrib==null || tag_end==null || str.length==0  || tag_start.length==0 || attrib.length==0 || tag_end.length==0) return idx_arr;
  
    start_pos_tag = str.indexOf(tag_start);
   
    while(start_pos_tag>-1) {
        var end_pos_tag = str.indexOf(">",start_pos_tag);
        if(end_pos_tag>-1){
              var searchStr = str.substring(start_pos_tag,end_pos_tag+1);
              var attrib_pos = searchStr.indexOf(attrib);
              if(attrib_pos>-1){
               //   console.log("find attrib_pos = "+attrib_pos);
                  find_idx = start_pos_tag;
                  break;
              }
        }
        start_pos_tag = str.indexOf(tag_start,start_pos_tag+1);
    }
    if(start_pos_tag>-1){
          //寻找匹配标签，基本算法，找到结束标签，查看这段字符是否有相等的开始标签和结束标签，有，找到结果，没有，继续
        tag_end_find_idx = str.indexOf(tag_end,start_pos_tag);
        while(tag_end_find_idx>-1) {
            //统计这这段字符的开始标签和结束标签
            var searchStr = str.substring(start_pos_tag,tag_end_find_idx+tag_end.length);
            //console.log("searchStr = "+searchStr);
            var count_start_tag = countStr(searchStr,tag_start);
           // console.log("count_start_tag = "+count_start_tag);
            var count_end_tag = countStr(searchStr,tag_end);
           // console.log("count_end_tag = "+count_end_tag);
            if(count_start_tag==count_end_tag){
               // console.log("find tag_end = "+tag_end_find_idx);
                break;
            }
            tag_end_find_idx = str.indexOf(tag_end,tag_end_find_idx+1);
        }
    } 
    idx_arr[0] = find_idx;
    idx_arr[1] = tag_end_find_idx;
    return idx_arr;
}
String.prototype.toCharArray = function () {
    var arr = new Array();
    for (var index = 0; index < this.length; index++) {
        arr[index] = this.charAt(index);
    }
    return arr;
}
//发布日期
function formatDateStr(str){

    if((str.indexOf("年")>-1 && str.indexOf("月")>-1 && str.indexOf("日")>-1)  ||str.indexOf("-")>-1){
        var dateArr  = getDigit(str);
        
        if(dateArr[1].length==1) dateArr[1] = "0"+dateArr[1];
        if(dateArr[2].length==1) dateArr[2] = "0"+dateArr[2];
        datestr =  dateArr[0]+dateArr[1]+dateArr[2];
        str = datestr;
       // return datestr;
    }
   str = str.replace("年", "");
    str = str.replace("月", "");
    str = str.replace("日", "");
    str = str.replaceAll("-", "");
    return str;
}
  
  

 //替换标签,
function replaceAllHtml(str) {
   return replaceAllHtlm(str);
}
 
function replace_lt_gt_Tag(str) {
    str = str.replaceAll("&lt;", "<");
    str = str.replaceAll("&gt;", ">");//span&gt;
    return (str);
 }
//替换标签 手误，使用 replaceAllHtml
function replaceAllHtlm(str) {
    var reTag = /<(?:.|\s)*?>/g;
    str = str.replaceAll("&nbsp;", " ");
   
    str = str.replaceAll("&emsp;", " ");
    str = str.replaceAll("&ensp;", " ");
    str = str.replaceAll(hex2str("0x09"), " ");
    str = str.replaceAll(hex2str("0xC2"), " ");
    str = str.replaceAll(hex2str("0xA0"), " "); //特殊空格
    str = str.replace(/<[/]?[bB][rR][ ]?[/]?>/ig, "\r\n");// </br> <br /> <br> 大小写等
    str = str.replace(/<[bB][rR] .*?>/ig, "\r\n");// <BR SSSXXX>   大小写等
    str = str.replace(/<[/]?[pP][ /]?>/ig, "\r\n");// <p> </p> 大小写
    str = str.replace(/<script.*?>.*?<\/script>/ig, '');
    str = str.replace(/<script[^>]*>([\s\S](?!<script))*?<\/script>/ig, '');
    str = str.replace(/<style[^>]*>([\s\S](?!<style))*?<\/style>/ig, '');
    str = str.replaceAll("&#8220;", "“");
    str = str.replaceAll("&#8221;", "”");
    str = str.replaceAll("　", "  ");
    str = str.replaceAll("&ldquo;", "“");
    str = str.replaceAll("&rdquo;", "”");
    str = str.replaceAll("&rdquo;", "”");
    str =str.replace(reTag, "")
    str = str.replaceAll("-->", "");
    return str;
}
//替换居中、居右标签，同时增加前置空格
function replaceBlock(txt,start_token,end_token,spaceX,removeHtmlTag){
    removeHtmlTag = typeof  removeHtmlTag != 'undefined' ?  removeHtmlTag : true;
    var last_pos = -1;
    var current_pos = -1;
    var first_add = false;
    var last_add = false;
    while ((current_pos = txt.indexOf(start_token, current_pos)) > -1) {
      //  console.log("current_pos--"+current_pos)
        endLine_pos = txt.indexOf(end_token, current_pos)
        //新的部门处理
        if (endLine_pos> 1) { //发现，去标签，增加空格
            var newStr = txt.substring(current_pos, endLine_pos);
            if (removeHtmlTag){
                newStr = replaceAllHtlm(newStr); //移除标签
                newStr = spaceX+newStr;
                txt = txt.substring(0,current_pos)+newStr+txt.substring(endLine_pos+end_token.length);
            }else{
                newStr = spaceX+newStr;
                txt = txt.substring(0,current_pos)+newStr+txt.substring(endLine_pos);
            }

        }
       current_pos = current_pos + start_token.length;

    }
    return txt;
}
//替换居中、居右标签，同时增加前置空格,后面增加回车换
function replaceBlockAddBr(txt,start_token,end_token,spaceX,removeHtmlTag){
    removeHtmlTag = typeof  removeHtmlTag != 'undefined' ?  removeHtmlTag : true;
    var last_pos = -1;
    var current_pos = -1;
    var first_add = false;
    var last_add = false;
    while ((current_pos = txt.indexOf(start_token, current_pos)) > -1) {
      //  console.log("current_pos--"+current_pos)
        endLine_pos = txt.indexOf(end_token, current_pos)
        //新的部门处理
        if (endLine_pos> 1) { //发现，去标签，增加空格
            var newStr = txt.substring(current_pos, endLine_pos);
            if (removeHtmlTag){
                newStr = replaceAllHtlm(newStr); //移除标签
                newStr = spaceX+newStr+br_str;
                txt = txt.substring(0,current_pos)+newStr+txt.substring(endLine_pos+end_token.length);
            }else{
                newStr = spaceX+newStr+br_str;
                txt = txt.substring(0,current_pos)+newStr+txt.substring(endLine_pos);
            }

        }
       current_pos = current_pos + start_token.length;

    }
    return txt;
}
//替换居中、居右标签，同时增加前置空格
function removeBlock(txt,start_token,end_token,spaceX){
    var last_pos = -1;
    var current_pos = -1;
    var first_add = false;
    var last_add = false;
    while ((current_pos = txt.indexOf(start_token, current_pos)) > -1) {
        endLine_pos = txt.indexOf(end_token, current_pos)
        //新的部门处理
        if (endLine_pos> 1) { //发现，去标签，增加空格
            var newStr = txt.substring(current_pos, endLine_pos);
            newStr = spaceX;   
           // console.log("--"+newStr)
            txt = txt.substring(0,current_pos)+newStr+txt.substring(endLine_pos+end_token.length);

        }
       current_pos = current_pos + start_token.length;

    }
    return txt;
}
// 插入函数
//参数说明：strSrc表示原字符串变量，addStr表示要插入的字符串，pos表示要插入的位置
function insertStr(strSrc, addStr, pos) {
    if (pos > strSrc.length) return strSrc + addStr;
    if (pos <= 0) return addStr + strSrc;
    strSrc = strSrc.substring(0, pos) + addStr + strSrc.substring(pos);
    return strSrc;
}
// 统计字符串数量函数
//参数说明：strSrc表示原字符串变量，searchStr表示要统计的字符串
function countStr(strSrc, searchStr) {
    var pos = 0;
    var count = 0;
    while ((pos = strSrc.indexOf(searchStr, pos)) > -1) {
        pos = pos + searchStr.length;
        count++;
    }

    return count;
}
//取字符窜里的数字到整形数组里
function getDigit(str) {
    var tempStrArr = new Array();
    var chr = str.toCharArray();
    var tempV = new Object();
    tempV.add = function (key, value) { this[key] = value }
    tempV.get = function (key) { return this[key] }
    tempV.size = function () { return Object.keys(tempV).length - 3 }
    var tempStr = "";
    var bl = false;
    var idx = 0;
    for (var i = 0; i < chr.length; i++) {
        if (isDigit(chr[i])) {
            if (!bl) {
                if (tempStr.length > 0) {
                    tempV.add(idx++, tempStr);
                }
                tempStr = "";
                tempStr = chr[i];
                bl = true;
            }
            else {
                tempStr += chr[i];
            }
        }
        else {
            bl = false;

        }
    }
    //最后再添加
    if ((tempStr.length > 0)) {
        tempV.add(idx++, tempStr);
    }
    tempStrArr = new Array(tempV.size());
    for (var j = 0; j < tempV.size(); j++) {
        tempStrArr[j] = tempV.get(j);
    }
    return tempStrArr;
}
//9、判断是否为数字类型
function isDigit(value) {
    var patrn = /^[0-9]*$/;
    if (patrn.exec(value) == null || value == "") {
        return false
    } else {
        return true
    }
}
/**
   *把数字转换成大写汉字
   * @param c 需要转换的字符
   * @return 成功返回对应的整数汉字
   */
function ToChineseDigit(c) {
    var result = "";
    switch (c) {
        case '0':
            result = "零";
            break;
        case '1':
            result = "一";
            break;
        case '2':
            result = "二";
            break;
        case '3':
            result = "三";
            break;
        case '4':
            result = "四";
            break;
        case '5':
            result = "五";
            break;
        case '6':
            result = "六";
            break;
        case '7':
            result = "七";
            break;
        case '8':
            result = "八";
            break;
        case '9':
            result = "九";
            break;
    }
    return result;
}
/**
 * 乘权运算反运算 100 --》百
 * @param  需要转换的整形
 * @return 中文单位
 */
function intToChar(dd) {
    var result = "";
    switch (dd) {
        case 10:
            result = "十";
            break;
        case 100:
            result = "百";
            break;
        case 1000:
            result = "千";
            break;
        case 10000:
            result = "万";
            break;

    }
    return result;
}

function toInt(number) {
    return number * 1 | 0 || 0;
}
/**
   * 数字转换成对应大写整数 101 -->一百零一
   * @param dd
   * @return
   */
function DigitToTxt(dd) {
    if (dd >= 10 && dd < 20) { //如果是在10-19之间特殊处理
        if (dd == 10) {
            return "十";
        }
        else {
            return "十" +
                ToChineseDigit((dd + "").charAt(1));
        }
    }
    var ddStr = dd + "";
    var result = "";
    var zeroStr = "";
    for (var i = 0; i < ddStr.length; i++) {

        if (ddStr.charAt(ddStr.length - 1 - i) == '0') {
            if (i != 0 && !result.equals("")) {
                zeroStr = "零";
            }
            continue;
        }
        result = ToChineseDigit(ddStr.charAt(ddStr.length - 1 - i)) + intToChar(toInt(Math.pow(10.0, i))) + zeroStr + result;
        zeroStr = "";
    }
    return result;
}

// 字符串转16进制
function str2hex(str){
    if(str === ""){
      return "";
    }
    var arr = [];
    arr.push("0x");
    for(var i=0;i<str.length;i++){
      arr.push(str.charCodeAt(i).toString(16));
    }
    return arr.join('');
  }
// 16进制转字符串
// 
function hex2str(hex) {
    　　var trimedStr = hex.trim();
    　　var rawStr = trimedStr.substr(0,2).toLowerCase() === "0x" ? trimedStr.substr(2) : trimedStr;
    　　var len = rawStr.length;
    　　if(len % 2 !== 0) {
    　　　　alert("Illegal Format ASCII Code!");
    　　　　return "";
    　　}
    　　var curCharCode;
    　　var resultStr = [];
    　　for(var i = 0; i < len;i = i + 2) {
    　　　　curCharCode = parseInt(rawStr.substr(i, 2), 16);
    　　　　resultStr.push(String.fromCharCode(curCharCode));
    　　}
    　　return resultStr.join("");
    }

 
//查询日期，判断是否是日期类型行
function isDateStr(str){
    var start_y = str.indexOf("年");
    var start_m = str.indexOf("月");
    var start_d = str.indexOf("日");
    if(start_y>-1 && start_m>-1 && start_d>-1){
        return true;
    }else{
        return false;
    }
}

//多行居中标签替换，包括BR等。
function align_center_moreLine(txt,start_token,end_token){
    var  start_token_idx = txt.lastIndexOf(start_token);
    if(start_token_idx>0){
        var  end_token_idx = txt.indexOf(end_token,start_token_idx+1);
        if (end_token_idx>0){
            align_str = txt.substring(start_token_idx,end_token_idx);
           // console.log("align_str="+align_str)
             align_str = replaceAllHtlm(align_str);
            var tmp_str_arr = align_str.split(br_str);
            align_str ="";
            for (var xx = 0; xx < tmp_str_arr.length; xx++) {
                tmp_str_arr [xx] =  space_6 +tmp_str_arr[xx].trim()+br_str;
                align_str = align_str+tmp_str_arr [xx];
            }
            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx+end_token.length);
        }

    }
    return txt; 
    
}
//多行居中标签替换，包括BR等。
function align_center_moreLineAll(txt,start_token,end_token){
    var  start_token_idx = txt.indexOf(start_token);
    while(start_token_idx>-1){
      //  console.log("txte="+txt)
        var  end_token_idx = txt.indexOf(end_token,start_token_idx+1);
       
        if (end_token_idx>0){
            align_str = txt.substring(start_token_idx,end_token_idx);
           // console.log("align_str="+align_str)
             align_str = replaceAllHtlm(align_str);
            var tmp_str_arr = align_str.split(br_str);
            align_str ="";
            for (var xx = 0; xx < tmp_str_arr.length; xx++) {
                tmp_str_arr [xx] =  space_6 +tmp_str_arr[xx].trim()+br_str;
                align_str = align_str+tmp_str_arr [xx];
            }
           // txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx+end_token.length);
            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx+end_token.length);
        }
        start_token_idx = txt.indexOf(start_token,start_token_idx+1);
        
    }
    return txt; 
    
}
 
//多行居右标签替换，包括BR等。
function align_right_moreLine(txt,start_token,end_token){
    var  start_token_idx = txt.indexOf(start_token);
    if(start_token_idx>0){
        var  end_token_idx = txt.indexOf(end_token,start_token_idx);
        if (end_token_idx>0){
            align_str = txt.substring(start_token_idx,end_token_idx);
             align_str = replaceAllHtlm(align_str);
            var tmp_str_arr = align_str.split(br_str);
            align_str ="";
            for (var xx = 0; xx < tmp_str_arr.length; xx++) {
                tmp_str_arr [xx] =  space_36 +tmp_str_arr[xx].trim()+br_str;
                align_str = align_str+tmp_str_arr [xx];
            }
            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx+end_token.length);
        }

    }
    return txt; 
    
}
//多行居右标签替换，包括BR等。替换所有
function align_right_moreLineAll(txt,start_token,end_token){
    var  start_token_idx = txt.indexOf(start_token);
    while(start_token_idx>0){
        var  end_token_idx = txt.indexOf(end_token,start_token_idx);
        if (end_token_idx>0){
            align_str = txt.substring(start_token_idx,end_token_idx);
             align_str = replaceAllHtlm(align_str);
            var tmp_str_arr = align_str.split(br_str);
            align_str ="";
            for (var xx = 0; xx < tmp_str_arr.length; xx++) {
                tmp_str_arr [xx] =  space_36 +tmp_str_arr[xx].trim()+br_str;
                align_str = align_str+tmp_str_arr [xx];
            }
            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx+end_token.length);
        }
        start_token_idx = txt.indexOf(start_token,start_token_idx+1);
    }
    return txt; 
    
}
//多行居右标签替换，包括BR等。替换所有,属性关键字查找
function align_right_moreLineAll_TAG(txt,start_token_tag,end_token,attribStr){
   // console.log("  find ="+start_token_tag);
    var  start_token_idx = txt.indexOf(start_token_tag);
    //console.log("  find ="+start_token_idx);
    while(start_token_idx>-1){
        var close_tag_idx = txt.indexOf(">",start_token_idx);
      //  console.log("  close_tag_idx ="+close_tag_idx);
        if(close_tag_idx >-1){
            align_str = txt.substring(start_token_idx,close_tag_idx+1);
            
            if(align_str.search(attribStr)==-1){
               
                start_token_idx = txt.indexOf(start_token_tag,start_token_idx+1);
               // console.log("  start_token_idx ccc ="+start_token_idx);
                continue;
            }
        }
        var  end_token_idx = txt.indexOf(end_token,close_tag_idx);
        if (end_token_idx>0){
            align_str = txt.substring(start_token_idx,end_token_idx);
            
             align_str = replaceAllHtlm(align_str);
            var tmp_str_arr = align_str.split(br_str);
            align_str ="";
            for (var xx = 0; xx < tmp_str_arr.length; xx++) {
                tmp_str_arr [xx] =  space_36 +tmp_str_arr[xx].trim()+br_str;
                align_str = align_str+tmp_str_arr [xx];
            }
            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx+end_token.length);
        }
        start_token_idx = txt.indexOf(start_token_tag,start_token_idx+2);
        //console.log("  start_token_idx ="+start_token_idx);


    }
    return txt; 
    
}
//一行居右标签替换，包括BR等。
function align_right_oneLine(txt,start_token,end_token){
    var  start_token_idx = txt.indexOf(start_token);
    if(start_token_idx>0){
        var  end_token_idx = txt.indexOf(end_token,start_token_idx);
        if (end_token_idx>0){
            align_str = txt.substring(start_token_idx,end_token_idx);
            align_str = replaceAllHtlm(align_str);
            var tmp_str_arr = align_str.split(br_str);
            align_str ="";
            for (var xx = 0; xx < tmp_str_arr.length; xx++) {            
                align_str = align_str+tmp_str_arr[xx].trim();
            }
             
           if(align_str.length>0){
                align_str =space_36+ align_str+br_str;
            }
            txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx+end_token.length);
        }

    }
    return txt; 
    
}
 
//多行居右标签替换，包括BR等。替换所有,属性关键字查找
function align_right_moreLineAll_TAG(txt,start_token_tag,end_token,attribStr){
    // console.log("  find ="+start_token_tag);
     var  start_token_idx = txt.indexOf(start_token_tag);
     //console.log("  find ="+start_token_idx);
     while(start_token_idx>-1){
         var close_tag_idx = txt.indexOf(">",start_token_idx);
       //  console.log("  close_tag_idx ="+close_tag_idx);
         if(close_tag_idx >-1){
             align_str = txt.substring(start_token_idx,close_tag_idx+1);
             
             if(align_str.search(attribStr)==-1){
                
                 start_token_idx = txt.indexOf(start_token_tag,start_token_idx+1);
                // console.log("  start_token_idx ccc ="+start_token_idx);
                 continue;
             }
         }
         var  end_token_idx = txt.indexOf(end_token,close_tag_idx);
         if (end_token_idx>0){
             align_str = txt.substring(start_token_idx,end_token_idx);
             
              align_str = replaceAllHtlm(align_str);
             var tmp_str_arr = align_str.split(br_str);
             align_str ="";
             for (var xx = 0; xx < tmp_str_arr.length; xx++) {
                 tmp_str_arr [xx] =  space_36 +tmp_str_arr[xx].trim()+br_str;
                 align_str = align_str+tmp_str_arr [xx];
             }
             txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx+end_token.length);
         }
         start_token_idx = txt.indexOf(start_token_tag,start_token_idx+2);
         //console.log("  start_token_idx ="+start_token_idx);
 
 
     }
     return txt; 
     
 }

 //
//多行居右（居中）标签替换，包括BR等。替换所有,属性关键字查找，居中传6个空格，居右传36空格
function align_moreLineAll_TAG(txt,start_token_tag,end_token,attribStr,space_x){
    // console.log("  find ="+start_token_tag);
     var  start_token_idx = txt.indexOf(start_token_tag);
     //console.log("  find ="+start_token_idx);
     while(start_token_idx>-1){
         var close_tag_idx = txt.indexOf(">",start_token_idx);
        
         if(close_tag_idx >-1){
             align_str = txt.substring(start_token_idx,close_tag_idx+1);
             
             if(align_str.search(attribStr)==-1){
                
                 start_token_idx = txt.indexOf(start_token_tag,start_token_idx+1);
                // console.log("  start_token_idx ccc ="+start_token_idx);
                 continue;
             }
         }
         var  end_token_idx = txt.indexOf(end_token,close_tag_idx);
         if (end_token_idx>0){
             align_str = txt.substring(start_token_idx,end_token_idx);
            // console.log("  align_str ="+align_str);
              align_str = replaceAllHtlm(align_str);
              
             var tmp_str_arr = align_str.split(br_str);
             align_str ="";
             for (var xx = 0; xx < tmp_str_arr.length; xx++) {
                 tmp_str_arr [xx] =  space_x +tmp_str_arr[xx].trim()+br_str;
                 align_str = align_str+tmp_str_arr [xx];
             }
             txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx+end_token.length);
            // console.log("  align_str2 ="+align_str);
         }
         start_token_idx = txt.indexOf(start_token_tag,start_token_idx+2);
         //console.log("  start_token_idx ="+start_token_idx);
 
 
     }
     return txt; 
     
 }
  //多行居右（居中）标签替换，包括BR等。替换所有,属性关键字查找，居中传6个空格，居右传36空格 这个还有些问题，正则表达式占用资源大
function align_moreLineAll_TAG_bug(txt,start_token_tag,end_token,attribStr,space_x){
    // console.log("  find ="+start_token_tag);
     var  start_token_idx = txt.search(start_token_tag);
     //console.log("  find ="+start_token_idx);
     while(start_token_idx>-1){
         var close_tag_idx = txt.indexOf(">",start_token_idx);
        
         if(close_tag_idx >-1){
             align_str = txt.substring(start_token_idx,close_tag_idx+1);
             
             if(align_str.search(attribStr)==-1){
               // console.log("  start_token_tag  ="+start_token_tag);
              //  console.log("  txt  ="+txt);
                txt = txt.substring(0,start_token_idx)+ txt.substring(close_tag_idx+1);
                 start_token_idx = txt.search(start_token_tag);

                // console.log("  start_token_idx ccc ="+start_token_idx);
                 continue;
             }
         }
         var  end_token_idx = txt.search(end_token);
         if (end_token_idx>0){
             align_str = txt.substring(start_token_idx,end_token_idx);
         //    console.log("  align_str ="+align_str);
              align_str = replaceAllHtlm(align_str);
              align_str =align_str.replaceAll(br_str+br_str,br_str);
             var tmp_str_arr = align_str.split(br_str);
             align_str ="";
             for (var xx = 0; xx < tmp_str_arr.length; xx++) {
                 tmp_str_arr [xx] =  space_x +tmp_str_arr[xx].trim()+br_str;
                 align_str = align_str+tmp_str_arr [xx];
             }
             txt = txt.substring(0,start_token_idx)+align_str+txt.substring(end_token_idx+end_token.length);
           //  console.log("  align_str2 ="+align_str);
         }
        // txt = txt.substring(0,start_token_idx)+ txt.substring(close_tag_idx+1);
         start_token_idx = txt.search(start_token_tag);
         //console.log("  start_token_idx ="+start_token_idx);
 
 
     }
     return txt; 
     
 }
//处理正文章节条函数
function deal_paragraph(txt){
      /*
      处理基本算法， 
      1、如果是目录，跳过，目录基本判断，连续是章节，中间没有正文
      2、章节的处理。6个空格，上下空行，基本判断 第字开头， 章 或者 节 空格，中间文字不超过 5个字符，第一百四十五条
      3、条的处理 前面空4个，后面 空2个
      4、最后在处理目录问题，如果发现连续出现章节的，已经排版好的，删除空行
      */

     //console.log("bbb txt"+txt);
     var tmp_str_arr = txt.split(br_str);
     txt = "";
     var maxLen =6;//第字 和章节条之间的字符数量
     //处理
     /*strtiao = Replace(strtiao, "条　", "条  ")
      strtiao = Replace(strtiao, "章　", "章  ")
      strtiao = Replace(strtiao, "章 ", "章  ")
      strtiao = Replace(strtiao, "章   ", "章  ")*/
      var str_di="第";
      var str_zhang="章";
      var str_jie="节";
      var str_tiao="条";
      var MaxStrLen = 5;//中间文字不超过 5个字符，第一百四十五条
     for (var xx = 0; xx < tmp_str_arr.length; xx++) {
         if (tmp_str_arr[xx].trim().length > 0) {
         //    console.log("-----------"+tmp_str_arr[xx])
            //先看章
            var start_di =tmp_str_arr[xx].indexOf(str_di);
            var start_zhang =tmp_str_arr[xx].indexOf(str_zhang);
            var start_jie =tmp_str_arr[xx].indexOf(str_jie);
            var start_tiao =tmp_str_arr[xx].indexOf(str_tiao);
            //先完成开发，然后在考虑优化，
            if(start_di>0){//有第字
               if(start_zhang>0 && start_di<start_zhang && (start_zhang-start_di)<=MaxStrLen&&  start_zhang>start_jie && start_zhang>start_tiao  ){//章处理，有章字 章 字 必须在节 和条的前面，才算，而且中间不能大于字符  &&  tmp_str_arr[xx].substring(start_di,start_zhang).length>MaxStrLen
                 // console.log("有第 MM 章");
                  //在章后面加上2个英文空格
                  var str_z_tmp = tmp_str_arr[xx].substring(0,start_zhang+1);
                  tmp_str_arr[xx] = str_z_tmp +space_2+tmp_str_arr[xx].substring(start_zhang+1).trim();
                  //看看后面是否有空行，有就不用增加
                  if((xx+1)<tmp_str_arr.length &&  tmp_str_arr[xx+1].trim().length==0){//有换行，不加
                    tmp_str_arr[xx] = tmp_str_arr[xx].trim() ;//先删除空格，在补充  //然后6空格， 
                  }else{
                    tmp_str_arr[xx] = tmp_str_arr[xx].trim() + br_str;//先删除空格，在补充  //然后6空格，前后空行
                  }
                 
                  //看看前面是否已经有空行了，有就不用添加
                  if((xx-1)>=0 &&  tmp_str_arr[xx-1].trim().length==0){//有换行，不加
                    tmp_str_arr[xx] = space_6 + tmp_str_arr[xx];
                  }else{
                    tmp_str_arr[xx] = br_str+space_6 + tmp_str_arr[xx];
                  }
                  

               }else if(start_jie>0  && start_di<start_jie && (start_jie-start_di)<=MaxStrLen && start_jie>start_tiao){//有节字
                  // console.log("有第 MM 节");
                   //在节后面加上2个英文空格
                  var str_z_tmp = tmp_str_arr[xx].substring(0,start_jie+1);
                  tmp_str_arr[xx] = str_z_tmp +space_2+tmp_str_arr[xx].substring(start_jie+1).trim();
                  tmp_str_arr[xx] = tmp_str_arr[xx].trim() + br_str;//先删除空格，在补充  //然后6空格
                  tmp_str_arr[xx] = br_str+space_6 + tmp_str_arr[xx];
               }else if(start_tiao>0  && start_di<start_tiao && (start_tiao-start_di)<=MaxStrLen ){//有条字
                  // console.log("有第 MM 条");
                   //在条后面加上2个英文空格
                  var str_z_tmp = tmp_str_arr[xx].substring(0,start_tiao+1);
                  tmp_str_arr[xx] = str_z_tmp +space_2+tmp_str_arr[xx].substring(start_tiao+1).trim();
                  tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格，在补充  //然后4空格
                  tmp_str_arr[xx] = space_4 + tmp_str_arr[xx];
               }

            }

             txt = txt + tmp_str_arr[xx] + br_str;
 
         }else{
           txt = txt + tmp_str_arr[xx] + br_str;
         }
 
     }
     //处理完成章节，查看 如果连续两个第一章，认为是目录。
     //处理空行
     var first_zhang =   txt.indexOf("      第一章");
     var last_zhang =txt.lastIndexOf("      第一章");
    if(first_zhang>-1 && last_zhang>0 && last_zhang>first_zhang){//有目录
        var str_mulu_tmp = txt.substring(first_zhang,last_zhang);
        str_mulu_tmp = str_mulu_tmp.replaceAll("\r\n\r\n","");
        txt=txt.substring(0,first_zhang)+str_mulu_tmp+br_str+txt.substring(last_zhang);
    }

   // console.log("aaaa txt="+txt);
    return (txt);
}
// 处理空行，以及针对空格处理换行
function deal_lines(txt){
    var tmp_str_arr = txt.split(br_str);
    txt = "";
    //处理空行
    for (var xx = 0; xx < tmp_str_arr.length; xx++) {

        if (tmp_str_arr[xx].trim().length > 0) {
           // console.log("-----------"+tmp_str_arr[xx])
            //处理多余空格
            //先36空格
            if (tmp_str_arr[xx].indexOf(space_6) >=0 && (tmp_str_arr[xx].length - tmp_str_arr[xx].trim().length) > 20) {
                tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格，在补充
                tmp_str_arr[xx] = space_36 + tmp_str_arr[xx];  //换行专门处理
            } else if (tmp_str_arr[xx].indexOf(space_6) >=0 && (tmp_str_arr[xx].length - tmp_str_arr[xx].trim().length) >= 6) {
                //console.log("-----------"+tmp_str_arr[xx])
                tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格，在补充  //然后6空格
                tmp_str_arr[xx] = space_6 + tmp_str_arr[xx];
               // console.log("---ll--------"+tmp_str_arr[xx])
            } else if (tmp_str_arr[xx].indexOf(space_2) >=0 && (tmp_str_arr[xx].length - tmp_str_arr[xx].trim().length) >= 2) {
               
                tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格，在补充  //最后4空格
                tmp_str_arr[xx] = space_4 + tmp_str_arr[xx];
            }else{//顶格
                //console.log("---2222222222222--------"+tmp_str_arr[xx])
                tmp_str_arr[xx] = tmp_str_arr[xx].trim();//先删除空格， 
                tmp_str_arr[xx] = tmp_str_arr[xx];
            }

            txt = txt + tmp_str_arr[xx] + br_str;

        }

    }
    return txt;
}

//处理日期，包括日期转换为中文
function  deal_appDate(txt){
    var start_36 = 0;
    var tmp_str_arr = txt.split(br_str);
    txt = "";
    //处理空行
    for (var xx = 0; xx < tmp_str_arr.length; xx++) {   
        if (tmp_str_arr[xx].trim().length > 0 && tmp_str_arr[xx].indexOf(space_36) ==0) {//注意，第一行可能不是 0，
            var str_36 = tmp_str_arr[xx].trim();
            var start_year = str_36.indexOf("年");
            var start_mm = str_36.indexOf("月", start_year);
            var start_dd = str_36.indexOf("日", start_mm);
            if (start_year > -1 && start_mm > start_year && start_dd > start_mm && str_36.trim().length<15) {//&
                var digit_arr = getDigit(str_36);
                if (digit_arr.length == 3) {
                    //处理年
                    var str_36_new = "";
                    try {
                        //var digit_data = Integer.parseInt(digit_arr[0]);
                        for (var pp = 0; pp < digit_arr[0].length; pp++) {
                            str_36_new = str_36_new + ToChineseDigit(digit_arr[0].charAt(pp));
                        }
                        str_36_new = str_36_new + "年";
                        str_36_new = str_36_new.replaceAll("零", "○");
                        //月
                        str_36_new = str_36_new + DigitToTxt(digit_arr[1]) + "月";
                        //日
                        str_36_new = str_36_new + DigitToTxt(digit_arr[2]) + "日";
                        //加上后面的字符
                        var last_idx = str_36.lastIndexOf("日");
                       
                        if(last_idx>0){
                            str_36_new = str_36_new+str_36.substr(last_idx+1);
                        }
                        tmp_str_arr[xx]=space_36+str_36_new;

                    } catch (e) {
                        // TODO Auto-generated catch block
                    }

                }

            }
        }
        txt = txt + tmp_str_arr[xx] + br_str;
    }

    return txt;
}

//处理部门上下换行问题，多个部门和日期之间的换行问题
function deal_space36_lines(txt){
    var last_pos = -1;
    var current_pos = -1;
    var first_add = false;
    var last_add = false;
    while ((current_pos = txt.indexOf(space_36, current_pos)) > -1) {
        if (!first_add) {
            txt = insertStr(txt, br_str, current_pos);
            first_add = true;
            last_pos = current_pos;
          continue;
        }
        //新的部门处理
        if (current_pos - last_pos > 1) {
            //count br_str >=2
            var count_br = countStr(txt.substring(last_pos, current_pos),br_str);
            if (count_br >= 2) {
                var endLine_pos = txt.indexOf(space_36, last_pos);
                if (endLine_pos > -1) {
                    endLine_pos = txt.indexOf(br_str, endLine_pos);
                    if (endLine_pos > 0) {
                        txt = insertStr(txt, br_str, endLine_pos);
                        first_add = false;// 下一组
                        last_add = true;
                        current_pos = endLine_pos;
                    }
                }
            }

        }
        last_pos = current_pos;
        current_pos = current_pos + space_36.length;

    }
    if (first_add && !last_add) {//添加头，也需要添加尾巴
        current_pos = txt.indexOf(br_str, last_pos);
        if (current_pos > 0) txt = insertStr(txt, br_str, current_pos);
    }
    return txt;
}

function deal_department_space(txt){
    var tmp_str_arr = txt.split(br_str);
    txt = "";
    //处理空行
    for (var xx = 0; xx < tmp_str_arr.length; xx++) {

        if (tmp_str_arr[xx].trim().length > 0) {
            
            //36空格
            if (tmp_str_arr[xx].indexOf(space_36) > -1 && !isDateStr(tmp_str_arr[xx].trim())) {//排除日期
               // console.log("-----------"+tmp_str_arr[xx])
                var department_arr =  tmp_str_arr[xx].trim().split(" ");//如果是空格或者一个字符，全部数组，合并
                var is_find = false;
                var new_department_str="";
                for(var yy=0;yy<department_arr.length;yy++){
                   if(department_arr[yy].length<=1){
                      new_department_str = new_department_str+department_arr[yy].trim();
                   //   console.log("-----------"+new_department_str)
                      is_find= true;
                   }else{
                    is_find= false;
                    break;
                   }
                }
                if(is_find)  tmp_str_arr[xx] = new_department_str;
                tmp_str_arr[xx] = space_36 + tmp_str_arr[xx].trim();  //换行专门处理
            }
        }
        txt = txt + tmp_str_arr[xx] + br_str;
    }
    return txt;
}
//处理开头空行问题
function deal_firstLineNull(txt){
     //删除开头空格
     for (var mm = 0; mm < 10; mm++) {
        var start_3 = txt.indexOf("\n");
        if (start_3 == 0) {
            txt = txt.substring(start_3 + 1);
        }
        start_3 = txt.indexOf(br_str);
        if (start_3 == 0) {
            txt = txt.substring(start_3 + 2);
        }
    }
    return txt;
}
//发改委正文特殊处理,部门在后面居中处理
//2020 -3-13 升级
function deal_special_department(txt){
    
    var tmp_str_arr = txt.split(br_str);
    txt = "";
     //反过来处理部门居右问题
    var xx = tmp_str_arr.length-1;
    //最后一行有日期，且有6空格，居中标示
   // console.log("ll="+tmp_str_arr[xx])
    while(tmp_str_arr[xx]!=null &&  tmp_str_arr[xx].trim().length==0){//去掉最后一行
      xx =xx-1;
    }
    //console.debug("-------------------"+tmp_str_arr[xx]+"111111111111111111------------------")
    if(tmp_str_arr[xx]!=null && tmp_str_arr[xx].trim().length>0 &&  tmp_str_arr[xx].indexOf(space_6)>-1 && tmp_str_arr[xx].indexOf("年")>-1 &&  tmp_str_arr[xx].indexOf("月")>-1 &&  tmp_str_arr[xx].indexOf("日")>-1  &&  tmp_str_arr[xx].trim().length<15){
        tmp_str_arr[xx]   =space_36+ tmp_str_arr[xx].trim();
       
        for (xx = xx-1; xx >=0; xx--) {
           // console.log("================="+ tmp_str_arr[xx])
            if (tmp_str_arr[xx].trim().length > 0 &&  tmp_str_arr[xx].indexOf(space_6)==0 && tmp_str_arr[xx].trim().length<80) {
                tmp_str_arr[xx]   =space_36+ tmp_str_arr[xx].trim();
            }else{
                break;
            }
            
        }
    }
    //重新组合正文
    for (var xx =0; xx < tmp_str_arr.length; xx++) {
        if (tmp_str_arr[xx].trim().length > 0) {
            txt =   txt+tmp_str_arr[xx]+br_str;
        }
        
    }
    return txt;
}
//处理开始标题折行问题，连续三行居中，前面两行合并为标题
function deal_titles_old(txt){
    var tmp_str_arr = txt.split(br_str);
    txt = "";
    //处理开始标题折行问题，连续三行居中，前面两行合并为标题
    var start =0;
    while((tmp_str_arr[start].trim().length==0 || tmp_str_arr[start].indexOf(space_6)>-1) && start<5){
       // console.log("-----"+tmp_str_arr[start]);
        if(tmp_str_arr[start].trim().length==0)  {start++;continue;}
        if(tmp_str_arr[start].charAt(tmp_str_arr[start].length-1)!='号'){
           if(txt.length==0) txt = space_6;
            txt = txt+tmp_str_arr[start].trim();
        }else{
            txt = txt+br_str+br_str;
            break;
        }
        start++;
    }
 
  
    for (var xx =start; xx < tmp_str_arr.length; xx++) {
            txt =   txt+tmp_str_arr[xx]+br_str;
    }
    return txt;
}
//处理开始标题折行问题，连续三行居中，前面两行合并为标题  
// 2019-10-30 增加没有文号的情况下，换行处理。优化6个空格在其他地方的情况
//2020-3-13 发现更多的bug ，在java下的js，如果有越界，没有抛出异常在页面，调试困难
function deal_titles(txt){
    var tmp_str_arr = txt.split(br_str);
  
    if(tmp_str_arr==null || tmp_str_arr.length<=2) return txt;
    //处理开始标题折行问题，连续三行居中，前面两行合并为标题
  // return "www"+tmp_str_arr[1]
   txt = "";
    var start =0;
    var addBr = false;
    while(start<tmp_str_arr.length &&(tmp_str_arr[start].trim().length==0 || tmp_str_arr[start].indexOf(space_6)==0) && start<5){
      //  console.log("-----"+tmp_str_arr[start]);
         
        if(tmp_str_arr[start].trim().length==0)  {start++;continue;}
      
        if(tmp_str_arr[start].charAt(tmp_str_arr[start].length-1)!='号'){
           if(txt.length==0) txt = space_6;
            txt = txt+tmp_str_arr[start].trim();
        }else{
            txt = txt+br_str+br_str;
            addBr = true;
            break;
        }
      
        start++;
    }
   // return "111"+txt;
    if(!addBr){
        txt = txt+br_str+br_str;
    }
     
    for (var xx =start; xx < tmp_str_arr.length; xx++) {
            txt =   txt+tmp_str_arr[xx]+br_str;
    }
    return txt;
}
//处理正文附件标题
function deal_attach_titles(txt,end_token){
    var fujian_token="附件：";
    var end_token = "</div>";
    end_token = typeof  end_token != 'undefined' ?  end_token : "</div>";
  
   /* var start_2  = txt.indexOf(fujian_token);
     
    if (start_2 >= 0) {
       var start_3 = txt.indexOf(end_token, start_2);
        if (start_3 >= 0) {
            var tmp_str = txt.substring(start_2, start_3);
            var tmp_str_bak = tmp_str;
            tmp_str = replaceAllHtlm(tmp_str);
            var tmp_str_arr = tmp_str.split(br_str);
            var tmp_str_ok = "";
            for (var xx = 0; xx < tmp_str_arr.length; xx++) {
                if (tmp_str_arr[xx].trim().length > 0) {
                    if(xx==0){
                        tmp_str_ok = tmp_str_arr[xx].trim() + br_str;
                    }else{
                        tmp_str_ok = tmp_str_ok  + space_4+tmp_str_arr[xx].trim() + br_str;
                    }
                    
                }

            }
            tmp_str_ok = tmp_str_ok.replaceAll("[*]", "×");
 
            var fj_pos = tmp_str_ok.indexOf(fujian_token);
            if(fj_pos>-1){
                tmp_str_ok =  insertStr(tmp_str_ok,br_str+space_4,fj_pos+fujian_token.length)
            }
            
             txt = txt.replaceAll(tmp_str_bak, tmp_str_ok);
          } 
       
    }//end 处理 附件
    */
    txt = txt.replaceAll(br_str+"附件：",br_str+space_4+"附件：");//顶格附件处理
    return txt;
}

//简单处理表格，基本保障表格文本样式
var tabReg_global = /(<div[^>]*>[\s\S]{0,10})?<table[^>]*>[\s\S]*?<\/table>([\s\S]{0,10}<\/div>)?/gi; //全局表格样式，如果有div，优先使用div
//var tabReg_global = /<table[^>]*>[\s\S]*?<\/table>/gi;
function tableGetTxt(str,start_idx,spaceX){
    //如果有多个table使用下面注释的正则只会匹配成一个table
            //var tabReg = /<table[^>]*>((?!table).)*<\/table>/gi;
        //匹配单个table
        start_idx = typeof  start_idx != 'undefined' ?  start_idx : 0;
        spaceX = typeof  spaceX != 'undefined' ?  spaceX : space_4;
        // var  tabReg =/<table[^>]*>[\s\S]*?<\/table>/gi;
       var tabMatch = tabReg_global.test(str);  
        var tabMatchContentArray = str.match(tabReg_global);
        // console.log("========tabMatchContentArray=========="+);
        if(tabMatch && tabMatchContentArray.length>start_idx){
        //    console.log("find table");
        }else{
            return "";
        }
        str = tabMatchContentArray[start_idx];
        //下面的htmlReg1 ，htmlReg2可以匹配任意标签
        //先处理表格的回车换行问题。
        str = str.replaceAll("\r\n", "");
        str = str.replaceAll(hex2str("0x0A"), "");//单个回车
        str = str.replace(/<\/tr>/ig, "\r\n");// </br> <br /> <br> 大小写等
        str = str.replace(/<[/]?[bB][rR][ ]?[/]?>/ig, "");// </br> <br /> <br> 大小写等
        str = str.replace(/<[bB][rR] .*?>/ig, "");// <BR SSSXXX>   大小写等
        str = str.replace(/<[/]?[pP][ /]?>/ig, "");// <p> </p> 大小写
        str = str.replaceAll("</td>", " ");//加空格
        str = str.replaceAll("</TD>", " ");//加空格
        str = replaceAllHtml(str)
        var tmp_str_arr = str.split(br_str);
        str = "";
        //处理空行
        for (var xx = 0; xx < tmp_str_arr.length; xx++) {
            str = str + spaceX+tmp_str_arr[xx].trim() + br_str; 
        //  console.log("444444444444="+tmp_str_arr[xx].trim()); 
        }
    return br_str+ br_str+str;
}
//简单处理表格，基本保障表格文本样式,
function table_replaceAll(str,spaceX){
    //如果有多个table使用下面注释的正则只会匹配成一个table
     start_idx = typeof  start_idx != 'undefined' ?  start_idx : 0;
    spaceX = typeof  spaceX != 'undefined' ?  spaceX : space_4;
    //var tabReg = /<table[^>]*>\s*(<tbody[^>]*>)?(\s*<tr[^>]*>[\s\S]*?<\/tr>\s*)*(<\/tbody>)?\s*<\/table>/gi;
    tabReg_global = /<div[^>]*>[\s\S]{0,10}<table[^>]*>[\s\S]*?<\/table>[\s\S]{0,10}<\/div>/gi;
   
    var tabMatch = tabReg_global.test(str);  
    if(!tabMatch){
        tabReg_global = /<table[^>]*>[\s\S]*?<\/table>/gi;
    }
    tabReg_global.lastIndex=0;//test 方法使用使用/g参数会移动搜索位置，所以每次要重置开始的位置。
    var tabMatch = tabReg_global.test(str); 
    var tabMatchContentArray = str.match(tabReg_global);
    // console.log("========tabMatchContentArray=========="+tabMatchContentArray.length);
    if(tabMatch){
       // console.log("find table");
        for(var mm =0;mm<tabMatchContentArray.length;mm++){
            var tableTxt = tableGetTxt(str,start_idx,spaceX);
            tableTxt = tableTxt.replaceAll(space_6," ");
            str = str.replace(tabMatchContentArray[mm],tableTxt);
        }
    }          
    
    while(str.indexOf(space_6)>-1){//删除连续空格
        str = str.replaceAll(space_6," ")
    }
    return str;
}
// 替换文号方法增加特殊内容
function deal_wenhao_new(str){
    str = str.replaceAll("〔","[");
    str = str.replaceAll("〕","]");
    str = str.replaceAll("﹝","[");
    str = str.replaceAll("﹞","]");
    str = str.replaceAll(br_str,"");
    str = str.replaceAll("\n","");
    str = str.replaceAll("、"," ");
    str = replaceAllHtlm(str);
    return str;
}


// 替换正文含有文件后缀
function RelaceExt(str){
    str = str.replaceAll("\\.docx","");
    str = str.replaceAll("\\.DOCX","");
    str = str.replaceAll("\\.doc","");
    str = str.replaceAll("\\.DOC","");
    str = str.replaceAll("\\.xls","");
    str = str.replaceAll("\\.XLS","");
    str = str.replaceAll("\\.xlsx","");
    str = str.replaceAll("\\.XLSX","");
    return str;
} 

//清洗标题的特殊字符、换行、空格、<> 转义符等
function title_clean(title){
    title = replaceAllHtlm(title);
    title = title.replaceAll(br_str,"");
    title = replace_lt_gt_Tag(title);
    title = replaceAllHtlm(title);
    title = title.replaceAll(br_str,"");
    title = title.replaceAll(hex2str("0x0A"), "");  //单个换行符
    return title;
} 