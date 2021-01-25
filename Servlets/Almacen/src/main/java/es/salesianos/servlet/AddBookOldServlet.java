package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Book;
import es.salesianos.model.assembler.BookAssembler;
import es.salesianos.service.BookService;


public class AddBookOldServlet extends HttpServlet{
	private BookService service = new BookService();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = BookAssembler.assembleBookFrom(req);
		service.dateEditionLower(book);
		redirect(req, resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listWarehouse.jsp");
		dispatcher.forward(req,resp);
	}
}
