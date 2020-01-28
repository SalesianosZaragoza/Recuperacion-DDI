package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Race;
import es.salesianos.service.RaceService;
import es.salesianos.service.Service;

@Controller
public class ListRaceController {

	@Autowired
	@Qualifier("raceService")
	private Service<Race> service = new RaceService();

	@PostMapping(path = "/listraces")
	private ModelAndView listAllRaces() {
		List<Race> races = service.listAll();
		ModelAndView model = new ModelAndView("ListRaces");
		model.addObject("listOfRaces", races);
		return model;
	}

	@GetMapping(path = "/listraces")
	public String getListRacePage() {
		return "ListRaces";
	}
	
}