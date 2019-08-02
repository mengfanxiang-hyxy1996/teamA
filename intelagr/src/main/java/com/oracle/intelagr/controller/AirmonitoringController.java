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
import com.oracle.intelagr.entity.AirMoni;
import com.oracle.intelagr.entity.MoniPoint;
import com.oracle.intelagr.entity.User;

import com.oracle.intelagr.mapper.MoniPointMapper;
import com.oracle.intelagr.service.IAirmonitoringService;


@Controller
@RequestMapping("/airMoni")
public class AirmonitoringController {
	@Autowired
	private IAirmonitoringService airmonitoringService;
	@Autowired
	private MoniPointMapper moniPointMapper;
	@RequestMapping("/list")
	public String list(AirMoni airmoni,PageModel pageModel,Model model) {
		pageModel.setData(airmoni);
		airmonitoringService.queryForPage(pageModel);
		model.addAttribute("pageModel", pageModel);
		return "/airmoni/airMoniList";
	}
	@RequestMapping("/add")
	public String add(Model model) {
		List<AirMoni> list=airmonitoringService.selectAll();
		List<MoniPoint> mlist=moniPointMapper.select();
		model.addAttribute("mlist", mlist);
		model.addAttribute("list", list);
		return "/airmoni/airMoniAdd";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public JsonResult save(@RequestBody AirMoni airmoni,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		airmoni.setCreateUserId(user.getUserID());
		airmoni.setUpdateUserId(user.getUserID());
		airmoni.setCreateDate(new Date());
		airmoni.setUpdateDate(new Date());
		airmoni.setMonitorDate(new Date());
		return new JsonResult(true);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public JsonResult update(@RequestBody AirMoni airMoni,HttpServletRequest request) {
		HttpSession session = request.getSession();
		airMoni.setUpdateUserId(((User)session.getAttribute("user")).getUserID());
		airMoni.setUpdateDate(new Date());
		airmonitoringService.update(airMoni);
		return new JsonResult(true);
		
	}
	@RequestMapping("/edit")
	public String edit(int id,Model model) {
		AirMoni airMoni = airmonitoringService.selectById(id);
		List<MoniPoint> mlist=moniPointMapper.select();
		model.addAttribute("mlist", mlist);
		model.addAttribute("airMoni",airMoni);
		return "/airmoni/airMoniEdit";
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
		airmonitoringService.updateflag(id);
		return new JsonResult(true);
	}
	@RequestMapping("/view")
	public String view(int id,Model model) {
		
		AirMoni airMoni = airmonitoringService.selectById(id);
		System.out.println(airMoni.getNo2());
		List<MoniPoint> mlist=moniPointMapper.select();
		model.addAttribute("mlist", mlist);
	    model.addAttribute("airMoni",airMoni);
		return "airmoni/airMoniEdit";
	}
	
}
