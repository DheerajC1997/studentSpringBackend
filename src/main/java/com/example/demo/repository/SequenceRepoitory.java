package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.DatabaseSequence;

public interface SequenceRepoitory extends MongoRepository<DatabaseSequence, String> {

}
