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
		<br><s:form action="userInf1!update1.action" theme="simple" method="post">
		<fieldset style="width:98%">
			<legend>填写员工信息如下：</legend>
			<input type="hidden" name="user" value="${user.uid}"/>
			
			<table border="0" cellpadding="0" cellspacing="15">
            <tr>
            	<td>用户名：</td>
                <td><input type="text" name="user.username" value="${user.username }"/></td>
 
             
            </tr>  
                 
            <tr>
            	<td>用户编号：</td>
                <td><input type="text" name="user.uid" value="${user.uid }"/></td>
 
             
            </tr>       
            <tr>
             <td>权限编号：</td>
             
				<td><input type="text" name="user.usertype" value="${user.usertype}"/></td>    
            	
            
            <%-- 	<td>密码：</td>
                <td><input type="text" name="emp.password" value="${emp.password}"/></td> --%>
			</tr>       
             <tr>
            <%-- <td>用户ID：</td>
                <td><input type="text" name="emp.uid" value="${emp.uid } " /></td>  --%>  
                <!--  style="display: none;" -->      
            </tr>
            <tr>
                <%-- <td>备注信息：</td>
                <td colspan="3" style="height: 42px"><br>
                <textarea rows="5" cols="53" name="emp.remark" >${emp.remark }</textarea>
                    <br></td> --%>
            </tr>
            <tr>
                <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="3">&nbsp;</td>
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