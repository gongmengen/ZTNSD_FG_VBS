package com.spider.elemente;

import com.lawstar.basic.util.Tools;
import com.spider.App;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
public class JavaScript_static {
    public static String LAWSTARLIB_JS;
    public static String LAWSTAR_TITLE;
    public static String LAWSTAR_CONTENT;
    public static String LAWSTAR_APPDATE;
    public static String LAWSTAR_WENHAO;
    public static String LAWSTAR_ATTMENTS;

    //通用 base
    public void setLawstarlibJs() throws IOException {
        StringBuilder builder = new StringBuilder();
        try {
            String filepath = "js/lawstarlib.js";
            URI resource = App.class.getClassLoader().getResource(filepath).toURI();

            File uriFile = new File(resource);
            System.out.println(uriFile.getAbsolutePath());

            //FileReader fr = new FileReader(uriFile.getAbsolutePath());
            builder.append(Tools.readFile(String.valueOf(uriFile.getAbsoluteFile()),"UTF-8").toString());
/*            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(uriFile.getAbsoluteFile()),"utf-8"));
            while(br.readLine()!=null){
                builder.append(br.readLine()+"\r\n");
            }*/


        } catch (URISyntaxException e) {
            System.err.println(e);
        }
        LAWSTARLIB_JS = builder.toString();
    }
    //通用标题
    public void setLawstar_title() throws IOException {
        StringBuilder builder = new StringBuilder();
        try {
            String filepath = "js/lawstar-title1.25.js";
            URI resource = App.class.getClassLoader().getResource(filepath).toURI();

            File uriFile = new File(resource);
            System.out.println(uriFile.getAbsolutePath());

            //FileReader fr = new FileReader(uriFile.getAbsolutePath());
            builder.append(Tools.readFile(String.valueOf(uriFile.getAbsoluteFile()),"UTF-8").toString());
/*            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(uriFile.getAbsoluteFile()),"utf-8"));
            while(br.readLine()!=null){
                builder.append(br.readLine()+"\r\n");
            }*/


        } catch (URISyntaxException e) {
            System.err.println(e);
        }
        LAWSTAR_TITLE = builder.toString();
    }
    //通用正文
    public void setLawstar_content() throws IOException {
        StringBuilder builder = new StringBuilder();
        try {
            String filepath = "js/lawstar-content1.25.js";
            URI resource = App.class.getClassLoader().getResource(filepath).toURI();

            File uriFile = new File(resource);
            System.out.println(uriFile.getAbsolutePath());

            //FileReader fr = new FileReader(uriFile.getAbsolutePath());
            builder.append(Tools.readFile(String.valueOf(uriFile.getAbsoluteFile()),"UTF-8").toString());
/*            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(uriFile.getAbsoluteFile()),"utf-8"));
            while(br.readLine()!=null){
                builder.append(br.readLine()+"\r\n");
            }*/


        } catch (URISyntaxException e) {
            System.err.println(e);
        }
        LAWSTAR_CONTENT = builder.toString();
    }
    //通用文号
    public void setLawstar_wenhao() throws IOException {
        StringBuilder builder = new StringBuilder();
        try {
            String filepath = "js/lawstar-wenhao1.25.js";
            URI resource = App.class.getClassLoader().getResource(filepath).toURI();

            File uriFile = new File(resource);
            System.out.println(uriFile.getAbsolutePath());

            //FileReader fr = new FileReader(uriFile.getAbsolutePath());
            builder.append(Tools.readFile(String.valueOf(uriFile.getAbsoluteFile()),"UTF-8").toString());
/*            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(uriFile.getAbsoluteFile()),"utf-8"));
            while(br.readLine()!=null){
                builder.append(br.readLine()+"\r\n");
            }*/


        } catch (URISyntaxException e) {
            System.err.println(e);
        }
        LAWSTAR_WENHAO = builder.toString();
    }
    //通用发布日期
    public void setLawstar_appdate() throws IOException {
        StringBuilder builder = new StringBuilder();
        try {
            String filepath = "js/lawstar-appdate1.25.js";
            URI resource = App.class.getClassLoader().getResource(filepath).toURI();

            File uriFile = new File(resource);
            System.out.println(uriFile.getAbsolutePath());

            //FileReader fr = new FileReader(uriFile.getAbsolutePath());
            builder.append(Tools.readFile(String.valueOf(uriFile.getAbsoluteFile()),"UTF-8").toString());
/*            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(uriFile.getAbsoluteFile()),"utf-8"));
            while(br.readLine()!=null){
                builder.append(br.readLine()+"\r\n");
            }*/


        } catch (URISyntaxException e) {
            System.err.println(e);
        }
        LAWSTAR_APPDATE = builder.toString();
    }
    //通用附件
    public void setLawstar_attments() throws IOException {
        StringBuilder builder = new StringBuilder();
        try {
            String filepath = "js/lawstar_attments.js";
            URI resource = App.class.getClassLoader().getResource(filepath).toURI();

            File uriFile = new File(resource);
            System.out.println(uriFile.getAbsolutePath());

            //FileReader fr = new FileReader(uriFile.getAbsolutePath());
            builder.append(Tools.readFile(String.valueOf(uriFile.getAbsoluteFile()),"UTF-8").toString());
/*            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(uriFile.getAbsoluteFile()),"utf-8"));
            while(br.readLine()!=null){
                builder.append(br.readLine()+"\r\n");
            }*/


        } catch (URISyntaxException e) {
            System.err.println(e);
        }
        LAWSTAR_ATTMENTS = builder.toString();
    }
}
