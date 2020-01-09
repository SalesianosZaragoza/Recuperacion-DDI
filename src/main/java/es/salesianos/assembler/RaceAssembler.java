package es.salesianos.assembler;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Race;

public class RaceAssembler {
	
	public Race createRaceFromRequest(HttpServletRequest request) {
		Race race = new Race();
		race.setSpecie(request.getParameter("specie"));
		return race;
	}
}
