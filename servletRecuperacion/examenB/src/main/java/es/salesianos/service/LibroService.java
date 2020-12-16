package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Almacen;
import es.salesianos.model.Libro;
import es.salesianos.model.assembler.LibroAssembler;
import es.salesianos.repository.LibroRepository;

public class LibroService {

	private LibroAssembler assembler = new LibroAssembler();
	private LibroRepository repository = new LibroRepository();
	
	public Libro createNewEntityFromRequest(HttpServletRequest req) {
		Libro libro = assembler.assembleFrom(req);
		return libro;
	}
	
	public Libro updateEntityFromRequest(HttpServletRequest req) {
		Libro libro = assembler.assembleFromExistent(req);
		return libro;
	}

	public void insert(Libro libro) {
		repository.insert(libro);
	}
	
	public void update(Libro libro) {
		repository.update(libro);
	}

	public List<Libro> listAll() {
		return repository.listAll();
	}
	
	public Libro findById(Integer id) {
		return repository.findById(id);
	}
	
	public void delete(Libro libro) {
		repository.delete(libro);
	}

}
