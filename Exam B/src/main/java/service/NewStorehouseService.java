package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.NewStorehouse;
import modelAssembler.NewStorehouseAssembler;
import repository.NewStorehouseRepository;

public class NewStorehouseService {

	private NewStorehouseRepository repository = new NewStorehouseRepository();

	public NewStorehouse assembleStoreFromRequest(HttpServletRequest req) {
		return NewStorehouseAssembler.assemblerNewStorehouseFrom(req);
	}

	public void insertOrUpdate(NewStorehouse storehouseForm) {
		NewStorehouse storehouseInDatabase = repository.searchStorehouse(storehouseForm);
		if (null == storehouseInDatabase) {
			repository.insertNewStorehouse(storehouseForm);
		} else {
			repository.updateNewStorehouse(storehouseForm);
		}
	}

	public NewStorehouseRepository getNewStorehouseRepository() {
		return repository;
	}

	public void setNewStorehouseRepository(NewStorehouseRepository repository) {
		this.repository = repository;
	}

	public List<NewStorehouse> listAll() {
		return repository.searchAll();
	}
}
