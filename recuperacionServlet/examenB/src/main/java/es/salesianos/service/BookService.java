package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Book;
import es.salesianos.model.assembler.BookAssembler;
import es.salesianos.repository.BookRepository;

public class BookService {

	private BookAssembler assembler = new BookAssembler();
	private BookRepository repository = new BookRepository();
	
	public Book createNewEntityFromRequest(HttpServletRequest req) {
		Book libro = assembler.assembleFrom(req);
		return libro;
	}

	public void insert(Book book) {
		repository.insert(book);
	}
	
	public void delete(Book book) {
		repository.delete(book);
	}

}
