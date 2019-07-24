package com.oracle.intelagr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.intelagr.entity.SpecLandReg;
import com.oracle.intelagr.mapper.SpecLandRegMapper;
import com.oracle.intelagr.service.ISpecLandRegService;
@Service
public class SpecLandRegService implements ISpecLandRegService {
	@Autowired
	private SpecLandRegMapper specLandRegMapper;
	@Override
	@Transactional
	public void save(SpecLandReg specLandReg) {
		specLandRegMapper.insert(specLandReg);
	}
}
