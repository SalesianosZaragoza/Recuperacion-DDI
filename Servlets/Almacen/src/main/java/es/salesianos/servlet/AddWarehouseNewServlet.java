package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.WarehouseNew;
import es.salesianos.service.WarehouseNewService;



public class AddWarehouseNewServlet extends HttpServlet {
private WarehouseNewService service = new WarehouseNewService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WarehouseNew warehouseNew = service.assembleWarehouseNewFromRequest(req);
		service.addWarehouseNew(warehouseNew);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(req,resp);
	}
	
}