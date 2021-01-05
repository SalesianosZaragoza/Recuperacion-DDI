package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.service.EmpresaService;


public class deleteEmpresaServlet extends HttpServlet{

	EmpresaService service = new EmpresaService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String answer = req.getParameter("answer");	
		String id = req.getParameter("id");
		service.deleteEmpresa(Integer.parseInt(id), answer);
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listAlmacen.jsp");
		dispatcher.forward(req,resp);
	}
}
