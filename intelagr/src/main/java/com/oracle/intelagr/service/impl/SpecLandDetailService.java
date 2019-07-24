package com.oracle.intelagr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.intelagr.entity.SpecLandDetail;
import com.oracle.intelagr.mapper.SpecLandDetailMapper;
import com.oracle.intelagr.service.ISpecLandDetailService;
@Service
public class SpecLandDetailService implements ISpecLandDetailService {
	@Autowired 
	private SpecLandDetailMapper specLandDetailMapper;
	@Override
	@Transactional
	public void save(SpecLandDetail specLandDetail) {
		specLandDetailMapper.insert(specLandDetail);
	}

}
