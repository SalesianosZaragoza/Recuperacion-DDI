package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.salesianos.assembler.RaceAssembler;
import es.salesianos.model.Race;
import es.salesianos.repository.RaceRepository;
import es.salesianos.repository.Repository;

@org.springframework.stereotype.Service("raceService")
public class RaceService implements Service<Race>{
	
	@Autowired
	private RaceAssembler assembler = new RaceAssembler();
	
	@Autowired
	@Qualifier("raceRepository")
	private Repository<Race> repository = new RaceRepository();

	@Override
	public Race createNewDataFromRequest(HttpServletRequest req) {
		Race race = assembler.createRaceFromRequest(req);
		return race;
	}

	@Override
	public void insert(Race race) {
		repository.insert(race);
	}

	@Override
	public void update(Race race) {
		repository.update(race);
	}

	@Override
	public List<Race> listAll() {
		return repository.listAll();
	}

	@Override
	public void delete(HttpServletRequest req){
		repository.delete(req);
	}

	@Override
	public Race listById(Integer id) {
		return repository.selectById(id);
	}

	@Override
	public Race updateDataFromRequest(HttpServletRequest req) {
		Race race= assembler.updateRaceFromRequest(req);
		return race;
	}
}
