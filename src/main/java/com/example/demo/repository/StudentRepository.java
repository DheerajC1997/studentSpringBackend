package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;


public interface StudentRepository extends MongoRepository<Student,Integer> {
	
	Student findByName(String name);
	
	
}
