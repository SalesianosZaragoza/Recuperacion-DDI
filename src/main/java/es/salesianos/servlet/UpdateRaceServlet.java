package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Race;
import es.salesianos.service.RaceService;

public class UpdateRaceServlet extends HttpServlet {

	RaceService service = new RaceService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		Integer idRace = Integer.parseInt(parameter);
		Race specie = (Race) service.listById(idRace);
		req.setAttribute("raza", specie);
		redirect(req, resp, "UpdateRace.jsp");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		Integer idRace = Integer.parseInt(parameter);
		String specie = req.getParameter("especie");
		Race race = new Race();
		race.setSpecie(specie);
		race.setId(idRace);
		service.update(race);
		redirect(req, resp, "ListRace.jsp");

	}


	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String page)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + page);
		dispatcher.forward(req, resp);
	}

}
