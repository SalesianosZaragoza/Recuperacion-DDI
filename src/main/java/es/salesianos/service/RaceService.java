package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.salesianos.model.Race;
import es.salesianos.repository.RaceRepository;
import es.salesianos.repository.Repository;

@org.springframework.stereotype.Service("raceService")
public class RaceService implements Service<Race> {
	
	@Autowired
	@Qualifier("raceRepository")
	private Repository<Race> repository = new RaceRepository();

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
}