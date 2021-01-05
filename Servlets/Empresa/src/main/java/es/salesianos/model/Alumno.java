package es.salesianos.model;

public class Alumno {
	
	private Integer id;
	private String name;
	private Integer edad;
	private boolean asisteFCT;
	private Integer empresa;

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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public boolean isAsisteFCT() {
		return asisteFCT;
	}

	public void setAsisteFCT(boolean asisteFCT) {
		this.asisteFCT = asisteFCT;
	}

	
	

}
