package com.spider.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblErrorLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblErrorLogExample() {
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

        public Criteria andErrorcodeIsNull() {
            addCriterion("errorCode is null");
            return (Criteria) this;
        }

        public Criteria andErrorcodeIsNotNull() {
            addCriterion("errorCode is not null");
            return (Criteria) this;
        }

        public Criteria andErrorcodeEqualTo(Integer value) {
            addCriterion("errorCode =", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotEqualTo(Integer value) {
            addCriterion("errorCode <>", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeGreaterThan(Integer value) {
            addCriterion("errorCode >", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("errorCode >=", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeLessThan(Integer value) {
            addCriterion("errorCode <", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeLessThanOrEqualTo(Integer value) {
            addCriterion("errorCode <=", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeIn(List<Integer> values) {
            addCriterion("errorCode in", values, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotIn(List<Integer> values) {
            addCriterion("errorCode not in", values, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeBetween(Integer value1, Integer value2) {
            addCriterion("errorCode between", value1, value2, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("errorCode not between", value1, value2, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrordetailsIsNull() {
            addCriterion("errorDetails is null");
            return (Criteria) this;
        }

        public Criteria andErrordetailsIsNotNull() {
            addCriterion("errorDetails is not null");
            return (Criteria) this;
        }

        public Criteria andErrordetailsEqualTo(String value) {
            addCriterion("errorDetails =", value, "errordetails");
            return (Criteria) this;
        }

        public Criteria andErrordetailsNotEqualTo(String value) {
            addCriterion("errorDetails <>", value, "errordetails");
            return (Criteria) this;
        }

        public Criteria andErrordetailsGreaterThan(String value) {
            addCriterion("errorDetails >", value, "errordetails");
            return (Criteria) this;
        }

        public Criteria andErrordetailsGreaterThanOrEqualTo(String value) {
            addCriterion("errorDetails >=", value, "errordetails");
            return (Criteria) this;
        }

        public Criteria andErrordetailsLessThan(String value) {
            addCriterion("errorDetails <", value, "errordetails");
            return (Criteria) this;
        }

        public Criteria andErrordetailsLessThanOrEqualTo(String value) {
            addCriterion("errorDetails <=", value, "errordetails");
            return (Criteria) this;
        }

        public Criteria andErrordetailsLike(String value) {
            addCriterion("errorDetails like", value, "errordetails");
            return (Criteria) this;
        }

        public Criteria andErrordetailsNotLike(String value) {
            addCriterion("errorDetails not like", value, "errordetails");
            return (Criteria) this;
        }

        public Criteria andErrordetailsIn(List<String> values) {
            addCriterion("errorDetails in", values, "errordetails");
            return (Criteria) this;
        }

        public Criteria andErrordetailsNotIn(List<String> values) {
            addCriterion("errorDetails not in", values, "errordetails");
            return (Criteria) this;
        }

        public Criteria andErrordetailsBetween(String value1, String value2) {
            addCriterion("errorDetails between", value1, value2, "errordetails");
            return (Criteria) this;
        }

        public Criteria andErrordetailsNotBetween(String value1, String value2) {
            addCriterion("errorDetails not between", value1, value2, "errordetails");
            return (Criteria) this;
        }

        public Criteria andInformationidIsNull() {
            addCriterion("informationid is null");
            return (Criteria) this;
        }

        public Criteria andInformationidIsNotNull() {
            addCriterion("informationid is not null");
            return (Criteria) this;
        }

        public Criteria andInformationidEqualTo(Integer value) {
            addCriterion("informationid =", value, "informationid");
            return (Criteria) this;
        }

        public Criteria andInformationidNotEqualTo(Integer value) {
            addCriterion("informationid <>", value, "informationid");
            return (Criteria) this;
        }

        public Criteria andInformationidGreaterThan(Integer value) {
            addCriterion("informationid >", value, "informationid");
            return (Criteria) this;
        }

        public Criteria andInformationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("informationid >=", value, "informationid");
            return (Criteria) this;
        }

        public Criteria andInformationidLessThan(Integer value) {
            addCriterion("informationid <", value, "informationid");
            return (Criteria) this;
        }

        public Criteria andInformationidLessThanOrEqualTo(Integer value) {
            addCriterion("informationid <=", value, "informationid");
            return (Criteria) this;
        }

        public Criteria andInformationidIn(List<Integer> values) {
            addCriterion("informationid in", values, "informationid");
            return (Criteria) this;
        }

        public Criteria andInformationidNotIn(List<Integer> values) {
            addCriterion("informationid not in", values, "informationid");
            return (Criteria) this;
        }

        public Criteria andInformationidBetween(Integer value1, Integer value2) {
            addCriterion("informationid between", value1, value2, "informationid");
            return (Criteria) this;
        }

        public Criteria andInformationidNotBetween(Integer value1, Integer value2) {
            addCriterion("informationid not between", value1, value2, "informationid");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNull() {
            addCriterion("creatTime is null");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNotNull() {
            addCriterion("creatTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreattimeEqualTo(Date value) {
            addCriterion("creatTime =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterion("creatTime <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterion("creatTime >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creatTime >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(Date value) {
            addCriterion("creatTime <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("creatTime <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<Date> values) {
            addCriterion("creatTime in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterion("creatTime not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterion("creatTime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("creatTime not between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andSendstatusIsNull() {
            addCriterion("sendStatus is null");
            return (Criteria) this;
        }

        public Criteria andSendstatusIsNotNull() {
            addCriterion("sendStatus is not null");
            return (Criteria) this;
        }

        public Criteria andSendstatusEqualTo(Integer value) {
            addCriterion("sendStatus =", value, "sendstatus");
            return (Criteria) this;
        }

        public Criteria andSendstatusNotEqualTo(Integer value) {
            addCriterion("sendStatus <>", value, "sendstatus");
            return (Criteria) this;
        }

        public Criteria andSendstatusGreaterThan(Integer value) {
            addCriterion("sendStatus >", value, "sendstatus");
            return (Criteria) this;
        }

        public Criteria andSendstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sendStatus >=", value, "sendstatus");
            return (Criteria) this;
        }

        public Criteria andSendstatusLessThan(Integer value) {
            addCriterion("sendStatus <", value, "sendstatus");
            return (Criteria) this;
        }

        public Criteria andSendstatusLessThanOrEqualTo(Integer value) {
            addCriterion("sendStatus <=", value, "sendstatus");
            return (Criteria) this;
        }

        public Criteria andSendstatusIn(List<Integer> values) {
            addCriterion("sendStatus in", values, "sendstatus");
            return (Criteria) this;
        }

        public Criteria andSendstatusNotIn(List<Integer> values) {
            addCriterion("sendStatus not in", values, "sendstatus");
            return (Criteria) this;
        }

        public Criteria andSendstatusBetween(Integer value1, Integer value2) {
            addCriterion("sendStatus between", value1, value2, "sendstatus");
            return (Criteria) this;
        }

        public Criteria andSendstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sendStatus not between", value1, value2, "sendstatus");
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