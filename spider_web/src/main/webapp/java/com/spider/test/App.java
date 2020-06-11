package com.spider.test;

import com.lawstar.basic.util.Tools;
import com.lawstar.law.util.HttpsUtils;
import com.spider.elemente.JavaScript_static;
import org.apache.poi.hpsf.PropertySet;
import org.apache.poi.hpsf.PropertySetFactory;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Throwable {
        String filePath = "D:\\company\\员工须知2016.doc";
        File file = new File(filePath);
        processDOC(file,"法律之星");
    }
    private static void processDOC(File file, String author) throws Throwable {
        FileInputStream fs = new FileInputStream(file);

        POIFSFileSystem poifs = new POIFSFileSystem(fs);
        fs = new FileInputStream(file);
        HWPFDocument doc = new HWPFDocument(fs);
        DirectoryEntry dir = poifs.getRoot();
        SummaryInformation si = null;
        DocumentEntry siEntry = (DocumentEntry)
                dir.getEntry(SummaryInformation.DEFAULT_STREAM_NAME);
        DocumentInputStream dis = new DocumentInputStream(siEntry);
        PropertySet ps = new PropertySet(dis);
        si = new SummaryInformation(ps);
        si.setAuthor(author);
    }



/*    @Test
    public void t5() throws Exception {
        String filePath = "D:\\company\\员工须知2016.doc";
        File poiFilesystem = new File(filePath);

     *//* Open the POI filesystem. *//*
        InputStream is = new FileInputStream(poiFilesystem);
        POIFSFileSystem poifs = new POIFSFileSystem(is);
        is.close();

     *//* Read the summary information. *//*
        DirectoryEntry dir = poifs.getRoot();
        SummaryInformation si;
        try
        {
            DocumentEntry siEntry = (DocumentEntry)
                    dir.getEntry(SummaryInformation.DEFAULT_STREAM_NAME);
            DocumentInputStream dis = new DocumentInputStream(siEntry);
            PropertySet ps = new PropertySet(dis);
            dis.close();
            si = new SummaryInformation(ps);
        }
        catch (FileNotFoundException ex)
        {
         *//* There is no summary information yet. We have to create a new
         * one. *//*
            si = PropertySetFactory.newSummaryInformation();
        }


        si.setAuthor("法律之星");

        FileOutputStream out = new FileOutputStream(filePath);
        si.write(out);
        out.close();
    }*/
    @Test
    public void t1(){
        try {
            URI resource = this.getClass().getClassLoader().getResource("fujian/tmp").toURI();
            File file = new File(resource);
            //File file1 = new File(file.getAbsoluteFile(),"2.txt");
            System.out.println(file.getAbsolutePath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void t2(){

        String attachment_jb_c = "http://xxgk.spb.gov.cn:80//upload/1576218608499.pdf//快递业务经营许可实地核查工作要点（一）.pdf  (595KB)##http://xxgk.spb.gov.cn:80//upload/1576218619518.pdf//快递业务经营许可实地核查工作要点（二）.pdf  (577KB)##";
        String localFilePath = "D:\\tomcat";
        String attach_base_url = "http://xxgk.spb.gov.cn/extranet/detail.html?yc_id=a7bc992f-6219-4c06-83b0-2a7e8864c57a";

        saveAttachment(attachment_jb_c,localFilePath,attach_base_url);
    }

    public void saveAttachment(String attachment_jb_c,String localFilePath,String attach_base_url){
        String attachListStr ="";//用于保存数据库列表
        if (attachment_jb_c!=null&&!"".equals(attachment_jb_c.trim())) {

            String []  retARR = new String[2];
            retARR[0] = "false";
            retARR[1] = "";
            try{
                retARR   = saveUrlAs(attach_base_url, attachment_jb_c, localFilePath);
            }catch(Exception e){
                System.out.println("-----------附件下载有失败："+e);
            }

            System.out.println("-----保存是否成功："+retARR[0]);
            if(retARR[0].equals("true")){
                attachListStr =retARR [1];
                System.out.println("-----------附件下载结果："+attachListStr);
            }


        }
    }


    public  String[] saveUrlAs(String baseUrl, String url, String localFilePath)
            throws Exception
    {
        String regxUrl = "";
        String remoteFileUrl = "";
        String attachListStr = "";
        String[] retArr = new String[2];
        boolean b = false;

        String[] attachArr = url.split("##");
        com.lawstar.law.util.HttpsUtils.delDir(new File(localFilePath));
        Tools.mkDir(localFilePath);

        for (String attachStr : attachArr)
            if (attachStr.trim().length() > 0) {
                remoteFileUrl = attachStr.substring(0, attachStr.lastIndexOf("//"));
                String fileName = attachStr.substring(attachStr.lastIndexOf("//") + 2);
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
                        remoteFileUrl = remoteFileUrl.substring(idx+1);
                    }

                }

                if (regxUrl.equals(remoteFileUrl))
                {
                    if (!remoteFileUrl.contains("http")) {
                        remoteFileUrl = baseUrl_tmp + remoteFileUrl;
                    }
                }
                else {

                    if ("".equals(regxUrl)){
                        remoteFileUrl = baseUrl_tmp + "/" + remoteFileUrl;
                    }else {
                        remoteFileUrl = baseUrl_tmp + "/" + regxUrl;
                    }

                }

                String newFilePath = localFilePath + "/" + fileName;
                //System.out.println("附件保存地址" + newFilePath);
                int index = remoteFileUrl.lastIndexOf("/");
                String result = remoteFileUrl.substring(0, index + 1);
                String temp = remoteFileUrl.substring(index + 1);
                String encode = URLEncoder.encode(temp, "utf-8");
                //System.out.println(encode);
                encode = encode.replace("%3D", "=");
                encode = encode.replace("%2F", "/");
                encode = encode.replace("+", "%20");
                encode = encode.replace("%26", "&");
                result = result + encode;
                remoteFileUrl = result;

                //System.out.println(result);
                //System.out.println("remoteFileUrl=" + remoteFileUrl);
                b = com.lawstar.law.util.HttpsUtils.executeDownloadFile(null, remoteFileUrl, newFilePath, "UTF-8", true);
                if (!b) {
                    Thread.currentThread(); Thread.sleep(2000L);
                    b = com.lawstar.law.util.HttpsUtils.executeDownloadFile(null, remoteFileUrl, newFilePath, "UTF-8", true);
                }
                if (!b) break;
                if (fileName.indexOf(".") < 0) fileName = fileName + com.lawstar.law.util.HttpsUtils.ext;
                if (attachListStr.length() == 0) attachListStr = fileName; else
                    attachListStr = attachListStr + "|" + fileName;
            }
        retArr[0] = b+"";
        retArr[1] = attachListStr;
        return retArr;
    }
}
