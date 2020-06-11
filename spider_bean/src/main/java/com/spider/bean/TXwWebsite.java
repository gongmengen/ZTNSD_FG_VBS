package com.spider.bean;

import java.util.Date;

public class TXwWebsite {
    private Integer id;

    private String websitename;

    private String websiteaddress;

    private String websitecron;

    private Integer columnid;

    private Integer updatecycle;

    private String webcharset;

    private Integer userid;

    private String username;

    private Date lasttime;

    private Date createtime;

    private Integer istatus;

    private String grablist;

    private String grabsonwebsite;

    private String grabcontent;

    private String grabpic;

    private String grabtitle;

    private String grabtime;

    private String grabsource;

    private String dynamicquery;

    private String removestring;

    private String removesection;

    private String dycolumn;

    private Integer refmain;

    private Integer belongdepartment;

    private String departmentDbName;

    private String type;

    private Integer issuccess;

    private String pageaddress;

    private Integer ispage;

    private Integer currpage;

    private Date endgeccotime;

    private String nodecode;

    private String usertask;

    private Integer titlestatus;

    private Integer newsnumstatus;

    //表中不含有的字段
    private Integer spidercount;

    public Integer getNotUpdateTime() {
        return notUpdateTime;
    }

    public void setNotUpdateTime(Integer notUpdateTime) {
        this.notUpdateTime = notUpdateTime;
    }

    private Integer notUpdateTime;//未更新时长

    private String notUpdateDay;//未更新时长

    public String getNotUpdateDay() {
        return notUpdateDay;
    }

    public void setNotUpdateDay(String notUpdateDay) {
        this.notUpdateDay = notUpdateDay;
    }

    public Integer getSpidercount() {
        return spidercount;
    }

    public void setSpidercount(Integer spidercount) {
        this.spidercount = spidercount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebsitename() {
        return websitename;
    }

    public void setWebsitename(String websitename) {
        this.websitename = websitename == null ? null : websitename.trim();
    }

    public String getWebsiteaddress() {
        return websiteaddress;
    }

    public void setWebsiteaddress(String websiteaddress) {
        this.websiteaddress = websiteaddress == null ? null : websiteaddress.trim();
    }

    public String getWebsitecron() {
        return websitecron;
    }

    public void setWebsitecron(String websitecron) {
        this.websitecron = websitecron == null ? null : websitecron.trim();
    }

    public Integer getColumnid() {
        return columnid;
    }

    public void setColumnid(Integer columnid) {
        this.columnid = columnid;
    }

    public Integer getUpdatecycle() {
        return updatecycle;
    }

    public void setUpdatecycle(Integer updatecycle) {
        this.updatecycle = updatecycle;
    }

    public String getWebcharset() {
        return webcharset;
    }

    public void setWebcharset(String webcharset) {
        this.webcharset = webcharset == null ? null : webcharset.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getIstatus() {
        return istatus;
    }

    public void setIstatus(Integer istatus) {
        this.istatus = istatus;
    }

    public String getGrablist() {
        return grablist;
    }

    public void setGrablist(String grablist) {
        this.grablist = grablist == null ? null : grablist.trim();
    }

    public String getGrabsonwebsite() {
        return grabsonwebsite;
    }

    public void setGrabsonwebsite(String grabsonwebsite) {
        this.grabsonwebsite = grabsonwebsite == null ? null : grabsonwebsite.trim();
    }

    public String getGrabcontent() {
        return grabcontent;
    }

    public void setGrabcontent(String grabcontent) {
        this.grabcontent = grabcontent == null ? null : grabcontent.trim();
    }

    public String getGrabpic() {
        return grabpic;
    }

    public void setGrabpic(String grabpic) {
        this.grabpic = grabpic == null ? null : grabpic.trim();
    }

    public String getGrabtitle() {
        return grabtitle;
    }

    public void setGrabtitle(String grabtitle) {
        this.grabtitle = grabtitle == null ? null : grabtitle.trim();
    }

    public String getGrabtime() {
        return grabtime;
    }

    public void setGrabtime(String grabtime) {
        this.grabtime = grabtime == null ? null : grabtime.trim();
    }

    public String getGrabsource() {
        return grabsource;
    }

    public void setGrabsource(String grabsource) {
        this.grabsource = grabsource == null ? null : grabsource.trim();
    }

    public String getDynamicquery() {
        return dynamicquery;
    }

    public void setDynamicquery(String dynamicquery) {
        this.dynamicquery = dynamicquery == null ? null : dynamicquery.trim();
    }

    public String getRemovestring() {
        return removestring;
    }

    public void setRemovestring(String removestring) {
        this.removestring = removestring == null ? null : removestring.trim();
    }

    public String getRemovesection() {
        return removesection;
    }

    public void setRemovesection(String removesection) {
        this.removesection = removesection == null ? null : removesection.trim();
    }

    public String getDycolumn() {
        return dycolumn;
    }

    public void setDycolumn(String dycolumn) {
        this.dycolumn = dycolumn == null ? null : dycolumn.trim();
    }

    public Integer getRefmain() {
        return refmain;
    }

    public void setRefmain(Integer refmain) {
        this.refmain = refmain;
    }

    public Integer getBelongdepartment() {
        return belongdepartment;
    }

    public void setBelongdepartment(Integer belongdepartment) {
        this.belongdepartment = belongdepartment;
    }

    public String getDepartmentDbName() {
        return departmentDbName;
    }

    public void setDepartmentDbName(String departmentDbName) {
        this.departmentDbName = departmentDbName == null ? null : departmentDbName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getIssuccess() {
        return issuccess;
    }

    public void setIssuccess(Integer issuccess) {
        this.issuccess = issuccess;
    }

    public String getPageaddress() {
        return pageaddress;
    }

    public void setPageaddress(String pageaddress) {
        this.pageaddress = pageaddress == null ? null : pageaddress.trim();
    }

    public Integer getIspage() {
        return ispage;
    }

    public void setIspage(Integer ispage) {
        this.ispage = ispage;
    }

    public Integer getCurrpage() {
        return currpage;
    }

    public void setCurrpage(Integer currpage) {
        this.currpage = currpage;
    }

    public Date getEndgeccotime() {
        return endgeccotime;
    }

    public void setEndgeccotime(Date endgeccotime) {
        this.endgeccotime = endgeccotime;
    }

    public String getNodecode() {
        return nodecode;
    }

    public void setNodecode(String nodecode) {
        this.nodecode = nodecode == null ? null : nodecode.trim();
    }

    public String getUsertask() {
        return usertask;
    }

    public void setUsertask(String usertask) {
        this.usertask = usertask == null ? null : usertask.trim();
    }

    public Integer getTitlestatus() {
        return titlestatus;
    }

    public void setTitlestatus(Integer titlestatus) {
        this.titlestatus = titlestatus;
    }

    public Integer getNewsnumstatus() {
        return newsnumstatus;
    }

    public void setNewsnumstatus(Integer newsnumstatus) {
        this.newsnumstatus = newsnumstatus;
    }
}