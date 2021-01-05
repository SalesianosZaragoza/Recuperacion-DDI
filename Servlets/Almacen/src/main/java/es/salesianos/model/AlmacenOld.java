package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

public class AlmacenOld {
	
	private Integer id;
	private String nombre;
	private List<Libro> libros = new ArrayList<Libro>();
	
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return nombre;
	}
	public void setName(String name) {
		this.nombre = name;
	}
	

}
