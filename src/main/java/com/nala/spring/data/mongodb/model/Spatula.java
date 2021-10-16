package com.nala.spring.data.mongodb.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Spatula {

	@Id
    private String id;
	
	private String name;
	
	private Integer spatulaId;
	
	private String description;
	
	private SpatulaType spatulaType;
	
	private String status;
	
	private String images;
	
	private String thumbnailImages;
	
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

	public Integer getSpatulaId() {
		return spatulaId;
	}

	public void setSpatulaId(Integer spatulaId) {
		this.spatulaId = spatulaId;
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

	public SpatulaType getSpatulaType() {
		return spatulaType;
	}

	public void setSpatulaType(SpatulaType spatulaType) {
		this.spatulaType = spatulaType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "Spatula [id=" + id + ", name=" + name + ", spatulaId=" + spatulaId + ", description=" + description
				+ ", spatulaType=" + spatulaType + ", status=" + status + ", images=" + images + ", thumbnailImages="
				+ thumbnailImages + ", createdBy=" + createdBy + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", createdDateTime=" + createdDateTime + ", lastUpdatedDateTime=" + lastUpdatedDateTime + "]";
	}
	
}
