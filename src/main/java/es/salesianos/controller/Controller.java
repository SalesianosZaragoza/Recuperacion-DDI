package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.service.Service;

public class Controller {

	@Autowired
	@Qualifier("characterService")
	private Service<Character> characterService;

	@Autowired
	@Qualifier("raceService")
	private Service<Race> raceService;

	@GetMapping("index")
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("/listCharacters")
	public String getListCharacterPage() {
		return "ListCharacters";
	}

	@GetMapping("/listRaces")
	public String getListRacePage() {
		return "ListRaces";
	}

	@PostMapping("/listcharacters")
	protected ModelAndView listAllCharacters() {
		List<Character> characters = characterService.listAll();
		ModelAndView model = new ModelAndView("ListCharacters");
		model.addObject("listOfCharacters", characters);
		return model;
	}

	@PostMapping("/listraces")
	protected ModelAndView listAllRaces() {
		List<Race> races = raceService.listAll();
		ModelAndView model = new ModelAndView("ListRaces");
		model.addObject("listOfRaces", races);
		return model;
	}

	@PostMapping("/insertCharacter")
	public String insertCharacter(Character character) {
		characterService.insert(character);
		return "welcomeCharacter";
	}

	@PostMapping("/insertRace")
	public String insertRace(Race race) {
		raceService.insert(race);
		return "welcomeRace";
	}

	@GetMapping("/updateCharacter")
	protected ModelAndView editCharacterById(@RequestParam("id") Integer id) {
		ModelAndView model = new ModelAndView("updateCharacter");
		Character character = characterService.findById(id);
		model.addObject("character", character);
		return model;
	}

	@PostMapping("/updateCharacter")
	protected ModelAndView updateCharacter(@ModelAttribute Character character) {
		characterService.update(character);
		return listAllCharacters();
	}

	@GetMapping("deleteCharacter")
	protected ModelAndView deleteCharacter(@RequestParam("id") Integer id) {
		characterService.delete(id);
		return listAllCharacters();
	}

	@GetMapping("deleteRace")
	protected ModelAndView deleteRace(@RequestParam("id") Integer id) {
		raceService.delete(id);
		return listAllRaces();
	}
}
