package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Company;
import es.salesianos.service.CompanyService;

public class AddCompanyServlet extends HttpServlet {
private CompanyService service = new CompanyService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Company owner = service.assembleCompanyFromRequest(req);
		service.addCompany(owner);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(req,resp);
	}
	
}