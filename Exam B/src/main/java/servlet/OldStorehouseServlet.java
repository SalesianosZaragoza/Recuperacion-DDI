package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OldStorehouse;
import service.OldStorehouseService;;

public class OldStorehouseServlet extends HttpServlet {
	private OldStorehouseService service = new OldStorehouseService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OldStorehouse storehouse = service.assembleStoreFromRequest(req);
		service.insertOrUpdate(storehouse);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insertOldStorehouse.jsp");
		dispatcher.forward(req, resp);
	}

	public OldStorehouseService getService() {
		return service;
	}

	public void setService(OldStorehouseService service) {
		this.service = service;

	}
}
