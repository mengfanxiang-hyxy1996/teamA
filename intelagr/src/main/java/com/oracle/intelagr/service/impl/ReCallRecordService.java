package com.oracle.intelagr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.Company;
import com.oracle.intelagr.entity.ReCallRecord;
import com.oracle.intelagr.entity.YearCode;
import com.oracle.intelagr.mapper.ReCallRecordMapper;
import com.oracle.intelagr.service.IReCallRecordService;


@Service
public class ReCallRecordService implements IReCallRecordService{
    @Autowired
	private ReCallRecordMapper reCallRecordMapper;
	@Override
	public void query(PageModel pageModel) {
		ReCallRecord reCallRecord=(ReCallRecord) pageModel.getData();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("index", (pageModel.getPage()-1)*pageModel.getPageSize());
		map.put("pageSize", pageModel.getPageSize());
		map.put("companyCode", reCallRecord.getCompanyCode());
		map.put("beginDate", reCallRecord.getBeginDate());
		map.put("endDate", reCallRecord.getEndDate());
		map.put("batchNo", reCallRecord.getBatchNo());
		List<ReCallRecord> list=reCallRecordMapper.select(map);
		pageModel.setTotalCount(reCallRecordMapper.count(map));
		pageModel.setResult(list);
		
	}
       
}
