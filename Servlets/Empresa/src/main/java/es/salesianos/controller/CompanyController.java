package es.salesianos.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Company;
import es.salesianos.service.CompanyService;

@Controller
public class CompanyController extends HttpServlet {
	
	@Autowired 
	private CompanyService companyService;
	
	@GetMapping("/insertCompany")
	public ModelAndView insertCompany() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addCompany");
		modelAndView.addObject("business", new Company());
		return modelAndView;
	}

	@PostMapping("/insertCompany")
	public ModelAndView insertCompany(@ModelAttribute("company")Company company, HttpServletResponse httpResponse) {
		companyService.addCompany(company);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", companyService.listAllCompany());
		modelAndView.setViewName("listCompany");
		return modelAndView;
	}

	@GetMapping("/deleteCompany")
	public ModelAndView deleteCompany(@RequestParam Integer id,@RequestParam String answer, HttpServletResponse httpResponse) {
		companyService.deleteCompany(id,answer);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", companyService.listAllCompany());
		modelAndView.setViewName("listCompany");
		return modelAndView;
	}
	
	
}