package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class VoteServlet extends HttpServlet{
    private String jdbcUrl = "jdbc:h2:file:./testdb";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dni = req.getParameter("DNI");
        String voto = req.getParameter("voto") ;

//        Integer votoNum = Integer.parseInt(voto);

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
            preparedStatement = conn.prepareStatement("UPDATE USER SET nombre = ? WHERE DNI = ?");
            preparedStatement.setString(1, voto);
            preparedStatement.setString(2, dni);
            preparedStatement.executeUpdate();
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

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
