package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Almacen;
import es.salesianos.model.Libro;
import es.salesianos.model.assembler.AlmacenAssembler;
import es.salesianos.repository.AlmacenRepository;

public class AlmacenService {

	private AlmacenAssembler assembler = new AlmacenAssembler();
	private AlmacenRepository repository = new AlmacenRepository();
	
	public Almacen createNewEntityFromRequest(HttpServletRequest req) {
		Almacen almacen = assembler.assembleFrom(req);
		return almacen;
	}
	
	public Almacen updateEntityFromRequest(HttpServletRequest req) {
		Almacen almacen = assembler.assembleFromExistent(req);
		return almacen;
	}
	
	public void insert(Almacen almacen) {
		repository.insert(almacen);
	}

	public void update(Almacen almacen) {
		repository.update(almacen);
	}
	
	public List<Almacen> listAll() {
		return repository.listAll();
	}

	public List<Almacen> listOld() {
		return repository.listOld();
	}

	public List<Almacen> listNew() {
		return repository.listNew();
	}
	
	public Almacen findByIdOld(Integer id) {
		return repository.findByIdOld(id);
	}
	
	public Almacen findByIdNew(Integer id) {
		return repository.findByIdNew(id);
	}
	
	public void delete(Almacen almacen) {
		LibroService l_service = new LibroService();
		for (Libro libro:almacen.getLibros()) {
			l_service.delete(libro);
		}
		repository.delete(almacen);
	}
}
