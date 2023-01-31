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
import com.example.demo.repository.SequenceRepoitory;
import com.example.demo.service.SequenceService;
import com.example.demo.service.StudentService;

@RestController 
public class StudentController {
	
	@Autowired
	private StudentService service;
	@Autowired
	private SequenceService sequence;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student student) {
		if(student.getId()==null) {
			Student newservice = service.getStudentByName(student.getName());
			// validation statement : if already same name exist ,it wont work
			if(newservice == null){
				//id generated
				int newId=sequence.findSequence();
				String setNewId="R-";
			
				if(newId<10) {setNewId=setNewId+"00"+newId;}
				else if (newId<100) {setNewId=setNewId+"0"+newId;}
				else {setNewId=setNewId+newId;}
						
				student.setId(setNewId);
				//student.setId(newId);
				service.saveStudent(student);
				sequence.update(newId);
				return ("Sucess");
			}
			else {
				return("Failure : Identical name exist");
			}
		}else {
			 service.saveStudent(student);
			 return ("Updated");
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
	public Student findStudentById(@RequestParam String id) {
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
	public String deleteStudent(@PathVariable String id) {
		return service.deleteStudent(id);
	}

	
	
	

}
