<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="css/main.css" type="text/css"></link>



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
	
   
<div class="table_top" style="height:100%" >
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>管理员>>添加用户</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<br><s:form action="user!add.action" method="post" theme="simple">
		<fieldset style="width:98%">
			<legend>填写职工信息如下：</legend>
			<table border="0" cellpadding="0" cellspacing="15">
            <tr>
            	<td>用户名：</td>
                <td><input type="text" name="user.username"/></td>  
            	<td>用户ID：</td>
                <td><input type="text" name="user.uid"/></td>  
            </tr>
            <tr>
               <td>密码：</td>
                <td ><input type="text" name="user.password"/><span id="passwordMsg" style="color:red">${password_error}</span></td>
          	   <td>密码确认：</td>
                <td ><input type="text" name="password2"/></td>
               </tr>
              <tr>   
            	<td>权限：</td>
                <td><input type="text" name="user.usertype"/></td>
 
            	<!-- <td>员工姓名：</td>
                <td><input type="text" name="user.utruename"/></td> -->
            </tr>
            <tr>
           		<td> <s:submit cssClass="buttonBack" value="保存"/></td>
            </tr>
        </table>
     </fieldset>
     </s:form>
    </div>
  </div>
</body>
</html>