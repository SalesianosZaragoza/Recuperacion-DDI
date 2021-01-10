package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.NewStorehouse;
import model.OldStorehouse;
import service.BookService;
import service.NewStorehouseService;
import service.OldStorehouseService;

public class BookServlet extends HttpServlet {

	private BookService service = new BookService();
	private NewStorehouseService nService = new NewStorehouseService();
	private OldStorehouseService oService = new OldStorehouseService();
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book storehouse = service.assembleBookFromRequest(req);
		service.insertOrUpdate(storehouse);
		List<NewStorehouse> listAllNewStorehouse = nService.listAll();
		req.setAttribute("listAllNewStorehouse", listAllNewStorehouse);
		List<OldStorehouse> listAlloldtorehouse = oService.listAll();
		req.setAttribute("listAlloldtorehouse", listAlloldtorehouse);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insertBook.jsp");
		dispatcher.forward(req, resp);
	}

	public BookService getService() {
		return service;
	}

	public void setService(BookService service) {
		this.service = service;

	}
}
