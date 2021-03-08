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

import es.salesianos.model.Book;
import es.salesianos.service.BookService;
import es.salesianos.service.WarehouseService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	@Autowired
	private WarehouseService warehouse_service;
	
	@GetMapping("/BookList")
	public ModelAndView getBookList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", service.listAll());
		modelAndView.setViewName("book_list");
		return modelAndView;
	}
	
	@GetMapping("/BookInsert")
	public ModelAndView BookInsert() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("book_insert");
		modelAndView.addObject("book", new Book());
		modelAndView.addObject("oldWarehouses", warehouse_service.listOld());
		modelAndView.addObject("newWarehouses", warehouse_service.listNew());
		return modelAndView;
	}
	
	@PostMapping("/BookInsert")
	public void postBookInsert(@ModelAttribute("book")Book book, HttpServletResponse httpResponse) {
		book.setEditionDate(book.getDateString());
		book.setWarehouseOld(book.getWarehouseOldId() != null);
		service.insert(book);
		try {
			httpResponse.sendRedirect("BookList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/BookDelete")
	public void bookDelete(@RequestParam Integer id, HttpServletResponse httpResponse) {
		service.delete(id);
		try {
			httpResponse.sendRedirect("/BookList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}