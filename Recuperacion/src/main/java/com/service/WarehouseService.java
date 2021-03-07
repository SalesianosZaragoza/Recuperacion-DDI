package com.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.model.Book;
import com.model.Warehouse;
import com.repository.RepositoryWareHouseExam1;

@Service
public class WarehouseService implements ServiceExam1<Warehouse> {


	private RepositoryWareHouseExam1<Warehouse> repository;

	@Override
	public void insertOldWarehouse(Warehouse warehouse) {
		repository.insertOldWarehouse(warehouse);
	}
	
	@Override
	public void insertNewWarehouse(Warehouse warehouse) {
		repository.insertNewWarehouse(warehouse);
	}


	@Override
	public List<Warehouse> listAll() {
		return repository.listAll();
	}

	@Override
	public void deleteOldWarehouse(Integer id) {
		repository.deleteOldWarehouse(id);
	}


	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void insert(Warehouse warehouse) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void insert(Book book) {
		
		
	}



}



