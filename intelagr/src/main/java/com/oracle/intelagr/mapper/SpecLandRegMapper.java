package com.oracle.intelagr.mapper;

import java.util.List;
import java.util.Map;

import com.oracle.intelagr.entity.SpecLandReg;

public interface SpecLandRegMapper {

	public void insert(SpecLandReg specLandReg);
	public List<SpecLandReg> select(Map<String,Object> map);
	public int selectCount(Map<String,Object> map);	
	public SpecLandReg selectSpe(Map<String, Object> map);
	public void delete(int id);
	public SpecLandReg selectById(int id);
	public void updateById(Map<String,Object> map);
	public void updateByIdE(SpecLandReg specLandReg);
	public List<SpecLandReg> selectList(Map<String,Object> map);
	public int selectListCount(Map<String,Object> map);
	public SpecLandReg selectEdit(int id);
}
