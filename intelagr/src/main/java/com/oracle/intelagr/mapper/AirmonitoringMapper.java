package com.oracle.intelagr.mapper;

import java.util.List;
import java.util.Map;

import com.oracle.intelagr.entity.AirMoni;


public interface AirmonitoringMapper {
	public List<AirMoni> select(Map<String,Object> map);
	public AirMoni selectById(int id);
	public int count(Map<String,Object> map);
	public void insert(AirMoni airMoni);
	public void update(AirMoni airMoni);
	public List<AirMoni> selectAll();
	public void updateflag(int [] ids);
}
