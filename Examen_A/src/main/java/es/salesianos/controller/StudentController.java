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
import es.salesianos.model.Student;
import es.salesianos.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/studentList")
	public ModelAndView getStudentList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", service.listAll());
		modelAndView.setViewName("student_list");
		return modelAndView;
	}
	
	@GetMapping("/studentInsert")
	public ModelAndView studentInsert() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("student_insert");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}
	
	@PostMapping("/studentInsert")
	public void insertStudent(@ModelAttribute("student")Student student, HttpServletResponse httpResponse) {
		service.insert(student);
		try {
			httpResponse.sendRedirect("/studentList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/studentDelete")
	public void deleteStudent(@RequestParam Integer id, HttpServletResponse httpResponse) {
		service.delete(id);
		try {
			httpResponse.sendRedirect("/studentsList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/studentEdit")
	public ModelAndView getEditStudent(@RequestParam Integer id) {
		Student student = service.findById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("student_edit");
		modelAndView.addObject("student", student);
		return modelAndView;
	}

	@PostMapping("/studentEdit")
	public void editStudent(@ModelAttribute("student") Student studentForm, HttpServletResponse httpResponse) {
		service.update(studentForm);
		try {
			httpResponse.sendRedirect("/studentList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}