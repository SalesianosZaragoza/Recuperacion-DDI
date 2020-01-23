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

import es.salesianos.model.Race;
import es.salesianos.service.CharacterService;
import es.salesianos.service.RaceService;
import es.salesianos.service.Service;

public class RaceServlet extends HttpServlet {
	
	private Service service = new RaceService();

	//private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	private static final long serialVersionUID = 1L;
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Race race =  service.createNewRaceFromRequest(req);
		service.insertRace(race);
		redirect(req, resp);
		
		/*
	//////////////////////////////////////////////MOVERLO A RACEREPOSITORY/////////////////////////////////////////////////
		
		Race race = new Race();
		race.setSpecies(req.getParameter("race"));
		Connection conn;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(jdbcUrl, "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO RACE (species)" + "VALUES (?)");
			preparedStatement.setString(1, race.getSpecies());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		redirect(req, resp);
		*/
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Listed.jsp");
		dispatcher.forward(req, resp);
	}
}