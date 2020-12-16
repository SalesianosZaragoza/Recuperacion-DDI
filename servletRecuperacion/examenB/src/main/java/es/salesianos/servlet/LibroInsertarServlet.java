package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Almacen;
import es.salesianos.model.Libro;
import es.salesianos.service.AlmacenService;
import es.salesianos.service.LibroService;

public class LibroInsertarServlet extends HttpServlet{
	
	private LibroService service = new LibroService();
	private AlmacenService a_service = new AlmacenService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Libro libro = service.createNewEntityFromRequest(req);
		service.insert(libro);
		dredirect(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Almacen> almacenes_old = a_service.listOld();
		List<Almacen> almacenes_new = a_service.listNew();
		req.setAttribute("almacenes_old", almacenes_old);
		req.setAttribute("almacenes_new", almacenes_new);
		redirect(req,resp);
	}

	protected void dredirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("/listadoLibros");
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/libros_insertar.jsp");
		dispatcher.forward(req,resp);
	}
}
