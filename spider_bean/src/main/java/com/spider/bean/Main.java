package com.spider.bean;

import java.util.Comparator;
import java.util.Date;

public class Main {
    private Long number;

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

    private Integer marked;

    private String anyou;

    private Long rid;

    private Integer rjs13;

    private Integer updatetime;

    private Integer truetag1;

    //增加 重复判断字段
    private Integer pre_distinct;

    //附件数
    private Integer fj_count;

    //正文字数
    private long contentSize;

    //排序得分
    private int compare_score;

    public static final Comparator<Main> MAIN_BY_SCORE = new Comparator<Main>(){
        public int compare(Main o1, Main o2) {
            if (o1.getCompare_score()>o2.getCompare_score()){
                return -1;
            }else if (o1.getCompare_score()<o2.getCompare_score()){
                return 1;
            }else {
                return 0;
            }

        }
    };


    public Main(Long number, String rjs0, String rjs4,String rjs5,String rjs6, String rjs10,String rjs12) {
        this.number = number;
        this.rjs0 = rjs0;
        this.rjs4 = rjs4;
        this.rjs5 = rjs5;
        this.rjs6 = rjs6;
        this.rjs10 = rjs10;
        this.rjs12 = rjs12;
    }

    public Main() {
    }

    public int getCompare_score() {
        return compare_score;
    }

    public void setCompare_score(int compare_score) {
        this.compare_score = compare_score;
    }

    public long getContentSize() {
        return contentSize;
    }

    public void setContentSize(long contentSize) {
        this.contentSize = contentSize;
    }

    public Integer getFj_count() {
        return fj_count;
    }

    public void setFj_count(Integer fj_count) {
        this.fj_count = fj_count;
    }

    public Integer getPre_distinct() {
        return pre_distinct;
    }

    public void setPre_distinct(Integer pre_distinct) {
        this.pre_distinct = pre_distinct;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getRjs0() {
        return rjs0;
    }

    public void setRjs0(String rjs0) {
        this.rjs0 = rjs0 == null ? null : rjs0.trim();
    }

    public String getRjs1() {
        return rjs1;
    }

    public void setRjs1(String rjs1) {
        this.rjs1 = rjs1 == null ? null : rjs1.trim();
    }

    public String getRjs4() {
        return rjs4;
    }

    public void setRjs4(String rjs4) {
        this.rjs4 = rjs4 == null ? null : rjs4.trim();
    }

    public String getRjs5() {
        return rjs5;
    }

    public void setRjs5(String rjs5) {
        this.rjs5 = rjs5 == null ? null : rjs5.trim();
    }

    public String getRjs6() {
        return rjs6;
    }

    public void setRjs6(String rjs6) {
        this.rjs6 = rjs6 == null ? null : rjs6.trim();
    }

    public String getRjs7() {
        return rjs7;
    }

    public void setRjs7(String rjs7) {
        this.rjs7 = rjs7 == null ? null : rjs7.trim();
    }

    public String getRjs8() {
        return rjs8;
    }

    public void setRjs8(String rjs8) {
        this.rjs8 = rjs8 == null ? null : rjs8.trim();
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
        this.rjs10 = rjs10 == null ? null : rjs10.trim();
    }

    public String getRjs11() {
        return rjs11;
    }

    public void setRjs11(String rjs11) {
        this.rjs11 = rjs11 == null ? null : rjs11.trim();
    }

    public String getRjs12() {
        return rjs12;
    }

    public void setRjs12(String rjs12) {
        this.rjs12 = rjs12 == null ? null : rjs12.trim();
    }

    public String getKword() {
        return kword;
    }

    public void setKword(String kword) {
        this.kword = kword == null ? null : kword.trim();
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser == null ? null : appuser.trim();
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

    public Integer getMarked() {
        return marked;
    }

    public void setMarked(Integer marked) {
        this.marked = marked;
    }

    public String getAnyou() {
        return anyou;
    }

    public void setAnyou(String anyou) {
        this.anyou = anyou == null ? null : anyou.trim();
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
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
}