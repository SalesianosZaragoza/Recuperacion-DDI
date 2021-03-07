package com.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Book;
import com.model.Warehouse;

@SuppressWarnings("unused")
@Repository
public interface RepositoryBookExam1<E> {
	static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	public List<E> listAll();
	
	public void insertBook(Book book);
	
	public void delete(Integer id);

	public void insertWarehouse(Warehouse warehouse);

	public void findByIdNewWarehouse(int id);
	

}
