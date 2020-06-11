package com.spider.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblErrorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblErrorExample() {
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

        public Criteria andErroridIsNull() {
            addCriterion("errorId is null");
            return (Criteria) this;
        }

        public Criteria andErroridIsNotNull() {
            addCriterion("errorId is not null");
            return (Criteria) this;
        }

        public Criteria andErroridEqualTo(Integer value) {
            addCriterion("errorId =", value, "errorid");
            return (Criteria) this;
        }

        public Criteria andErroridNotEqualTo(Integer value) {
            addCriterion("errorId <>", value, "errorid");
            return (Criteria) this;
        }

        public Criteria andErroridGreaterThan(Integer value) {
            addCriterion("errorId >", value, "errorid");
            return (Criteria) this;
        }

        public Criteria andErroridGreaterThanOrEqualTo(Integer value) {
            addCriterion("errorId >=", value, "errorid");
            return (Criteria) this;
        }

        public Criteria andErroridLessThan(Integer value) {
            addCriterion("errorId <", value, "errorid");
            return (Criteria) this;
        }

        public Criteria andErroridLessThanOrEqualTo(Integer value) {
            addCriterion("errorId <=", value, "errorid");
            return (Criteria) this;
        }

        public Criteria andErroridIn(List<Integer> values) {
            addCriterion("errorId in", values, "errorid");
            return (Criteria) this;
        }

        public Criteria andErroridNotIn(List<Integer> values) {
            addCriterion("errorId not in", values, "errorid");
            return (Criteria) this;
        }

        public Criteria andErroridBetween(Integer value1, Integer value2) {
            addCriterion("errorId between", value1, value2, "errorid");
            return (Criteria) this;
        }

        public Criteria andErroridNotBetween(Integer value1, Integer value2) {
            addCriterion("errorId not between", value1, value2, "errorid");
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

        public Criteria andErrordescIsNull() {
            addCriterion("errorDesc is null");
            return (Criteria) this;
        }

        public Criteria andErrordescIsNotNull() {
            addCriterion("errorDesc is not null");
            return (Criteria) this;
        }

        public Criteria andErrordescEqualTo(String value) {
            addCriterion("errorDesc =", value, "errordesc");
            return (Criteria) this;
        }

        public Criteria andErrordescNotEqualTo(String value) {
            addCriterion("errorDesc <>", value, "errordesc");
            return (Criteria) this;
        }

        public Criteria andErrordescGreaterThan(String value) {
            addCriterion("errorDesc >", value, "errordesc");
            return (Criteria) this;
        }

        public Criteria andErrordescGreaterThanOrEqualTo(String value) {
            addCriterion("errorDesc >=", value, "errordesc");
            return (Criteria) this;
        }

        public Criteria andErrordescLessThan(String value) {
            addCriterion("errorDesc <", value, "errordesc");
            return (Criteria) this;
        }

        public Criteria andErrordescLessThanOrEqualTo(String value) {
            addCriterion("errorDesc <=", value, "errordesc");
            return (Criteria) this;
        }

        public Criteria andErrordescLike(String value) {
            addCriterion("errorDesc like", value, "errordesc");
            return (Criteria) this;
        }

        public Criteria andErrordescNotLike(String value) {
            addCriterion("errorDesc not like", value, "errordesc");
            return (Criteria) this;
        }

        public Criteria andErrordescIn(List<String> values) {
            addCriterion("errorDesc in", values, "errordesc");
            return (Criteria) this;
        }

        public Criteria andErrordescNotIn(List<String> values) {
            addCriterion("errorDesc not in", values, "errordesc");
            return (Criteria) this;
        }

        public Criteria andErrordescBetween(String value1, String value2) {
            addCriterion("errorDesc between", value1, value2, "errordesc");
            return (Criteria) this;
        }

        public Criteria andErrordescNotBetween(String value1, String value2) {
            addCriterion("errorDesc not between", value1, value2, "errordesc");
            return (Criteria) this;
        }

        public Criteria andErrorstatusIsNull() {
            addCriterion("errorStatus is null");
            return (Criteria) this;
        }

        public Criteria andErrorstatusIsNotNull() {
            addCriterion("errorStatus is not null");
            return (Criteria) this;
        }

        public Criteria andErrorstatusEqualTo(Integer value) {
            addCriterion("errorStatus =", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusNotEqualTo(Integer value) {
            addCriterion("errorStatus <>", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusGreaterThan(Integer value) {
            addCriterion("errorStatus >", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("errorStatus >=", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusLessThan(Integer value) {
            addCriterion("errorStatus <", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusLessThanOrEqualTo(Integer value) {
            addCriterion("errorStatus <=", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusIn(List<Integer> values) {
            addCriterion("errorStatus in", values, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusNotIn(List<Integer> values) {
            addCriterion("errorStatus not in", values, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusBetween(Integer value1, Integer value2) {
            addCriterion("errorStatus between", value1, value2, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("errorStatus not between", value1, value2, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andCreatidIsNull() {
            addCriterion("creatId is null");
            return (Criteria) this;
        }

        public Criteria andCreatidIsNotNull() {
            addCriterion("creatId is not null");
            return (Criteria) this;
        }

        public Criteria andCreatidEqualTo(Integer value) {
            addCriterion("creatId =", value, "creatid");
            return (Criteria) this;
        }

        public Criteria andCreatidNotEqualTo(Integer value) {
            addCriterion("creatId <>", value, "creatid");
            return (Criteria) this;
        }

        public Criteria andCreatidGreaterThan(Integer value) {
            addCriterion("creatId >", value, "creatid");
            return (Criteria) this;
        }

        public Criteria andCreatidGreaterThanOrEqualTo(Integer value) {
            addCriterion("creatId >=", value, "creatid");
            return (Criteria) this;
        }

        public Criteria andCreatidLessThan(Integer value) {
            addCriterion("creatId <", value, "creatid");
            return (Criteria) this;
        }

        public Criteria andCreatidLessThanOrEqualTo(Integer value) {
            addCriterion("creatId <=", value, "creatid");
            return (Criteria) this;
        }

        public Criteria andCreatidIn(List<Integer> values) {
            addCriterion("creatId in", values, "creatid");
            return (Criteria) this;
        }

        public Criteria andCreatidNotIn(List<Integer> values) {
            addCriterion("creatId not in", values, "creatid");
            return (Criteria) this;
        }

        public Criteria andCreatidBetween(Integer value1, Integer value2) {
            addCriterion("creatId between", value1, value2, "creatid");
            return (Criteria) this;
        }

        public Criteria andCreatidNotBetween(Integer value1, Integer value2) {
            addCriterion("creatId not between", value1, value2, "creatid");
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

        public Criteria andStoptimeIsNull() {
            addCriterion("stopTime is null");
            return (Criteria) this;
        }

        public Criteria andStoptimeIsNotNull() {
            addCriterion("stopTime is not null");
            return (Criteria) this;
        }

        public Criteria andStoptimeEqualTo(Date value) {
            addCriterion("stopTime =", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeNotEqualTo(Date value) {
            addCriterion("stopTime <>", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeGreaterThan(Date value) {
            addCriterion("stopTime >", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stopTime >=", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeLessThan(Date value) {
            addCriterion("stopTime <", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeLessThanOrEqualTo(Date value) {
            addCriterion("stopTime <=", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeIn(List<Date> values) {
            addCriterion("stopTime in", values, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeNotIn(List<Date> values) {
            addCriterion("stopTime not in", values, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeBetween(Date value1, Date value2) {
            addCriterion("stopTime between", value1, value2, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeNotBetween(Date value1, Date value2) {
            addCriterion("stopTime not between", value1, value2, "stoptime");
            return (Criteria) this;
        }

        public Criteria andLevelsIsNull() {
            addCriterion("levels is null");
            return (Criteria) this;
        }

        public Criteria andLevelsIsNotNull() {
            addCriterion("levels is not null");
            return (Criteria) this;
        }

        public Criteria andLevelsEqualTo(Byte value) {
            addCriterion("levels =", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotEqualTo(Byte value) {
            addCriterion("levels <>", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsGreaterThan(Byte value) {
            addCriterion("levels >", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsGreaterThanOrEqualTo(Byte value) {
            addCriterion("levels >=", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsLessThan(Byte value) {
            addCriterion("levels <", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsLessThanOrEqualTo(Byte value) {
            addCriterion("levels <=", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsIn(List<Byte> values) {
            addCriterion("levels in", values, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotIn(List<Byte> values) {
            addCriterion("levels not in", values, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsBetween(Byte value1, Byte value2) {
            addCriterion("levels between", value1, value2, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotBetween(Byte value1, Byte value2) {
            addCriterion("levels not between", value1, value2, "levels");
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