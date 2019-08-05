package com.oracle.intelagr.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.intelagr.common.JsonResult;
import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.User;
import com.oracle.intelagr.entity.YearCode;
import com.oracle.intelagr.service.impl.YearCodeService;
@Controller
@RequestMapping("/year")
public class YearCodeController {
	
		@Autowired
		private YearCodeService yearCodeService;
		
	    @RequestMapping("/list")
        public String list(PageModel pageModel,YearCode year,Model model) {
    	       pageModel.setData(year);
    	       yearCodeService.newSelect(pageModel);
    	       model.addAttribute("pageModel", pageModel);
    	  return "/yearcode/yearcodeList";
      }
	    
	    @RequestMapping("/add")
	    public String add() {
	    	return "/yearcode/yearcodeAdd";
	    }
	    
	    @RequestMapping("save")
	    @ResponseBody
	    public JsonResult save(@RequestBody YearCode yearCode,HttpServletRequest request) {
	    	HttpSession session = request.getSession();
	    	yearCode.setCreateUserId(((User)session.getAttribute("user")).getUserID());
	    	yearCode.setUpdateUserId(((User)session.getAttribute("user")).getUserID());
	    	yearCode.setCreateDate(new Date());
	    	yearCode.setUpdateDate(new Date());
	    	int a=yearCodeService.save(yearCode);
	   
	    	JsonResult result=null;
	    	if(a>0) {
	    		result=new JsonResult(true);
	    	}else {
	    		result=new JsonResult(false,"失败");
	    	}
	    	return result;
	    }
	    
	    
	    @RequestMapping("delete")
	    @ResponseBody
	    public JsonResult delete(@RequestBody YearCode yearCode,HttpServletRequest request) {
	    	HttpSession session=request.getSession();
	    	User user=(User) session.getAttribute("user");
	    	yearCode.setUpdateUserId(user.getUserID());
	    	yearCode.setUpdateDate(new Date());
	    	
	    	int a=yearCodeService.delete(yearCode);
	    	JsonResult result=null;
	    	if(a>0) {
	    		result=new JsonResult(true);
	    	}else {
	    		result=new JsonResult(false,"失败");
	    	}
	    	
	    	return result;
	    			
			}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
