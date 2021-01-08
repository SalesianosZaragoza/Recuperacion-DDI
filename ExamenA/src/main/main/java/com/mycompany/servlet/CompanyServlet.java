package com.mycompany.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.model.Company;
import com.mycompany.service.Service;

	public class CompanyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		Company company = new Company();
		company.setId(Integer.parseInt(id));
		company.setName(name);
		System.out.println("" + company);
		service.insert(company);
		doAction(req, resp);
			
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insertCompany.jsp");
		dispatcher.forward(req, resp);
	}

}
