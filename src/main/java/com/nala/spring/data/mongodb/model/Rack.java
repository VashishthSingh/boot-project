package com.nala.spring.data.mongodb.model;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Rack {

	@Id
	private String id;
	
	private String name;
	
	private String description;
	
	private String rackType;
	
	private String rackId;
	
	private String maptoRobot;
	
	private String status;
	
	private String images;
	
	private String createdBy;

	private String lastUpdatedBy;

	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
	private Date createdDateTime;

	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
	private Date lastUpdatedDateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getRackType() {
		return rackType;
	}

	public void setRackType(String rackType) {
		this.rackType = rackType;
	}

	public String getRackId() {
		return rackId;
	}

	public void setRackId(String rackId) {
		this.rackId = rackId;
	}

	public String getMaptoRobot() {
		return maptoRobot;
	}

	public void setMaptoRobot(String maptoRobot) {
		this.maptoRobot = maptoRobot;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
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
		return "Rack [id=" + id + ", name=" + name + ", description=" + description + ", rackType=" + rackType
				+ ", rackId=" + rackId + ", maptoRobot=" + maptoRobot + ", status=" + status + ", images=" + images
				+ ", createdBy=" + createdBy + ", lastUpdatedBy=" + lastUpdatedBy + ", createdDateTime="
				+ createdDateTime + ", lastUpdatedDateTime=" + lastUpdatedDateTime + "]";
	}
	
	
}
