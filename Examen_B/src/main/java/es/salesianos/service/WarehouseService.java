package es.salesianos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Book;
import es.salesianos.model.Warehouse;
import es.salesianos.repository.WarehouseRepository;
@Service
public class WarehouseService {

	@Autowired
	private WarehouseRepository repository = new WarehouseRepository();
		
	public void insert(Warehouse warehouse) {
		repository.insert(warehouse);
	}

	public void update(Warehouse warehouse) {
		repository.update(warehouse);
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
	
	public void deleteOld(Integer id) {
		Warehouse warehouse = findByOld(id);
		BookService book_service = new BookService();
		for (Book book : warehouse.getBooks()) {
			book_service.delete(book);
		}
		repository.delete(warehouse);
	}

	public void deleteNew(Integer id) {
		Warehouse warehouse = findByNew(id);
		BookService book_service = new BookService();
		for (Book book : warehouse.getBooks()) {
			book_service.delete(book);
		}
		repository.delete(warehouse);
	}
}
