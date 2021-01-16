package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.service.WarehouseNewService;


public class DeleteWarehouseNewServlet extends HttpServlet{

	WarehouseNewService service = new WarehouseNewService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		service.deleteWarehouseNew(Integer.parseInt(id));
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listWarehouse.jsp");
		dispatcher.forward(req,resp);
	}
}
