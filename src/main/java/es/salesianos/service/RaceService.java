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

public class RaceService implements Service<Race>{

	private RaceAssembler assembler = new RaceAssembler();
	private Repository<Race> repository = new RaceRepository();
	
	public RaceService() {

	}
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
