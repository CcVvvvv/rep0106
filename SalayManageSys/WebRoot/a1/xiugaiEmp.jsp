<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" type="text/css"></link>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
	body{
		text-align:center;
	}
	.buttonBack{
		background: url(skin/83.gif);
		width:67px;
		height:22px;
		border:0px;
		cursor: pointer;
	}
	input{
		border:1px solid gray;
		height:22px;
	}
	a:hover{
		text-decoration: underline;
	}
</style>

</head>
<body style="overflow-y:scroll">

   
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;<a href="dept!doShowAll.action" target="main">管理员</a>>>修改员工信息</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<br><s:form action="empInf!update1.action" theme="simple" method="post">
		<fieldset style="width:98%">
			<legend>填写员工信息如下：</legend>
			<%-- <input type="hidden" name="emp.uid" value="${emp.uid }"/>
			 --%>
			<table border="0" cellpadding="0" cellspacing="15">
            <tr>
           	 <td>教职工工号：</td>
                <td><input type="text" name="emp.uid" value="${emp.uid }"/></td>    
                <td>教职工姓名：</td>
                <td ><input type="text" name="emp.utruename" value="${emp.utruename }"/></td>
                                  
            </tr>
            <tr>
            	<td>教职工性别：</td>
                <td>
                    <select name=emp.sex value="${emp.sex}">
                    	<option value="男">男</option>
                    	<option value="女">女</option>
                    </select>  
                </td>         
                  <td>出生日期：</td>
                <td ><input class="Wdate" type="text" name="emp.birthday" id="time" value="${emp.birthday }"
 					 onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"></td>    
                
         <tr>
            	<td>婚姻：</td>
                <td><input type="text" name="emp.marry" value="${emp.marry }"/></td>    
                <td>是否独子：</td>
                <td ><input type="text" name="emp.shifouduzi" value="${emp.shifouduzi }"/></td>                
            </tr>
                
                <tr>
            	<td>职务：</td>
                <td><input type="text" name="emp.zhiwu" value="${emp.zhiwu }"/></td>    
                <td>职称：</td>
                <td ><input type="text" name="emp.zhichen" value="${emp.zhichen }"/></td>                
                
                 <tr>
            	<td>岗位：</td>
                <td><input type="text" name="emp.polity" value="${emp.polity }"/></td>    
                <td>入职时间：</td>
                <td ><input class="Wdate" type="text" name="emp.startdate" id="time" value="${emp.startdate }"
 					 onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"></td>                
            </tr>
             <tr>
            	
                <td>权限：</td>
                <td ><input type="text" name="emp.usertype" value="${emp.usertype }"/></td>  
                  <td>部门名称：
                <td>
                	           			 
                   <select name="emp.deptname" value="emp.deptname" >
                    	<option value="计算机">计算机</option>
                    	<option value="机械">机械</option>
                    	<option value="财务部">财务部</option>
                    	<option value="电子">电子</option>
                    	<option value="审计处">审计处</option>
                    	<option value="人事部">人事部</option>
                    	<option value="教务处">教务处</option>
           
                    </select>
                </td>          
            </tr>
            
            <tr>
            	<td>联系方式：</td>
                <td><input type="text" name="emp.telnum" value="${emp.telnum }"/></td>
            </tr>
             <tr>
            
                
               
            </tr>
            <tr>
            
        
            </tr>
        
           
            <tr>
                <td colspan="3"></td>
                <td align="left">
                 	<s:submit cssClass="buttonBack" value="保  存"/>
                 	&nbsp;&nbsp;&nbsp;<!-- <input type="button" value="返  回"  cssClass="buttonBack"  onclick="location='../a1/employeeInf.action'" class="buttonBack"/> -->
                </td>
            </tr>
        </table>
     </fieldset>
     </s:form>
    </div>
  </div>
</body>
</html>