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

import com.nala.spring.data.mongodb.model.ActionType;
import com.nala.spring.data.mongodb.repository.ActionTypeRepository;

@RestController
@RequestMapping("/api/actionType")
public class ActionTypeController {

	@Autowired
	ActionTypeRepository actionTypeRepository;
	
	
	@GetMapping("/{id}")
	  public ResponseEntity<ActionType> getActionTypeById(@PathVariable("id") String id) {
	    Optional<ActionType> actionTypeData = actionTypeRepository.findById(id);
	    if (actionTypeData.isPresent()) {
	      return new ResponseEntity<>(actionTypeData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	 
	 @PostMapping("/")
	  public ResponseEntity<ActionType> createActionType(@RequestBody ActionType actionType) {
	    try {
	    	actionType.setCreatedBy("Admin");
			actionType.setCreatedDateTime(new Date());
			actionType.setLastUpdatedBy("Admin");
			actionType.setLastUpdatedDateTime(new Date());
	    	ActionType _actionType = actionTypeRepository.save(actionType);
	      return new ResponseEntity<>(_actionType, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	  @PutMapping("/{id}")
	  public ResponseEntity<ActionType> updateActionType(@PathVariable("id") String id, @RequestBody ActionType actionType) {
	    Optional<ActionType> actionTypeData = actionTypeRepository.findById(id);

	    if (actionTypeData.isPresent()) {
	    	ActionType _actionType  = actionTypeData.get();
	    	_actionType.setName(actionType.getName());
	    	_actionType.setDescription(actionType.getDescription());
	    	_actionType.setLastUpdatedBy("Admin");
	    	_actionType.setLastUpdatedDateTime(new Date());
	    	//_actionType.setStatus(actionType.getStatus());
	      return new ResponseEntity<>(actionTypeRepository.save(_actionType), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteActionType(@PathVariable("id") String id) {
	    try {
	    	actionTypeRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	

	  @GetMapping("/list")
	  public ResponseEntity<List<ActionType>> getActionTypeList() {
		try {
			List<ActionType> actionTypeList = actionTypeRepository.findAll();
			return new ResponseEntity<>(actionTypeList, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }
	  
	  
	  @GetMapping("/search/{name}/{description}")
	  public ResponseEntity<List<ActionType>> searchActionTypeByNameAndDescription(@PathVariable("name") String name,@PathVariable("description") String description) {
	    List<ActionType> actionTypeList = actionTypeRepository.findActionTypeByRegexpNameAndDescription(name,description);
	    if (actionTypeList.size()>0) {
	      return new ResponseEntity<>(actionTypeList, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  
	  @GetMapping("/search/{name}")
	  public ResponseEntity<List<ActionType>> searchActionTypeByName(@PathVariable("name") String name) {
	    List<ActionType> actionTypeList = actionTypeRepository.findActionTypeByRegexpName(name);
	    if (actionTypeList.size()>0) {
	      return new ResponseEntity<>(actionTypeList, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  
	  
	  
	  
}
