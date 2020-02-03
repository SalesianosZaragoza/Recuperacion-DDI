package es.salesianos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(path="index")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping(path = "/listcharacters")
	public String getListCharacterPage() {
		return "ListCharacters";
	}
	
	@GetMapping(path = "/listraces")
	public String getListRacePage() {
		return "ListRaces";
	}
}
