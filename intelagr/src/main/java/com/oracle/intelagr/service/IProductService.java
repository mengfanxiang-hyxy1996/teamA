package com.oracle.intelagr.service;

import java.util.List;
import java.util.Map;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.Product;


public interface IProductService {
	public List<Product> login(Product product);
	public List<Map> getFunction(String ID);
	public void queryForPage(PageModel pageModel);
	public void save(Product product);
	public Product selectById(String ID);
	public void update(Product product);
	public void delete(String ID);
}
