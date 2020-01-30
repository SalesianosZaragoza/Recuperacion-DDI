package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Character;
import es.salesianos.service.Service;

@Controller
public class ListCharacterController{

	@Autowired
	@Qualifier("characterService")
	private Service<Character> service;

	@PostMapping(path = "/listcharacters")
	private ModelAndView listAllCharacters() {
		List<Character> characters = service.listAll();
		ModelAndView model = new ModelAndView("ListCharacters");
		model.addObject("listOfCharacters", characters);
		return model;
	}
	@GetMapping(path = "/listcharacters")
	public String getListCharacterPage() {
		return "ListCharacters";
	}
	
}