package service;

import java.util.List;


import model.Warehouse;
import repository.Repository;


public class WarehouseService implements Service<Warehouse> {


	private Repository<Warehouse> repository;

	@Override
	public void insert(Warehouse warehouse) {
		repository.insert(warehouse);
	}

	@Override
	public void update(Warehouse warehouse) {
		repository.update(warehouse);
	}

	@Override
	public List<Warehouse> listAll() {
		return repository.listAll();
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
