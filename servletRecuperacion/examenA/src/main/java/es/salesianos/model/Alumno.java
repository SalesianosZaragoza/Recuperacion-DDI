package es.salesianos.model;

public class Alumno {

	private Integer id;
	private String nombre;
	private int edad;
	private boolean asisteFCT;
	private int empresa;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isAsisteFCT() {
		return asisteFCT;
	}
	public void setAsisteFCT(boolean asisteFCT) {
		this.asisteFCT = asisteFCT;
	}
	public int getEmpresa() {
		return empresa;
	}
	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}
	


}
