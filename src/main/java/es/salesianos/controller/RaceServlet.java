package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import es.salesianos.model.Race;
import es.salesianos.service.RaceService;
import es.salesianos.service.Service;

@Controller
public class RaceServlet{

	@Autowired
	@Qualifier("raceService")
	private Service<Race> service = new RaceService();

	@PostMapping(path="/insertRace")
	public String saveRace(Race race)  {
		service.insert(race);
		return "welcomeRace";
	}

}
