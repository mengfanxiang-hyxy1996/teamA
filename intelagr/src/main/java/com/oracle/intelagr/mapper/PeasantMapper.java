package com.oracle.intelagr.mapper;


import java.util.List;
import java.util.Map;

import com.oracle.intelagr.entity.Peasant;

public interface PeasantMapper {
	
	public Peasant select(String contractorID);
	//qlz 写
	public Peasant selectinfor(String contractorID);
	//qlz 写   查询农户基本信息
	public List<Peasant> selectById(Map<String,Object> map);
	//qlz 写   查询农户面积
	public List<Peasant> selectMu(Map<String,Object> map);
}
