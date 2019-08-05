<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/tags/simple" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<form id="inputForm" name="inputForm" method="get" action="${pageContext.request.contextPath}/specLandReg/editInput">
				<input type='hidden' id="pageTotal" name="pageTotal" value="${pageModel.totalCount }" />
				<input type="hidden" id="page" name="page" value="${pageModel.page }">
				<input type="hidden" id="pageSize" name="pageSize" value="${pageModel.pageSize }">
			
				<table class="table_common_style">
					<tr>
						<td class="table_common_td_label_query_style">年度：</td>
						<td class="table_common_td_txt_query_style">
							

		<s:select id="year" name="year" entityName="yearCode"  value="${pageModel.data.year}" hasPleaseSelectOption="true"></s:select>

	

		 <script type="text/javascript">

			 $(document).ready(function(){ 

				 $('#year').combobox({ 

					 onChange:function(newValue,oldValue){

						 return false;

					 } 

				 });


			 });

		</script>
 
						</td>
						<td class="table_common_td_label_query_style">企业：</td>
						<td colspan="3" class="table_common_td_txt_query_style">
							


	

		<s:select id="companyCode" name="companyCode" entityName="company" value="${pageModel.data.companyCode }" hasPleaseSelectOption="true"></s:select>

		 <script type="text/javascript">

			 $(document).ready(function(){ 

				 $('#companyCode_companyName').val($('#companyCode option:selected').text());

				 $('#companyCode').combobox({ 

					 onChange:function(newValue,oldValue){

						 var ops = document.getElementById('companyCode').options;

						 for(var i=0;i<ops.length;i++){ 

							 if(ops[i].value == newValue){ 

								 $('#companyCode_companyName').val(ops[i].text); 

								 break; 

							 } 

						 } 

						 return false;; 

					 } 

				 });


				 $('#companyCode').combobox('textbox').bind('focus',function(){
					 var value = $('#companyCode').combobox('getValue');
					 var opts = $('#companyCode').combobox('getData');
						 if(value != ''){
							 var findFlag = false;
							 for(var i=0; i<opts.length; i++){
								 if(opts[i].value == value){
									 findFlag = true;
									 break;
								 }
							 }
							 if(!findFlag){
								 value = '';
								 $('#companyCode').combobox('setValue', '');
							 }
						 }
					 if(value == ''){
						 $('#companyCode').combobox('setText','');
					 }
				 }); 
				 $('#companyCode').combobox('textbox').bind('blur',function(){  
					 var value = $('#companyCode').combobox('getValue');
					 if(value == ''){
						 $('#companyCode').combobox('setText','-=请选择=-');
					 }
				 });
			 });

		</script>



						</td>
					</tr>
					<tr>
						<td class="table_common_td_label_query_style">申请日期：</td>
						<td class="table_common_td_txt_query_style editableFalse">
							<input class="easyui-datebox" id="beginDate" name="beginDate" value=""
	            				data-options="required:false,showSeconds:false" style="width:100px" editable="false"/>
							~
							<input class="easyui-datebox" id="endDate" name="endDate" value=""
	            				data-options="required:false,showSeconds:false" style="width:100px" editable="false"/>
						</td>
						<td class="table_common_td_label_query_style">状态：</td>
						</td>
						<td class="table_common_td_txt_query_style">
							

		<select id="status" name="status" class="easyui-combobox" style="width:187px;height:25px" data-options="editable:true">
<option value="${pageModel.data.status}" selected>-=请选择=-</option>
			<option value="01">待申请</option>

			<option value="02">待审核</option>

			<option value="03">已审核</option>

			<option value="04">已驳回</option>
<%-- <c:if test="value=='01'">
			<option value="01">待申请</option>
            </c:if>
            <c:if test="value=='02'">
			<option value="02">待审核</option>
            </c:if>
            <c:if test="value=='03'">
			<option value="03">已审核</option>
			</c:if>
            <c:if test="value=='04'">
			<option value="04">已驳回</option>
            </c:if>
            <c:if test="value!='01' and value!='02' and value!='03' and value!='04' ">
           
           <option value="01">待申请</option>
           <option value="02">待审核</option>
           <option value="03">已审核</option>
		   <option value="04">已驳回</option>
            </c:if> --%>
		</select>

		 <script type="text/javascript">

			 $(document).ready(function(){ 

				 $('#status').combobox({ 

					 onChange:function(newValue,oldValue){

						 return false;

					 } 

				 });


			 });
       
		</script>
