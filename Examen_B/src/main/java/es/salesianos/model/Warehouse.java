package es.salesianos.model;

import java.util.List;

public class Warehouse {

	private Integer id;
	private String name;
	private boolean isOld;
	private String tipo;
	
	private List<Book> books;
	
	public Warehouse(String name, boolean isOld) {
		setName(name);
		setOld(isOld);
	}
	
	public Warehouse(Integer id, String name, boolean isOld) {
		this(name, isOld);
		setId(id);
	}
	
	public Warehouse() {

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
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
