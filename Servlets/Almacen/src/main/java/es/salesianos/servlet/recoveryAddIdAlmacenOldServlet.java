package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.AlmacenOld;
import es.salesianos.service.AlmacenOldService;

public class recoveryAddIdAlmacenOldServlet extends HttpServlet{
	AlmacenOldService service = new AlmacenOldService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		AlmacenOld almacenForm= new AlmacenOld();
		almacenForm.setId(Integer.parseInt(id));
		req.setAttribute("almacen", almacenForm);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addLibroOld.jsp");
		dispatcher.forward(req,resp);
	}
}
