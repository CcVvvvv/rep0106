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

</head>
<body>
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;人事部管理>>奖金及扣款清单</td>
				<td align="right">
				
				</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<div style="margin-bottom:10px;">
		  <s:form action="buildjiangjin.action" method="post" theme="simple">
		 
		 	<td>年份：</td>
				 <s:select label="月份" name="year" list="{'2015','2014','2013','2012'}"
				       multiple="false"/>
		 
		 
		 	<td>月份：</td>
				 <s:select label="月份" name="month" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}"
				       multiple="false"/>
		 
		
			<s:submit cssClass="buttonBack" value="查询"/> 
			&nbsp;&nbsp;&nbsp;
			
		</s:form> </div>
	
<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
			<tr class="table_head">
				<td>序号</td>
				<td>部门</td>
				<td>工号</td>
				<td>姓名</td>
				<td>年份</td>
				<td>月份</td>
				<td>迟到扣款</td>
				<td>早退扣款</td>
				<td>请假扣款</td>
				<!-- <td>旷工扣款</td> -->
				<td>加班奖金</td>
			<!-- 	<td>奖罚最后金额</td> 
				-->
			</tr>
		  <c:forEach items="${attendences}" var="attendence" varStatus="i">
			<tr bgcolor="#FFFFFF">
				<td>${i.index+1 } </td>
				<td>${attendence.dept}</td>	
				<td>${attendence.aid}</td>		
					
				<td>${attendence.atruename}</td>
				<td>${attendence.ayear}</td>
				<td>${attendence.amonth}</td>
				<td>${attendence.alatecome}</td>
				<td>${attendence.aearlyleave}</td>
				<td>${attendence.aleave}</td>
			<%-- 	<td>${attendence.anegletwork}</td> --%>
				<td>${attendence.aovertime}</td>
			
			
			</tr>  
		  </c:forEach>		
		</table>
	</div>
</div>
</body>
</html>