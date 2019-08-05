<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/tags/simple" %>
<!DOCTYPE html>
<html style="width:100%;height:100%;overflow:hidden">
<head>
<title>用户管理-五常优质水稻溯源监管平台</title>
<link rel="stylesheet" type="text/css" href="../style/index.css">
<link rel="stylesheet" type="text/css" href="../js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../js/themes/color.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/form2js.js"></script>
<script type="text/javascript" src="../js/json2.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout" >
	<div region="center" border="false" style="padding:5px;">	
		<form id="addForm" class="easyui-form" method="post" data-options="novalidate:true">
			
			<fieldset class="fieldset_common_style">
				<table class="table_common_style">				
				<tr>
		    	<td class="table_common_td_label_style">年度：</td>
	    		<td class="table_common_td_txt_style editableFalse">
		    	<s:select name="year" id="year" entityName="yearCode" value="${pageModel.data.year }"  hasPleaseSelectOption="true"></s:select>
		    		<span class="span_common_mustinput_style">*</span>
	    		</td>
	    		</tr>
	    		<tr>
		    		<td class="table_common_td_label_style">品种：</td>
		    		<td class="table_common_td_txt_style">
		    		<select id="seedCode" name="seedCode" class="easyui-combobox" style="width:187px;height:25px" data-options="editable:false">
						<option value="1">稻花香1号</option>
						<option value="2">稻花香2号</option>
					</select>
					<span class="span_common_mustinput_style">*</span>
		    			</td>
	    		</tr>
	    			<tr>
		    			<td class="table_common_td_label_style">最小亩产量(斤)：</td>
		    			<td class="table_common_td_txt_style">
		    				<input class="easyui-numberbox" precision="1" type="text" name="minYield"  data-options="min:0,max:999999999.99,precision:2,groupSeparator:','" style="width:187px;"></input>
		    				<span class="span_common_mustinput_style">*</span>
		    			</td>
	    			</tr>
	    			<tr>
		    			<td class="table_common_td_label_style">最大亩产量(斤)：</td>
		    			<td class="table_common_td_txt_style">
		    				<input class="easyui-numberbox" precision="1" type="text" name="maxYield"  data-options="min:0,max:999999999.99,precision:2,groupSeparator:','"  style="width:187px;"></input>
		    				<span class="span_common_mustinput_style">*</span>
		    			</td>
	    			</tr>
	    			<tr>
		    			<td class="table_common_td_label_style">出米率：</td>
		    			<td class="table_common_td_txt_style">
		    				<input class="easyui-numberbox" precision="2"  type="text" name="milledriceRate"  data-options="min:0,max:99999.9999,precision:2,groupSeparator:','"  style="width:187px;"></input>
		    				<span class="span_common_mustinput_style">*</span>
		    			</td>
	    			</tr>
	    			<tr height="80">
		    			<td colspan="2" align="center">
		    			<a href="#" class="easyui-linkbutton" onclick="formCheck()" data-options="iconCls:'icon-save'">保存</a>
		    			<a href="#" class="easyui-linkbutton" style="margin-left:15px;" onclick="closeEdiDialog()" data-options="iconCls:'icon-cancel'">取消</a>
		    			</td>
	    			</tr>
				</table>
			</fieldset>
		</form>
	</div> 
<script type="text/javascript"> 
function formCheck(){
	if(!check()) return ;
	save();
}

function save(){
	var a = $('#addForm').toObject();
	alert(a);
	showLoading();
	$.ajax({
		url:"${pageContext.request.contextPath}/graiEval/save",
		type:"post",
		data:a,
		success:function(e){
			hideLoading();
			if (200 == e.status) {
				$.messager.alert('提示','操作成功。','info');
				
				$('#inputForm').submit(); 
			} else {
				parent.parent.Public.tips({
					type : 1,
					content : "失败！" + e.msg
				});
			}
		},
		dataType:"json"
	});
	$.messager.alert('提示','保存成功。','info');
	closeEdiDialog();
		
}

function closeEdiDialog(){
	$('#addDialog').dialog('close');
}

function check(){
	if($("input[name='minYield']").val()==""){
		$.messager.alert('警告','请填写最小亩产量。','warning');
		return false;
	}else if (!isNumber($("input[name='minYield']").val())){
		$.messager.alert('警告','最小亩产量请输入数字。','warning');
		return false;
	}
	if($("input[name='maxYield']").val()==""){
		$.messager.alert('警告','请填写最大亩产量。','warning');
		return false;
	}else if (!isNumber($("input[name='maxYield']").val())){
		$.messager.alert('警告','最大亩产量请输入数字。','warning');
		return false;
	}	

	if(parseFloat($("input[name='minYield']").val())>parseFloat($("input[name='maxYield']").val())){
		$.messager.alert('警告','最小亩产量不能大于最大亩产量。','warning');
		return false;
	}
	return true;
}
</script>
</body>
</html>