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

import com.nala.spring.data.mongodb.model.TossType;
import com.nala.spring.data.mongodb.repository.TossTypeRepository;

@RestController
@RequestMapping("/api/tossType")
public class TossTypeController {
	
	@Autowired
	private TossTypeRepository tossTypeRepository;
	
	@GetMapping("/{id}")
	  public ResponseEntity<TossType> getTossTypeById(@PathVariable("id") String id) {
		try {
			Optional<TossType> tossTypeData = tossTypeRepository.findById(id);
			if (tossTypeData.isPresent()) {
				return new ResponseEntity<>(tossTypeData.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	
	@GetMapping("/list")
	  public ResponseEntity<List<TossType>> getTossTypeList() {
		try {
			List<TossType> tossTypeList = tossTypeRepository.findAll();
			if(tossTypeList.size()>0) {
				return new ResponseEntity<>(tossTypeList, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 } 
	
	@PostMapping("/")
	  public ResponseEntity<TossType> createTossType(@RequestBody TossType tossType) {
	    try {
	    	tossType.setCreatedBy("Muni");
	    	tossType.setCreatedDateTime(new Date());
	    	tossType.setLastUpdatedBy("Muni");
	    	tossType.setLastUpdatedDateTime(new Date());
	    	TossType _tossType = tossTypeRepository.save(tossType);
	      return new ResponseEntity<>(_tossType, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@PutMapping("/{id}")
	  public ResponseEntity<TossType> updateTossType(@PathVariable("id") String id, @RequestBody TossType tossType) {
	    try {
	    	Optional<TossType> tossTypeData = tossTypeRepository.findById(id);
	    	if (tossTypeData.isPresent()) {
	    		TossType _tossType  = tossTypeData.get();
	    		_tossType.setName(tossType.getName());
	    		_tossType.setDescription(tossType.getDescription());
	    		//_tossType.setStatus(tossType.getStatus());
	    		return new ResponseEntity<>(tossTypeRepository.save(_tossType), HttpStatus.OK);
	    	} else {
	    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	}
	    }catch(Exception e) {
	    	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteTossType(@PathVariable("id") String id) {
	    try {
	    	tossTypeRepository.deleteById(id);
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/findByName/{name}")
	  public ResponseEntity<List<TossType>> findTossTypeByName(@PathVariable("name") String name) {
		try {
		name=name.trim();
	    List<TossType> tossTypeList = tossTypeRepository.findTossTypeByRegexpName(name);
	    if (tossTypeList.size()>0) {
	      return new ResponseEntity<>(tossTypeList, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	
	@GetMapping("/findByNameAndDescription/{name}/{description}")
	  public ResponseEntity<List<TossType>> findTossTypeByNameAndDescription(@PathVariable("name") String name,@PathVariable("description") String description) {
	    try {
	    	name=name.trim();
	    	description=description.trim();
	    	List<TossType> tossTypeList = tossTypeRepository.findTossTypeByRegexpNameAndDescription(name,description);
	    	if (tossTypeList.size()>0) {
	    		return new ResponseEntity<>(tossTypeList, HttpStatus.OK);
	    	} else {
	    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	}
	    }catch(Exception e) {
	    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
}
