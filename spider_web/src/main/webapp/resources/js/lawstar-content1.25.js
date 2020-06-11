//v1.25 lawstar getContent_jtb branch  2019-10-18  by yjs
/**
 *  2019-10-24 增加居中、居右正则表达式
 */                              
//入口函数,全部使用小写字母
function entry(str) {
    str =getContent_jtb(str) 
    return str; 
}//正文 发改委
function getContent(str) {
    start_token ="<p id=\"xxgk_content_fwzh_bottom\" style=\"display: none;\"></p>";
    end_token = "<!--添加微信附件打开提示-->";
    idx = str.indexOf(start_token)
    idx_2 = str.indexOf(end_token, idx + start_token.length)
    //console.log("2222"+idx_2);
    str = str.substring(idx, idx_2)
    return deal_all_text(str);
}
//正文，交通部，标签区间方法
function getContent_jtb(str) {
    var start_token ="<div"; // html 页面标签开始
    var attrib_str="zwnr";  // 页面标签属性，关键字
    var end_token = "</div>"; //html 结束标签
    var idx_arr = str.findTagPostion(start_token,attrib_str,end_token);
    idx = idx_arr[0];
    idx_2 = idx_arr[1];
    str = str.substring(idx, idx_2+end_token.length);
    return deal_all_text(str);
}


//正文预处理
function deal_prepared(txt){
    //  txt = txt.toLowerCase();
      txt = txt.replaceAll("　　　　　", "    ");
      txt = txt.replaceAll("　", "  ");
      txt = txt.replaceAll("   ", "    ");
      txt = txt.replaceAll(" ", " ");
      txt = txt.replaceAll("\n", br_str);
      txt = txt.replaceAll(hex2str("0x09"), "    ");
      txt = replaceBlock(txt,"<p style=","</p>",br_str,false);// p 前面增加回车换行
      txt = replaceBlock(txt,"<div ","</div>",br_str,false);// p 前面增加回车换行
      return txt;
  }
  //处理正文附件标题
function deal_attach_titles_new(txt){
    var fujian_token="附件：";
    var end_token = "</p>";
    var start_2  = txt.indexOf(fujian_token);
     
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
            tmp_str_ok = tmp_str_ok.replaceAll("\\*", "×");
            var fj_pos = tmp_str_ok.indexOf(fujian_token);
            if(fj_pos>-1){
                tmp_str_ok =  insertStr(tmp_str_ok,br_str+space_4,fj_pos+fujian_token.length)
            }
            
             txt = txt.replaceAll(tmp_str_bak, tmp_str_ok);
          } 
       
    }//end 处理 附件
    return txt;
}
 //居中标签适配
//<p style="text-align: center">
function align_center(txt){
     txt = align_moreLineAll_TAG(txt,"<p ","</p>","text-align:[ ]?center",space_6);//多行居右处理
     txt = align_moreLineAll_TAG(txt,"<div ","</div>","text-align:[ ]?center",space_6);//多行居右处理
    txt = align_center_moreLine(txt,"<p align=\"center\">","</p>");//多行居右处理
    txt = align_center_moreLineAll(txt,"<p align=\"center\">","</p>");//多行居右处理
    txt = align_center_moreLineAll(txt,"<p style=\"TEXT-ALIGN:[ ]?center\">","</p>");//多行居右处理
    txt = txt.replaceAll("<p align=center>", space_6);
    txt = txt.replaceAll("<p align='center>'", space_6);
    txt = txt.replaceAll("<h3 style=\"margin-bottom:14px;\">", space_6);//自然资源部
    txt = txt.replaceAll("<p align=\"center\">", space_6);
    txt = txt.replaceAll("<div align=center>", space_6);
    txt = txt.replaceAll("<div align=center>", space_6);
    txt = txt.replaceAll("<p style=\"text-align: center\">", "<p style=\"text-align:center\">");
    txt = txt.replaceAll("<p style=\"text-align:center\">",space_6);
    txt = replaceBlock(txt,"<p align=\"center\"","</p>",space_6);
    txt = txt.replaceAll_lawstar("<p ","center",space_6);
    txt = txt.replaceAll_lawstar("<div ","center",space_6);
   //
    return txt;
}
//段落开头标签适配 一般空四个
function align_left(txt){
    txt = txt.replaceAll_lawstar("<p ","mso-char-indent-count",space_4);
    txt = txt.replaceAll_lawstar("<p ","text-indent",space_4);
    txt = replaceBlockAddBr(txt,"<p align=\"justify\">","</p>",br_str);
    txt = replaceBlockAddBr(txt,"<p class","</p>",br_str);
    txt = replaceBlockAddBr(txt,"<p style=","</p>",br_str);
    return txt;
}
// 居右标签适配
//<p style="text-align: center">
function align_right(txt){
    txt = align_right_moreLineAll_TAG(txt,"<p ","</p>","align=[\"']?right[\"']?");//多行居右处理
    txt = align_right_moreLineAll_TAG(txt,"<P ","</P>","align=[\"']?right[\"']?");//多行居右处理
    txt = align_right_moreLineAll_TAG(txt,"<p ","</p>","text-align:[ ]?right");//多行居右处理
    txt = align_right_moreLineAll_TAG(txt,"<P ","</P>","TEXT-ALIGN:[ ]?right");//多行居右处理
    txt = align_right_moreLineAll_TAG(txt,"<p ","</p>","TEXT-ALIGN:[ ]?right");//多行居右处理
    txt = align_right_moreLineAll_TAG(txt,"<div ","</div>","right");//多行居右处理
    txt = align_moreLineAll_TAG(txt,"<div ","</div>","text-align:[ ]?right",space_36);//多行居右处理
    txt = align_right_moreLineAll_TAG(txt,"<DIV ","</DIV>","right");//多行居右处理
    txt = align_right_moreLineAll_TAG(txt,"<td ","</td>","right");//多行居右处理
    txt = align_right_moreLineAll_TAG(txt,"<TD ","</TD>","right");//多行居右处理
    return txt;
}

