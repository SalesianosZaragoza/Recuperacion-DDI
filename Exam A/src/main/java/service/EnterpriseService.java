package service;

import javax.servlet.http.HttpServletRequest;

import models.Enterprise;
import modelsAssembler.EnterpriseAssembler;
import repository.EnterpriseRepository;

public class EnterpriseService {

	private EnterpriseRepository repository = new EnterpriseRepository();

	public Enterprise assembleUserFromRequest(HttpServletRequest req) {
		return EnterpriseAssembler.assemblerUserFrom(req);
	}

	public void insertOrUpdate(Enterprise userFormulario) {
		Enterprise userInDatabase = repository.searchEnterprise(userFormulario);
		if (null == userInDatabase) {
			repository.insertEnterprise(userFormulario);
		} else {
			repository.updateEnterprise(userFormulario);
		}
	}

	public EnterpriseRepository getEnterpriseRepository() {
		return repository;
	}

	public void setEnterpriseRepository(EnterpriseRepository repository) {
		this.repository = repository;
	}

}
