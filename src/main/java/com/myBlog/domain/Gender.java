package com.myBlog.domain;

public class Gender {
	private Integer gender;

	private String genderName;

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName == null ? null : genderName.trim();
	}
}