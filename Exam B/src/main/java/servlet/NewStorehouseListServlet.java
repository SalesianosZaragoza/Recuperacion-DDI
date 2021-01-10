package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewStorehouse;
import service.NewStorehouseService;

public class NewStorehouseListServlet extends HttpServlet {
	private NewStorehouseService service = new NewStorehouseService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<NewStorehouse> listAllNewStorehouse = service.listAll();
		req.setAttribute("listAllNewStorehouse", listAllNewStorehouse);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newStorehouseList.jsp");
		dispatcher.forward(req, resp);
	}
}
