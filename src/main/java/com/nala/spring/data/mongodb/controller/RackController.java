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

import com.nala.spring.data.mongodb.model.Rack;
import com.nala.spring.data.mongodb.repository.RackRepository;

@RestController
@RequestMapping("/api")
public class RackController {
	
	 @Autowired
	 RackRepository rackRepository;
	 
	 @GetMapping("/rack/{id}")
	  public ResponseEntity<Rack> getRackById(@PathVariable("id") String id) {
	    Optional<Rack> rackData = rackRepository.findById(id);
	    if (rackData.isPresent()) {
	      return new ResponseEntity<>(rackData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	 @PostMapping("/rack")
	  public ResponseEntity<Rack> createRack(@RequestBody Rack rack) {
	    try {
	    	rack.setCreatedBy("Admin");
	    	rack.setCreatedDateTime(new Date());
	    	rack.setLastUpdatedBy("Admin");
	    	rack.setLastUpdatedDateTime(new Date());
	    	Rack _rack = rackRepository.save(rack);
	      return new ResponseEntity<>(_rack, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 @PutMapping("/rack/{id}")
	  public ResponseEntity<Rack> updateRack(@PathVariable("id") String id, @RequestBody Rack rack) {
	    Optional<Rack> rackData = rackRepository.findById(id);

	    if (rackData.isPresent()) {
	    	Rack _rack  = rackData.get();
	    	_rack.setName(rack.getName());
	    	_rack.setDescription(rack.getDescription());
	    	_rack.setRackType(rack.getRackType());
	    	_rack.setStatus(rack.getStatus());
	    	_rack.setMaptoRobot(rack.getMaptoRobot());
	    	_rack.setRackId(rack.getRackId());
	    	_rack.setLastUpdatedBy("Admin");
	    	_rack.setLastUpdatedDateTime(new Date());
	    	
	      return new ResponseEntity<>(rackRepository.save(_rack), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/rack/{id}")
	  public ResponseEntity<HttpStatus> deleteRack(@PathVariable("id") String id) {
	    try {
	    	rackRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
