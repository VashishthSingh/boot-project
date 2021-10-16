package com.nala.spring.data.mongodb.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nala.spring.data.mongodb.model.BowlType;
import com.nala.spring.data.mongodb.repository.BowlTypeRepository;

@RestController
@RequestMapping("/api/bowlType")
public class BowlTypeController {
	

	@Autowired
	BowlTypeRepository bowlTypeRepository;
	
	@GetMapping("/{id}")
	  public ResponseEntity<BowlType> getBowlTypeById(@PathVariable("id") String id) {
	    Optional<BowlType> bowlTypeData = bowlTypeRepository.findById(id);
	    if (bowlTypeData.isPresent()) {
	      return new ResponseEntity<>(bowlTypeData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	 
	 @PostMapping("/")
	  public ResponseEntity<BowlType> createBowlType(@RequestBody BowlType bowlType) {
	    try {
	    	bowlType.setCreatedBy("hargovind");
			bowlType.setCreatedDateTime(new Date());
			bowlType.setLastUpdatedBy("hargovind");
			bowlType.setLastUpdatedDateTime(new Date());
	    	BowlType _bowlType = bowlTypeRepository.save(bowlType);
	      return new ResponseEntity<>(_bowlType, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	  @PutMapping("/{id}")
	  public ResponseEntity<BowlType> updateBowlType(@PathVariable("id") String id, @RequestBody BowlType bowlType) {
	    Optional<BowlType> bowlTypeData = bowlTypeRepository.findById(id);

	    if (bowlTypeData.isPresent()) {
	    	BowlType _bowlType  = bowlTypeData.get();
	    	_bowlType.setName(bowlType.getName());
	    	_bowlType.setDescription(bowlType.getDescription());
	    	//_bowlType.setStatus(bowlType.getStatus());
	      return new ResponseEntity<>(bowlTypeRepository.save(_bowlType), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteBowlType(@PathVariable("id") String id) {
	    try {
	    	bowlTypeRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	

}
