package com.myBlog.domain;

import java.util.Date;

public class Content {
	private Integer contentId;

	private Integer contentType;

	private String contentName;

	private String tinyImg;

	private Integer pageviews;

	private Integer contenState;

	private Date createTime;

	private String summary;

	private Date updateTime;

	private String author;

	private String content;

	// 中文的文章类型
	private String typeName;
	// 字符串格式的时间
	private String date;

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName == null ? null : contentName.trim();
	}

	public String getTinyImg() {
		return tinyImg;
	}

	public void setTinyImg(String tinyImg) {
		this.tinyImg = tinyImg == null ? null : tinyImg.trim();
	}

	public Integer getPageviews() {
		return pageviews;
	}

	public void setPageviews(Integer pageviews) {
		this.pageviews = pageviews;
	}

	public Integer getContenState() {
		return contenState;
	}

	public void setContenState(Integer contenState) {
		this.contenState = contenState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary == null ? null : summary.trim();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}