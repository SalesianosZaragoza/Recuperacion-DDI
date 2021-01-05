package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Alumno;
import es.salesianos.model.assembler.AlumnoAssembler;
import es.salesianos.repository.Repository;

public class AlumnoService {

	private Repository repository = new Repository();
	
	
	public Alumno assemblePetFromRequest(HttpServletRequest req) {
		return AlumnoAssembler.assembleAlumnoFrom(req);
	}
	
	public void addAlumno(Alumno alumno) {
		repository.insert(alumno);
		
	}
	
	public void update(Alumno alumno) {
		repository.update(alumno);
		
	}
	
	public Alumno search(Integer codOwner) {
		return repository.search(codOwner);
		
	}
}
