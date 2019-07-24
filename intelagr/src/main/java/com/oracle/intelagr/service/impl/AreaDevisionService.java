package com.oracle.intelagr.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.intelagr.entity.AreaDevision;
import com.oracle.intelagr.mapper.AreaDevisionMapper;
import com.oracle.intelagr.service.IAreaDevisionService;
@Service
public class AreaDevisionService implements IAreaDevisionService {

	@Autowired
	private AreaDevisionMapper areaDevisionMapper;
	
/*	@Override
	public AreaDevision query(AreaDevision areaDevision) {
		return areaDevisionMapper.select(areaDevision);
	}*/

	@Override
	public List<AreaDevision> queryTown() {
		return areaDevisionMapper.selectTown();
	}

	@Override
	public List<AreaDevision> queryCountry(String townCode) {
		return areaDevisionMapper.selectCountry(townCode);
	}
}
