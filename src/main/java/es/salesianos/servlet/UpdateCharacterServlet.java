package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.LordOfTheRingsCharacter;
import es.salesianos.service.CharacterService;

public class UpdateCharacterServlet extends HttpServlet {

	CharacterService service = new CharacterService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		Integer idCharacter = Integer.parseInt(parameter);
		LordOfTheRingsCharacter character = (LordOfTheRingsCharacter) service.listById(idCharacter);
		req.setAttribute("personaje", character);
		redirect(req, resp, "UpdateCharacter.jsp");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		Integer idUser = Integer.parseInt(parameter);
		String name = req.getParameter("nombre");
		String bearer = req.getParameter("portador");
		Integer codRace = req.getIntHeader("codRaza");
		LordOfTheRingsCharacter character = new LordOfTheRingsCharacter();
		character.setCharacterName(name);
		character.setRingBearer(bearer);
		character.setCodRace(codRace);
		character.setId(idUser);
		service.update(character);
		redirect(req, resp, "CharacterList.jsp");

	}


	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String page)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + page);
		dispatcher.forward(req, resp);
	}

}
