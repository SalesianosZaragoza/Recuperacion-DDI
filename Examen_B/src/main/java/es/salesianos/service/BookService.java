package es.salesianos.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;


import es.salesianos.model.Book;
import es.salesianos.model.assembler.BookAssembler;

import es.salesianos.repository.BookRepository;

public class BookService {

	private BookAssembler assembler = new BookAssembler();
	private BookRepository repository = new BookRepository();
	
	public Book createNewEntityFromRequest(HttpServletRequest req) {
		Book book = assembler.assembleFrom(req);
		return book;
	}
	
	public void insert(Book book) {
		repository.insert(book);
	}

	public void delete(Book book) {
		repository.delete(book);
	}

}
