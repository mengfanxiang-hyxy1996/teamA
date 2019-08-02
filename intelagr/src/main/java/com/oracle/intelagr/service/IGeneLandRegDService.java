package com.oracle.intelagr.service;


import java.util.List;
import java.util.Map;

import com.oracle.intelagr.entity.GeneLandRegD;

public interface IGeneLandRegDService {

	public List<GeneLandRegD> query(String contractorID);

	public int selectLastId();

	public void add(GeneLandRegD geneLandRegD);
	
	public Float selectSum(String contractorID);
	
	public List<GeneLandRegD> selectGen(Map<String,Object> map);

}
