package com.spider.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformationPipelineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InformationPipelineExample() {
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

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andNewstitleIsNull() {
            addCriterion("newsTitle is null");
            return (Criteria) this;
        }

        public Criteria andNewstitleIsNotNull() {
            addCriterion("newsTitle is not null");
            return (Criteria) this;
        }

        public Criteria andNewstitleEqualTo(String value) {
            addCriterion("newsTitle =", value, "newstitle");
            return (Criteria) this;
        }

        public Criteria andNewstitleNotEqualTo(String value) {
            addCriterion("newsTitle <>", value, "newstitle");
            return (Criteria) this;
        }

        public Criteria andNewstitleGreaterThan(String value) {
            addCriterion("newsTitle >", value, "newstitle");
            return (Criteria) this;
        }

        public Criteria andNewstitleGreaterThanOrEqualTo(String value) {
            addCriterion("newsTitle >=", value, "newstitle");
            return (Criteria) this;
        }

        public Criteria andNewstitleLessThan(String value) {
            addCriterion("newsTitle <", value, "newstitle");
            return (Criteria) this;
        }

        public Criteria andNewstitleLessThanOrEqualTo(String value) {
            addCriterion("newsTitle <=", value, "newstitle");
            return (Criteria) this;
        }

        public Criteria andNewstitleLike(String value) {
            addCriterion("newsTitle like", value, "newstitle");
            return (Criteria) this;
        }

        public Criteria andNewstitleNotLike(String value) {
            addCriterion("newsTitle not like", value, "newstitle");
            return (Criteria) this;
        }

        public Criteria andNewstitleIn(List<String> values) {
            addCriterion("newsTitle in", values, "newstitle");
            return (Criteria) this;
        }

        public Criteria andNewstitleNotIn(List<String> values) {
            addCriterion("newsTitle not in", values, "newstitle");
            return (Criteria) this;
        }

        public Criteria andNewstitleBetween(String value1, String value2) {
            addCriterion("newsTitle between", value1, value2, "newstitle");
            return (Criteria) this;
        }

        public Criteria andNewstitleNotBetween(String value1, String value2) {
            addCriterion("newsTitle not between", value1, value2, "newstitle");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNull() {
            addCriterion("releaseTime is null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNotNull() {
            addCriterion("releaseTime is not null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeEqualTo(String value) {
            addCriterion("releaseTime =", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotEqualTo(String value) {
            addCriterion("releaseTime <>", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThan(String value) {
            addCriterion("releaseTime >", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThanOrEqualTo(String value) {
            addCriterion("releaseTime >=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThan(String value) {
            addCriterion("releaseTime <", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThanOrEqualTo(String value) {
            addCriterion("releaseTime <=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLike(String value) {
            addCriterion("releaseTime like", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotLike(String value) {
            addCriterion("releaseTime not like", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIn(List<String> values) {
            addCriterion("releaseTime in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotIn(List<String> values) {
            addCriterion("releaseTime not in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeBetween(String value1, String value2) {
            addCriterion("releaseTime between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotBetween(String value1, String value2) {
            addCriterion("releaseTime not between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andImptimeIsNull() {
            addCriterion("impTime is null");
            return (Criteria) this;
        }

        public Criteria andImptimeIsNotNull() {
            addCriterion("impTime is not null");
            return (Criteria) this;
        }

        public Criteria andImptimeEqualTo(String value) {
            addCriterion("impTime =", value, "imptime");
            return (Criteria) this;
        }

        public Criteria andImptimeNotEqualTo(String value) {
            addCriterion("impTime <>", value, "imptime");
            return (Criteria) this;
        }

        public Criteria andImptimeGreaterThan(String value) {
            addCriterion("impTime >", value, "imptime");
            return (Criteria) this;
        }

        public Criteria andImptimeGreaterThanOrEqualTo(String value) {
            addCriterion("impTime >=", value, "imptime");
            return (Criteria) this;
        }

        public Criteria andImptimeLessThan(String value) {
            addCriterion("impTime <", value, "imptime");
            return (Criteria) this;
        }

        public Criteria andImptimeLessThanOrEqualTo(String value) {
            addCriterion("impTime <=", value, "imptime");
            return (Criteria) this;
        }

        public Criteria andImptimeLike(String value) {
            addCriterion("impTime like", value, "imptime");
            return (Criteria) this;
        }

        public Criteria andImptimeNotLike(String value) {
            addCriterion("impTime not like", value, "imptime");
            return (Criteria) this;
        }

        public Criteria andImptimeIn(List<String> values) {
            addCriterion("impTime in", values, "imptime");
            return (Criteria) this;
        }

        public Criteria andImptimeNotIn(List<String> values) {
            addCriterion("impTime not in", values, "imptime");
            return (Criteria) this;
        }

        public Criteria andImptimeBetween(String value1, String value2) {
            addCriterion("impTime between", value1, value2, "imptime");
            return (Criteria) this;
        }

        public Criteria andImptimeNotBetween(String value1, String value2) {
            addCriterion("impTime not between", value1, value2, "imptime");
            return (Criteria) this;
        }

        public Criteria andFilenumIsNull() {
            addCriterion("filenum is null");
            return (Criteria) this;
        }

        public Criteria andFilenumIsNotNull() {
            addCriterion("filenum is not null");
            return (Criteria) this;
        }

        public Criteria andFilenumEqualTo(String value) {
            addCriterion("filenum =", value, "filenum");
            return (Criteria) this;
        }

        public Criteria andFilenumNotEqualTo(String value) {
            addCriterion("filenum <>", value, "filenum");
            return (Criteria) this;
        }

        public Criteria andFilenumGreaterThan(String value) {
            addCriterion("filenum >", value, "filenum");
            return (Criteria) this;
        }

        public Criteria andFilenumGreaterThanOrEqualTo(String value) {
            addCriterion("filenum >=", value, "filenum");
            return (Criteria) this;
        }

        public Criteria andFilenumLessThan(String value) {
            addCriterion("filenum <", value, "filenum");
            return (Criteria) this;
        }

        public Criteria andFilenumLessThanOrEqualTo(String value) {
            addCriterion("filenum <=", value, "filenum");
            return (Criteria) this;
        }

        public Criteria andFilenumLike(String value) {
            addCriterion("filenum like", value, "filenum");
            return (Criteria) this;
        }

        public Criteria andFilenumNotLike(String value) {
            addCriterion("filenum not like", value, "filenum");
            return (Criteria) this;
        }

        public Criteria andFilenumIn(List<String> values) {
            addCriterion("filenum in", values, "filenum");
            return (Criteria) this;
        }

        public Criteria andFilenumNotIn(List<String> values) {
            addCriterion("filenum not in", values, "filenum");
            return (Criteria) this;
        }

        public Criteria andFilenumBetween(String value1, String value2) {
            addCriterion("filenum between", value1, value2, "filenum");
            return (Criteria) this;
        }

        public Criteria andFilenumNotBetween(String value1, String value2) {
            addCriterion("filenum not between", value1, value2, "filenum");
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

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createTime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createTime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
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

        public Criteria andInformationIdIsNull() {
            addCriterion("information_id is null");
            return (Criteria) this;
        }

        public Criteria andInformationIdIsNotNull() {
            addCriterion("information_id is not null");
            return (Criteria) this;
        }

        public Criteria andInformationIdEqualTo(Integer value) {
            addCriterion("information_id =", value, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdNotEqualTo(Integer value) {
            addCriterion("information_id <>", value, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdGreaterThan(Integer value) {
            addCriterion("information_id >", value, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("information_id >=", value, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdLessThan(Integer value) {
            addCriterion("information_id <", value, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdLessThanOrEqualTo(Integer value) {
            addCriterion("information_id <=", value, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdIn(List<Integer> values) {
            addCriterion("information_id in", values, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdNotIn(List<Integer> values) {
            addCriterion("information_id not in", values, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdBetween(Integer value1, Integer value2) {
            addCriterion("information_id between", value1, value2, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("information_id not between", value1, value2, "informationId");
            return (Criteria) this;
        }

        public Criteria andDeptcodeIsNull() {
            addCriterion("deptcode is null");
            return (Criteria) this;
        }

        public Criteria andDeptcodeIsNotNull() {
            addCriterion("deptcode is not null");
            return (Criteria) this;
        }

        public Criteria andDeptcodeEqualTo(String value) {
            addCriterion("deptcode =", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeNotEqualTo(String value) {
            addCriterion("deptcode <>", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeGreaterThan(String value) {
            addCriterion("deptcode >", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeGreaterThanOrEqualTo(String value) {
            addCriterion("deptcode >=", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeLessThan(String value) {
            addCriterion("deptcode <", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeLessThanOrEqualTo(String value) {
            addCriterion("deptcode <=", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeLike(String value) {
            addCriterion("deptcode like", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeNotLike(String value) {
            addCriterion("deptcode not like", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeIn(List<String> values) {
            addCriterion("deptcode in", values, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeNotIn(List<String> values) {
            addCriterion("deptcode not in", values, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeBetween(String value1, String value2) {
            addCriterion("deptcode between", value1, value2, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeNotBetween(String value1, String value2) {
            addCriterion("deptcode not between", value1, value2, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNull() {
            addCriterion("deptname is null");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNotNull() {
            addCriterion("deptname is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnameEqualTo(String value) {
            addCriterion("deptname =", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotEqualTo(String value) {
            addCriterion("deptname <>", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThan(String value) {
            addCriterion("deptname >", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("deptname >=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThan(String value) {
            addCriterion("deptname <", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThanOrEqualTo(String value) {
            addCriterion("deptname <=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLike(String value) {
            addCriterion("deptname like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotLike(String value) {
            addCriterion("deptname not like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameIn(List<String> values) {
            addCriterion("deptname in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotIn(List<String> values) {
            addCriterion("deptname not in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameBetween(String value1, String value2) {
            addCriterion("deptname between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotBetween(String value1, String value2) {
            addCriterion("deptname not between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andPreDistinctIsNull() {
            addCriterion("pre_distinct is null");
            return (Criteria) this;
        }

        public Criteria andPreDistinctIsNotNull() {
            addCriterion("pre_distinct is not null");
            return (Criteria) this;
        }

        public Criteria andPreDistinctEqualTo(Integer value) {
            addCriterion("pre_distinct =", value, "preDistinct");
            return (Criteria) this;
        }

        public Criteria andPreDistinctNotEqualTo(Integer value) {
            addCriterion("pre_distinct <>", value, "preDistinct");
            return (Criteria) this;
        }

        public Criteria andPreDistinctGreaterThan(Integer value) {
            addCriterion("pre_distinct >", value, "preDistinct");
            return (Criteria) this;
        }

        public Criteria andPreDistinctGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_distinct >=", value, "preDistinct");
            return (Criteria) this;
        }

        public Criteria andPreDistinctLessThan(Integer value) {
            addCriterion("pre_distinct <", value, "preDistinct");
            return (Criteria) this;
        }

        public Criteria andPreDistinctLessThanOrEqualTo(Integer value) {
            addCriterion("pre_distinct <=", value, "preDistinct");
            return (Criteria) this;
        }

        public Criteria andPreDistinctIn(List<Integer> values) {
            addCriterion("pre_distinct in", values, "preDistinct");
            return (Criteria) this;
        }

        public Criteria andPreDistinctNotIn(List<Integer> values) {
            addCriterion("pre_distinct not in", values, "preDistinct");
            return (Criteria) this;
        }

        public Criteria andPreDistinctBetween(Integer value1, Integer value2) {
            addCriterion("pre_distinct between", value1, value2, "preDistinct");
            return (Criteria) this;
        }

        public Criteria andPreDistinctNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_distinct not between", value1, value2, "preDistinct");
            return (Criteria) this;
        }

        public Criteria andXwcolumnIsNull() {
            addCriterion("xwColumn is null");
            return (Criteria) this;
        }

        public Criteria andXwcolumnIsNotNull() {
            addCriterion("xwColumn is not null");
            return (Criteria) this;
        }

        public Criteria andXwcolumnEqualTo(String value) {
            addCriterion("xwColumn =", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnNotEqualTo(String value) {
            addCriterion("xwColumn <>", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnGreaterThan(String value) {
            addCriterion("xwColumn >", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnGreaterThanOrEqualTo(String value) {
            addCriterion("xwColumn >=", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnLessThan(String value) {
            addCriterion("xwColumn <", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnLessThanOrEqualTo(String value) {
            addCriterion("xwColumn <=", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnLike(String value) {
            addCriterion("xwColumn like", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnNotLike(String value) {
            addCriterion("xwColumn not like", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnIn(List<String> values) {
            addCriterion("xwColumn in", values, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnNotIn(List<String> values) {
            addCriterion("xwColumn not in", values, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnBetween(String value1, String value2) {
            addCriterion("xwColumn between", value1, value2, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnNotBetween(String value1, String value2) {
            addCriterion("xwColumn not between", value1, value2, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceIsNull() {
            addCriterion("websitesource is null");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceIsNotNull() {
            addCriterion("websitesource is not null");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceEqualTo(String value) {
            addCriterion("websitesource =", value, "websitesource");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceNotEqualTo(String value) {
            addCriterion("websitesource <>", value, "websitesource");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceGreaterThan(String value) {
            addCriterion("websitesource >", value, "websitesource");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceGreaterThanOrEqualTo(String value) {
            addCriterion("websitesource >=", value, "websitesource");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceLessThan(String value) {
            addCriterion("websitesource <", value, "websitesource");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceLessThanOrEqualTo(String value) {
            addCriterion("websitesource <=", value, "websitesource");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceLike(String value) {
            addCriterion("websitesource like", value, "websitesource");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceNotLike(String value) {
            addCriterion("websitesource not like", value, "websitesource");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceIn(List<String> values) {
            addCriterion("websitesource in", values, "websitesource");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceNotIn(List<String> values) {
            addCriterion("websitesource not in", values, "websitesource");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceBetween(String value1, String value2) {
            addCriterion("websitesource between", value1, value2, "websitesource");
            return (Criteria) this;
        }

        public Criteria andWebsitesourceNotBetween(String value1, String value2) {
            addCriterion("websitesource not between", value1, value2, "websitesource");
            return (Criteria) this;
        }

        public Criteria andErrorStatusIsNull() {
            addCriterion("error_status is null");
            return (Criteria) this;
        }

        public Criteria andErrorStatusIsNotNull() {
            addCriterion("error_status is not null");
            return (Criteria) this;
        }

        public Criteria andErrorStatusEqualTo(Integer value) {
            addCriterion("error_status =", value, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusNotEqualTo(Integer value) {
            addCriterion("error_status <>", value, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusGreaterThan(Integer value) {
            addCriterion("error_status >", value, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("error_status >=", value, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusLessThan(Integer value) {
            addCriterion("error_status <", value, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusLessThanOrEqualTo(Integer value) {
            addCriterion("error_status <=", value, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusIn(List<Integer> values) {
            addCriterion("error_status in", values, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusNotIn(List<Integer> values) {
            addCriterion("error_status not in", values, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusBetween(Integer value1, Integer value2) {
            addCriterion("error_status between", value1, value2, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("error_status not between", value1, value2, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andFjcountIsNull() {
            addCriterion("fjcount is null");
            return (Criteria) this;
        }

        public Criteria andFjcountIsNotNull() {
            addCriterion("fjcount is not null");
            return (Criteria) this;
        }

        public Criteria andFjcountEqualTo(Integer value) {
            addCriterion("fjcount =", value, "fjcount");
            return (Criteria) this;
        }

        public Criteria andFjcountNotEqualTo(Integer value) {
            addCriterion("fjcount <>", value, "fjcount");
            return (Criteria) this;
        }

        public Criteria andFjcountGreaterThan(Integer value) {
            addCriterion("fjcount >", value, "fjcount");
            return (Criteria) this;
        }

        public Criteria andFjcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fjcount >=", value, "fjcount");
            return (Criteria) this;
        }

        public Criteria andFjcountLessThan(Integer value) {
            addCriterion("fjcount <", value, "fjcount");
            return (Criteria) this;
        }

        public Criteria andFjcountLessThanOrEqualTo(Integer value) {
            addCriterion("fjcount <=", value, "fjcount");
            return (Criteria) this;
        }

        public Criteria andFjcountIn(List<Integer> values) {
            addCriterion("fjcount in", values, "fjcount");
            return (Criteria) this;
        }

        public Criteria andFjcountNotIn(List<Integer> values) {
            addCriterion("fjcount not in", values, "fjcount");
            return (Criteria) this;
        }

        public Criteria andFjcountBetween(Integer value1, Integer value2) {
            addCriterion("fjcount between", value1, value2, "fjcount");
            return (Criteria) this;
        }

        public Criteria andFjcountNotBetween(Integer value1, Integer value2) {
            addCriterion("fjcount not between", value1, value2, "fjcount");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeIsNull() {
            addCriterion("personincharge is null");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeIsNotNull() {
            addCriterion("personincharge is not null");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeEqualTo(String value) {
            addCriterion("personincharge =", value, "personincharge");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeNotEqualTo(String value) {
            addCriterion("personincharge <>", value, "personincharge");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeGreaterThan(String value) {
            addCriterion("personincharge >", value, "personincharge");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeGreaterThanOrEqualTo(String value) {
            addCriterion("personincharge >=", value, "personincharge");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeLessThan(String value) {
            addCriterion("personincharge <", value, "personincharge");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeLessThanOrEqualTo(String value) {
            addCriterion("personincharge <=", value, "personincharge");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeLike(String value) {
            addCriterion("personincharge like", value, "personincharge");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeNotLike(String value) {
            addCriterion("personincharge not like", value, "personincharge");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeIn(List<String> values) {
            addCriterion("personincharge in", values, "personincharge");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeNotIn(List<String> values) {
            addCriterion("personincharge not in", values, "personincharge");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeBetween(String value1, String value2) {
            addCriterion("personincharge between", value1, value2, "personincharge");
            return (Criteria) this;
        }

        public Criteria andPersoninchargeNotBetween(String value1, String value2) {
            addCriterion("personincharge not between", value1, value2, "personincharge");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyword not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyword not between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andRjs1IsNull() {
            addCriterion("rjs1 is null");
            return (Criteria) this;
        }

        public Criteria andRjs1IsNotNull() {
            addCriterion("rjs1 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs1EqualTo(String value) {
            addCriterion("rjs1 =", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1NotEqualTo(String value) {
            addCriterion("rjs1 <>", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1GreaterThan(String value) {
            addCriterion("rjs1 >", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1GreaterThanOrEqualTo(String value) {
            addCriterion("rjs1 >=", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1LessThan(String value) {
            addCriterion("rjs1 <", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1LessThanOrEqualTo(String value) {
            addCriterion("rjs1 <=", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1Like(String value) {
            addCriterion("rjs1 like", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1NotLike(String value) {
            addCriterion("rjs1 not like", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1In(List<String> values) {
            addCriterion("rjs1 in", values, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1NotIn(List<String> values) {
            addCriterion("rjs1 not in", values, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1Between(String value1, String value2) {
            addCriterion("rjs1 between", value1, value2, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1NotBetween(String value1, String value2) {
            addCriterion("rjs1 not between", value1, value2, "rjs1");
            return (Criteria) this;
        }

        public Criteria andExtend1IsNull() {
            addCriterion("extend1 is null");
            return (Criteria) this;
        }

        public Criteria andExtend1IsNotNull() {
            addCriterion("extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend1EqualTo(String value) {
            addCriterion("extend1 =", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotEqualTo(String value) {
            addCriterion("extend1 <>", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1GreaterThan(String value) {
            addCriterion("extend1 >", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("extend1 >=", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1LessThan(String value) {
            addCriterion("extend1 <", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1LessThanOrEqualTo(String value) {
            addCriterion("extend1 <=", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1Like(String value) {
            addCriterion("extend1 like", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotLike(String value) {
            addCriterion("extend1 not like", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1In(List<String> values) {
            addCriterion("extend1 in", values, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotIn(List<String> values) {
            addCriterion("extend1 not in", values, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1Between(String value1, String value2) {
            addCriterion("extend1 between", value1, value2, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotBetween(String value1, String value2) {
            addCriterion("extend1 not between", value1, value2, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend2IsNull() {
            addCriterion("extend2 is null");
            return (Criteria) this;
        }

        public Criteria andExtend2IsNotNull() {
            addCriterion("extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend2EqualTo(String value) {
            addCriterion("extend2 =", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotEqualTo(String value) {
            addCriterion("extend2 <>", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2GreaterThan(String value) {
            addCriterion("extend2 >", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("extend2 >=", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2LessThan(String value) {
            addCriterion("extend2 <", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2LessThanOrEqualTo(String value) {
            addCriterion("extend2 <=", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2Like(String value) {
            addCriterion("extend2 like", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotLike(String value) {
            addCriterion("extend2 not like", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2In(List<String> values) {
            addCriterion("extend2 in", values, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotIn(List<String> values) {
            addCriterion("extend2 not in", values, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2Between(String value1, String value2) {
            addCriterion("extend2 between", value1, value2, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotBetween(String value1, String value2) {
            addCriterion("extend2 not between", value1, value2, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend3IsNull() {
            addCriterion("extend3 is null");
            return (Criteria) this;
        }

        public Criteria andExtend3IsNotNull() {
            addCriterion("extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend3EqualTo(String value) {
            addCriterion("extend3 =", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotEqualTo(String value) {
            addCriterion("extend3 <>", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3GreaterThan(String value) {
            addCriterion("extend3 >", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("extend3 >=", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3LessThan(String value) {
            addCriterion("extend3 <", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3LessThanOrEqualTo(String value) {
            addCriterion("extend3 <=", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3Like(String value) {
            addCriterion("extend3 like", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotLike(String value) {
            addCriterion("extend3 not like", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3In(List<String> values) {
            addCriterion("extend3 in", values, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotIn(List<String> values) {
            addCriterion("extend3 not in", values, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3Between(String value1, String value2) {
            addCriterion("extend3 between", value1, value2, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotBetween(String value1, String value2) {
            addCriterion("extend3 not between", value1, value2, "extend3");
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