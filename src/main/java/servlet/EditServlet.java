package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet{
	private String jdbcUrl = "jdbc:h2:file:./testdb";
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("Nombre");
		String apellidos = req.getParameter("Apellidos");
		String dni = req.getParameter("DNI");
		String horaEntrada = req.getParameter("HoraEntrada");
		String horaSalida = req.getParameter("HoraSalida");
		String curso = req.getParameter("Curso");

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
					"UPDATE USER SET nombre= ?, apellidos= ?, DNI= ?, horaEntrada= ?, horaSalida= ?, curso = ? WHERE DNI = ?");
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, apellidos);
			preparedStatement.setString(3, dni);
			preparedStatement.setString(4, horaEntrada);
			preparedStatement.setString(5, horaSalida);
			preparedStatement.setString(6, curso);
			preparedStatement.setString(7, dni);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("IMPRIMIENDO LISTADO");
			preparedStatement = conn.prepareStatement("SELECT * FROM USER");
			ResultSet resultSet = preparedStatement.executeQuery();

			ArrayList<String[]> listAlumnos = new ArrayList<String[]>();
			while (resultSet.next()) {
				String string = resultSet.getString(1);
				String datosAlumno[] = { resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5),  resultSet.getString(6)};
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

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editar.jsp");
		dispatcher.forward(req, resp);
	}
}
