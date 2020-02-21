package es.salesianos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("/listcharacters")
	public String ListCharacters() {
		return "ListCharacters";
	}

	@GetMapping("/listraces")
	public String ListRaces() {
		return "ListRaces";
	}
}
