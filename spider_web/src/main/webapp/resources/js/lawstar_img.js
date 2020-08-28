function imgEntry(title,appDate,numTxt,depcode,deptName,dbsType,AttachStr,src_code,txt,txt_code){
    return getImgList(title,appDate,numTxt,depcode,deptName,dbsType,AttachStr,src_code,txt,txt_code);
}
//获取图片列表
function getImgList(title,appDate,numTxt,depcode,deptName,dbsType,AttachStr,src_code,txt,txt_code){
    var p_arr_sp = new Array("<img[\\s\\S]*?>");
    var attach_str="";
    for (var xx = 0; xx < p_arr_sp.length; xx++) {
        var parttern_str =p_arr_sp[xx];
        var  regex_str =  new RegExp(parttern_str, "gi");
        var findTitleArr = txt_code.match(regex_str);
        // console.log(regex_str);
        if(findTitleArr!=null &&  findTitleArr.length>0){
            // console.log("findTitleArr=="+findTitleArr.length);
            for(var xx=0;xx<findTitleArr.length;xx++){
                var str = findTitleArr[xx];
                // console.log("str=="+str);
                var start_token=/src=["']?/ig;
                var end_token = "[\"' >]";
                var result = str.match(start_token);
                if(result!=null  && result.length>0 ){
                    idx_1 = str.indexOf(result[0]);
                    str = str.substring(idx_1 + result[0].length);
                    idx_2 = str.search(end_token);
                    link = str.substring(0, idx_2);
                    var name = "附件图片"+(xx+1);
                    if ( link.length>0) attach_str = attach_str + link + "//" + name + "##"
                }
            }

        }
    }
    return attach_str;
}