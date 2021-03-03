package es.salesianos.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.model.Business;
import es.salesianos.service.BusinessService;


public class BusinessListServlet extends HttpServlet{
	
	private BusinessService service = new BusinessService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Business> business = service.listAll();
		req.setAttribute("business", business);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/business_list.jsp");
		dispatcher.forward(req,resp);
	}

}
