package com.nala.spring.data.mongodb.model;


import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Action {
	
	@Id
    private ObjectId id;
	
	private int actionId;
	
	private String name;
	
	private String description;
	
	private int actionTypeId;
	
	private ActionType actionType;
	
	private boolean isRackDependent;
	
	private boolean isRoboDependent;
	
	private boolean isBurnerDependent;
	
	private boolean isStationdependent;
	
	private boolean isHoldingStationDependent;
	
	private boolean isservingStationDependent;
	
	private boolean isFryerDependent;
	
	private boolean isLiquidDependent;
	
	private boolean isSectionDependent;
	
	private boolean isUtensilDependent;
	
	private boolean isSpatulaDependent;
	
	private boolean isStirDependent;
	
	private boolean isTossDependent;
	
	private boolean isBowlDependent;

	private String images;

	private String thumbnailImages;
	
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

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
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

	public int getActionTypeId() {
		return actionTypeId;
	}

	public void setActionTypeId(int actionTypeId) {
		this.actionTypeId = actionTypeId;
	}

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

	public boolean isRackDependent() {
		return isRackDependent;
	}

	public void setRackDependent(boolean isRackDependent) {
		this.isRackDependent = isRackDependent;
	}

	public boolean isRoboDependent() {
		return isRoboDependent;
	}

	public void setRoboDependent(boolean isRoboDependent) {
		this.isRoboDependent = isRoboDependent;
	}

	public boolean isBurnerDependent() {
		return isBurnerDependent;
	}

	public void setBurnerDependent(boolean isBurnerDependent) {
		this.isBurnerDependent = isBurnerDependent;
	}

	public boolean isStationdependent() {
		return isStationdependent;
	}

	public void setStationdependent(boolean isStationdependent) {
		this.isStationdependent = isStationdependent;
	}

	public boolean isHoldingStationDependent() {
		return isHoldingStationDependent;
	}

	public void setHoldingStationDependent(boolean isHoldingStationDependent) {
		this.isHoldingStationDependent = isHoldingStationDependent;
	}

	public boolean isIsservingStationDependent() {
		return isservingStationDependent;
	}

	public void setIsservingStationDependent(boolean isservingStationDependent) {
		this.isservingStationDependent = isservingStationDependent;
	}

	public boolean isFryerDependent() {
		return isFryerDependent;
	}

	public void setFryerDependent(boolean isFryerDependent) {
		this.isFryerDependent = isFryerDependent;
	}

	public boolean isLiquidDependent() {
		return isLiquidDependent;
	}

	public void setLiquidDependent(boolean isLiquidDependent) {
		this.isLiquidDependent = isLiquidDependent;
	}

	public boolean isSectionDependent() {
		return isSectionDependent;
	}

	public void setSectionDependent(boolean isSectionDependent) {
		this.isSectionDependent = isSectionDependent;
	}

	public boolean isUtensilDependent() {
		return isUtensilDependent;
	}

	public void setUtensilDependent(boolean isUtensilDependent) {
		this.isUtensilDependent = isUtensilDependent;
	}

	public boolean isSpatulaDependent() {
		return isSpatulaDependent;
	}

	public void setSpatulaDependent(boolean isSpatulaDependent) {
		this.isSpatulaDependent = isSpatulaDependent;
	}

	public boolean isStirDependent() {
		return isStirDependent;
	}

	public void setStirDependent(boolean isStirDependent) {
		this.isStirDependent = isStirDependent;
	}

	public boolean isTossDependent() {
		return isTossDependent;
	}

	public void setTossDependent(boolean isTossDependent) {
		this.isTossDependent = isTossDependent;
	}

	public boolean isBowlDependent() {
		return isBowlDependent;
	}

	public void setBowlDependent(boolean isBowlDependent) {
		this.isBowlDependent = isBowlDependent;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getThumbnailImages() {
		return thumbnailImages;
	}

	public void setThumbnailImages(String thumbnailImages) {
		this.thumbnailImages = thumbnailImages;
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
		return "Action [id=" + id + ", actionId=" + actionId + ", name=" + name + ", description=" + description
				+ ", actionTypeId=" + actionTypeId + ", actionType=" + actionType + ", isRackDependent="
				+ isRackDependent + ", isRoboDependent=" + isRoboDependent + ", isBurnerDependent=" + isBurnerDependent
				+ ", isStationdependent=" + isStationdependent + ", isHoldingStationDependent="
				+ isHoldingStationDependent + ", isservingStationDependent=" + isservingStationDependent
				+ ", isFryerDependent=" + isFryerDependent + ", isLiquidDependent=" + isLiquidDependent
				+ ", isSectionDependent=" + isSectionDependent + ", isUtensilDependent=" + isUtensilDependent
				+ ", isSpatulaDependent=" + isSpatulaDependent + ", isStirDependent=" + isStirDependent
				+ ", isTossDependent=" + isTossDependent + ", isBowlDependent=" + isBowlDependent + ", images=" + images
				+ ", thumbnailImages=" + thumbnailImages + ", createdBy=" + createdBy + ", lastUpdatedBy="
				+ lastUpdatedBy + ", createdDateTime=" + createdDateTime + ", lastUpdatedDateTime="
				+ lastUpdatedDateTime + "]";
	}

}

