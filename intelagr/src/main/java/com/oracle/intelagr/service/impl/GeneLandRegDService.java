package com.oracle.intelagr.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.GeneLandRegD;
import com.oracle.intelagr.mapper.GeneLandRegDMapper;
import com.oracle.intelagr.service.IGeneLandRegDService;
@Service
public class GeneLandRegDService implements IGeneLandRegDService {

	@Autowired
	private GeneLandRegDMapper geneLandRegDMapper;
	
	@Override
	public List<GeneLandRegD> query(String contractorID) {
		// TODO Auto-generated method stub
		
		return geneLandRegDMapper.select(contractorID);
	}

	@Override
	public int selectLastId() {
		return geneLandRegDMapper.selectLastId();
	}

	@Override
	public void add(GeneLandRegD geneLandRegD) {
		// TODO Auto-generated method stub
		geneLandRegDMapper.insert(geneLandRegD);
	}

	@Override
	public Float selectSum(String contractorID) {
		
		return geneLandRegDMapper.selectSum(contractorID);
	}

	@Override
	public List<GeneLandRegD> selectGen(Map<String, Object> map) {
		return geneLandRegDMapper.selectBytudi(map);
	}

}
