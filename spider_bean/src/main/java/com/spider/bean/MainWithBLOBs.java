package com.spider.bean;

public class MainWithBLOBs extends Main {
    private String linksource;

    private String fjian;

    public MainWithBLOBs() {
    }

    public MainWithBLOBs(Long number, String rjs0, String rjs4, String rjs5, String rjs6, String rjs10, String rjs12) {
        super(number, rjs0, rjs4, rjs5, rjs6, rjs10, rjs12);
    }

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