package es.salesianos.model;



public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private boolean assistsFCT;
	
	public Student(String name, Integer age, boolean assistFCT) {
		setName(name);
		setAge(age);
		setAssistsFCT(assistsFCT);
		
	}
	
	public Student(Integer id, String name, Integer age, boolean assistFCT) {
		this(name, age, assistFCT);
		setId(id);
	}
	
	public Student() {
		
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

}
