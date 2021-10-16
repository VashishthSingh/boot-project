package com.nala.spring.data.mongodb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nala.spring.data.mongodb.model.UtensilType;

public interface UtensilTypeRepository extends MongoRepository<UtensilType, String> {
	
	 List<UtensilType> findByName(String name);
	 
	 @Query("{'$or' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	 List<UtensilType> findUtensilTypeByQuery(String name, String description);
	 
	 @Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	 List<UtensilType> findUtensilTypeByRegexpNameAndDescription(String name, String description);
	 
	 @Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}} ")
	 List<UtensilType> findUtensilTypeByRegexpName(String regexp);
	 
	 @Query("{ 'description' : { '$regex' : ?0 , $options: 'i'}} ")
	 List<UtensilType> findUtensilTypeByRegexpDescription(String regexp);
	 
	 @Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'typeid' : { '$regex' : ?1 , $options: 'i'}}]}") 
	Page<UtensilType> search(String utensilTypeSearchName, String utensilTypeSearchTypeId, Pageable paging);

}