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

public class WarehouseListServlet extends HttpServlet{
	
	private WarehouseService service = new WarehouseService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Warehouse> newWarehouses = service.listOld();
		List<Warehouse> oldWarehouses = service.listNew();
		req.setAttribute("warehouse_old", newWarehouses);
		req.setAttribute("warehouse_new", oldWarehouses);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/warehouse_list.jsp");
		dispatcher.forward(req,resp);
	}

}
