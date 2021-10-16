 package com.nala.spring.data.mongodb.repository;

 import java.util.List;
 import org.springframework.data.mongodb.repository.MongoRepository;
 import org.springframework.data.mongodb.repository.Query;

import com.nala.spring.data.mongodb.model.Action;
 
public interface ActionRepository extends MongoRepository<Action, String> {
	
	 List<Action> findByName(String name);
	 
	 @Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	 List<Action> findActionsByRegexpNameAndDescription(String name, String description);
	 
	 @Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}} ")
	 List<Action> findActionsByRegexpName(String regexp);
	 
	 @Query("{ 'description' : { '$regex' : ?0 , $options: 'i'}} ")
	 List<Action> findActionsByRegexpDescription(String regexp);
	 
	 @Query("{classificationType.name : {$ne : ?0}}")
	 List<Action> findByClassificationTypeNotInActions(String type);

}
