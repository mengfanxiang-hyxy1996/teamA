package com.oracle.intelagr.service;

import java.util.List;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.YearCode;

public interface IYearCodeService {
	public YearCode getYearCode(String yearCode) ;
	
	public List<YearCode> getYearCodeList();
	
	public void newSelect(PageModel pageModel);
	
	public int save(YearCode yearCode);
	
	public int delete(YearCode yearCode);
}
