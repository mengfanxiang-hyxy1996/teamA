package com.oracle.intelagr.service;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.WaterMoni;

public interface IWaterMoniService {
	public void queryForPage(PageModel pageModel);
	public void save(WaterMoni waterMoni);
	public void update(WaterMoni waterMoni);
	public WaterMoni selectById(int id);
	public void delete(int id);
	public void updateflag(int [] ids);	
}
