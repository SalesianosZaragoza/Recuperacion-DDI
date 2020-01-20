package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Race;

public class RaceAssembler {
	
	public Race CreateRaceFromRequest(HttpServletRequest request) {
		Race race = new Race();
		race.setId(Integer.parseInt(request.getParameter("id")));
		race.setSpecies(request.getParameter("codRace"));
		return race;
	}

}
