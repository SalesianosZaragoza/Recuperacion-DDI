package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import es.salesianos.repository.Repository;
import es.salesianos.model.Character;
import es.salesianos.model.Race;

import es.salesianos.assembler.RaceAssembler;

public class RaceService implements Service{
	
	private RaceAssembler assembler = new RaceAssembler();
	
	public RaceService() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	@Autowired
	private Repository<Race> repository;
	
	public Race createNewRaceFromRequest(HttpServletRequest req) {
		Race race = assembler.CreateRaceFromRequest(req);
		return race;
	}
	
	@Override
	public void insertRace(Race race) {
		repository.insert(race);
	}
	
	
	@Override
	public List<Race> listAllRace() {
		return repository.listAll();
		
	}

	@Override
	public Character createNewUserFromRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertCharacter(Character character) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Character> listAll() {
		// TODO Auto-generated method stub
		return null;
	}


}