package com.oracle.intelagr.mapper;

import java.util.List;
import java.util.Map;


import com.oracle.intelagr.entity.BlackListD;

public interface BlackListDMapper {
       public List<BlackListD> query(Map<String,Object> map);
       
       public int count(Map<String,Object> map);
}
