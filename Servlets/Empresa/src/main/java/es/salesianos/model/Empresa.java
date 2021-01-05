package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private Integer id;
	private String name;
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	public List<Alumno> getAlumno() {
		return alumnos;
	}
	public void setAlumno(List<Alumno> alumnos) {
		this.alumnos = alumnos;
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
