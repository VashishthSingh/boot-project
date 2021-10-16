package com.nala.spring.data.mongodb.model;

import java.util.List;

public class SpatulaTypeResultSet {
	
	private List<SpatulaType> spatulaTypes;
	private Integer startNo;
	private Long endNo;
	private Long totalSize;
	private Integer noOfPages;
	private Integer pno;
	
	public List<SpatulaType> getSpatulaTypes() {
		return spatulaTypes;
	}
	public void setSpatulaTypes(List<SpatulaType> spatulaTypes) {
		this.spatulaTypes = spatulaTypes;
	}
	public Integer getStartNo() {
		return startNo;
	}
	public void setStartNo(Integer startNo) {
		this.startNo = startNo;
	}
	
	public Long getEndNo() {
		return endNo;
	}
	public void setEndNo(Long endNo) {
		this.endNo = endNo;
	}
	
	public Long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
}
