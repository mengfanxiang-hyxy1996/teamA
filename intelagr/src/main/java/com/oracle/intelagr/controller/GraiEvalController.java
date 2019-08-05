package com.oracle.intelagr.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.intelagr.common.JsonResult;
import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.GraiEval;
import com.oracle.intelagr.entity.User;
import com.oracle.intelagr.service.impl.GraiEvalService;

@Controller
@RequestMapping("/graiEval")
public class GraiEvalController {
	   @Autowired
       private GraiEvalService graiEvalService;
       
	   @RequestMapping("/list")
       public String graiEvalList(GraiEval graiEval ,PageModel pageModel,Model model) {
	    	  Map<String,Object> map=new HashMap<String,Object>();
	    	  pageModel.setData(graiEval);
	    	  graiEvalService.queryForPage(pageModel);
	    	  model.addAttribute("pageModel",pageModel);
	    	  return "/graieval/graiEvalList";
       }
       
      @RequestMapping("/add")
      private String add(Map map) {
    	 
    	 
    	  return "/graieval/graiEvalEdit";
      }
      
      @RequestMapping("/save")
      @ResponseBody
      private JsonResult save(GraiEval graiEval,HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	graiEval.setCreateUserId(((User)session.getAttribute("user")).getUserID());
    	graiEval.setUpdateUserId(((User)session.getAttribute("user")).getUserID());
    	graiEval.setCreateDate(new Date());
    	graiEval.setUpdateDate(new Date());
    	graiEvalService.save(graiEval);
  		return new JsonResult(true);
      }
      
      @RequestMapping("/update")
      private String update(GraiEval graiEval,Map map) {
      	GraiEval list=graiEvalService.selectById(graiEval.getId());
      	System.out.println(list+"*******************");
      	map.put("list", list);
        return "/graieval/update";
      
        }
      
      
      @RequestMapping("/updateSave")
      @ResponseBody
      private JsonResult updateSave(GraiEval graiEval,HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	graiEval.setUpdateUserId(((User)session.getAttribute("user")).getUserID());
    	graiEval.setUpdateDate(new Date());
    	graiEvalService.updateSave(graiEval);
  		return new JsonResult(true);
      }
      
     
      @RequestMapping("/delete")
      @ResponseBody
      private JsonResult delete(@RequestBody String ids,HttpServletRequest request) {
    	  System.out.println(ids);
    	  ids = "&"+ids ;
    	  String[] idss = ids.split("&ids%5B%5D=");
    	  HttpSession session=request.getSession();
    	  User user = (User)session.getAttribute("user");
    	
    	//System.out.println("******************"+Arrays.toString(idss)+"************************");
    	
    	  for(int i = 1;i<idss.length;i++){
	    	//通过id 设置修改者id 修改时间 修改成"Y"
    		GraiEval graiEval=new GraiEval();
	    	graiEval.setId(Integer.parseInt(idss[i]));
	        graiEval.setUpdateUserId(user.getUserID());
	    	graiEval.setUpdateDate(new Date());
	    	graiEvalService.delete(graiEval);
	    	
	    	}
  		return new JsonResult(true);
    
      }
      
      //粮食产量评估管理
      @RequestMapping("/listquery")
      public String listquery(Map map) {
    	  
    	
    	  return "/graieval/graiEvalListQuery";
      }
      
}
