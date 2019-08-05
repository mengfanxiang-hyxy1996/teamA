<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/tags/simple" %>
<!DOCTYPE html>
<html style="width:100%;height:100%;overflow:hidden">
<head>
<title>用户管理-五常优质水稻溯源监管平台</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/index.css">
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
		<fieldset id="queryBlock" class="fieldset_common_style">
			<form id="inputForm" name="inputRegForm" method="post" action="${pageContext.request.contextPath}/recall/list">
				<input type='hidden' id="pageTotal" name="pageTotal" value="${pageModel.totalCount }" />
				<input type="hidden" id="page" name="page" value="${pageModel.page }">
				<input type="hidden" id="pageSize" name="pageSize" value="${pageModel.pageSize }">
				
				<table class="table_common_style">
					<tr>
						<td class="table_common_td_label_query_style">企业：</td>
						<td class="table_common_td_txt_query_style">
							
        <s:select name="companyCode" id="companyCode" entityName="company" value="${pageModel.data.companyCode }"  hasPleaseSelectOption="true"></s:select>
						</td>
						<td class="table_common_td_label_query_style">批次号：</td>
						<td class="table_common_td_txt_query_style">
							<input type="text" class="easyui-textbox" value="${batchNo }" name="batchNo" id="batchNo"/>
						</td>
					</tr>
					<tr>
						<td class="table_common_td_label_query_style">处理日期：</td>
						<td colspan="2" class="table_common_td_txt_query_style editableFalse">
							<input class="easyui-datebox" name="beginDate" id="beginDate"
							value="${pageModel.data.beginDate }"
							data-options="required:false,showSeconds:false"
							style="width: 150px" editable="false" /> ~ <input
							class="easyui-datebox" name="endDate" id="endDate" value="${pageModel.data.endDate }"
							data-options="required:false,showSeconds:false"
							style="width: 150px" editable="false" />
						</td>
						
						<td align="right" valign="bottom">
	                       	<a href="#" class="easyui-linkbutton" onclick="form_check();">
	                       		<span class="l-btn-left"><span class="l-btn-text icon-search l-btn-icon-left">查询</span></span>
	                       	</a>
	             		</td>
					</tr>
				</table>	
			</form>
		</fieldset>
		
		<table id="data" class="easyui-datagrid" striped="true" singleSelect="false" pageSize="${pageModel.pageSize }" pageNumber="${pageModel.page }">
			<thead>
				<tr>
					<th field="companyName" width="250" align="center">企业名称</th>
					<th field="inputName" width="120" align="center">处理日期</th>
					<th field="inpuDealer" width="120" align="center">批次</th>
					<th field="purchaseQuantity" width="80" align="center">产品名称</th>
					<th field="reason" width="300" align="center">召回原因</th>
				</tr>
			</thead>
			<tbody>
						<c:forEach items="${pageModel.result }" var="r">
				<tr>
					<td height="30" align="center" nowrap>${r.company.companyName }</td>
					<td height="30" align="center" nowrap>${r.settleDate }</td>
					<td height="30" align="center" nowrap>${r.batchNo }</td>
					<td height="30" align="center" nowrap>${r.product.productName }</td>
					<td height="30" align="center" nowrap>${r.recallReason }</td>
					
				</tr>
				</c:forEach>	
			</tbody>
		</table>
	</div>
	<div id="addDialog"></div>
	
<script type="text/javascript">
$(document).ready(function(){
	var winHeight = $(window).height();
	var queryBlockHeight = $("#queryBlock").height();
	var toolBlock = $("#toolBlock").height();
	$("#data").datagrid({ 
		height:winHeight -queryBlockHeight -30,
		pagination: true,
        rownumbers: true,
        fitColumns: false,
        //fit: true,
        pageList: [10,20,25],
        pagePosition: "top"
	});
	
	var pagger = $('#data').datagrid('getPager');  
	$(pagger).pagination({
		total: $("#pageTotal").val(),
		pageNumber: parseInt($("#page").val()),
		showPageList: true,
		showRefresh:false,
	    onSelectPage: function(pageNumber, pageSize){
	    	$('#page').val(pageNumber);
	    	$('#pageSize').val(pageSize);
	    	showLoading();
	    	$('#inputForm').submit();
	    }
	});
});

function form_check(){
	var beginDate =$.trim($("#beginDate").datebox('getValue'));
	var endDate =$.trim($("#endDate").datebox('getValue'));
	if(!dateCompare(beginDate,endDate)){
		$.messager.alert('警告','处理日期开始日不能大于结束日。','warning');
		return false;
	}
	showLoading();
	$('#inputForm').submit();
}
</script>
</body>
</html>