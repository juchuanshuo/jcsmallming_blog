package com.myBlog.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ContentExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ContentExample() {
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andContentIdIsNull() {
			addCriterion("content_id is null");
			return (Criteria) this;
		}

		public Criteria andContentIdIsNotNull() {
			addCriterion("content_id is not null");
			return (Criteria) this;
		}

		public Criteria andContentIdEqualTo(Integer value) {
			addCriterion("content_id =", value, "contentId");
			return (Criteria) this;
		}

		public Criteria andContentIdNotEqualTo(Integer value) {
			addCriterion("content_id <>", value, "contentId");
			return (Criteria) this;
		}

		public Criteria andContentIdGreaterThan(Integer value) {
			addCriterion("content_id >", value, "contentId");
			return (Criteria) this;
		}

		public Criteria andContentIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("content_id >=", value, "contentId");
			return (Criteria) this;
		}

		public Criteria andContentIdLessThan(Integer value) {
			addCriterion("content_id <", value, "contentId");
			return (Criteria) this;
		}

		public Criteria andContentIdLessThanOrEqualTo(Integer value) {
			addCriterion("content_id <=", value, "contentId");
			return (Criteria) this;
		}

		public Criteria andContentIdIn(List<Integer> values) {
			addCriterion("content_id in", values, "contentId");
			return (Criteria) this;
		}

		public Criteria andContentIdNotIn(List<Integer> values) {
			addCriterion("content_id not in", values, "contentId");
			return (Criteria) this;
		}

		public Criteria andContentIdBetween(Integer value1, Integer value2) {
			addCriterion("content_id between", value1, value2, "contentId");
			return (Criteria) this;
		}

		public Criteria andContentIdNotBetween(Integer value1, Integer value2) {
			addCriterion("content_id not between", value1, value2, "contentId");
			return (Criteria) this;
		}

		public Criteria andContentTypeIsNull() {
			addCriterion("content_type is null");
			return (Criteria) this;
		}

		public Criteria andContentTypeIsNotNull() {
			addCriterion("content_type is not null");
			return (Criteria) this;
		}

		public Criteria andContentTypeEqualTo(Integer value) {
			addCriterion("content_type =", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotEqualTo(Integer value) {
			addCriterion("content_type <>", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeGreaterThan(Integer value) {
			addCriterion("content_type >", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("content_type >=", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeLessThan(Integer value) {
			addCriterion("content_type <", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeLessThanOrEqualTo(Integer value) {
			addCriterion("content_type <=", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeIn(List<Integer> values) {
			addCriterion("content_type in", values, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotIn(List<Integer> values) {
			addCriterion("content_type not in", values, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeBetween(Integer value1, Integer value2) {
			addCriterion("content_type between", value1, value2, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("content_type not between", value1, value2, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentNameIsNull() {
			addCriterion("content_name is null");
			return (Criteria) this;
		}

		public Criteria andContentNameIsNotNull() {
			addCriterion("content_name is not null");
			return (Criteria) this;
		}

		public Criteria andContentNameEqualTo(String value) {
			addCriterion("content_name =", value, "contentName");
			return (Criteria) this;
		}

		public Criteria andContentNameNotEqualTo(String value) {
			addCriterion("content_name <>", value, "contentName");
			return (Criteria) this;
		}

		public Criteria andContentNameGreaterThan(String value) {
			addCriterion("content_name >", value, "contentName");
			return (Criteria) this;
		}

		public Criteria andContentNameGreaterThanOrEqualTo(String value) {
			addCriterion("content_name >=", value, "contentName");
			return (Criteria) this;
		}

		public Criteria andContentNameLessThan(String value) {
			addCriterion("content_name <", value, "contentName");
			return (Criteria) this;
		}

		public Criteria andContentNameLessThanOrEqualTo(String value) {
			addCriterion("content_name <=", value, "contentName");
			return (Criteria) this;
		}

		public Criteria andContentNameLike(String value) {
			addCriterion("content_name like", value, "contentName");
			return (Criteria) this;
		}

		public Criteria andContentNameNotLike(String value) {
			addCriterion("content_name not like", value, "contentName");
			return (Criteria) this;
		}

		public Criteria andContentNameIn(List<String> values) {
			addCriterion("content_name in", values, "contentName");
			return (Criteria) this;
		}

		public Criteria andContentNameNotIn(List<String> values) {
			addCriterion("content_name not in", values, "contentName");
			return (Criteria) this;
		}

		public Criteria andContentNameBetween(String value1, String value2) {
			addCriterion("content_name between", value1, value2, "contentName");
			return (Criteria) this;
		}

		public Criteria andContentNameNotBetween(String value1, String value2) {
			addCriterion("content_name not between", value1, value2, "contentName");
			return (Criteria) this;
		}

		public Criteria andTinyImgIsNull() {
			addCriterion("tiny_img is null");
			return (Criteria) this;
		}

		public Criteria andTinyImgIsNotNull() {
			addCriterion("tiny_img is not null");
			return (Criteria) this;
		}

		public Criteria andTinyImgEqualTo(String value) {
			addCriterion("tiny_img =", value, "tinyImg");
			return (Criteria) this;
		}

		public Criteria andTinyImgNotEqualTo(String value) {
			addCriterion("tiny_img <>", value, "tinyImg");
			return (Criteria) this;
		}

		public Criteria andTinyImgGreaterThan(String value) {
			addCriterion("tiny_img >", value, "tinyImg");
			return (Criteria) this;
		}

		public Criteria andTinyImgGreaterThanOrEqualTo(String value) {
			addCriterion("tiny_img >=", value, "tinyImg");
			return (Criteria) this;
		}

		public Criteria andTinyImgLessThan(String value) {
			addCriterion("tiny_img <", value, "tinyImg");
			return (Criteria) this;
		}

		public Criteria andTinyImgLessThanOrEqualTo(String value) {
			addCriterion("tiny_img <=", value, "tinyImg");
			return (Criteria) this;
		}

		public Criteria andTinyImgLike(String value) {
			addCriterion("tiny_img like", value, "tinyImg");
			return (Criteria) this;
		}

		public Criteria andTinyImgNotLike(String value) {
			addCriterion("tiny_img not like", value, "tinyImg");
			return (Criteria) this;
		}

		public Criteria andTinyImgIn(List<String> values) {
			addCriterion("tiny_img in", values, "tinyImg");
			return (Criteria) this;
		}

		public Criteria andTinyImgNotIn(List<String> values) {
			addCriterion("tiny_img not in", values, "tinyImg");
			return (Criteria) this;
		}

		public Criteria andTinyImgBetween(String value1, String value2) {
			addCriterion("tiny_img between", value1, value2, "tinyImg");
			return (Criteria) this;
		}

		public Criteria andTinyImgNotBetween(String value1, String value2) {
			addCriterion("tiny_img not between", value1, value2, "tinyImg");
			return (Criteria) this;
		}

		public Criteria andPageviewsIsNull() {
			addCriterion("pageviews is null");
			return (Criteria) this;
		}

		public Criteria andPageviewsIsNotNull() {
			addCriterion("pageviews is not null");
			return (Criteria) this;
		}

		public Criteria andPageviewsEqualTo(Integer value) {
			addCriterion("pageviews =", value, "pageviews");
			return (Criteria) this;
		}

		public Criteria andPageviewsNotEqualTo(Integer value) {
			addCriterion("pageviews <>", value, "pageviews");
			return (Criteria) this;
		}

		public Criteria andPageviewsGreaterThan(Integer value) {
			addCriterion("pageviews >", value, "pageviews");
			return (Criteria) this;
		}

		public Criteria andPageviewsGreaterThanOrEqualTo(Integer value) {
			addCriterion("pageviews >=", value, "pageviews");
			return (Criteria) this;
		}

		public Criteria andPageviewsLessThan(Integer value) {
			addCriterion("pageviews <", value, "pageviews");
			return (Criteria) this;
		}

		public Criteria andPageviewsLessThanOrEqualTo(Integer value) {
			addCriterion("pageviews <=", value, "pageviews");
			return (Criteria) this;
		}

		public Criteria andPageviewsIn(List<Integer> values) {
			addCriterion("pageviews in", values, "pageviews");
			return (Criteria) this;
		}

		public Criteria andPageviewsNotIn(List<Integer> values) {
			addCriterion("pageviews not in", values, "pageviews");
			return (Criteria) this;
		}

		public Criteria andPageviewsBetween(Integer value1, Integer value2) {
			addCriterion("pageviews between", value1, value2, "pageviews");
			return (Criteria) this;
		}

		public Criteria andPageviewsNotBetween(Integer value1, Integer value2) {
			addCriterion("pageviews not between", value1, value2, "pageviews");
			return (Criteria) this;
		}

		public Criteria andContenStateIsNull() {
			addCriterion("conten_state is null");
			return (Criteria) this;
		}

		public Criteria andContenStateIsNotNull() {
			addCriterion("conten_state is not null");
			return (Criteria) this;
		}

		public Criteria andContenStateEqualTo(Integer value) {
			addCriterion("conten_state =", value, "contenState");
			return (Criteria) this;
		}

		public Criteria andContenStateNotEqualTo(Integer value) {
			addCriterion("conten_state <>", value, "contenState");
			return (Criteria) this;
		}

		public Criteria andContenStateGreaterThan(Integer value) {
			addCriterion("conten_state >", value, "contenState");
			return (Criteria) this;
		}

		public Criteria andContenStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("conten_state >=", value, "contenState");
			return (Criteria) this;
		}

		public Criteria andContenStateLessThan(Integer value) {
			addCriterion("conten_state <", value, "contenState");
			return (Criteria) this;
		}

		public Criteria andContenStateLessThanOrEqualTo(Integer value) {
			addCriterion("conten_state <=", value, "contenState");
			return (Criteria) this;
		}

		public Criteria andContenStateIn(List<Integer> values) {
			addCriterion("conten_state in", values, "contenState");
			return (Criteria) this;
		}

		public Criteria andContenStateNotIn(List<Integer> values) {
			addCriterion("conten_state not in", values, "contenState");
			return (Criteria) this;
		}

		public Criteria andContenStateBetween(Integer value1, Integer value2) {
			addCriterion("conten_state between", value1, value2, "contenState");
			return (Criteria) this;
		}

		public Criteria andContenStateNotBetween(Integer value1, Integer value2) {
			addCriterion("conten_state not between", value1, value2, "contenState");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterionForJDBCDate("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterionForJDBCDate("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterionForJDBCDate("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andSummaryIsNull() {
			addCriterion("summary is null");
			return (Criteria) this;
		}

		public Criteria andSummaryIsNotNull() {
			addCriterion("summary is not null");
			return (Criteria) this;
		}

		public Criteria andSummaryEqualTo(String value) {
			addCriterion("summary =", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryNotEqualTo(String value) {
			addCriterion("summary <>", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryGreaterThan(String value) {
			addCriterion("summary >", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryGreaterThanOrEqualTo(String value) {
			addCriterion("summary >=", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryLessThan(String value) {
			addCriterion("summary <", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryLessThanOrEqualTo(String value) {
			addCriterion("summary <=", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryLike(String value) {
			addCriterion("summary like", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryNotLike(String value) {
			addCriterion("summary not like", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryIn(List<String> values) {
			addCriterion("summary in", values, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryNotIn(List<String> values) {
			addCriterion("summary not in", values, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryBetween(String value1, String value2) {
			addCriterion("summary between", value1, value2, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryNotBetween(String value1, String value2) {
			addCriterion("summary not between", value1, value2, "summary");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterionForJDBCDate("update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterionForJDBCDate("update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterionForJDBCDate("update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("update_time not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andAuthorIsNull() {
			addCriterion("author is null");
			return (Criteria) this;
		}

		public Criteria andAuthorIsNotNull() {
			addCriterion("author is not null");
			return (Criteria) this;
		}

		public Criteria andAuthorEqualTo(String value) {
			addCriterion("author =", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorNotEqualTo(String value) {
			addCriterion("author <>", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorGreaterThan(String value) {
			addCriterion("author >", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorGreaterThanOrEqualTo(String value) {
			addCriterion("author >=", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorLessThan(String value) {
			addCriterion("author <", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorLessThanOrEqualTo(String value) {
			addCriterion("author <=", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorLike(String value) {
			addCriterion("author like", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorNotLike(String value) {
			addCriterion("author not like", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorIn(List<String> values) {
			addCriterion("author in", values, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorNotIn(List<String> values) {
			addCriterion("author not in", values, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorBetween(String value1, String value2) {
			addCriterion("author between", value1, value2, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorNotBetween(String value1, String value2) {
			addCriterion("author not between", value1, value2, "author");
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