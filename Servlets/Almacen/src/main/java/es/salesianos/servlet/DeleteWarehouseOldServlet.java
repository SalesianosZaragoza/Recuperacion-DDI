package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.service.WarehouseOldService;


public class DeleteWarehouseOldServlet extends HttpServlet{

	WarehouseOldService service = new WarehouseOldService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		service.deleteWarehouseOld(Integer.parseInt(id));
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listWarehouse.jsp");
		dispatcher.forward(req,resp);
	}
}
