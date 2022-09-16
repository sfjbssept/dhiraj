package com.student.app.entity;

public class Student {
	public String schoolName;
	public String className;
	
	public Student(String schoolName, String className) {
		super();
		this.schoolName = schoolName;
		this.className = className;
	}
	
	
	public String getSchoolName() {
		return schoolName;
	}


	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	
}
