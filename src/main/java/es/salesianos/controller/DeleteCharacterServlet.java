package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.salesianos.model.Character;
import es.salesianos.service.CharacterService;
import es.salesianos.service.Service;

@Controller
public class DeleteCharacterServlet {

	@Autowired
	@Qualifier("characterService")
	private Service<Character> service = new CharacterService(); 

	@GetMapping("deleteCharacter")
	protected String deleteCharacter(@RequestParam Integer idCharacter){
		service.delete(idCharacter);
		return "index";
	}

}
