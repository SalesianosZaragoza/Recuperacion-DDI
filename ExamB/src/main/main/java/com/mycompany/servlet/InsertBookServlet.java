package com.mycompany.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mycompany.model.Warehpouse;
import com.mycompany.model.Book;
import com.mycompany.service.WarehouseService;
import com.mycompany.service.BookService;

public class InsertBookServlet extends HttpServlet {

	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = service.createNewEntityFromRequest(req);
		service.insert(book);
		redirect(req,resp);
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Warehouse> warehouses_old = a_service.listOld();
		List<Warehouse> warehouses_new = a_service.listNew();
		req.setAttribute("warehouses_old", almacenes_old);
		req.setAttribute("warehouses_new", almacenes_new);
		redirect(req,resp);
	}

	protected void dredirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("/listBooks");
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insertBooks.jsp");
		dispatcher.forward(req,resp);
	}
}