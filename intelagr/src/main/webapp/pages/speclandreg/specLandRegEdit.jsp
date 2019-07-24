<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/tags/simple" %>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/upload.js"></script>
	<script>
		var root = "${pageContext.request.contextPath}";
	</script>

</head>
<body class="easyui-layout">
	<div region="center" border="false" style="padding:5px;">
		<form id="editForm" name="editForm" method="post" action="../specLandReg/list">
			<fieldset class="fieldset_common_style">
				<input type="hidden" name="id" id="id" value=""/>
				<input type="hidden" name="status" id="statusEdit" value="01"/>
				<input type="hidden" name="detailId" id="detailId" value=""/>
				<table>
					<tr>
						<td>
							
							
								<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="return save();">
									保存
								</a>
								<a href="#" class="easyui-linkbutton" onclick="return submitAudit();">
									<span class="l-btn-left">
										<span class="l-btn-text icon-ok l-btn-icon-left">提交申请</span></span>
								</a>
							
							
								<a href="#" class="easyui-linkbutton"  onclick="return retList();">
									<span class="l-btn-left">
									<span class="l-btn-text icon-cancel l-btn-icon-left">返回</span></span>
								</a>
							
						</td>
					</tr>
				</table>	
			</fieldset>
			<fieldset class="fieldset_common_style">
				<table class="table_common_style">
					<tr>
						<td class="table_common_td_label_style">申请批次号：</td>
						<td class="table_common_td_txt_style">
							<input type="hidden" name="applyBatchNo" value="${result }">
							${result }
						</td>
					</tr>
					<tr> 
						<td class="table_common_td_label_style">年度：</td>
						<td class="table_common_td_txt_style editableFalse">
							
<%-- 
 		<select id="year" name="year" class="easyui-combobox" style="width:187px;height:25px" data-options="editable:false">
			<option value="" selected>-=请选择=-</option>
			<c:forEach items="${yearList }" var="y">
			<option value="${y.yearCode }">${y.yearName }</option>
			</c:forEach>
		</select>   --%>
 <s:select name="year" id="year" entityName="yearcode"  hasPleaseSelectOption="true"></s:select>  
		 <script type="text/javascript">

			 $(document).ready(function(){ 

				 $('#year').combobox({ 

					 onChange:function(newValue,oldValue){

						 return false;

					 } 

				 });


			 });

		</script>

							<span class="span_common_mustinput_style">*</span>
						</td>
						<td class="table_common_td_label_style">企业：</td>
						<td class="table_common_td_txt_style editableFalse">
							

<%--   		<select id="companyCode1" name="companyCode" class="easyui-combobox" style="width:187px;height:25px" data-options="editable:true">
			<option value="" selected>-=请选择=-</option>
			<c:forEach items="${companyList }" var="cmp">
			<option value="${cmp.companyCode }">${cmp.companyName }</option>
			</c:forEach>
		</select> --%>   
 <s:select name="companyCode" id="companyCode1" entityName="company" codeKey="" hasPleaseSelectOption="true"></s:select>

		 <input type="hidden" id="companyCode1_companyName" name="companyName" value="">

		 <script type="text/javascript">

			 $(document).ready(function(){ 

				 $('#companyCode1_companyName').val($('#companyCode1 option:selected').text());

				 $('#companyCode1').combobox({ 

					 onChange:function(newValue,oldValue){

						 var ops = document.getElementById('companyCode1').options;

						 for(var i=0;i<ops.length;i++){ 

							 if(ops[i].value == newValue){ 

								 $('#companyCode1_companyName').val(ops[i].text); 

								 break; 

							 } 

						 } 

						 return false;; 

					 } 

				 });


				 $('#companyCode1').combobox('textbox').bind('focus',function(){
					 var value = $('#companyCode1').combobox('getValue');
					 var opts = $('#companyCode1').combobox('getData');
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
								 $('#companyCode1').combobox('setValue', '');
							 }
						 }
					 if(value == ''){
						 $('#companyCode1').combobox('setText','');
					 }
				 }); 
				 $('#companyCode1').combobox('textbox').bind('blur',function(){  
					 var value = $('#companyCode1').combobox('getValue');
					 if(value == ''){
						 $('#companyCode1').combobox('setText','-=请选择=-');
					 }
				 });
			 });

		</script>

							
							<span class="span_common_mustinput_style">*</span>
						</td>
					</tr>
					<tr>
						<td class="table_common_td_label_style">承包方类型：</td>
						<td class="table_common_td_txt_style editableFalse">
							


