package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Company;
import es.salesianos.service.CompanyService;

public class RecoveryAddIdCompanyServlet extends HttpServlet{
	CompanyService service = new CompanyService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Company companyForm= new Company();
		companyForm.setId(Integer.parseInt(id));
		req.setAttribute("company", companyForm);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addStudent.jsp");
		dispatcher.forward(req,resp);
	}
}
