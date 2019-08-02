package com.oracle.intelagr.mapper;

import java.util.List;
import java.util.Map;

import com.oracle.intelagr.entity.Product;



public interface ProductMapper {
	public List<Product> select(Map<String,Object> map);
	public Product selectById(String ID);
	public int count(Map<String,Object> map);
	public void insert(Product product);
	public void update(Product product);
}
