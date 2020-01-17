package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Race;
import es.salesianos.repository.RaceRepository;

public class RaceService {

	RaceRepository repository = new RaceRepository();

	private List<Race> listRace() {
		return repository.listAll();
	}
}