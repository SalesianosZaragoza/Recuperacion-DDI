package es.salesianos.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.service.CharacterService;
import es.salesianos.service.Service;

public class ListedServlet extends HttpServlet {


	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	Service service = new CharacterService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Character> users = service.listAll();
		req.setAttribute("listOfUsers", users);
		Connection conn;
		ArrayList<Race> userst = new ArrayList<Race>();
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(jdbcUrl, "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM RACE");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Race user = new Race();
				user.setId(resultSet.getInt("id"));
				user.setSpecies(resultSet.getString("species"));
				userst.add(user);
			}
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

		List<Race> race = userst;
		req.setAttribute("listOfRaces", race);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Listed.jsp");
		dispatcher.forward(req, resp);
	}
}