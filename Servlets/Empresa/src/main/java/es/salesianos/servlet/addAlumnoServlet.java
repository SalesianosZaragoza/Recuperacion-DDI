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


public class addAlumnoServlet extends HttpServlet{
	private AlumnoService service = new AlumnoService();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Alumno alumno = AlumnoAssembler.assembleAlumnoFrom(req);
		service.addAlumno(alumno);
		redirect(req, resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listEmpresa.jsp");
		dispatcher.forward(req,resp);
	}
}
