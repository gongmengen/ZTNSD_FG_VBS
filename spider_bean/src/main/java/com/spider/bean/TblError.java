package com.spider.bean;

import java.util.Date;

public class TblError {
    private Integer errorid;

    private Integer errorcode;

    private String errordesc;

    private Integer errorstatus;

    private Integer creatid;

    private Date creattime;

    private Date stoptime;

    private Byte levels;

    public Integer getErrorid() {
        return errorid;
    }

    public void setErrorid(Integer errorid) {
        this.errorid = errorid;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrordesc() {
        return errordesc;
    }

    public void setErrordesc(String errordesc) {
        this.errordesc = errordesc == null ? null : errordesc.trim();
    }

    public Integer getErrorstatus() {
        return errorstatus;
    }

    public void setErrorstatus(Integer errorstatus) {
        this.errorstatus = errorstatus;
    }

    public Integer getCreatid() {
        return creatid;
    }

    public void setCreatid(Integer creatid) {
        this.creatid = creatid;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getStoptime() {
        return stoptime;
    }

    public void setStoptime(Date stoptime) {
        this.stoptime = stoptime;
    }

    public Byte getLevels() {
        return levels;
    }

    public void setLevels(Byte levels) {
        this.levels = levels;
    }
}