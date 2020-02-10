package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.service.Service;

@Controller
public class DeleteController {

	@Autowired
	ListController controller;
	
	@Autowired
	@Qualifier("characterService")
	private Service<Character> characterService;
	
	@Autowired
	@Qualifier("raceService")
	private Service<Race> raceService;
	
	@GetMapping("deleteCharacter")
	protected ModelAndView deleteCharacter(@RequestParam("id") Integer idCharacter){
		characterService.delete(idCharacter);
		return controller.listAllCharacters();
	}
	
	@GetMapping("deleteRace")
	protected ModelAndView deleteRace(@RequestParam("id") Integer idRace){
		raceService.delete(idRace);
		return controller.listAllRaces();
	}
}
