package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.WarehouseOld;
import es.salesianos.service.WarehouseOldService;

public class RecoveryAddIdWarehouseOldServlet extends HttpServlet{
	WarehouseOldService service = new WarehouseOldService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		WarehouseOld warehouseForm= new WarehouseOld();
		warehouseForm.setId(Integer.parseInt(id));
		req.setAttribute("warehouse", warehouseForm);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addBookOld.jsp");
		dispatcher.forward(req,resp);
	}
}
