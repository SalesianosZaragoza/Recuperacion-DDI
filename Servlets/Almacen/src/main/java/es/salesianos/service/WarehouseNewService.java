package es.salesianos.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.WarehouseNew;
import es.salesianos.model.assembler.WarehouseNewAssembler;
import es.salesianos.repository.Repository;

public class WarehouseNewService {
	
	
	private Repository repository = new Repository();
	
	
	public WarehouseNew assembleWarehouseNewFromRequest(HttpServletRequest req) {
		return WarehouseNewAssembler.assembleWarehouseNewFrom(req);
	}
	
	public void addWarehouseNew(WarehouseNew warehouseNew) {
		repository.insert(warehouseNew);
	}
	
	public void deleteWarehouseNew(Integer id) {
		repository.deleteNew(id);
	}
	

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	public List<WarehouseNew> listAllWarehouseesNew() {		
		return repository.searchAllNew();
	}
	

}
