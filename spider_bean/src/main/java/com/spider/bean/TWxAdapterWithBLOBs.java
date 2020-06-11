package com.spider.bean;

public class TWxAdapterWithBLOBs extends TWxAdapter {
    private String title;

    private String newscontent;

    private String releasedate;

    private String newnum;

    private String implementdate;

    private String composetext;

    private String attachment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent == null ? null : newscontent.trim();
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate == null ? null : releasedate.trim();
    }

    public String getNewnum() {
        return newnum;
    }

    public void setNewnum(String newnum) {
        this.newnum = newnum == null ? null : newnum.trim();
    }

    public String getImplementdate() {
        return implementdate;
    }

    public void setImplementdate(String implementdate) {
        this.implementdate = implementdate == null ? null : implementdate.trim();
    }

    public String getComposetext() {
        return composetext;
    }

    public void setComposetext(String composetext) {
        this.composetext = composetext == null ? null : composetext.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }
}