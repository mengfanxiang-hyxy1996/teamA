package com.oracle.intelagr.mapper;

import java.util.List;
import java.util.Map;

import com.oracle.intelagr.entity.GeneLandReg;
import com.oracle.intelagr.entity.GraiReg;

public interface GeneLandRegMapper {
	
	public int selectLastId();
	
	public void insert(GeneLandReg geneLandReg);
	
	public List<GeneLandReg> select(Map<String,Object> map);
	
	public int selectCount(Map<String,Object> map);
	
	public GeneLandReg selectById(int id);

	//qlz 写
	public List<GeneLandReg> selectPT(GraiReg graiReg );
	//qlz 写
	public  List<GeneLandReg> selectBa(Map<String , Object> map);

	
	public GeneLandReg selectByapplyBatchNo(String applyBatchNo);
	
	public void update(GeneLandReg gen);
	
	public void delete(int id);
	
	


}
