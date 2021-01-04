package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Enterprise;
import service.EnterpriseService;

public class EnterpriseServlet extends HttpServlet {

	private EnterpriseService service = new EnterpriseService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enterprise enterprise = service.assembleUserFromRequest(req);
		service.insertOrUpdate(enterprise);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/enterpriseList.jsp");
		dispatcher.forward(req, resp);
	}

	public EnterpriseService getService() {
		return service;
	}

	public void setService(EnterpriseService service) {
		this.service = service;
	}

}