<%--  		<select id="contractorType" name="contractorType" class="easyui-combobox" style="width:187px;height:25px" data-options="editable:false">
			<c:forEach items="${contracList }" var="contrac">
			<option value="${contrac.codeCode }" selected>${contrac.codeValue }</option>
			</c:forEach>
			<option value="" selected>-=请选择=-</option>
		</select>  --%>
 <s:select name="contractorType" id="contractorType" entityName="commondata" value="${pageModel.data.ContractorType }" codeKey="ContractorType" hasPleaseSelectOption="true"></s:select>		 
		 <script type="text/javascript">

			 $(document).ready(function(){ 

				 $('#contractorType').combobox({ 

					 onChange:function(newValue,oldValue){

						 return false;

					 } 

				 });


			 });

		</script>

							<span class="span_common_mustinput_style">*</span>
						</td>
						<td class="table_common_td_label_style">证件类型：</td>
						<td class="table_common_td_txt_style editableFalse">
							
<%--  		<select id="idType" name="idType" class="easyui-combobox" style="width:187px;height:25px" data-options="editable:false">
			<c:forEach items="${idTypeList }" var="idType">
			<option value="${idType.codeCode }" selected>${idType.codeValue }</option>
			</c:forEach>
			<option value="" selected>-=请选择=-</option>
		</select>  --%>
 <s:select name="idType" id="idType" entityName="commondata" value="${pageModel.data.IDType }" codeKey="IDType" hasPleaseSelectOption="true"></s:select>	 

		 <script type="text/javascript">

			 $(document).ready(function(){ 

				 $('#idType').combobox({ 

					 onChange:function(newValue,oldValue){

						 return false;

					 } 

				 });


			 });

		</script>

							<span class="span_common_mustinput_style">*</span>
						</td>
					</tr>
					<tr>
						<td class="table_common_td_label_style">承包方：</td>
						<td class="table_common_td_txt_style">
							<input class="easyui-textbox" type="text" name="contractorName" value="" style="width:188px;" maxlength="10"></input>
							<span class="span_common_mustinput_style">*</span>
						</td>
						<td class="table_common_td_label_style">证件号码：</td>
						<td class="table_common_td_txt_style">
							<input class="easyui-textbox" type="text" name="contractorID" value="" style="width:188px;"></input>
							<span class="span_common_mustinput_style">*</span>
						</td>
					</tr>
					<tr>
						<td class="table_common_td_label_style">住址：</td>
						<td colspan="3" class="table_common_td_txt_style editableFalse">
							
<span >
<select id='cityCode' name='cityCode' class='easyui-combobox' style='width:140px;height:25px' data-options='editable:false'>
		<option value=''>==请选择==</option>
		<option value='230184'>五常市</option>
</select> 
</span>
<span id='townSpan'><select id='townCode' name='townCode' class='easyui-combobox' style='width:150px;height:25px' data-options='editable:false,required:true'>
	<option value=''  selected>-=请选择=-</option></select></span>
