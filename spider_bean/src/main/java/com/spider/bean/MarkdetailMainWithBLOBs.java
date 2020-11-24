package com.spider.bean;

public class MarkdetailMainWithBLOBs extends MarkdetailMain {
    private String linksource;

    private String fjian;

    public String getLinksource() {
        return linksource;
    }

    public void setLinksource(String linksource) {
        this.linksource = linksource == null ? null : linksource.trim();
    }

    public String getFjian() {
        return fjian;
    }

    public void setFjian(String fjian) {
        this.fjian = fjian == null ? null : fjian.trim();
    }
}