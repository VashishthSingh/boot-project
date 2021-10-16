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

import com.nala.spring.data.mongodb.model.Action;
import com.nala.spring.data.mongodb.model.ActionType;
import com.nala.spring.data.mongodb.repository.ActionRepository;

@RestController
@RequestMapping("/api/action")
public class ActionController {

	@Autowired
	ActionRepository actionRepository;
	
	
	@GetMapping("/{id}")
	  public ResponseEntity<Action> getActionById(@PathVariable("id") String id) {
	    Optional<Action> actionData = actionRepository.findById(id);
	    if (actionData.isPresent()) {
	      return new ResponseEntity<>(actionData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	 
	 @PostMapping("/")
	  public ResponseEntity<Action> createAction(@RequestBody Action action) {
	    try {
	    	action.setCreatedBy("hargovind");
			action.setCreatedDateTime(new Date());
			action.setLastUpdatedBy("hargovind");
			action.setLastUpdatedDateTime(new Date());
	    	Action _action = actionRepository.save(action);
	      return new ResponseEntity<>(_action, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	  @PutMapping("/{id}")
	  public ResponseEntity<Action> updateAction(@PathVariable("id") String id, @RequestBody Action action) {
	    Optional<Action> actionData = actionRepository.findById(id);

	    if (actionData.isPresent()) {
	    	Action _action  = actionData.get();
	    	_action.setName(action.getName());
	    	_action.setDescription(action.getDescription());
	    	_action.setLastUpdatedBy("Admin");
	    	_action.setLastUpdatedDateTime(new Date());
	    	//_action.setStatus(action.getStatus());
	      return new ResponseEntity<>(actionRepository.save(_action), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteAction(@PathVariable("id") String id) {
	    try {
	    	actionRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	

	  @GetMapping("/list")
	  public ResponseEntity<List<Action>> getActionList() {
		try {
			List<Action> actionList = actionRepository.findAll();
			return new ResponseEntity<>(actionList, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }
	  
	  
	  @GetMapping("/search/{name}/{description}")
	  public ResponseEntity<List<Action>> searchActionByNameAndDescription(@PathVariable("name") String name,@PathVariable("description") String description) {
	    List<Action> actionList = actionRepository.findActionsByRegexpNameAndDescription(name,description);
	    if (actionList.size()>0) {
	      return new ResponseEntity<>(actionList, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  
	  @GetMapping("/search/{name}")
	  public ResponseEntity<List<Action>> searchActionByName(@PathVariable("name") String name) {
	    List<Action> actionList = actionRepository.findActionsByRegexpName(name);
	    if (actionList.size()>0) {
	      return new ResponseEntity<>(actionList, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  
}
