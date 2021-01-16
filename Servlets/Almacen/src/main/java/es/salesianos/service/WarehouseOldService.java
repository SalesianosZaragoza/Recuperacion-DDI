package es.salesianos.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.WarehouseOld;
import es.salesianos.model.assembler.WarehouseOldAssembler;
import es.salesianos.repository.Repository;

public class WarehouseOldService {
	
	
	private Repository repository = new Repository();
	
	
	public WarehouseOld assembleWarehouseOldFromRequest(HttpServletRequest req) {
		return WarehouseOldAssembler.assembleWarehouseOldFrom(req);
	}
	
	public void addWarehouseOld(WarehouseOld warehouseOld) {
		repository.insert(warehouseOld);
	}
	
	public void deleteWarehouseOld(Integer id) {
		repository.deleteOld(id);
	}
	

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public List<WarehouseOld> listAllWarehouseesOld() {		
		return repository.searchAllOld();
	}
	

}
