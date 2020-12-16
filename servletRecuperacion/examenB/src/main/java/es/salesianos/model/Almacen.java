package es.salesianos.model;

import java.util.List;

public class Almacen {

	private Integer id;
	private String name;
	private boolean isOld;

	List<Libro> libros;
	
	public Almacen() { }
	
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
	
	public List<Libro> getLibros() {
		return libros;
	}
	
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
}
