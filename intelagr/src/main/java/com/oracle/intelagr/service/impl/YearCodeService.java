package com.oracle.intelagr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.YearCode;
import com.oracle.intelagr.mapper.YearCodeMapper;
import com.oracle.intelagr.service.IYearCodeService;
@Service
public class YearCodeService implements IYearCodeService{
	@Autowired
	private YearCodeMapper yearCodeMapper;
	@Override
	public YearCode getYearCode(String yearCode) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("yearCode", yearCode);
		List<YearCode> list = yearCodeMapper.select(params);
		if(list.size()>0) {
			return list.get(0);
		}
		return new YearCode();
	}
	@Override
	public List<YearCode> getYearCodeList() {
		Map<String,Object> params = new HashMap<String,Object>();
		return yearCodeMapper.select(params);
	}
	
	@Override
	public void newSelect(PageModel pageModel) {
		   YearCode yearCode=(YearCode) pageModel.getData();
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yearName", yearCode.getYearName());
		   map.put("index", (pageModel.getPage()-1)*pageModel.getPageSize());
		   map.put("pageSize", pageModel.getPageSize());
		   List<YearCode> list=yearCodeMapper.newSelect(map);
		   pageModel.setTotalCount(yearCodeMapper.count(map));
		   pageModel.setResult(list);
	}
	@Override
	public int save(YearCode yearCode) {
		return yearCodeMapper.save(yearCode);
		
	}
	@Override
	public int delete(YearCode yearCode) {
		return yearCodeMapper.delete(yearCode);
		
	}

}
