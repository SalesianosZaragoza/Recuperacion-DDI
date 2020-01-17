package es.salesianos.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String query1 = req.getParameter("consulta1");
		String query2 = req.getParameter("consulta2");

		System.out.println(query1);
		System.out.println(query2);

		Connection conn;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(jdbcUrl, "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		PreparedStatement preparedStatement0 = null;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;

		try {
			preparedStatement0 = conn.prepareStatement("DELETE FROM CHARACTER WHERE id = ?");
			preparedStatement1 = conn.prepareStatement("DELETE FROM CHARACTER WHERE codRace = ?");
			preparedStatement2 = conn.prepareStatement("DELETE FROM RACE WHERE id = ?");

			preparedStatement0.setString(1, query1);
			preparedStatement1.setString(1, query2);
			preparedStatement2.setString(1, query2);

			preparedStatement0.executeUpdate();
			preparedStatement1.executeUpdate();
			preparedStatement2.executeUpdate();
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
			if (preparedStatement1 != null) {
				try {
					preparedStatement1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}