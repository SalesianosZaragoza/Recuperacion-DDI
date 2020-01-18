package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.assembler.CharacterAssembler;
import es.salesianos.model.Character;
import es.salesianos.service.CharacterService;

public class UpdateCharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CharacterService service = new CharacterService();
	CharacterAssembler assembler = new CharacterAssembler();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		Integer id = Integer.parseInt(parameter);
		Character character = service.findBy(id);
		req.setAttribute("character", character);
		redirect(req, resp, "updateCharacter.jsp");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Character character = service.createNewFromRequest(req);
		character.setId(Integer.parseInt(req.getParameter("id")));
		service.update(character);
		redirect(req, resp, "ListCharacter.jsp");

	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String url)
		throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + url);
		dispatcher.forward(req, resp);
	}
} 