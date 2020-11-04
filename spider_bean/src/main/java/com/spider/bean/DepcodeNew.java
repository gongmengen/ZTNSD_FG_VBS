package com.spider.bean;

public class DepcodeNew {
    private String depNumber;

    private String depName;

    private String alisName;

    private Short sortF;

    public String getDepNumber() {
        return depNumber;
    }

    public void setDepNumber(String depNumber) {
        this.depNumber = depNumber == null ? null : depNumber.trim();
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    public String getAlisName() {
        return alisName;
    }

    public void setAlisName(String alisName) {
        this.alisName = alisName == null ? null : alisName.trim();
    }

    public Short getSortF() {
        return sortF;
    }

    public void setSortF(Short sortF) {
        this.sortF = sortF;
    }
}