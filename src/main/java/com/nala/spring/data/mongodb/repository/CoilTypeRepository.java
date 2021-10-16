package com.nala.spring.data.mongodb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nala.spring.data.mongodb.model.CoilType;

public interface CoilTypeRepository extends MongoRepository<CoilType, String> {

	@Query("{ 'name' : { $eq : ?0 } }")
	CoilType findByName(String name);

	@Query("{ 'coilTypeId' : { $eq : ?0 } }")
	Page<CoilType> findByCoilTypeId(Integer coilTypeId, Pageable pageable);

	@Query("{ 'isActive' : { $eq : ?0 } }")
	Page<CoilType> findByIsActive(Boolean isActive, Pageable pageable);

	@Query("{'$or' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	Page<CoilType> findByQuery(String name, String description, Pageable pageable);

	@Query("{'$and' : [{ 'coilTypeId' : { '$eq' : ?0 }}, { 'name' : { '$regex' : ?1 , $options: 'i'}}, { 'description' : { '$regex' : ?2 , $options: 'i'}}, { 'isActive' : { '$eq' : ?3 }}]}")
	Page<CoilType> search(Integer coilTypeId, String name, String description, Boolean isActive, Pageable pageable);

}
