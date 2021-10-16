package com.nala.spring.data.mongodb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nala.spring.data.mongodb.model.TossType;

public interface TossTypeRepository extends MongoRepository<TossType, String>{
	
	 List<TossType> findByName(String name);
	 
	 @Query("{'$or' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	 List<TossType> findTossTypeByQuery(String name, String description);
	 
	 @Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	 List<TossType> findTossTypeByRegexpNameAndDescription(String name, String description);
	 
	 @Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}} ")
	 List<TossType> findTossTypeByRegexpName(String regexp);
	 
	 @Query("{ 'description' : { '$regex' : ?0 , $options: 'i'}} ")
	 List<TossType> findTossTypeByRegexpDescription(String regexp);
	 
	 @Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'typeid' : { '$regex' : ?1 , $options: 'i'}}]}") 
	 Page<TossType> search(String utensilTypeSearchName, String utensilTypeSearchTypeId, Pageable paging);

}
