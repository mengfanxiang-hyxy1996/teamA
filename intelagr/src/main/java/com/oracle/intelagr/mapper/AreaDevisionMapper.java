package com.oracle.intelagr.mapper;

import java.util.List;

import com.oracle.intelagr.entity.AreaDevision;

public interface AreaDevisionMapper {
	
	public AreaDevision select(AreaDevision areaDevision);
	public List<AreaDevision> selectTown();
	public List<AreaDevision> selectCountry(String townCode);
}
