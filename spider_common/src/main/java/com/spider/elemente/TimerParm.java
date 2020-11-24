package com.spider.elemente;

import com.spider.App;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class TimerParm {
    public static String TIMER_STATUS;

    public static String LOCAL_HOST;

    public static String destDir;

    public static String copyDir;

    public static String attachmentPATH;

    public static String username;

    public static String fjPath5;

    public static String txtPath5;

    public static String txtCopyPath5;

    public static String username_chl;

    public static String timerurlforchl;

    public static String fjPath5_chl;

    public static String timerurlfortmp;

    public static String txt_chlPath;

    public static String fjPath5_history;

    public static String txtPath5_history;

    public static String getFjPath5_history() {
        return fjPath5_history;
    }

    public static void setFjPath5_history(String fjPath5_history) {
        TimerParm.fjPath5_history = fjPath5_history;
    }

    public static String getTxtPath5_history() {
        return txtPath5_history;
    }

    public static void setTxtPath5_history(String txtPath5_history) {
        TimerParm.txtPath5_history = txtPath5_history;
    }

    public static String getFjPath5_chl() {
        return fjPath5_chl;
    }

    public static void setFjPath5_chl(String fjPath5_chl) {
        TimerParm.fjPath5_chl = fjPath5_chl;
    }

    public static String getTimerurlfortmp() {
        return timerurlfortmp;
    }

    public static void setTimerurlfortmp(String timerurlfortmp) {
        TimerParm.timerurlfortmp = timerurlfortmp;
    }


    public static String getTxt_chlPath() {
        return txt_chlPath;
    }

    public static void setTxt_chlPath(String txt_chlPath) {
        TimerParm.txt_chlPath = txt_chlPath;
    }

    public static String getTimerurlforchl() {
        return timerurlforchl;
    }

    public static void setTimerurlforchl(String timerurlforchl) {
        TimerParm.timerurlforchl = timerurlforchl;
    }

    public static String getUsername_chl() {
        return username_chl;
    }

    public static void setUsername_chl(String username_chl) {
        TimerParm.username_chl = username_chl;
    }

    public static String getFjPath5() {
        return fjPath5;
    }

    public static void setFjPath5(String fjPath5) {
        TimerParm.fjPath5 = fjPath5;
    }

    public static String getTxtPath5() {
        return txtPath5;
    }

    public static void setTxtPath5(String txtPath5) {
        TimerParm.txtPath5 = txtPath5;
    }

    public static String getTxtCopyPath5() {
        return txtCopyPath5;
    }

    public static void setTxtCopyPath5(String txtCopyPath5) {
        TimerParm.txtCopyPath5 = txtCopyPath5;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        TimerParm.username = username;
    }

    public static String getDestDir() {
        return destDir;
    }

    public static void setDestDir(String destDir) {
        TimerParm.destDir = destDir;
    }

    public static String getCopyDir() {
        return copyDir;
    }

    public static void setCopyDir(String copyDir) {
        TimerParm.copyDir = copyDir;
    }

    public static String getAttachmentPATH() {
        return attachmentPATH;
    }

    public static void setAttachmentPATH(String attachmentPATH) {
        TimerParm.attachmentPATH = attachmentPATH;
    }

    public static String getTimerStatus() {
        return TIMER_STATUS;
    }

    public static void setTimerStatus(String timerStatus) {
        TIMER_STATUS = timerStatus;
    }

    public static String getLocalHost() {
        return LOCAL_HOST;
    }

    public static void setLocalHost(String localHost) {
        LOCAL_HOST = localHost;
    }
    /*public static String setLocalHost(){
        String filepath = "url.txt";
        StringBuilder url = new StringBuilder();
        URI resource = null;
        try {
            resource = App.class.getClassLoader().getResource(filepath).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        File uriFile = new File(resource);
        System.out.println(uriFile.getAbsolutePath());
        try {
//读取文件(字符流)
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(uriFile.getAbsoluteFile()),"utf-8"));
            //BufferedReader in = new BufferedReader(new FileReader("d:\\1.txt")));

            //读取数据
            //循环取出数据
            String str = null;
            while ((str = in.readLine()) != null) {
                url.append(str);
                //写入相关文件
            }

            //清楚缓存

            //关闭流
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOCAL_HOST = url.toString();
        return url.toString();
    }*/

}
