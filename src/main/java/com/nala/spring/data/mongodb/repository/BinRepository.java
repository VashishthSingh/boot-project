package com.nala.spring.data.mongodb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nala.spring.data.mongodb.model.Bin;


public interface BinRepository extends MongoRepository<Bin, String> {

	List<Bin> findByName(String name);

	@Query("{ 'name' : { $regex: ?0 } }")
	List<Bin> findBinRegexpName(String regexp);

	@Query("{'$or' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	List<Bin> findBinByQuery(String name, String description);

	@Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'description' : { '$regex' : ?1 , $options: 'i'}}]}")
	List<Bin> findBinByRegexpNameAndDescription(String name, String description);

	@Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}} ")
	List<Bin> findBinByRegexpName(String regexp);

	@Query("{ 'description' : { '$regex' : ?0 , $options: 'i'}} ")
	List<Bin> findBinByRegexpDescription(String regexp);

	@Query("{ 'classificationType.name' : ?0 }")
	List<Bin> findBinsByClassificationTypeName(String name);

	@Query("{ 'rack.rackId' : ?0 }")
	List<Bin> findBinsByRackId(String rackId);

	@Query("{'$and' : [{ 'name' : { '$regex' : ?0 , $options: 'i'}}, { 'rack.rackId' : { '$regex' : ?1 , $options: 'i'}}, { 'section' : { '$regex' : ?2 , $options: 'i'}}, { 'seqRack' : { '$regex' : ?3 , $options: 'i'}}]}")
	Page<Bin> search(String binSearchName, String binRack, String binSection, String seqRack, Pageable pageable);

}
