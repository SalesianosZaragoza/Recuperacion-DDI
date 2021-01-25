package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Book;
import es.salesianos.model.assembler.BookAssembler;
import es.salesianos.repository.Repository;

public class BookService {

	private Repository repository = new Repository();
	
	
	public Book assembleBookFromRequest(HttpServletRequest req) {
		return BookAssembler.assembleBookFrom(req);
	}
	
	public void addBook(Book book) {
		repository.insert(book);
	}

	public void dateEditionhHigher(Book book) {
		if(book.getDateEdition().getYear() >=  2000)
			addBook(book);
	}

	public void dateEditionLower(Book book) {
		if(book.getDateEdition().getYear() <  2000)
			addBook(book);
	}
}
