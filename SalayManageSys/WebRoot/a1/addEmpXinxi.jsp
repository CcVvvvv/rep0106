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
				<td class="td_top"><b>当前位置:</b>管理员>>添加职工</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<br><s:form action="empInf!add1.action" theme="simple" method="post">
		<fieldset style="width:98%">
			<legend>填写职工信息如下：</legend>
			<h4></h4>
			<table border="0" cellpadding="0" cellspacing="15">
            <tr>
            <!-- 	<td>教职工工号   *：</td>
                <td><input type="text" name="emp.uempid"/></td>
                   -->
                   <td>教职工ID：</td>
                <td><input type="text" name="emp.uid"/>    </td> 
                <td>教职工姓名：</td>
                <td ><input type="text" name="emp.utruename"/></td>
                  
            </tr>
            <tr>
            	    <td>联系方式：</td>
                <td><input type="text" name="emp.telnum"/>
  				</td>
                  <td>出生年月：</td>
                <td ><input class="Wdate" type="text" name="emp.birthday" id="time"
 					 onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"></td>
                 
                 
            </tr>
            <tr>
          	   <td>教职工性别：</td>
                <td><input name="emp.sex" type="radio" value="男"  checked="checked"/>男
                <input name="emp.sex" type="radio" value="女" />女	</td>
            	<td>是否独子：</td>
                <td><input type="text" name="emp.shifouduzi"/></td>
               
               
            </tr>
            <tr>
            	<td>职务：</td>
                <td><input type="text" name="emp.zhiwu"/></td>
                  
                <td>职称：</td>
                <td >
				 <select name="emp.zhichen">
						<option value="初级">初级</option>
						<option value="中级">中级</option>
						<option value="高级">高级</option>
					</select>     
				      
             
            </tr>
            <tr>
            	<td>岗位：</td>
                <td><input type="text" name="emp.polity"/></td>
                  
                <td>入职时间：</td>
                <td ><input class="Wdate" type="text" name="emp.startdate" id="time"
 					 onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"></td>
                 
            </tr>
            <tr>
            	<td>部门：</td>
                <td><select name="emp.deptname" >  
						  <option value ="机械">机械</option>
						  <option value ="电子">电子</option>
						  <option value ="财务处">财务处</option>
						  <option value ="人事部">人事部</option>
						  <option value ="保卫处">保卫处</option>
						  <option value ="计算机系">计算机系</option>
						  <option value ="自动化系">自动化系</option>
						  <option value ="机械系">机械系</option>
						</select></td>
               
                <td>权限：</td>
                <td ><input type="text" name="emp.usertype"/></td>
                 
            </tr>
            <tr>
               
           <td>婚姻：</td>
                <td ><input type="text" name="emp.marry"/></td>
            </tr>
 			<tr>
 			 
 			</tr>
           <!--  <tr>
                <td>备注信息：</td>
                <td colspan="3" style="height: 42px"><br>
                <textarea rows="5" cols="53" name="emp.remark"></textarea>
                    <br></td>
            </tr> -->
            <tr>
              
            </tr>
            <tr>
                <td colspan="3">&nbsp;</td>
                <td align="left">
                 	<s:submit cssClass="buttonBack" value="增加"/>
                 	&nbsp;&nbsp;&nbsp;
                 	<input type="button" value="返  回" 
                 	onclick="location='employeeInf.action'" class="buttonBack"/>
                </td>
            </tr>
        </table>
     </fieldset>
     </s:form>
    </div>
  </div>
</body>
</html>