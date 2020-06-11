package com.spider.bean;

public class TXwInformationWithBLOBs extends TXwInformation {
    private String newscontent;

    private String newscontentnotupdate;

    private String abstractnewscontent;

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent == null ? null : newscontent.trim();
    }

    public String getNewscontentnotupdate() {
        return newscontentnotupdate;
    }

    public void setNewscontentnotupdate(String newscontentnotupdate) {
        this.newscontentnotupdate = newscontentnotupdate == null ? null : newscontentnotupdate.trim();
    }

    public String getAbstractnewscontent() {
        return abstractnewscontent;
    }

    public void setAbstractnewscontent(String abstractnewscontent) {
        this.abstractnewscontent = abstractnewscontent == null ? null : abstractnewscontent.trim();
    }
}