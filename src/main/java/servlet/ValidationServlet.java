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

public class ValidationServlet extends HttpServlet{
    private String jdbcUrl = "jdbc:h2:file:./testdb";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("Nombre");
        String apellidos = req.getParameter("Apellidos");
        String dni = req.getParameter("DNI");
        String horaEntrada = req.getParameter("HoraEntrada");
        String horaSalida = req.getParameter("HoraSalida");


        Connection conn;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(jdbcUrl , "sa", "");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement("SELECT u.nombre, u.apellidos FROM USER as u WHERE u.DNI == ?");
            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();

            String nombreAlumnoSelec = new String();
            String apellidosAlumnoSelec = new String();

            while (resultSet.next()) {
                String string1 = resultSet.getString(1);
                nombreAlumnoSelec = string1;
                String string2 = resultSet.getString(2);
                apellidosAlumnoSelec = string2;
            }
            req.setAttribute("alumno", nombreAlumnoSelec);
            req.setAttribute("apellidos", apellidosAlumnoSelec);


            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
            System.out.println("IMPRIMIENDO LISTADO");
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

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/comprobacionForm.jsp");
        dispatcher.forward(req, resp);
    }

}

