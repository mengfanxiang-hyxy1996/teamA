package com.oracle.intelagr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.AirMoni;
import com.oracle.intelagr.entity.WaterMoni;
import com.oracle.intelagr.mapper.AirmonitoringMapper;
import com.oracle.intelagr.mapper.UserMapper;
import com.oracle.intelagr.mapper.UserRoleMapper;
import com.oracle.intelagr.service.IAirmonitoringService;

@Service
public class AirmonitoringService implements IAirmonitoringService {
	@Autowired
	private AirmonitoringMapper airmonitoringMapper;
	@Override
	public void queryForPage(PageModel pageModel) {
		AirMoni air=(AirMoni)pageModel.getData();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("index", (pageModel.getPage()-1)*pageModel.getPageSize());
		map.put("pageSize", pageModel.getPageSize());
		map.put("beginDate",air.getBeginDate());
		map.put("endDate", air.getEndDate());
		List<AirMoni> list = airmonitoringMapper.select(map);
		pageModel.setTotalCount(airmonitoringMapper.count(map));
		pageModel.setResult(list);
	}
	@Override
	public void save(AirMoni airMoni) {
		airmonitoringMapper.insert(airMoni);
	}
	@Override
	public void update(AirMoni airMoni) {
		airmonitoringMapper.update(airMoni);
	}
	@Override
	public AirMoni selectById(int id) {
		return airmonitoringMapper.selectById(id);
	}
	@Override
	public void delete(int id) {
		AirMoni airMoni = new AirMoni();
		airMoni.setId(id);
		airMoni.setDeleteFlag("Y");
		airmonitoringMapper.update(airMoni);
	}
	@Override
	public void updateflag(int[] ids) {
		airmonitoringMapper.updateflag(ids);
	}
	@Override
	public List<AirMoni> selectAll() {
		return airmonitoringMapper.selectAll();
	}
	
	
}
