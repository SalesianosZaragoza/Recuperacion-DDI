package com.mycompany.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;


import com.mycompany.model.Book;
import com.mycompany.model.Warehouse;
import com.mycompany.repository.WarehouseRepository;

public class WarehouseService {

private WarehouseAssembler assembler = new AlmacenAssembler();
	private WarehouseRepository repository = new WarehouseRepository();

	public Warehouse createNewEntityFromRequest(HttpServletRequest req) {
		Warehouse warehouse = assembler.assembleFrom(req);
		return warehouse;
	}

	public Warehouse updateEntityFromRequest(HttpServletRequest req) {
		Warehouse warehouse = assembler.assembleFromExistent(req);
		return warehouse;
	}

	public void insert(Warehouse warehouse) {
		repository.insert(warehouse);
	}
	public void update(Warehouse warehouse) {
		repository.update(warehouse);
	}

	public List<Warehouse> listAll() {
		return repository.listAll();
	}

	public List<Warehouse> listOld() {
		return repository.listOld();
	}

	public List<Warehouse> listNew() {
		return repository.listNew();
	}

	public Warehouse findByIdOld(Integer id) {
		return repository.findByIdOld(id);
	}

	public Warehouse findByIdNew(Integer id) {
		return repository.findByIdNew(id);
	}
	public void delete(Warehouse warehouse) {
		BookService l_service = new BookService();
		for (Book book:warehouse.getBooks()) {
			l_service.delete(book);
		}
		repository.delete(warehouse);
	}

}
