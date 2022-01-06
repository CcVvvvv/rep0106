<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/table.css" type="text/css"></link>
<link rel="stylesheet" href="css/main.css" type="text/css"></link>


<style type="text/css">
	a:hover{ text-decoration:underline; color:#075B92;}
	.body{
		text-align:center;
	}
	.buttonBack{
		background: url(skin/83.gif);
		width:67px;
		height:22px;
		border:0px;
		cursor: pointer;
	}
	.input{
		border:1px solid gray;
		height:22px;
	}
</style>
<script language="javascript" type="text/javascript" 
src="${pageContext.request.contextPath}/user/js/jquery-1.4.3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//获取年度下拉框值
        var date = new Date(); 
        var year = date.getFullYear() - 2;
        for(var i = 0;i < 5 ; i++){
           if(year + i == date.getFullYear()){
             var option= $("<option></option>").val(year+i).text(year+i).attr("selected",true).appendTo($("#year"));
           }else{
             $("<option></option>").val(year+i).text(year+i).appendTo($("#year"));
           }
       	}
    });
    
   function getDate(){	
	var year=document.getElementById("year").value;	
	var year2=document.getElementById("year2");	
	year2.value=year;	
	var month=document.getElementById("month").value;	
	var month2=document.getElementById("month2");	
	month2.value=month;	
}
</script>
</head>
<body style="font-size:30px;font-style:italic;">
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;系统管理员>>部门信息</td>
				
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
	
		<div style="margin-top:10px;"  >
		<a href="addDept.jsp">	<img src="skin/22.gif"/>&nbsp;&nbsp;新增</a>
	
		</div>
<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
			<tr class="table_head">
				<td>序号</td>
				<td>名称</td>
				<td>部门简介</td>
				<td>部门主任</td>
				<td>部门电话</td>		
				<td>基本操作</td>
			</tr>
		  <c:forEach items="${depts}" var="dept" varStatus="i">
			<tr bgcolor="#FFFFFF">
				<td>${i.index+1 } </td>
			
				<td>${dept.name}</td>
				<td>${dept.remark}</td>
				<td>${dept.manager}</td>
				<td>${dept.tel}</td>
			
				<td>
					<a href="dept!load.action?dept.id=${dept.id}" >
					<img src="skin/edt.gif"/>修改</a>
					<a href="dept!delete.action?dept.id=${dept.id}">
					<img src="skin/del.gif"/>删除</a>
				</td>
			</tr>  
		  </c:forEach>		
		</table>
	</div>
</div>
</body>
</html>