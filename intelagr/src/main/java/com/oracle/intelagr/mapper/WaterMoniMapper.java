package com.oracle.intelagr.mapper;

import java.util.List;
import java.util.Map;

import com.oracle.intelagr.entity.WaterMoni;

public interface WaterMoniMapper {

	public List<WaterMoni> select(Map<String, Object> map);
	public WaterMoni selectById(int id);
	public int count(Map<String,Object> map);
	public void insert(WaterMoni waterMoni);
	public void update(WaterMoni waterMoni);
	public void updateflag(int [] ids);
	public List<WaterMoni> selectAll();
	

}
