package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Libro;
import es.salesianos.model.assembler.LibroAssembler;
import es.salesianos.service.LibroService;


public class addLibroNewServlet extends HttpServlet{
	private LibroService service = new LibroService();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Libro libro = LibroAssembler.assembleLibroFrom(req);
		if(libro.getFechaEdicion().getYear() >=  2000)
			service.addLibro(libro);
		redirect(req, resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listOwner.jsp");
		dispatcher.forward(req,resp);
	}
}
