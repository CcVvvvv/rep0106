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
<body>
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;人事部管理>>出勤</td>
				<td align="right">
				
				</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<div style="margin-bottom:10px;">
		<s:form action="chuq.action" method="post" theme="simple">
		
			 <td>年份：</td>
				 <s:select label="年份" name="year" list="{'2015','2014','2013','2012','2011','2010','2009','2008'}"
				       multiple="false"/>
			 
		 	<td>月份：</td>
				 <s:select label="月份" name="month" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}"
				       multiple="false"/>
			<s:submit cssClass="buttonBack" value="查询"/><%-- 
			<s:submit cssClass="buttonBack" value="导入"/> --%>
			<!-- <input type="button" cssClass="buttonBack" value="导入" onclick="location='daorusuccess.jsp'" /> -->
			&nbsp;&nbsp;&nbsp;
			<!--  
			<input type="button" value="生成" 
			onclick="location='/EmpManageSys/salary/addAttendences.action'" class="buttonBack"/>
			-->
		</s:form></div>
		<div >
		<%-- 	<s:form action="addAttendences.action" method="post" theme="simple">
			<input id="year2" name="attendence.year"/ style="display: none">&nbsp;&nbsp;
			<input id="month2" name="attendence.month" style="display: none"/>
				<s:submit cssClass="buttonBack" value="生成" onclick="getDate();"/>
			</s:form> --%>
		</div>
<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
			<tr class="table_head">
				<td>序号</td>
				<td>部门</td>
				<td>工号</td>
				<td>姓名</td>
				<td>年份</td>
				<td>月份</td>
				
				<td>缺勤天数</td>
				<td>扣款每次</td>
				<td>应扣</td>
				
				<td>基本操作</td>
			</tr>
		  <c:forEach items="${attendences}" var="attendence" varStatus="i">
			<tr bgcolor="#FFFFFF">
				<td>${i.index+1 } </td>
				<td>${attendence.dept} </td><%-- 
				<td>${attendence.aid}</td> --%>
		 <td>${attendence.aempid}</td>
				<td>${attendence.atruename}</td>
				<td>${attendence.ayear}</td>
				<td>${attendence.amonth}</td>
				
				<td>${attendence.queqinday}</td>
				<td>${attendence.koukuanmeici}</td>
				<td>${attendence.yinkou}</td> 
				
				<td>
					<a href="attendence1!loadatt.action?attendence.aid=${attendence.aid}" >
					<img src="skin/edt.gif"/>修改</a>
					
				</td>
			</tr>  
		  </c:forEach>		
		</table>
	</div>
</div>
</body>
</html>