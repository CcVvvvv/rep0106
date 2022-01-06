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
				<td class="td_top"><b>当前位置:</b>&nbsp;<a href="" target="main">教职工管理</a>>>个人信息</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;"><!-- emp!load.action -->
		<br><s:form action="emp!load.action" theme="simple" method="post">
		<fieldset style="width:98%">
			<legend>信息如下：</legend>
			<input type="hidden" name="emp.uid" value="${emp.uid }"/>
			
			<table border="0" cellpadding="0" cellspacing="15">
            <tr>
            	<td>员工工号：</td>
                <td>${emp.uempid }
                   </td>
                <td>员工姓名：</td>
                <td >${emp.utruename }
                   </td>
            </tr>
            <tr>
            	<td>员工性别：</td>
                <td>
                     ${emp.sex}
                </td>
                   
                <td>出生年月：</td>
                <td >${emp.birthday }
 					 </td>
                   
            </tr>
            <tr>
          	 <%--   <td>年龄：</td>
                <td >${emp.age }
                   </td> --%>
        <%--     	<td>身份证号：</td>
                <td>${emp.idnum }
                   </td>
                --%>
     
            	<td>婚姻情况：</td>
                <td>${emp.marry }
                   </td>
          <%--       <td>政治面貌：</td>
                <td >${emp.polity }
                   </td> --%>
      
            	<%-- <td>籍贯：</td>
                <td>${emp.city }
                   </td> --%>
                <td>手机号：</td>
                <td >${emp.telnum }
                   </td>
            </tr>
            <tr>
            	<%-- <td>毕业院校：</td>
                <td>${emp.school }
                   </td> --%>
         <%--        <td>学历：</td>
                <td >${emp.degree }
                   </td> --%>
 
                <td>入职时间：</td>
                <td>${emp.startdate }
 					
  				</td>
      <%--           <td>部门名称：
                <td>	           			 
                  ${emp.deptname}
                </td> --%>
               
           
      <%--       	<td>住址：</td>
                <td>${emp.address }
                   </td> --%>
            	<td>权限编号：</td>
                <td>${emp.usertype }
                   </td>
        
            </tr>
            <tr>
            	<td>是否独子：</td>
                <td>${emp.shifouduzi }</td>
                  
                <td>职务：</td>
                <td >${emp.polity}</td>
                   
            </tr>
             <tr>
            	<td>职称：</td>
                <td> ${emp.zhichen}</td>
                  
                <td>岗位：</td>
                <td >${emp.gangwei}</td>
                   
            </tr>
        
            <tr>
        <%--         <td>备注信息：</td>
                <td colspan="3" style="height: 42px">
                ${emp.remark }
                    <br></td> --%>
                   	<td>部门：</td>
                <td >
                 <select name="emp.deptname"   value="${emp.deptname }">                	
                 	<option value="机械" selected>机械</option>
                 	<option value="人事部">人事部</option>
                 	<option value="电子">电子</option>
                 	<option value="计算机" selected >计算机</option>
                 	<option value="保卫处">保卫处</option>
                 	<option value="财务处">财务处</option>
                 	<option value="教务处">教务处</option>
                 	<option value="审计处">审计处</option>
                 </select><td></td>
                    <td>
                    	<s:submit cssClass="buttonBack" value="修改"/>
                   <!--  	<a href="../a5/addPersInf.jsp">修改</a> -->
                    </td>
            </tr>
          	
     
        </table>
     </fieldset>
     
     </s:form>
     
    </div>
  </div>
</body>
</html>