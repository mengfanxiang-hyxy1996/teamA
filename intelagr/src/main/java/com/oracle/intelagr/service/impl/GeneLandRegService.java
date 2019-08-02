package com.oracle.intelagr.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.AreaDevision;
import com.oracle.intelagr.entity.CommonData;
import com.oracle.intelagr.entity.Contract;
import com.oracle.intelagr.entity.GeneLandDetail;
import com.oracle.intelagr.entity.GeneLandReg;
import com.oracle.intelagr.entity.GeneLandRegD;
import com.oracle.intelagr.entity.GraiReg;
import com.oracle.intelagr.entity.Peasant;
import com.oracle.intelagr.entity.SpecLandReg;
import com.oracle.intelagr.entity.User;
import com.oracle.intelagr.mapper.AreaDevisionMapper;
import com.oracle.intelagr.mapper.CommonDataMapper;
import com.oracle.intelagr.mapper.ContractMapper;
import com.oracle.intelagr.mapper.GeneLandDetailMapper;
import com.oracle.intelagr.mapper.GeneLandRegDMapper;
import com.oracle.intelagr.mapper.GeneLandRegMapper;
import com.oracle.intelagr.mapper.PeasantMapper;
import com.oracle.intelagr.mapper.SpecLandRegMapper;
import com.oracle.intelagr.service.IGeneLandRegService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class GeneLandRegService implements IGeneLandRegService {
	@Autowired
	private GeneLandRegMapper geneLandRegMapper;
	@Autowired
	private GeneLandRegDMapper geneLandRegDMapper;
	@Autowired
	private GeneLandDetailMapper geneLandDetailDMapper;
	@Autowired
	private PeasantMapper peasantMapper;
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private CommonDataMapper commonDataMapper;
	@Autowired
	private AreaDevisionMapper areaDevisionMapper;
	@Autowired
	private SpecLandRegMapper specLandRegMapper;

	@Override
	public int selectLastId() {
		// TODO Auto-generated method stub
		return geneLandRegMapper.selectLastId();
	}

	@Override
	@Transactional
	public void add(String test, User user) {
		// TODO Auto-generated method stub
		GeneLandReg gen = new GeneLandReg();
		JSONObject obj = JSONObject.fromObject(test);
		String year = (String) obj.get("year");
		String companyCode = (String) obj.get("companyCode");
		String companyName = (String) obj.get("companyName");
		String status = (String) obj.get("status");
		String applyBatchNo = (String) obj.get("applyBatchNo");
		gen.setYear(year);
		gen.setCompanyCode(companyCode);
		gen.setCompanyName(companyName);
		gen.setStatus(status);
		gen.setApplyBatchNo(applyBatchNo);
		gen.setRemark("备注");
		gen.setDeleteFlag("N");
		gen.setCreateDate(new Date());
		gen.setCreateUserId(user.getUserID());
		gen.setUpdateDate(new Date());
		gen.setUpdateUserId(user.getUserID());
		geneLandRegMapper.insert(gen);
		int hid = geneLandRegMapper.selectLastId();
		List<GeneLandRegD> list = (List<GeneLandRegD>) JSONArray
				.toList(JSONArray.fromObject(obj.get("list").toString()), GeneLandRegD.class);
		GeneLandRegD gend = list.get(0);
		gend.setRegisteredTotalYield(gend.getArchiveAcreage());
		gend.setHid(hid);
		gend.setCityCode("230184");
		gend.setRemark("备注");
		gend.setDeleteFlag("N");
		gend.setCreateDate(new Date());
		gend.setCreateUserId(user.getUserID());
		gend.setUpdateDate(new Date());
		gend.setUpdateUserId(user.getUserID());
		geneLandRegDMapper.insert(gend);
		int hid2 = geneLandRegDMapper.selectLastId();
		// geneLandDetailDMapper.
		String[] contractorValue = obj.get("contractorValue").toString().split(",");
		String landType = contractorValue[0];
		String landClass = contractorValue[1];

		String contractorCode = peasantMapper.select(gend.getContractorID()).getContractorCode();
		List<Contract> contracts = contractMapper.select(contractorCode);
		for (Contract contract : contracts) {
			Float sc = null;
			if (contract.getContractArea() == 0) {
				sc = contract.getMeasurementMu();
			} else {
				sc = contract.getContractArea();
			}
			Float cl = contract.getMeasurementMu();
			GeneLandDetail gendl = new GeneLandDetail();
			gendl.setHid(hid2);
			gendl.setLandType(landType);
			gendl.setActualMu(sc);
			gendl.setMeasurementMu(cl);
			gendl.setLandClass(landClass);
			gendl.setLandName(contract.getLandName());
			gendl.setCityCode(gend.getCityCode());
			gendl.setTownCode(gend.getTownCode());
			gendl.setCountryCode(gend.getCountryCode());
			gendl.setGroupName(gend.getGroupName());
			gendl.setRemark("备注");
			gendl.setDeleteFlag("N");
			gendl.setCreateDate(new Date());
			gendl.setCreateUserId(user.getUserID());
			gendl.setUpdateDate(new Date());
			gendl.setUpdateUserId(user.getUserID());
			geneLandDetailDMapper.insert(gendl);
		}
	}

	@Override
	public void queryforpage(PageModel pageModel) {
		// TODO Auto-generated method stub
		GeneLandReg gen = (GeneLandReg)pageModel.getData();
		Map<String,Object> map = new HashMap<>();
		map.put("year", gen.getYear());
		map.put("companyCode", gen.getCompanyCode());
		map.put("status", gen.getStatus());
		
		map.put("beginDate", gen.getBeginDate());
		map.put("endDate", gen.getEndDate());
		map.put("index", (pageModel.getPage()-1)*pageModel.getPageSize());
		map.put("pageSize", pageModel.getPageSize());
		List<GeneLandReg> list = geneLandRegMapper.select(map) ;
		pageModel.setTotalCount(geneLandRegMapper.selectCount(map));
		pageModel.setResult(list);
	}

	@Override
	public Float getSum(PageModel pageModel) {
		GeneLandReg gen = (GeneLandReg)pageModel.getData();
		Map<String,Object> map = new HashMap<>();
		map.put("year", gen.getYear());
		map.put("companyCode", gen.getCompanyCode());
		map.put("status", gen.getStatus());
		map.put("beginDate", gen.getBeginDate());
		map.put("endDate", gen.getEndDate());
		map.put("index", (pageModel.getPage()-1)*pageModel.getPageSize());
		map.put("pageSize", pageModel.getPageSize());
		List<GeneLandReg> list = geneLandRegMapper.select(map) ;
		float sum = 0;
		for (GeneLandReg geneLandReg : list) {
			sum+=geneLandReg.getGeneLandRegD().getArchiveAcreage();
		}
		return sum;
	}

	@Override
	public GeneLandReg queryone(int id) {
		// TODO Auto-generated method stub
		
		GeneLandReg  gen = geneLandRegMapper.selectById(id);
		String contractorID = gen.getGeneLandRegD().getContractorID();
		AreaDevision areaDevision = new AreaDevision();
		areaDevision.setCityCode("230184");
		areaDevision.setTownCode(gen.getGeneLandRegD().getTownCode());
		areaDevision.setCountryCode(gen.getGeneLandRegD().getCountryCode());
		AreaDevision an = areaDevisionMapper.select(areaDevision);
		gen.getGeneLandRegD().setTownName(an.getTownName());
		gen.getGeneLandRegD().setCountryName(an.getCountryName());
		Peasant  peasant = peasantMapper.select(contractorID);
		float zmj = 0;
		for(Contract c:peasant.getContract()) {
			zmj+=c.getMeasurementMu();
		}
		float yba = gen.getGeneLandRegD().getArchiveAcreage();
		float kba = zmj-yba;
		gen.getGeneLandRegD().setZmj(zmj);
		gen.getGeneLandRegD().setYba(yba);
		gen.getGeneLandRegD().setKba(kba);
		return gen;
	}


	@Override
	public GeneLandReg queryapplyBatchNo(String applyBatchNo) {
		// TODO Auto-generated method stub
		GeneLandReg gen = geneLandRegMapper.selectByapplyBatchNo(applyBatchNo);
		for(GeneLandDetail genl:gen.getGeneLandRegD().getGeneLandDetail()) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("codeKey", "PlowlandType");
			map.put("codeCode", genl.getLandType());
			List<CommonData> c= commonDataMapper.select(map);
			map.put("codeKey", "PlowlandClass");
			map.put("codeCode", genl.getLandClass());
			List<CommonData> c2 = commonDataMapper.select(map);
			genl.setLandTypeName(c.get(0).getCodeValue());
			genl.setLandClassName(c2.get(0).getCodeValue());
		}
		float ybaSum = geneLandRegDMapper.selectSum(gen.getGeneLandRegD().getContractorID());
		float kba = gen.getGeneLandRegD().getContractTotalYield()-ybaSum;
		gen.getGeneLandRegD().setKba(kba);
		gen.getGeneLandRegD().setYba(ybaSum);
		return gen;
	}

	@Override
	@Transactional
	public void update(String test) throws ParseException {
		JSONObject obj = JSONObject.fromObject(test);
		System.out.println(obj.get("operatorDate").toString());
		String applyBatchNo = (String)obj.get("applyBatchNo");
	
		String status = (String)obj.get("status");
		String reason = (String)obj.get("reason");
		String operatorName = (String)obj.get("operatorName");
		String contractorID = (String)obj.get("contractorID");
		String contractorTel = (String)obj.get("contractorTel");
		String groupName = (String)obj.get("groupName");
		float archiveAcreage = Float.parseFloat(obj.get("archiveAcreage").toString());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date operatorDate = sf.parse(obj.get("operatorDate").toString());
		GeneLandReg gen = new GeneLandReg();
		gen.setApplyBatchNo(applyBatchNo);
		gen.setStatus(status);
		gen.setReason(reason);
		gen.setAuditor(operatorName);
		gen.setAuditTime(operatorDate);
		geneLandRegMapper.update(gen);
		GeneLandRegD gend = new GeneLandRegD();
		gend.setContractorID(contractorID);
		gend.setContractorTel(contractorTel);
		gend.setGroupName(groupName);
		gend.setArchiveAcreage(archiveAcreage);
		gend.setOperatorName(operatorName);
		geneLandRegDMapper.update(gend);
	}


	@Override
	public void delete(int id) {
		geneLandRegMapper.delete(id);
	}



}
