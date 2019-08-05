package com.oracle.intelagr.mapper;

import java.util.List;
import java.util.Map;

import com.oracle.intelagr.entity.YearCode;

public interface YearCodeMapper {
	public List<YearCode> select(Map<String,Object> map);
	
	public int count(Map<String,Object> map);
	
	public List<YearCode> newSelect(Map<String,Object> map);
	
	public int save(YearCode yearCode);
	
	public int delete(YearCode yearCode);
}
