package com.oracle.intelagr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.BlackList;
import com.oracle.intelagr.entity.BlackListD;
import com.oracle.intelagr.entity.ReCallRecord;
import com.oracle.intelagr.service.impl.BlackListDService;

@Controller
@RequestMapping("/blackList")
public class BlackListDController {
	@Autowired
	private BlackListDService blackListDService;
	
	
	 @RequestMapping("/list")
     public String list(PageModel pageModel,BlackListD blackListD,Model model) {
			System.out.println("*******************"+blackListD.getCompanyCode()+"*******************");
			pageModel.setData(blackListD);
			blackListDService.select(pageModel);
			model.addAttribute("pageModel", pageModel);
	    	return "/blacklist/blackList";
     }
}
