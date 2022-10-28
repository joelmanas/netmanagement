package netmanagement.database.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andPhysicaladdressIsNull() {
            addCriterion("physicalAddress is null");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressIsNotNull() {
            addCriterion("physicalAddress is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressEqualTo(String value) {
            addCriterion("physicalAddress =", value, "physicaladdress");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressNotEqualTo(String value) {
            addCriterion("physicalAddress <>", value, "physicaladdress");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressGreaterThan(String value) {
            addCriterion("physicalAddress >", value, "physicaladdress");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressGreaterThanOrEqualTo(String value) {
            addCriterion("physicalAddress >=", value, "physicaladdress");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressLessThan(String value) {
            addCriterion("physicalAddress <", value, "physicaladdress");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressLessThanOrEqualTo(String value) {
            addCriterion("physicalAddress <=", value, "physicaladdress");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressLike(String value) {
            addCriterion("physicalAddress like", value, "physicaladdress");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressNotLike(String value) {
            addCriterion("physicalAddress not like", value, "physicaladdress");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressIn(List<String> values) {
            addCriterion("physicalAddress in", values, "physicaladdress");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressNotIn(List<String> values) {
            addCriterion("physicalAddress not in", values, "physicaladdress");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressBetween(String value1, String value2) {
            addCriterion("physicalAddress between", value1, value2, "physicaladdress");
            return (Criteria) this;
        }

        public Criteria andPhysicaladdressNotBetween(String value1, String value2) {
            addCriterion("physicalAddress not between", value1, value2, "physicaladdress");
            return (Criteria) this;
        }

        public Criteria andIpaddressIsNull() {
            addCriterion("ipAddress is null");
            return (Criteria) this;
        }

        public Criteria andIpaddressIsNotNull() {
            addCriterion("ipAddress is not null");
            return (Criteria) this;
        }

        public Criteria andIpaddressEqualTo(String value) {
            addCriterion("ipAddress =", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotEqualTo(String value) {
            addCriterion("ipAddress <>", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressGreaterThan(String value) {
            addCriterion("ipAddress >", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressGreaterThanOrEqualTo(String value) {
            addCriterion("ipAddress >=", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLessThan(String value) {
            addCriterion("ipAddress <", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLessThanOrEqualTo(String value) {
            addCriterion("ipAddress <=", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLike(String value) {
            addCriterion("ipAddress like", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotLike(String value) {
            addCriterion("ipAddress not like", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressIn(List<String> values) {
            addCriterion("ipAddress in", values, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotIn(List<String> values) {
            addCriterion("ipAddress not in", values, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressBetween(String value1, String value2) {
            addCriterion("ipAddress between", value1, value2, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotBetween(String value1, String value2) {
            addCriterion("ipAddress not between", value1, value2, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andLabelIsNull() {
            addCriterion("label is null");
            return (Criteria) this;
        }

        public Criteria andLabelIsNotNull() {
            addCriterion("label is not null");
            return (Criteria) this;
        }

        public Criteria andLabelEqualTo(String value) {
            addCriterion("label =", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotEqualTo(String value) {
            addCriterion("label <>", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThan(String value) {
            addCriterion("label >", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThanOrEqualTo(String value) {
            addCriterion("label >=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThan(String value) {
            addCriterion("label <", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThanOrEqualTo(String value) {
            addCriterion("label <=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLike(String value) {
            addCriterion("label like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotLike(String value) {
            addCriterion("label not like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelIn(List<String> values) {
            addCriterion("label in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotIn(List<String> values) {
            addCriterion("label not in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelBetween(String value1, String value2) {
            addCriterion("label between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotBetween(String value1, String value2) {
            addCriterion("label not between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andTrustIsNull() {
            addCriterion("trust is null");
            return (Criteria) this;
        }

        public Criteria andTrustIsNotNull() {
            addCriterion("trust is not null");
            return (Criteria) this;
        }

        public Criteria andTrustEqualTo(Boolean value) {
            addCriterion("trust =", value, "trust");
            return (Criteria) this;
        }

        public Criteria andTrustNotEqualTo(Boolean value) {
            addCriterion("trust <>", value, "trust");
            return (Criteria) this;
        }

        public Criteria andTrustGreaterThan(Boolean value) {
            addCriterion("trust >", value, "trust");
            return (Criteria) this;
        }

        public Criteria andTrustGreaterThanOrEqualTo(Boolean value) {
            addCriterion("trust >=", value, "trust");
            return (Criteria) this;
        }

        public Criteria andTrustLessThan(Boolean value) {
            addCriterion("trust <", value, "trust");
            return (Criteria) this;
        }

        public Criteria andTrustLessThanOrEqualTo(Boolean value) {
            addCriterion("trust <=", value, "trust");
            return (Criteria) this;
        }

        public Criteria andTrustIn(List<Boolean> values) {
            addCriterion("trust in", values, "trust");
            return (Criteria) this;
        }

        public Criteria andTrustNotIn(List<Boolean> values) {
            addCriterion("trust not in", values, "trust");
            return (Criteria) this;
        }

        public Criteria andTrustBetween(Boolean value1, Boolean value2) {
            addCriterion("trust between", value1, value2, "trust");
            return (Criteria) this;
        }

        public Criteria andTrustNotBetween(Boolean value1, Boolean value2) {
            addCriterion("trust not between", value1, value2, "trust");
            return (Criteria) this;
        }

        public Criteria andRemoveIsNull() {
            addCriterion("remove is null");
            return (Criteria) this;
        }

        public Criteria andRemoveIsNotNull() {
            addCriterion("remove is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveEqualTo(Boolean value) {
            addCriterion("remove =", value, "remove");
            return (Criteria) this;
        }

        public Criteria andRemoveNotEqualTo(Boolean value) {
            addCriterion("remove <>", value, "remove");
            return (Criteria) this;
        }

        public Criteria andRemoveGreaterThan(Boolean value) {
            addCriterion("remove >", value, "remove");
            return (Criteria) this;
        }

        public Criteria andRemoveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("remove >=", value, "remove");
            return (Criteria) this;
        }

        public Criteria andRemoveLessThan(Boolean value) {
            addCriterion("remove <", value, "remove");
            return (Criteria) this;
        }

        public Criteria andRemoveLessThanOrEqualTo(Boolean value) {
            addCriterion("remove <=", value, "remove");
            return (Criteria) this;
        }

        public Criteria andRemoveIn(List<Boolean> values) {
            addCriterion("remove in", values, "remove");
            return (Criteria) this;
        }

        public Criteria andRemoveNotIn(List<Boolean> values) {
            addCriterion("remove not in", values, "remove");
            return (Criteria) this;
        }

        public Criteria andRemoveBetween(Boolean value1, Boolean value2) {
            addCriterion("remove between", value1, value2, "remove");
            return (Criteria) this;
        }

        public Criteria andRemoveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("remove not between", value1, value2, "remove");
            return (Criteria) this;
        }

        public Criteria andUpdatedatIsNull() {
            addCriterion("updatedAt is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedatIsNotNull() {
            addCriterion("updatedAt is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedatEqualTo(Date value) {
            addCriterion("updatedAt =", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatNotEqualTo(Date value) {
            addCriterion("updatedAt <>", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatGreaterThan(Date value) {
            addCriterion("updatedAt >", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatGreaterThanOrEqualTo(Date value) {
            addCriterion("updatedAt >=", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatLessThan(Date value) {
            addCriterion("updatedAt <", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatLessThanOrEqualTo(Date value) {
            addCriterion("updatedAt <=", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatIn(List<Date> values) {
            addCriterion("updatedAt in", values, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatNotIn(List<Date> values) {
            addCriterion("updatedAt not in", values, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatBetween(Date value1, Date value2) {
            addCriterion("updatedAt between", value1, value2, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatNotBetween(Date value1, Date value2) {
            addCriterion("updatedAt not between", value1, value2, "updatedat");
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