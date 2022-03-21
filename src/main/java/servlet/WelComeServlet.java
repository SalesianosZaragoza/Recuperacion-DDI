package servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelComeServlet extends HttpServlet {
	private String jdbcUrl = "jdbc:h2:file:./testdb";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			/*preparedStatement = conn.prepareStatement(
					"DROP TABLE USER");
			preparedStatement.executeUpdate();
			preparedStatement.close();*/
			preparedStatement = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS USER (nombre VARCHAR(100), apellidos VARCHAR(100), DNI VARCHAR(9), horaEntrada TIME, horaSalida TIME, curso VARCHAR(9), voto INTEGER)");
			preparedStatement.executeUpdate();
			preparedStatement.close();
			preparedStatement = conn.prepareStatement("SELECT * FROM USER");
			ResultSet resultSet = preparedStatement.executeQuery();

			ArrayList<String[]> listAlumnos = new ArrayList<String[]>();
			while (resultSet.next()) {
				String string = resultSet.getString(1);
				String datosAlumno[] = { resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)};
				listAlumnos.add(datosAlumno);
				System.out.println(string);
			}
			req.setAttribute("alumnos", listAlumnos);
			preparedStatement.close();
			conn.close();
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

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("Nombre");
		String apellidos = req.getParameter("Apellidos");
		String dni = req.getParameter("DNI");
		String horaEntrada = req.getParameter("HoraEntrada");
		String horaSalida = req.getParameter("HoraSalida");
		String curso = req.getParameter("Curso");
		Integer voto = 0;

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

			preparedStatement = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS USER (nombre VARCHAR(100), apellidos VARCHAR(100), DNI VARCHAR(9), horaEntrada TIME, horaSalida TIME, curso VARCHAR(9), voto INTEGER)");
			preparedStatement.executeUpdate();
			preparedStatement.close();
			preparedStatement = conn.prepareStatement(
					"INSERT INTO USER (nombre, apellidos, DNI, horaEntrada, horaSalida, curso, voto) VALUES (?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, apellidos);
			preparedStatement.setString(3, dni);
			preparedStatement.setString(4, horaEntrada);
			preparedStatement.setString(5, horaSalida);
			preparedStatement.setString(6, curso);
			preparedStatement.setInt(7, voto);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("IMPRIMIENDO LISTADO");
			preparedStatement = conn.prepareStatement("SELECT * FROM USER");
			ResultSet resultSet = preparedStatement.executeQuery();

			ArrayList<String[]> listAlumnos = new ArrayList<String[]>();
			while (resultSet.next()) {
				String string = resultSet.getString(1);
				String datosAlumno[] = { resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5),  resultSet.getString(6), resultSet.getString(7)};
				listAlumnos.add(datosAlumno);
				System.out.println(string);
			}
			req.setAttribute("alumnos", listAlumnos);
			preparedStatement.close();
			conn.close();
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

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.jsp");
		dispatcher.forward(req, resp);
	}
}
