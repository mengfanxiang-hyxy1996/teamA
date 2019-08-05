package com.oracle.intelagr.mapper;

import java.util.List;
import java.util.Map;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.ReCallRecord;

public interface ReCallRecordMapper {
       public List<ReCallRecord>  select(Map<String,Object> map);
       
       public int count(Map<String,Object> map);
}
