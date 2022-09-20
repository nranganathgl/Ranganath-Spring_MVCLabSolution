package com.gl.student.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.gl.student.mgmt.entity.Student;
import com.gl.student.mgmt.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/")
	public String helloWorld() {
		return "demo";
	}
	
	@RequestMapping("/showStudents")
	public String getStudents(Model theModel) {
		
		List<Student> studentsList = studentService.findAll();
        theModel.addAttribute("students", studentsList);
		return "list-students";
	}
	
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Student theCustomer = new Student();
        theModel.addAttribute("student",theCustomer);
        return "student-form";
    }
    
    @PostMapping("/saveStudent")
    public String saveCustomer(@ModelAttribute("customer")Student theStudent){
    	studentService.save(theStudent);
        //return "list-customers";
        return "redirect:/showStudents";
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId")int student_Id, Model theModel){

        Student student = studentService.getStudent(student_Id);
        theModel.addAttribute(student);
        return "student-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("studentId") int student_Id){
    	studentService.deleteById(student_Id);
        return "redirect:/showStudents";
    }

}
