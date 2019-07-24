package com.oracle.intelagr.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.intelagr.common.CommonUtil;
import com.oracle.intelagr.common.Constants;
import com.oracle.intelagr.common.JsonResult;
import com.oracle.intelagr.entity.AreaDevision;
import com.oracle.intelagr.entity.SpecLandDetail;
import com.oracle.intelagr.entity.SpecLandReg;
import com.oracle.intelagr.entity.User;
import com.oracle.intelagr.service.IAreaDevisionService;
import com.oracle.intelagr.service.IFileManagerService;
import com.oracle.intelagr.service.IServialNumService;
import com.oracle.intelagr.service.ISpecLandDetailService;
import com.oracle.intelagr.service.ISpecLandRegService;

@Controller
@RequestMapping("/specLandReg")
public class SpecLandRegController {
	@Autowired
	private IServialNumService servialNumService;
	@Autowired
	private IAreaDevisionService AreaDevisionService;
	@Autowired
	private IFileManagerService fileManagerService;
	@Autowired
	private ISpecLandRegService specLandRegService;
	@Autowired
	private ISpecLandDetailService specLandDetailService;	
/*	@Autowired
	private ICompanyService companyService;	*/
/*	@Autowired
	private IYearCodeService yearService;	*/
/*	@Autowired
	private ICommonDataService commonDataService;	*/	
	@RequestMapping("/editInput")
	public String editInput(Model model) {		
	//	List<YearCode> yearList = yearService.getYearCodeList();
	//	List<Company>  companyList = companyService.getCompanyListByCompanyType(null);
	//	List<CommonData> contracList = commonDataService.getCommonDataListByCodeKey("ContractorType");
	//	List<CommonData> idTypeList = commonDataService.getCommonDataListByCodeKey("IDType");
	//	List<CommonData> plowlandTypeList = commonDataService.getCommonDataListByCodeKey("PlowlandType");
	//	List<CommonData> plowlandClassList = commonDataService.getCommonDataListByCodeKey("PlowlandClass");
	//	model.addAttribute("companyList", companyList);
	//	model.addAttribute("yearList",yearList);
	//	model.addAttribute("contracList",contracList);
	//	model.addAttribute("idTypeList",idTypeList);
	//	model.addAttribute("plowlandTypeList",plowlandTypeList);
	//	model.addAttribute("plowlandClassList",plowlandClassList);			
		String result = servialNumService.getServialNum(Constants.BIZ_TYPE_TX);
		model.addAttribute("result", result);
		return "/speclandreg/specLandRegEdit";
	}
	@RequestMapping("/townCode")
	@ResponseBody
	public JsonResult townCode() {
		List<AreaDevision> TownList = AreaDevisionService.queryTown();
		JsonResult result = new JsonResult(true,"操作成功");
		result.setData(TownList);
		return result;
	}
	
	@RequestMapping("/countryCode")
	@ResponseBody
	public JsonResult countryCode(String townCode) {
		List<AreaDevision> CountryList = AreaDevisionService.queryCountry(townCode);
		JsonResult result = new JsonResult(true,"操作成功");
		result.setData(CountryList);
		return result;
	}
	@RequestMapping("/save")
	@ResponseBody
	public JsonResult save(SpecLandReg specLandReg,SpecLandDetail specLandDetail,String operatorDate1,HttpServletRequest request) {
		HttpSession session = request.getSession();
		specLandReg.setCreateUserId(((User)session.getAttribute("user")).getUserID());
		specLandReg.setUpdateUserId(((User)session.getAttribute("user")).getUserID());
		specLandReg.setCreateDate(new Date());
		specLandReg.setUpdateDate(new Date());
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		try {
			specLandReg.setOperatorDate(date.parse(operatorDate1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		specLandReg.setRemark("特殊土地备案");
		specLandRegService.save(specLandReg);
		specLandDetail.setHid(specLandReg.getId());
		specLandDetail.setCreateUserId(((User)session.getAttribute("user")).getUserID());
		specLandDetail.setUpdateUserId(((User)session.getAttribute("user")).getUserID());
		specLandDetail.setCreateDate(new Date());
		specLandDetail.setUpdateDate(new Date());
		specLandDetailService.save(specLandDetail);
		CommonUtil.saveMfile(fileManagerService, "04", String.valueOf(specLandReg.getId()), request);
		return new JsonResult(true);
	}
	@RequestMapping("/list")
	public String list(Model model) {
		return "/speclandreg/specLandRegList";
	}
	@RequestMapping("/listquery")
	public String listquery(Model model) {
		return "/speclandreg/specLandRegListQuery";
	}
}
