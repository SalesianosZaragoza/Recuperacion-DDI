package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.salesianos.model.Character;
import es.salesianos.service.CharacterService;
import es.salesianos.service.Service;


public class CharacterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Autowired
	@Qualifier("characterService")
	private Service<Character> service = new CharacterService(); 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Character character = service.createNewDataFromRequest(req);
		service.insert(character);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcomeCharacter.jsp");
		dispatcher.forward(req, resp);
	}
}
