package com.nala.spring.data.mongodb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Coil {

	@Id
	private ObjectId id;

	Integer coilId;

	CoilType coilType;

	String coilName;

	Integer coilAddress;

	String description;

	Integer burnerId;

	String javaPreOperations;

	String javaPostOperations;

	String plcOperations;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Integer getCoilId() {
		return coilId;
	}

	public void setCoilId(Integer coilId) {
		this.coilId = coilId;
	}

	public CoilType getCoilType() {
		return coilType;
	}

	public void setCoilType(CoilType coilType) {
		this.coilType = coilType;
	}

	public String getCoilName() {
		return coilName;
	}

	public void setCoilName(String coilName) {
		this.coilName = coilName;
	}

	public Integer getCoilAddress() {
		return coilAddress;
	}

	public void setCoilAddress(Integer coilAddress) {
		this.coilAddress = coilAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getBurnerId() {
		return burnerId;
	}

	public void setBurnerId(Integer burnerId) {
		this.burnerId = burnerId;
	}

	public String getJavaPreOperations() {
		return javaPreOperations;
	}

	public void setJavaPreOperations(String javaPreOperations) {
		this.javaPreOperations = javaPreOperations;
	}

	public String getJavaPostOperations() {
		return javaPostOperations;
	}

	public void setJavaPostOperations(String javaPostOperations) {
		this.javaPostOperations = javaPostOperations;
	}

	public String getPlcOperations() {
		return plcOperations;
	}

	public void setPlcOperations(String plcOperations) {
		this.plcOperations = plcOperations;
	}

	@Override
	public String toString() {
		return "Coil [id=" + id + ", coilId=" + coilId + ", coilType=" + coilType + ", coilName=" + coilName
				+ ", coilAddress=" + coilAddress + ", description=" + description + ", burnerId=" + burnerId
				+ ", javaPreOperations=" + javaPreOperations + ", javaPostOperations=" + javaPostOperations
				+ ", plcOperations=" + plcOperations + "]";
	}

}
