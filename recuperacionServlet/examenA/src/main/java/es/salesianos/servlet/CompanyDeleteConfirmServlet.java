package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Company;
import es.salesianos.service.CompanyService;

public class CompanyDeleteConfirmServlet extends HttpServlet {
	private CompanyService service = new CompanyService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Company companies = service.updateEntityFromRequest(req);
		if (req.getParameter("deleteStudents").equals("true")) {
			service.delete(companies, true);
		} else {			
			service.delete(companies, false);
		}
		dredirect(req,resp);
	}
	
	protected void dredirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("/listCompanies");
	}
}
