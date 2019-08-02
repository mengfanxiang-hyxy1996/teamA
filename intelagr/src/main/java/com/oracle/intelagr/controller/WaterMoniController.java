package com.oracle.intelagr.controller;

import java.util.Date;
import java.util.List;

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
import com.oracle.intelagr.entity.MoniPoint;
import com.oracle.intelagr.entity.User;
import com.oracle.intelagr.entity.WaterMoni;
import com.oracle.intelagr.mapper.MoniPointMapper;
import com.oracle.intelagr.service.impl.WaterMoniService;

@Controller
@RequestMapping("/waterMoni")
public class WaterMoniController {
	@Autowired
	private WaterMoniService waterMoniService;
	@Autowired
	private MoniPointMapper moniPointMapper;
	@RequestMapping("/list")
	public String list(WaterMoni waterMoni,PageModel pageModel,Model model) {
		pageModel.setData(waterMoni);
		waterMoniService.queryForPage(pageModel);
		model.addAttribute("pageModel", pageModel);
		return "watermoni/waterMoniList";
	}
	@RequestMapping("/add")
	public String add(Model model) {
		List<WaterMoni> list=waterMoniService.selectAll();
		List<MoniPoint> mlist=moniPointMapper.select();
		model.addAttribute("mlist", mlist);
		model.addAttribute("list", list);
		return "/watermoni/waterMoniAdd";
	}
	@RequestMapping("/save")
	@ResponseBody
	public JsonResult save(@RequestBody WaterMoni waterMoni,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		waterMoni.setCreateUserId(user.getUserID());
		waterMoni.setUpdateUserId(user.getUserID());
		waterMoni.setCreateDate(new Date());
		waterMoni.setUpdateDate(new Date());
		waterMoni.setMonitorDate(new Date());
		waterMoniService.save(waterMoni);
		return new JsonResult(true);
	}
	@RequestMapping("/update")
	@ResponseBody
	public JsonResult update(@RequestBody WaterMoni waterMoni,HttpServletRequest request) {
		HttpSession session = request.getSession();
		waterMoni.setUpdateUserId(((User)session.getAttribute("user")).getUserID());
		waterMoni.setUpdateDate(new Date());
		waterMoniService.update(waterMoni);
		return new JsonResult(true);
	}
	@RequestMapping("/edit")
	public String edit(int id,Model model) {
		WaterMoni waterMoni = waterMoniService.selectById(id);
		List<MoniPoint> mlist=moniPointMapper.select();
		model.addAttribute("mlist", mlist);
		model.addAttribute("waterMoni",waterMoni);
		return "/watermoni/waterMoniEdit";
	}
	@RequestMapping("/delete")
	@ResponseBody
	public JsonResult delete(HttpServletRequest request) {
		String [] ids=request.getParameterValues("ids[]");
		int [] id=new int[ids.length];
		for (int i=0;i<ids.length;i++) {
			id[i]=Integer.parseInt(ids[i]);
		}
		System.out.println(ids.toString());
		waterMoniService.updateflag(id);
		return new JsonResult(true);
	}
	@RequestMapping("/view")
	public String view(int id,Model model) {
		WaterMoni waterMoni = waterMoniService.selectById(id);
		List<MoniPoint> mlist=moniPointMapper.select();
		model.addAttribute("mlist", mlist);
	    model.addAttribute("waterMoni",waterMoni);
		return "watermoni/waterMoniEdit";
	}
	
}
