package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.WarehouseOld;
import es.salesianos.service.WarehouseOldService;

public class AddWarehouseOldServlet extends HttpServlet {
private WarehouseOldService service = new WarehouseOldService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WarehouseOld warehouseOld = service.assembleWarehouseOldFromRequest(req);
		service.addWarehouseOld(warehouseOld);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(req,resp);
	}
	
}