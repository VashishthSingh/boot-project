package com.nala.spring.data.mongodb.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class TossType {
	
	@Id
	private ObjectId id;
	
	private String name;
	
	private String description;
	
	private String typeid;
	
	private int sequence;
	
	private String createdBy;
	
    private String lastUpdatedBy;
    
    @DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date createdDateTime;
    
    @DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date lastUpdatedDateTime;

	public TossType() {
		super();
	}
	
	public TossType(String name, String description, String typeid, int sequence) {
		super();
		this.id = new ObjectId();
		this.name = name;
		this.description = description;
		this.typeid = typeid;
		this.sequence = sequence;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
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
		return "TossType [id=" + id + ", name=" + name + ", description=" + description + ", typeid=" + typeid
				+ ", sequence=" + sequence + ", createdBy=" + createdBy + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", createdDateTime=" + createdDateTime + ", lastUpdatedDateTime=" + lastUpdatedDateTime + "]";
	}

}
