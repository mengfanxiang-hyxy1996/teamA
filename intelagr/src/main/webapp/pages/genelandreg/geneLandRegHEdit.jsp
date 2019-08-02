<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html style="width:100%;height:100%;overflow:hidden">
<head>
<title>用户管理-五常优质水稻溯源监管平台</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/table.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/themes/color.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form2js.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/json2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>

</head>
<body>
	<div region="center" border="false" style="padding:5px;">
	<form id="inputFrom" name="inputFrom" method="post" action="../geneLandReg/list">
		<table id="data">
			<tr>
				<th>
					<a href="#" class="easyui-linkbutton" style="margin-left:1px; width:80px;" onclick="return save();">
						<span class="l-btn-left">
							<span class="l-btn-text icon-ok l-btn-icon-left">
						确定
						</span></span>
					</a>
					<a href="#" class="easyui-linkbutton" style="margin-left:1px; width:80px;" onclick="return closeEditDialog();">
						<span class="l-btn-left">
							<span class="l-btn-text icon-cancel l-btn-icon-left">
						返回</span></span>
					</a>
				</th>
			</tr>
		</table>
	
	<fieldset class="fieldset_common_style">
			<table class="table_common_style">
				<tr>
					<td class="table_common_td_label_style">审批流水号：</td>
					<td class="table_common_td_txt_style">
					<input name="applyBatchNo" id="applyBatchNo" readonly="readonly" value="${gen.applyBatchNo }"  style="width:150px;">
					</td>
					<td class="table_common_td_label_style">年度：</td>
					<td class="table_common_td_txt_style">
						<select id="year" name="year"style="width:187px;height:25px">
							<c:forEach items="${year }" var="y">
							<option value="${y.yearCode }">${y.yearName }</option>
							</c:forEach>
						</select>
					</td>
					
				</tr>
				<tr>
					<td class="table_common_td_label_style">审核：</td>
					<td class="table_common_td_txt_style">
						<input name="companyCode" type="hidden" value="${gen.companyCode }" />
							<select id="status" name="status" style="width:187px;height:25px">
								<option value=" ">-=请选择=-</option>
								<option value="02">通过</option>
								<option value="03">不通过</option>
							</select>
					</td>
					<td class="table_common_td_label_style">原因：</td>
					<td><input type="text" name="reason" value=" " style="width:200px;" /> </td>
				</tr>
			</table>
		</fieldset>
	
	

		<fieldset class="fieldset_common_style">
			
			<table class="table_common_style">
				<tr>
					<td class="table_common_td_label_style">证件类型：</td>
					<td class="table_common_td_txt_style editableFalse">
						<select id="idType" name="idType" style="width:150px;">
							<option value="01">身份证</option>
						</select>
						<span class="span_common_mustinput_style">*</span>
					</td>
					<td class="table_common_td_label_style">证件号码：</td>
					<td class="table_common_td_txt_style">
						<input name="contractorID" id="contractorID" value="${gen.geneLandRegD.contractorID }" readonly="readonly"  style="width:150px;">
						<span class="span_common_mustinput_style">*</span>
					</td>
				</tr>
			</table>	
		</fieldset>
		
		
		
		
		
		
		<fieldset class="fieldset_common_style">
			<table class="table_common_style">
				<tr>
					<td class="table_common_td_label_style">承包方类型：</td>
					<td class="table_common_td_txt_style">
					<select id="contractorType" name="contractorType"  style="width:150px;">
						<option value="01">农户</option>
					</select>
					</td>
					<td class="table_common_td_label_style">承包方：</td>
					<td class="table_common_td_txt_style">
						<input name="contractorName" id="tmp_contractorName" readonly="readonly" value="${gen.geneLandRegD.contractorName }"  style="width:150px;">
					</td>
					
				</tr>
				
				<tr>
					<td class="table_common_td_label_style">联系方式：</td>
					<td class="table_common_td_txt_style">
						<input name="contractorTel" id="tmp_contractorTel" value="${gen.geneLandRegD.contractorTel }" style="width:150px;">
						<span class="span_common_mustinput_style">*</span>
					</td>
					<td class="table_common_td_label_style">住址：</td>
					<td colspan="5" class="table_common_td_txt_style">
						<input type="text"  id="tmp_groupName" name="groupName" value="${gen.geneLandRegD.groupName }" readonly="readonly" style="width:200px;">
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset class="fieldset_common_style">
			<table id="datas" height="120px;" width="100%" class="easyui-datagrid" striped="true" singleSelect="true">
				<thead>
				<tr>
					<th field="landType" width="20%" height="20" align="center" nowrap >土地类型</th>
					<th field="aMu" width="20%" height="20" align="center" nowrap>实（亩）</th>
					<th field="cMu" width="20%" height="20" align="center" nowrap>测量（亩）</th>
					<th field="landClass" width="20%" height="20" align="center" nowrap>土地类别</th>
					<th field="landName" width="20%" height="20" align="center" nowrap>地块名称</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${gen.geneLandRegD.geneLandDetail}" var="c" >
					<tr>
					<td align="center" height="20">${c.landTypeName }</td>
					<td align="center" height="20">${c.actualMu }</td>
					<td align="center" height="20">${c.measurementMu }</td>
					<td align="center" height="20">${c.landClassName }</td>
					<td align="center" height="20">${c.landName }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</fieldset>
		<fieldset class="fieldset_common_style">
			<table class="table_common_style">
		
						<tr>
					<td class="table_common_td_label_style">承包总面积（亩）：</td>
					<td class="table_common_td_txt_style">
						<input name="zmj" id="zmj" readonly="readonly" value="${gen.geneLandRegD.contractTotalYield }" style="background-color:#B0B0B0;width:150px;">
					</td>
					<td class="table_common_td_label_style">已备案面积（亩）：</td>
					<td class="table_common_td_txt_style">
						<input name="ybamj" id="ybamj" readonly="readonly"  value="${gen.geneLandRegD.yba}"  style="background-color:#B0B0B0;width:150px;">
					</td>
				</tr>
				<tr>
					<td class="table_common_td_label_style">可备案面积（亩）：</td>
					<td class="table_common_td_txt_style">
						<input name="kbamj" id="kbamj" readonly="readonly" value="${gen.getGeneLandRegD().kba }"  style="background-color:#B0B0B0;width:150px;">
					</td>
					<td class="table_common_td_label_style"><strong>本次备案面积（亩）：</strong></td>
					<td class="table_common_td_txt_style">
						<input name="archiveAcreage" id="tmp_archiveAcreage" value="${gen.geneLandRegD.archiveAcreage }" style="width:150px;">
						<span class="span_common_mustinput_style">*</span>
					</td>
				</tr>
				<tr>   
					<td class="table_common_td_label_style">经办人：</td>
					<td class="table_common_td_txt_style">
						<input name="operatorName" id="tmp_operatorName" value="${gen.geneLandRegD.operatorName }"  type="text" style="width:150px;">
						<span class="span_common_mustinput_style">*</span>
					</td>
					<td class="table_common_td_label_style"><strong>经办日期：</strong></td>
					<td class="table_common_td_txt_style editableFalse">
						<input name="operatorDate" id="tmp_operatorDateDate" value='<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd HH:mm:ss"/>' style="width:150px">
            			<span class="span_common_mustinput_style">*</span>
					</td>
				</tr>
			</table>
		</fieldset>
		</form>
	</div>
	<div id="addDialog"></div>
	
<script type="text/javascript">

function save(){
	var a = $('#inputFrom').toObject();
	showLoading();
	$.ajax({
		
		url:"${pageContext.request.contextPath}/geneLandReg/editReg",
		type:"post",
		data:{"test":JSON.stringify(a)},
		success:function(e){
			hideLoading();
			if (200 == e.status) {
				$.messager.alert('提示','操作成功。','info', function(){
					var retFlag = "";
					if( retFlag == "1" ){//为1表示从一览页面过来的;
						retList();
					}else{
						document.location.href = "${pageContext.request.contextPath}/geneLandReg/list";
					}
				});
			} else {
				$.messager.alert('错误',e.msg,'error');
			}
		},
		dataType:"json"
	})
	
}
function closeEditDialog(){
	$('#addDialog').dialog('close');
}
</script>
</body>
</html>