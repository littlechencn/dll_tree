package cn.littlechen.dlltree.model;

import java.util.ArrayList;
import java.util.List;

public class TWineDllFileContainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TWineDllFileContainExample() {
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

        public Criteria andDllNameIsNull() {
            addCriterion("dll_name is null");
            return (Criteria) this;
        }

        public Criteria andDllNameIsNotNull() {
            addCriterion("dll_name is not null");
            return (Criteria) this;
        }

        public Criteria andDllNameEqualTo(String value) {
            addCriterion("dll_name =", value, "dllName");
            return (Criteria) this;
        }

        public Criteria andDllNameNotEqualTo(String value) {
            addCriterion("dll_name <>", value, "dllName");
            return (Criteria) this;
        }

        public Criteria andDllNameGreaterThan(String value) {
            addCriterion("dll_name >", value, "dllName");
            return (Criteria) this;
        }

        public Criteria andDllNameGreaterThanOrEqualTo(String value) {
            addCriterion("dll_name >=", value, "dllName");
            return (Criteria) this;
        }

        public Criteria andDllNameLessThan(String value) {
            addCriterion("dll_name <", value, "dllName");
            return (Criteria) this;
        }

        public Criteria andDllNameLessThanOrEqualTo(String value) {
            addCriterion("dll_name <=", value, "dllName");
            return (Criteria) this;
        }

        public Criteria andDllNameLike(String value) {
            addCriterion("dll_name like", value, "dllName");
            return (Criteria) this;
        }

        public Criteria andDllNameNotLike(String value) {
            addCriterion("dll_name not like", value, "dllName");
            return (Criteria) this;
        }

        public Criteria andDllNameIn(List<String> values) {
            addCriterion("dll_name in", values, "dllName");
            return (Criteria) this;
        }

        public Criteria andDllNameNotIn(List<String> values) {
            addCriterion("dll_name not in", values, "dllName");
            return (Criteria) this;
        }

        public Criteria andDllNameBetween(String value1, String value2) {
            addCriterion("dll_name between", value1, value2, "dllName");
            return (Criteria) this;
        }

        public Criteria andDllNameNotBetween(String value1, String value2) {
            addCriterion("dll_name not between", value1, value2, "dllName");
            return (Criteria) this;
        }

        public Criteria andFClassIsNull() {
            addCriterion("f_class is null");
            return (Criteria) this;
        }

        public Criteria andFClassIsNotNull() {
            addCriterion("f_class is not null");
            return (Criteria) this;
        }

        public Criteria andFClassEqualTo(String value) {
            addCriterion("f_class =", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassNotEqualTo(String value) {
            addCriterion("f_class <>", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassGreaterThan(String value) {
            addCriterion("f_class >", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassGreaterThanOrEqualTo(String value) {
            addCriterion("f_class >=", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassLessThan(String value) {
            addCriterion("f_class <", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassLessThanOrEqualTo(String value) {
            addCriterion("f_class <=", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassLike(String value) {
            addCriterion("f_class like", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassNotLike(String value) {
            addCriterion("f_class not like", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassIn(List<String> values) {
            addCriterion("f_class in", values, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassNotIn(List<String> values) {
            addCriterion("f_class not in", values, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassBetween(String value1, String value2) {
            addCriterion("f_class between", value1, value2, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassNotBetween(String value1, String value2) {
            addCriterion("f_class not between", value1, value2, "fClass");
            return (Criteria) this;
        }

        public Criteria andFPathIsNull() {
            addCriterion("f_path is null");
            return (Criteria) this;
        }

        public Criteria andFPathIsNotNull() {
            addCriterion("f_path is not null");
            return (Criteria) this;
        }

        public Criteria andFPathEqualTo(String value) {
            addCriterion("f_path =", value, "fPath");
            return (Criteria) this;
        }

        public Criteria andFPathNotEqualTo(String value) {
            addCriterion("f_path <>", value, "fPath");
            return (Criteria) this;
        }

        public Criteria andFPathGreaterThan(String value) {
            addCriterion("f_path >", value, "fPath");
            return (Criteria) this;
        }

        public Criteria andFPathGreaterThanOrEqualTo(String value) {
            addCriterion("f_path >=", value, "fPath");
            return (Criteria) this;
        }

        public Criteria andFPathLessThan(String value) {
            addCriterion("f_path <", value, "fPath");
            return (Criteria) this;
        }

        public Criteria andFPathLessThanOrEqualTo(String value) {
            addCriterion("f_path <=", value, "fPath");
            return (Criteria) this;
        }

        public Criteria andFPathLike(String value) {
            addCriterion("f_path like", value, "fPath");
            return (Criteria) this;
        }

        public Criteria andFPathNotLike(String value) {
            addCriterion("f_path not like", value, "fPath");
            return (Criteria) this;
        }

        public Criteria andFPathIn(List<String> values) {
            addCriterion("f_path in", values, "fPath");
            return (Criteria) this;
        }

        public Criteria andFPathNotIn(List<String> values) {
            addCriterion("f_path not in", values, "fPath");
            return (Criteria) this;
        }

        public Criteria andFPathBetween(String value1, String value2) {
            addCriterion("f_path between", value1, value2, "fPath");
            return (Criteria) this;
        }

        public Criteria andFPathNotBetween(String value1, String value2) {
            addCriterion("f_path not between", value1, value2, "fPath");
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