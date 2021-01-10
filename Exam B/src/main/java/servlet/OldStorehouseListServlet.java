package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OldStorehouse;
import service.OldStorehouseService;

public class OldStorehouseListServlet extends HttpServlet {
	private OldStorehouseService service = new OldStorehouseService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<OldStorehouse> listAllOldStorehouse = service.listAll();
		req.setAttribute("listAllOldstorehouse", listAllOldStorehouse);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/oldStorehouseList.jsp");
		dispatcher.forward(req, resp);
	}
}
