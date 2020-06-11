package com.spider.bean;

public class Informationcheck {
    private Integer id;

    private Integer ckKind;

    private Integer ckPriority;

    private String ckScript;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCkKind() {
        return ckKind;
    }

    public void setCkKind(Integer ckKind) {
        this.ckKind = ckKind;
    }

    public Integer getCkPriority() {
        return ckPriority;
    }

    public void setCkPriority(Integer ckPriority) {
        this.ckPriority = ckPriority;
    }

    public String getCkScript() {
        return ckScript;
    }

    public void setCkScript(String ckScript) {
        this.ckScript = ckScript == null ? null : ckScript.trim();
    }
}