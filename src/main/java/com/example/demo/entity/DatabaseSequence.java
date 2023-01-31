package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "DBsequence")
public class DatabaseSequence {
	@Id
	private String id;
	private int seq;
	
	
	
	
	
	public DatabaseSequence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DatabaseSequence(String id, int seq) {
		super();
		this.id = id;
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}

}
