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
				<td class="td_top"><b>当前位置:</b>&nbsp;学校各部门>>业绩考核</td>
				<td align="right">
				
				</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<div style="margin-bottom:10px;">
		<s:form action="yejikaohe.action" method="post" theme="simple">
		
			 <td>部门：</td>
				 <s:select label="部门" name="dept" list="{'财务处','机械','计算机','教务处','电子','化工'}"
				       multiple="false"/>
			 <td>年份：</td>
				 <s:select label="年份" name="year" list="{'2014','2013','2012','2011','2010','2009','2008'}"
				       multiple="false"/>
			 
		 	
			<s:submit cssClass="buttonBack" value="查询"/>
			<%-- <s:submit cssClass="buttonBack" value="上传"/> --%>
			&nbsp;&nbsp;&nbsp;
			  <tr>
		  <!-- <input type="button" cssClass="buttonBack" value="上传" onclick="location='shangchuansuccess.jsp'" /> -->	
		</tr>
			<!--  
			<input type="button" value="生成" 
			onclick="location='/EmpManageSys/salary/addAttendences.action'" class="buttonBack"/>
			-->
		</s:form></div>
		<div >
		<a href="addYeji.jsp">
					<img src="skin/22.gif"/>&nbsp;&nbsp;新增</a>
		</div>
<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
			<tr class="table_head">
				<td>序号</td>
				<td>部门</td>
				<td>工号</td>
				<td>姓名</td>
				<td>年份</td>				
				<td>教学工作量</td> 
				<td>教研</td>
			 	<td>科研</td>	 		 	
				<td>考核结果</td>	
				<td>基本操作</td>
			
			</tr>
		  <c:forEach items="${salarys}" var="salary" varStatus="i">
			<tr bgcolor="#FFFFFF">
				<td>${i.index+1 } </td>
				<td>${salary.dept}</td>
				<td>${salary.sid}</td>
				<td>${salary.struename}</td>
				<td>${salary.syear}</td>
		 		<td>${salary.gongzuoliang}</td> 
		 		<td>${salary.jiaoyan}</td> 	
			 	<td>${salary.keyan}</td>
				<td>${salary.zuizhongyeji}</td>			
				<td>
					<a href="salary!load.action?salary.uid=${salary.uid}" >
					<img src="skin/edt.gif"/>修改</a>
					
					<a href="salary!delete.action?salary.uid=${salary.uid}" >
					<img src="skin/edt.gif"/>删除</a>
					
				
					<a href="xiugaiSuccess.jsp" >
					<img src="skin/edt.gif"/>上传</a>
					
				</td>
			</tr>  
		  </c:forEach>	
		
		</table>
		
	</div>
	
	
	<div>
		<tr></tr><tr></tr><tr></tr>
		
		</div>
	
</div>
</body>
</html>