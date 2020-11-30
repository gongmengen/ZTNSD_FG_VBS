package com.spider.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarkdetailMainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarkdetailMainExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Long value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Long value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Long value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Long value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Long value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Long> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Long> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Long value1, Long value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Long value1, Long value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andRjs0IsNull() {
            addCriterion("RJS0 is null");
            return (Criteria) this;
        }

        public Criteria andRjs0IsNotNull() {
            addCriterion("RJS0 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs0EqualTo(String value) {
            addCriterion("RJS0 =", value, "rjs0");
            return (Criteria) this;
        }

        public Criteria andRjs0NotEqualTo(String value) {
            addCriterion("RJS0 <>", value, "rjs0");
            return (Criteria) this;
        }

        public Criteria andRjs0GreaterThan(String value) {
            addCriterion("RJS0 >", value, "rjs0");
            return (Criteria) this;
        }

        public Criteria andRjs0GreaterThanOrEqualTo(String value) {
            addCriterion("RJS0 >=", value, "rjs0");
            return (Criteria) this;
        }

        public Criteria andRjs0LessThan(String value) {
            addCriterion("RJS0 <", value, "rjs0");
            return (Criteria) this;
        }

        public Criteria andRjs0LessThanOrEqualTo(String value) {
            addCriterion("RJS0 <=", value, "rjs0");
            return (Criteria) this;
        }

        public Criteria andRjs0Like(String value) {
            addCriterion("RJS0 like", value, "rjs0");
            return (Criteria) this;
        }

        public Criteria andRjs0NotLike(String value) {
            addCriterion("RJS0 not like", value, "rjs0");
            return (Criteria) this;
        }

        public Criteria andRjs0In(List<String> values) {
            addCriterion("RJS0 in", values, "rjs0");
            return (Criteria) this;
        }

        public Criteria andRjs0NotIn(List<String> values) {
            addCriterion("RJS0 not in", values, "rjs0");
            return (Criteria) this;
        }

        public Criteria andRjs0Between(String value1, String value2) {
            addCriterion("RJS0 between", value1, value2, "rjs0");
            return (Criteria) this;
        }

        public Criteria andRjs0NotBetween(String value1, String value2) {
            addCriterion("RJS0 not between", value1, value2, "rjs0");
            return (Criteria) this;
        }

        public Criteria andRjs1IsNull() {
            addCriterion("RJS1 is null");
            return (Criteria) this;
        }

        public Criteria andRjs1IsNotNull() {
            addCriterion("RJS1 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs1EqualTo(String value) {
            addCriterion("RJS1 =", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1NotEqualTo(String value) {
            addCriterion("RJS1 <>", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1GreaterThan(String value) {
            addCriterion("RJS1 >", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1GreaterThanOrEqualTo(String value) {
            addCriterion("RJS1 >=", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1LessThan(String value) {
            addCriterion("RJS1 <", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1LessThanOrEqualTo(String value) {
            addCriterion("RJS1 <=", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1Like(String value) {
            addCriterion("RJS1 like", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1NotLike(String value) {
            addCriterion("RJS1 not like", value, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1In(List<String> values) {
            addCriterion("RJS1 in", values, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1NotIn(List<String> values) {
            addCriterion("RJS1 not in", values, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1Between(String value1, String value2) {
            addCriterion("RJS1 between", value1, value2, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs1NotBetween(String value1, String value2) {
            addCriterion("RJS1 not between", value1, value2, "rjs1");
            return (Criteria) this;
        }

        public Criteria andRjs4IsNull() {
            addCriterion("RJS4 is null");
            return (Criteria) this;
        }

        public Criteria andRjs4IsNotNull() {
            addCriterion("RJS4 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs4EqualTo(String value) {
            addCriterion("RJS4 =", value, "rjs4");
            return (Criteria) this;
        }

        public Criteria andRjs4NotEqualTo(String value) {
            addCriterion("RJS4 <>", value, "rjs4");
            return (Criteria) this;
        }

        public Criteria andRjs4GreaterThan(String value) {
            addCriterion("RJS4 >", value, "rjs4");
            return (Criteria) this;
        }

        public Criteria andRjs4GreaterThanOrEqualTo(String value) {
            addCriterion("RJS4 >=", value, "rjs4");
            return (Criteria) this;
        }

        public Criteria andRjs4LessThan(String value) {
            addCriterion("RJS4 <", value, "rjs4");
            return (Criteria) this;
        }

        public Criteria andRjs4LessThanOrEqualTo(String value) {
            addCriterion("RJS4 <=", value, "rjs4");
            return (Criteria) this;
        }

        public Criteria andRjs4Like(String value) {
            addCriterion("RJS4 like", value, "rjs4");
            return (Criteria) this;
        }

        public Criteria andRjs4NotLike(String value) {
            addCriterion("RJS4 not like", value, "rjs4");
            return (Criteria) this;
        }

        public Criteria andRjs4In(List<String> values) {
            addCriterion("RJS4 in", values, "rjs4");
            return (Criteria) this;
        }

        public Criteria andRjs4NotIn(List<String> values) {
            addCriterion("RJS4 not in", values, "rjs4");
            return (Criteria) this;
        }

        public Criteria andRjs4Between(String value1, String value2) {
            addCriterion("RJS4 between", value1, value2, "rjs4");
            return (Criteria) this;
        }

        public Criteria andRjs4NotBetween(String value1, String value2) {
            addCriterion("RJS4 not between", value1, value2, "rjs4");
            return (Criteria) this;
        }

        public Criteria andRjs5IsNull() {
            addCriterion("RJS5 is null");
            return (Criteria) this;
        }

        public Criteria andRjs5IsNotNull() {
            addCriterion("RJS5 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs5EqualTo(String value) {
            addCriterion("RJS5 =", value, "rjs5");
            return (Criteria) this;
        }

        public Criteria andRjs5NotEqualTo(String value) {
            addCriterion("RJS5 <>", value, "rjs5");
            return (Criteria) this;
        }

        public Criteria andRjs5GreaterThan(String value) {
            addCriterion("RJS5 >", value, "rjs5");
            return (Criteria) this;
        }

        public Criteria andRjs5GreaterThanOrEqualTo(String value) {
            addCriterion("RJS5 >=", value, "rjs5");
            return (Criteria) this;
        }

        public Criteria andRjs5LessThan(String value) {
            addCriterion("RJS5 <", value, "rjs5");
            return (Criteria) this;
        }

        public Criteria andRjs5LessThanOrEqualTo(String value) {
            addCriterion("RJS5 <=", value, "rjs5");
            return (Criteria) this;
        }

        public Criteria andRjs5Like(String value) {
            addCriterion("RJS5 like", value, "rjs5");
            return (Criteria) this;
        }

        public Criteria andRjs5NotLike(String value) {
            addCriterion("RJS5 not like", value, "rjs5");
            return (Criteria) this;
        }

        public Criteria andRjs5In(List<String> values) {
            addCriterion("RJS5 in", values, "rjs5");
            return (Criteria) this;
        }

        public Criteria andRjs5NotIn(List<String> values) {
            addCriterion("RJS5 not in", values, "rjs5");
            return (Criteria) this;
        }

        public Criteria andRjs5Between(String value1, String value2) {
            addCriterion("RJS5 between", value1, value2, "rjs5");
            return (Criteria) this;
        }

        public Criteria andRjs5NotBetween(String value1, String value2) {
            addCriterion("RJS5 not between", value1, value2, "rjs5");
            return (Criteria) this;
        }

        public Criteria andRjs6IsNull() {
            addCriterion("RJS6 is null");
            return (Criteria) this;
        }

        public Criteria andRjs6IsNotNull() {
            addCriterion("RJS6 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs6EqualTo(String value) {
            addCriterion("RJS6 =", value, "rjs6");
            return (Criteria) this;
        }

        public Criteria andRjs6NotEqualTo(String value) {
            addCriterion("RJS6 <>", value, "rjs6");
            return (Criteria) this;
        }

        public Criteria andRjs6GreaterThan(String value) {
            addCriterion("RJS6 >", value, "rjs6");
            return (Criteria) this;
        }

        public Criteria andRjs6GreaterThanOrEqualTo(String value) {
            addCriterion("RJS6 >=", value, "rjs6");
            return (Criteria) this;
        }

        public Criteria andRjs6LessThan(String value) {
            addCriterion("RJS6 <", value, "rjs6");
            return (Criteria) this;
        }

        public Criteria andRjs6LessThanOrEqualTo(String value) {
            addCriterion("RJS6 <=", value, "rjs6");
            return (Criteria) this;
        }

        public Criteria andRjs6Like(String value) {
            addCriterion("RJS6 like", value, "rjs6");
            return (Criteria) this;
        }

        public Criteria andRjs6NotLike(String value) {
            addCriterion("RJS6 not like", value, "rjs6");
            return (Criteria) this;
        }

        public Criteria andRjs6In(List<String> values) {
            addCriterion("RJS6 in", values, "rjs6");
            return (Criteria) this;
        }

        public Criteria andRjs6NotIn(List<String> values) {
            addCriterion("RJS6 not in", values, "rjs6");
            return (Criteria) this;
        }

        public Criteria andRjs6Between(String value1, String value2) {
            addCriterion("RJS6 between", value1, value2, "rjs6");
            return (Criteria) this;
        }

        public Criteria andRjs6NotBetween(String value1, String value2) {
            addCriterion("RJS6 not between", value1, value2, "rjs6");
            return (Criteria) this;
        }

        public Criteria andRjs7IsNull() {
            addCriterion("RJS7 is null");
            return (Criteria) this;
        }

        public Criteria andRjs7IsNotNull() {
            addCriterion("RJS7 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs7EqualTo(String value) {
            addCriterion("RJS7 =", value, "rjs7");
            return (Criteria) this;
        }

        public Criteria andRjs7NotEqualTo(String value) {
            addCriterion("RJS7 <>", value, "rjs7");
            return (Criteria) this;
        }

        public Criteria andRjs7GreaterThan(String value) {
            addCriterion("RJS7 >", value, "rjs7");
            return (Criteria) this;
        }

        public Criteria andRjs7GreaterThanOrEqualTo(String value) {
            addCriterion("RJS7 >=", value, "rjs7");
            return (Criteria) this;
        }

        public Criteria andRjs7LessThan(String value) {
            addCriterion("RJS7 <", value, "rjs7");
            return (Criteria) this;
        }

        public Criteria andRjs7LessThanOrEqualTo(String value) {
            addCriterion("RJS7 <=", value, "rjs7");
            return (Criteria) this;
        }

        public Criteria andRjs7Like(String value) {
            addCriterion("RJS7 like", value, "rjs7");
            return (Criteria) this;
        }

        public Criteria andRjs7NotLike(String value) {
            addCriterion("RJS7 not like", value, "rjs7");
            return (Criteria) this;
        }

        public Criteria andRjs7In(List<String> values) {
            addCriterion("RJS7 in", values, "rjs7");
            return (Criteria) this;
        }

        public Criteria andRjs7NotIn(List<String> values) {
            addCriterion("RJS7 not in", values, "rjs7");
            return (Criteria) this;
        }

        public Criteria andRjs7Between(String value1, String value2) {
            addCriterion("RJS7 between", value1, value2, "rjs7");
            return (Criteria) this;
        }

        public Criteria andRjs7NotBetween(String value1, String value2) {
            addCriterion("RJS7 not between", value1, value2, "rjs7");
            return (Criteria) this;
        }

        public Criteria andRjs8IsNull() {
            addCriterion("RJS8 is null");
            return (Criteria) this;
        }

        public Criteria andRjs8IsNotNull() {
            addCriterion("RJS8 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs8EqualTo(String value) {
            addCriterion("RJS8 =", value, "rjs8");
            return (Criteria) this;
        }

        public Criteria andRjs8NotEqualTo(String value) {
            addCriterion("RJS8 <>", value, "rjs8");
            return (Criteria) this;
        }

        public Criteria andRjs8GreaterThan(String value) {
            addCriterion("RJS8 >", value, "rjs8");
            return (Criteria) this;
        }

        public Criteria andRjs8GreaterThanOrEqualTo(String value) {
            addCriterion("RJS8 >=", value, "rjs8");
            return (Criteria) this;
        }

        public Criteria andRjs8LessThan(String value) {
            addCriterion("RJS8 <", value, "rjs8");
            return (Criteria) this;
        }

        public Criteria andRjs8LessThanOrEqualTo(String value) {
            addCriterion("RJS8 <=", value, "rjs8");
            return (Criteria) this;
        }

        public Criteria andRjs8Like(String value) {
            addCriterion("RJS8 like", value, "rjs8");
            return (Criteria) this;
        }

        public Criteria andRjs8NotLike(String value) {
            addCriterion("RJS8 not like", value, "rjs8");
            return (Criteria) this;
        }

        public Criteria andRjs8In(List<String> values) {
            addCriterion("RJS8 in", values, "rjs8");
            return (Criteria) this;
        }

        public Criteria andRjs8NotIn(List<String> values) {
            addCriterion("RJS8 not in", values, "rjs8");
            return (Criteria) this;
        }

        public Criteria andRjs8Between(String value1, String value2) {
            addCriterion("RJS8 between", value1, value2, "rjs8");
            return (Criteria) this;
        }

        public Criteria andRjs8NotBetween(String value1, String value2) {
            addCriterion("RJS8 not between", value1, value2, "rjs8");
            return (Criteria) this;
        }

        public Criteria andRjs9IsNull() {
            addCriterion("RJS9 is null");
            return (Criteria) this;
        }

        public Criteria andRjs9IsNotNull() {
            addCriterion("RJS9 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs9EqualTo(Short value) {
            addCriterion("RJS9 =", value, "rjs9");
            return (Criteria) this;
        }

        public Criteria andRjs9NotEqualTo(Short value) {
            addCriterion("RJS9 <>", value, "rjs9");
            return (Criteria) this;
        }

        public Criteria andRjs9GreaterThan(Short value) {
            addCriterion("RJS9 >", value, "rjs9");
            return (Criteria) this;
        }

        public Criteria andRjs9GreaterThanOrEqualTo(Short value) {
            addCriterion("RJS9 >=", value, "rjs9");
            return (Criteria) this;
        }

        public Criteria andRjs9LessThan(Short value) {
            addCriterion("RJS9 <", value, "rjs9");
            return (Criteria) this;
        }

        public Criteria andRjs9LessThanOrEqualTo(Short value) {
            addCriterion("RJS9 <=", value, "rjs9");
            return (Criteria) this;
        }

        public Criteria andRjs9In(List<Short> values) {
            addCriterion("RJS9 in", values, "rjs9");
            return (Criteria) this;
        }

        public Criteria andRjs9NotIn(List<Short> values) {
            addCriterion("RJS9 not in", values, "rjs9");
            return (Criteria) this;
        }

        public Criteria andRjs9Between(Short value1, Short value2) {
            addCriterion("RJS9 between", value1, value2, "rjs9");
            return (Criteria) this;
        }

        public Criteria andRjs9NotBetween(Short value1, Short value2) {
            addCriterion("RJS9 not between", value1, value2, "rjs9");
            return (Criteria) this;
        }

        public Criteria andRjs10IsNull() {
            addCriterion("RJS10 is null");
            return (Criteria) this;
        }

        public Criteria andRjs10IsNotNull() {
            addCriterion("RJS10 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs10EqualTo(String value) {
            addCriterion("RJS10 =", value, "rjs10");
            return (Criteria) this;
        }

        public Criteria andRjs10NotEqualTo(String value) {
            addCriterion("RJS10 <>", value, "rjs10");
            return (Criteria) this;
        }

        public Criteria andRjs10GreaterThan(String value) {
            addCriterion("RJS10 >", value, "rjs10");
            return (Criteria) this;
        }

        public Criteria andRjs10GreaterThanOrEqualTo(String value) {
            addCriterion("RJS10 >=", value, "rjs10");
            return (Criteria) this;
        }

        public Criteria andRjs10LessThan(String value) {
            addCriterion("RJS10 <", value, "rjs10");
            return (Criteria) this;
        }

        public Criteria andRjs10LessThanOrEqualTo(String value) {
            addCriterion("RJS10 <=", value, "rjs10");
            return (Criteria) this;
        }

        public Criteria andRjs10Like(String value) {
            addCriterion("RJS10 like", value, "rjs10");
            return (Criteria) this;
        }

        public Criteria andRjs10NotLike(String value) {
            addCriterion("RJS10 not like", value, "rjs10");
            return (Criteria) this;
        }

        public Criteria andRjs10In(List<String> values) {
            addCriterion("RJS10 in", values, "rjs10");
            return (Criteria) this;
        }

        public Criteria andRjs10NotIn(List<String> values) {
            addCriterion("RJS10 not in", values, "rjs10");
            return (Criteria) this;
        }

        public Criteria andRjs10Between(String value1, String value2) {
            addCriterion("RJS10 between", value1, value2, "rjs10");
            return (Criteria) this;
        }

        public Criteria andRjs10NotBetween(String value1, String value2) {
            addCriterion("RJS10 not between", value1, value2, "rjs10");
            return (Criteria) this;
        }

        public Criteria andRjs11IsNull() {
            addCriterion("RJS11 is null");
            return (Criteria) this;
        }

        public Criteria andRjs11IsNotNull() {
            addCriterion("RJS11 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs11EqualTo(String value) {
            addCriterion("RJS11 =", value, "rjs11");
            return (Criteria) this;
        }

        public Criteria andRjs11NotEqualTo(String value) {
            addCriterion("RJS11 <>", value, "rjs11");
            return (Criteria) this;
        }

        public Criteria andRjs11GreaterThan(String value) {
            addCriterion("RJS11 >", value, "rjs11");
            return (Criteria) this;
        }

        public Criteria andRjs11GreaterThanOrEqualTo(String value) {
            addCriterion("RJS11 >=", value, "rjs11");
            return (Criteria) this;
        }

        public Criteria andRjs11LessThan(String value) {
            addCriterion("RJS11 <", value, "rjs11");
            return (Criteria) this;
        }

        public Criteria andRjs11LessThanOrEqualTo(String value) {
            addCriterion("RJS11 <=", value, "rjs11");
            return (Criteria) this;
        }

        public Criteria andRjs11Like(String value) {
            addCriterion("RJS11 like", value, "rjs11");
            return (Criteria) this;
        }

        public Criteria andRjs11NotLike(String value) {
            addCriterion("RJS11 not like", value, "rjs11");
            return (Criteria) this;
        }

        public Criteria andRjs11In(List<String> values) {
            addCriterion("RJS11 in", values, "rjs11");
            return (Criteria) this;
        }

        public Criteria andRjs11NotIn(List<String> values) {
            addCriterion("RJS11 not in", values, "rjs11");
            return (Criteria) this;
        }

        public Criteria andRjs11Between(String value1, String value2) {
            addCriterion("RJS11 between", value1, value2, "rjs11");
            return (Criteria) this;
        }

        public Criteria andRjs11NotBetween(String value1, String value2) {
            addCriterion("RJS11 not between", value1, value2, "rjs11");
            return (Criteria) this;
        }

        public Criteria andRjs12IsNull() {
            addCriterion("RJS12 is null");
            return (Criteria) this;
        }

        public Criteria andRjs12IsNotNull() {
            addCriterion("RJS12 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs12EqualTo(String value) {
            addCriterion("RJS12 =", value, "rjs12");
            return (Criteria) this;
        }

        public Criteria andRjs12NotEqualTo(String value) {
            addCriterion("RJS12 <>", value, "rjs12");
            return (Criteria) this;
        }

        public Criteria andRjs12GreaterThan(String value) {
            addCriterion("RJS12 >", value, "rjs12");
            return (Criteria) this;
        }

        public Criteria andRjs12GreaterThanOrEqualTo(String value) {
            addCriterion("RJS12 >=", value, "rjs12");
            return (Criteria) this;
        }

        public Criteria andRjs12LessThan(String value) {
            addCriterion("RJS12 <", value, "rjs12");
            return (Criteria) this;
        }

        public Criteria andRjs12LessThanOrEqualTo(String value) {
            addCriterion("RJS12 <=", value, "rjs12");
            return (Criteria) this;
        }

        public Criteria andRjs12Like(String value) {
            addCriterion("RJS12 like", value, "rjs12");
            return (Criteria) this;
        }

        public Criteria andRjs12NotLike(String value) {
            addCriterion("RJS12 not like", value, "rjs12");
            return (Criteria) this;
        }

        public Criteria andRjs12In(List<String> values) {
            addCriterion("RJS12 in", values, "rjs12");
            return (Criteria) this;
        }

        public Criteria andRjs12NotIn(List<String> values) {
            addCriterion("RJS12 not in", values, "rjs12");
            return (Criteria) this;
        }

        public Criteria andRjs12Between(String value1, String value2) {
            addCriterion("RJS12 between", value1, value2, "rjs12");
            return (Criteria) this;
        }

        public Criteria andRjs12NotBetween(String value1, String value2) {
            addCriterion("RJS12 not between", value1, value2, "rjs12");
            return (Criteria) this;
        }

        public Criteria andKwordIsNull() {
            addCriterion("kword is null");
            return (Criteria) this;
        }

        public Criteria andKwordIsNotNull() {
            addCriterion("kword is not null");
            return (Criteria) this;
        }

        public Criteria andKwordEqualTo(String value) {
            addCriterion("kword =", value, "kword");
            return (Criteria) this;
        }

        public Criteria andKwordNotEqualTo(String value) {
            addCriterion("kword <>", value, "kword");
            return (Criteria) this;
        }

        public Criteria andKwordGreaterThan(String value) {
            addCriterion("kword >", value, "kword");
            return (Criteria) this;
        }

        public Criteria andKwordGreaterThanOrEqualTo(String value) {
            addCriterion("kword >=", value, "kword");
            return (Criteria) this;
        }

        public Criteria andKwordLessThan(String value) {
            addCriterion("kword <", value, "kword");
            return (Criteria) this;
        }

        public Criteria andKwordLessThanOrEqualTo(String value) {
            addCriterion("kword <=", value, "kword");
            return (Criteria) this;
        }

        public Criteria andKwordLike(String value) {
            addCriterion("kword like", value, "kword");
            return (Criteria) this;
        }

        public Criteria andKwordNotLike(String value) {
            addCriterion("kword not like", value, "kword");
            return (Criteria) this;
        }

        public Criteria andKwordIn(List<String> values) {
            addCriterion("kword in", values, "kword");
            return (Criteria) this;
        }

        public Criteria andKwordNotIn(List<String> values) {
            addCriterion("kword not in", values, "kword");
            return (Criteria) this;
        }

        public Criteria andKwordBetween(String value1, String value2) {
            addCriterion("kword between", value1, value2, "kword");
            return (Criteria) this;
        }

        public Criteria andKwordNotBetween(String value1, String value2) {
            addCriterion("kword not between", value1, value2, "kword");
            return (Criteria) this;
        }

        public Criteria andAppuserIsNull() {
            addCriterion("appuser is null");
            return (Criteria) this;
        }

        public Criteria andAppuserIsNotNull() {
            addCriterion("appuser is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserEqualTo(String value) {
            addCriterion("appuser =", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserNotEqualTo(String value) {
            addCriterion("appuser <>", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserGreaterThan(String value) {
            addCriterion("appuser >", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserGreaterThanOrEqualTo(String value) {
            addCriterion("appuser >=", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserLessThan(String value) {
            addCriterion("appuser <", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserLessThanOrEqualTo(String value) {
            addCriterion("appuser <=", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserLike(String value) {
            addCriterion("appuser like", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserNotLike(String value) {
            addCriterion("appuser not like", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserIn(List<String> values) {
            addCriterion("appuser in", values, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserNotIn(List<String> values) {
            addCriterion("appuser not in", values, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserBetween(String value1, String value2) {
            addCriterion("appuser between", value1, value2, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserNotBetween(String value1, String value2) {
            addCriterion("appuser not between", value1, value2, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppdateIsNull() {
            addCriterion("appdate is null");
            return (Criteria) this;
        }

        public Criteria andAppdateIsNotNull() {
            addCriterion("appdate is not null");
            return (Criteria) this;
        }

        public Criteria andAppdateEqualTo(Date value) {
            addCriterion("appdate =", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateNotEqualTo(Date value) {
            addCriterion("appdate <>", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateGreaterThan(Date value) {
            addCriterion("appdate >", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateGreaterThanOrEqualTo(Date value) {
            addCriterion("appdate >=", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateLessThan(Date value) {
            addCriterion("appdate <", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateLessThanOrEqualTo(Date value) {
            addCriterion("appdate <=", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateIn(List<Date> values) {
            addCriterion("appdate in", values, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateNotIn(List<Date> values) {
            addCriterion("appdate not in", values, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateBetween(Date value1, Date value2) {
            addCriterion("appdate between", value1, value2, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateNotBetween(Date value1, Date value2) {
            addCriterion("appdate not between", value1, value2, "appdate");
            return (Criteria) this;
        }

        public Criteria andTruetagIsNull() {
            addCriterion("truetag is null");
            return (Criteria) this;
        }

        public Criteria andTruetagIsNotNull() {
            addCriterion("truetag is not null");
            return (Criteria) this;
        }

        public Criteria andTruetagEqualTo(Integer value) {
            addCriterion("truetag =", value, "truetag");
            return (Criteria) this;
        }

        public Criteria andTruetagNotEqualTo(Integer value) {
            addCriterion("truetag <>", value, "truetag");
            return (Criteria) this;
        }

        public Criteria andTruetagGreaterThan(Integer value) {
            addCriterion("truetag >", value, "truetag");
            return (Criteria) this;
        }

        public Criteria andTruetagGreaterThanOrEqualTo(Integer value) {
            addCriterion("truetag >=", value, "truetag");
            return (Criteria) this;
        }

        public Criteria andTruetagLessThan(Integer value) {
            addCriterion("truetag <", value, "truetag");
            return (Criteria) this;
        }

        public Criteria andTruetagLessThanOrEqualTo(Integer value) {
            addCriterion("truetag <=", value, "truetag");
            return (Criteria) this;
        }

        public Criteria andTruetagIn(List<Integer> values) {
            addCriterion("truetag in", values, "truetag");
            return (Criteria) this;
        }

        public Criteria andTruetagNotIn(List<Integer> values) {
            addCriterion("truetag not in", values, "truetag");
            return (Criteria) this;
        }

        public Criteria andTruetagBetween(Integer value1, Integer value2) {
            addCriterion("truetag between", value1, value2, "truetag");
            return (Criteria) this;
        }

        public Criteria andTruetagNotBetween(Integer value1, Integer value2) {
            addCriterion("truetag not between", value1, value2, "truetag");
            return (Criteria) this;
        }

        public Criteria andLawlevelIsNull() {
            addCriterion("lawlevel is null");
            return (Criteria) this;
        }

        public Criteria andLawlevelIsNotNull() {
            addCriterion("lawlevel is not null");
            return (Criteria) this;
        }

        public Criteria andLawlevelEqualTo(Integer value) {
            addCriterion("lawlevel =", value, "lawlevel");
            return (Criteria) this;
        }

        public Criteria andLawlevelNotEqualTo(Integer value) {
            addCriterion("lawlevel <>", value, "lawlevel");
            return (Criteria) this;
        }

        public Criteria andLawlevelGreaterThan(Integer value) {
            addCriterion("lawlevel >", value, "lawlevel");
            return (Criteria) this;
        }

        public Criteria andLawlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("lawlevel >=", value, "lawlevel");
            return (Criteria) this;
        }

        public Criteria andLawlevelLessThan(Integer value) {
            addCriterion("lawlevel <", value, "lawlevel");
            return (Criteria) this;
        }

        public Criteria andLawlevelLessThanOrEqualTo(Integer value) {
            addCriterion("lawlevel <=", value, "lawlevel");
            return (Criteria) this;
        }

        public Criteria andLawlevelIn(List<Integer> values) {
            addCriterion("lawlevel in", values, "lawlevel");
            return (Criteria) this;
        }

        public Criteria andLawlevelNotIn(List<Integer> values) {
            addCriterion("lawlevel not in", values, "lawlevel");
            return (Criteria) this;
        }

        public Criteria andLawlevelBetween(Integer value1, Integer value2) {
            addCriterion("lawlevel between", value1, value2, "lawlevel");
            return (Criteria) this;
        }

        public Criteria andLawlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("lawlevel not between", value1, value2, "lawlevel");
            return (Criteria) this;
        }

        public Criteria andMarkedIsNull() {
            addCriterion("Marked is null");
            return (Criteria) this;
        }

        public Criteria andMarkedIsNotNull() {
            addCriterion("Marked is not null");
            return (Criteria) this;
        }

        public Criteria andMarkedEqualTo(Integer value) {
            addCriterion("Marked =", value, "marked");
            return (Criteria) this;
        }

        public Criteria andMarkedNotEqualTo(Integer value) {
            addCriterion("Marked <>", value, "marked");
            return (Criteria) this;
        }

        public Criteria andMarkedGreaterThan(Integer value) {
            addCriterion("Marked >", value, "marked");
            return (Criteria) this;
        }

        public Criteria andMarkedGreaterThanOrEqualTo(Integer value) {
            addCriterion("Marked >=", value, "marked");
            return (Criteria) this;
        }

        public Criteria andMarkedLessThan(Integer value) {
            addCriterion("Marked <", value, "marked");
            return (Criteria) this;
        }

        public Criteria andMarkedLessThanOrEqualTo(Integer value) {
            addCriterion("Marked <=", value, "marked");
            return (Criteria) this;
        }

        public Criteria andMarkedIn(List<Integer> values) {
            addCriterion("Marked in", values, "marked");
            return (Criteria) this;
        }

        public Criteria andMarkedNotIn(List<Integer> values) {
            addCriterion("Marked not in", values, "marked");
            return (Criteria) this;
        }

        public Criteria andMarkedBetween(Integer value1, Integer value2) {
            addCriterion("Marked between", value1, value2, "marked");
            return (Criteria) this;
        }

        public Criteria andMarkedNotBetween(Integer value1, Integer value2) {
            addCriterion("Marked not between", value1, value2, "marked");
            return (Criteria) this;
        }

        public Criteria andAnyouIsNull() {
            addCriterion("anyou is null");
            return (Criteria) this;
        }

        public Criteria andAnyouIsNotNull() {
            addCriterion("anyou is not null");
            return (Criteria) this;
        }

        public Criteria andAnyouEqualTo(String value) {
            addCriterion("anyou =", value, "anyou");
            return (Criteria) this;
        }

        public Criteria andAnyouNotEqualTo(String value) {
            addCriterion("anyou <>", value, "anyou");
            return (Criteria) this;
        }

        public Criteria andAnyouGreaterThan(String value) {
            addCriterion("anyou >", value, "anyou");
            return (Criteria) this;
        }

        public Criteria andAnyouGreaterThanOrEqualTo(String value) {
            addCriterion("anyou >=", value, "anyou");
            return (Criteria) this;
        }

        public Criteria andAnyouLessThan(String value) {
            addCriterion("anyou <", value, "anyou");
            return (Criteria) this;
        }

        public Criteria andAnyouLessThanOrEqualTo(String value) {
            addCriterion("anyou <=", value, "anyou");
            return (Criteria) this;
        }

        public Criteria andAnyouLike(String value) {
            addCriterion("anyou like", value, "anyou");
            return (Criteria) this;
        }

        public Criteria andAnyouNotLike(String value) {
            addCriterion("anyou not like", value, "anyou");
            return (Criteria) this;
        }

        public Criteria andAnyouIn(List<String> values) {
            addCriterion("anyou in", values, "anyou");
            return (Criteria) this;
        }

        public Criteria andAnyouNotIn(List<String> values) {
            addCriterion("anyou not in", values, "anyou");
            return (Criteria) this;
        }

        public Criteria andAnyouBetween(String value1, String value2) {
            addCriterion("anyou between", value1, value2, "anyou");
            return (Criteria) this;
        }

        public Criteria andAnyouNotBetween(String value1, String value2) {
            addCriterion("anyou not between", value1, value2, "anyou");
            return (Criteria) this;
        }

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Long value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Long value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Long value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Long value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Long value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Long value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Long> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Long> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Long value1, Long value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Long value1, Long value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRjs13IsNull() {
            addCriterion("RJS13 is null");
            return (Criteria) this;
        }

        public Criteria andRjs13IsNotNull() {
            addCriterion("RJS13 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs13EqualTo(Integer value) {
            addCriterion("RJS13 =", value, "rjs13");
            return (Criteria) this;
        }

        public Criteria andRjs13NotEqualTo(Integer value) {
            addCriterion("RJS13 <>", value, "rjs13");
            return (Criteria) this;
        }

        public Criteria andRjs13GreaterThan(Integer value) {
            addCriterion("RJS13 >", value, "rjs13");
            return (Criteria) this;
        }

        public Criteria andRjs13GreaterThanOrEqualTo(Integer value) {
            addCriterion("RJS13 >=", value, "rjs13");
            return (Criteria) this;
        }

        public Criteria andRjs13LessThan(Integer value) {
            addCriterion("RJS13 <", value, "rjs13");
            return (Criteria) this;
        }

        public Criteria andRjs13LessThanOrEqualTo(Integer value) {
            addCriterion("RJS13 <=", value, "rjs13");
            return (Criteria) this;
        }

        public Criteria andRjs13In(List<Integer> values) {
            addCriterion("RJS13 in", values, "rjs13");
            return (Criteria) this;
        }

        public Criteria andRjs13NotIn(List<Integer> values) {
            addCriterion("RJS13 not in", values, "rjs13");
            return (Criteria) this;
        }

        public Criteria andRjs13Between(Integer value1, Integer value2) {
            addCriterion("RJS13 between", value1, value2, "rjs13");
            return (Criteria) this;
        }

        public Criteria andRjs13NotBetween(Integer value1, Integer value2) {
            addCriterion("RJS13 not between", value1, value2, "rjs13");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Integer value) {
            addCriterion("UpdateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Integer value) {
            addCriterion("UpdateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Integer value) {
            addCriterion("UpdateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("UpdateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Integer value) {
            addCriterion("UpdateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Integer value) {
            addCriterion("UpdateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Integer> values) {
            addCriterion("UpdateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Integer> values) {
            addCriterion("UpdateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Integer value1, Integer value2) {
            addCriterion("UpdateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("UpdateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andTruetag1IsNull() {
            addCriterion("truetag_1 is null");
            return (Criteria) this;
        }

        public Criteria andTruetag1IsNotNull() {
            addCriterion("truetag_1 is not null");
            return (Criteria) this;
        }

        public Criteria andTruetag1EqualTo(Integer value) {
            addCriterion("truetag_1 =", value, "truetag1");
            return (Criteria) this;
        }

        public Criteria andTruetag1NotEqualTo(Integer value) {
            addCriterion("truetag_1 <>", value, "truetag1");
            return (Criteria) this;
        }

        public Criteria andTruetag1GreaterThan(Integer value) {
            addCriterion("truetag_1 >", value, "truetag1");
            return (Criteria) this;
        }

        public Criteria andTruetag1GreaterThanOrEqualTo(Integer value) {
            addCriterion("truetag_1 >=", value, "truetag1");
            return (Criteria) this;
        }

        public Criteria andTruetag1LessThan(Integer value) {
            addCriterion("truetag_1 <", value, "truetag1");
            return (Criteria) this;
        }

        public Criteria andTruetag1LessThanOrEqualTo(Integer value) {
            addCriterion("truetag_1 <=", value, "truetag1");
            return (Criteria) this;
        }

        public Criteria andTruetag1In(List<Integer> values) {
            addCriterion("truetag_1 in", values, "truetag1");
            return (Criteria) this;
        }

        public Criteria andTruetag1NotIn(List<Integer> values) {
            addCriterion("truetag_1 not in", values, "truetag1");
            return (Criteria) this;
        }

        public Criteria andTruetag1Between(Integer value1, Integer value2) {
            addCriterion("truetag_1 between", value1, value2, "truetag1");
            return (Criteria) this;
        }

        public Criteria andTruetag1NotBetween(Integer value1, Integer value2) {
            addCriterion("truetag_1 not between", value1, value2, "truetag1");
            return (Criteria) this;
        }

        public Criteria andRjs14IsNull() {
            addCriterion("RJS14 is null");
            return (Criteria) this;
        }

        public Criteria andRjs14IsNotNull() {
            addCriterion("RJS14 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs14EqualTo(String value) {
            addCriterion("RJS14 =", value, "rjs14");
            return (Criteria) this;
        }

        public Criteria andRjs14NotEqualTo(String value) {
            addCriterion("RJS14 <>", value, "rjs14");
            return (Criteria) this;
        }

        public Criteria andRjs14GreaterThan(String value) {
            addCriterion("RJS14 >", value, "rjs14");
            return (Criteria) this;
        }

        public Criteria andRjs14GreaterThanOrEqualTo(String value) {
            addCriterion("RJS14 >=", value, "rjs14");
            return (Criteria) this;
        }

        public Criteria andRjs14LessThan(String value) {
            addCriterion("RJS14 <", value, "rjs14");
            return (Criteria) this;
        }

        public Criteria andRjs14LessThanOrEqualTo(String value) {
            addCriterion("RJS14 <=", value, "rjs14");
            return (Criteria) this;
        }

        public Criteria andRjs14Like(String value) {
            addCriterion("RJS14 like", value, "rjs14");
            return (Criteria) this;
        }

        public Criteria andRjs14NotLike(String value) {
            addCriterion("RJS14 not like", value, "rjs14");
            return (Criteria) this;
        }

        public Criteria andRjs14In(List<String> values) {
            addCriterion("RJS14 in", values, "rjs14");
            return (Criteria) this;
        }

        public Criteria andRjs14NotIn(List<String> values) {
            addCriterion("RJS14 not in", values, "rjs14");
            return (Criteria) this;
        }

        public Criteria andRjs14Between(String value1, String value2) {
            addCriterion("RJS14 between", value1, value2, "rjs14");
            return (Criteria) this;
        }

        public Criteria andRjs14NotBetween(String value1, String value2) {
            addCriterion("RJS14 not between", value1, value2, "rjs14");
            return (Criteria) this;
        }

        public Criteria andRjs15IsNull() {
            addCriterion("RJS15 is null");
            return (Criteria) this;
        }

        public Criteria andRjs15IsNotNull() {
            addCriterion("RJS15 is not null");
            return (Criteria) this;
        }

        public Criteria andRjs15EqualTo(String value) {
            addCriterion("RJS15 =", value, "rjs15");
            return (Criteria) this;
        }

        public Criteria andRjs15NotEqualTo(String value) {
            addCriterion("RJS15 <>", value, "rjs15");
            return (Criteria) this;
        }

        public Criteria andRjs15GreaterThan(String value) {
            addCriterion("RJS15 >", value, "rjs15");
            return (Criteria) this;
        }

        public Criteria andRjs15GreaterThanOrEqualTo(String value) {
            addCriterion("RJS15 >=", value, "rjs15");
            return (Criteria) this;
        }

        public Criteria andRjs15LessThan(String value) {
            addCriterion("RJS15 <", value, "rjs15");
            return (Criteria) this;
        }

        public Criteria andRjs15LessThanOrEqualTo(String value) {
            addCriterion("RJS15 <=", value, "rjs15");
            return (Criteria) this;
        }

        public Criteria andRjs15Like(String value) {
            addCriterion("RJS15 like", value, "rjs15");
            return (Criteria) this;
        }

        public Criteria andRjs15NotLike(String value) {
            addCriterion("RJS15 not like", value, "rjs15");
            return (Criteria) this;
        }

        public Criteria andRjs15In(List<String> values) {
            addCriterion("RJS15 in", values, "rjs15");
            return (Criteria) this;
        }

        public Criteria andRjs15NotIn(List<String> values) {
            addCriterion("RJS15 not in", values, "rjs15");
            return (Criteria) this;
        }

        public Criteria andRjs15Between(String value1, String value2) {
            addCriterion("RJS15 between", value1, value2, "rjs15");
            return (Criteria) this;
        }

        public Criteria andRjs15NotBetween(String value1, String value2) {
            addCriterion("RJS15 not between", value1, value2, "rjs15");
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

        public Criteria andMarkTitleIsNull() {
            addCriterion("mark_title is null");
            return (Criteria) this;
        }

        public Criteria andMarkTitleIsNotNull() {
            addCriterion("mark_title is not null");
            return (Criteria) this;
        }

        public Criteria andMarkTitleEqualTo(Integer value) {
            addCriterion("mark_title =", value, "markTitle");
            return (Criteria) this;
        }

        public Criteria andMarkTitleNotEqualTo(Integer value) {
            addCriterion("mark_title <>", value, "markTitle");
            return (Criteria) this;
        }

        public Criteria andMarkTitleGreaterThan(Integer value) {
            addCriterion("mark_title >", value, "markTitle");
            return (Criteria) this;
        }

        public Criteria andMarkTitleGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_title >=", value, "markTitle");
            return (Criteria) this;
        }

        public Criteria andMarkTitleLessThan(Integer value) {
            addCriterion("mark_title <", value, "markTitle");
            return (Criteria) this;
        }

        public Criteria andMarkTitleLessThanOrEqualTo(Integer value) {
            addCriterion("mark_title <=", value, "markTitle");
            return (Criteria) this;
        }

        public Criteria andMarkTitleIn(List<Integer> values) {
            addCriterion("mark_title in", values, "markTitle");
            return (Criteria) this;
        }

        public Criteria andMarkTitleNotIn(List<Integer> values) {
            addCriterion("mark_title not in", values, "markTitle");
            return (Criteria) this;
        }

        public Criteria andMarkTitleBetween(Integer value1, Integer value2) {
            addCriterion("mark_title between", value1, value2, "markTitle");
            return (Criteria) this;
        }

        public Criteria andMarkTitleNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_title not between", value1, value2, "markTitle");
            return (Criteria) this;
        }

        public Criteria andMarkFilenumIsNull() {
            addCriterion("mark_filenum is null");
            return (Criteria) this;
        }

        public Criteria andMarkFilenumIsNotNull() {
            addCriterion("mark_filenum is not null");
            return (Criteria) this;
        }

        public Criteria andMarkFilenumEqualTo(Integer value) {
            addCriterion("mark_filenum =", value, "markFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkFilenumNotEqualTo(Integer value) {
            addCriterion("mark_filenum <>", value, "markFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkFilenumGreaterThan(Integer value) {
            addCriterion("mark_filenum >", value, "markFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkFilenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_filenum >=", value, "markFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkFilenumLessThan(Integer value) {
            addCriterion("mark_filenum <", value, "markFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkFilenumLessThanOrEqualTo(Integer value) {
            addCriterion("mark_filenum <=", value, "markFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkFilenumIn(List<Integer> values) {
            addCriterion("mark_filenum in", values, "markFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkFilenumNotIn(List<Integer> values) {
            addCriterion("mark_filenum not in", values, "markFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkFilenumBetween(Integer value1, Integer value2) {
            addCriterion("mark_filenum between", value1, value2, "markFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkFilenumNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_filenum not between", value1, value2, "markFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkDeptcodeIsNull() {
            addCriterion("mark_deptcode is null");
            return (Criteria) this;
        }

        public Criteria andMarkDeptcodeIsNotNull() {
            addCriterion("mark_deptcode is not null");
            return (Criteria) this;
        }

        public Criteria andMarkDeptcodeEqualTo(Integer value) {
            addCriterion("mark_deptcode =", value, "markDeptcode");
            return (Criteria) this;
        }

        public Criteria andMarkDeptcodeNotEqualTo(Integer value) {
            addCriterion("mark_deptcode <>", value, "markDeptcode");
            return (Criteria) this;
        }

        public Criteria andMarkDeptcodeGreaterThan(Integer value) {
            addCriterion("mark_deptcode >", value, "markDeptcode");
            return (Criteria) this;
        }

        public Criteria andMarkDeptcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_deptcode >=", value, "markDeptcode");
            return (Criteria) this;
        }

        public Criteria andMarkDeptcodeLessThan(Integer value) {
            addCriterion("mark_deptcode <", value, "markDeptcode");
            return (Criteria) this;
        }

        public Criteria andMarkDeptcodeLessThanOrEqualTo(Integer value) {
            addCriterion("mark_deptcode <=", value, "markDeptcode");
            return (Criteria) this;
        }

        public Criteria andMarkDeptcodeIn(List<Integer> values) {
            addCriterion("mark_deptcode in", values, "markDeptcode");
            return (Criteria) this;
        }

        public Criteria andMarkDeptcodeNotIn(List<Integer> values) {
            addCriterion("mark_deptcode not in", values, "markDeptcode");
            return (Criteria) this;
        }

        public Criteria andMarkDeptcodeBetween(Integer value1, Integer value2) {
            addCriterion("mark_deptcode between", value1, value2, "markDeptcode");
            return (Criteria) this;
        }

        public Criteria andMarkDeptcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_deptcode not between", value1, value2, "markDeptcode");
            return (Criteria) this;
        }

        public Criteria andMarkDeptnameIsNull() {
            addCriterion("mark_deptname is null");
            return (Criteria) this;
        }

        public Criteria andMarkDeptnameIsNotNull() {
            addCriterion("mark_deptname is not null");
            return (Criteria) this;
        }

        public Criteria andMarkDeptnameEqualTo(Integer value) {
            addCriterion("mark_deptname =", value, "markDeptname");
            return (Criteria) this;
        }

        public Criteria andMarkDeptnameNotEqualTo(Integer value) {
            addCriterion("mark_deptname <>", value, "markDeptname");
            return (Criteria) this;
        }

        public Criteria andMarkDeptnameGreaterThan(Integer value) {
            addCriterion("mark_deptname >", value, "markDeptname");
            return (Criteria) this;
        }

        public Criteria andMarkDeptnameGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_deptname >=", value, "markDeptname");
            return (Criteria) this;
        }

        public Criteria andMarkDeptnameLessThan(Integer value) {
            addCriterion("mark_deptname <", value, "markDeptname");
            return (Criteria) this;
        }

        public Criteria andMarkDeptnameLessThanOrEqualTo(Integer value) {
            addCriterion("mark_deptname <=", value, "markDeptname");
            return (Criteria) this;
        }

        public Criteria andMarkDeptnameIn(List<Integer> values) {
            addCriterion("mark_deptname in", values, "markDeptname");
            return (Criteria) this;
        }

        public Criteria andMarkDeptnameNotIn(List<Integer> values) {
            addCriterion("mark_deptname not in", values, "markDeptname");
            return (Criteria) this;
        }

        public Criteria andMarkDeptnameBetween(Integer value1, Integer value2) {
            addCriterion("mark_deptname between", value1, value2, "markDeptname");
            return (Criteria) this;
        }

        public Criteria andMarkDeptnameNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_deptname not between", value1, value2, "markDeptname");
            return (Criteria) this;
        }

        public Criteria andMarkReleaseIsNull() {
            addCriterion("mark_release is null");
            return (Criteria) this;
        }

        public Criteria andMarkReleaseIsNotNull() {
            addCriterion("mark_release is not null");
            return (Criteria) this;
        }

        public Criteria andMarkReleaseEqualTo(Integer value) {
            addCriterion("mark_release =", value, "markRelease");
            return (Criteria) this;
        }

        public Criteria andMarkReleaseNotEqualTo(Integer value) {
            addCriterion("mark_release <>", value, "markRelease");
            return (Criteria) this;
        }

        public Criteria andMarkReleaseGreaterThan(Integer value) {
            addCriterion("mark_release >", value, "markRelease");
            return (Criteria) this;
        }

        public Criteria andMarkReleaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_release >=", value, "markRelease");
            return (Criteria) this;
        }

        public Criteria andMarkReleaseLessThan(Integer value) {
            addCriterion("mark_release <", value, "markRelease");
            return (Criteria) this;
        }

        public Criteria andMarkReleaseLessThanOrEqualTo(Integer value) {
            addCriterion("mark_release <=", value, "markRelease");
            return (Criteria) this;
        }

        public Criteria andMarkReleaseIn(List<Integer> values) {
            addCriterion("mark_release in", values, "markRelease");
            return (Criteria) this;
        }

        public Criteria andMarkReleaseNotIn(List<Integer> values) {
            addCriterion("mark_release not in", values, "markRelease");
            return (Criteria) this;
        }

        public Criteria andMarkReleaseBetween(Integer value1, Integer value2) {
            addCriterion("mark_release between", value1, value2, "markRelease");
            return (Criteria) this;
        }

        public Criteria andMarkReleaseNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_release not between", value1, value2, "markRelease");
            return (Criteria) this;
        }

        public Criteria andMarkImpIsNull() {
            addCriterion("mark_imp is null");
            return (Criteria) this;
        }

        public Criteria andMarkImpIsNotNull() {
            addCriterion("mark_imp is not null");
            return (Criteria) this;
        }

        public Criteria andMarkImpEqualTo(Integer value) {
            addCriterion("mark_imp =", value, "markImp");
            return (Criteria) this;
        }

        public Criteria andMarkImpNotEqualTo(Integer value) {
            addCriterion("mark_imp <>", value, "markImp");
            return (Criteria) this;
        }

        public Criteria andMarkImpGreaterThan(Integer value) {
            addCriterion("mark_imp >", value, "markImp");
            return (Criteria) this;
        }

        public Criteria andMarkImpGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_imp >=", value, "markImp");
            return (Criteria) this;
        }

        public Criteria andMarkImpLessThan(Integer value) {
            addCriterion("mark_imp <", value, "markImp");
            return (Criteria) this;
        }

        public Criteria andMarkImpLessThanOrEqualTo(Integer value) {
            addCriterion("mark_imp <=", value, "markImp");
            return (Criteria) this;
        }

        public Criteria andMarkImpIn(List<Integer> values) {
            addCriterion("mark_imp in", values, "markImp");
            return (Criteria) this;
        }

        public Criteria andMarkImpNotIn(List<Integer> values) {
            addCriterion("mark_imp not in", values, "markImp");
            return (Criteria) this;
        }

        public Criteria andMarkImpBetween(Integer value1, Integer value2) {
            addCriterion("mark_imp between", value1, value2, "markImp");
            return (Criteria) this;
        }

        public Criteria andMarkImpNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_imp not between", value1, value2, "markImp");
            return (Criteria) this;
        }

        public Criteria andMarkAttachmentIsNull() {
            addCriterion("mark_attachment is null");
            return (Criteria) this;
        }

        public Criteria andMarkAttachmentIsNotNull() {
            addCriterion("mark_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andMarkAttachmentEqualTo(Integer value) {
            addCriterion("mark_attachment =", value, "markAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkAttachmentNotEqualTo(Integer value) {
            addCriterion("mark_attachment <>", value, "markAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkAttachmentGreaterThan(Integer value) {
            addCriterion("mark_attachment >", value, "markAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkAttachmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_attachment >=", value, "markAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkAttachmentLessThan(Integer value) {
            addCriterion("mark_attachment <", value, "markAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkAttachmentLessThanOrEqualTo(Integer value) {
            addCriterion("mark_attachment <=", value, "markAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkAttachmentIn(List<Integer> values) {
            addCriterion("mark_attachment in", values, "markAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkAttachmentNotIn(List<Integer> values) {
            addCriterion("mark_attachment not in", values, "markAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkAttachmentBetween(Integer value1, Integer value2) {
            addCriterion("mark_attachment between", value1, value2, "markAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkAttachmentNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_attachment not between", value1, value2, "markAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkContentIsNull() {
            addCriterion("mark_content is null");
            return (Criteria) this;
        }

        public Criteria andMarkContentIsNotNull() {
            addCriterion("mark_content is not null");
            return (Criteria) this;
        }

        public Criteria andMarkContentEqualTo(Integer value) {
            addCriterion("mark_content =", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentNotEqualTo(Integer value) {
            addCriterion("mark_content <>", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentGreaterThan(Integer value) {
            addCriterion("mark_content >", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_content >=", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentLessThan(Integer value) {
            addCriterion("mark_content <", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentLessThanOrEqualTo(Integer value) {
            addCriterion("mark_content <=", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentIn(List<Integer> values) {
            addCriterion("mark_content in", values, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentNotIn(List<Integer> values) {
            addCriterion("mark_content not in", values, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentBetween(Integer value1, Integer value2) {
            addCriterion("mark_content between", value1, value2, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_content not between", value1, value2, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentTitleIsNull() {
            addCriterion("mark_content_title is null");
            return (Criteria) this;
        }

        public Criteria andMarkContentTitleIsNotNull() {
            addCriterion("mark_content_title is not null");
            return (Criteria) this;
        }

        public Criteria andMarkContentTitleEqualTo(Integer value) {
            addCriterion("mark_content_title =", value, "markContentTitle");
            return (Criteria) this;
        }

        public Criteria andMarkContentTitleNotEqualTo(Integer value) {
            addCriterion("mark_content_title <>", value, "markContentTitle");
            return (Criteria) this;
        }

        public Criteria andMarkContentTitleGreaterThan(Integer value) {
            addCriterion("mark_content_title >", value, "markContentTitle");
            return (Criteria) this;
        }

        public Criteria andMarkContentTitleGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_content_title >=", value, "markContentTitle");
            return (Criteria) this;
        }

        public Criteria andMarkContentTitleLessThan(Integer value) {
            addCriterion("mark_content_title <", value, "markContentTitle");
            return (Criteria) this;
        }

        public Criteria andMarkContentTitleLessThanOrEqualTo(Integer value) {
            addCriterion("mark_content_title <=", value, "markContentTitle");
            return (Criteria) this;
        }

        public Criteria andMarkContentTitleIn(List<Integer> values) {
            addCriterion("mark_content_title in", values, "markContentTitle");
            return (Criteria) this;
        }

        public Criteria andMarkContentTitleNotIn(List<Integer> values) {
            addCriterion("mark_content_title not in", values, "markContentTitle");
            return (Criteria) this;
        }

        public Criteria andMarkContentTitleBetween(Integer value1, Integer value2) {
            addCriterion("mark_content_title between", value1, value2, "markContentTitle");
            return (Criteria) this;
        }

        public Criteria andMarkContentTitleNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_content_title not between", value1, value2, "markContentTitle");
            return (Criteria) this;
        }

        public Criteria andMarkContentFilenumIsNull() {
            addCriterion("mark_content_filenum is null");
            return (Criteria) this;
        }

        public Criteria andMarkContentFilenumIsNotNull() {
            addCriterion("mark_content_filenum is not null");
            return (Criteria) this;
        }

        public Criteria andMarkContentFilenumEqualTo(Integer value) {
            addCriterion("mark_content_filenum =", value, "markContentFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkContentFilenumNotEqualTo(Integer value) {
            addCriterion("mark_content_filenum <>", value, "markContentFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkContentFilenumGreaterThan(Integer value) {
            addCriterion("mark_content_filenum >", value, "markContentFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkContentFilenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_content_filenum >=", value, "markContentFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkContentFilenumLessThan(Integer value) {
            addCriterion("mark_content_filenum <", value, "markContentFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkContentFilenumLessThanOrEqualTo(Integer value) {
            addCriterion("mark_content_filenum <=", value, "markContentFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkContentFilenumIn(List<Integer> values) {
            addCriterion("mark_content_filenum in", values, "markContentFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkContentFilenumNotIn(List<Integer> values) {
            addCriterion("mark_content_filenum not in", values, "markContentFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkContentFilenumBetween(Integer value1, Integer value2) {
            addCriterion("mark_content_filenum between", value1, value2, "markContentFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkContentFilenumNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_content_filenum not between", value1, value2, "markContentFilenum");
            return (Criteria) this;
        }

        public Criteria andMarkContentContentIsNull() {
            addCriterion("mark_content_content is null");
            return (Criteria) this;
        }

        public Criteria andMarkContentContentIsNotNull() {
            addCriterion("mark_content_content is not null");
            return (Criteria) this;
        }

        public Criteria andMarkContentContentEqualTo(Integer value) {
            addCriterion("mark_content_content =", value, "markContentContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentContentNotEqualTo(Integer value) {
            addCriterion("mark_content_content <>", value, "markContentContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentContentGreaterThan(Integer value) {
            addCriterion("mark_content_content >", value, "markContentContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentContentGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_content_content >=", value, "markContentContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentContentLessThan(Integer value) {
            addCriterion("mark_content_content <", value, "markContentContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentContentLessThanOrEqualTo(Integer value) {
            addCriterion("mark_content_content <=", value, "markContentContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentContentIn(List<Integer> values) {
            addCriterion("mark_content_content in", values, "markContentContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentContentNotIn(List<Integer> values) {
            addCriterion("mark_content_content not in", values, "markContentContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentContentBetween(Integer value1, Integer value2) {
            addCriterion("mark_content_content between", value1, value2, "markContentContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentContentNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_content_content not between", value1, value2, "markContentContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentLkIsNull() {
            addCriterion("mark_content_lk is null");
            return (Criteria) this;
        }

        public Criteria andMarkContentLkIsNotNull() {
            addCriterion("mark_content_lk is not null");
            return (Criteria) this;
        }

        public Criteria andMarkContentLkEqualTo(Integer value) {
            addCriterion("mark_content_lk =", value, "markContentLk");
            return (Criteria) this;
        }

        public Criteria andMarkContentLkNotEqualTo(Integer value) {
            addCriterion("mark_content_lk <>", value, "markContentLk");
            return (Criteria) this;
        }

        public Criteria andMarkContentLkGreaterThan(Integer value) {
            addCriterion("mark_content_lk >", value, "markContentLk");
            return (Criteria) this;
        }

        public Criteria andMarkContentLkGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_content_lk >=", value, "markContentLk");
            return (Criteria) this;
        }

        public Criteria andMarkContentLkLessThan(Integer value) {
            addCriterion("mark_content_lk <", value, "markContentLk");
            return (Criteria) this;
        }

        public Criteria andMarkContentLkLessThanOrEqualTo(Integer value) {
            addCriterion("mark_content_lk <=", value, "markContentLk");
            return (Criteria) this;
        }

        public Criteria andMarkContentLkIn(List<Integer> values) {
            addCriterion("mark_content_lk in", values, "markContentLk");
            return (Criteria) this;
        }

        public Criteria andMarkContentLkNotIn(List<Integer> values) {
            addCriterion("mark_content_lk not in", values, "markContentLk");
            return (Criteria) this;
        }

        public Criteria andMarkContentLkBetween(Integer value1, Integer value2) {
            addCriterion("mark_content_lk between", value1, value2, "markContentLk");
            return (Criteria) this;
        }

        public Criteria andMarkContentLkNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_content_lk not between", value1, value2, "markContentLk");
            return (Criteria) this;
        }

        public Criteria andMarkContentAttachmentIsNull() {
            addCriterion("mark_content_attachment is null");
            return (Criteria) this;
        }

        public Criteria andMarkContentAttachmentIsNotNull() {
            addCriterion("mark_content_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andMarkContentAttachmentEqualTo(Integer value) {
            addCriterion("mark_content_attachment =", value, "markContentAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkContentAttachmentNotEqualTo(Integer value) {
            addCriterion("mark_content_attachment <>", value, "markContentAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkContentAttachmentGreaterThan(Integer value) {
            addCriterion("mark_content_attachment >", value, "markContentAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkContentAttachmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_content_attachment >=", value, "markContentAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkContentAttachmentLessThan(Integer value) {
            addCriterion("mark_content_attachment <", value, "markContentAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkContentAttachmentLessThanOrEqualTo(Integer value) {
            addCriterion("mark_content_attachment <=", value, "markContentAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkContentAttachmentIn(List<Integer> values) {
            addCriterion("mark_content_attachment in", values, "markContentAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkContentAttachmentNotIn(List<Integer> values) {
            addCriterion("mark_content_attachment not in", values, "markContentAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkContentAttachmentBetween(Integer value1, Integer value2) {
            addCriterion("mark_content_attachment between", value1, value2, "markContentAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkContentAttachmentNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_content_attachment not between", value1, value2, "markContentAttachment");
            return (Criteria) this;
        }

        public Criteria andMarkKindIsNull() {
            addCriterion("mark_kind is null");
            return (Criteria) this;
        }

        public Criteria andMarkKindIsNotNull() {
            addCriterion("mark_kind is not null");
            return (Criteria) this;
        }

        public Criteria andMarkKindEqualTo(Integer value) {
            addCriterion("mark_kind =", value, "markKind");
            return (Criteria) this;
        }

        public Criteria andMarkKindNotEqualTo(Integer value) {
            addCriterion("mark_kind <>", value, "markKind");
            return (Criteria) this;
        }

        public Criteria andMarkKindGreaterThan(Integer value) {
            addCriterion("mark_kind >", value, "markKind");
            return (Criteria) this;
        }

        public Criteria andMarkKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_kind >=", value, "markKind");
            return (Criteria) this;
        }

        public Criteria andMarkKindLessThan(Integer value) {
            addCriterion("mark_kind <", value, "markKind");
            return (Criteria) this;
        }

        public Criteria andMarkKindLessThanOrEqualTo(Integer value) {
            addCriterion("mark_kind <=", value, "markKind");
            return (Criteria) this;
        }

        public Criteria andMarkKindIn(List<Integer> values) {
            addCriterion("mark_kind in", values, "markKind");
            return (Criteria) this;
        }

        public Criteria andMarkKindNotIn(List<Integer> values) {
            addCriterion("mark_kind not in", values, "markKind");
            return (Criteria) this;
        }

        public Criteria andMarkKindBetween(Integer value1, Integer value2) {
            addCriterion("mark_kind between", value1, value2, "markKind");
            return (Criteria) this;
        }

        public Criteria andMarkKindNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_kind not between", value1, value2, "markKind");
            return (Criteria) this;
        }

        public Criteria andMarkKeywordIsNull() {
            addCriterion("mark_keyword is null");
            return (Criteria) this;
        }

        public Criteria andMarkKeywordIsNotNull() {
            addCriterion("mark_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andMarkKeywordEqualTo(Integer value) {
            addCriterion("mark_keyword =", value, "markKeyword");
            return (Criteria) this;
        }

        public Criteria andMarkKeywordNotEqualTo(Integer value) {
            addCriterion("mark_keyword <>", value, "markKeyword");
            return (Criteria) this;
        }

        public Criteria andMarkKeywordGreaterThan(Integer value) {
            addCriterion("mark_keyword >", value, "markKeyword");
            return (Criteria) this;
        }

        public Criteria andMarkKeywordGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_keyword >=", value, "markKeyword");
            return (Criteria) this;
        }

        public Criteria andMarkKeywordLessThan(Integer value) {
            addCriterion("mark_keyword <", value, "markKeyword");
            return (Criteria) this;
        }

        public Criteria andMarkKeywordLessThanOrEqualTo(Integer value) {
            addCriterion("mark_keyword <=", value, "markKeyword");
            return (Criteria) this;
        }

        public Criteria andMarkKeywordIn(List<Integer> values) {
            addCriterion("mark_keyword in", values, "markKeyword");
            return (Criteria) this;
        }

        public Criteria andMarkKeywordNotIn(List<Integer> values) {
            addCriterion("mark_keyword not in", values, "markKeyword");
            return (Criteria) this;
        }

        public Criteria andMarkKeywordBetween(Integer value1, Integer value2) {
            addCriterion("mark_keyword between", value1, value2, "markKeyword");
            return (Criteria) this;
        }

        public Criteria andMarkKeywordNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_keyword not between", value1, value2, "markKeyword");
            return (Criteria) this;
        }

        public Criteria andMarkOtherIsNull() {
            addCriterion("mark_other is null");
            return (Criteria) this;
        }

        public Criteria andMarkOtherIsNotNull() {
            addCriterion("mark_other is not null");
            return (Criteria) this;
        }

        public Criteria andMarkOtherEqualTo(Integer value) {
            addCriterion("mark_other =", value, "markOther");
            return (Criteria) this;
        }

        public Criteria andMarkOtherNotEqualTo(Integer value) {
            addCriterion("mark_other <>", value, "markOther");
            return (Criteria) this;
        }

        public Criteria andMarkOtherGreaterThan(Integer value) {
            addCriterion("mark_other >", value, "markOther");
            return (Criteria) this;
        }

        public Criteria andMarkOtherGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_other >=", value, "markOther");
            return (Criteria) this;
        }

        public Criteria andMarkOtherLessThan(Integer value) {
            addCriterion("mark_other <", value, "markOther");
            return (Criteria) this;
        }

        public Criteria andMarkOtherLessThanOrEqualTo(Integer value) {
            addCriterion("mark_other <=", value, "markOther");
            return (Criteria) this;
        }

        public Criteria andMarkOtherIn(List<Integer> values) {
            addCriterion("mark_other in", values, "markOther");
            return (Criteria) this;
        }

        public Criteria andMarkOtherNotIn(List<Integer> values) {
            addCriterion("mark_other not in", values, "markOther");
            return (Criteria) this;
        }

        public Criteria andMarkOtherBetween(Integer value1, Integer value2) {
            addCriterion("mark_other between", value1, value2, "markOther");
            return (Criteria) this;
        }

        public Criteria andMarkOtherNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_other not between", value1, value2, "markOther");
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