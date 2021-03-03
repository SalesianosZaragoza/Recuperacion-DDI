package es.salesianos.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Business;
import es.salesianos.service.BusinessService;


public class BusinessConfirmDeleteServlet extends HttpServlet{
	
	private BusinessService service = new BusinessService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Business business = service.updateEntityFromRequest(req);
		if (req.getParameter("studentDelete").equals("true")) {
			service.delete(business, true);
		} else {			
			service.delete(business, false);
		}
		dredirect(req,resp);
	}
	
	protected void dredirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("/businessList");
	}
}
