package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.salesianos.model.Company;
import es.salesianos.service.CompanyService;

public class ListCompanyServlet extends HttpServlet {
	private CompanyService service = new  CompanyService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Company> listAllCompany = service.listAllCompany();		
		req.setAttribute("listAllCompany", listAllCompany);
		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listCompany.jsp");
		dispatcher.forward(req,resp);
	}
}
