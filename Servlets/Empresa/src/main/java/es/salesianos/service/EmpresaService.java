package es.salesianos.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Empresa;
import es.salesianos.model.assembler.EmpresaAssembler;
import es.salesianos.repository.Repository;

public class EmpresaService {
	
	
	private Repository repository = new Repository();
	
	
	public Empresa assembleOwnerFromRequest(HttpServletRequest req) {
		return EmpresaAssembler.assembleEmpresaFrom(req);
	}
	
	public void addEmpresa(Empresa owner) {
		repository.insert(owner);
	}

	public void insert(Empresa ownerFormulario) {
			repository.insert(ownerFormulario);
		
	}
	
	public void deleteEmpresa(Integer id, String answer) {
		repository.deleteNew(id,answer);
	}
	

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	public List<Empresa> listAllEmpresa() {		
		return repository.searchAllEmpresa();
	}
	

}
