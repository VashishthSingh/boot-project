package com.nala.spring.data.mongodb.controller;

import java.util.Date;
import java.util.List;
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

import com.nala.spring.data.mongodb.model.UtensilType;
import com.nala.spring.data.mongodb.repository.UtensilTypeRepository;

@RestController
@RequestMapping("/api/utensilType")
public class UtensilTypeController {

	@Autowired
	UtensilTypeRepository utensilTypeRepository;
	
	
	@GetMapping("/{id}")
	  public ResponseEntity<UtensilType> getUtensilTypeById(@PathVariable("id") String id) {
	    Optional<UtensilType> utensilTypeData = utensilTypeRepository.findById(id);
	    if (utensilTypeData.isPresent()) {
	      return new ResponseEntity<>(utensilTypeData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	 
	 @PostMapping("/")
	  public ResponseEntity<UtensilType> createUtensilType(@RequestBody UtensilType utensilType) {
	    try {
	    	utensilType.setCreatedBy("hargovind");
			utensilType.setCreatedDateTime(new Date());
			utensilType.setLastUpdatedBy("hargovind");
			utensilType.setLastUpdatedDateTime(new Date());
	    	UtensilType _utensilType = utensilTypeRepository.save(utensilType);
	      return new ResponseEntity<>(_utensilType, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	  @PutMapping("/{id}")
	  public ResponseEntity<UtensilType> updateUtensilType(@PathVariable("id") String id, @RequestBody UtensilType utensilType) {
	    Optional<UtensilType> utensilTypeData = utensilTypeRepository.findById(id);

	    if (utensilTypeData.isPresent()) {
	    	UtensilType _utensilType  = utensilTypeData.get();
	    	_utensilType.setName(utensilType.getName());
	    	_utensilType.setDescription(utensilType.getDescription());
	    	_utensilType.setTypeid(utensilType.getTypeid());
	    	_utensilType.setLastUpdatedBy("Admin");
	    	_utensilType.setLastUpdatedDateTime(new Date());
	    	//_utensilType.setStatus(utensilType.getStatus());
	      return new ResponseEntity<>(utensilTypeRepository.save(_utensilType), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteUtensilType(@PathVariable("id") String id) {
	    try {
	    	utensilTypeRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	  @GetMapping("/list")
	  public ResponseEntity<List<UtensilType>> getUtensilTypeList() {
		try {
			List<UtensilType> utensilTypeList = utensilTypeRepository.findAll();
			return new ResponseEntity<>(utensilTypeList, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }
	  
	  
	  @GetMapping("/search/{name}/{description}")
	  public ResponseEntity<List<UtensilType>> searchUtensilTypeByNameAndDescription(@PathVariable("name") String name,@PathVariable("description") String description) {
	    List<UtensilType> utensilTypeList = utensilTypeRepository.findUtensilTypeByRegexpNameAndDescription(name,description);
	    if (utensilTypeList.size()>0) {
	      return new ResponseEntity<>(utensilTypeList, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  
	  @GetMapping("/search/{name}")
	  public ResponseEntity<List<UtensilType>> searchUtensilTypeByName(@PathVariable("name") String name) {
	    List<UtensilType> utensilTypeList = utensilTypeRepository.findUtensilTypeByRegexpName(name);
	    if (utensilTypeList.size()>0) {
	      return new ResponseEntity<>(utensilTypeList, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  
	
}
