package com.oracle.intelagr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.intelagr.common.MD5Util;
import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.AirMoni;
import com.oracle.intelagr.entity.Function;
import com.oracle.intelagr.entity.Product;
import com.oracle.intelagr.entity.Role;
import com.oracle.intelagr.entity.User;
import com.oracle.intelagr.entity.UserRole;
import com.oracle.intelagr.mapper.ProductMapper;
import com.oracle.intelagr.mapper.UserMapper;
import com.oracle.intelagr.mapper.UserRoleMapper;
import com.oracle.intelagr.service.IProductService;
import com.oracle.intelagr.service.IUserService;
@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductMapper productMapper;
	@Override
	public List<Product> login(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map> getFunction(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void queryForPage(PageModel pageModel) {
		Product product=(Product)pageModel.getData();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("companyCode",product.getCompanyCode());
		map.put("productName", product.getProductName());
		map.put("index", (pageModel.getPage()-1)*pageModel.getPageSize());
		map.put("pageSize", pageModel.getPageSize());
		List<Product> list = productMapper.select(map);
		pageModel.setTotalCount(productMapper.count(map));
		pageModel.setResult(list);
		
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product selectById(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String ID) {
		// TODO Auto-generated method stub
		
	}
	
}
