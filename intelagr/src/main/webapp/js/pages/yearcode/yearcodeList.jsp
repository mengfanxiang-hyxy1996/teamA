<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html style="width:100%;height:100%;overflow:hidden">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品列表-五常优质水稻溯源监管平台</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>
</head>
<body class="easyui-layout">
	<div region="center" border="false" style="padding:5px;">	
		<fieldset id="queryBlock" class="fieldset_common_style">
			<form id="yearForm" name="yearForm" method="post" action="${pageContext.request.contextPath}/year/list">
				<table class="table_common_style">
					<tr>
						<td class="table_common_td_label_query_style">显示年度：</td>
						<td nowrap>
							<input name="yearName" type="text" value="${pageModel.data.yearName }" class="easyui-textbox" style="width:200px;height:25px">
							<input type='hidden' id="pageTotal" name="pageTotal" value="${pageModel.totalCount }" />
							<input type="hidden" id="page" name="page" value="${pageModel.page }">
							<input type="hidden" id="pageSize" name="pageSize" value="${pageModel.pageSize }">
						</td>
						<td align="right" valign="bottom">
	                       	<a href="#" class="easyui-linkbutton" onclick="onSubmit()">
	                       	<span class="l-btn-left"><span class="l-btn-text icon-search l-btn-icon-left">查询</span></span></a>
	             		</td>
					</tr>
				</table>
			</form>
		</fieldset>
		<fieldset id="toolBlock" class="fieldset_common_style">
			<table>
				<tr>
					<td>
						<a href="#" class="easyui-linkbutton" onclick="addYear();">
							<span class="l-btn-left">
								<span class="l-btn-text icon-add l-btn-icon-left">添加</span>
							</span>
						</a>
						<a href="#" class="easyui-linkbutton" onclick="deleteYear();">
							<span class="l-btn-left">
								<span class="l-btn-text icon-remove l-btn-icon-left">删除</span>
							</span>
						</a>
					</td>
				</tr>
			</table>
		</fieldset>
		<table id="data" class="easyui-datagrid" striped="true" checkbox="true" singleSelect="true" pageSize="${pageModel.pageSize }" pageNumber="${pageModel.page }">
			
			<thead>
				<tr>
					<th field="id" width="150" checkbox="true"  align="center"></th>
					<th field="yearCode" width="250"  align="center">实际年度</th>
					<th field="yearName" width="200" align="center">显示年度</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${pageModel.result }" var="y">
				<tr>
				    <td height="30" align="center" nowrap>${y.id}</td>
					<td height="30" align="center" nowrap>${y.yearCode }</td>
					<td height="30" align="center" nowrap>${y.yearName }</td>
				</tr>
				</c:forEach>
						
			</tbody>
		</table>
		<div id="addDialog"></div>
	</div>
<script type="text/javascript">
	var winHeight = $(window).height();
	var queryBlockHeight = $("#queryBlock").height()

	$(document).ready(function(){
		$("#data").datagrid({
			height:winHeight -queryBlockHeight-45,
			pagination: true,
	        rownumbers: true,
	        fitColumns: false,
	        //fit: true,
	        pageList: [10,20,30],
	        pagePosition: "top"
	});
	
	var pagger = $('#data').datagrid('getPager');  
	$(pagger).pagination({
		total: $("#pageTotal").val(),
		pageNumber: parseInt($("#page").val()),
		showPageList: true,
		showRefresh: false,
	    onSelectPage: function(pageNumber, pageSize){
	    	$('#page').val(pageNumber);
	    	$('#pageSize').val(pageSize);
	    	onSubmit();
	    }
	});
});

function addYear(){
	   
		$('#addDialog').dialog({
	    title: '添加年度',
	    width: 500,
	    height: 260,
	    closed: false,
	    cache: false,
	    href: '${pageContext.request.contextPath}/year/add',
	    modal: true
	});
}

function deleteYear(){
	
	var rows = $('#data').datagrid('getSelections');
	var length = rows.length;
	if(rows.length == 0){
		$.messager.alert('警告','至少选择一个年度。','warning');
		return false;
	}
	var id=rows[0].id;
	alert(JSON.stringify({id:id}));
	
	$.messager.confirm("确认", "您确认删除选定的记录吗？", function (deleteAction) {
		if (deleteAction) {
			showLoading();
			Public.ajaxPost('${pageContext.request.contextPath}/year/delete', JSON.stringify({id:id}), function(e) {
				hideLoading();
				if (200 == e.status) {
					$.messager.alert('提示','操作成功。','info');
					onSubmit();
				} else
					$.messager.alert('错误',e.msg,'error');
			});
		}
	});
}
	
function onSubmit(){
	showLoading();
	$('#yearForm').submit();
}
</script>
</body>
</html>