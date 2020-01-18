package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.RaceAssembler;
import es.salesianos.model.Race;
import es.salesianos.repository.RaceRepository;

public class RaceService implements Service<Race> {
	private RaceAssembler assembler = new RaceAssembler();
	private RaceRepository repository = new RaceRepository();

	public Race createNewFromRequest(HttpServletRequest req) {
		Race race = assembler.createRaceFromRequest(req);
		return race;
	}

	public void insert(Race race) {
		repository.insert(race);
	}

	public List<Race> listAll() {
		return repository.listAll();
	}

	public void update(Race race) {
		repository.update(race);
	}

	public Race findById(Integer id) {
		return repository.findById(id);
	}
}
