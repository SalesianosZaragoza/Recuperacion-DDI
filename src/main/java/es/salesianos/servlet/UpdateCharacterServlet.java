package es.salesianos.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Character;
import es.salesianos.service.CharacterService;
import es.salesianos.service.Service;

public class UpdateCharacterServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	Service<Character> service = new CharacterService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		Integer idCharacter = Integer.parseInt(parameter);
		
		Character character = service.listById(idCharacter);
		req.setAttribute("character", character);
		redirect(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Character character = service.updateDataFromRequest(req);
		service.update(character);
		req.setAttribute("character", character);
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListCharacters.jsp");
		dispatcher.forward(req, resp);
	}
}
