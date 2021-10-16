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

import com.nala.spring.data.mongodb.model.Utensil;
import com.nala.spring.data.mongodb.repository.UtensilRepository;

@RestController
@RequestMapping("/api/utensil")
public class UtensilController {

	
	@Autowired
	UtensilRepository utensilRepository;
	
	 @GetMapping("/{id}")
	  public ResponseEntity<Utensil> getUtensilById(@PathVariable("id") String id) {
	    Optional<Utensil> utensilData = utensilRepository.findById(id);
	    if (utensilData.isPresent()) {
	      return new ResponseEntity<>(utensilData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	 
	 @PostMapping("/")
	  public ResponseEntity<Utensil> createUtensil(@RequestBody Utensil utensil) {
	    try {
	    	utensil.setCreatedBy("hargovind");
			utensil.setCreatedDateTime(new Date());
			utensil.setLastUpdatedBy("hargovind");
			utensil.setLastUpdatedDateTime(new Date());
	    	Utensil _utensil = utensilRepository.save(utensil);
	      return new ResponseEntity<>(_utensil, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PutMapping("/{id}")
	  public ResponseEntity<Utensil> updateUtensil(@PathVariable("id") String id, @RequestBody Utensil utensil) {
	    Optional<Utensil> utensilData = utensilRepository.findById(id);

	    if (utensilData.isPresent()) {
	    	Utensil _utensil  = utensilData.get();
	    	_utensil.setName(utensil.getName());
	    	_utensil.setDescription(utensil.getDescription());
	    	_utensil.setUtensilType(utensil.getUtensilType());
	    	_utensil.setStatus(utensil.getStatus());
	    	_utensil.setUtensilType(utensil.getUtensilType());
	    	_utensil.setImage(utensil.getImage());
	    	_utensil.setSequence(utensil.getSequence());
	    	_utensil.setLastUpdatedBy("Admin");
	    	_utensil.setLastUpdatedDateTime(new Date());
	    	//_utensil.setS
	      return new ResponseEntity<>(utensilRepository.save(_utensil), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteUtensil(@PathVariable("id") String id) {
	    try {
	    	utensilRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	  
	  @GetMapping("/list")
	  public ResponseEntity<List<Utensil>> getUtensilList() {
		try {
			List<Utensil> utensilList = utensilRepository.findAll();
			return new ResponseEntity<>(utensilList, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }
	  
	  
	  @GetMapping("/search/{name}/{description}")
	  public ResponseEntity<List<Utensil>> searchUtensilByNameAndDescription(@PathVariable("name") String name,@PathVariable("description") String description) {
	    List<Utensil> utensilList = utensilRepository.findUtensilByRegexpNameAndDescription(name,description);
	    if (utensilList.size()>0) {
	      return new ResponseEntity<>(utensilList, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  
	  @GetMapping("/search/{name}")
	  public ResponseEntity<List<Utensil>> searchUtensilByName(@PathVariable("name") String name) {
	    List<Utensil> utensilList = utensilRepository.findUtensilByRegexpName(name);
	    if (utensilList.size()>0) {
	      return new ResponseEntity<>(utensilList, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	
}
