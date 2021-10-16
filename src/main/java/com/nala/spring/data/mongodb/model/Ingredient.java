package com.nala.spring.data.mongodb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Ingredient {

	@Id
	private ObjectId id;

	private Integer ingredientId;

	private String name;

	private String shortDescription;

	private String description;
	
	private String ingredientClassificationType;
	
	private String ingredientTypeOfUsage;
	
	private String ingredientWeightToVolumeRatio;
	
	private ArrayList<DispenseSettings> dispenseSettings;
	
	
	//list of dispense settings
	
    public String getIngredientClassificationType() {
		return ingredientClassificationType;
	}

	public void setIngredientClassificationType(String ingredientClassificationType) {
		this.ingredientClassificationType = ingredientClassificationType;
	}

	public String getIngredientTypeOfUsage() {
		return ingredientTypeOfUsage;
	}

	public void setIngredientTypeOfUsage(String ingredientTypeOfUsage) {
		this.ingredientTypeOfUsage = ingredientTypeOfUsage;
	}

	public String getIngredientWeightToVolumeRatio() {
		return ingredientWeightToVolumeRatio;
	}

	public void setIngredientWeightToVolumeRatio(String ingredientWeightToVolumeRatio) {
		this.ingredientWeightToVolumeRatio = ingredientWeightToVolumeRatio;
	}

	public Binary getImage() {
		return image;
	}

	public void setImage(Binary image) {
		this.image = image;
	}

	private Binary image; 

	private int sequence;

	private String createdBy;

	private String lastUpdatedBy;

	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
	private Date createdDateTime;

	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
	private Date lastUpdatedDateTime;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Integer getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Date getLastUpdatedDateTime() {
		return lastUpdatedDateTime;
	}

	public void setLastUpdatedDateTime(Date lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", ingredientId=" + ingredientId
				+ ", name=" + name + ", shortDescription=" + shortDescription + ", description=" + description
				+ ", sequence=" + sequence + ", createdBy=" + createdBy + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", createdDateTime=" + createdDateTime + ", lastUpdatedDateTime=" + lastUpdatedDateTime + "]";
	}

	public List<DispenseSettings> getDispenseSettings() {
		return dispenseSettings;
	}

	public void setDispenseSettings(DispenseSettings dispenseSettings2) {
		
		if(this.dispenseSettings==null)
		{this.dispenseSettings = new ArrayList<DispenseSettings>();}	
		
		this.dispenseSettings.add( dispenseSettings2);   
	}



	
}
