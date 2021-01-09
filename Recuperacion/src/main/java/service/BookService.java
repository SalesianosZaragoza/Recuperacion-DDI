package service;

import java.util.List;
import model.Book;
import repository.Repository;


public class BookService implements Service<Book> {


	private Repository<Book> repository;

	
	public void insert(Book book) {
		repository.insert(book);
	}

	
	public List<Book> listAll() {
		return repository.listAll();
	}

	
	public void delete(Integer id) {
		repository.delete(id);
	}
	

	public Book findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public void update(Book element) {
		// TODO Auto-generated method stub
		
	}

}
