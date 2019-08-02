package com.oracle.intelagr.mapper;

import java.util.List;

import com.oracle.intelagr.entity.Contract;

public interface ContractMapper {
	
	public List<Contract> select(String contractorCode);

}
