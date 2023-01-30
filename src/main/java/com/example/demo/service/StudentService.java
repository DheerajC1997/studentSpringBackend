package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;



@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public Student saveStudent(Student student) {
		
		return repository.save(student);
	}
	public List<Student> saveStudents(List<Student>student){
		return repository.saveAll(student);
	}
	public List<Student> getStudents(){
		return repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		//return repository.findAll();
	}
	public Student getStudentById(int id) {
//		Optional<Student> findById=repository.findById(id);
//		Student student=findById.get();
//		return student;
//		Optional<Student> findById = repository.findById(id);
//		Student student1 =findById.orElse(new Student());
//		return student1;
		return repository.findById(id).orElse(null);
	}
	public Student getStudentByName(String name) {
		return repository.findByName(name);
	}
	public String deleteStudent(int id) {
		repository.deleteById(id);
		return "Product removed"+id;
	}
	public Student updateStudent(Student student) {
		Student existingStudent = repository.findById(student.getId()).orElse(null);
//		existingStudent.setName(student.getName());
//		existingStudent.setDate(student.getDate());
//		existingStudent.setClasses(student.getClasses());
//		existingStudent.setDivision(student.getDivision());
//		existingStudent.setGender(student.getGender());
//		return repository.save(existingStudent);
		if(existingStudent != null) {
			 repository.save(student);
		}
		return null;
	}
	
	}