<BR>
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
		<fieldset id="toolBlock" class="fieldset_common_style">
			<table>	
				<tr>
					<td>
						<a href="#" class="easyui-linkbutton" onclick="view();">
							<span class="l-btn-left">
								<span class="l-btn-text icon-view l-btn-icon-left">查看</span>
							</span>
						</a>
						<a href="#" class="easyui-linkbutton" onclick="add();">
							<span class="l-btn-left">
								<span class="l-btn-text icon-add l-btn-icon-left">添加</span>
							</span>
						</a>
						<a href="#" class="easyui-linkbutton" onclick="edit();">
							<span class="l-btn-left">
								<span class="l-btn-text icon-edit l-btn-icon-left">修改</span>
							</span>
						</a>
						<a href="#" class="easyui-linkbutton" onclick="deleteRecord();">
							<span class="l-btn-left">
								<span class="l-btn-text icon-remove l-btn-icon-left">删除</span>
							</span>
						</a>
						<a href="#" class="easyui-linkbutton" onclick="submitAudit();">
							<span class="l-btn-left">
								<span class="l-btn-text icon-ok l-btn-icon-left">提交申请</span>
							</span>
						</a>
					</td>
				</tr>
			</table>
		</fieldset>
		<table id="data" class="easyui-datagrid" striped="true" singleSelect="false" pageSize="${pageModel.pageSize }" pageNumber="${pageModel.page }">
			<thead>
				<tr>
					<th field="id" width="140" align="center" checkbox="true"></th>
					<th field="applyBatchNo" width="140" align="center">申请批次号</th>
					<th field="year" width="70" align="center">年度</th>
					<th field="companyName" width="218" align="center">企业</th>
					<th field="operatorDate" width="115" align="center">申请日期</th>
					<th field="operatorName" width="100" align="center">申请人</th>
					<th field="archiveAcreage" width="125" align="center">本次备案总面积（亩）</th>
					<th field="status" width="120" align="center">状态</th>
					<th field="reason" width="120" align="center">驳回原因</th>
					<th field="auditor" width="80" align="center">审核人</th>
					<th field="auditTime" width="130" align="center">审核时间</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageModel.result }" var="y">
				<tr>
				    <td height="30" align="center" nowrap>${y.id}</td>
				    <td height="30" align="center" nowrap>${y.applyBatchNo}</td>
					<td height="30" align="center" nowrap>${y.year }</td>
					<td height="30" align="center" nowrap>${y.companyName }</td>
					<td height="30" align="center" nowrap>${y.operatorDate }</td>
					<td height="30" align="center" nowrap>${y.operatorName }</td>
					<td height="30" align="center" nowrap>${y.archiveAcreage }</td>
					<td height="30" align="center" nowrap>${y.status }</td>
					<td height="30" align="center" nowrap>${y.reason }</td>
					<td height="30" align="center" nowrap>${y.auditor }</td>
					<td height="30" align="center" nowrap>${y.auditTime }</td>
					<td height="30" align="center" nowrap>${y.auditTime }</td>
				</tr>
				</c:forEach>	
				<tr>
				    <td height="30" align="center" nowrap></td>
				    <td height="30" align="center" nowrap></td>
					<td height="30" align="center" nowrap></td>
					<td height="30" align="center" nowrap></td>
					<td height="30" align="center" nowrap></td>
					<td height="30" align="center" nowrap>合计：</td>
					<td height="30" align="center" nowrap>${sum}</td>
				</tr>		
			</tbody>
		</table>
	</div>
	<div id="addDialog"></div>
	<div id="flowDialog"></div>
