<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出勤工资信息</title>
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
</script>
</head>
<body>
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;人事处>>生成出勤工资</td>
				<td align="right">
				</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<div style="margin-bottom:10px;"><!--salaryList1.action  -->
				<s:form action="buildchuqin.action" method="post" theme="simple">
			 	<td>请选择部门名称：</td>
					 <s:select name="dept" list="{'机械','电子','自动化','计算机','人事处','财务处','审计处','保卫处','教务处'}"
					       multiple="false"/> 
			     <td>年份：</td>
				 <s:select label="年份" name="year" list="{'2015','2014','2013','2012','2011','2010','2009','2008'}"
				       multiple="false"/>
			 
		 	<td>月份：</td>
				 <s:select label="月份" name="month" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}"
				       multiple="false"/>
		 
			<s:submit cssClass="buttonBack" value="生成"/>
	</s:form> </div>
		
		<div >
			
		</div>
		<div id="salarytable">
<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
			<tr class="table_head">
				<td>部门</td>	
				<td>工号</td>
				<td>应扣</td>			
				<td>年份</td>
				<td>月份</td>
				<td>出勤天数</td>
				<td>出勤工资</td>
			<!-- 	<td>出勤工资</td>		 -->		
			</tr>
		  <c:forEach items="${askForLeaves}" var="askForLeave" varStatus="i">
			<tr bgcolor="#FFFFFF">
				<td>${askForLeave.dept}</td>
				<td>${askForLeave.uid}</td>
				<td>${askForLeave.deduction}</td>
				<td>${askForLeave.year}</td>
				<td>${askForLeave.month}</td>
				<td>${askForLeave.day}</td>
				<td>
				${askForLeave.gongzi}
				 </td>	
			</tr>  
		  </c:forEach>		
		</table>
		</div>
	</div>
</div>
</body>
</html>