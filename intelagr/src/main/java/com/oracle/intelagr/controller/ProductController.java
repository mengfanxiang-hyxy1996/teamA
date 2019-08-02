package com.oracle.intelagr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.intelagr.common.JsonResult;
import com.oracle.intelagr.common.PageModel;

import com.oracle.intelagr.entity.Product;

import com.oracle.intelagr.service.impl.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("/list")
	public String list(Product product,PageModel pageModel,Model model) {
		pageModel.setData(product);
		productService.queryForPage(pageModel);
		model.addAttribute("pageModel", pageModel);
		return "/product/productList";
	}
	
}
