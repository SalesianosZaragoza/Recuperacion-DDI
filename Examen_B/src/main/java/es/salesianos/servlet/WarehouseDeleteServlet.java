package es.salesianos.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Warehouse;
import es.salesianos.service.WarehouseService;

public class WarehouseDeleteServlet extends HttpServlet{
	
	private WarehouseService service = new WarehouseService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		Integer id = Integer.parseInt(req.getParameter("id"));
		Warehouse warehouse = null;
		if (type.equals("old")) {
			warehouse = service.findByOld(id);
		} else if (type.equals("new")) {
			warehouse = service.findByNew(id);
		}
		service.delete(warehouse);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("/listadoAlmacenes");
	}
	
}
