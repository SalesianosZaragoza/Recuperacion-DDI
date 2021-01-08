package com.mycompany.model;

public class Student {
	private Integer id;
	private String name_student;
	private Integer age;
	private boolean FCT_asists;
	private Integer company;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName_student() {
		return name_student;
	}
	public void setName_student(String name_student) {
		this.name_student = name_student;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public boolean isFCT_asists() {
		return FCT_asists;
	}
	public void setFCT_asists(boolean fCT_asists) {
		FCT_asists = fCT_asists;
	}
	public Integer getCompany(){
		return company;
	}
	public void setCompany(Integer company){
		this.company = company;
	}
	
	public Student(Integer id, String name_student, Integer age, boolean fCT_asists) {
		super();
		this.id = id;
		this.name_student = name_student;
		this.age = age;
		FCT_asists = fCT_asists;
		this.company = company;
	}
	

}
