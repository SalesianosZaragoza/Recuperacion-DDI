package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Book;
import com.model.Warehouse;
import com.repository.RepositoryBookExam1;

@Service
public class BookService implements ServiceExam1<Book> {


	private RepositoryBookExam1<Book> repository;

	
	public void insert(Book book) {
		repository.insertBook(book);
	}

	
	public List<Book> listAll() {
		return repository.listAll();
	}

	
	public void delete(Integer id) {
		repository.delete(id);
	}	

	
	public void updateNewWarehouse(int id) {
		repository.findByIdNewWarehouse(id);
	}
	
	
	public void updateOldWarehouse(int id) {
		repository.findByIdNewWarehouse(id);
	}


	@Override
	public void insert(Warehouse warehouse) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteOldWarehouse(Integer id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void insertOldWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void insertNewWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		
	}


}
