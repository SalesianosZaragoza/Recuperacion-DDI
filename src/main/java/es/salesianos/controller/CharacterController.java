package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import es.salesianos.model.Character;
import es.salesianos.service.CharacterService;
import es.salesianos.service.Service;

@Controller
public class CharacterController {

	@Autowired
	@Qualifier("characterService")
	private Service<Character> service = new CharacterService(); 

	@PostMapping(path="/insertCharacter")
	public String saveCharacter(Character character)  {
		service.insert(character);
		return "welcomeCharacter";
	}
	@GetMapping(path="index")
	public String getIndexPàge()  {
		return "index";
	}
}
