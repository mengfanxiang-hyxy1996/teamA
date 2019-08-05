package com.oracle.intelagr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.BlackList;
import com.oracle.intelagr.entity.BlackListD;
import com.oracle.intelagr.mapper.BlackListDMapper;
import com.oracle.intelagr.service.IBlackListDService;

@Service
public class BlackListDService implements IBlackListDService{
    @Autowired
	private BlackListDMapper blackListDMapper;
	
	@Override
	public void select(PageModel pageModel) {
		BlackListD blackListD=(BlackListD) pageModel.getData();
		Map<String,Object> map=new HashMap();
		map.put("companyCode", blackListD.getCompanyCode());
		map.put("index",(pageModel.getPage()-1)*pageModel.getPageSize());
		map.put("pageSize",pageModel.getPageSize());
		List<BlackListD> list=blackListDMapper.query(map);
		pageModel.setTotalCount(blackListDMapper.count(map));
		pageModel.setResult(list);
	}

	

}
