package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.RaceAssembler;
import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.repository.CharacterRepository;
import es.salesianos.repository.RaceRepository;
import es.salesianos.repository.Repository;

public class RaceService implements Service{

	private RaceAssembler assembler = new RaceAssembler();
	private RaceRepository repository = new RaceRepository();
	
	public RaceService() {

	}
	
	public Race createNewRaceFromRequest(HttpServletRequest req) {
		Race race = assembler.createRaceFromRequest(req);
		return race;
	}

	public void insertRace(Race race) {
		repository.insert(race);
	}

	
	public void update(Race race) {
		repository.update(race);
	}

	public List<Race> listRaces() {
		return repository.listAll();
	}

	public Character createNewCharacterFromRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertCharacter(Character user) {
		// TODO Auto-generated method stub
		
	}

	public List<Character> listCharacters() {
		// TODO Auto-generated method stub
		return null;
	}
}
