package models;

public class Alumn {

	private String name;
	private Integer age;
	private boolean fct;
	private Integer enterprise;
	private String asistFct;

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

	public boolean isFct() {
		return fct;
	}

	public void setFct(boolean fct) {
		this.fct = fct;
	}

	public Integer getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Integer enterprise) {
		this.enterprise = enterprise;
	}

	public String getAsistFct() {
		if (isFct())
			asistFct = "si";
		else
			asistFct = "no";
		return asistFct;
	}

	public void setAsistFct(String asisteFct) {
		this.asistFct = asisteFct;
		if (this.asistFct == "no")
			this.fct = false;
		else
			this.fct = true;
	}

}
