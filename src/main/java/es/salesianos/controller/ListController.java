package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.service.Service;

@Controller
public class ListController{

	@Autowired
	@Qualifier("characterService")
	private Service<Character> characterService;
	
	@Autowired
	@Qualifier("raceService")
	private Service<Race> raceService;

	@PostMapping(path = "/listcharacters")
	private ModelAndView listAllCharacters() {
		List<Character> characters = characterService.listAll();
		ModelAndView model = new ModelAndView("ListCharacters");
		model.addObject("listOfCharacters", characters);
		return model;
	}
	
	@PostMapping(path = "/listraces")
	private ModelAndView listAllRaces() {
		List<Race> races = raceService.listAll();
		ModelAndView model = new ModelAndView("ListRaces");
		model.addObject("listOfRaces", races);
		return model;
	}
	
}