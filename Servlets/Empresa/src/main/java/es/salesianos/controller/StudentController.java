package es.salesianos.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Student;
import es.salesianos.service.StudentService;



@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/insertStudent")
	public ModelAndView insertStudent() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", new Student());
		modelAndView.setViewName("addStudent");	
		return modelAndView;
	}
	
	@PostMapping("/insertStudent")
	public ModelAndView insertStudent(@ModelAttribute("student")Student student, HttpServletResponse httpResponse) {
		studentService.insert(student);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", studentService.searchAll());
		modelAndView.addObject("student", new Student());
		modelAndView.setViewName("listCompany");
		return modelAndView;
	}
	
	@GetMapping("/studentEdit")
	public ModelAndView editStudent(@RequestParam Integer id) {
		Student student = studentService.searchStudent(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("studentEdited");
		modelAndView.addObject("student", student);
		return modelAndView;
	}

	@PostMapping("/studentEdit")
	public ModelAndView editStudent(@ModelAttribute("student")Student student, HttpServletResponse httpResponse) {
		studentService.update(student);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", studentService.searchAll());
		modelAndView.addObject("student", new Student());
		modelAndView.setViewName("listCompany");
		return modelAndView;
	}
}
