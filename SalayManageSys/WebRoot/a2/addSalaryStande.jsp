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
				<td class="td_top"><b>当前位置:</b>人事处>>添加工资设定</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<br><s:form action="setSalaryStandard!add.action" theme="simple" method="post">
		<fieldset style="width:98%">
			<legend>填写工资信息如下：</legend>
			<table border="0" cellpadding="0" cellspacing="15">
            <tr>
            	<td>岗位：</td>
                <td><select name="salaryStandard.zhiwei">
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
		
			</select></td>
                  
                <td>基本工资：</td>
                <td ><input type="text" name="salaryStandard.dbasesalary"/></td>
                
            </tr>
            <tr>
            	<td>薪级工资：</td>
                <td><input type="text" name="salaryStandard.baoliu"/>	</td>
               
                <td>基础绩效：</td>
                <td ><input type="text" name="salaryStandard.jixiao"/></td>
                  
            </tr>
            <tr>
          	  <!--  <td>补发资：</td>
                <td ><input type="text" name="salaryStandard.bufazi"/></td> -->
                  <td>取暖补：</td>
                <td ><input type="text" name="salaryStandard.qunuanbu"/></td>
            	<td>独子补：</td>
                <td><input type="text" name="salaryStandard.duzibu"/></td>
                   
               
            </tr>
            <tr>
            	<td>公积金补：</td>
                <td><input type="text" name="salaryStandard.gongjijin"/></td>
           
                <td>医疗险：</td>
                <td ><input type="text" name="salaryStandard.yiliaoxian"/></td>
                
            </tr>
            <tr>
            	<td>公积金减：</td>
                <td><input type="text" name="salaryStandard.gongjijinjian"/></td>
                 <td>编号：</td>
                <td ><input type="text" name="salaryStandard.did"/></td>
               
              
            </tr>
            
            <tr>
                      
              
                <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="3">&nbsp;</td>
                <td align="left">
                 	<s:submit cssClass="buttonBack" value="增加"/>
                 	&nbsp;&nbsp;&nbsp;
                 	<!-- <input type="button" value="返  回" 
                 	onclick="location='../a2/setSalayStandar.jsp'" class="buttonBack"/> -->
                </td>
            </tr>
        </table>
     </fieldset>
     </s:form>
    </div>
  </div>
</body>
</html>