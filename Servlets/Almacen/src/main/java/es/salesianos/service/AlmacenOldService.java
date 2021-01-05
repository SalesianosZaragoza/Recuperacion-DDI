package es.salesianos.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.AlmacenOld;
import es.salesianos.model.assembler.AlmacenOldAssembler;
import es.salesianos.repository.Repository;

public class AlmacenOldService {
	
	
	private Repository repository = new Repository();
	
	
	public AlmacenOld assembleOwnerFromRequest(HttpServletRequest req) {
		return AlmacenOldAssembler.assembleAlmacenOldFrom(req);
	}
	
	public void addAlmacenOld(AlmacenOld owner) {
		repository.insert(owner);
	}

	public void insertOrUpdate(AlmacenOld ownerFormulario) {
		AlmacenOld userInDatabase = repository.search(ownerFormulario);
		if(null == userInDatabase){
			repository.insert(ownerFormulario);
		}else{
			repository.update(ownerFormulario);
		}
	}
	
	public void deleteAlmacenOld(Integer id) {
		repository.deleteOld(id);
	}
	

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public List<AlmacenOld> listAllAlmacenesOld() {		
		return repository.searchAllOld();
	}
	

}
