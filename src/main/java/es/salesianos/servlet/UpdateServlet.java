package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.User;
import es.salesianos.service.UserService;

public class UpdateServlet extends HttpServlet {

	UserService service = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		Integer idUser = Integer.parseInt(parameter);
		// Select * from USER where id=?
		User user = service.listById(idUser);
		req.setAttribute("usuario", user);
		redirect(req, resp);

	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Update.jsp");
		dispatcher.forward(req, resp);
	}

}
