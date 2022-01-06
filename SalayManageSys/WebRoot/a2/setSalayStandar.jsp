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
				<td class="td_top"><b>当前位置:</b>&nbsp;人事处管理>>工资标准设定</td>
				<td align="right">
				</td>
			</tr>
		 </table>
	</div>
	
	<div style="margin-bottom:10px;">
		<s:form action="../a2/salaryStandardList.action" method="post" theme="simple">
		<td>请选择设置岗位</td>
			<select name="zhiwei">
				<option value="一级">教授一级</option>
				<option value="二级">教授二级</option>
				<option value="三级">教授三级</option>
				<option value="四级">教授四级</option>
				<option value="五级">副教授五级</option>
				<option value="六级">副教授六级</option>
				<option value="七级">副教授七级</option>
				<option value="八级">讲师八级</option>
				<option value="九级">讲师九级</option>
				<option value="十级">讲师十级</option>
				<option value="十一级">助教十一级</option>
				<option value="十二级">助教十二级</option>
				<option value="十三级">助教十三级</option>
			<!-- 	<option value="十四级">行政人员</option>
				<option value="十五级">后勤人员</option> -->
			</select>
		
			<s:submit cssClass="buttonBack" value="查询"/>
			&nbsp;&nbsp;&nbsp;
			
		</s:form></div>
	
	
	<div height="100%" style="margin-top:10px;">
		<div style="margin-bottom:10px;">
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
		
		</div>
		
		<div id="salarytable">
<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
			<tr class="table_head">
				<td>序号</td>
				<td>岗位</td>
				<td>基本工资</td>
				<td>薪级工资</td>
				<td>基础绩效</td>
				<!-- <td>补发资</td> -->
				<td>独子补</td>
				<td>公积金补</td>
				<td>医疗险</td>
				<td>公积金减</td>
				<td>取暖补</td>
				<td>基本操作</td>
				
			</tr>
		  <c:forEach items="${salaryStandards}" var="salaryStandard" varStatus="i">
			<tr bgcolor="#FFFFFF">
				<td>${i.index+1 } </td>
				<td>${salaryStandard.zhiwei } </td>
				<td>${salaryStandard.dbasesalary} </td>
				<td>${salaryStandard.baoliu} </td>
				<td>${salaryStandard.jixiao} </td>
				<%-- <td>${salaryStandard.bufazi} </td> --%>
				<td>${salaryStandard.duzibu} </td>
				<td>${salaryStandard.gongjijin} </td>
				<td>${salaryStandard.yiliaoxian} </td>
				<td>${salaryStandard.gongjijinjian} </td>
				<td>${salaryStandard.qunuanbu} </td>
				
				<td>
				<a href="salaryStandardTwo!load.action?salaryStandard.did=${salaryStandard.did}" >
					<img src="skin/edt.gif"/>修改</a>
				<a href="salaryStandardTwo!delete.action?salaryStandard.did=${salaryStandard.did}">
					<img src="skin/del.gif"/>删除</a>	
				</td>
			</tr>  
		  </c:forEach>		
		</table>
		</div>
		 <div style="margin-top:10px;"  >
			<a href="addSalaryStande.jsp">
					<img src="skin/22.gif"/>&nbsp;&nbsp;新增</a>
			
		</div>
 	</div>
</div>
</body>
</html>