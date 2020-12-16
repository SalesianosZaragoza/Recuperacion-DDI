package es.salesianos.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import es.salesianos.model.Alumno;
import es.salesianos.model.Empresa;

import es.salesianos.service.Service;

public class AlumnoServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


	private Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nombre");
		Integer edad = Integer.parseInt(req.getParameter("edad"));
		String asiste = req.getParameter("asiste");
		Integer empresa = Integer.parseInt(req.getParameter("empresa"));
		Alumno alumno = new Alumno();
		alumno.setNombre(nom);
		alumno.setEdad(edad);
		alumno.setAsisteFCT(Boolean.getBoolean(asiste));
		alumno.setEmpresa(empresa);
		service.insert(alumno);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insertarEmpresa.jsp");
		dispatcher.forward(req, resp);
	}
}
