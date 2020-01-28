package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import es.salesianos.model.Character;
import es.salesianos.service.CharacterService;
import es.salesianos.service.Service;

@Controller
public class CharacterServlet {

	@Autowired
	@Qualifier("characterService")
	private Service<Character> service = new CharacterService(); 

	@PostMapping(path="/insertCharacter")
	public String saveCharacter(Character character)  {
		service.insert(character);
		return "welcomeCharacter";
	}
	@PostMapping(path = "/index")
	public String getIndexPage() {
		return "index";
	}

}
