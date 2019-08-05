package com.oracle.intelagr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.ReCallRecord;

import com.oracle.intelagr.service.impl.ReCallRecordService;

@Controller
@RequestMapping("/recall")
public class ReCallRecordController {
	 @Autowired
     private ReCallRecordService reCallRecordService;
	
     @RequestMapping("/list")
    public String query(ReCallRecord reCallRecord,Model model,PageModel pageModel) {
    	System.out.println(reCallRecord.getCompanyCode()+reCallRecord.getEndDate()+reCallRecord.getBatchNo()+reCallRecord.getBeginDate());
    	pageModel.setData(reCallRecord);
        reCallRecordService.query(pageModel);
    	model.addAttribute("pageModel",pageModel);
    	return "/recall/recallList";
    } 
     
}
