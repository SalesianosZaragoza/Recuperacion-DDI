package com.mycompany.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mycompany.model.Warehouse;
import com.mycompany.service.WarehouseService;

public class ListWarwehouseServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Warehouse> warehouses_old = service.listOld();
		List<Warehouse> warehouses_new = service.listNew();
		req.setAttribute("warehouses_old", warehouses_old);
		req.setAttribute("warehouses_new", warehouses_new);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListWarehouses.jsp");
		dispatcher.forward(req, resp);
	}


}
