package com.nala.spring.data.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nala.spring.data.mongodb.model.BowlType;

public interface BowlTypeRepository extends MongoRepository<BowlType, String> {
	
	 List<BowlType> findByName(String name);
	 
	 @Query("{'$or' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	 List<BowlType> findBowlTypeByQuery(String name, String description);
	 
	 @Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	 List<BowlType> findBowlTypeByRegexpNameAndDescription(String name, String description);
	 
	 @Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}} ")
	 List<BowlType> findBowlTypeByRegexpName(String regexp);
	 
	 @Query("{ 'description' : { '$regex' : ?0 , $options: 'i'}} ")
	 List<BowlType> findBowlTypeByRegexpDescription(String regexp);

}
