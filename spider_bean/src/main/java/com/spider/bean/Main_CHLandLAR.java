package com.spider.bean;

import java.util.Date;

public class Main_CHLandLAR {
    private Integer rid;

    private String rjs0;

    private String rjs1;

    private String rjs4;

    private String rjs5;

    private String rjs6;

    private String rjs7;

    private String rjs8;

    private Short rjs9;

    private String rjs10;

    private String rjs11;

    private String rjs12;

    private String kword;

    private String appuser;

    private Date appdate;

    private Integer truetag;

    private Integer lawlevel;

    private Integer rjs13;

    private Integer updatetime;

    private Integer truetag1;

    private Integer flag;

    private String linksource;

    private String fjian;

    //新增
    private String rjs14;

    private String rjs15;

    public Main_CHLandLAR(){

    }

    public Main_CHLandLAR(long l, String newstitle, String deptcode, String releasetime, String imptime, String deptname, String filenum, String rjs1, String keyword) {

        this.rid = (int)l;
        this.rjs0 = newstitle;
        this.rjs4 = deptcode;
        this.rjs5 = releasetime;
        this.rjs6 = imptime;
        this.rjs10 = deptname;
        this.rjs12 = filenum;
        this.rjs1 = rjs1;
        this.kword = keyword;

    }

    public String getRjs14() {
        return rjs14;
    }

    public void setRjs14(String rjs14) {
        this.rjs14 = rjs14;
    }

    public String getRjs15() {
        return rjs15;
    }

    public void setRjs15(String rjs15) {
        this.rjs15 = rjs15;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRjs0() {
        return rjs0;
    }

    public void setRjs0(String rjs0) {
        this.rjs0 = rjs0;
    }

    public String getRjs1() {
        return rjs1;
    }

    public void setRjs1(String rjs1) {
        this.rjs1 = rjs1;
    }

    public String getRjs4() {
        return rjs4;
    }

    public void setRjs4(String rjs4) {
        this.rjs4 = rjs4;
    }

    public String getRjs5() {
        return rjs5;
    }

    public void setRjs5(String rjs5) {
        this.rjs5 = rjs5;
    }

    public String getRjs6() {
        return rjs6;
    }

    public void setRjs6(String rjs6) {
        this.rjs6 = rjs6;
    }

    public String getRjs7() {
        return rjs7;
    }

    public void setRjs7(String rjs7) {
        this.rjs7 = rjs7;
    }

    public String getRjs8() {
        return rjs8;
    }

    public void setRjs8(String rjs8) {
        this.rjs8 = rjs8;
    }

    public Short getRjs9() {
        return rjs9;
    }

    public void setRjs9(Short rjs9) {
        this.rjs9 = rjs9;
    }

    public String getRjs10() {
        return rjs10;
    }

    public void setRjs10(String rjs10) {
        this.rjs10 = rjs10;
    }

    public String getRjs11() {
        return rjs11;
    }

    public void setRjs11(String rjs11) {
        this.rjs11 = rjs11;
    }

    public String getRjs12() {
        return rjs12;
    }

    public void setRjs12(String rjs12) {
        this.rjs12 = rjs12;
    }

    public String getKword() {
        return kword;
    }

    public void setKword(String kword) {
        this.kword = kword;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public Date getAppdate() {
        return appdate;
    }

    public void setAppdate(Date appdate) {
        this.appdate = appdate;
    }

    public Integer getTruetag() {
        return truetag;
    }

    public void setTruetag(Integer truetag) {
        this.truetag = truetag;
    }

    public Integer getLawlevel() {
        return lawlevel;
    }

    public void setLawlevel(Integer lawlevel) {
        this.lawlevel = lawlevel;
    }

    public Integer getRjs13() {
        return rjs13;
    }

    public void setRjs13(Integer rjs13) {
        this.rjs13 = rjs13;
    }

    public Integer getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Integer updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getTruetag1() {
        return truetag1;
    }

    public void setTruetag1(Integer truetag1) {
        this.truetag1 = truetag1;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getLinksource() {
        return linksource;
    }

    public void setLinksource(String linksource) {
        this.linksource = linksource;
    }

    public String getFjian() {
        return fjian;
    }

    public void setFjian(String fjian) {
        this.fjian = fjian;
    }
}
