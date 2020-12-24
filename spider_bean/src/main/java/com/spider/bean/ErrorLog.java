package com.spider.bean;

import java.util.Date;

public class ErrorLog {
    private Integer id;

    private Integer errorcode;

    private String rjs8;

    private Date creattime;

    private Integer websiteid;

    private String errordetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public String getRjs8() {
        return rjs8;
    }

    public void setRjs8(String rjs8) {
        this.rjs8 = rjs8 == null ? null : rjs8.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Integer getWebsiteid() {
        return websiteid;
    }

    public void setWebsiteid(Integer websiteid) {
        this.websiteid = websiteid;
    }

    public String getErrordetails() {
        return errordetails;
    }

    public void setErrordetails(String errordetails) {
        this.errordetails = errordetails == null ? null : errordetails.trim();
    }
}