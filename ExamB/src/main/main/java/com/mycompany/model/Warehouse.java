package com.mycompany.model;

import java.util.List;

public class Warehouse {
	
	private Integer id;
	private String Name;
	private boolean isOld;

	List<Book> books;
public Almacen(String name, boolean isOld) {
		setName(name);
		setOld(isOld);
	}

	public Almacen(Integer id, String name, boolean isOld) {
		this(name, isOld);
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

	public boolean isOld() {
		return isOld;
	}

	public void setOld(boolean isOld) {
		this.isOld = isOld;
	}

	public List<Book> getBooks() {
		return libros;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
