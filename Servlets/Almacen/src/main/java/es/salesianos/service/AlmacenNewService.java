package es.salesianos.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.AlmacenNew;
import es.salesianos.model.assembler.AlmacenNewAssembler;
import es.salesianos.repository.Repository;

public class AlmacenNewService {
	
	
	private Repository repository = new Repository();
	
	
	public AlmacenNew assembleOwnerFromRequest(HttpServletRequest req) {
		return AlmacenNewAssembler.assembleAlmacenNewFrom(req);
	}
	
	public void addAlmacenNew(AlmacenNew owner) {
		repository.insert(owner);
	}

	public void insertOrUpdate(AlmacenNew ownerFormulario) {
		AlmacenNew userInDatabase = repository.search(ownerFormulario);
		if(null == userInDatabase){
			repository.insert(ownerFormulario);
		}else{
			repository.update(ownerFormulario);
		}
	}
	
	public void deleteAlmacenNew(Integer id) {
		repository.deleteNew(id);
	}
	

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	public List<AlmacenNew> listAllAlmacenesNew() {		
		return repository.searchAllNew();
	}
	

}
