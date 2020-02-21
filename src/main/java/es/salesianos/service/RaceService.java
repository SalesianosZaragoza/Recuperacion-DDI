package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.salesianos.model.Race;
import es.salesianos.repository.Repository;

@org.springframework.stereotype.Service("RaceService")
public class RaceService implements Service<Race> {

	@Autowired
	@Qualifier("raceRepository")
	private Repository<Race> repository;

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
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public Race findById(Integer id) {
		return repository.findById(id);
	}

}