<span id='countrySpan'><select id='countryCode' name='countryCode' class='easyui-combobox' style='width:140px;height:25px' data-options='editable:false'></select></span>
<span id='groupSpan'><input class='easyui-textbox' type='text' id='groupName' name='groupName'  value='' style='width:260px;height:25px'></select></span>
<script>
$(document).ready(function(){
	  $('#cityCode').combobox({  
		valueField:'townCode',
		textField:'townName',
		onChange : function(){
			var cityCode = $('#cityCode').combobox('getValue');
			$.ajax({ 
				url:"${pageContext.request.contextPath}/specLandReg/townCode",
				type:"post",
				data:{"cityCode":cityCode},
				success:function(e){
					if (200 == e.status) {
						$('#townCode').combobox({valueField:'townCode',textField:'townName'});
						$('#townCode').combobox('loadData', JSON.parse(JSON.stringify(e.data)));
					} else {
						parent.parent.Public.tips({
							type : 1,
							content : '失败！' + e.msg
						});
					}
				},
					dataType:"json"
				});
		}
	}); 
    $('#townCode').combobox({
        valueField:'countryCode',
        textField:'countryName',
        onChange: function(){
			var cityCode = $('#cityCode').combobox('getValue');
			var townCode = $('#townCode').combobox('getValue');
			$.ajax({ 
				url:"${pageContext.request.contextPath}/specLandReg/countryCode",
				type:"post",
				data:{"townCode":townCode},
				success:function(e){
					if (200 == e.status) {
						$('#countryCode').combobox({valueField:'countryCode',textField:'countryName'});
						$('#countryCode').combobox('loadData', JSON.parse(JSON.stringify(e.data)));
					} else {
						parent.parent.Public.tips({
							type : 1,
							content : '失败！' + e.msg
						});
					}
				},
					dataType:"json"
				});
        }
    }); 
});
</script>

							<span class="span_common_mustinput_style">*</span>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="fieldset_common_style">
				<table class="table_common_style">
					<tr>
						<td class="table_common_td_label_style">土地类型：</td>
						<td class="table_common_td_txt_style editableFalse">

<%--  		<select id="landType" name="landType" class="easyui-combobox" style="width:100pxpx;height:25px" data-options="editable:false">
			<c:forEach items="${plowlandTypeList }" var="plowlandType">
			<option value="${plowlandType.codeCode }" selected>${plowlandType.codeValue }</option>
			</c:forEach>
			<option value="" selected>-=请选择=-</option>
		</select>   --%>
 <s:select name="landType" id="landType" entityName="commondata" value="${pageModel.data.PlowlandType }" codeKey="PlowlandType" hasPleaseSelectOption="true"></s:select>

		 <script type="text/javascript">

			 $(document).ready(function(){ 

				 $('#landType').combobox({ 

					 onChange:function(newValue,oldValue){

						 return false;

					 } 

				 });


			 });

		</script>
	
							<span class="span_common_mustinput_style">*</span>	
						</td>
						<td class="table_common_td_label_style">测量（亩）：</td>
						<td class="table_common_td_txt_style">
							<input  class="easyui-numberbox" precision="2" min="0.00" max="9999999.99"  name="actualMu" value="" style="width:120px;"></input>
							<span class="span_common_mustinput_style">*</span>
						</td>
						<td class="table_common_td_label_style">土地类别：</td>
						<td class="table_common_td_txt_style editableFalse">
							


<%--  		<select id="landClass" name="landClass" class="easyui-combobox" style="width:110px;height:25px" data-options="editable:false">
			<c:forEach items="${plowlandClassList }" var="plowlandClass">
			<option value="${plowlandClass.codeCode }" selected>${plowlandClass.codeValue }</option>
			</c:forEach>
			<option value="" selected>-=请选择=-</option>

		</select>  --%> 
 <s:select name="landClass" id="landClass" entityName="commondata"  codeKey="PlowlandClass" hasPleaseSelectOption="true"></s:select>	
		 <script type="text/javascript">

			 $(document).ready(function(){ 

				 $('#landClass').combobox({ 

					 onChange:function(newValue,oldValue){

						 return false;

					 } 

				 });


			 });

		</script>

							<span class="span_common_mustinput_style">*</span>
						</td>
					</tr>
					<tr>
						<td class="table_common_td_label_style">地块位置：</td>
					<td colspan="5" class="table_common_td_txt_style editableFalse">
							
<span>
<select id='cityCodeDetail' name='cityCodeDetail' class='easyui-combobox' style='width:146px;height:25px' data-options='editable:false'>
		<option value='' selected>-=请选择=-</option>
		<option value='230184'>五常市</option>
