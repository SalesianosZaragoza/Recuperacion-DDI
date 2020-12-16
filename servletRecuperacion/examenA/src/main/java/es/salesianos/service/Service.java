package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Alumno;
import es.salesianos.model.Empresa;
import es.salesianos.model.EmpresaAlumnoDto;
import es.salesianos.repository.Repository;

public class Service {

private Repository repository = new Repository();
	
	
	
	public void insert(Empresa empresa) {
		repository.insert(empresa);
	}

	public Empresa getEmpresa() {
		return repository.getEmpresa();
	}

	public void insert(Alumno alumno) {	
		repository.insert(alumno);
	}

	public List<EmpresaAlumnoDto> listDto() {
		return repository.listAllDto();
	}

	public void updateAlumno(Alumno a) {
		 repository.updateAlumno(a);
		
	}

}
