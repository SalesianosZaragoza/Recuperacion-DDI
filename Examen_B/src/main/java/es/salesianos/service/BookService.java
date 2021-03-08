package es.salesianos.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Book;
import es.salesianos.model.Warehouse;
import es.salesianos.repository.BookRepository;
import es.salesianos.repository.WarehouseRepository;
@Service
public class BookService {	
	@Autowired
	private BookRepository repository;
	@Autowired
	private WarehouseRepository warehouse_repository;
	
	public void insert(Book book) {
		repository.insert(book);
	}

	public void delete(Book book) {
		repository.delete(book);
	}
	
	public void delete(Integer id) {
		repository.delete(id);
	}
	
	public List<Book> listAll() {
		List<Book> list = repository.listAll();
		for (Book book : list) {
			Warehouse warehouse;
			if (book.isWarehouseOld()) {
				warehouse = warehouse_repository.findByOld(book.getWarehouseId());
			} else {
				warehouse = warehouse_repository.findByNew(book.getWarehouseId());
			}
			book.setWarehouse(warehouse);
		}
		return list;
	}

}
