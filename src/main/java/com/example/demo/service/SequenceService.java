package com.example.demo.service;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DatabaseSequence;
import com.example.demo.entity.Student;
import com.example.demo.repository.SequenceRepoitory;

@Service
public class SequenceService {
	
	@Autowired
	private SequenceRepoitory repoitory;
	
	
	
	public void update(int seq) {
		DatabaseSequence db= new DatabaseSequence(Student.SequenceName, seq);

//		db.setId(Student.SequenceName);
//		db.setSeq(seq);
		repoitory.save(db);
	}
	
	public int findSequence() {
		DatabaseSequence sequ = repoitory.findById(Student.SequenceName).orElse(null);
		if(sequ == null) {
			System.out.println(2);
			return(1);
			
		}
		else {
			System.out.println(2);
		return(sequ.getSeq()+1);
		}
	}

}
