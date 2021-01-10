package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Book;
import modelAssembler.BookAssembler;
import repository.BookRepository;

public class BookService {

	private BookRepository repository = new BookRepository();

	public Book assembleBookFromRequest(HttpServletRequest req) {
		return BookAssembler.assemblerBookFrom(req);
	}

	public void insertOrUpdate(Book bookForm) {
		Book bookInDatabase = repository.searchBook(bookForm);
		if (null == bookInDatabase) {
			repository.insertBook(bookForm);
		} else {
			repository.updateBook(bookForm);
		}
	}

	public BookRepository getNewStorehouseRepository() {
		return repository;
	}

	public void setNewStorehouseRepository(BookRepository repository) {
		this.repository = repository;
	}

	public List<Book> listAll() {
		return repository.searchAll();
	}
}
