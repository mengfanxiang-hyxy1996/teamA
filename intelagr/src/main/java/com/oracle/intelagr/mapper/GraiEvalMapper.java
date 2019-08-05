package com.oracle.intelagr.mapper;

import java.util.List;
import java.util.Map;

import com.oracle.intelagr.entity.Company;
import com.oracle.intelagr.entity.GraiEval;

public interface GraiEvalMapper {
	   //根据年度查找所有信息
       public List<GraiEval> select(Map<String,Object> map);
       //查询信息所得条数
	   public int count(Map<String,Object> map);
	   
	  
	   
	   public void insert(GraiEval graiEval);
	   
	   public GraiEval selectById(int id) ;
	   
	   public void update(GraiEval graiEval);
	   
	   public void delete(GraiEval graiEval);
	   
	   public List selectCompany();
}
