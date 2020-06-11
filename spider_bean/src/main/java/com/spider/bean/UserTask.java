package com.spider.bean;

public class UserTask {
    private Integer id;

    private String name;

    private String pass;

    private Integer websiteid;

    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public Integer getWebsiteid() {
        return websiteid;
    }

    public void setWebsiteid(Integer websiteid) {
        this.websiteid = websiteid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}