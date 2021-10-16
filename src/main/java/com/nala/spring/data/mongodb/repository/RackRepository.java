package com.nala.spring.data.mongodb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.nala.spring.data.mongodb.model.Rack;

public interface RackRepository  extends MongoRepository<Rack, String>{
	
	@Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'rackType' : { '$regex' : ?1 , $options: 'i'}}, { 'maptoRobot' : { '$regex' : ?2 , $options: 'i'}}, { 'status' : { '$regex' : ?3 , $options: 'i'}}]}")
	Page<Rack> search(String name, String rackType, String maptoRobot, String status, Pageable pageable);

}
