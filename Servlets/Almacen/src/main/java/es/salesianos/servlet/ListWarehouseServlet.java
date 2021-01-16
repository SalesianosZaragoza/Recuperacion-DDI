package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.salesianos.model.WarehouseNew;
import es.salesianos.model.WarehouseOld;
import es.salesianos.service.WarehouseNewService;
import es.salesianos.service.WarehouseOldService;

public class ListWarehouseServlet extends HttpServlet {
	private WarehouseNewService warehouseNewService = new  WarehouseNewService();
	private WarehouseOldService warehouseOldService = new  WarehouseOldService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<WarehouseOld> listAllWarehouseesOld = warehouseOldService.listAllWarehouseesOld();
		List<WarehouseNew> listAllWarehouseesNew = warehouseNewService.listAllWarehouseesNew();
		req.setAttribute("listAllWarehouseOld", listAllWarehouseesOld);
		req.setAttribute("listAllWarehouseNew", listAllWarehouseesNew);
		
		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listWarehouse.jsp");
		dispatcher.forward(req,resp);
	}
}
