package es.salesianos.model;

public class Character {

	private Integer id;
	private String name;
	private Integer age ;
	private Boolean holder;
	
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
	
	public Boolean getHolder() {
		return holder;
	}
	
	public void setHolder(Boolean holder) {
		this.holder = holder;
	}
	
	public void switchHolder() {
		this.holder = !this.holder;
	}
	
}
