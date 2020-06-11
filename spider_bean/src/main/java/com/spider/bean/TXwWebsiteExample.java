package com.spider.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TXwWebsiteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TXwWebsiteExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWebsitenameIsNull() {
            addCriterion("websiteName is null");
            return (Criteria) this;
        }

        public Criteria andWebsitenameIsNotNull() {
            addCriterion("websiteName is not null");
            return (Criteria) this;
        }

        public Criteria andWebsitenameEqualTo(String value) {
            addCriterion("websiteName =", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameNotEqualTo(String value) {
            addCriterion("websiteName <>", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameGreaterThan(String value) {
            addCriterion("websiteName >", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameGreaterThanOrEqualTo(String value) {
            addCriterion("websiteName >=", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameLessThan(String value) {
            addCriterion("websiteName <", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameLessThanOrEqualTo(String value) {
            addCriterion("websiteName <=", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameLike(String value) {
            addCriterion("websiteName like", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameNotLike(String value) {
            addCriterion("websiteName not like", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameIn(List<String> values) {
            addCriterion("websiteName in", values, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameNotIn(List<String> values) {
            addCriterion("websiteName not in", values, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameBetween(String value1, String value2) {
            addCriterion("websiteName between", value1, value2, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameNotBetween(String value1, String value2) {
            addCriterion("websiteName not between", value1, value2, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressIsNull() {
            addCriterion("websiteAddress is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressIsNotNull() {
            addCriterion("websiteAddress is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressEqualTo(String value) {
            addCriterion("websiteAddress =", value, "websiteaddress");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressNotEqualTo(String value) {
            addCriterion("websiteAddress <>", value, "websiteaddress");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressGreaterThan(String value) {
            addCriterion("websiteAddress >", value, "websiteaddress");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressGreaterThanOrEqualTo(String value) {
            addCriterion("websiteAddress >=", value, "websiteaddress");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressLessThan(String value) {
            addCriterion("websiteAddress <", value, "websiteaddress");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressLessThanOrEqualTo(String value) {
            addCriterion("websiteAddress <=", value, "websiteaddress");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressLike(String value) {
            addCriterion("websiteAddress like", value, "websiteaddress");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressNotLike(String value) {
            addCriterion("websiteAddress not like", value, "websiteaddress");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressIn(List<String> values) {
            addCriterion("websiteAddress in", values, "websiteaddress");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressNotIn(List<String> values) {
            addCriterion("websiteAddress not in", values, "websiteaddress");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressBetween(String value1, String value2) {
            addCriterion("websiteAddress between", value1, value2, "websiteaddress");
            return (Criteria) this;
        }

        public Criteria andWebsiteaddressNotBetween(String value1, String value2) {
            addCriterion("websiteAddress not between", value1, value2, "websiteaddress");
            return (Criteria) this;
        }

        public Criteria andWebsitecronIsNull() {
            addCriterion("websiteCron is null");
            return (Criteria) this;
        }

        public Criteria andWebsitecronIsNotNull() {
            addCriterion("websiteCron is not null");
            return (Criteria) this;
        }

        public Criteria andWebsitecronEqualTo(String value) {
            addCriterion("websiteCron =", value, "websitecron");
            return (Criteria) this;
        }

        public Criteria andWebsitecronNotEqualTo(String value) {
            addCriterion("websiteCron <>", value, "websitecron");
            return (Criteria) this;
        }

        public Criteria andWebsitecronGreaterThan(String value) {
            addCriterion("websiteCron >", value, "websitecron");
            return (Criteria) this;
        }

        public Criteria andWebsitecronGreaterThanOrEqualTo(String value) {
            addCriterion("websiteCron >=", value, "websitecron");
            return (Criteria) this;
        }

        public Criteria andWebsitecronLessThan(String value) {
            addCriterion("websiteCron <", value, "websitecron");
            return (Criteria) this;
        }

        public Criteria andWebsitecronLessThanOrEqualTo(String value) {
            addCriterion("websiteCron <=", value, "websitecron");
            return (Criteria) this;
        }

        public Criteria andWebsitecronLike(String value) {
            addCriterion("websiteCron like", value, "websitecron");
            return (Criteria) this;
        }

        public Criteria andWebsitecronNotLike(String value) {
            addCriterion("websiteCron not like", value, "websitecron");
            return (Criteria) this;
        }

        public Criteria andWebsitecronIn(List<String> values) {
            addCriterion("websiteCron in", values, "websitecron");
            return (Criteria) this;
        }

        public Criteria andWebsitecronNotIn(List<String> values) {
            addCriterion("websiteCron not in", values, "websitecron");
            return (Criteria) this;
        }

        public Criteria andWebsitecronBetween(String value1, String value2) {
            addCriterion("websiteCron between", value1, value2, "websitecron");
            return (Criteria) this;
        }

        public Criteria andWebsitecronNotBetween(String value1, String value2) {
            addCriterion("websiteCron not between", value1, value2, "websitecron");
            return (Criteria) this;
        }

        public Criteria andColumnidIsNull() {
            addCriterion("columnId is null");
            return (Criteria) this;
        }

        public Criteria andColumnidIsNotNull() {
            addCriterion("columnId is not null");
            return (Criteria) this;
        }

        public Criteria andColumnidEqualTo(Integer value) {
            addCriterion("columnId =", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidNotEqualTo(Integer value) {
            addCriterion("columnId <>", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidGreaterThan(Integer value) {
            addCriterion("columnId >", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidGreaterThanOrEqualTo(Integer value) {
            addCriterion("columnId >=", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidLessThan(Integer value) {
            addCriterion("columnId <", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidLessThanOrEqualTo(Integer value) {
            addCriterion("columnId <=", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidIn(List<Integer> values) {
            addCriterion("columnId in", values, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidNotIn(List<Integer> values) {
            addCriterion("columnId not in", values, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidBetween(Integer value1, Integer value2) {
            addCriterion("columnId between", value1, value2, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidNotBetween(Integer value1, Integer value2) {
            addCriterion("columnId not between", value1, value2, "columnid");
            return (Criteria) this;
        }

        public Criteria andUpdatecycleIsNull() {
            addCriterion("updateCycle is null");
            return (Criteria) this;
        }

        public Criteria andUpdatecycleIsNotNull() {
            addCriterion("updateCycle is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatecycleEqualTo(Integer value) {
            addCriterion("updateCycle =", value, "updatecycle");
            return (Criteria) this;
        }

        public Criteria andUpdatecycleNotEqualTo(Integer value) {
            addCriterion("updateCycle <>", value, "updatecycle");
            return (Criteria) this;
        }

        public Criteria andUpdatecycleGreaterThan(Integer value) {
            addCriterion("updateCycle >", value, "updatecycle");
            return (Criteria) this;
        }

        public Criteria andUpdatecycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("updateCycle >=", value, "updatecycle");
            return (Criteria) this;
        }

        public Criteria andUpdatecycleLessThan(Integer value) {
            addCriterion("updateCycle <", value, "updatecycle");
            return (Criteria) this;
        }

        public Criteria andUpdatecycleLessThanOrEqualTo(Integer value) {
            addCriterion("updateCycle <=", value, "updatecycle");
            return (Criteria) this;
        }

        public Criteria andUpdatecycleIn(List<Integer> values) {
            addCriterion("updateCycle in", values, "updatecycle");
            return (Criteria) this;
        }

        public Criteria andUpdatecycleNotIn(List<Integer> values) {
            addCriterion("updateCycle not in", values, "updatecycle");
            return (Criteria) this;
        }

        public Criteria andUpdatecycleBetween(Integer value1, Integer value2) {
            addCriterion("updateCycle between", value1, value2, "updatecycle");
            return (Criteria) this;
        }

        public Criteria andUpdatecycleNotBetween(Integer value1, Integer value2) {
            addCriterion("updateCycle not between", value1, value2, "updatecycle");
            return (Criteria) this;
        }

        public Criteria andWebcharsetIsNull() {
            addCriterion("webCharset is null");
            return (Criteria) this;
        }

        public Criteria andWebcharsetIsNotNull() {
            addCriterion("webCharset is not null");
            return (Criteria) this;
        }

        public Criteria andWebcharsetEqualTo(String value) {
            addCriterion("webCharset =", value, "webcharset");
            return (Criteria) this;
        }

        public Criteria andWebcharsetNotEqualTo(String value) {
            addCriterion("webCharset <>", value, "webcharset");
            return (Criteria) this;
        }

        public Criteria andWebcharsetGreaterThan(String value) {
            addCriterion("webCharset >", value, "webcharset");
            return (Criteria) this;
        }

        public Criteria andWebcharsetGreaterThanOrEqualTo(String value) {
            addCriterion("webCharset >=", value, "webcharset");
            return (Criteria) this;
        }

        public Criteria andWebcharsetLessThan(String value) {
            addCriterion("webCharset <", value, "webcharset");
            return (Criteria) this;
        }

        public Criteria andWebcharsetLessThanOrEqualTo(String value) {
            addCriterion("webCharset <=", value, "webcharset");
            return (Criteria) this;
        }

        public Criteria andWebcharsetLike(String value) {
            addCriterion("webCharset like", value, "webcharset");
            return (Criteria) this;
        }

        public Criteria andWebcharsetNotLike(String value) {
            addCriterion("webCharset not like", value, "webcharset");
            return (Criteria) this;
        }

        public Criteria andWebcharsetIn(List<String> values) {
            addCriterion("webCharset in", values, "webcharset");
            return (Criteria) this;
        }

        public Criteria andWebcharsetNotIn(List<String> values) {
            addCriterion("webCharset not in", values, "webcharset");
            return (Criteria) this;
        }

        public Criteria andWebcharsetBetween(String value1, String value2) {
            addCriterion("webCharset between", value1, value2, "webcharset");
            return (Criteria) this;
        }

        public Criteria andWebcharsetNotBetween(String value1, String value2) {
            addCriterion("webCharset not between", value1, value2, "webcharset");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNull() {
            addCriterion("lastTime is null");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNotNull() {
            addCriterion("lastTime is not null");
            return (Criteria) this;
        }

        public Criteria andLasttimeEqualTo(Date value) {
            addCriterion("lastTime =", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotEqualTo(Date value) {
            addCriterion("lastTime <>", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThan(Date value) {
            addCriterion("lastTime >", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastTime >=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThan(Date value) {
            addCriterion("lastTime <", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThanOrEqualTo(Date value) {
            addCriterion("lastTime <=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeIn(List<Date> values) {
            addCriterion("lastTime in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotIn(List<Date> values) {
            addCriterion("lastTime not in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeBetween(Date value1, Date value2) {
            addCriterion("lastTime between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotBetween(Date value1, Date value2) {
            addCriterion("lastTime not between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andIstatusIsNull() {
            addCriterion("istatus is null");
            return (Criteria) this;
        }

        public Criteria andIstatusIsNotNull() {
            addCriterion("istatus is not null");
            return (Criteria) this;
        }

        public Criteria andIstatusEqualTo(Integer value) {
            addCriterion("istatus =", value, "istatus");
            return (Criteria) this;
        }

        public Criteria andIstatusNotEqualTo(Integer value) {
            addCriterion("istatus <>", value, "istatus");
            return (Criteria) this;
        }

        public Criteria andIstatusGreaterThan(Integer value) {
            addCriterion("istatus >", value, "istatus");
            return (Criteria) this;
        }

        public Criteria andIstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("istatus >=", value, "istatus");
            return (Criteria) this;
        }

        public Criteria andIstatusLessThan(Integer value) {
            addCriterion("istatus <", value, "istatus");
            return (Criteria) this;
        }

        public Criteria andIstatusLessThanOrEqualTo(Integer value) {
            addCriterion("istatus <=", value, "istatus");
            return (Criteria) this;
        }

        public Criteria andIstatusIn(List<Integer> values) {
            addCriterion("istatus in", values, "istatus");
            return (Criteria) this;
        }

        public Criteria andIstatusNotIn(List<Integer> values) {
            addCriterion("istatus not in", values, "istatus");
            return (Criteria) this;
        }

        public Criteria andIstatusBetween(Integer value1, Integer value2) {
            addCriterion("istatus between", value1, value2, "istatus");
            return (Criteria) this;
        }

        public Criteria andIstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("istatus not between", value1, value2, "istatus");
            return (Criteria) this;
        }

        public Criteria andGrablistIsNull() {
            addCriterion("GrabList is null");
            return (Criteria) this;
        }

        public Criteria andGrablistIsNotNull() {
            addCriterion("GrabList is not null");
            return (Criteria) this;
        }

        public Criteria andGrablistEqualTo(String value) {
            addCriterion("GrabList =", value, "grablist");
            return (Criteria) this;
        }

        public Criteria andGrablistNotEqualTo(String value) {
            addCriterion("GrabList <>", value, "grablist");
            return (Criteria) this;
        }

        public Criteria andGrablistGreaterThan(String value) {
            addCriterion("GrabList >", value, "grablist");
            return (Criteria) this;
        }

        public Criteria andGrablistGreaterThanOrEqualTo(String value) {
            addCriterion("GrabList >=", value, "grablist");
            return (Criteria) this;
        }

        public Criteria andGrablistLessThan(String value) {
            addCriterion("GrabList <", value, "grablist");
            return (Criteria) this;
        }

        public Criteria andGrablistLessThanOrEqualTo(String value) {
            addCriterion("GrabList <=", value, "grablist");
            return (Criteria) this;
        }

        public Criteria andGrablistLike(String value) {
            addCriterion("GrabList like", value, "grablist");
            return (Criteria) this;
        }

        public Criteria andGrablistNotLike(String value) {
            addCriterion("GrabList not like", value, "grablist");
            return (Criteria) this;
        }

        public Criteria andGrablistIn(List<String> values) {
            addCriterion("GrabList in", values, "grablist");
            return (Criteria) this;
        }

        public Criteria andGrablistNotIn(List<String> values) {
            addCriterion("GrabList not in", values, "grablist");
            return (Criteria) this;
        }

        public Criteria andGrablistBetween(String value1, String value2) {
            addCriterion("GrabList between", value1, value2, "grablist");
            return (Criteria) this;
        }

        public Criteria andGrablistNotBetween(String value1, String value2) {
            addCriterion("GrabList not between", value1, value2, "grablist");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteIsNull() {
            addCriterion("Grabsonwebsite is null");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteIsNotNull() {
            addCriterion("Grabsonwebsite is not null");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteEqualTo(String value) {
            addCriterion("Grabsonwebsite =", value, "grabsonwebsite");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteNotEqualTo(String value) {
            addCriterion("Grabsonwebsite <>", value, "grabsonwebsite");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteGreaterThan(String value) {
            addCriterion("Grabsonwebsite >", value, "grabsonwebsite");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("Grabsonwebsite >=", value, "grabsonwebsite");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteLessThan(String value) {
            addCriterion("Grabsonwebsite <", value, "grabsonwebsite");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteLessThanOrEqualTo(String value) {
            addCriterion("Grabsonwebsite <=", value, "grabsonwebsite");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteLike(String value) {
            addCriterion("Grabsonwebsite like", value, "grabsonwebsite");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteNotLike(String value) {
            addCriterion("Grabsonwebsite not like", value, "grabsonwebsite");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteIn(List<String> values) {
            addCriterion("Grabsonwebsite in", values, "grabsonwebsite");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteNotIn(List<String> values) {
            addCriterion("Grabsonwebsite not in", values, "grabsonwebsite");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteBetween(String value1, String value2) {
            addCriterion("Grabsonwebsite between", value1, value2, "grabsonwebsite");
            return (Criteria) this;
        }

        public Criteria andGrabsonwebsiteNotBetween(String value1, String value2) {
            addCriterion("Grabsonwebsite not between", value1, value2, "grabsonwebsite");
            return (Criteria) this;
        }

        public Criteria andGrabcontentIsNull() {
            addCriterion("GrabContent is null");
            return (Criteria) this;
        }

        public Criteria andGrabcontentIsNotNull() {
            addCriterion("GrabContent is not null");
            return (Criteria) this;
        }

        public Criteria andGrabcontentEqualTo(String value) {
            addCriterion("GrabContent =", value, "grabcontent");
            return (Criteria) this;
        }

        public Criteria andGrabcontentNotEqualTo(String value) {
            addCriterion("GrabContent <>", value, "grabcontent");
            return (Criteria) this;
        }

        public Criteria andGrabcontentGreaterThan(String value) {
            addCriterion("GrabContent >", value, "grabcontent");
            return (Criteria) this;
        }

        public Criteria andGrabcontentGreaterThanOrEqualTo(String value) {
            addCriterion("GrabContent >=", value, "grabcontent");
            return (Criteria) this;
        }

        public Criteria andGrabcontentLessThan(String value) {
            addCriterion("GrabContent <", value, "grabcontent");
            return (Criteria) this;
        }

        public Criteria andGrabcontentLessThanOrEqualTo(String value) {
            addCriterion("GrabContent <=", value, "grabcontent");
            return (Criteria) this;
        }

        public Criteria andGrabcontentLike(String value) {
            addCriterion("GrabContent like", value, "grabcontent");
            return (Criteria) this;
        }

        public Criteria andGrabcontentNotLike(String value) {
            addCriterion("GrabContent not like", value, "grabcontent");
            return (Criteria) this;
        }

        public Criteria andGrabcontentIn(List<String> values) {
            addCriterion("GrabContent in", values, "grabcontent");
            return (Criteria) this;
        }

        public Criteria andGrabcontentNotIn(List<String> values) {
            addCriterion("GrabContent not in", values, "grabcontent");
            return (Criteria) this;
        }

        public Criteria andGrabcontentBetween(String value1, String value2) {
            addCriterion("GrabContent between", value1, value2, "grabcontent");
            return (Criteria) this;
        }

        public Criteria andGrabcontentNotBetween(String value1, String value2) {
            addCriterion("GrabContent not between", value1, value2, "grabcontent");
            return (Criteria) this;
        }

        public Criteria andGrabpicIsNull() {
            addCriterion("GrabPic is null");
            return (Criteria) this;
        }

        public Criteria andGrabpicIsNotNull() {
            addCriterion("GrabPic is not null");
            return (Criteria) this;
        }

        public Criteria andGrabpicEqualTo(String value) {
            addCriterion("GrabPic =", value, "grabpic");
            return (Criteria) this;
        }

        public Criteria andGrabpicNotEqualTo(String value) {
            addCriterion("GrabPic <>", value, "grabpic");
            return (Criteria) this;
        }

        public Criteria andGrabpicGreaterThan(String value) {
            addCriterion("GrabPic >", value, "grabpic");
            return (Criteria) this;
        }

        public Criteria andGrabpicGreaterThanOrEqualTo(String value) {
            addCriterion("GrabPic >=", value, "grabpic");
            return (Criteria) this;
        }

        public Criteria andGrabpicLessThan(String value) {
            addCriterion("GrabPic <", value, "grabpic");
            return (Criteria) this;
        }

        public Criteria andGrabpicLessThanOrEqualTo(String value) {
            addCriterion("GrabPic <=", value, "grabpic");
            return (Criteria) this;
        }

        public Criteria andGrabpicLike(String value) {
            addCriterion("GrabPic like", value, "grabpic");
            return (Criteria) this;
        }

        public Criteria andGrabpicNotLike(String value) {
            addCriterion("GrabPic not like", value, "grabpic");
            return (Criteria) this;
        }

        public Criteria andGrabpicIn(List<String> values) {
            addCriterion("GrabPic in", values, "grabpic");
            return (Criteria) this;
        }

        public Criteria andGrabpicNotIn(List<String> values) {
            addCriterion("GrabPic not in", values, "grabpic");
            return (Criteria) this;
        }

        public Criteria andGrabpicBetween(String value1, String value2) {
            addCriterion("GrabPic between", value1, value2, "grabpic");
            return (Criteria) this;
        }

        public Criteria andGrabpicNotBetween(String value1, String value2) {
            addCriterion("GrabPic not between", value1, value2, "grabpic");
            return (Criteria) this;
        }

        public Criteria andGrabtitleIsNull() {
            addCriterion("GrabTitle is null");
            return (Criteria) this;
        }

        public Criteria andGrabtitleIsNotNull() {
            addCriterion("GrabTitle is not null");
            return (Criteria) this;
        }

        public Criteria andGrabtitleEqualTo(String value) {
            addCriterion("GrabTitle =", value, "grabtitle");
            return (Criteria) this;
        }

        public Criteria andGrabtitleNotEqualTo(String value) {
            addCriterion("GrabTitle <>", value, "grabtitle");
            return (Criteria) this;
        }

        public Criteria andGrabtitleGreaterThan(String value) {
            addCriterion("GrabTitle >", value, "grabtitle");
            return (Criteria) this;
        }

        public Criteria andGrabtitleGreaterThanOrEqualTo(String value) {
            addCriterion("GrabTitle >=", value, "grabtitle");
            return (Criteria) this;
        }

        public Criteria andGrabtitleLessThan(String value) {
            addCriterion("GrabTitle <", value, "grabtitle");
            return (Criteria) this;
        }

        public Criteria andGrabtitleLessThanOrEqualTo(String value) {
            addCriterion("GrabTitle <=", value, "grabtitle");
            return (Criteria) this;
        }

        public Criteria andGrabtitleLike(String value) {
            addCriterion("GrabTitle like", value, "grabtitle");
            return (Criteria) this;
        }

        public Criteria andGrabtitleNotLike(String value) {
            addCriterion("GrabTitle not like", value, "grabtitle");
            return (Criteria) this;
        }

        public Criteria andGrabtitleIn(List<String> values) {
            addCriterion("GrabTitle in", values, "grabtitle");
            return (Criteria) this;
        }

        public Criteria andGrabtitleNotIn(List<String> values) {
            addCriterion("GrabTitle not in", values, "grabtitle");
            return (Criteria) this;
        }

        public Criteria andGrabtitleBetween(String value1, String value2) {
            addCriterion("GrabTitle between", value1, value2, "grabtitle");
            return (Criteria) this;
        }

        public Criteria andGrabtitleNotBetween(String value1, String value2) {
            addCriterion("GrabTitle not between", value1, value2, "grabtitle");
            return (Criteria) this;
        }

        public Criteria andGrabtimeIsNull() {
            addCriterion("GrabTime is null");
            return (Criteria) this;
        }

        public Criteria andGrabtimeIsNotNull() {
            addCriterion("GrabTime is not null");
            return (Criteria) this;
        }

        public Criteria andGrabtimeEqualTo(String value) {
            addCriterion("GrabTime =", value, "grabtime");
            return (Criteria) this;
        }

        public Criteria andGrabtimeNotEqualTo(String value) {
            addCriterion("GrabTime <>", value, "grabtime");
            return (Criteria) this;
        }

        public Criteria andGrabtimeGreaterThan(String value) {
            addCriterion("GrabTime >", value, "grabtime");
            return (Criteria) this;
        }

        public Criteria andGrabtimeGreaterThanOrEqualTo(String value) {
            addCriterion("GrabTime >=", value, "grabtime");
            return (Criteria) this;
        }

        public Criteria andGrabtimeLessThan(String value) {
            addCriterion("GrabTime <", value, "grabtime");
            return (Criteria) this;
        }

        public Criteria andGrabtimeLessThanOrEqualTo(String value) {
            addCriterion("GrabTime <=", value, "grabtime");
            return (Criteria) this;
        }

        public Criteria andGrabtimeLike(String value) {
            addCriterion("GrabTime like", value, "grabtime");
            return (Criteria) this;
        }

        public Criteria andGrabtimeNotLike(String value) {
            addCriterion("GrabTime not like", value, "grabtime");
            return (Criteria) this;
        }

        public Criteria andGrabtimeIn(List<String> values) {
            addCriterion("GrabTime in", values, "grabtime");
            return (Criteria) this;
        }

        public Criteria andGrabtimeNotIn(List<String> values) {
            addCriterion("GrabTime not in", values, "grabtime");
            return (Criteria) this;
        }

        public Criteria andGrabtimeBetween(String value1, String value2) {
            addCriterion("GrabTime between", value1, value2, "grabtime");
            return (Criteria) this;
        }

        public Criteria andGrabtimeNotBetween(String value1, String value2) {
            addCriterion("GrabTime not between", value1, value2, "grabtime");
            return (Criteria) this;
        }

        public Criteria andGrabsourceIsNull() {
            addCriterion("GrabSource is null");
            return (Criteria) this;
        }

        public Criteria andGrabsourceIsNotNull() {
            addCriterion("GrabSource is not null");
            return (Criteria) this;
        }

        public Criteria andGrabsourceEqualTo(String value) {
            addCriterion("GrabSource =", value, "grabsource");
            return (Criteria) this;
        }

        public Criteria andGrabsourceNotEqualTo(String value) {
            addCriterion("GrabSource <>", value, "grabsource");
            return (Criteria) this;
        }

        public Criteria andGrabsourceGreaterThan(String value) {
            addCriterion("GrabSource >", value, "grabsource");
            return (Criteria) this;
        }

        public Criteria andGrabsourceGreaterThanOrEqualTo(String value) {
            addCriterion("GrabSource >=", value, "grabsource");
            return (Criteria) this;
        }

        public Criteria andGrabsourceLessThan(String value) {
            addCriterion("GrabSource <", value, "grabsource");
            return (Criteria) this;
        }

        public Criteria andGrabsourceLessThanOrEqualTo(String value) {
            addCriterion("GrabSource <=", value, "grabsource");
            return (Criteria) this;
        }

        public Criteria andGrabsourceLike(String value) {
            addCriterion("GrabSource like", value, "grabsource");
            return (Criteria) this;
        }

        public Criteria andGrabsourceNotLike(String value) {
            addCriterion("GrabSource not like", value, "grabsource");
            return (Criteria) this;
        }

        public Criteria andGrabsourceIn(List<String> values) {
            addCriterion("GrabSource in", values, "grabsource");
            return (Criteria) this;
        }

        public Criteria andGrabsourceNotIn(List<String> values) {
            addCriterion("GrabSource not in", values, "grabsource");
            return (Criteria) this;
        }

        public Criteria andGrabsourceBetween(String value1, String value2) {
            addCriterion("GrabSource between", value1, value2, "grabsource");
            return (Criteria) this;
        }

        public Criteria andGrabsourceNotBetween(String value1, String value2) {
            addCriterion("GrabSource not between", value1, value2, "grabsource");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryIsNull() {
            addCriterion("dynamicQuery is null");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryIsNotNull() {
            addCriterion("dynamicQuery is not null");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryEqualTo(String value) {
            addCriterion("dynamicQuery =", value, "dynamicquery");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryNotEqualTo(String value) {
            addCriterion("dynamicQuery <>", value, "dynamicquery");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryGreaterThan(String value) {
            addCriterion("dynamicQuery >", value, "dynamicquery");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryGreaterThanOrEqualTo(String value) {
            addCriterion("dynamicQuery >=", value, "dynamicquery");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryLessThan(String value) {
            addCriterion("dynamicQuery <", value, "dynamicquery");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryLessThanOrEqualTo(String value) {
            addCriterion("dynamicQuery <=", value, "dynamicquery");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryLike(String value) {
            addCriterion("dynamicQuery like", value, "dynamicquery");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryNotLike(String value) {
            addCriterion("dynamicQuery not like", value, "dynamicquery");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryIn(List<String> values) {
            addCriterion("dynamicQuery in", values, "dynamicquery");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryNotIn(List<String> values) {
            addCriterion("dynamicQuery not in", values, "dynamicquery");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryBetween(String value1, String value2) {
            addCriterion("dynamicQuery between", value1, value2, "dynamicquery");
            return (Criteria) this;
        }

        public Criteria andDynamicqueryNotBetween(String value1, String value2) {
            addCriterion("dynamicQuery not between", value1, value2, "dynamicquery");
            return (Criteria) this;
        }

        public Criteria andRemovestringIsNull() {
            addCriterion("removeString is null");
            return (Criteria) this;
        }

        public Criteria andRemovestringIsNotNull() {
            addCriterion("removeString is not null");
            return (Criteria) this;
        }

        public Criteria andRemovestringEqualTo(String value) {
            addCriterion("removeString =", value, "removestring");
            return (Criteria) this;
        }

        public Criteria andRemovestringNotEqualTo(String value) {
            addCriterion("removeString <>", value, "removestring");
            return (Criteria) this;
        }

        public Criteria andRemovestringGreaterThan(String value) {
            addCriterion("removeString >", value, "removestring");
            return (Criteria) this;
        }

        public Criteria andRemovestringGreaterThanOrEqualTo(String value) {
            addCriterion("removeString >=", value, "removestring");
            return (Criteria) this;
        }

        public Criteria andRemovestringLessThan(String value) {
            addCriterion("removeString <", value, "removestring");
            return (Criteria) this;
        }

        public Criteria andRemovestringLessThanOrEqualTo(String value) {
            addCriterion("removeString <=", value, "removestring");
            return (Criteria) this;
        }

        public Criteria andRemovestringLike(String value) {
            addCriterion("removeString like", value, "removestring");
            return (Criteria) this;
        }

        public Criteria andRemovestringNotLike(String value) {
            addCriterion("removeString not like", value, "removestring");
            return (Criteria) this;
        }

        public Criteria andRemovestringIn(List<String> values) {
            addCriterion("removeString in", values, "removestring");
            return (Criteria) this;
        }

        public Criteria andRemovestringNotIn(List<String> values) {
            addCriterion("removeString not in", values, "removestring");
            return (Criteria) this;
        }

        public Criteria andRemovestringBetween(String value1, String value2) {
            addCriterion("removeString between", value1, value2, "removestring");
            return (Criteria) this;
        }

        public Criteria andRemovestringNotBetween(String value1, String value2) {
            addCriterion("removeString not between", value1, value2, "removestring");
            return (Criteria) this;
        }

        public Criteria andRemovesectionIsNull() {
            addCriterion("removeSection is null");
            return (Criteria) this;
        }

        public Criteria andRemovesectionIsNotNull() {
            addCriterion("removeSection is not null");
            return (Criteria) this;
        }

        public Criteria andRemovesectionEqualTo(String value) {
            addCriterion("removeSection =", value, "removesection");
            return (Criteria) this;
        }

        public Criteria andRemovesectionNotEqualTo(String value) {
            addCriterion("removeSection <>", value, "removesection");
            return (Criteria) this;
        }

        public Criteria andRemovesectionGreaterThan(String value) {
            addCriterion("removeSection >", value, "removesection");
            return (Criteria) this;
        }

        public Criteria andRemovesectionGreaterThanOrEqualTo(String value) {
            addCriterion("removeSection >=", value, "removesection");
            return (Criteria) this;
        }

        public Criteria andRemovesectionLessThan(String value) {
            addCriterion("removeSection <", value, "removesection");
            return (Criteria) this;
        }

        public Criteria andRemovesectionLessThanOrEqualTo(String value) {
            addCriterion("removeSection <=", value, "removesection");
            return (Criteria) this;
        }

        public Criteria andRemovesectionLike(String value) {
            addCriterion("removeSection like", value, "removesection");
            return (Criteria) this;
        }

        public Criteria andRemovesectionNotLike(String value) {
            addCriterion("removeSection not like", value, "removesection");
            return (Criteria) this;
        }

        public Criteria andRemovesectionIn(List<String> values) {
            addCriterion("removeSection in", values, "removesection");
            return (Criteria) this;
        }

        public Criteria andRemovesectionNotIn(List<String> values) {
            addCriterion("removeSection not in", values, "removesection");
            return (Criteria) this;
        }

        public Criteria andRemovesectionBetween(String value1, String value2) {
            addCriterion("removeSection between", value1, value2, "removesection");
            return (Criteria) this;
        }

        public Criteria andRemovesectionNotBetween(String value1, String value2) {
            addCriterion("removeSection not between", value1, value2, "removesection");
            return (Criteria) this;
        }

        public Criteria andDycolumnIsNull() {
            addCriterion("dycolumn is null");
            return (Criteria) this;
        }

        public Criteria andDycolumnIsNotNull() {
            addCriterion("dycolumn is not null");
            return (Criteria) this;
        }

        public Criteria andDycolumnEqualTo(String value) {
            addCriterion("dycolumn =", value, "dycolumn");
            return (Criteria) this;
        }

        public Criteria andDycolumnNotEqualTo(String value) {
            addCriterion("dycolumn <>", value, "dycolumn");
            return (Criteria) this;
        }

        public Criteria andDycolumnGreaterThan(String value) {
            addCriterion("dycolumn >", value, "dycolumn");
            return (Criteria) this;
        }

        public Criteria andDycolumnGreaterThanOrEqualTo(String value) {
            addCriterion("dycolumn >=", value, "dycolumn");
            return (Criteria) this;
        }

        public Criteria andDycolumnLessThan(String value) {
            addCriterion("dycolumn <", value, "dycolumn");
            return (Criteria) this;
        }

        public Criteria andDycolumnLessThanOrEqualTo(String value) {
            addCriterion("dycolumn <=", value, "dycolumn");
            return (Criteria) this;
        }

        public Criteria andDycolumnLike(String value) {
            addCriterion("dycolumn like", value, "dycolumn");
            return (Criteria) this;
        }

        public Criteria andDycolumnNotLike(String value) {
            addCriterion("dycolumn not like", value, "dycolumn");
            return (Criteria) this;
        }

        public Criteria andDycolumnIn(List<String> values) {
            addCriterion("dycolumn in", values, "dycolumn");
            return (Criteria) this;
        }

        public Criteria andDycolumnNotIn(List<String> values) {
            addCriterion("dycolumn not in", values, "dycolumn");
            return (Criteria) this;
        }

        public Criteria andDycolumnBetween(String value1, String value2) {
            addCriterion("dycolumn between", value1, value2, "dycolumn");
            return (Criteria) this;
        }

        public Criteria andDycolumnNotBetween(String value1, String value2) {
            addCriterion("dycolumn not between", value1, value2, "dycolumn");
            return (Criteria) this;
        }

        public Criteria andRefmainIsNull() {
            addCriterion("refMain is null");
            return (Criteria) this;
        }

        public Criteria andRefmainIsNotNull() {
            addCriterion("refMain is not null");
            return (Criteria) this;
        }

        public Criteria andRefmainEqualTo(Integer value) {
            addCriterion("refMain =", value, "refmain");
            return (Criteria) this;
        }

        public Criteria andRefmainNotEqualTo(Integer value) {
            addCriterion("refMain <>", value, "refmain");
            return (Criteria) this;
        }

        public Criteria andRefmainGreaterThan(Integer value) {
            addCriterion("refMain >", value, "refmain");
            return (Criteria) this;
        }

        public Criteria andRefmainGreaterThanOrEqualTo(Integer value) {
            addCriterion("refMain >=", value, "refmain");
            return (Criteria) this;
        }

        public Criteria andRefmainLessThan(Integer value) {
            addCriterion("refMain <", value, "refmain");
            return (Criteria) this;
        }

        public Criteria andRefmainLessThanOrEqualTo(Integer value) {
            addCriterion("refMain <=", value, "refmain");
            return (Criteria) this;
        }

        public Criteria andRefmainIn(List<Integer> values) {
            addCriterion("refMain in", values, "refmain");
            return (Criteria) this;
        }

        public Criteria andRefmainNotIn(List<Integer> values) {
            addCriterion("refMain not in", values, "refmain");
            return (Criteria) this;
        }

        public Criteria andRefmainBetween(Integer value1, Integer value2) {
            addCriterion("refMain between", value1, value2, "refmain");
            return (Criteria) this;
        }

        public Criteria andRefmainNotBetween(Integer value1, Integer value2) {
            addCriterion("refMain not between", value1, value2, "refmain");
            return (Criteria) this;
        }

        public Criteria andBelongdepartmentIsNull() {
            addCriterion("belongDepartment is null");
            return (Criteria) this;
        }

        public Criteria andBelongdepartmentIsNotNull() {
            addCriterion("belongDepartment is not null");
            return (Criteria) this;
        }

        public Criteria andBelongdepartmentEqualTo(Integer value) {
            addCriterion("belongDepartment =", value, "belongdepartment");
            return (Criteria) this;
        }

        public Criteria andBelongdepartmentNotEqualTo(Integer value) {
            addCriterion("belongDepartment <>", value, "belongdepartment");
            return (Criteria) this;
        }

        public Criteria andBelongdepartmentGreaterThan(Integer value) {
            addCriterion("belongDepartment >", value, "belongdepartment");
            return (Criteria) this;
        }

        public Criteria andBelongdepartmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("belongDepartment >=", value, "belongdepartment");
            return (Criteria) this;
        }

        public Criteria andBelongdepartmentLessThan(Integer value) {
            addCriterion("belongDepartment <", value, "belongdepartment");
            return (Criteria) this;
        }

        public Criteria andBelongdepartmentLessThanOrEqualTo(Integer value) {
            addCriterion("belongDepartment <=", value, "belongdepartment");
            return (Criteria) this;
        }

        public Criteria andBelongdepartmentIn(List<Integer> values) {
            addCriterion("belongDepartment in", values, "belongdepartment");
            return (Criteria) this;
        }

        public Criteria andBelongdepartmentNotIn(List<Integer> values) {
            addCriterion("belongDepartment not in", values, "belongdepartment");
            return (Criteria) this;
        }

        public Criteria andBelongdepartmentBetween(Integer value1, Integer value2) {
            addCriterion("belongDepartment between", value1, value2, "belongdepartment");
            return (Criteria) this;
        }

        public Criteria andBelongdepartmentNotBetween(Integer value1, Integer value2) {
            addCriterion("belongDepartment not between", value1, value2, "belongdepartment");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameIsNull() {
            addCriterion("department_DB_Name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameIsNotNull() {
            addCriterion("department_DB_Name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameEqualTo(String value) {
            addCriterion("department_DB_Name =", value, "departmentDbName");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameNotEqualTo(String value) {
            addCriterion("department_DB_Name <>", value, "departmentDbName");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameGreaterThan(String value) {
            addCriterion("department_DB_Name >", value, "departmentDbName");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_DB_Name >=", value, "departmentDbName");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameLessThan(String value) {
            addCriterion("department_DB_Name <", value, "departmentDbName");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameLessThanOrEqualTo(String value) {
            addCriterion("department_DB_Name <=", value, "departmentDbName");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameLike(String value) {
            addCriterion("department_DB_Name like", value, "departmentDbName");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameNotLike(String value) {
            addCriterion("department_DB_Name not like", value, "departmentDbName");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameIn(List<String> values) {
            addCriterion("department_DB_Name in", values, "departmentDbName");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameNotIn(List<String> values) {
            addCriterion("department_DB_Name not in", values, "departmentDbName");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameBetween(String value1, String value2) {
            addCriterion("department_DB_Name between", value1, value2, "departmentDbName");
            return (Criteria) this;
        }

        public Criteria andDepartmentDbNameNotBetween(String value1, String value2) {
            addCriterion("department_DB_Name not between", value1, value2, "departmentDbName");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andIssuccessIsNull() {
            addCriterion("isSuccess is null");
            return (Criteria) this;
        }

        public Criteria andIssuccessIsNotNull() {
            addCriterion("isSuccess is not null");
            return (Criteria) this;
        }

        public Criteria andIssuccessEqualTo(Integer value) {
            addCriterion("isSuccess =", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessNotEqualTo(Integer value) {
            addCriterion("isSuccess <>", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessGreaterThan(Integer value) {
            addCriterion("isSuccess >", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("isSuccess >=", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessLessThan(Integer value) {
            addCriterion("isSuccess <", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessLessThanOrEqualTo(Integer value) {
            addCriterion("isSuccess <=", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessIn(List<Integer> values) {
            addCriterion("isSuccess in", values, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessNotIn(List<Integer> values) {
            addCriterion("isSuccess not in", values, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessBetween(Integer value1, Integer value2) {
            addCriterion("isSuccess between", value1, value2, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessNotBetween(Integer value1, Integer value2) {
            addCriterion("isSuccess not between", value1, value2, "issuccess");
            return (Criteria) this;
        }

        public Criteria andPageaddressIsNull() {
            addCriterion("pageAddress is null");
            return (Criteria) this;
        }

        public Criteria andPageaddressIsNotNull() {
            addCriterion("pageAddress is not null");
            return (Criteria) this;
        }

        public Criteria andPageaddressEqualTo(String value) {
            addCriterion("pageAddress =", value, "pageaddress");
            return (Criteria) this;
        }

        public Criteria andPageaddressNotEqualTo(String value) {
            addCriterion("pageAddress <>", value, "pageaddress");
            return (Criteria) this;
        }

        public Criteria andPageaddressGreaterThan(String value) {
            addCriterion("pageAddress >", value, "pageaddress");
            return (Criteria) this;
        }

        public Criteria andPageaddressGreaterThanOrEqualTo(String value) {
            addCriterion("pageAddress >=", value, "pageaddress");
            return (Criteria) this;
        }

        public Criteria andPageaddressLessThan(String value) {
            addCriterion("pageAddress <", value, "pageaddress");
            return (Criteria) this;
        }

        public Criteria andPageaddressLessThanOrEqualTo(String value) {
            addCriterion("pageAddress <=", value, "pageaddress");
            return (Criteria) this;
        }

        public Criteria andPageaddressLike(String value) {
            addCriterion("pageAddress like", value, "pageaddress");
            return (Criteria) this;
        }

        public Criteria andPageaddressNotLike(String value) {
            addCriterion("pageAddress not like", value, "pageaddress");
            return (Criteria) this;
        }

        public Criteria andPageaddressIn(List<String> values) {
            addCriterion("pageAddress in", values, "pageaddress");
            return (Criteria) this;
        }

        public Criteria andPageaddressNotIn(List<String> values) {
            addCriterion("pageAddress not in", values, "pageaddress");
            return (Criteria) this;
        }

        public Criteria andPageaddressBetween(String value1, String value2) {
            addCriterion("pageAddress between", value1, value2, "pageaddress");
            return (Criteria) this;
        }

        public Criteria andPageaddressNotBetween(String value1, String value2) {
            addCriterion("pageAddress not between", value1, value2, "pageaddress");
            return (Criteria) this;
        }

        public Criteria andIspageIsNull() {
            addCriterion("isPage is null");
            return (Criteria) this;
        }

        public Criteria andIspageIsNotNull() {
            addCriterion("isPage is not null");
            return (Criteria) this;
        }

        public Criteria andIspageEqualTo(Integer value) {
            addCriterion("isPage =", value, "ispage");
            return (Criteria) this;
        }

        public Criteria andIspageNotEqualTo(Integer value) {
            addCriterion("isPage <>", value, "ispage");
            return (Criteria) this;
        }

        public Criteria andIspageGreaterThan(Integer value) {
            addCriterion("isPage >", value, "ispage");
            return (Criteria) this;
        }

        public Criteria andIspageGreaterThanOrEqualTo(Integer value) {
            addCriterion("isPage >=", value, "ispage");
            return (Criteria) this;
        }

        public Criteria andIspageLessThan(Integer value) {
            addCriterion("isPage <", value, "ispage");
            return (Criteria) this;
        }

        public Criteria andIspageLessThanOrEqualTo(Integer value) {
            addCriterion("isPage <=", value, "ispage");
            return (Criteria) this;
        }

        public Criteria andIspageIn(List<Integer> values) {
            addCriterion("isPage in", values, "ispage");
            return (Criteria) this;
        }

        public Criteria andIspageNotIn(List<Integer> values) {
            addCriterion("isPage not in", values, "ispage");
            return (Criteria) this;
        }

        public Criteria andIspageBetween(Integer value1, Integer value2) {
            addCriterion("isPage between", value1, value2, "ispage");
            return (Criteria) this;
        }

        public Criteria andIspageNotBetween(Integer value1, Integer value2) {
            addCriterion("isPage not between", value1, value2, "ispage");
            return (Criteria) this;
        }

        public Criteria andCurrpageIsNull() {
            addCriterion("currPage is null");
            return (Criteria) this;
        }

        public Criteria andCurrpageIsNotNull() {
            addCriterion("currPage is not null");
            return (Criteria) this;
        }

        public Criteria andCurrpageEqualTo(Integer value) {
            addCriterion("currPage =", value, "currpage");
            return (Criteria) this;
        }

        public Criteria andCurrpageNotEqualTo(Integer value) {
            addCriterion("currPage <>", value, "currpage");
            return (Criteria) this;
        }

        public Criteria andCurrpageGreaterThan(Integer value) {
            addCriterion("currPage >", value, "currpage");
            return (Criteria) this;
        }

        public Criteria andCurrpageGreaterThanOrEqualTo(Integer value) {
            addCriterion("currPage >=", value, "currpage");
            return (Criteria) this;
        }

        public Criteria andCurrpageLessThan(Integer value) {
            addCriterion("currPage <", value, "currpage");
            return (Criteria) this;
        }

        public Criteria andCurrpageLessThanOrEqualTo(Integer value) {
            addCriterion("currPage <=", value, "currpage");
            return (Criteria) this;
        }

        public Criteria andCurrpageIn(List<Integer> values) {
            addCriterion("currPage in", values, "currpage");
            return (Criteria) this;
        }

        public Criteria andCurrpageNotIn(List<Integer> values) {
            addCriterion("currPage not in", values, "currpage");
            return (Criteria) this;
        }

        public Criteria andCurrpageBetween(Integer value1, Integer value2) {
            addCriterion("currPage between", value1, value2, "currpage");
            return (Criteria) this;
        }

        public Criteria andCurrpageNotBetween(Integer value1, Integer value2) {
            addCriterion("currPage not between", value1, value2, "currpage");
            return (Criteria) this;
        }

        public Criteria andEndgeccotimeIsNull() {
            addCriterion("endGeccoTime is null");
            return (Criteria) this;
        }

        public Criteria andEndgeccotimeIsNotNull() {
            addCriterion("endGeccoTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndgeccotimeEqualTo(Date value) {
            addCriterion("endGeccoTime =", value, "endgeccotime");
            return (Criteria) this;
        }

        public Criteria andEndgeccotimeNotEqualTo(Date value) {
            addCriterion("endGeccoTime <>", value, "endgeccotime");
            return (Criteria) this;
        }

        public Criteria andEndgeccotimeGreaterThan(Date value) {
            addCriterion("endGeccoTime >", value, "endgeccotime");
            return (Criteria) this;
        }

        public Criteria andEndgeccotimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endGeccoTime >=", value, "endgeccotime");
            return (Criteria) this;
        }

        public Criteria andEndgeccotimeLessThan(Date value) {
            addCriterion("endGeccoTime <", value, "endgeccotime");
            return (Criteria) this;
        }

        public Criteria andEndgeccotimeLessThanOrEqualTo(Date value) {
            addCriterion("endGeccoTime <=", value, "endgeccotime");
            return (Criteria) this;
        }

        public Criteria andEndgeccotimeIn(List<Date> values) {
            addCriterion("endGeccoTime in", values, "endgeccotime");
            return (Criteria) this;
        }

        public Criteria andEndgeccotimeNotIn(List<Date> values) {
            addCriterion("endGeccoTime not in", values, "endgeccotime");
            return (Criteria) this;
        }

        public Criteria andEndgeccotimeBetween(Date value1, Date value2) {
            addCriterion("endGeccoTime between", value1, value2, "endgeccotime");
            return (Criteria) this;
        }

        public Criteria andEndgeccotimeNotBetween(Date value1, Date value2) {
            addCriterion("endGeccoTime not between", value1, value2, "endgeccotime");
            return (Criteria) this;
        }

        public Criteria andNodecodeIsNull() {
            addCriterion("nodeCode is null");
            return (Criteria) this;
        }

        public Criteria andNodecodeIsNotNull() {
            addCriterion("nodeCode is not null");
            return (Criteria) this;
        }

        public Criteria andNodecodeEqualTo(String value) {
            addCriterion("nodeCode =", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotEqualTo(String value) {
            addCriterion("nodeCode <>", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeGreaterThan(String value) {
            addCriterion("nodeCode >", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeGreaterThanOrEqualTo(String value) {
            addCriterion("nodeCode >=", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeLessThan(String value) {
            addCriterion("nodeCode <", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeLessThanOrEqualTo(String value) {
            addCriterion("nodeCode <=", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeLike(String value) {
            addCriterion("nodeCode like", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotLike(String value) {
            addCriterion("nodeCode not like", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeIn(List<String> values) {
            addCriterion("nodeCode in", values, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotIn(List<String> values) {
            addCriterion("nodeCode not in", values, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeBetween(String value1, String value2) {
            addCriterion("nodeCode between", value1, value2, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotBetween(String value1, String value2) {
            addCriterion("nodeCode not between", value1, value2, "nodecode");
            return (Criteria) this;
        }

        public Criteria andUsertaskIsNull() {
            addCriterion("userTask is null");
            return (Criteria) this;
        }

        public Criteria andUsertaskIsNotNull() {
            addCriterion("userTask is not null");
            return (Criteria) this;
        }

        public Criteria andUsertaskEqualTo(String value) {
            addCriterion("userTask =", value, "usertask");
            return (Criteria) this;
        }

        public Criteria andUsertaskNotEqualTo(String value) {
            addCriterion("userTask <>", value, "usertask");
            return (Criteria) this;
        }

        public Criteria andUsertaskGreaterThan(String value) {
            addCriterion("userTask >", value, "usertask");
            return (Criteria) this;
        }

        public Criteria andUsertaskGreaterThanOrEqualTo(String value) {
            addCriterion("userTask >=", value, "usertask");
            return (Criteria) this;
        }

        public Criteria andUsertaskLessThan(String value) {
            addCriterion("userTask <", value, "usertask");
            return (Criteria) this;
        }

        public Criteria andUsertaskLessThanOrEqualTo(String value) {
            addCriterion("userTask <=", value, "usertask");
            return (Criteria) this;
        }

        public Criteria andUsertaskLike(String value) {
            addCriterion("userTask like", value, "usertask");
            return (Criteria) this;
        }

        public Criteria andUsertaskNotLike(String value) {
            addCriterion("userTask not like", value, "usertask");
            return (Criteria) this;
        }

        public Criteria andUsertaskIn(List<String> values) {
            addCriterion("userTask in", values, "usertask");
            return (Criteria) this;
        }

        public Criteria andUsertaskNotIn(List<String> values) {
            addCriterion("userTask not in", values, "usertask");
            return (Criteria) this;
        }

        public Criteria andUsertaskBetween(String value1, String value2) {
            addCriterion("userTask between", value1, value2, "usertask");
            return (Criteria) this;
        }

        public Criteria andUsertaskNotBetween(String value1, String value2) {
            addCriterion("userTask not between", value1, value2, "usertask");
            return (Criteria) this;
        }

        public Criteria andTitlestatusIsNull() {
            addCriterion("titleStatus is null");
            return (Criteria) this;
        }

        public Criteria andTitlestatusIsNotNull() {
            addCriterion("titleStatus is not null");
            return (Criteria) this;
        }

        public Criteria andTitlestatusEqualTo(Integer value) {
            addCriterion("titleStatus =", value, "titlestatus");
            return (Criteria) this;
        }

        public Criteria andTitlestatusNotEqualTo(Integer value) {
            addCriterion("titleStatus <>", value, "titlestatus");
            return (Criteria) this;
        }

        public Criteria andTitlestatusGreaterThan(Integer value) {
            addCriterion("titleStatus >", value, "titlestatus");
            return (Criteria) this;
        }

        public Criteria andTitlestatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("titleStatus >=", value, "titlestatus");
            return (Criteria) this;
        }

        public Criteria andTitlestatusLessThan(Integer value) {
            addCriterion("titleStatus <", value, "titlestatus");
            return (Criteria) this;
        }

        public Criteria andTitlestatusLessThanOrEqualTo(Integer value) {
            addCriterion("titleStatus <=", value, "titlestatus");
            return (Criteria) this;
        }

        public Criteria andTitlestatusIn(List<Integer> values) {
            addCriterion("titleStatus in", values, "titlestatus");
            return (Criteria) this;
        }

        public Criteria andTitlestatusNotIn(List<Integer> values) {
            addCriterion("titleStatus not in", values, "titlestatus");
            return (Criteria) this;
        }

        public Criteria andTitlestatusBetween(Integer value1, Integer value2) {
            addCriterion("titleStatus between", value1, value2, "titlestatus");
            return (Criteria) this;
        }

        public Criteria andTitlestatusNotBetween(Integer value1, Integer value2) {
            addCriterion("titleStatus not between", value1, value2, "titlestatus");
            return (Criteria) this;
        }

        public Criteria andNewsnumstatusIsNull() {
            addCriterion("newsnumStatus is null");
            return (Criteria) this;
        }

        public Criteria andNewsnumstatusIsNotNull() {
            addCriterion("newsnumStatus is not null");
            return (Criteria) this;
        }

        public Criteria andNewsnumstatusEqualTo(Integer value) {
            addCriterion("newsnumStatus =", value, "newsnumstatus");
            return (Criteria) this;
        }

        public Criteria andNewsnumstatusNotEqualTo(Integer value) {
            addCriterion("newsnumStatus <>", value, "newsnumstatus");
            return (Criteria) this;
        }

        public Criteria andNewsnumstatusGreaterThan(Integer value) {
            addCriterion("newsnumStatus >", value, "newsnumstatus");
            return (Criteria) this;
        }

        public Criteria andNewsnumstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("newsnumStatus >=", value, "newsnumstatus");
            return (Criteria) this;
        }

        public Criteria andNewsnumstatusLessThan(Integer value) {
            addCriterion("newsnumStatus <", value, "newsnumstatus");
            return (Criteria) this;
        }

        public Criteria andNewsnumstatusLessThanOrEqualTo(Integer value) {
            addCriterion("newsnumStatus <=", value, "newsnumstatus");
            return (Criteria) this;
        }

        public Criteria andNewsnumstatusIn(List<Integer> values) {
            addCriterion("newsnumStatus in", values, "newsnumstatus");
            return (Criteria) this;
        }

        public Criteria andNewsnumstatusNotIn(List<Integer> values) {
            addCriterion("newsnumStatus not in", values, "newsnumstatus");
            return (Criteria) this;
        }

        public Criteria andNewsnumstatusBetween(Integer value1, Integer value2) {
            addCriterion("newsnumStatus between", value1, value2, "newsnumstatus");
            return (Criteria) this;
        }

        public Criteria andNewsnumstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("newsnumStatus not between", value1, value2, "newsnumstatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}