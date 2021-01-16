package es.salesianos.model;

public class Student {
	
	private Integer id;
	private String name;
	private Integer age;
	private boolean asisteFCT;
	private Integer company;

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

	public Integer getCompany() {
		return company;
	}

	public void setCompany(Integer company) {
		this.company = company;
	}

	public boolean isAsisteFCT() {
		return asisteFCT;
	}

	public void setAsisteFCT(boolean asisteFCT) {
		this.asisteFCT = asisteFCT;
	}

	
	

}