</select> 
</span>
<span id='townSpan'><select id='townCodeDetail' name='townCodeDetail' class='easyui-combobox' style='width:150px;height:25px' data-options='editable:false,required:true'>	<option value=''  selected>-=请选择=-</option></select></span>
<span id='countrySpan'><select id='countryCodeDetail' name='countryCodeDetail' class='easyui-combobox' style='width:146px;height:25px' data-options='editable:false'></select></span>
<span id='groupSpan'><input class='easyui-textbox' type='text' id='groupNameDetail' name='groupNameDetail'  value='' style='width:265px;height:25px'></select></span>
<script>
$(document).ready(function(){
	$('#cityCodeDetail').combobox({
		valueField:'townCode',
		textField:'townName',
		onChange : function(){
			var cityCode = $('#cityCodeDetail').combobox('getValue');
			$.ajax({ 
				url:"${pageContext.request.contextPath}/specLandReg/townCode",
				type:"post",
				data:{"cityCode":cityCode},
				success:function(e){
					if (200 == e.status) {
						$('#townCodeDetail').combobox({valueField:'townCode',textField:'townName'});
						$('#townCodeDetail').combobox('loadData', JSON.parse(JSON.stringify(e.data)));
					} else {
						parent.parent.Public.tips({
							type : 1,
							content : '失败！' + e.msg
						});
					}
				},
					dataType:"json"
				});
		}
	});
    $('#townCodeDetail').combobox({
    	valueField:'countryCode',
        textField:'countryName',
        onChange: function(){
			var cityCode = $('#cityCodeDetail').combobox('getValue');
			var townCode = $('#townCodeDetail').combobox('getValue');
			$.ajax({ 
				url:"${pageContext.request.contextPath}/specLandReg/countryCode",
				type:"post",
				data:{"townCode":townCode},
				success:function(e){
					if (200 == e.status) {
						$('#countryCodeDetail').combobox({valueField:'countryCode',textField:'countryName'});
						$('#countryCodeDetail').combobox('loadData', JSON.parse(JSON.stringify(e.data)));
					} else {
						parent.parent.Public.tips({
							type : 1,
							content : '失败！' + e.msg
						});
					}
				},
					dataType:"json"
				});
        }
    });
});
</script>

							<span class="span_common_mustinput_style">*</span>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="fieldset_common_style">
				<table class="table_common_style">
					
					<tr>
						<td class="table_common_td_label_style">本次备案面积（亩）：</td>
						<td class="table_common_td_txt_style">
							<input  class="easyui-numberbox" precision="2" min="0.00" max="9999999.99" type="text" name="archiveAcreage" value="" style="width:100px;"></input>
							<span class="span_common_mustinput_style">*</span>
						</td>
						<td class="table_common_td_label_style">经办人：</td>
						<td class="table_common_td_txt_style">
							<input class="easyui-textbox" type="text" name="operatorName" value="" style="width:100px;"></input>
							<span class="span_common_mustinput_style">*</span>
						</td>
						<td class="table_common_td_label_style">经办日期：</td>
						<td class="table_common_td_txt_style editableFalse">
							<input class="easyui-datebox" name="operatorDate1" id="operatorDate" value="Sun May 21 00:00:00 CST 2017"
       data-options="required:true,showSeconds:false" style="width:100px" editable="false" >
							<span class="span_common_mustinput_style">*</span>
						</td>
					</tr>
					<tr>
						<td class="table_common_td_label_comment_style">情况说明：</td>
						<td colspan="5" class="table_common_td_txt_style">
							<textarea class="easyui-textbox" rows="3" id="description" name="description" cols="60" style="width:500px;height:100px" data-options="multiline:true"></textarea>
							<span class="span_common_mustinput_style">*</span>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="fieldset_common_style">
				<legend>举证资料列表</legend>
				<table class="table_common_style">
					<tr>
						<td>
							<a href="#" class="easyui-linkbutton" onclick="javascript:showUploadDialog('04', '', '举证资料', 'imgPriviewOuter', 'imgPriviewInner');">
								<span class="l-btn-left"><span class="l-btn-text icon-docupload l-btn-icon-left">上传举证凭证</span></span>
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<table id="imgList" height="152px" class="easyui-datagrid" striped="true" singleSelect="true">
								<thead>
									<tr>
										<th field="originalName" width="50%" align="center">举证凭证</td>
										<th field="fileInfo" width="30%" align="center">说明</td>
										<th field="op" width="20%" align="center">操作</td>
									</tr>
								</thead>
							</table>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="fieldset_common_style">
				<legend>举证资料预览</legend>
				<table id="fileDiv" class="table_common_style">
					<tr>
						<td>
							

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/jquery.scrollpic.css">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/jquery.fancybox.css" media="screen" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/jquery.fancybox-buttons.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ScrollPic.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.fancybox.js"></script>	

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.fancybox-buttons.js"></script>

