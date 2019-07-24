package com.oracle.intelagr.service;

import java.util.List;
import java.util.Map;

import com.oracle.intelagr.entity.AreaDevision;

public interface IAreaDevisionService {
	
/*	public AreaDevision query(AreaDevision areaDevision);*/
	public List<AreaDevision> queryTown();
	public List<AreaDevision> queryCountry(String townCode);
}
