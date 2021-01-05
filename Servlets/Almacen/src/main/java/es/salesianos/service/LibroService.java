package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Libro;
import es.salesianos.model.assembler.LibroAssembler;
import es.salesianos.repository.Repository;

public class LibroService {

	private Repository repository = new Repository();
	
	
	public Libro assemblePetFromRequest(HttpServletRequest req) {
		return LibroAssembler.assembleLibroFrom(req);
	}
	
	public void addLibro(Libro libro) {
		repository.insert(libro);
		
	}
}
