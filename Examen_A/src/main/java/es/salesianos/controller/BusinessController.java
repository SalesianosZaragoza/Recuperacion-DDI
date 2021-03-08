package es.salesianos.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import es.salesianos.model.Business;
import es.salesianos.service.BusinessService;

@Controller
public class BusinessController {
	
	@Autowired
	private BusinessService service;
	
	@GetMapping("/businessList")
	public ModelAndView getBusinessList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", service.listAll());
		modelAndView.setViewName("business_list");
		return modelAndView;
	}
	
	@GetMapping("/businessInsert")
	public ModelAndView businessInsert() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("business_insert");
		modelAndView.addObject("business", new Business());
		return modelAndView;
	}
	
	@PostMapping("/businessInsert")
	public void insertBusiness(@ModelAttribute("business")Business business, HttpServletResponse httpResponse) {
		service.insert(business);
		try {
			httpResponse.sendRedirect("/businessList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/businessDelete")
	public void deleteBusiness(@RequestParam Integer id, HttpServletResponse httpResponse) {
		service.delete(id);
		try {
			httpResponse.sendRedirect("/businessList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/businessEdit")
	public ModelAndView getEditBusiness(@RequestParam Integer id) {
		Business business = service.findById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("business_edit");
		modelAndView.addObject("business", business);
		return modelAndView;
	}

	@PostMapping("/businessEdit")
	public void editBusiness(@ModelAttribute("business") Business businessForm, HttpServletResponse httpResponse) {
		service.update(businessForm);
		try {
			httpResponse.sendRedirect("/businessList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
