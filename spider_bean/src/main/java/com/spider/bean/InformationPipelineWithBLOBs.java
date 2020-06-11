package com.spider.bean;

public class InformationPipelineWithBLOBs extends InformationPipeline {
    private String newscontent;

    private String attachment;

    private String fjian;

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent == null ? null : newscontent;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getFjian() {
        return fjian;
    }

    public void setFjian(String fjian) {
        this.fjian = fjian == null ? null : fjian.trim();
    }
}