//正文后处理
function deal_last(txt){
    txt = removeBlock(txt,"抄送：",br_str,"");
    txt = removeBlock(txt,"分送：",br_str,"");
    txt = removeBlock(txt,"链接：",br_str,"");
    txt = removeBlock(txt,"网站纠错",br_str,"");
    txt = removeBlock(txt,"附件.pdf",br_str,"");
    txt = txt.replaceAll("（此件主动公开）","");
    txt = txt.replaceAll("（此件公开发布）","");
    txt = txt.replaceAll(".此件公开发布.","");
    txt = txt.replaceAll(".此件主动公开.","");
      return txt;
  }
  function deal_all_text(txt) {//国家税务局
    //可选函数开关
     //附件排版（可选）
     var use_attach=true; //false
      //特殊部门处理（可选，针对最后的发布日期和部门居中情况进行处理）
      var use_specail_department=true; //false
      //标题处理（可选，针对标题折行的情况，通常可以关闭）
      var use_moreLineTitle=true; //false
      //标题处理（可选，针对标题折行的情况，通常可以关闭）
      var use_moreLineTitle=true; //false

      //正文处理模块函数，流程是预处理-->附件排版（可选）-->居中处理-->居右处理-->局左处理-->替换网页标签-->空行和排版处理-->特殊部门处理（可选，针对最后的发布日期和部门居中情况进行处理）
      // -->标题处理（可选，针对标题折行的情况，通常可以关闭）-->章节处理（排版含有章节的正文）-->处理发布日期-->删除空行-->//处理空行36个格的日期问题-->  删除开头空格-->/处理部门日期换行问题，36格子换行 
      //-->处理部门中间空格问题，如果单个字，合并             
      if (txt==null || txt.length==0) return "";
      //正文预处理
      //注意：在处理正文前，删除、替换一些不必要的标签，空格，特殊字符等等，可以自定义
      txt = deal_prepared(txt);

       //附件处理，包括排版 
       //注意：如果发现正文不正常，注释这段代码，不处理正文内部的附件文字排版
      txt = deal_attach_titles_new(txt);
      //居中标签处理
      txt = align_center(txt);
      //居右标签处理
      txt = align_right(txt);
      //居左
      txt = align_left(txt);
      //替换网页标签
      txt = replaceAllHtlm(txt);
      
      //删除空行以及根据空格补充回车换行
      txt = deal_lines(txt);
      //发改委正文特殊处理 ，部门居中，从后面排版
      txt = deal_special_department(txt);

      //处理开头三行居中，合并标题问题，四川省政府模式
      txt = deal_titles(txt);
      //处理章节，条的格式（参考VB）
      txt = deal_paragraph(txt);
      //处理空行36个格的日期问题，由原来的数字年份转换为一般的中文数字年份。2015年1月2日    二零一五年二月十一日
      txt = deal_appDate(txt);
      //删除开头空格
      txt = deal_firstLineNull(txt);
       //处理部门日期换行问题，36格子换行
      txt = deal_space36_lines(txt);
      //处理部门中间空格问题，如果单个字，合并
      txt = deal_department_space(txt);
      //最后处理，删除一些不要的文字，行等。
      txt = deal_last(txt);
      return txt;
  }
                                