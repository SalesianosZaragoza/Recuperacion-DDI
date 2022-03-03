package servlet;

import java.io.IOException;
import java.sql.*;
import java.time.LocalTime;
import java.time.ZoneId;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidationServlet extends HttpServlet{
    private String jdbcUrl = "jdbc:h2:file:./testdb";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String dni = req.getParameter("DNI");

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
            preparedStatement = conn.prepareStatement("SELECT u.nombre, u.apellidos, u.horaEntrada, u.horaSalida FROM USER as u WHERE u.DNI = ?");
            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();

            String nombreAlumnoSelec = new String();
            String apellidosAlumnoSelec = new String();
            String entradaAlumnoSelec = new String();
            String salidaAlumnoSelec = new String();
            String permiso= new String();


            while (resultSet.next()) {
                String string1 = resultSet.getString(1);
                nombreAlumnoSelec = string1;
                String string2 = resultSet.getString(2);
                apellidosAlumnoSelec = string2;
                String string3 = resultSet.getString(3);
                entradaAlumnoSelec = string3;
                String string4 = resultSet.getString(4);
                salidaAlumnoSelec = string4;
                permiso = PermisoEntrada(entradaAlumnoSelec ,salidaAlumnoSelec);

            }
            req.setAttribute("nombre", nombreAlumnoSelec);
            req.setAttribute("apellidos", apellidosAlumnoSelec);
            req.setAttribute("entrada", entradaAlumnoSelec);
            req.setAttribute("salida", salidaAlumnoSelec);
            req.setAttribute("permiso", permiso);

            preparedStatement.execute();
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

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/permiso.jsp");
        dispatcher.forward(req, resp);
    }

    public String PermisoEntrada(String hentrada, String hsalida){
        LocalTime hentradaTime= LocalTime.parse(hentrada);
        LocalTime hsalidaTime= LocalTime.parse(hsalida);
        ZoneId zona = ZoneId.of("Europe/Paris");
        LocalTime actual =LocalTime.now(zona);
        if((actual.isAfter(hentradaTime))&&(actual.isBefore(hsalidaTime)))
            return "Permitida";
        else
            return "Denegada";

    }

}

