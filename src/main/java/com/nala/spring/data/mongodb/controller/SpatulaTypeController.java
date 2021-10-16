package com.nala.spring.data.mongodb.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nala.spring.data.mongodb.model.SpatulaType;
import com.nala.spring.data.mongodb.model.SpatulaTypeResultSet;
import com.nala.spring.data.mongodb.repository.SpatulaTypeRepository;

@RestController
@RequestMapping("/api/spatulaType")
public class SpatulaTypeController {

	@Autowired
	SpatulaTypeRepository spatulaTypeRepository;

	@GetMapping("/{id}")
	public ResponseEntity<SpatulaType> getSpatulaTypeById(@PathVariable("id") String id) {
		try {
			Optional<SpatulaType> spatulaTypeData = spatulaTypeRepository.findById(id);
			if (spatulaTypeData.isPresent()) {
				return new ResponseEntity<>(spatulaTypeData.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list-spatula-types")
	public ResponseEntity<SpatulaTypeResultSet> spatulaTypeSearch(
			@RequestParam(value = "spatulaTypeName", required = false) String spatulaTypeName,
			@RequestParam(value = "spatulaTypeStatus", required = false) String spatulaTypeStatus,
			@RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestParam(value = "sortOrder", required = false) Boolean sortOrder,
			@RequestParam(value = "fromDate", required = false) @DateTimeFormat(pattern = "MM-dd-yyyy") Date fromDate,
			@RequestParam(value = "toDate", required = false) @DateTimeFormat(pattern = "MM-dd-yyyy") Date toDate,
			@RequestParam(value = "pageNo", required = false) Integer pageNo,
			@RequestParam(value = "pageSize", required = false) Integer pageSize) {
		if (pageNo == null || pageNo < 1) {
			pageNo = 1;
		}
		if (pageSize == null || pageSize < 0) {
			pageSize = 10;
		}
		if (spatulaTypeName == null) {
			spatulaTypeName = "";
		}
		
		if (spatulaTypeStatus == null) {
			spatulaTypeStatus = "";
		}
		Pageable paging = PageRequest.of(pageNo - 1, pageSize);
		Page<SpatulaType> pageSpatula = spatulaTypeRepository.search(spatulaTypeName, spatulaTypeStatus, paging);
		if (pageSpatula != null) {
			SpatulaTypeResultSet spatulaTypeResultSet = new SpatulaTypeResultSet();
			spatulaTypeResultSet.setSpatulaTypes((List<SpatulaType>) pageSpatula.getContent());

			spatulaTypeResultSet.setStartNo((pageNo > 1) ? ((pageNo - 1) * pageSize) + 1 : 1);
			spatulaTypeResultSet.setEndNo((pageNo > 1)
					? (((pageNo * pageSize) > pageSpatula.getTotalElements()) ? pageSpatula.getTotalElements()
							: (pageNo * pageSize))
					: pageSpatula.getTotalElements());
			spatulaTypeResultSet.setTotalSize(pageSpatula.getTotalElements());
			spatulaTypeResultSet.setNoOfPages(pageSpatula.getTotalPages());
			spatulaTypeResultSet.setPno(pageNo);
			return new ResponseEntity<>(spatulaTypeResultSet, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public ResponseEntity<SpatulaType> createSpatulaTyep(@RequestBody SpatulaType spatulaTyep) {
		try {
			spatulaTyep.setCreatedBy("Admin");
			spatulaTyep.setCreatedDateTime(new Date());
			spatulaTyep.setLastUpdatedBy("Admin");
			spatulaTyep.setLastUpdatedDateTime(new Date());
			SpatulaType _spatulaTyep = spatulaTypeRepository.save(spatulaTyep);
			return new ResponseEntity<>(_spatulaTyep, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<SpatulaType> updateSpatulaType(@PathVariable("id") String id,
			@RequestBody SpatulaType spatulaType) {
		try {
			Optional<SpatulaType> spatulaTypeData = spatulaTypeRepository.findById(id);
			if (spatulaTypeData.isPresent()) {
				SpatulaType _spatulaType = spatulaTypeData.get();
				_spatulaType.setSpatulaTypeId(spatulaType.getSpatulaTypeId());
				_spatulaType.setName(spatulaType.getName());
				_spatulaType.setDescription(spatulaType.getDescription());
				_spatulaType.setStatus(spatulaType.getStatus());
				_spatulaType.setLastUpdatedBy("Admin");
				_spatulaType.setLastUpdatedDateTime(new Date());
				return new ResponseEntity<>(spatulaTypeRepository.save(_spatulaType), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteSpatulaType(@PathVariable("id") String id) {
		try {
			spatulaTypeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
