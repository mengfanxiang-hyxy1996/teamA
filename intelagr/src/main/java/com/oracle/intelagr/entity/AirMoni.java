package com.oracle.intelagr.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



public class AirMoni extends BaseEntity {
	
	private Integer id;
	//监测日期
	private Date monitorDate;
	//监测点位
	private String monitorPointCode;
	private String monitorPointName;
	//tsp
	private Float tsp;
	//SO2
	private Float so2;
	//NO2
	private Float no2;
	private MoniPoint moniPoint;
	
	public MoniPoint getMoniPoint() {
		return moniPoint;
	}
	public void setMoniPoint(MoniPoint moniPoint) {
		this.moniPoint = moniPoint;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date beginDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getMonitorDate() {
		return monitorDate;
	}
	public void setMonitorDate(Date monitorDate) {
		this.monitorDate = monitorDate;
	}
	public String getMonitorPointCode() {
		return monitorPointCode;
	}
	public void setMonitorPointCode(String monitorPointCode) {
		this.monitorPointCode = monitorPointCode;
	}
	public Float getTsp() {
		return tsp;
	}
	public void setTsp(Float tsp) {
		this.tsp = tsp;
	}
	public Float getSo2() {
		return so2;
	}
	public void setSo2(Float so2) {
		this.so2 = so2;
	}
	public Float getNo2() {
		return no2;
	}
	public void setNo2(Float no2) {
		this.no2 = no2;
	}
	public String getMonitorPointName() {
		return monitorPointName;
	}
	public void setMonitorPointName(String monitorPointName) {
		this.monitorPointName = monitorPointName;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
