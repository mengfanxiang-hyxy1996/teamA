package com.oracle.intelagr.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class WaterMoni extends BaseEntity {
	private Integer id;
	// 监测日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date monitorDate;
	// 断面编号
	private String monitorPointCode;
	private String monitorPointName;
	// PH值
	private Float ph;
	// DO
	private Float doValue;
	// CODMn
	private Float codmn;
	// BOD5
	private Float bod5;
	// 氨氮
	private Float nh3n;
	// 总磷
	private Float tp;
	// CODCr
	private Float codcr;
	private String remark;
	private String deleteFlag;
	private Date createDate;
	private String createUserId;
	private String updateUserId;
	private MoniPoint moniPoint;
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

	public Float getPh() {
		return ph;
	}

	public void setPh(Float ph) {
		this.ph = ph;
	}

	public Float getDoValue() {
		return doValue;
	}

	public void setDoValue(Float doValue) {
		this.doValue = doValue;
	}

	public Float getCodmn() {
		return codmn;
	}

	public void setCodmn(Float codmn) {
		this.codmn = codmn;
	}

	public Float getBod5() {
		return bod5;
	}

	public void setBod5(Float bod5) {
		this.bod5 = bod5;
	}

	public Float getNh3n() {
		return nh3n;
	}

	public void setNh3n(Float nh3n) {
		this.nh3n = nh3n;
	}

	public Float getTp() {
		return tp;
	}

	public void setTp(Float tp) {
		this.tp = tp;
	}

	public Float getCodcr() {
		return codcr;
	}

	public void setCodcr(Float codcr) {
		this.codcr = codcr;
	}

	public String getMonitorPointCode() {
		return monitorPointCode;
	}

	public void setMonitorPointCode(String monitorPointCode) {
		this.monitorPointCode = monitorPointCode;
	}

	public String getMonitorPointName() {
		return monitorPointName;
	}

	public void setMonitorPointName(String monitorPointName) {
		this.monitorPointName = monitorPointName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public MoniPoint getMoniPoint() {
		return moniPoint;
	}

	public void setMoniPoint(MoniPoint moniPoint) {
		this.moniPoint = moniPoint;
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
