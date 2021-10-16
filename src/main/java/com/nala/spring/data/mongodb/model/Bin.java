package com.nala.spring.data.mongodb.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Bin {

	@Id
	private String id;
	
	private Integer binId;

	private String name;
	
	private String description;
	
	private Rack rack;
	
	private String section;
	
	private String seqRack;
	
	private String minVolume;
	
	private String maxVolume;
	
	private String thresholdVolume;
	
	private String ingredient;
	
	private String image;
	
	private String minQty;
	
	private String maxQty;
	
	private String thresholdQty;
	
	private String presentQty;
	
	private String lastRefilledQty;
	
	private String lastRefilledBy;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
	private Date lastRefilledDateTime;

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

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSeqRack() {
		return seqRack;
	}

	public void setSeqRack(String seqRack) {
		this.seqRack = seqRack;
	}

	public String getMinVolume() {
		return minVolume;
	}

	public void setMinVolume(String minVolume) {
		this.minVolume = minVolume;
	}

	public String getMaxVolume() {
		return maxVolume;
	}

	public void setMaxVolume(String maxVolume) {
		this.maxVolume = maxVolume;
	}

	public String getThresholdVolume() {
		return thresholdVolume;
	}

	public void setThresholdVolume(String thresholdVolume) {
		this.thresholdVolume = thresholdVolume;
	}

	
	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getMinQty() {
		return minQty;
	}

	public void setMinQty(String minQty) {
		this.minQty = minQty;
	}

	public String getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(String maxQty) {
		this.maxQty = maxQty;
	}

	public String getThresholdQty() {
		return thresholdQty;
	}

	public void setThresholdQty(String thresholdQty) {
		this.thresholdQty = thresholdQty;
	}

	public String getPresentQty() {
		return presentQty;
	}

	public void setPresentQty(String presentQty) {
		this.presentQty = presentQty;
	}

	public String getLastRefilledBy() {
		return lastRefilledBy;
	}

	public void setLastRefilledBy(String lastRefilledBy) {
		this.lastRefilledBy = lastRefilledBy;
	}

	public Date getLastRefilledDateTime() {
		return lastRefilledDateTime;
	}

	public void setLastRefilledDateTime(Date lastRefilledDateTime) {
		this.lastRefilledDateTime = lastRefilledDateTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getLastRefilledQty() {
		return lastRefilledQty;
	}

	public void setLastRefilledQty(String lastRefilledQty) {
		this.lastRefilledQty = lastRefilledQty;
	}

	@Override
	public String toString() {
		return "Bin [id=" + id + ", name=" + name + ", description=" + description + ", rack=" + rack + ", section="
				+ section + ", seqRack=" + seqRack + ", minVolume=" + minVolume + ", maxVolume=" + maxVolume
				+ ", thresholdVolume=" + thresholdVolume + ", ingredient=" + ingredient + ", image=" + image
				+ ", minQty=" + minQty + ", maxQty=" + maxQty + ", thresholdQty=" + thresholdQty + ", presentQty="
				+ presentQty + ", lastRefilledQty=" + lastRefilledQty + ", lastRefilledBy=" + lastRefilledBy
				+ ", lastRefilledDateTime=" + lastRefilledDateTime + ", createdBy=" + createdBy + ", lastUpdatedBy="
				+ lastUpdatedBy + ", createdDateTime=" + createdDateTime + ", lastUpdatedDateTime="
				+ lastUpdatedDateTime + "]";
	}

}
