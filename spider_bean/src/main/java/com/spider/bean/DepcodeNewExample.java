package com.spider.bean;

import java.util.ArrayList;
import java.util.List;

public class DepcodeNewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepcodeNewExample() {
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

        public Criteria andDepNumberIsNull() {
            addCriterion("dep_number is null");
            return (Criteria) this;
        }

        public Criteria andDepNumberIsNotNull() {
            addCriterion("dep_number is not null");
            return (Criteria) this;
        }

        public Criteria andDepNumberEqualTo(String value) {
            addCriterion("dep_number =", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberNotEqualTo(String value) {
            addCriterion("dep_number <>", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberGreaterThan(String value) {
            addCriterion("dep_number >", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberGreaterThanOrEqualTo(String value) {
            addCriterion("dep_number >=", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberLessThan(String value) {
            addCriterion("dep_number <", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberLessThanOrEqualTo(String value) {
            addCriterion("dep_number <=", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberLike(String value) {
            addCriterion("dep_number like", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberNotLike(String value) {
            addCriterion("dep_number not like", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberIn(List<String> values) {
            addCriterion("dep_number in", values, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberNotIn(List<String> values) {
            addCriterion("dep_number not in", values, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberBetween(String value1, String value2) {
            addCriterion("dep_number between", value1, value2, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberNotBetween(String value1, String value2) {
            addCriterion("dep_number not between", value1, value2, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNull() {
            addCriterion("dep_name is null");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNotNull() {
            addCriterion("dep_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepNameEqualTo(String value) {
            addCriterion("dep_name =", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotEqualTo(String value) {
            addCriterion("dep_name <>", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThan(String value) {
            addCriterion("dep_name >", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThanOrEqualTo(String value) {
            addCriterion("dep_name >=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThan(String value) {
            addCriterion("dep_name <", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThanOrEqualTo(String value) {
            addCriterion("dep_name <=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLike(String value) {
            addCriterion("dep_name like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotLike(String value) {
            addCriterion("dep_name not like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameIn(List<String> values) {
            addCriterion("dep_name in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotIn(List<String> values) {
            addCriterion("dep_name not in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameBetween(String value1, String value2) {
            addCriterion("dep_name between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotBetween(String value1, String value2) {
            addCriterion("dep_name not between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andAlisNameIsNull() {
            addCriterion("alis_name is null");
            return (Criteria) this;
        }

        public Criteria andAlisNameIsNotNull() {
            addCriterion("alis_name is not null");
            return (Criteria) this;
        }

        public Criteria andAlisNameEqualTo(String value) {
            addCriterion("alis_name =", value, "alisName");
            return (Criteria) this;
        }

        public Criteria andAlisNameNotEqualTo(String value) {
            addCriterion("alis_name <>", value, "alisName");
            return (Criteria) this;
        }

        public Criteria andAlisNameGreaterThan(String value) {
            addCriterion("alis_name >", value, "alisName");
            return (Criteria) this;
        }

        public Criteria andAlisNameGreaterThanOrEqualTo(String value) {
            addCriterion("alis_name >=", value, "alisName");
            return (Criteria) this;
        }

        public Criteria andAlisNameLessThan(String value) {
            addCriterion("alis_name <", value, "alisName");
            return (Criteria) this;
        }

        public Criteria andAlisNameLessThanOrEqualTo(String value) {
            addCriterion("alis_name <=", value, "alisName");
            return (Criteria) this;
        }

        public Criteria andAlisNameLike(String value) {
            addCriterion("alis_name like", value, "alisName");
            return (Criteria) this;
        }

        public Criteria andAlisNameNotLike(String value) {
            addCriterion("alis_name not like", value, "alisName");
            return (Criteria) this;
        }

        public Criteria andAlisNameIn(List<String> values) {
            addCriterion("alis_name in", values, "alisName");
            return (Criteria) this;
        }

        public Criteria andAlisNameNotIn(List<String> values) {
            addCriterion("alis_name not in", values, "alisName");
            return (Criteria) this;
        }

        public Criteria andAlisNameBetween(String value1, String value2) {
            addCriterion("alis_name between", value1, value2, "alisName");
            return (Criteria) this;
        }

        public Criteria andAlisNameNotBetween(String value1, String value2) {
            addCriterion("alis_name not between", value1, value2, "alisName");
            return (Criteria) this;
        }

        public Criteria andSortFIsNull() {
            addCriterion("sort_f is null");
            return (Criteria) this;
        }

        public Criteria andSortFIsNotNull() {
            addCriterion("sort_f is not null");
            return (Criteria) this;
        }

        public Criteria andSortFEqualTo(Short value) {
            addCriterion("sort_f =", value, "sortF");
            return (Criteria) this;
        }

        public Criteria andSortFNotEqualTo(Short value) {
            addCriterion("sort_f <>", value, "sortF");
            return (Criteria) this;
        }

        public Criteria andSortFGreaterThan(Short value) {
            addCriterion("sort_f >", value, "sortF");
            return (Criteria) this;
        }

        public Criteria andSortFGreaterThanOrEqualTo(Short value) {
            addCriterion("sort_f >=", value, "sortF");
            return (Criteria) this;
        }

        public Criteria andSortFLessThan(Short value) {
            addCriterion("sort_f <", value, "sortF");
            return (Criteria) this;
        }

        public Criteria andSortFLessThanOrEqualTo(Short value) {
            addCriterion("sort_f <=", value, "sortF");
            return (Criteria) this;
        }

        public Criteria andSortFIn(List<Short> values) {
            addCriterion("sort_f in", values, "sortF");
            return (Criteria) this;
        }

        public Criteria andSortFNotIn(List<Short> values) {
            addCriterion("sort_f not in", values, "sortF");
            return (Criteria) this;
        }

        public Criteria andSortFBetween(Short value1, Short value2) {
            addCriterion("sort_f between", value1, value2, "sortF");
            return (Criteria) this;
        }

        public Criteria andSortFNotBetween(Short value1, Short value2) {
            addCriterion("sort_f not between", value1, value2, "sortF");
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