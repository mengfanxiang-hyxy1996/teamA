package com.oracle.intelagr.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.intelagr.common.Constants;
import com.oracle.intelagr.common.JsonResult;
import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.AreaDevision;
import com.oracle.intelagr.entity.Company;
import com.oracle.intelagr.entity.GeneLandReg;
import com.oracle.intelagr.entity.Peasant;
import com.oracle.intelagr.entity.User;
import com.oracle.intelagr.entity.YearCode;
import com.oracle.intelagr.service.IAreaDevisionService;
import com.oracle.intelagr.service.ICommonDataService;
import com.oracle.intelagr.service.ICompanyService;
import com.oracle.intelagr.service.IGeneLandRegDService;
import com.oracle.intelagr.service.IGeneLandRegService;
import com.oracle.intelagr.service.IPeasantService;
import com.oracle.intelagr.service.IServialNumService;
import com.oracle.intelagr.service.IYearCodeService;

@Controller
@RequestMapping("/geneLandReg")
public class GeneLandRegController {
	@Autowired
	private IServialNumService servialNumService;
	@Autowired
	private ICompanyService companyService;
	@Autowired
	private IPeasantService peasantService;
	@Autowired
	private IGeneLandRegService geneLandRegService;
	@Autowired
	private IYearCodeService yearCodeService;
	
	@RequestMapping("/editInput")
	public String editInput(Model model) {
		List<YearCode> year = yearCodeService.getYearCodeList();
		String num = servialNumService.getServialNum(Constants.BIZ_TYPE_PT);
		List<Company>  list = companyService.getCompanyListByCompanyType(null);
		model.addAttribute("list", list);
		model.addAttribute("num", num);
		model.addAttribute("year", year);
		return "/genelandreg/geneLandRegEdit";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "/genelandreg/geneLandRegDEdit";
	}
	@RequestMapping("/getContratorInfo")
	@ResponseBody
	public JsonResult getContratorInfo(String contractorID,Model model) {
		Peasant  peasant = peasantService.query(contractorID);
		if(peasant==null) {
			return new JsonResult(false,"身份证不存在");
		}
		JsonResult j = new JsonResult(true,"操作成功");
		j.setData(peasant);
		return j;
		
	}
	@RequestMapping("/save")
	@ResponseBody
	public JsonResult save(String test,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		try {
			geneLandRegService.add(test, user);
			return new JsonResult(true,"操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(false,"操作失败");
		}
	}
	
	@RequestMapping("/edit")
	public String edit(String rowIndex,String contractorID,String conInfo,String flag,String year,Model model) {
		model.addAttribute("rowIndex", rowIndex);
		model.addAttribute("conInfo", conInfo);
		model.addAttribute("year", year);
		model.addAttribute("flag", flag);
		Peasant  peasant = peasantService.query(contractorID);
		model.addAttribute("peasant", peasant);
		return "/genelandreg/geneLandRegDEdit";
	}
	
	@RequestMapping("/list")
	public String list(PageModel pageModel,Model model,String companyCode,String status,String year) {
		GeneLandReg gen = new GeneLandReg();
		gen.setCompanyCode(companyCode);
		gen.setYear(year);
		gen.setStatus(status);
		pageModel.setData(gen);
		geneLandRegService.queryforpage(pageModel);
		List<Company>  list = companyService.getCompanyListByCompanyType(null);
		List<YearCode> years = yearCodeService.getYearCodeList();
		model.addAttribute("year", years);
		model.addAttribute("list", list);
		model.addAttribute("pageModel", pageModel);
		return "/genelandreg/geneLandRegList";
	}

	@RequestMapping("/view")
	public String view(int id,Model model) {
		GeneLandReg  gen = geneLandRegService.queryone(id);
		model.addAttribute("geneLandReg", gen);
		return "/genelandreg/geneLandRegView";
	}
	
	@RequestMapping("/update")
	public String update(String applyBatchNo,Model model) {
		System.out.println(applyBatchNo);
		GeneLandReg gen = geneLandRegService.queryapplyBatchNo(applyBatchNo);
		List<Company>  list = companyService.getCompanyListByCompanyType(null);
		List<YearCode> years = yearCodeService.getYearCodeList();
		model.addAttribute("year", years);
		model.addAttribute("list", list);
		model.addAttribute("gen", gen);
		return "/genelandreg/geneLandRegHEdit";
	}
	
	@RequestMapping("/editReg")
	@ResponseBody
	public JsonResult editReg(String test) throws ParseException {
		System.out.println(test);
		try {
			geneLandRegService.update(test);
			return new JsonResult(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(false,"操作失败");
		}
	}
	@RequestMapping("/delete")
	@ResponseBody
	public JsonResult delete(HttpServletRequest request) throws ParseException {
		String[] ids = request.getParameterValues("ids[]");
		System.out.println(ids[0]);
		for(int i = 0;i<ids.length;i++){
			geneLandRegService.delete(Integer.parseInt(ids[i]));
		}
		return new JsonResult(true);
		
	}
}
