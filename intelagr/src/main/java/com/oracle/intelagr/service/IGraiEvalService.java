package com.oracle.intelagr.service;

import java.util.List;
import java.util.Map;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.Company;
import com.oracle.intelagr.entity.GraiEval;
import com.oracle.intelagr.entity.User;



public interface IGraiEvalService {
	public void queryForPage(PageModel pageModel);
	
	
	
	public void save(GraiEval graiEval);
	
	public GraiEval selectById(int id);
	
	public void updateSave(GraiEval graiEval);
	
	public void delete(GraiEval graiEval);
	
	public List selectCompany();
}
