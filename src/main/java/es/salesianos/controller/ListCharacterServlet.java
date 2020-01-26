package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Character;
import es.salesianos.service.CharacterService;
import es.salesianos.service.Service;

@Controller
public class ListCharacterServlet{

	@Autowired
	@Qualifier("characterService")
	private Service<Character> service = new CharacterService();

	@PostMapping(path = "/listcharacters")
	private ModelAndView listAllCharacters() {
		List<Character> characters = service.listAll();
		ModelAndView model = new ModelAndView("listCharacter");
		model.addObject("listOfCharacters", characters);
		return model;
	}
}