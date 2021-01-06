package es.salesianos.model;

import java.util.List;

public class Business {

	private Integer id;
	private String name;
	
	public Business(String name) {
		setName(name);
	}
	
	public Business(Integer id, String name) {
		this(name);
		setId(id);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
