package com.college.crudstudent.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.college.crudstudent.entity.StudentEntity;
import com.college.crudstudent.service.StudentService;



@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<StudentEntity> listOfStudents = studentService.findAll();
		model.addAttribute("studentsList",listOfStudents);
		System.out.print("GET //");
		return "index";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("student", new StudentEntity());
		return "new";
		
	}
	
	@PostMapping("/save")
	public String saveRecord(@ModelAttribute("student") StudentEntity studentEntity) {
		studentService.save(studentEntity);
		return "redirect:/";
		
	}
	
	@RequestMapping("/edit/{id}")
	//@PutMapping("/edit/{id}") //Once check this too whether working or not
	public ModelAndView editStudent(@PathVariable int id) { //Check whether int leads to mishap, if any issue exists change datatype to long
		ModelAndView modelAndView = new ModelAndView("new");
		StudentEntity studentEntity = studentService.findById(id);
		modelAndView.addObject("student", studentEntity);
		return modelAndView;
		
	}
	
	@RequestMapping("/delete/{id}")
	//@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteById(id);
		return "redirect:/";
	}

}
