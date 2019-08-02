package com.oracle.intelagr.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.GeneLandReg;
import com.oracle.intelagr.entity.GraiReg;
import com.oracle.intelagr.entity.User;

public interface IGeneLandRegService {

	public int selectLastId();

	public void add(String test,User user);
	
	public void queryforpage(PageModel pageModel);
	
	public Float getSum(PageModel pageModel);
	
	public GeneLandReg queryone(int id);

	
	public GeneLandReg queryapplyBatchNo(String applyBatchNo);
	
	public void update (String test)throws ParseException;
	
	public void delete(int id);
	

}
