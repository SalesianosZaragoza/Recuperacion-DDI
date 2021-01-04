package es.salesianos.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Warehouse;
import es.salesianos.model.Book;
import es.salesianos.model.assembler.WarehouseAssembler;
import es.salesianos.repository.WarehouseRepository;

public class WarehouseService {

	private WarehouseAssembler assembler = new WarehouseAssembler();
	private WarehouseRepository repository = new WarehouseRepository();
	
	public Warehouse createNewEntityFromRequest(HttpServletRequest req) {
		Warehouse warehouse = assembler.assembleFrom(req);
		return warehouse;
	}
	
	public void insert(Warehouse warehouse) {
		repository.insert(warehouse);
	}
	
	public List<Warehouse> listOld() {
		return repository.listOld();
	}

	public List<Warehouse> listNew() {
		return repository.listNew();
	}
	
	public Warehouse findByOld(Integer id) {
		return repository.findByOld(id);
	}
	
	public Warehouse findByNew(Integer id) {
		return repository.findByNew(id);
	}
	
	public void delete(Warehouse warehouse) {
		BookService book_service = new BookService();
		for (Book book : warehouse.getBooks()) {
			book_service.delete(book);
		}
		repository.delete(warehouse);
	}
}
