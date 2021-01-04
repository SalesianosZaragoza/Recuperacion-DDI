package es.salesianos.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Warehouse;
import es.salesianos.service.WarehouseService;

public class InsertWarehouseServlet extends HttpServlet{
	
	private WarehouseService service = new WarehouseService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Warehouse warehouse = service.createNewEntityFromRequest(req);
		service.insert(warehouse);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("/listWarehouses");
	}
	
}