<script type="text/javascript">

	$(function(){

	$('.yiz-slider-3').ScrollPic({

		Time: 0,

		speed: 500,

		autoscrooll: false,

		arrowcontrol: true,

		numbercontrol: false

	});

})

$(document).ready(function() {

$('.fancybox-buttons').fancybox({

	openEffect  : 'none',

	closeEffect : 'none',

	prevEffect : 'none',

	nextEffect : 'none',

	closeBtn  : true,

	helpers : {

		title : {

			type : 'inside'

		},

		buttons	: {}

	},

	afterLoad : function() {

		this.title = 'Image ' + (this.index + 1) + ' of ' + this.group.length + (this.title ? ' - ' + this.title : '');

	}

});

});

</script>

<style>
.t1 a:link, .t1 a:visited{}t1 a:hover{}
</style>

<div id='imgPriviewOuter'><div class="yiz-slider-3 yiz-slider" id="imgPriviewInner" data-yiz-slider="3" style="width:420px;height:500px">

 <ul>

<li><img src="${pageContext.request.contextPath}/images/nothing.png" alt="There is nothing to View." /></li>

</ul>

</div></div>

						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	<div id="bhDialog"></div>
	<div id="uploadDialog"></div>
	
<script type="text/javascript">
	$(document).ready(function(){
		var id = $("#id").val();
		if(id != ""){
			showFileList("04", id, '举证资料', 'imgPriviewOuter', 'imgPriviewInner' );
		}
	});
	
	//动态调整预览图片位置
	var width = $("#fileDiv").width();
	var picWidth = $("#imgPriviewInner").width();
	var paddingLeft = (width - picWidth)/2 + "px";
	$("#fileDiv").css("padding-left", paddingLeft);

	function closeEditDialog(){
		$('#addDialog').dialog('close');
	}

	function save(){
		if(!check()) return ;
		var retFlag = '1';
		var a = $('#editForm').toObject();

		showLoading();
		$.ajax({
			url:"${pageContext.request.contextPath}/specLandReg/save",
			type:"post",
			data:a,
			success:function(e){
				hideLoading();
				if (200 == e.status) {
					$.messager.alert('提示','操作成功。','info',function(){
						if(retFlag == '1'){
							//location.href = "${pageContext.request.contextPath}/specLandReg/list";
							retList();
						}else if("edit" == "audit"){
						    location.href = '${pageContext.request.contextPath}/specLandReg/listquery?year=&companyCode=&beginDate=&endDate=&status=&page=&pageSize=';
						} else {
						    location.href = '${pageContext.request.contextPath}/specLandReg/editInput';
						}
					});
				} else {
					$.messager.alert('错误','保存失败！' + e.msg,'error');
				}
			},
			dataType:"json"
		}); 
	}
	
	function closeEdiDialog(){
		$('#addDialog').dialog('close');
	}
	
	function fileUpload(){
		$('#addDialog').dialog({
		    title: '文件上传',
		    width: 550,
		    height: 400,
		    closed: false,
		    cache: false,
		    href: '../file/uploadInit?bizType=specLandReg',
		    modal: true
		});
	}

function auditOpt( status ){
	if( status == "0" ){   //通过,改变状态
		$("#statusEdit").val( "03" );
		save();
	}else if( status == -1 ){  //驳回,弹窗
		var id = $("#id").val();
		$('#bhDialog').dialog({
		    title: '驳回',
		    width: 400,
		    height: 300,
		    closed: false,
		    cache: false,
		    href: '${pageContext.request.contextPath}/specLandReg/auditBhInput?id='+id,
		    modal: true
		});
	}
}

