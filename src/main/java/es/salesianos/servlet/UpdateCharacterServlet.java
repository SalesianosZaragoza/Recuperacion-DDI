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
		String parameterId = req.getParameter("id");
		Integer id = Integer.parseInt(parameterId);
		String name = req.getParameter("name");
		String carrier = req.getParameter("carrier");
		String idRace = req.getParameter("race");
		Character character = new Character();
		character.setId(id);
		character.setName(name);
		character.setCarrier(carrier);
		try {
			character.setCodRace(idRace);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		service.update(character);

		req.setAttribute("character", character);
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateCharacter.jsp");
		dispatcher.forward(req, resp);
	}
}