<script type="text/javascript">
$(document).ready(function(){
	var winHeight = $(window).height();
    var queryBlockHeight = $("#queryBlock").height();
    var toolBlock = $("#toolBlock").height();
	$("#data").datagrid({ 
		onLoadSuccess:function(data){
			$(".datagrid-cell-check")[data.rows.length-1].innerHTML = "";
	    },
	    onSelectAll:function(rows){
	    	 $('#data').datagrid('unselectRow',rows.length-1);
	    },
	    onSelect:function(index,row){
	    	var rows  = $('#data').datagrid("getRows");
	    	if(index == rows.length-1){
	    		$('#data').datagrid('unselectRow', index);
	    	}
	    },
		height:winHeight -queryBlockHeight -toolBlock-50,
		pagination: true,
        rownumbers: true,
        fitColumns: false,
        checkOnSelect:false,
        //fit: true,
        pageList: [15,20,25],
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

function deleteRecord(id){
	var rows = $('#data').datagrid('getSelections');
	var length = rows.length;
	if(length < 1){
		$.messager.alert('警告','请至少选择一条记录！','warning');
		return false; 
	}
	for(var i=0; i<rows.length; i++) {
		if(rows[i].spstatus=='03'){
			$.messager.alert('警告','您所选择的记录中包含已审核通过的备案土地记录,请重新选择！','warning');
			return false;
		}
		if(rows[i].spstatus=='02'){
			$.messager.alert('警告','您所选择的记录中包含待审核的备案土地记录,请重新选择！','warning');
			return false;
		}
	}

	$.messager.confirm("确认", "您确认删除选定的记录吗？", function (deleteAction) {
	    if (!deleteAction) {
			return false;
	    }
	    var ids = [];
		var rows = $('#data').datagrid('getSelections');
		var length = rows.length;
		for(var i=0; i<rows.length; i++) ids.push(rows[i].id);
		showLoading();
		Public.ajaxGet('delete', {ids : ids}, function(e) {
			hideLoading();
			if (200 == e.status) {
				form_check();
			} else
				$.messager.alert('错误','删除失败！' + e.msg,'error');
		});
	});
}

function edit(id){
	var rows = $('#data').datagrid('getSelections');
	var length = rows.length;
	if(length == 0 ){
		$.messager.alert('警告','请选择一条记录！','warning');
		return false;
	}
	if(length > 1){
		$.messager.alert('警告','只能选择一条记录！','warning');
		return false;
	}
	if(rows[0].spstatus=='02'){
		$.messager.alert('警告','待审核状态的备案土地信息不可被编辑！','warning');
		return false;
	}
	if(rows[0].spstatus=='03'){
		$.messager.alert('警告','已审核通过的备案土地信息不可被编辑！','warning');
		return false;
	}
	var id = rows[0].id;
	var url = "${pageContext.request.contextPath}/specLandReg/editInput?retFlag=1&id=" + id;
	url += getQueryCond();
	document.location.href = url;
}
function add(){
	 var url = "${pageContext.request.contextPath}/specLandReg/specLandRegEdit";
	document.location.href = url; 
	
}

function getQueryCond(){
	var year = $('#year').combobox('getValue');
	var companyCode = $('#companyCode').combobox('getValue');
	var status = $('#status').combobox('getValue');
	var beginDate = $('#beginDate').val();
	var endDate = $('#endDate').val();
	
	var str = "";
	str += "&year=" + year;
	str += "&companyCode=" + companyCode;
	str += "&status=" + status;
	str += "&beginDate=" + beginDate;
	str += "&endDate=" + endDate;
	
	return str;
}

function closeEdiDialog(){
	$('#userEditDlg').dialog('close');
}
//查看
function view(){
	var rows = $('#data').datagrid('getSelections');
	var length = rows.length;
	if(length == 0 ){
		$.messager.alert('警告','请选择一条记录！','warning');
		return false;
	}
	if(length > 1){
		$.messager.alert('警告','只能选择一条记录！','warning');
		return false;
	}
	var id = rows[0].id;
	var year = $('#year').combobox('getValue');
	var companyCode = $('#companyCode').combobox('getValue');
	var status = $('#status').combobox('getValue');
	var beginDate = $('#beginDate').val();
	var endDate = $('#endDate').val();
	
	var url = "${pageContext.request.contextPath}/specLandReg/view?id=" + id + "&gotoPage=1";
	url += "&year=" + year;
	url += "&companyCode=" + companyCode;
	url += "&status=" + status;
	url += "&beginDate=" + beginDate;
	url += "&endDate=" + endDate;
	 
	document.location.href = url;
}

function closeEdiDialog(){
	$('#userEditDlg').dialog('close');
}
//提交申请
function submitAudit(){
	var ids = [];
	var rows = $('#data').datagrid('getSelections');
	var length = rows.length;
	if(length == 0 ){
		$.messager.alert('警告','请选择一条记录！','warning');
		return false;
	}
	if(length > 1){
		$.messager.alert('警告','只能选择一条记录！','warning');
		return false;
	}
	if( rows[0].spstatus != "01" ){
		$.messager.alert('警告','只有待申请的记录允许提交申请，请重新选择！','warning');
		return false;
	}
	
	$.messager.confirm("确认", "您确定要将选中的记录提交申请吗？", function (deleteAction) {
	    if (!deleteAction) {
			return false;
	    }
	    ids.push(rows[0].id);
	    showLoading();
		Public.ajaxGet('submitAudit', {ids : ids}, function(e) {
			hideLoading();
			if (200 == e.status) {
				form_check();
			} else
				$.messager.alert('错误','提交申请失败！' + e.msg,'error');
		});
	});
}

function form_check(){
	var beginDate =$.trim($("#beginDate").datebox('getValue'));
	var endDate =$.trim($("#endDate").datebox('getValue'));
	if(!dateCompare(beginDate,endDate)){
		$.messager.alert('警告','申请日期开始日不能大于结束日！','warning');
		return false;
	}
	showLoading();
	$('#inputForm').submit();
}

/**
 * 点击流水号显示操作日志
 */
function detail( batchNo ){
	$('#flowDialog').dialog({
	    title: '操作记录',
	    width: 600,
	    height: 400,
	    closed: false,
	    cache: false,
	    href: '${pageContext.request.contextPath}/landLog/list' + "?landLogType=SPEC&batchNo=" + batchNo,
	    modal: true
	});
}
</script>
</body>
</html>