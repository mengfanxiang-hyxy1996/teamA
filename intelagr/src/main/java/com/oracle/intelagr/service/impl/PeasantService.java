package com.oracle.intelagr.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.oracle.intelagr.entity.CommonData;
import com.oracle.intelagr.entity.Contract;
import com.oracle.intelagr.entity.GeneLandRegD;

import com.oracle.intelagr.entity.Peasant;

import com.oracle.intelagr.entity.SpecLandDetail;
import com.oracle.intelagr.mapper.CommonDataMapper;
import com.oracle.intelagr.mapper.GeneLandRegDMapper;

import com.oracle.intelagr.mapper.PeasantMapper;
import com.oracle.intelagr.service.IPeasantService;
@Service
public class PeasantService implements IPeasantService {
	@Autowired
	private PeasantMapper peasantMapper;
	@Autowired
	private CommonDataMapper commonDataMapper;
	@Autowired
	private GeneLandRegDMapper geneLandRegDMapper;

	@Override
	public Peasant query(String contractorID) {
		Peasant  peasant = peasantMapper.select(contractorID);
		if(peasant==null) {
			return peasant;
		}
		List<Contract> list = new ArrayList<>();
		List<GeneLandRegD> gs = new ArrayList<>();
		GeneLandRegD gd = new GeneLandRegD();
		float zmj = 0;
		for (Contract contract : peasant.getContract()) {
			zmj += contract.getMeasurementMu();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("codeKey", "PlowlandType");
			map.put("codeCode", contract.getLandType());
			List<CommonData> c= commonDataMapper.select(map);
			map.put("codeKey", "PlowlandClass");
			map.put("codeCode", contract.getLandClass());
			List<CommonData> c2 = commonDataMapper.select(map);
			contract.setLandTypeName(c.get(0).getCodeValue());
			contract.setLandClassName(c2.get(0).getCodeValue());
			list.add(contract);
		}
		gd.setZmj(zmj);
		if(geneLandRegDMapper.select(contractorID).size()==0) {
			gd.setYba(null);
			gd.setKba(gd.getZmj());
		}else {
			Float yba = geneLandRegDMapper.selectSum(contractorID);
			gd.setYba(yba);
			gd.setKba(gd.getZmj()-yba);
		}
		gs.add(gd);
		peasant.setGeneLandRegD(gs);
		peasant.setContract(list);
		return peasant;
	}
	

}
