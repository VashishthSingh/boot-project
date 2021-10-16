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

import com.nala.spring.data.mongodb.model.Ingredient;
import com.nala.spring.data.mongodb.repository.DispenseSettingsRepository;
import com.nala.spring.data.mongodb.repository.IngredientRepository;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

	
	@Autowired
	DispenseSettingsRepository dispenseSettingsRepository;
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	 @GetMapping("/{id}")
	  public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") String id) {
	    Optional<Ingredient> ingredientData = ingredientRepository.findById(id);
	    if (ingredientData.isPresent()) {
	      return new ResponseEntity<>(ingredientData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	 @PostMapping("/")
	  public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
	    try {
	    	ingredient.setCreatedBy("hargovind");
			ingredient.setCreatedDateTime(new Date());
			ingredient.setLastUpdatedBy("hargovind");
			ingredient.setLastUpdatedDateTime(new Date());
	    	Ingredient _ingredient = ingredientRepository.save(ingredient);
	      return new ResponseEntity<>(_ingredient, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PutMapping("/{id}")
	  public ResponseEntity<Ingredient> updateIngredient(@PathVariable("id") String id, @RequestBody Ingredient ingredient) {
	    Optional<Ingredient> ingredientData = ingredientRepository.findById(id);

	    if (ingredientData.isPresent()) {
	    	Ingredient _ingredient  = ingredientData.get();
	    	_ingredient.setName(ingredient.getName());
	    	_ingredient.setDescription(ingredient.getDescription());
	    	_ingredient.setIngredientClassificationType(ingredient.getIngredientClassificationType());
	    	_ingredient.setIngredientTypeOfUsage(ingredient.getIngredientTypeOfUsage());
	    	_ingredient.setIngredientWeightToVolumeRatio(ingredient.getIngredientWeightToVolumeRatio());
	    	//_ingredient.setDispenseSettings(dispenseSettings2);
	    	_ingredient.setImage(ingredient.getImage());
	    	_ingredient.setSequence(ingredient.getSequence());
	    	_ingredient.setLastUpdatedBy("Admin");
	    	_ingredient.setLastUpdatedDateTime(new Date());
	    	
	      return new ResponseEntity<>(ingredientRepository.save(_ingredient), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteIngredient(@PathVariable("id") String id) {
	    try {
	    	ingredientRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	  
	  @GetMapping("/list")
	  public ResponseEntity<List<Ingredient>> getIngredientList() {
		try {
			List<Ingredient> ingredientList = ingredientRepository.findAll();
			return new ResponseEntity<>(ingredientList, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }
	  
	  
	  @GetMapping("/search/{name}/{description}")
	  public ResponseEntity<List<Ingredient>> searchIngredientByNameAndDescription(@PathVariable("name") String name,@PathVariable("description") String description) {
	    List<Ingredient> ingredientList = ingredientRepository.findIngredientsByRegexpNameAndDescription(name,description);
	    if (ingredientList.size()>0) {
	      return new ResponseEntity<>(ingredientList, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  
	  @GetMapping("/search/{name}")
	  public ResponseEntity<List<Ingredient>> searchIngredientByName(@PathVariable("name") String name) {
	    List<Ingredient> ingredientList = ingredientRepository.findIngredientsByRegexpName(name);
	    if (ingredientList.size()>0) {
	      return new ResponseEntity<>(ingredientList, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	
	
}
