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
<SCRIPT type="text/javascript">
   	   function go(){
	     var number=document.myf.num.value;
	     var num;
	     if(number.length==0){
	        alert("请先输入要查找的页数!");
	        return;
	     }else{
	       num=number-1;
	     }
	     location="emppageSelectEmp.action?pageNow="+num;
	   
	   }
	   
	   function getname(){
	      var ss=document.f.emp.empName.value;
	      alert(ss);
	   }
	   
	   
	   function dalAll(){	
        
        Window.open(strUrl,strWindowName,strWindowFeatures)
        
      return document.chform.submit();
        
	   }
	   
	 
	   
	   
</SCRIPT>

</head>
<body style="font-size:30px;font-style:italic;" >
<div class="table_top" style="height:100%">
    
  	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;系统管理员>>教职工信息</td>
				<td align="right">
			
				</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">

	<div style="margin-top:10px;"  >
			<a href="addEmpXinxi.jsp">
					<img src="skin/22.gif"/>&nbsp;&nbsp;新增</a>
		</div>
		
		<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
			<tr class="table_head">
				<td>序号</td>
			
				<td>教职工ID</td>
				<td>教职工姓名</td>
				<td>教职工性别</td>
				<td>出生日期</td>
				<td>婚姻</td>
				<td>是否独子</td>
				<td>职务</td>
				<td>职称</td>
				<td>岗位</td>
				<td>入职时间</td>
				<td>部门</td>
				<td>权限</td>
				<td>联系方式</td>
				<td>基本操作</td>
			</tr>
	   <form action="" name="chform"  method="post" >
		  <c:forEach items="${emps}" var="emp" varStatus="i">
			<tr bgcolor="#FFFFFF">
				<td>${i.index+1 } </td>			
				<td>${emp.uid}</td> <%-- 
				<td>${emp.uempid}</td>  --%>
				<td>${emp.utruename}</td>
				<td>${emp.sex}</td>
				<td>${emp.birthday}</td>
				<td>${emp.marry}</td>
				<td>${emp.shifouduzi}</td>
				<td>${emp.zhiwu}</td>
				<td>${emp.zhichen}</td>
				<td>${emp.polity}</td>
				<td>${emp.startdate}</td>
				<td>${emp.deptname}</td>
				<td>${emp.usertype}</td>
				<td>${emp.telnum}</td>
				<td>
					<a href="empInf!load.action?emp.uid=${emp.uid}" >
					<img src="skin/edt.gif"/>修改</a>
					<a href="empInf!delete.action?emp.uid=${emp.uid}">
					<img src="skin/del.gif"/>删除</a>
				</td>
			</tr>  
		  </c:forEach>
		</form>
		  </table>  
		<div style="margin-left: 200px; margin-top: 50px;">  
	
      </div>
	</div>
</div>

</body>
</html>