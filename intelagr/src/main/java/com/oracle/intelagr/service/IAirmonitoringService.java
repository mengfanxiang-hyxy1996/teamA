package com.oracle.intelagr.service;
import java.util.List;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.AirMoni;
public interface IAirmonitoringService {
	public void queryForPage(PageModel pageModel);
	public void save(AirMoni airMoni);
	public void update(AirMoni airMoni);
	public AirMoni selectById(int id);
	public void delete(int id);
	public void updateflag(int [] ids);
	public List<AirMoni> selectAll();
}
