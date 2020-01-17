package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.LordOfTheRingsCharacter;
import es.salesianos.service.CharacterService;
import es.salesianos.service.Service;

public class CharacterListServlet extends HttpServlet {

	CharacterService service = new CharacterService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<LordOfTheRingsCharacter> characters = service.listAll();
		req.setAttribute("listOfCharacters", characters);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CharacterList.jsp");
		dispatcher.forward(req, resp);
	}


}
