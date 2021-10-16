package com.nala.spring.data.mongodb.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class DispenseSettings {
	
	@Id
    private ObjectId id;
	
	private String start;
	
	private String end;
	
	private String bulkFeedPercentage;
	
	private String gapTimerSeconds;
	
	private String inchOnTimer;
	
	private String inchOffTimer;
	
	private String cutOfPercentage;
	
	private String RPM;
	
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

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getBulkFeedPercentage() {
		return bulkFeedPercentage;
	}

	public void setBulkFeedPercentage(String bulkFeedPercentage) {
		this.bulkFeedPercentage = bulkFeedPercentage;
	}

	public String getGapTimerSeconds() {
		return gapTimerSeconds;
	}

	public void setGapTimerSeconds(String gapTimerSeconds) {
		this.gapTimerSeconds = gapTimerSeconds;
	}

	public String getInchOnTimer() {
		return inchOnTimer;
	}

	public void setInchOnTimer(String inchOnTimer) {
		this.inchOnTimer = inchOnTimer;
	}

	public String getInchOffTimer() {
		return inchOffTimer;
	}

	public void setInchOffTimer(String inchOffTimer) {
		this.inchOffTimer = inchOffTimer;
	}

	public String getCutOfPercentage() {
		return cutOfPercentage;
	}

	public void setCutOfPercentage(String cutOfPercentage) {
		this.cutOfPercentage = cutOfPercentage;
	}

	public String getRPM() {
		return RPM;
	}

	public void setRPM(String rPM) {
		RPM = rPM;
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
    
    
    
    
    

}

