package es.salesianos.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Book;
import es.salesianos.model.Warehouse;
import es.salesianos.service.WarehouseService;
import es.salesianos.service.BookService;

public class BookInsertServlet extends HttpServlet{
	
	private BookService service = new BookService();
	private WarehouseService warehouse_service = new WarehouseService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = service.createNewEntityFromRequest(req);
		service.insert(book);
		dredirect(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Warehouse> oldWarehouses = warehouse_service.listOld();
		List<Warehouse> newWarehouses = warehouse_service.listNew();
		req.setAttribute("almacenes_old", oldWarehouses);
		req.setAttribute("almacenes_new", newWarehouses);
		redirect(req,resp);
	}

	protected void dredirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("/insertarLibro");
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/libros_insertar.jsp");
		dispatcher.forward(req,resp);
	}
}
