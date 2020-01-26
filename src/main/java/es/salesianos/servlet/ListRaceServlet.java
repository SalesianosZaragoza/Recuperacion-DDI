package es.salesianos.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Race;
import es.salesianos.service.RaceService;
import es.salesianos.service.Service;

public class ListRaceServlet {

	@Autowired
	@Qualifier("raceService")
	private Service<Race> service = new RaceService();

	@PostMapping(path = "/listraces")
	private ModelAndView listAllRaces() {
		List<Race> races = service.listAll();
		ModelAndView model = new ModelAndView("listRace");
		model.addObject("listOfRaces", races);
		return model;
	}
}