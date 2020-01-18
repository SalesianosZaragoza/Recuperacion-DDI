package es.salesianos.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.RaceAssembler;
import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.repository.CharacterRepository;
import es.salesianos.repository.RaceRepository;
import es.salesianos.repository.Repository;

public class RaceService implements Service<Race> {

	private RaceAssembler assembler = new RaceAssembler();
	private Repository<Race> repository = new RaceRepository();

	public Race createNewFromRequest(HttpServletRequest req) {
		Race race = assembler.createRaceFromRequest(req);
		return race;
	}

	public void insert(Race race) {
		repository.insert(race);
	}

	public void update(Race race) {
		repository.update(race);
	}

	public List<Race> listAll() {
		return repository.listAll();
	}
	
	public Race findBy(Integer id) {
		return repository.findBy(id);
	}

	@Override
	public void delete(HttpServletRequest req) {
		repository.delete(req);
	}
//	@Override
//	public Race updateDataFromRequest(HttpServletRequest req) {
//		Race race= assembler.updateRaceFromRequest(req);
//		return race;
//	}
}