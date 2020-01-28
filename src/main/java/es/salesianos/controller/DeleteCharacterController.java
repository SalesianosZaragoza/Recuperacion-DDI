package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Character;
import es.salesianos.service.CharacterService;
import es.salesianos.service.Service;

@Controller
public class DeleteCharacterController {

	@Autowired
	@Qualifier("characterService")
	private Service<Character> service = new CharacterService(); 

	@PostMapping("deleteCharacter")
	protected String deleteCharacter(@RequestParam Integer idCharacter){
		idCharacter = getIdCharacter(idCharacter);
		service.delete(idCharacter);
		return "index";
	}
	
	@GetMapping("deleteCharacter")
	protected Integer getIdCharacter(@RequestParam Integer idCharacter) {
		ModelAndView model = new ModelAndView();
		model.addObject("idCharacter", idCharacter);
		return idCharacter;
	}

}
