package com.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Warehouse;

@Repository
public interface RepositoryWareHouseExam1<E> {
	static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	public void insertOldWarehouse(E element);
	
	public void insertNewWarehouse(E element);
		
	public void update(boolean warehouse);

	public E findByIdOldWarehouse(Integer id);
	
	public E findByIdNewWarehouse(Integer id);
	
	public void deleteOldWarehouse(Integer id);
	
	public void deleteNewWarehouse(Integer id);

	List<Warehouse> listAll();

	


}
