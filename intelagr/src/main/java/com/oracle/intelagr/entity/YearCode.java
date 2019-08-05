package com.oracle.intelagr.entity;


/**
 * 数据字典Entity
 * 
 * @author 创新中软
 * @date 2015-08-18
 */
public class YearCode extends BaseEntity{
	// 自增长主键
	private Integer id;
	// 
	private String yearCode;
	// 
	private String yearName;
	
	private int displayseq;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYearCode() {
		return yearCode;
	}
	public void setYearCode(String yearCode) {
		this.yearCode = yearCode;
	}
	public String getYearName() {
		return yearName;
	}
	public void setYearName(String yearName) {
		this.yearName = yearName;
	}
	public int getDisplayseq() {
		return displayseq;
	}
	public void setDisplayseq(int displayseq) {
		this.displayseq = displayseq;
	}
	
}
