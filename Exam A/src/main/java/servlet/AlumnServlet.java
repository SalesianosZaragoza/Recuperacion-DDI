package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Alumn;
import service.AlumnService;

public class AlumnServlet extends HttpServlet {
	private AlumnService service = new AlumnService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Alumn enterprise = service.assembleUserFromRequest(req);
		service.insertOrUpdate(enterprise);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/alumnList.jsp");
		dispatcher.forward(req, resp);
	}

	public AlumnService getService() {
		return service;
	}

	public void setService(AlumnService service) {
		this.service = service;
	}
}
