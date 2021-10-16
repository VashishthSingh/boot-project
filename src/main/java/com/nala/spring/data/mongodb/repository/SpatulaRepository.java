package com.nala.spring.data.mongodb.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nala.spring.data.mongodb.model.Spatula;


public interface SpatulaRepository extends MongoRepository<Spatula, String>{

	@Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'spatulaType.name' : { '$regex' : ?1 , $options: 'i'}}, { 'status' : { '$regex' : ?2 , $options: 'i'}}]}")
	Page<Spatula> search(String name, String spatulaType, String status, Pageable pageable);
	
	Page<Spatula> findAll(Pageable pageable);
	
	 @Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'spatulaType' : { '$regex' : ?1 , $options: 'i'}}, { 'status' : { '$regex' : ?2 , $options: 'i'}}]}")
	 List<Spatula> findSpatulasByRegexpNameAndTypeAndStatus(String name, String spatulaType, String status);

}
