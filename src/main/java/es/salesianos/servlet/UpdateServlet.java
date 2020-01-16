package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import es.salesianos.model.Character;
import es.salesianos.service.CharacterService;

public class UpdateServlet extends SpringBaseServlet {

	@Autowired
	CharacterService service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		Integer idCharacter = Integer.parseInt(parameter);
		Character character = service.listById(idCharacter);
		req.setAttribute("character", character);
		redirect(req, resp, "Update.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String holder = req.getParameter("holder");
		Character character = new Character();
		System.out.println(id + " " + name + " " + age + " "+ holder);
		
		character.setId(Integer.parseInt(id));
		character.setName(name);
		character.setAge(Integer.parseInt(age));
		character.setHolder(Boolean.parseBoolean(holder));
		
		service.update(character);
		redirect(req, resp, "List.jsp");
	}


	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String page)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + page);
		dispatcher.forward(req, resp);
	}

}
