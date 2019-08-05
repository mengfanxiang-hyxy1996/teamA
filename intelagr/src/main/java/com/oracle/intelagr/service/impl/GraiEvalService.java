package com.oracle.intelagr.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.intelagr.common.PageModel;

import com.oracle.intelagr.entity.GraiEval;

import com.oracle.intelagr.mapper.GraiEvalMapper;
import com.oracle.intelagr.service.IGraiEvalService;

@Service
public class GraiEvalService implements IGraiEvalService {
    @Autowired
	private GraiEvalMapper graiEvalMapper;
	@Override
	public void queryForPage(PageModel pageModel) {
		 GraiEval graiEval= (GraiEval)pageModel.getData();
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("index", (pageModel.getPage()-1)*pageModel.getPageSize());
   	     map.put("pageSize", pageModel.getPageSize());
   	     map.put("year", graiEval.getYear());
	     List<GraiEval> list=graiEvalMapper.select(map);
	     int totalCount=graiEvalMapper.count(map);
	     pageModel.setTotalCount(totalCount);
	     pageModel.setResult(list);
	}
	
	@Override
	public void save(GraiEval graiEval) {
		 graiEvalMapper.insert(graiEval);
		
	}
	@Override
	public GraiEval selectById(int id) {
	   return graiEvalMapper.selectById(id);
	}
	public void updateSave(GraiEval graiEval) {
		
		 graiEvalMapper.update(graiEval);
	}
	public void delete(GraiEval graiEval) {
		graiEvalMapper.delete(graiEval);
		
		
		
	}
	@Override
	public List selectCompany() {
		// TODO Auto-generated method stub
		return graiEvalMapper.selectCompany();
	}


	
	
	
}
