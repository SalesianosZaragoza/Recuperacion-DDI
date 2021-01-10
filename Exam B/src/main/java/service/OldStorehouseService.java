package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.OldStorehouse;
import modelAssembler.OldStorehouseAssembler;
import repository.OldStorehouseRepository;

public class OldStorehouseService {

	private OldStorehouseRepository repository = new OldStorehouseRepository();

	public OldStorehouse assembleStoreFromRequest(HttpServletRequest req) {
		return OldStorehouseAssembler.assemblerOldStorehouseFrom(req);
	}

	public void insertOrUpdate(OldStorehouse storehouseForm) {
		OldStorehouse storehouseInDatabase = repository.searchStorehouse(storehouseForm);
		if (null == storehouseInDatabase) {
			repository.insertOldStorehouse(storehouseForm);
		} else {
			repository.updateOldStorehouse(storehouseForm);
		}
	}

	public OldStorehouseRepository getNewStorehouseRepository() {
		return repository;
	}

	public void setNewStorehouseRepository(OldStorehouseRepository repository) {
		this.repository = repository;
	}

	public List<OldStorehouse> listAll() {
		return repository.searchAll();
	}
}
