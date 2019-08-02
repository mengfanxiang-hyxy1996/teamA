package com.oracle.intelagr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.User;
import com.oracle.intelagr.entity.WaterMoni;
import com.oracle.intelagr.mapper.WaterMoniMapper;
import com.oracle.intelagr.service.IWaterMoniService;
@Service
public class WaterMoniService implements IWaterMoniService{
	@Autowired
	private WaterMoniMapper waterMoniMapper;
	public List<WaterMoni> selectAll() {
		return waterMoniMapper.selectAll();
	}

	@Override
	public void queryForPage(PageModel pageModel) {
		WaterMoni waterMoni = (WaterMoni)pageModel.getData();
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("index", (pageModel.getPage()-1)*pageModel.getPageSize());
		map.put("pageSize", pageModel.getPageSize());
		map.put("beginDate",waterMoni.getBeginDate());
		map.put("endDate",waterMoni.getEndDate());
		List<WaterMoni> list = waterMoniMapper.select(map);
		pageModel.setTotalCount(waterMoniMapper.count(map));
		pageModel.setResult(list);
	}

	@Override
	public void save(WaterMoni waterMoni) {
		waterMoniMapper.insert(waterMoni);
		
	}

	@Override
	public WaterMoni selectById(int id) {
		return waterMoniMapper.selectById(id);
	}

	@Override
	public void update(WaterMoni waterMoni) {
		waterMoniMapper.update(waterMoni);
		
	}

	@Override
	public void delete(int id) {
		WaterMoni waterMoni = new WaterMoni();
		waterMoni.setId(id);
		waterMoni.setDeleteFlag("Y");
		waterMoniMapper.update(waterMoni);
		
	}

	@Override
	public void updateflag(int[] ids) {
		waterMoniMapper.updateflag(ids);
		
	}
}
