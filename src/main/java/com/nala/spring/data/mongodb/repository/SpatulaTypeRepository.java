package com.nala.spring.data.mongodb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nala.spring.data.mongodb.model.SpatulaType;

public interface SpatulaTypeRepository extends MongoRepository<SpatulaType, String>{
	
	@Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'status' : { '$regex' : ?1 , $options: 'i'}}]}")
	Page<SpatulaType> search(String name, String status, Pageable pageable);
}
