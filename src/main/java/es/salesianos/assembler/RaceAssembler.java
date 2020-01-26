package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import es.salesianos.model.Race;

@Component
public class RaceAssembler {

	public Race createRaceFromRequest(HttpServletRequest request) {
		Race race = new Race();
		race.setSpecie(request.getParameter("specie"));
		return race;
	}

	public Race updateRaceFromRequest(HttpServletRequest req) {
		String parameterId = req.getParameter("id");
		Integer id = Integer.parseInt(parameterId);
		String specie = req.getParameter("specie");
		Race race = new Race();
		race.setId(id);
		race.setSpecie(specie);
		return race;
	}
}
