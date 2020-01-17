package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import es.salesianos.assembler.RaceAssembler;
import es.salesianos.model.LordOfTheRingsCharacter;
import es.salesianos.model.Race;
import es.salesianos.repository.Repository;

public class RaceService implements Service<Race> {

	private RaceAssembler assembler = new RaceAssembler();

	public RaceService() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Autowired
	private Repository<Race> repository;

	public Race createNewUserFromRequest(HttpServletRequest req) {
		Race specie = assembler.createUserFromRequest(req);
		return specie;
	}
	
	public void insert(Race specie) {
			repository.insert(specie);
	}

	@Override
	public List<Race> listAll() {
		return repository.listAll();
	}

	public Race listById(Integer idRace) {
		return repository.listByUser(idRace);
	}

	public void update(Race specie) {
		repository.update(specie);
	}
}
