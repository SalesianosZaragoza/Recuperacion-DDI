package es.salesianos.model;

public class EmpresaAlumnoDto{
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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
	private String empresa;
	private String nombre;
	private int edad;
	private boolean asisteFCT;



	

	


}
