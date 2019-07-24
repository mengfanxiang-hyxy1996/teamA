package com.oracle.intelagr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class Company {
	@RequestMapping("/list")
	public String list() {
		return "/company/companyList";
	}
}
