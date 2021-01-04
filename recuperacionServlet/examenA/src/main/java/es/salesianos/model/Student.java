package es.salesianos.model;

public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private boolean asistCT;
	private Integer company;
	
	private Company objCompany;
	
		
	public Student(String name, Integer age, boolean asistFCT, Integer company) {
		setName(name);
		setAge(age);
		setAsistFCT(asistFCT);
		setCompany(company);
	}
	
	public Student(Integer id, String name, Integer age, boolean asistFCT, Integer company) {
		this(name, age, asistFCT, company);
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
	public boolean isAsistFCT() {
		return asistCT;
	}
	public void setAsistFCT(boolean asistFCT) {
		this.asistCT = asistFCT;
	}
	public Integer getCompany() {
		return company;
	}
	public void setCompany(Integer company) {
		this.company = company;
	}

	public Company getObjCompany() {
		return objCompany;
	}

	public void setObjCompany(Company objCompany) {
		this.objCompany = objCompany;
	}

}
