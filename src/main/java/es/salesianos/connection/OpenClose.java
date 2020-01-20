package es.salesianos.connection;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OpenClose {

	Connection open(String ruta);

	void close(Connection conn);

	void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}