                                                                                                            //v1.25 lawstar getAttach branch  2019-10-18  by yjs
//2019-10-27 升级 正则表达式
//入口函数,全部使用小写字母
function entry(str) {
    str =getAttach_match(str) 
    return str; 
}
//附件 通用正则表达式处理
function getAttach_match(str) {
    //str = str.toLowerCase();
    start_token = "附件";
    end_token = "</div>";
    var attach_str = "";
    idx = str.indexOf(start_token)
    idx_2 = str.indexOf(end_token, idx + start_token.length)
    if(idx>-1 && idx_2>-1){
        str = str.substring(idx + start_token.length, idx_2)

        var start_token=/href=["']?/ig;
        var end_token = "[\"' >]";
        var firstA = ">";
        var lastA = "</[aA]>";
        var result = str.match(start_token);
        var dateStr="";
        if(result!=null  && result.length>0 ){
            for(var  kk=0;kk<result.length;kk++) {
                idx_1 = str.indexOf(result[kk]);
                str = str.substring(idx_1 + result[kk].length);
                idx_2 = str.search(end_token);
                link = str.substring(0, idx_2);
                str = str.substring(idx_2);
                idx_3 = str.indexOf(firstA);
                idx_4 = str.search(lastA);
                name = str.substring(idx_3+1, idx_4);
                name = replaceAllHtlm(name);
                name = name.replaceAll("\r\n","").trim();
                str = str.substring(idx_3 + lastA.length);
                mail_pattern=/mailto:/ig;
                if(link.search(mail_pattern)==-1 && name.length>0){
                    attach_str = attach_str + link + "//" + name + "##"
                }

            }
        }
       
    }
    attach_str = replaceAllHtlm(attach_str);
    return attach_str.trim();
}
//附件
function getAttach(str) {
   // str = str.toLowerCase();
    start_token = "附件";
    end_token = "</div>";
    var attach_str = "";
    idx = str.indexOf(start_token)
    idx_2 = str.indexOf(end_token, idx + start_token.length)
    if(idx>-1 && idx_2>-1){
        str = str.substring(idx + start_token.length, idx_2)
        var start_token = "href=\"";
        var end_token = "\"";
        var firstA = ">";
        var lastA = "</[aA]>";
        while ((idx = str.indexOf(start_token)) > -1) {
            idx_2 = str.indexOf(end_token, idx + start_token.length);
            link = str.substring(idx + start_token.length, idx_2);
            str = str.substring(idx_2 + end_token.length);
            idx_3 = str.indexOf(firstA,start_token);
            idx_4 = str.search(lastA);
            name = str.substring(idx_3+1, idx_4);
            str = str.substring(idx_3 + lastA.length);
            mail_pattern=/mailto:/ig;
            if(link.search(mail_pattern)==-1){
                attach_str = attach_str + link + "//" + name + "##"
            }

        }
    }
    attach_str = replaceAllHtlm(attach_str);
    return attach_str.trim();
}
                                
                                
                                