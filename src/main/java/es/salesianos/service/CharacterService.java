package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import es.salesianos.assembler.CharacterAssembler;
import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.repository.Repository;

public class CharacterService implements Service {

	private CharacterAssembler assembler = new CharacterAssembler();

	public CharacterService() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Autowired
	private Repository<Character> repository;

	public Character createNewUserFromRequest(HttpServletRequest req) {
		Character character = assembler.createUserFromRequest(req);
		return character;
	}
	
	public void insertCharacter(Character user) {
			repository.insert(user);
	}

	@Override
	public List<Character> listAll() {
		return repository.listAll();
	}

	public Character listById(Integer idUser) {
		return repository.findBy(idUser);
	}

	public void update(Character personaje) {
		repository.update(personaje);
	}

	@Override
	public Race createNewRaceFromRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Race> listAllRace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertRace(Race race) {
		
		
	}
}