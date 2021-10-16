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

import com.nala.spring.data.mongodb.model.Spatula;
import com.nala.spring.data.mongodb.model.SpatulaResultSet;
import com.nala.spring.data.mongodb.model.SpatulaType;
import com.nala.spring.data.mongodb.repository.SpatulaRepository;
import com.nala.spring.data.mongodb.repository.SpatulaTypeRepository;

@RestController
@RequestMapping("/api/spatula")
public class SpatulaController {

	@Autowired
	SpatulaRepository spatulaRepository;

	@Autowired
	SpatulaTypeRepository spatulaTypeRepository;

	@GetMapping("/{id}")
	public ResponseEntity<Spatula> getSpatulaById(@PathVariable("id") String id) {
		Optional<Spatula> spatulaData = spatulaRepository.findById(id);
		if (spatulaData.isPresent()) {
			return new ResponseEntity<>(spatulaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/list-spatulas")
	public ResponseEntity<SpatulaResultSet> spatulaSearch(
			@RequestParam(value = "spatulaSearchName", required = false) String spatulaSearchName,
			@RequestParam(value = "spatulaSearchType", required = false) String spatulaSearchType,
			@RequestParam(value = "spatulaSearchStatus", required = false) String spatulaSearchStatus,
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
		if (spatulaSearchName == null) {
			spatulaSearchName = "";
		}
		if (spatulaSearchType == null) {
			spatulaSearchType = "";
		}
		if (spatulaSearchStatus == null) {
			spatulaSearchStatus = "";
		}
		Pageable paging = PageRequest.of(pageNo - 1, pageSize);
		Page<Spatula> pageSpatula = spatulaRepository.search(spatulaSearchName, spatulaSearchType, spatulaSearchStatus,
				paging);
		if (pageSpatula != null) {
			SpatulaResultSet spatulaResultSet = new SpatulaResultSet();
			spatulaResultSet.setSpatulas((List<Spatula>) pageSpatula.getContent());

			spatulaResultSet.setStartNo((pageNo > 1) ? ((pageNo - 1) * pageSize) + 1 : 1);
			spatulaResultSet.setEndNo((pageNo > 1)
					? (((pageNo * pageSize) > pageSpatula.getTotalElements()) ? pageSpatula.getTotalElements()
							: (pageNo * pageSize))
					: pageSpatula.getTotalElements());
			spatulaResultSet.setTotalSize(pageSpatula.getTotalElements());
			spatulaResultSet.setNoOfPages(pageSpatula.getTotalPages());
			spatulaResultSet.setPno(pageNo);
			return new ResponseEntity<>(spatulaResultSet, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public ResponseEntity<Spatula> createSpatula(@RequestBody Spatula spatula) {
		try {
			Optional<SpatulaType> spatulaTypeData = spatulaTypeRepository.findById(spatula.getSpatulaType().getId());
			spatula.setSpatulaType(spatulaTypeData.get());
			spatula.setCreatedBy("Murali");
			spatula.setCreatedDateTime(new Date());
			spatula.setLastUpdatedBy("Murali");
			spatula.setLastUpdatedDateTime(new Date());
			Spatula _spatula = spatulaRepository.save(spatula);
			return new ResponseEntity<>(_spatula, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Spatula> updateSpatula(@PathVariable("id") String id, @RequestBody Spatula spatula) {
		Optional<Spatula> spatulaData = spatulaRepository.findById(id);

		if (spatulaData.isPresent()) {
			Spatula _spatula = spatulaData.get();
			Optional<SpatulaType> spatulaTypeData = spatulaTypeRepository.findById(spatula.getSpatulaType().getId());
			_spatula.setSpatulaType(spatulaTypeData.get());
			_spatula.setName(spatula.getName());
			_spatula.setDescription(spatula.getDescription());
			_spatula.setSpatulaType(spatula.getSpatulaType());
			_spatula.setStatus(spatula.getStatus());
			return new ResponseEntity<>(spatulaRepository.save(_spatula), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteSpatula(@PathVariable("id") String id) {
		try {
			spatulaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
