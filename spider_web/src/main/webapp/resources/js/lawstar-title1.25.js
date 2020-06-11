function entry(str) {
    str =getTitle_fgw(str);
    return str; 
}
//通过 title标签获取标题
function getTitle_fgw(str) {  
    start_token = "<title>";
    end_token = "</title>";
    var idx = str.indexOf(start_token);
    var idx_2 = str.indexOf(end_token, idx);
    var title = "";
    if(idx>-1 && idx_2>-1 ){
        title = str.substring(idx + start_token.length, idx_2);
        title = replaceAllHtlm(title);
        title =  title_clean(title);//清洗标题的特殊字符、换行、空格、<> 转义符等
        //下面是截取标题的栏目名称信息，部门信息等
        if(title.length>0){
            idx = title.search("([（(]发改)|-");
            if(idx>0){
                title = title.substring(0,idx);
                title = title.trim();
            }
        }
        
    }
    return title.trim();
}