package com.spider.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TXwInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TXwInformationExample() {
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

        public Criteria andWebsiteidIsNull() {
            addCriterion("websiteid is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteidIsNotNull() {
            addCriterion("websiteid is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteidEqualTo(Integer value) {
            addCriterion("websiteid =", value, "websiteid");
            return (Criteria) this;
        }

        public Criteria andWebsiteidNotEqualTo(Integer value) {
            addCriterion("websiteid <>", value, "websiteid");
            return (Criteria) this;
        }

        public Criteria andWebsiteidGreaterThan(Integer value) {
            addCriterion("websiteid >", value, "websiteid");
            return (Criteria) this;
        }

        public Criteria andWebsiteidGreaterThanOrEqualTo(Integer value) {
            addCriterion("websiteid >=", value, "websiteid");
            return (Criteria) this;
        }

        public Criteria andWebsiteidLessThan(Integer value) {
            addCriterion("websiteid <", value, "websiteid");
            return (Criteria) this;
        }

        public Criteria andWebsiteidLessThanOrEqualTo(Integer value) {
            addCriterion("websiteid <=", value, "websiteid");
            return (Criteria) this;
        }

        public Criteria andWebsiteidIn(List<Integer> values) {
            addCriterion("websiteid in", values, "websiteid");
            return (Criteria) this;
        }

        public Criteria andWebsiteidNotIn(List<Integer> values) {
            addCriterion("websiteid not in", values, "websiteid");
            return (Criteria) this;
        }

        public Criteria andWebsiteidBetween(Integer value1, Integer value2) {
            addCriterion("websiteid between", value1, value2, "websiteid");
            return (Criteria) this;
        }

        public Criteria andWebsiteidNotBetween(Integer value1, Integer value2) {
            addCriterion("websiteid not between", value1, value2, "websiteid");
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

        public Criteria andReleasesourceIsNull() {
            addCriterion("releaseSource is null");
            return (Criteria) this;
        }

        public Criteria andReleasesourceIsNotNull() {
            addCriterion("releaseSource is not null");
            return (Criteria) this;
        }

        public Criteria andReleasesourceEqualTo(String value) {
            addCriterion("releaseSource =", value, "releasesource");
            return (Criteria) this;
        }

        public Criteria andReleasesourceNotEqualTo(String value) {
            addCriterion("releaseSource <>", value, "releasesource");
            return (Criteria) this;
        }

        public Criteria andReleasesourceGreaterThan(String value) {
            addCriterion("releaseSource >", value, "releasesource");
            return (Criteria) this;
        }

        public Criteria andReleasesourceGreaterThanOrEqualTo(String value) {
            addCriterion("releaseSource >=", value, "releasesource");
            return (Criteria) this;
        }

        public Criteria andReleasesourceLessThan(String value) {
            addCriterion("releaseSource <", value, "releasesource");
            return (Criteria) this;
        }

        public Criteria andReleasesourceLessThanOrEqualTo(String value) {
            addCriterion("releaseSource <=", value, "releasesource");
            return (Criteria) this;
        }

        public Criteria andReleasesourceLike(String value) {
            addCriterion("releaseSource like", value, "releasesource");
            return (Criteria) this;
        }

        public Criteria andReleasesourceNotLike(String value) {
            addCriterion("releaseSource not like", value, "releasesource");
            return (Criteria) this;
        }

        public Criteria andReleasesourceIn(List<String> values) {
            addCriterion("releaseSource in", values, "releasesource");
            return (Criteria) this;
        }

        public Criteria andReleasesourceNotIn(List<String> values) {
            addCriterion("releaseSource not in", values, "releasesource");
            return (Criteria) this;
        }

        public Criteria andReleasesourceBetween(String value1, String value2) {
            addCriterion("releaseSource between", value1, value2, "releasesource");
            return (Criteria) this;
        }

        public Criteria andReleasesourceNotBetween(String value1, String value2) {
            addCriterion("releaseSource not between", value1, value2, "releasesource");
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

        public Criteria andPicturenumIsNull() {
            addCriterion("pictureNum is null");
            return (Criteria) this;
        }

        public Criteria andPicturenumIsNotNull() {
            addCriterion("pictureNum is not null");
            return (Criteria) this;
        }

        public Criteria andPicturenumEqualTo(Integer value) {
            addCriterion("pictureNum =", value, "picturenum");
            return (Criteria) this;
        }

        public Criteria andPicturenumNotEqualTo(Integer value) {
            addCriterion("pictureNum <>", value, "picturenum");
            return (Criteria) this;
        }

        public Criteria andPicturenumGreaterThan(Integer value) {
            addCriterion("pictureNum >", value, "picturenum");
            return (Criteria) this;
        }

        public Criteria andPicturenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pictureNum >=", value, "picturenum");
            return (Criteria) this;
        }

        public Criteria andPicturenumLessThan(Integer value) {
            addCriterion("pictureNum <", value, "picturenum");
            return (Criteria) this;
        }

        public Criteria andPicturenumLessThanOrEqualTo(Integer value) {
            addCriterion("pictureNum <=", value, "picturenum");
            return (Criteria) this;
        }

        public Criteria andPicturenumIn(List<Integer> values) {
            addCriterion("pictureNum in", values, "picturenum");
            return (Criteria) this;
        }

        public Criteria andPicturenumNotIn(List<Integer> values) {
            addCriterion("pictureNum not in", values, "picturenum");
            return (Criteria) this;
        }

        public Criteria andPicturenumBetween(Integer value1, Integer value2) {
            addCriterion("pictureNum between", value1, value2, "picturenum");
            return (Criteria) this;
        }

        public Criteria andPicturenumNotBetween(Integer value1, Integer value2) {
            addCriterion("pictureNum not between", value1, value2, "picturenum");
            return (Criteria) this;
        }

        public Criteria andReadstateIsNull() {
            addCriterion("readState is null");
            return (Criteria) this;
        }

        public Criteria andReadstateIsNotNull() {
            addCriterion("readState is not null");
            return (Criteria) this;
        }

        public Criteria andReadstateEqualTo(Integer value) {
            addCriterion("readState =", value, "readstate");
            return (Criteria) this;
        }

        public Criteria andReadstateNotEqualTo(Integer value) {
            addCriterion("readState <>", value, "readstate");
            return (Criteria) this;
        }

        public Criteria andReadstateGreaterThan(Integer value) {
            addCriterion("readState >", value, "readstate");
            return (Criteria) this;
        }

        public Criteria andReadstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("readState >=", value, "readstate");
            return (Criteria) this;
        }

        public Criteria andReadstateLessThan(Integer value) {
            addCriterion("readState <", value, "readstate");
            return (Criteria) this;
        }

        public Criteria andReadstateLessThanOrEqualTo(Integer value) {
            addCriterion("readState <=", value, "readstate");
            return (Criteria) this;
        }

        public Criteria andReadstateIn(List<Integer> values) {
            addCriterion("readState in", values, "readstate");
            return (Criteria) this;
        }

        public Criteria andReadstateNotIn(List<Integer> values) {
            addCriterion("readState not in", values, "readstate");
            return (Criteria) this;
        }

        public Criteria andReadstateBetween(Integer value1, Integer value2) {
            addCriterion("readState between", value1, value2, "readstate");
            return (Criteria) this;
        }

        public Criteria andReadstateNotBetween(Integer value1, Integer value2) {
            addCriterion("readState not between", value1, value2, "readstate");
            return (Criteria) this;
        }

        public Criteria andIncludedstateIsNull() {
            addCriterion("includedState is null");
            return (Criteria) this;
        }

        public Criteria andIncludedstateIsNotNull() {
            addCriterion("includedState is not null");
            return (Criteria) this;
        }

        public Criteria andIncludedstateEqualTo(Integer value) {
            addCriterion("includedState =", value, "includedstate");
            return (Criteria) this;
        }

        public Criteria andIncludedstateNotEqualTo(Integer value) {
            addCriterion("includedState <>", value, "includedstate");
            return (Criteria) this;
        }

        public Criteria andIncludedstateGreaterThan(Integer value) {
            addCriterion("includedState >", value, "includedstate");
            return (Criteria) this;
        }

        public Criteria andIncludedstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("includedState >=", value, "includedstate");
            return (Criteria) this;
        }

        public Criteria andIncludedstateLessThan(Integer value) {
            addCriterion("includedState <", value, "includedstate");
            return (Criteria) this;
        }

        public Criteria andIncludedstateLessThanOrEqualTo(Integer value) {
            addCriterion("includedState <=", value, "includedstate");
            return (Criteria) this;
        }

        public Criteria andIncludedstateIn(List<Integer> values) {
            addCriterion("includedState in", values, "includedstate");
            return (Criteria) this;
        }

        public Criteria andIncludedstateNotIn(List<Integer> values) {
            addCriterion("includedState not in", values, "includedstate");
            return (Criteria) this;
        }

        public Criteria andIncludedstateBetween(Integer value1, Integer value2) {
            addCriterion("includedState between", value1, value2, "includedstate");
            return (Criteria) this;
        }

        public Criteria andIncludedstateNotBetween(Integer value1, Integer value2) {
            addCriterion("includedState not between", value1, value2, "includedstate");
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

        public Criteria andXwcolumnEqualTo(Integer value) {
            addCriterion("xwColumn =", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnNotEqualTo(Integer value) {
            addCriterion("xwColumn <>", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnGreaterThan(Integer value) {
            addCriterion("xwColumn >", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnGreaterThanOrEqualTo(Integer value) {
            addCriterion("xwColumn >=", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnLessThan(Integer value) {
            addCriterion("xwColumn <", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnLessThanOrEqualTo(Integer value) {
            addCriterion("xwColumn <=", value, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnIn(List<Integer> values) {
            addCriterion("xwColumn in", values, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnNotIn(List<Integer> values) {
            addCriterion("xwColumn not in", values, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnBetween(Integer value1, Integer value2) {
            addCriterion("xwColumn between", value1, value2, "xwcolumn");
            return (Criteria) this;
        }

        public Criteria andXwcolumnNotBetween(Integer value1, Integer value2) {
            addCriterion("xwColumn not between", value1, value2, "xwcolumn");
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

        public Criteria andUpdatenameIsNull() {
            addCriterion("updateName is null");
            return (Criteria) this;
        }

        public Criteria andUpdatenameIsNotNull() {
            addCriterion("updateName is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatenameEqualTo(String value) {
            addCriterion("updateName =", value, "updatename");
            return (Criteria) this;
        }

        public Criteria andUpdatenameNotEqualTo(String value) {
            addCriterion("updateName <>", value, "updatename");
            return (Criteria) this;
        }

        public Criteria andUpdatenameGreaterThan(String value) {
            addCriterion("updateName >", value, "updatename");
            return (Criteria) this;
        }

        public Criteria andUpdatenameGreaterThanOrEqualTo(String value) {
            addCriterion("updateName >=", value, "updatename");
            return (Criteria) this;
        }

        public Criteria andUpdatenameLessThan(String value) {
            addCriterion("updateName <", value, "updatename");
            return (Criteria) this;
        }

        public Criteria andUpdatenameLessThanOrEqualTo(String value) {
            addCriterion("updateName <=", value, "updatename");
            return (Criteria) this;
        }

        public Criteria andUpdatenameLike(String value) {
            addCriterion("updateName like", value, "updatename");
            return (Criteria) this;
        }

        public Criteria andUpdatenameNotLike(String value) {
            addCriterion("updateName not like", value, "updatename");
            return (Criteria) this;
        }

        public Criteria andUpdatenameIn(List<String> values) {
            addCriterion("updateName in", values, "updatename");
            return (Criteria) this;
        }

        public Criteria andUpdatenameNotIn(List<String> values) {
            addCriterion("updateName not in", values, "updatename");
            return (Criteria) this;
        }

        public Criteria andUpdatenameBetween(String value1, String value2) {
            addCriterion("updateName between", value1, value2, "updatename");
            return (Criteria) this;
        }

        public Criteria andUpdatenameNotBetween(String value1, String value2) {
            addCriterion("updateName not between", value1, value2, "updatename");
            return (Criteria) this;
        }

        public Criteria andUpdateidIsNull() {
            addCriterion("updateId is null");
            return (Criteria) this;
        }

        public Criteria andUpdateidIsNotNull() {
            addCriterion("updateId is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateidEqualTo(Integer value) {
            addCriterion("updateId =", value, "updateid");
            return (Criteria) this;
        }

        public Criteria andUpdateidNotEqualTo(Integer value) {
            addCriterion("updateId <>", value, "updateid");
            return (Criteria) this;
        }

        public Criteria andUpdateidGreaterThan(Integer value) {
            addCriterion("updateId >", value, "updateid");
            return (Criteria) this;
        }

        public Criteria andUpdateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("updateId >=", value, "updateid");
            return (Criteria) this;
        }

        public Criteria andUpdateidLessThan(Integer value) {
            addCriterion("updateId <", value, "updateid");
            return (Criteria) this;
        }

        public Criteria andUpdateidLessThanOrEqualTo(Integer value) {
            addCriterion("updateId <=", value, "updateid");
            return (Criteria) this;
        }

        public Criteria andUpdateidIn(List<Integer> values) {
            addCriterion("updateId in", values, "updateid");
            return (Criteria) this;
        }

        public Criteria andUpdateidNotIn(List<Integer> values) {
            addCriterion("updateId not in", values, "updateid");
            return (Criteria) this;
        }

        public Criteria andUpdateidBetween(Integer value1, Integer value2) {
            addCriterion("updateId between", value1, value2, "updateid");
            return (Criteria) this;
        }

        public Criteria andUpdateidNotBetween(Integer value1, Integer value2) {
            addCriterion("updateId not between", value1, value2, "updateid");
            return (Criteria) this;
        }

        public Criteria andPicOneIsNull() {
            addCriterion("pic_one is null");
            return (Criteria) this;
        }

        public Criteria andPicOneIsNotNull() {
            addCriterion("pic_one is not null");
            return (Criteria) this;
        }

        public Criteria andPicOneEqualTo(String value) {
            addCriterion("pic_one =", value, "picOne");
            return (Criteria) this;
        }

        public Criteria andPicOneNotEqualTo(String value) {
            addCriterion("pic_one <>", value, "picOne");
            return (Criteria) this;
        }

        public Criteria andPicOneGreaterThan(String value) {
            addCriterion("pic_one >", value, "picOne");
            return (Criteria) this;
        }

        public Criteria andPicOneGreaterThanOrEqualTo(String value) {
            addCriterion("pic_one >=", value, "picOne");
            return (Criteria) this;
        }

        public Criteria andPicOneLessThan(String value) {
            addCriterion("pic_one <", value, "picOne");
            return (Criteria) this;
        }

        public Criteria andPicOneLessThanOrEqualTo(String value) {
            addCriterion("pic_one <=", value, "picOne");
            return (Criteria) this;
        }

        public Criteria andPicOneLike(String value) {
            addCriterion("pic_one like", value, "picOne");
            return (Criteria) this;
        }

        public Criteria andPicOneNotLike(String value) {
            addCriterion("pic_one not like", value, "picOne");
            return (Criteria) this;
        }

        public Criteria andPicOneIn(List<String> values) {
            addCriterion("pic_one in", values, "picOne");
            return (Criteria) this;
        }

        public Criteria andPicOneNotIn(List<String> values) {
            addCriterion("pic_one not in", values, "picOne");
            return (Criteria) this;
        }

        public Criteria andPicOneBetween(String value1, String value2) {
            addCriterion("pic_one between", value1, value2, "picOne");
            return (Criteria) this;
        }

        public Criteria andPicOneNotBetween(String value1, String value2) {
            addCriterion("pic_one not between", value1, value2, "picOne");
            return (Criteria) this;
        }

        public Criteria andPicTwoIsNull() {
            addCriterion("pic_two is null");
            return (Criteria) this;
        }

        public Criteria andPicTwoIsNotNull() {
            addCriterion("pic_two is not null");
            return (Criteria) this;
        }

        public Criteria andPicTwoEqualTo(String value) {
            addCriterion("pic_two =", value, "picTwo");
            return (Criteria) this;
        }

        public Criteria andPicTwoNotEqualTo(String value) {
            addCriterion("pic_two <>", value, "picTwo");
            return (Criteria) this;
        }

        public Criteria andPicTwoGreaterThan(String value) {
            addCriterion("pic_two >", value, "picTwo");
            return (Criteria) this;
        }

        public Criteria andPicTwoGreaterThanOrEqualTo(String value) {
            addCriterion("pic_two >=", value, "picTwo");
            return (Criteria) this;
        }

        public Criteria andPicTwoLessThan(String value) {
            addCriterion("pic_two <", value, "picTwo");
            return (Criteria) this;
        }

        public Criteria andPicTwoLessThanOrEqualTo(String value) {
            addCriterion("pic_two <=", value, "picTwo");
            return (Criteria) this;
        }

        public Criteria andPicTwoLike(String value) {
            addCriterion("pic_two like", value, "picTwo");
            return (Criteria) this;
        }

        public Criteria andPicTwoNotLike(String value) {
            addCriterion("pic_two not like", value, "picTwo");
            return (Criteria) this;
        }

        public Criteria andPicTwoIn(List<String> values) {
            addCriterion("pic_two in", values, "picTwo");
            return (Criteria) this;
        }

        public Criteria andPicTwoNotIn(List<String> values) {
            addCriterion("pic_two not in", values, "picTwo");
            return (Criteria) this;
        }

        public Criteria andPicTwoBetween(String value1, String value2) {
            addCriterion("pic_two between", value1, value2, "picTwo");
            return (Criteria) this;
        }

        public Criteria andPicTwoNotBetween(String value1, String value2) {
            addCriterion("pic_two not between", value1, value2, "picTwo");
            return (Criteria) this;
        }

        public Criteria andPicThreeIsNull() {
            addCriterion("pic_three is null");
            return (Criteria) this;
        }

        public Criteria andPicThreeIsNotNull() {
            addCriterion("pic_three is not null");
            return (Criteria) this;
        }

        public Criteria andPicThreeEqualTo(String value) {
            addCriterion("pic_three =", value, "picThree");
            return (Criteria) this;
        }

        public Criteria andPicThreeNotEqualTo(String value) {
            addCriterion("pic_three <>", value, "picThree");
            return (Criteria) this;
        }

        public Criteria andPicThreeGreaterThan(String value) {
            addCriterion("pic_three >", value, "picThree");
            return (Criteria) this;
        }

        public Criteria andPicThreeGreaterThanOrEqualTo(String value) {
            addCriterion("pic_three >=", value, "picThree");
            return (Criteria) this;
        }

        public Criteria andPicThreeLessThan(String value) {
            addCriterion("pic_three <", value, "picThree");
            return (Criteria) this;
        }

        public Criteria andPicThreeLessThanOrEqualTo(String value) {
            addCriterion("pic_three <=", value, "picThree");
            return (Criteria) this;
        }

        public Criteria andPicThreeLike(String value) {
            addCriterion("pic_three like", value, "picThree");
            return (Criteria) this;
        }

        public Criteria andPicThreeNotLike(String value) {
            addCriterion("pic_three not like", value, "picThree");
            return (Criteria) this;
        }

        public Criteria andPicThreeIn(List<String> values) {
            addCriterion("pic_three in", values, "picThree");
            return (Criteria) this;
        }

        public Criteria andPicThreeNotIn(List<String> values) {
            addCriterion("pic_three not in", values, "picThree");
            return (Criteria) this;
        }

        public Criteria andPicThreeBetween(String value1, String value2) {
            addCriterion("pic_three between", value1, value2, "picThree");
            return (Criteria) this;
        }

        public Criteria andPicThreeNotBetween(String value1, String value2) {
            addCriterion("pic_three not between", value1, value2, "picThree");
            return (Criteria) this;
        }

        public Criteria andPicFourIsNull() {
            addCriterion("pic_four is null");
            return (Criteria) this;
        }

        public Criteria andPicFourIsNotNull() {
            addCriterion("pic_four is not null");
            return (Criteria) this;
        }

        public Criteria andPicFourEqualTo(String value) {
            addCriterion("pic_four =", value, "picFour");
            return (Criteria) this;
        }

        public Criteria andPicFourNotEqualTo(String value) {
            addCriterion("pic_four <>", value, "picFour");
            return (Criteria) this;
        }

        public Criteria andPicFourGreaterThan(String value) {
            addCriterion("pic_four >", value, "picFour");
            return (Criteria) this;
        }

        public Criteria andPicFourGreaterThanOrEqualTo(String value) {
            addCriterion("pic_four >=", value, "picFour");
            return (Criteria) this;
        }

        public Criteria andPicFourLessThan(String value) {
            addCriterion("pic_four <", value, "picFour");
            return (Criteria) this;
        }

        public Criteria andPicFourLessThanOrEqualTo(String value) {
            addCriterion("pic_four <=", value, "picFour");
            return (Criteria) this;
        }

        public Criteria andPicFourLike(String value) {
            addCriterion("pic_four like", value, "picFour");
            return (Criteria) this;
        }

        public Criteria andPicFourNotLike(String value) {
            addCriterion("pic_four not like", value, "picFour");
            return (Criteria) this;
        }

        public Criteria andPicFourIn(List<String> values) {
            addCriterion("pic_four in", values, "picFour");
            return (Criteria) this;
        }

        public Criteria andPicFourNotIn(List<String> values) {
            addCriterion("pic_four not in", values, "picFour");
            return (Criteria) this;
        }

        public Criteria andPicFourBetween(String value1, String value2) {
            addCriterion("pic_four between", value1, value2, "picFour");
            return (Criteria) this;
        }

        public Criteria andPicFourNotBetween(String value1, String value2) {
            addCriterion("pic_four not between", value1, value2, "picFour");
            return (Criteria) this;
        }

        public Criteria andPicFiveIsNull() {
            addCriterion("pic_five is null");
            return (Criteria) this;
        }

        public Criteria andPicFiveIsNotNull() {
            addCriterion("pic_five is not null");
            return (Criteria) this;
        }

        public Criteria andPicFiveEqualTo(String value) {
            addCriterion("pic_five =", value, "picFive");
            return (Criteria) this;
        }

        public Criteria andPicFiveNotEqualTo(String value) {
            addCriterion("pic_five <>", value, "picFive");
            return (Criteria) this;
        }

        public Criteria andPicFiveGreaterThan(String value) {
            addCriterion("pic_five >", value, "picFive");
            return (Criteria) this;
        }

        public Criteria andPicFiveGreaterThanOrEqualTo(String value) {
            addCriterion("pic_five >=", value, "picFive");
            return (Criteria) this;
        }

        public Criteria andPicFiveLessThan(String value) {
            addCriterion("pic_five <", value, "picFive");
            return (Criteria) this;
        }

        public Criteria andPicFiveLessThanOrEqualTo(String value) {
            addCriterion("pic_five <=", value, "picFive");
            return (Criteria) this;
        }

        public Criteria andPicFiveLike(String value) {
            addCriterion("pic_five like", value, "picFive");
            return (Criteria) this;
        }

        public Criteria andPicFiveNotLike(String value) {
            addCriterion("pic_five not like", value, "picFive");
            return (Criteria) this;
        }

        public Criteria andPicFiveIn(List<String> values) {
            addCriterion("pic_five in", values, "picFive");
            return (Criteria) this;
        }

        public Criteria andPicFiveNotIn(List<String> values) {
            addCriterion("pic_five not in", values, "picFive");
            return (Criteria) this;
        }

        public Criteria andPicFiveBetween(String value1, String value2) {
            addCriterion("pic_five between", value1, value2, "picFive");
            return (Criteria) this;
        }

        public Criteria andPicFiveNotBetween(String value1, String value2) {
            addCriterion("pic_five not between", value1, value2, "picFive");
            return (Criteria) this;
        }

        public Criteria andPicOneShowIsNull() {
            addCriterion("pic_one_show is null");
            return (Criteria) this;
        }

        public Criteria andPicOneShowIsNotNull() {
            addCriterion("pic_one_show is not null");
            return (Criteria) this;
        }

        public Criteria andPicOneShowEqualTo(String value) {
            addCriterion("pic_one_show =", value, "picOneShow");
            return (Criteria) this;
        }

        public Criteria andPicOneShowNotEqualTo(String value) {
            addCriterion("pic_one_show <>", value, "picOneShow");
            return (Criteria) this;
        }

        public Criteria andPicOneShowGreaterThan(String value) {
            addCriterion("pic_one_show >", value, "picOneShow");
            return (Criteria) this;
        }

        public Criteria andPicOneShowGreaterThanOrEqualTo(String value) {
            addCriterion("pic_one_show >=", value, "picOneShow");
            return (Criteria) this;
        }

        public Criteria andPicOneShowLessThan(String value) {
            addCriterion("pic_one_show <", value, "picOneShow");
            return (Criteria) this;
        }

        public Criteria andPicOneShowLessThanOrEqualTo(String value) {
            addCriterion("pic_one_show <=", value, "picOneShow");
            return (Criteria) this;
        }

        public Criteria andPicOneShowLike(String value) {
            addCriterion("pic_one_show like", value, "picOneShow");
            return (Criteria) this;
        }

        public Criteria andPicOneShowNotLike(String value) {
            addCriterion("pic_one_show not like", value, "picOneShow");
            return (Criteria) this;
        }

        public Criteria andPicOneShowIn(List<String> values) {
            addCriterion("pic_one_show in", values, "picOneShow");
            return (Criteria) this;
        }

        public Criteria andPicOneShowNotIn(List<String> values) {
            addCriterion("pic_one_show not in", values, "picOneShow");
            return (Criteria) this;
        }

        public Criteria andPicOneShowBetween(String value1, String value2) {
            addCriterion("pic_one_show between", value1, value2, "picOneShow");
            return (Criteria) this;
        }

        public Criteria andPicOneShowNotBetween(String value1, String value2) {
            addCriterion("pic_one_show not between", value1, value2, "picOneShow");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowIsNull() {
            addCriterion("pic_two_show is null");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowIsNotNull() {
            addCriterion("pic_two_show is not null");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowEqualTo(String value) {
            addCriterion("pic_two_show =", value, "picTwoShow");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowNotEqualTo(String value) {
            addCriterion("pic_two_show <>", value, "picTwoShow");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowGreaterThan(String value) {
            addCriterion("pic_two_show >", value, "picTwoShow");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowGreaterThanOrEqualTo(String value) {
            addCriterion("pic_two_show >=", value, "picTwoShow");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowLessThan(String value) {
            addCriterion("pic_two_show <", value, "picTwoShow");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowLessThanOrEqualTo(String value) {
            addCriterion("pic_two_show <=", value, "picTwoShow");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowLike(String value) {
            addCriterion("pic_two_show like", value, "picTwoShow");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowNotLike(String value) {
            addCriterion("pic_two_show not like", value, "picTwoShow");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowIn(List<String> values) {
            addCriterion("pic_two_show in", values, "picTwoShow");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowNotIn(List<String> values) {
            addCriterion("pic_two_show not in", values, "picTwoShow");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowBetween(String value1, String value2) {
            addCriterion("pic_two_show between", value1, value2, "picTwoShow");
            return (Criteria) this;
        }

        public Criteria andPicTwoShowNotBetween(String value1, String value2) {
            addCriterion("pic_two_show not between", value1, value2, "picTwoShow");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowIsNull() {
            addCriterion("pic_three_show is null");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowIsNotNull() {
            addCriterion("pic_three_show is not null");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowEqualTo(String value) {
            addCriterion("pic_three_show =", value, "picThreeShow");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowNotEqualTo(String value) {
            addCriterion("pic_three_show <>", value, "picThreeShow");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowGreaterThan(String value) {
            addCriterion("pic_three_show >", value, "picThreeShow");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowGreaterThanOrEqualTo(String value) {
            addCriterion("pic_three_show >=", value, "picThreeShow");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowLessThan(String value) {
            addCriterion("pic_three_show <", value, "picThreeShow");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowLessThanOrEqualTo(String value) {
            addCriterion("pic_three_show <=", value, "picThreeShow");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowLike(String value) {
            addCriterion("pic_three_show like", value, "picThreeShow");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowNotLike(String value) {
            addCriterion("pic_three_show not like", value, "picThreeShow");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowIn(List<String> values) {
            addCriterion("pic_three_show in", values, "picThreeShow");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowNotIn(List<String> values) {
            addCriterion("pic_three_show not in", values, "picThreeShow");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowBetween(String value1, String value2) {
            addCriterion("pic_three_show between", value1, value2, "picThreeShow");
            return (Criteria) this;
        }

        public Criteria andPicThreeShowNotBetween(String value1, String value2) {
            addCriterion("pic_three_show not between", value1, value2, "picThreeShow");
            return (Criteria) this;
        }

        public Criteria andPicFourShowIsNull() {
            addCriterion("pic_four_show is null");
            return (Criteria) this;
        }

        public Criteria andPicFourShowIsNotNull() {
            addCriterion("pic_four_show is not null");
            return (Criteria) this;
        }

        public Criteria andPicFourShowEqualTo(String value) {
            addCriterion("pic_four_show =", value, "picFourShow");
            return (Criteria) this;
        }

        public Criteria andPicFourShowNotEqualTo(String value) {
            addCriterion("pic_four_show <>", value, "picFourShow");
            return (Criteria) this;
        }

        public Criteria andPicFourShowGreaterThan(String value) {
            addCriterion("pic_four_show >", value, "picFourShow");
            return (Criteria) this;
        }

        public Criteria andPicFourShowGreaterThanOrEqualTo(String value) {
            addCriterion("pic_four_show >=", value, "picFourShow");
            return (Criteria) this;
        }

        public Criteria andPicFourShowLessThan(String value) {
            addCriterion("pic_four_show <", value, "picFourShow");
            return (Criteria) this;
        }

        public Criteria andPicFourShowLessThanOrEqualTo(String value) {
            addCriterion("pic_four_show <=", value, "picFourShow");
            return (Criteria) this;
        }

        public Criteria andPicFourShowLike(String value) {
            addCriterion("pic_four_show like", value, "picFourShow");
            return (Criteria) this;
        }

        public Criteria andPicFourShowNotLike(String value) {
            addCriterion("pic_four_show not like", value, "picFourShow");
            return (Criteria) this;
        }

        public Criteria andPicFourShowIn(List<String> values) {
            addCriterion("pic_four_show in", values, "picFourShow");
            return (Criteria) this;
        }

        public Criteria andPicFourShowNotIn(List<String> values) {
            addCriterion("pic_four_show not in", values, "picFourShow");
            return (Criteria) this;
        }

        public Criteria andPicFourShowBetween(String value1, String value2) {
            addCriterion("pic_four_show between", value1, value2, "picFourShow");
            return (Criteria) this;
        }

        public Criteria andPicFourShowNotBetween(String value1, String value2) {
            addCriterion("pic_four_show not between", value1, value2, "picFourShow");
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

        public Criteria andPicSignIsNull() {
            addCriterion("pic_sign is null");
            return (Criteria) this;
        }

        public Criteria andPicSignIsNotNull() {
            addCriterion("pic_sign is not null");
            return (Criteria) this;
        }

        public Criteria andPicSignEqualTo(String value) {
            addCriterion("pic_sign =", value, "picSign");
            return (Criteria) this;
        }

        public Criteria andPicSignNotEqualTo(String value) {
            addCriterion("pic_sign <>", value, "picSign");
            return (Criteria) this;
        }

        public Criteria andPicSignGreaterThan(String value) {
            addCriterion("pic_sign >", value, "picSign");
            return (Criteria) this;
        }

        public Criteria andPicSignGreaterThanOrEqualTo(String value) {
            addCriterion("pic_sign >=", value, "picSign");
            return (Criteria) this;
        }

        public Criteria andPicSignLessThan(String value) {
            addCriterion("pic_sign <", value, "picSign");
            return (Criteria) this;
        }

        public Criteria andPicSignLessThanOrEqualTo(String value) {
            addCriterion("pic_sign <=", value, "picSign");
            return (Criteria) this;
        }

        public Criteria andPicSignLike(String value) {
            addCriterion("pic_sign like", value, "picSign");
            return (Criteria) this;
        }

        public Criteria andPicSignNotLike(String value) {
            addCriterion("pic_sign not like", value, "picSign");
            return (Criteria) this;
        }

        public Criteria andPicSignIn(List<String> values) {
            addCriterion("pic_sign in", values, "picSign");
            return (Criteria) this;
        }

        public Criteria andPicSignNotIn(List<String> values) {
            addCriterion("pic_sign not in", values, "picSign");
            return (Criteria) this;
        }

        public Criteria andPicSignBetween(String value1, String value2) {
            addCriterion("pic_sign between", value1, value2, "picSign");
            return (Criteria) this;
        }

        public Criteria andPicSignNotBetween(String value1, String value2) {
            addCriterion("pic_sign not between", value1, value2, "picSign");
            return (Criteria) this;
        }

        public Criteria andPicsIsNull() {
            addCriterion("pics is null");
            return (Criteria) this;
        }

        public Criteria andPicsIsNotNull() {
            addCriterion("pics is not null");
            return (Criteria) this;
        }

        public Criteria andPicsEqualTo(String value) {
            addCriterion("pics =", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotEqualTo(String value) {
            addCriterion("pics <>", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsGreaterThan(String value) {
            addCriterion("pics >", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsGreaterThanOrEqualTo(String value) {
            addCriterion("pics >=", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLessThan(String value) {
            addCriterion("pics <", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLessThanOrEqualTo(String value) {
            addCriterion("pics <=", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLike(String value) {
            addCriterion("pics like", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotLike(String value) {
            addCriterion("pics not like", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsIn(List<String> values) {
            addCriterion("pics in", values, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotIn(List<String> values) {
            addCriterion("pics not in", values, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsBetween(String value1, String value2) {
            addCriterion("pics between", value1, value2, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotBetween(String value1, String value2) {
            addCriterion("pics not between", value1, value2, "pics");
            return (Criteria) this;
        }

        public Criteria andGscolumnIsNull() {
            addCriterion("gsColumn is null");
            return (Criteria) this;
        }

        public Criteria andGscolumnIsNotNull() {
            addCriterion("gsColumn is not null");
            return (Criteria) this;
        }

        public Criteria andGscolumnEqualTo(Integer value) {
            addCriterion("gsColumn =", value, "gscolumn");
            return (Criteria) this;
        }

        public Criteria andGscolumnNotEqualTo(Integer value) {
            addCriterion("gsColumn <>", value, "gscolumn");
            return (Criteria) this;
        }

        public Criteria andGscolumnGreaterThan(Integer value) {
            addCriterion("gsColumn >", value, "gscolumn");
            return (Criteria) this;
        }

        public Criteria andGscolumnGreaterThanOrEqualTo(Integer value) {
            addCriterion("gsColumn >=", value, "gscolumn");
            return (Criteria) this;
        }

        public Criteria andGscolumnLessThan(Integer value) {
            addCriterion("gsColumn <", value, "gscolumn");
            return (Criteria) this;
        }

        public Criteria andGscolumnLessThanOrEqualTo(Integer value) {
            addCriterion("gsColumn <=", value, "gscolumn");
            return (Criteria) this;
        }

        public Criteria andGscolumnIn(List<Integer> values) {
            addCriterion("gsColumn in", values, "gscolumn");
            return (Criteria) this;
        }

        public Criteria andGscolumnNotIn(List<Integer> values) {
            addCriterion("gsColumn not in", values, "gscolumn");
            return (Criteria) this;
        }

        public Criteria andGscolumnBetween(Integer value1, Integer value2) {
            addCriterion("gsColumn between", value1, value2, "gscolumn");
            return (Criteria) this;
        }

        public Criteria andGscolumnNotBetween(Integer value1, Integer value2) {
            addCriterion("gsColumn not between", value1, value2, "gscolumn");
            return (Criteria) this;
        }

        public Criteria andTitleidIsNull() {
            addCriterion("titleId is null");
            return (Criteria) this;
        }

        public Criteria andTitleidIsNotNull() {
            addCriterion("titleId is not null");
            return (Criteria) this;
        }

        public Criteria andTitleidEqualTo(Integer value) {
            addCriterion("titleId =", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidNotEqualTo(Integer value) {
            addCriterion("titleId <>", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidGreaterThan(Integer value) {
            addCriterion("titleId >", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("titleId >=", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidLessThan(Integer value) {
            addCriterion("titleId <", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidLessThanOrEqualTo(Integer value) {
            addCriterion("titleId <=", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidIn(List<Integer> values) {
            addCriterion("titleId in", values, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidNotIn(List<Integer> values) {
            addCriterion("titleId not in", values, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidBetween(Integer value1, Integer value2) {
            addCriterion("titleId between", value1, value2, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidNotBetween(Integer value1, Integer value2) {
            addCriterion("titleId not between", value1, value2, "titleid");
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