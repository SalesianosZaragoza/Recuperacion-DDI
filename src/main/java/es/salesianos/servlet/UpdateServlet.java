package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import es.salesianos.model.Character;

import es.salesianos.service.CharacterService;

public class UpdateServlet extends HttpServlet {

	CharacterService service = new CharacterService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//String parameter = req.getParameter("id");
		Integer idCharacter= Integer.parseInt(req.getParameter("id"));
		
		Character character = service.listById(idCharacter);

		req.setAttribute("character", character);
		redirect(req, resp, "Update.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		Integer codRace = Integer.parseInt(req.getParameter("codRace"));
		String bearer = req.getParameter("bearer");	

		Character user = new Character();
		System.out.println(id + "" + name + "" + bearer);
				
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setCodRace(codRace);
		user.setBearer(bearer);
		
		service.update(user);
		redirect(req, resp, "Listed.jsp");
	}


	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String page)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + page);
		dispatcher.forward(req, resp);
	}

}
