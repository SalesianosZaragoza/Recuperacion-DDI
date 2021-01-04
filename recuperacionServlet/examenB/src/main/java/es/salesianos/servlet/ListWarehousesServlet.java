package es.salesianos.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Warehouse;
import es.salesianos.service.WarehouseService;

public class ListWarehousesServlet extends HttpServlet{
	
	private WarehouseService service = new WarehouseService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Warehouse> oldWarehouses = service.listOld();
		List<Warehouse> newWarehouses = service.listNew();
		req.setAttribute("oldWarehouses", oldWarehouses);
		req.setAttribute("newWarehouses", newWarehouses);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/list_warehouses.jsp");
		dispatcher.forward(req,resp);
	}

}
