package es.salesianos.model;

public class Company {
	private Integer id;
	private String name;
	
	
	public Company(String name) {
		setName(name);
	}
	
	public Company(Integer id, String name) {
		this(name);
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

}
