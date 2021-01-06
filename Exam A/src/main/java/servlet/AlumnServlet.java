package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Alumn;
import models.Enterprise;
import service.AlumnService;
import service.EnterpriseService;


public class AlumnServlet extends HttpServlet {
	private AlumnService service = new AlumnService();
	private EnterpriseService eService = new EnterpriseService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Alumn alumn = service.assembleUserFromRequest(req);
		service.insertOrUpdate(alumn);
		List<Enterprise> listAllEnterprises = eService.listAllEnterprises();
		req.setAttribute("listAllEnterprises", listAllEnterprises);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insertAlumn.jsp");
		dispatcher.forward(req, resp);
	}

	public AlumnService getService() {
		return service;
	}

	public void setService(AlumnService service) {
		this.service = service;
	}
}
