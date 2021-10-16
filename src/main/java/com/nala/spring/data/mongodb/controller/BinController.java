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

import com.nala.spring.data.mongodb.model.Bin;
import com.nala.spring.data.mongodb.model.Rack;
import com.nala.spring.data.mongodb.repository.BinRepository;
import com.nala.spring.data.mongodb.repository.RackRepository;

@RestController
@RequestMapping("/api/bin")
public class BinController {

	@Autowired
	BinRepository binRepository;

	@Autowired
	RackRepository rackRepository;

	@GetMapping("/{id}")
	public ResponseEntity<Bin> getBinById(@PathVariable("id") String id) {
		Optional<Bin> binData = binRepository.findById(id);
		if (binData.isPresent()) {
			return new ResponseEntity<>(binData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public ResponseEntity<Bin> createBin(@RequestBody Bin bin) {
		try {
			Optional<Rack> rackData = rackRepository.findById(bin.getRack().getId());
			bin.setRack(rackData.get());
			bin.setCreatedBy("Admin");
			bin.setCreatedDateTime(new Date());
			bin.setLastUpdatedBy("Admin");
			bin.setLastUpdatedDateTime(new Date());
			Bin _bin = binRepository.save(bin);
			return new ResponseEntity<>(_bin, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Bin> updateRack(@PathVariable("id") String id, @RequestBody Bin bin) {
		Optional<Bin> binData = binRepository.findById(id);
		Optional<Rack> rackData = rackRepository.findById(bin.getRack().getId());
		if (binData.isPresent()) {
			Bin _bin = binData.get();
			_bin.setName(bin.getName());
			_bin.setDescription(bin.getDescription());
			_bin.setSection(bin.getSection());
			_bin.setSeqRack(bin.getSeqRack());
			_bin.setMinVolume(bin.getMinVolume());
			_bin.setMaxVolume(bin.getMaxVolume());
			_bin.setThresholdVolume(bin.getThresholdVolume());
			_bin.setIngredient(bin.getIngredient());
			_bin.setMinQty(bin.getMinQty());
			_bin.setMaxQty(bin.getMaxQty());
			_bin.setThresholdQty(bin.getThresholdQty());
			_bin.setPresentQty(bin.getPresentQty());
			_bin.setRack(rackData.get());
			_bin.setLastRefilledBy(bin.getLastRefilledBy());
			_bin.setLastRefilledQty(bin.getLastRefilledQty());
			_bin.setLastRefilledDateTime(new Date());
			_bin.setLastUpdatedBy("Admin");
			_bin.setLastUpdatedDateTime(new Date());

			return new ResponseEntity<>(binRepository.save(_bin), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteRack(@PathVariable("id") String id) {
		try {
			binRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
