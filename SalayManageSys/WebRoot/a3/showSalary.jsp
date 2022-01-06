<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工资信息</title>
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
				<td class="td_top"><b>当前位置:</b>&nbsp;财务管理>>查询工资</td>
				<td align="right">
				</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<div style="margin-bottom:10px;">
				<s:form action="salaryList.action" method="post" theme="simple">
				<td>请选择您要查询的部门：</td>
					 <s:select label="部门" name="dept" list="{'机械','电子','自动化','计算机','人事处','财务处','审计处','保卫处','教务处'}"
					       multiple="false"/>
		<%-- 	部门：<s:textfield name="dept" cssClass="input"/>&nbsp;&nbsp;
			&nbsp;&nbsp; --%>
			<s:submit cssClass="buttonBack" value="查询"/>			
			<script>
				function printdiv(printpage)
				{
					var headstr = "<html><head><title></title></head><body>";
					var footstr = "</body>";
					var newstr = document.all.item(printpage).innerHTML;
					var oldstr = document.body.innerHTML;
					document.body.innerHTML = headstr+newstr+footstr;
					window.print(); 
					document.body.innerHTML = oldstr;
					return false;
				}
			</script>
			
		</s:form> </div>
		
		<div >
			
		</div>
		<div id="salarytable">
<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
			<tr class="table_head">
				<td>工资编号</td>
				<td>工号</td>
	<!-- 			<td>员工工资ID</td> -->
				<td>真实姓名</td>
				<td>部门</td>
				<td>年份</td>
				<td>月份</td>
				<td>基本工资</td>
				<td>薪资</td>
				<td>津贴</td>
				<td>独生子</td>
				<td>基础绩效</td>			
				<td>公积金减</td>			
				<td>公积金补</td>			
				<td>医疗险</td>
				<td>取暖补</td>
				<td>计税项目</td>
				<td>所得税</td>
				<td>应发</td>
				<td>应扣</td>
				<td>实发</td>
			</tr>
		  <c:forEach items="${salarys}" var="salary" varStatus="i">
			<tr bgcolor="#FFFFFF">
				<td>${salary.sid}</td>	
			<%-- 	<td>${salary.uid}</td>	 --%>
			<td>${salary.sempid}</td> 
				<td>${salary.struename}</td>
				<td>${salary.dept}</td>
				<td>${salary.syear}</td>
				<td>${salary.smonth}</td>
				<td>${salary.sbasesalary}</td>
				<td>${salary.xinji}</td>
				<td>${salary.jintie}</td>
				<td>${salary.dushengzibu}</td>
				<td>${salary.gongjijin}</td>
				<td>${salary.gongjijinjian}</td>
				<td>${salary.gongjijinbu}</td>
				<td>${salary.yiliaoxian}</td>
				<td>${salary.qunuanbu}</td>
				<td>${salary.jishuixiangmu}</td>
				<td>${salary.suodeshui}</td>
				<td>${salary.yingfa}</td>
				<td>${salary.yingkou}</td>
				<td>${salary.shifa}</td>
				<td>
		
				</td>
			</tr>  
		  </c:forEach>		
		</table>
		</div>
	</div>
</div>
</body>
</html>