//提交申请,只改变状态
function submitAudit(){
	$("#statusEdit").val( "02" );
	save();
	location.href = "${pageContext.request.contextPath}/specLandReg/editInput";
}

function retList(){
	location.href = "${pageContext.request.contextPath}/specLandReg/editInput"
	/* var url = "${pageContext.request.contextPath}/specLandReg/list";
	url += "?year=";
	url += "&page=";
	url += "&pageSize=";
	url += "&companyCode=";
	url += "&beginDate=";
	url += "&endDate=";
	url += "&status=";
	
	document.location.href = url; */
}
function check(){
	if($("#companyCode1").combobox('getValue')==""){
		$.messager.alert('警告','请选择企业！','warning');
		return false;
	}
	if($("#contractorType").combobox('getValue')==""){
		$.messager.alert('警告','请选择承包方类型！','warning');
		return false;
	}
	if($("#idType").combobox('getValue')==""){
		$.messager.alert('警告','请选择证件类型！','warning');
		return false;
	}
	if($("input[name='contractorName']").val()==""){
		$.messager.alert('警告','请填写承包方！','warning');
		return false;
	}
	if($("input[name='contractorID']").val()==""){
		$.messager.alert('警告','请填写承包人证件号码！','warning');
		return false;
	}
	if($("#idType").combobox('getValue')=="01" && $("input[name='contractorID']").val()!=""){
		var strError = checkIdNumber($("input[name='contractorID']").val());
		if(strError.length>1){
			$.messager.alert('警告',strError,'warning');
			return false;
		}
	}
	if(($("input[name='contractorID']").val()+"").length>18){
		$.messager.alert('警告','您输入的证件号码长度超出系统限制！','warning');
		return false;
	}
	if($("#countryCode").combobox('getValue')==""||$("#townCode").combobox('getValue')==""||$("#groupName").val()==""){
		$.messager.alert('警告','请填写住址！','warning');
		return false;
	}
	if($("#landType").combobox('getValue')==""){
		$.messager.alert('警告','请选择土地类型！','warning');
		return false;
	}
	if($("input[name='actualMu']").val()==""){
		$.messager.alert('警告','请填写测量亩！','warning');
		return false;
	}else if (!isNumber($("input[name='actualMu']").val())){
		$.messager.alert('警告','测量亩请输入数字！','warning');
		return false;
	}
	if(($("input[name='actualMu']").val()+"").length>14){
		$.messager.alert('警告','您输入的测量亩数字长度超出系统限制！','warning');
		return false;
	}
	if($("#landClass").combobox('getValue')==""){
		$.messager.alert('警告','请选择土地类别！','warning');
		return false;
	}	
	if($("#countryCodeDetail").combobox('getValue')==""||$("#townCodeDetail").combobox('getValue')==""||$("#groupNameDetail").val()==""){
		$.messager.alert('警告','请选择地块位置！','warning');
		return false;
	}
	if($("input[name='archiveAcreage']").val()==""){
		$.messager.alert('警告','请填写本次备案面积！','warning');
		return false;
	}else if (!isNumber($("input[name='archiveAcreage']").val())){
		$.messager.alert('警告','本次备案面积请输入数字！','warning');
		return false;
	}
	if(($("input[name='archiveAcreage']").val()+"").length>14){
		$.messager.alert('警告','您输入的本次备案面积数字长度超出系统限制！','warning');
		return false;
	}
	if($("input[name='operatorName']").val()==""){
		$.messager.alert('警告','请填写经办人！','warning');
		return false;
	}
	if(($("input[name='operatorName']").val()+"").length>10){
		$.messager.alert('警告','您输入的经办人名称长度超出系统限制！','warning');
		return false;
	}
	if($("#description").val()==""){
		$.messager.alert('警告','请输入本次备案的情况说明！','warning');
		return false;
	}
	return true;
}

function showVideoList(o, d){}
function closeDialog(){
	$("#addDialog").dialog('close');
}
</script>
</body>
</html>