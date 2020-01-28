package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.salesianos.model.Race;
import es.salesianos.service.RaceService;
import es.salesianos.service.Service;

@Controller
public class DeleteRaceController{
	
	@Autowired
	@Qualifier("raceService")
	private Service<Race> service = new RaceService(); 

	@GetMapping("deleteRace")
	protected String deleteCharacter(@RequestParam Integer idRace){
		service.delete(idRace);
		return "index";
	}
}
