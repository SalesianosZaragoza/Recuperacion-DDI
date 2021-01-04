package service;

import javax.servlet.http.HttpServletRequest;

import models.Alumn;
import modelsAssembler.AlumnAssembler;
import repository.AlumnRepository;

public class AlumnService {
	private AlumnRepository repository = new AlumnRepository();	
	
	public Alumn assembleUserFromRequest(HttpServletRequest req) {
		return AlumnAssembler.assemblerUserFrom(req);
	}

	public void insertOrUpdate(Alumn userFormulario) {
		Alumn userInDatabase = repository.searchAlumn(userFormulario);
		if(null == userInDatabase){
			repository.insertAlumn(userFormulario);
		}else{
			repository.updateAlumn(userFormulario);
		}
	}
	
	public AlumnRepository getAlumnRepository() {
		return repository;
	}

	public void setAlumnRepository(AlumnRepository repository) {
		this.repository = repository;
	}
}
