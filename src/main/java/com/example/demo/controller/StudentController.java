package com.example.demo.controller;
// will talk to service class

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student student) {
		Student newservice = service.getStudentByName(student.getName());
		// validation statement : if already same name exist ,it wont work
		if(newservice == null){
			service.saveStudent(student);
			//System.out.println("Success");
			return ("Sucess");
		}
		else {
			//System.out.println("Failure : Identical name exist");
			return("Failure : Identical name exist");
		}
		
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addStudents")
	public List<Student> addStudents(@RequestBody List<Student> student){
		return service.saveStudents(student);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	//@GetMapping("/getStudents")
	 @RequestMapping(value = "/getStudents", method = RequestMethod.GET, produces = { "application/json" })
	public List<Student> findAllStudents(){
		List<Student> xyz = service.getStudents();
		//return service.getStudents();
		return xyz;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getStudentById")
	public Student findStudentById(@RequestParam int id) {
		return service.getStudentById(id);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getStudentByName/{name}")
	public Student findStudentByName(@PathVariable String name) {
		return service.getStudentByName(name);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}

	
	
	

}
