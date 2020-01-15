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

	RaceService service = new RaceService();
	RaceAssembler assembler = new RaceAssembler();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		Integer idRace = Integer.parseInt(parameter);
		Race race = service.findById(idRace);
		req.setAttribute("raza", race);
		redirect(req, resp, "updateRace.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		assembler.createRaceFromRequest(req);
		redirect(req, resp, "listRaces.jsp");
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String page)
		throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + page);
		dispatcher.forward(req, resp);
	}

}
