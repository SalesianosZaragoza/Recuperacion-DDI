package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.assembler.RaceAssembler;
import es.salesianos.model.Race;
import es.salesianos.service.RaceService;

public class UpdateRaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RaceService service = new RaceService();
	RaceAssembler assembler = new RaceAssembler();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		Integer id = Integer.parseInt(parameter);
		Race race = service.findBy(id);
		req.setAttribute("race", race);
		redirect(req, resp, "updateRace.jsp");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Race race = service.createNewFromRequest(req);
		race.setId(Integer.parseInt(req.getParameter("id")));
		service.update(race);
		redirect(req, resp, "ListRaces.jsp");

	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String url)
		throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + url);
		dispatcher.forward(req, resp);
	}
} 