package com.spider.test;

import com.lawstar.basic.util.Tools;
import com.lawstar.law.util.HttpsUtils;
import com.spider.elemente.TimerParm;
import com.spider.test.wordUtil.DocUtil;
//import com.spider.test.wordUtil.XlsUtil;
import com.spider.utils.NioFileUtil;


import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageProperties;
import org.apache.poi.openxml4j.util.Nullable;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.net.URLEncoder;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T1 {

    @Test
    public void t7(){
        String str = "jdjd";
        str = str.replace("\\u200b","").replace("\\u200c","");
        System.out.println(str);
    }

    @Test
    public void t6(){
        try{
            //String filePath = "D:\\IDEAworkspace\\201910_ztrsd\\spider_vbs\\spider_VBS\\spider_web\\target\\spider_web\\resources\\fujian\\tmp\\Timer001s001\\中央对地方均衡性转移支付办法.docx";
            String filePath = "D:\\company\\个人信息登记表(转入).xls";
            OPCPackage opc = OPCPackage.open(filePath);
            PackageProperties pp = opc.getPackageProperties();

            Nullable<String> foo = pp.getCreatorProperty();
            System.out.println(foo.hasValue()?foo.getValue():"empty");
            //Set some properties
            pp.setCreatorProperty("法");
            Nullable<String> foo1 = pp.getCreatorProperty();
            System.out.println(foo1.getValue());


            opc.close();
        } catch (Exception e) {}


    }

    //主入口
    public static void main(String[] args) throws Exception {


        String path = "E:\\target\\fujian\\tmp\\difang001s002";
        NioFileUtil.reNameFile(path,"ceshi001s002");
        System.out.println("文件拷贝完成!");
    }

    @Test
    public void t1(){
        String str = "aa|bb|";
        String[] split = str.split("\\|");
        System.out.println(split.length);
    }
    @Test
    public void t2(){
        String filePath = "D:\\IDEAworkspace\\201910_ztrsd\\spider_vbs\\spider_VBS\\spider_web\\target\\spider_web\\resources\\tmptxt\\Timer001s001";

        File f = new File(filePath);
        boolean exists = f.exists();

        if (!exists){
            f.mkdir();
            boolean file = f.isFile();
            boolean directory = f.isDirectory();
            System.out.println("isfile"+file);
            System.out.println("isdir"+directory);
        }

        System.out.println(exists);

    }
    @Test
    public void t3() throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        long time = simpleDateFormat.parse(format).getTime();
        System.out.println(time);
/*        Long str = new Long(format);
        System.out.println(str);*/

    }

    @Test
    public void t4() throws Exception {
        String baseUrl = "http://www.mohrss.gov.cn/gkml/rsgl/sydwrsgl/202001/t20200116_355370.html";
        String url = "./P020200116338104720979.docx//aa##";
        String localFilePath = "D:\\临时文件\\project_test";
        //saveUrlAs(baseUrl,url,localFilePath);
       // com.spider.utils.HttpsUtils.saveUrlAs(baseUrl,url,localFilePath);
        //saveUrlAs1(baseUrl,url,localFilePath);

    }


    public  String[] saveUrlAs(String baseUrl, String url, String localFilePath)

    {
        String regxUrl = "";
        String remoteFileUrl = "";
        String attachListStr = "";
        String fileName = "";
        String[] retArr = new String[2];
        boolean b = false;
        String[] attachArr={""};
        if (url!=null){
            attachArr = url.split("##");
        }
        com.lawstar.law.util.HttpsUtils.delDir(new File(localFilePath));
        Tools.mkDir(localFilePath);

        for (String attachStr : attachArr)
            if (attachStr.trim().length() > 0) {

                //获取下载链接 、 附件名称 链接中自带http/https 直接返回链接，不带http/https的链接 通过原链接和 '//'前半部分拼接得到
                if (attachStr.lastIndexOf("//") != -1) {
                    remoteFileUrl = attachStr.substring(0, attachStr.lastIndexOf("//"));
                    fileName = attachStr.substring(attachStr.lastIndexOf("//") + 2);
                }



                if (fileName.indexOf(".") < 0) {
                    int ext_pos = remoteFileUrl.lastIndexOf(".");
                    if (ext_pos > -1) {
                        fileName = fileName + remoteFileUrl.substring(ext_pos);
                    }
                }
                if (fileName.indexOf("(") != -1) {
                    int ext_pos = fileName.lastIndexOf("(");
                    fileName = fileName.substring(0,ext_pos).trim();

                }

                //附件保存地址
                String newFilePath = localFilePath + File.separator + fileName;
                //pram
                String temp = null;
                String result = null;
                //处理原网站链接
                if (remoteFileUrl.indexOf("http")>-1) {

                }else {
                    String baseUrl_tmp = baseUrl;
                    if ((remoteFileUrl.length() > 0) && (remoteFileUrl.charAt(0) == '/')) {
                        int first_idx = baseUrl.indexOf("//");
                        first_idx = baseUrl.indexOf("/", first_idx + 2);
                        if (first_idx > -1) {
                            baseUrl_tmp = baseUrl.substring(0, first_idx);
                        }

                    }
                    if ((remoteFileUrl.length() > 0) && (remoteFileUrl.charAt(0) == '.')) {
                        int first_idx = baseUrl.lastIndexOf("/");
                        int idx = remoteFileUrl.lastIndexOf("/");
                        if (first_idx > -1) {
                            baseUrl_tmp = baseUrl_tmp.substring(0, first_idx);
                        }
                        if (idx > -1) {
                            remoteFileUrl = remoteFileUrl.substring(idx + 1);
                        }

                    }
                //参数

                int index = remoteFileUrl.lastIndexOf("/");
                result = remoteFileUrl.substring(0, index + 1);
                temp = remoteFileUrl.substring(index + 1);
                }
                String encode = null;
                try {
                    encode = URLEncoder.encode(temp, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                //System.out.println(encode);
                encode = encode.replace("%3D", "=");
                encode = encode.replace("%2F", "/");
                encode = encode.replace("+", "%20");
                encode = encode.replace("%26", "&");
                result = result + encode;
                remoteFileUrl = result;

                //System.out.println(result);
                //System.out.println("remoteFileUrl=" + remoteFileUrl);
                try {
                    b = HttpsUtils.executeDownloadFile(null, remoteFileUrl, newFilePath, "UTF-8", true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
/*                if (!b) {
                    Thread.currentThread();
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        b = HttpsUtils.executeDownloadFile(null, remoteFileUrl, newFilePath, "UTF-8", true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
                if (!b) break;
                if (fileName.indexOf(".") < 0) fileName = fileName + com.lawstar.law.util.HttpsUtils.ext;
                if (attachListStr.length() == 0) attachListStr = fileName; else
                    attachListStr = attachListStr + "|" + fileName;
            }
        retArr[0] = b+"";
        retArr[1] = attachListStr;
        return retArr;
    }


    public static String saveUrlAs1(String grabsonwebsite,String url,String folder) throws Exception{//ClientProtocolException, IO
        //正则表达式处理后的url
        String regxUrl = "";
        String remoteFileUrl = "";
        String localFilePath = "";
        String fileName      = "";
        boolean b =false;
        //处理url
        String[] URLs = url.split("##");
        for(String URL:URLs) {
            if(URL.length()<=0) continue;
            remoteFileUrl = URL.substring(0,URL.lastIndexOf("//"));
            //修改url为http格式
            regxUrl = remoteFileUrl.replaceAll("\\.{2}/+", "");
            //正则处理前和处理后的url一致时
            if(regxUrl.equals(remoteFileUrl)) {
                //判断该url是否包含http
                if(!remoteFileUrl.contains("http")) {
                    remoteFileUrl = grabsonwebsite+remoteFileUrl;
                }

            }else {
                remoteFileUrl = grabsonwebsite+"/"+regxUrl;
            }

            fileName 	  = URL.substring(URL.lastIndexOf("//")+2);
            if(fileName.indexOf(".")<0) fileName = fileName+".doc";

            localFilePath = "/bcn/192.168.0.5/fujian/tmp/"+folder;
            Tools.mkDir(localFilePath);
            localFilePath = localFilePath+"/"+fileName;
            System.out.println("附件保存地址"+localFilePath);
            int index = remoteFileUrl.lastIndexOf("/");
            String result = remoteFileUrl.substring(0,index+1);
            String temp = remoteFileUrl.substring(index+1);
            String encode = URLEncoder.encode(temp, "utf-8");
            System.out.println(encode);
            encode = encode.replace("%3D",  "=");
            encode = encode.replace("%2F", "/");
            encode = encode.replace("+", "%20");
            encode = encode.replace("%26", "&");
            result += encode;
            b = HttpsUtils.executeDownloadFile(null, remoteFileUrl, localFilePath, "UTF-8", true);
        }

        return ""+b;
    }
}
