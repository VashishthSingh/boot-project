package com.nala.spring.data.mongodb.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nala.spring.data.mongodb.model.CoilType;
import com.nala.spring.data.mongodb.repository.CoilTypeRepository;

@RestController
@RequestMapping("/api/coilType")
public class CoilTypeController {

	@Autowired
	CoilTypeRepository coilTypeRepository;

	@GetMapping("/{id}")
	public ResponseEntity<CoilType> getCoilTypeById(@PathVariable("id") String id) {
		try {
			Optional<CoilType> coilTypeData = coilTypeRepository.findById(id);
			if (coilTypeData.isPresent()) {
				return new ResponseEntity<>(coilTypeData.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/")
	public ResponseEntity<CoilType> createCoilType(@RequestBody CoilType coilType) {
		try {
			coilType.setCreatedBy("Admin");
			coilType.setCreatedDateTime(new Date());
			coilType.setLastUpdatedBy("Admin");
			coilType.setLastUpdatedDateTime(new Date());
			CoilType _coilType = coilTypeRepository.save(coilType);
			return new ResponseEntity<>(_coilType, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<CoilType> updateRack(@PathVariable("id") String id, @RequestBody CoilType coilType) {
		try {
			Optional<CoilType> coilTypeData = coilTypeRepository.findById(id);
			if (coilTypeData.isPresent()) {
				CoilType _coilType = coilTypeData.get();
				_coilType.setCoilTypeId(coilType.getCoilTypeId());
				_coilType.setName(coilType.getName());
				_coilType.setDescription(coilType.getDescription());
				_coilType.setActive(coilType.isActive());
				_coilType.setLastUpdatedBy("Admin");
				_coilType.setLastUpdatedDateTime(new Date());
				return new ResponseEntity<>(coilTypeRepository.save(_coilType), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteRack(@PathVariable("id") String id) {
		try {
			coilTypeRepository.deleteById(id);
			Optional<CoilType> coilTypeData = coilTypeRepository.findById(id);
			if (coilTypeData.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{name}")
	public ResponseEntity<CoilType> findByName(@PathVariable("name") String name) {
		try {
			CoilType coilTypeData = coilTypeRepository.findByName(name);
			if (coilTypeData!=null) {
				return new ResponseEntity<>(coilTypeData, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
/*
	@GetMapping("/{coilTypeId}")
	public @ResponseBody Page<CoilType> findByCoilTypeId(@PathVariable("coilTypeId") Integer coilTypeId) {
		try {
			Page<CoilType> coilTypeList = coilTypeRepository.findByCoilTypeId(coilTypeId);
			if (coilTypeList!=null) {
				return coilTypeList;
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/{isActive}")
	public ResponseEntity<CoilType> findByIsActive(@PathVariable("isActive") boolean isActive) {
		try {
			List<CoilType> coilTypeList = coilTypeRepository.findByIsActive(isActive);
			if (coilTypeList!=null) {
				return new ResponseEntity<>(coilTypeData.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

}
