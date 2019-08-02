package com.oracle.intelagr.mapper;


import java.util.List;
import java.util.Map;

import com.oracle.intelagr.entity.GeneLandRegD;

public interface GeneLandRegDMapper {
	
	public List<GeneLandRegD> select(String contractorID);
	
	public int selectLastId();
	
	public void insert(GeneLandRegD geneLandRegD );
	
	public Float selectSum(String contractorID);
	
	public List<GeneLandRegD> selectBytudi(Map<String,Object> map);
	
	public void update(GeneLandRegD gend);
	

}
