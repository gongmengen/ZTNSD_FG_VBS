package com.spider.utils;

import com.lawstar.basic.util.Tools;

public class DistinctMainPramUtil {
    public DistinctMainPramUtil() {
    }

    //处理标题返回 like 语句
    public String getSQLTitle(String titles){
        if (titles==null||"".equals(titles)){
            return titles;
        }
        int start_index = 0;
        String before_find_str [] = {"关于印发","关于发布","关于下达","关于公布"};
        String after_find_str [] = {"规定","办法","法","条例","实施细则的通知","意见","函","决定","公告","通告"};
        String last_find_str [] = {"的通知","意见","函","决定","公告","通告"};
        for(int kk=0;kk<before_find_str.length;kk++){
            start_index = titles.indexOf(before_find_str[kk]);

            if(start_index>-1){
                for(int mm=0;mm<before_find_str.length;mm++){
                    int start_index_in  = titles.indexOf(after_find_str[mm],start_index);
                    if(start_index_in>-1){
                        //删除前面的东西
                        titles = titles.substring(start_index+before_find_str[kk].length());
/*                        for(int nn=0;nn<last_find_str.length;nn++){//删除后面的东西
                            int start_index_last  = titles.indexOf(last_find_str[nn],start_index);
                            if(start_index_last>-1){
                                titles = titles.substring(0,start_index_last);
                                break;
                            }
                        }*/

                        titles=titles.replaceAll( "[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]" , "%");
                        System.out.println(titles);
                        break;
                    }
                }

                break;
            }

        }

        String titles_like = titles;

        start_index = titles.indexOf("关于");
        boolean isFind=false;
        if(start_index>-1){
            titles = titles.substring(start_index+2);
            titles_like  ="%"+titles;

        }


        titles_like=titles_like.replaceAll( "[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]" , "%");

        String sql=" '" +titles_like+"%'";
        sql = "LIKE "+sql;
        return sql;
    }
//处理发布日期
    public String[]  getReleaseTime(String RJS5){
        String[] resu = new String[2];
        if (RJS5==null||"".equals(RJS5)){
            resu[0] = "";
            resu[1] = "";
            return resu;
        }
        //把RJS5 转换为日期，然后+15 和 -15 天


        if(RJS5.length()>=8){
            //System.out.println(RJS5);

            com.lawstar.basic.util.DateTools dt = new com.lawstar.basic.util.DateTools();
            java.util.Date d1 = dt.strToDate(Integer.parseInt(RJS5.substring(0, 4)),Integer.parseInt(RJS5.substring(4, 6)), Integer.parseInt(RJS5.substring(6, 8)));

            //System.out.println(Tools.dateToStr(d1, "yyyy-MM-dd"));
            java.util.Date d_min=dt.add(d1, java.util.Calendar.DAY_OF_MONTH, -15);
            java.util.Date d_MAX=dt.add(d1, java.util.Calendar.DAY_OF_MONTH, +15);
            String str1 = Tools.dateToStr(d_min, "yyyy-MM-dd");
            String str1_arr [] = str1.split("-");
            String str2 = Tools.dateToStr(d_MAX, "yyyy-MM-dd");
            String str2_arr [] = str2.split("-");
            resu[0]=str1_arr[0]+str1_arr[1]+str1_arr[2];resu[1]=str2_arr[0]+str2_arr[1]+str2_arr[2];
        }
        return resu;
    }
//处理文号
    public String  getWenHao(String RJS12){
        if (RJS12==null||"".equals(RJS12)){
            return RJS12;
        }
        //预处理
        String[] befor = {"中华人民共和国"};
        for (String str:befor) {
            if (RJS12.indexOf(str) > -1) {
                RJS12 = RJS12.replaceAll(str, "");
            }
        }
/*        String str_d[] = Tools.getDigit(RJS12);
        String wenhao="";
        for(int xx =0;xx<str_d.length;xx++){
            System.out.println("w="+str_d[xx]);

        }
        if(str_d.length>0){
            wenhao = str_d[str_d.length-1];
        }*/
        return RJS12.replaceAll( "[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]" , "%");
    }
//处理部门名称
    public String  getDeptName(String RJS10){
        if (!"".equals(RJS10)){
            return RJS10.replaceAll( "[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]" , "%");
        }else {
            return RJS10;
        }

    }
}
