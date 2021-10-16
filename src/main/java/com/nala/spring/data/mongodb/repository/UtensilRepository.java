package com.nala.spring.data.mongodb.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nala.spring.data.mongodb.model.Utensil;


public interface UtensilRepository extends MongoRepository<Utensil, String>{
	
	
	List<Utensil> findByName(String name);
	
	 @Query("{ 'name' : { $regex: ?0 } }")
	 List<Utensil> findUtensilRegexpName(String regexp);
	
	 @Query("{'$or' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	 List<Utensil> findUtensilByQuery(String name, String description);
	 
	 @Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	 List<Utensil> findUtensilByRegexpNameAndDescription(String name, String description);
	  	
	 @Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}} ")
	 List<Utensil> findUtensilByRegexpName(String regexp);
	 
	 @Query("{ 'description' : { '$regex' : ?0 , $options: 'i'}} ")
	 List<Utensil> findUtensilByRegexpDescription(String regexp);
	 
	 @Query("{ 'classificationType.name' : ?0 }")
	 List<Utensil> findUtensilsByClassificationTypeName(String name);
	
	@Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'utensilType' : { '$regex' : ?1 , $options: 'i'}}, { 'status' : { '$regex' : ?2 , $options: 'i'}}]}")
	Page<Utensil> search(String utensilSearchName, String utensilSearchType, String utensilSearchStatus, Pageable pageable);

}

