package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import service.BookService;

public class BookListServlet extends HttpServlet {
	private BookService service = new BookService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book> listAllBook = service.listAll();
		req.setAttribute("listAllBook", listAllBook);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bookList.jsp");
		dispatcher.forward(req, resp);
	}
}
