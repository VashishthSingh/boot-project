package com.nala.spring.data.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nala.spring.data.mongodb.model.ActionType;

public interface ActionTypeRepository extends MongoRepository<ActionType, String>{
	
	 List<ActionType> findByName(String name);
	 
	 @Query("{'$or' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	 List<ActionType> findActionTypeByQuery(String name, String description);
	 
	 @Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	 List<ActionType> findActionTypeByRegexpNameAndDescription(String name, String description);
	 
	 @Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}} ")
	 List<ActionType> findActionTypeByRegexpName(String regexp);
	 
	 @Query("{ 'description' : { '$regex' : ?0 , $options: 'i'}} ")
	 List<ActionType> findActionTypeByRegexpDescription(String regexp);
	 
}
