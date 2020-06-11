//v1.25 lawstar getAppdate branch  2019-10-18  by yjs
//入口函数,全部使用小写字母
function entry(str) {
    str =getAppdate_exp_last(str) 
    return str; 
}

//取最后一个发布日期
function getAppdate_exp_last(str) {
    str =replaceAllHtlm(str);
    var regExp=/[12][0-9]{3}[年-][0-9]{1,2}[月-][0-9]{1,2}[日 ]?/g;
    var result = str.match(regExp);
    var dateStr="";
    if(result!=null  && result.length>0 ){
        dateStr = formatDateStr(result[result.length-1]);
    }
    return dateStr.trim();
}
//通过正则表达式提取日期
function getAppdate_exp(str) {
    var str =replaceAllHtlm(str);
    var pos = str.search("[12][0-9]{3}[年-][0-9]{1,2}[月-][0-9]{1,2}[日 ]?");
    var dateStr="";
    if(pos>-1){
        var pos_end = str.indexOf("日",pos);
        if(pos_end==-1){
            pos_end = str.indexOf(" ",pos);
        }
        if(pos_end>0){
            dateStr = str.substring(pos,pos_end+1);
            dateStr = formatDateStr(dateStr);
        }
    }
    return dateStr.trim();
}
function getAppdate(str) {
    start_token = "发布日期：</li>";
    end_token = "</li>";
    idx = str.indexOf(start_token)
    idx_2 = str.indexOf(end_token, idx+start_token.length)
    var dateStr="";
    if(idx>-1 && idx_2>-1 ){
        dateStr = str.substring(idx + start_token.length, idx_2)
        dateStr = replaceAllHtlm(dateStr);
        dateStr = formatDateStr(dateStr);
    }
    return dateStr.trim();
}
//发布日期 商务部
function getAppdate_sfb(str) {
    start_token = "<p ";
    start_token_atrrib=" align=\"right\"";
    end_token = "</p>";
    str = str.toLowerCase();
    idx = str.lastIndexOf_lawstar(start_token,start_token_atrrib)
    idx_2 = str.indexOf(end_token, idx);
    str = str.substring(idx, idx_2)
    //console.log("sss"+str)
    str = replaceAllHtlm(str);
    var datestr ="";
    if(str.indexOf("年")>-1 && str.indexOf("月")>-1 && str.indexOf("日")>-1  ){
        var dateArr  = getDigit(str);
        
        if(dateArr[1].length==1) dateArr[1] = "0"+dateArr[1];
        if(dateArr[2].length==1) dateArr[2] = "0"+dateArr[2];
        datestr =  dateArr[0]+dateArr[1]+dateArr[2];
       // return datestr;
    }
    datestr = datestr.replace("年", "");
    datestr = datestr.replace("月", "");
    datestr = datestr.replace("日", "");
    datestr = datestr.replaceAll("-", "");
    return datestr.trim();
}


                                