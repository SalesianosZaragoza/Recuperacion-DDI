package com.mycompany.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mycompany.model.Book;
import com.mycompany.model.Warehouse;
import com.mycompany.assembler.BookAssembler;
import com.mycompany.repository.BookRepository;

public class BookService{
	
	private BookAssembler assembler = new BookAssembler();
	private BookRepository repository = new BookRepository();
	

	public Book createNewEntityFromRequest(HttpServletRequest req) {
		Book book = assembler.createUserFromRequest(req);
		return book;
	}
	
	public Book updateEntityFromRequest(HttpServletRequest req) {
		Book book = assembler.assembleFromExistent(req);
		return book;
	}

	public void insert(Book book) {
		repository.insert(book);
	}

	public void update(Book	book) {
		repository.update(book);
	}

	public List<Book> listAll() {
		return repository.listAll();
	}

	public Book findById(Integer id) {
		return repository.findById(id);
	}

	public void delete(Book book) {
		repository.delete(book);
	}


}
