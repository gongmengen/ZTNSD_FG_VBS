package com.spider.bean;

import java.util.Date;

public class TblErrorLog {
    private Integer id;

    private Integer errorcode;

    private String errordetails;

    private Integer informationid;

    private Date creattime;

    private Integer sendstatus;

    private Integer xwcolumn;

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

    public String getErrordetails() {
        return errordetails;
    }

    public void setErrordetails(String errordetails) {
        this.errordetails = errordetails == null ? null : errordetails.trim();
    }

    public TblErrorLog(Integer errorcode, String errordetails, Integer informationid) {
        this.errorcode = errorcode;
        this.errordetails = errordetails;
        this.informationid = informationid;
    }

    public TblErrorLog(Integer errorcode, String errordetails, Integer informationid, Integer xwcolumn) {
        this.errorcode = errorcode;
        this.errordetails = errordetails;
        this.informationid = informationid;
        this.xwcolumn = xwcolumn;
    }

    public TblErrorLog() {
    }

    public Integer getInformationid() {
        return informationid;
    }

    public void setInformationid(Integer informationid) {
        this.informationid = informationid;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Integer getSendstatus() {
        return sendstatus;
    }

    public void setSendstatus(Integer sendstatus) {
        this.sendstatus = sendstatus;
    }

    public Integer getXwcolumn() {
        return xwcolumn;
    }

    public void setXwcolumn(Integer xwcolumn) {
        this.xwcolumn = xwcolumn;
    }
}