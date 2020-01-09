package es.salesianos.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.service.CharacterService;
import es.salesianos.service.RaceService;
import es.salesianos.service.Service;

public class DeleteRaceServlet extends HttpServlet {
	
	private Service<Race> service = new RaceService(); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service.delete(req);
		redirect(req, resp);

	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListRaces.jsp");
		dispatcher.forward(req, resp);
	}

}
