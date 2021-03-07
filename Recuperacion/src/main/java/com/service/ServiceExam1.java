package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Book;
import com.model.Warehouse;

@Service
public interface ServiceExam1<E> {

	public List<E> listAll();

	public void delete(Integer id);

	public void insert(Warehouse warehouse);

	public void insert(Book book);

	void deleteOldWarehouse(Integer id);

	void insertOldWarehouse(Warehouse warehouse);
	
	void insertNewWarehouse(Warehouse warehouse);

}
