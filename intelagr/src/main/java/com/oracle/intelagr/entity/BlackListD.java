package com.oracle.intelagr.entity;

import java.util.Date;



public class BlackListD extends BaseEntity {
	private Integer id;
	//企业ID
	private String companyCode;
	//拉黑截止日期
	private String blackListEndDate;
	//原因
	private String blackListReason;
	//处理人
	private String processor;
	//时长
	private String blackListTimeLimit;
	//处理日期
	private String settleDate;
	//公司
	private Company company;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getBlackListEndDate() {
		return blackListEndDate;
	}
	public void setBlackListEndDate(String blackListEndDate) {
		this.blackListEndDate = blackListEndDate;
	}
	public String getBlackListReason() {
		return blackListReason;
	}
	public void setBlackListReason(String blackListReason) {
		this.blackListReason = blackListReason;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getBlackListTimeLimit() {
		return blackListTimeLimit;
	}
	public void setBlackListTimeLimit(String blackListTimeLimit) {
		this.blackListTimeLimit = blackListTimeLimit;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}


	
}