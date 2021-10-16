package com.nala.spring.data.mongodb.model;

import java.util.List;

public class SpatulaResultSet {
	
	private List<Spatula> spatulas;
	private Integer startNo;
	private Long endNo;
	private Long totalSize;
	private Integer noOfPages;
	private Integer pno;
	
	
	public List<Spatula> getSpatulas() {
		return spatulas;
	}
	public void setSpatulas(List<Spatula> spatulas) {
		this.spatulas = spatulas;
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
	@Override
	public String toString() {
		return "SpatulaResultSet [spatulas=" + spatulas + ", startNo=" + startNo + ", endNo=" + endNo + ", totalSize="
				+ totalSize + ", noOfPages=" + noOfPages + ", pno=" + pno + "]";
	}
	
}
