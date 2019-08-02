package com.oracle.intelagr.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


public class GeneLandReg extends BaseEntity {
	private Integer id;
	//年度
	private String year;
	//企业ID
	private String companyCode;
	//企业名称
	private String companyName;
	//申请批次号
	private String applyBatchNo;
	//审核人
	private String auditor;
	//审核时间
	private Date auditTime;
	//状态
	private String status;
	//驳回原因
	private String reason;
	
	private Float mjsum;
	
	private GeneLandRegD geneLandRegD;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date beginDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
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
	public GeneLandRegD getGeneLandRegD() {
		return geneLandRegD;
	}
	public void setGeneLandRegD(GeneLandRegD geneLandRegD) {
		this.geneLandRegD = geneLandRegD;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getApplyBatchNo() {
		return applyBatchNo;
	}
	public void setApplyBatchNo(String applyBatchNo) {
		this.applyBatchNo = applyBatchNo;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	public Float getMjsum() {
		return mjsum;
	}
	public void setMjsum(Float mjsum) {
		this.mjsum = mjsum;
	}
	@Override
	public String toString() {
		return "GeneLandReg [id=" + id + ", year=" + year + ", companyCode=" + companyCode + ", companyName="
				+ companyName + ", applyBatchNo=" + applyBatchNo + ", auditor=" + auditor + ", auditTime=" + auditTime
				+ ", status=" + status + ", reason=" + reason + ", mjsum=" + mjsum + ", geneLandRegD=" + geneLandRegD
				+ "]";
	}
	
	
}
