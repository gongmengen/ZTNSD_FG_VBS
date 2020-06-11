//入口函数,
function entry(str) {
    var str_src =str;
    str =wenhao_pattern_csb(str) 
    if(str==null || str.length==0)    str =wenhao_pattern_gg(str_src)  
    if(str==null || str.length==0)   str =wenhao_pattern_ling(str_src)  
    return str; 
}
//文号通过正文区域，使用正则表达式正则表达式提取，并限定开通
function wenhao_pattern_csb(str) { 
   var wh_str=getContent_jtb(str);
   if(wh_str==null || wh_str.length<60)   wh_str=getContent_jtb2(str);
    wh_str = replaceAllHtlm(wh_str);
    start_token = "[\u4e00-\u9fa5]+[\\[(（〔﹝【]....[\\])）﹞〕】][第 ]?[0-9]{1,4}[ ]?号";
     end_token = "号";
     var arr_wh = wh_str.match(start_token);
     // 100这个数字根据正文开头文字多少调整
     var wenHao_str = "";
     if(arr_wh!=null &&arr_wh.length>0 && wh_str.indexOf(arr_wh[0])<100 ){
         wh_str = arr_wh[0];
         wh_str = replaceAllHtlm(wh_str);
         wh_str= wh_str.replace("无","");
         wenHao_str = deal_wenhao_new(wh_str);
     }
    
     return wenHao_str.trim();
 }
//取正文区域
function getContent_jtb(str) {

    var start_token ="<div"; // html 页面标签开始
    var attrib_str="TRS_Editor";  // 页面标签属性，关键字
    var end_token = "</div>"; //html 结束标签
    var idx_arr = str.findTagPostion(start_token,attrib_str,end_token);
    idx = idx_arr[0];
    idx_2 = idx_arr[1];
    str = str.substring(idx, idx_2+end_token.length);
    return (str);
}
function getContent_jtb2(str) {
    var start_token ="<div"; // html 页面标签开始
    var attrib_str="yjzq-left";  // 页面标签属性，关键字
    var end_token = "</div>"; //html 结束标签
    var idx_arr = str.findTagPostion(start_token,attrib_str,end_token);
    idx = idx_arr[0];
    idx_2 = idx_arr[1];
    str = str.substring(idx, idx_2+end_token.length);
    return (str);
}

//文号，通过固定标签的方式，模板非常确定文号
function wenhao(str) { 
    start_token = "<span>文</span>号：</li>";
    end_token = "</li>";
    var idx = str.indexOf(start_token);
    var idx_2 = str.indexOf(end_token, idx+start_token.length);
    var wenHao_str = "";
    if(idx>-1 && idx_2>-1){
        wenHao_str = str.substring(idx+start_token.length, idx_2);
        wenHao_str = replaceAllHtlm(wenHao_str);
        wenHao_str= wenHao_str.replace("无","");
        wenHao_str= wenHao_str.replaceAll(" ","");
       // wenHao_str= wenHao_str.replaceAll("	","");
        wenHao_str = deal_wenhao_new(wenHao_str);
    }
   
    return wenHao_str.trim();
}
//文号通过正则表达式，缺点会取错文号。
function wenhao_pattern(str) { 
    // start_token = "<p align=[\"']?center[\"']?>发改";
    start_token = ">.{1,6}[\\[(（〔﹝【]....[\\])）﹞〕】][第 ]?[0-9]{1,4}[ ]?号";
     end_token = "号";
     var idx = str.search(start_token);
     var idx_2 = str.indexOf(end_token, idx);
     var wenHao_str = "";
     if(idx>-1 && idx_2>-1){
         wenHao_str = str.substring(idx+1, idx_2+1);
         wenHao_str = replaceAllHtlm(wenHao_str);
         wenHao_str= wenHao_str.replace("无","");
         wenHao_str= wenHao_str.replaceAll(" ","");
        // wenHao_str= wenHao_str.replaceAll("	","");
         wenHao_str = deal_wenhao_new(wenHao_str);
     }
    
     return wenHao_str.trim();
 }
 //取公告类型的文号
function wenhao_pattern_gg(str) {
    str =replaceAllHtlm(str);
    var regExp=/公告.{1,5}第[ ]?[0-9]{1,4}[ ]?号/g;
    var result = str.match(regExp);
    var dateStr="";
    if(result!=null  && result.length>0 ){
        dateStr = (result[0]);
    }
    return dateStr.trim();
}
 //取政府令 例如汕头市人民政府令第187号
 function wenhao_pattern_ling(str) {
    str =replaceAllHtlm(str);
   // return str;
    var regExp=/[\n]{1,3}.{3,15}令第[ ]?[0-9]{1,4}[ ]?号/g;

    var result = str.match(regExp);
    var dateStr="";
    if(result!=null  && result.length>0 ){
        dateStr = (result[0]);
    }
    return dateStr.trim();
}
                                    