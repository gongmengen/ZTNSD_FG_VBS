package com.spider.bean;

public class Informationtwice {
    private Integer id;

    private Integer twiceKind;

    private Integer twicePriority;

    private String twiceScript;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTwiceKind() {
        return twiceKind;
    }

    public void setTwiceKind(Integer twiceKind) {
        this.twiceKind = twiceKind;
    }

    public Integer getTwicePriority() {
        return twicePriority;
    }

    public void setTwicePriority(Integer twicePriority) {
        this.twicePriority = twicePriority;
    }

    public String getTwiceScript() {
        return twiceScript;
    }

    public void setTwiceScript(String twiceScript) {
        this.twiceScript = twiceScript == null ? null : twiceScript.trim();
    }
}