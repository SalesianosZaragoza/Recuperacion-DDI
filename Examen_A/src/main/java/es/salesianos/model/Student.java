package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private boolean assistsFCT;

	private Integer business;
	private Business businessobj;
	
	public Student(String name, Integer age, boolean assistFCT, Integer business) {
		setName(name);
		setAge(age);
		setAssistsFCT(assistsFCT);
		setBusiness(business);
	}
	
	public Student(Integer id, String name, Integer age, boolean assistFCT, Integer business) {
		this(name, age, assistFCT, business);
		setId(id);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean isAssistsFCT() {
		return assistsFCT;
	}

	public void setAssistsFCT(boolean assistsFCT) {
		this.assistsFCT = assistsFCT;
	}

	public Integer getBusiness() {
		return business;
	}

	public void setBusiness(Integer business) {
		this.business = business;
	}

	public Business getBusinessobj() {
		return businessobj;
	}

	public void setBusinessobj(Business businessobj) {
		this.businessobj = businessobj;
	}
}
