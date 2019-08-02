<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="simple" uri="/tags/simple"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="width:100%;height:100%;overflow:hidden">
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
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
<body class="easyui-layout">
	<div region="center" border="false" style="padding:5px;">
			<form id="inputFrom" name="inputFrom" method="get" action="../geneLandReg/list">
			<fieldset id="queryBlock" class="fieldset_common_style">
			<table class="table_common_style">
				<tr>
					<td class="table_common_td_label_style">年度：</td>
					<td class="table_common_td_txt_style">
						${geneLandReg.year }
					</td>
					<td class="table_common_td_label_style">企业：</td>
					<td class="table_common_td_txt_style">
						${geneLandReg.companyName }
					</td>
				</tr>
				<tr>
					<td class="table_common_td_label_style">申请批次号：</td>
					<td class="table_common_td_txt_style">
						${geneLandReg.applyBatchNo}
					</td>
					<td class="table_common_td_label_style">审核状态：</td>
					<td class="table_common_td_txt_style">
						<simple:showName entityName="commonData" codeKey="GeneralRegistStatus" value="${geneLandReg.status}"></simple:showName>
					</td>
				</tr>
				<tr>
					<td class="table_common_td_label_style">审核人：</td>
					<td class="table_common_td_txt_style">
						${geneLandReg.auditor}
					</td>
					<td class="table_common_td_label_style">审核时间：</td>
					<td class="table_common_td_txt_style">
						<fmt:formatDate value="${geneLandReg.auditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>
			</table>
			</fieldset>	
			<fieldset id="toolBlock" class="fieldset_common_style">
			<table>
				<tr>
					<td>
						
					</td>
				</tr>				
			</table>
		</fieldset>
		<table id="geneLandData" class="easyui-datagrid" style="table-layout:fixed;border-collapse: collapse;">
			<thead> 
				<tr> 
					<!-- Modify By WolfSoul Begin -->
					<th field="contractorText" width="120" align="center" nowrap="nowrap">承包方类型</th>
					<th field="idTypeText" width="120" align="center" nowrap="nowrap">证件类型</th>
					<th field="contractorID" width="150" align="center" nowrap="nowrap">证件号码</th>
					<th field="contractorName" width="120" align="center" nowrap="nowrap">承包方</th>
					<th field="townText" width="120" align="center" nowrap="nowrap">所在乡</th>
					<th field="countryText" width="120" align="center" nowrap="nowrap">所在村</th>
					<th field="groupName" width="200" align="center" nowrap="nowrap">住址</th>
					<th field="zmj" width="130" align="center" nowrap="nowrap">承包总面积（亩）</th>
					<th field="yba" width="130" align="center" nowrap="nowrap">已备案面积（亩）</th>
					<th field="kba" width="130" align="center" nowrap="nowrap">可备案面积（亩）</th>
					<th field="archiveAcreage" width="130" align="center" nowrap>本次备案面积（亩）</th>
					<th field="operatorName" width="130" align="center" nowrap="nowrap">经办人</th>
					<th field="operatorDate" width="120" align="center" nowrap="nowrap">经办日期</th> 
					<!-- Modify By WolfSoul End -->
				</tr>
			</thead>
			<tbody id="dataBody">
				<%-- <c:forEach var="geneLandRegD" items="${genLandReg}" varStatus="status"> --%>
				<%-- Modify By WolfSoul Begin --%>
				<tr>
					<td height="30" align="center" nowrap>
						<simple:showName entityName="commonData" codeKey="ContractorType" value="${geneLandReg.geneLandRegD.contractorType}"></simple:showName>
					</td>
					<td height="30" align="center" nowrap>
						<simple:showName entityName="commonData" codeKey="IDType" value="${geneLandReg.geneLandRegD.idType}"></simple:showName>
					</td>
					<td height="30" align="center" nowrap>${geneLandReg.geneLandRegD.contractorID}</td>
					<td height="30" align="center" nowrap>${geneLandReg.geneLandRegD.contractorName}</td>
					<td height="30" align="center" nowrap>${geneLandReg.geneLandRegD.townName}</td>
					<td height="30" align="center" nowrap>${geneLandReg.geneLandRegD.countryName}</td>
					<td height="30" align="center" nowrap>${geneLandReg.geneLandRegD.groupName}</td>
					<td height="30" align="center" nowrap>
						<f:formatNumber type="number" value="${geneLandReg.geneLandRegD.zmj}" pattern="0.00" maxFractionDigits="2"/>
					</td>
					<td height="30" align="center" nowrap>
						<f:formatNumber type="number" value="${geneLandReg.geneLandRegD.yba}" pattern="0.00" maxFractionDigits="2"/>
					</td>
					<td height="30" align="center" nowrap>
						<f:formatNumber type="number" value="${geneLandReg.geneLandRegD.kba}" pattern="0.00" maxFractionDigits="2"/>
					</td>
					<td height="30" align="center" nowrap>
						<f:formatNumber type="number" value="${geneLandReg.geneLandRegD.archiveAcreage}" pattern="0.00" maxFractionDigits="2"/>
					</td>
					<td height="30" align="center" nowrap>${geneLandReg.geneLandRegD.operatorName}</td>
					<td height="30" align="center" nowrap>
						<fmt:formatDate value="${geneLandReg.geneLandRegD.operatorDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>
				<%-- Modify By WolfSoul End --%>
				<%-- </c:forEach>	 --%>	
			</tbody>
		</table>
		</form>
	</div>
	<div id="addDialog"></div>
	
<script type="text/javascript">
$(document).ready(function(){
	 var winHeight = $(window).height();
     var queryBlockHeight = $("#queryBlock").height();
     var toolBlock = $("#toolBlock").height();
	//Modify By WolfSoul Begin
	$("#geneLandData").datagrid({ 
		height:winHeight -queryBlockHeight -toolBlock - 50,
        rownumbers: true,
        fitColumns: false
	});
	//Modify By WolfSoul End
});

function reList(){
	document.location.href = "${pageContext.request.contextPath}/geneLandReg/list?year=${year}&companyCode=${companyCode}&beginDate=${beginDate}&endDate=${endDate}&status=${status}&page=${page}&pageSize=${pageSize}";
}
</script>
</body>
</html>