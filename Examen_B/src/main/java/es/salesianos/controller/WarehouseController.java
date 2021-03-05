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

import es.salesianos.model.Warehouse;
import es.salesianos.service.WarehouseService;

@Controller
public class WarehouseController {
	
	@Autowired
	private WarehouseService service;
	
	
	@GetMapping("/WarehouseList")
	public ModelAndView getWarehouseList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listOld", service.listOld());
		modelAndView.addObject("listNew", service.listNew());
		modelAndView.setViewName("warehouse_list");
		return modelAndView;
	}
	
	@GetMapping("/WarehouseInsert")
	public ModelAndView warehouseInsert() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("warehouse_insert");
		modelAndView.addObject("warehouse", new Warehouse());
		return modelAndView;
	}
	
	@PostMapping("/WarehouseInsert")
	public void postWarehouseInsert(@ModelAttribute("warehouse")Warehouse warehouse, HttpServletResponse httpResponse) {
		warehouse.setOld(warehouse.getTipo().equals("true"));
		service.insert(warehouse);
		try {
			httpResponse.sendRedirect("/WarehouseList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/WarehouseDeleteOld")
	public void warehouseDeleteOld(@RequestParam Integer id, HttpServletResponse httpResponse) {
		service.deleteOld(id);
		try {
			httpResponse.sendRedirect("/WarehouseList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/WarehouseDeleteNew")
	public void warehouseDeleteNew(@RequestParam Integer id, HttpServletResponse httpResponse) {
		service.deleteOld(id);
		try {
			httpResponse.sendRedirect("/WarehouseList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}