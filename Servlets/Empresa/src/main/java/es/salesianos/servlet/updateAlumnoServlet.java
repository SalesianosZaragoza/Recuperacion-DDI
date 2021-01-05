package es.salesianos.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Alumno;
import es.salesianos.model.assembler.AlumnoAssembler;
import es.salesianos.service.AlumnoService;

public class updateAlumnoServlet extends HttpServlet{
	AlumnoService service = new AlumnoService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Alumno owner = AlumnoAssembler.assembleAlumnoFrom(req);
		service.update(owner);
		redirect(req, resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listEmpresa.jsp");
		dispatcher.forward(req,resp);
	}
}
