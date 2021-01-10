package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewStorehouse;
import service.NewStorehouseService;

public class NewStorehouseServlet extends HttpServlet {

	private NewStorehouseService service = new NewStorehouseService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewStorehouse storehouse = service.assembleStoreFromRequest(req);
		service.insertOrUpdate(storehouse);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insertNewStorehouse.jsp");
		dispatcher.forward(req, resp);
	}

	public NewStorehouseService getService() {
		return service;
	}

	public void setService(NewStorehouseService service) {
		this.service = service;

	}
}
