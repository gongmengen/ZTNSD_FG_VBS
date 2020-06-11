package com.spider.utils;

import com.lawstar.basic.util.Tools;
import com.spider.App;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class Tool_file {
    private FileWriter fw = null;
    //写出文件 -覆盖
    public void writeFile_cover(String filePath,String content) throws IOException {
        fw = new FileWriter(filePath,false);
        fw.write(content);
        fw.close();
    }
    //写出文件 -追加
    public void writeFile_add(String filePath,String content) throws IOException {
        fw = new FileWriter(filePath,true);
        fw.write(content);
        fw.close();
    }
    //根据文件相对路径的到文件位于系统中的绝对路径
    public String getFilePathUseProjectUri(String filePath_projectUri) throws URISyntaxException {
        URI resource = null;
        resource = App.class.getClassLoader().getResource(filePath_projectUri).toURI();
        File uriFile = new File(resource);
        return uriFile.getAbsolutePath();
    }
}
