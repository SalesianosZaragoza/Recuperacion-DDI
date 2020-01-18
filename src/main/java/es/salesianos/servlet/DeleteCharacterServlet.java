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

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;

public class DeleteCharacterServlet extends H2Connection {
	private static final long serialVersionUID = 1L;
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		Integer idChar = Integer.parseInt(parameter);

		Connection connect;
		try {
			Class.forName("org.h2.Driver");
			connect = DriverManager.getConnection(jdbcUrl, "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connect.prepareStatement("DELETE FROM PERSONAJE WHERE id=?");
			preparedStatement.setInt(1, idChar);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(connect);
			close(preparedStatement);
		}
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/deleteCharacter.jsp");
		dispatcher.forward(req, resp);
	}

}
