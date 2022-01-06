<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		border:0px solid gray;
		height:22px;
		border-bottom:1px solid gray;
	}
	a:hover{
	text-decoration: underline;
	}
</style>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>
              
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;<a href="deptList.action.action">人事部管理</a>>>修改出勤信息</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<fieldset style="width:98%">
			<legend>出勤详情如下：</legend>
			
			<form action="attendence1!update2.action" method="post">
			
			<input type="hidden" name="attendence.aid" value="${attendence.aid}"/>
		<table border="0" cellpadding="0" cellspacing="15">
            <tr>
                <td >
                    姓名：</td>
                <td>
                   <input type="text" name="attendence.atruename"  value="${attendence.atruename}"/></td>
                <td>
                    工号：</td>
                 <td >
                    <input type="text" name="attendence.aempid" value="${attendence.aempid}" /></td>
            </tr>
            <tr>
                <td>
                    年份：</td>
                <td>
                    <input type="text" name="attendence.ayear" value="${attendence.ayear}"/></td>
                <td>
                    月份：</td>
                 <td>
                     <input type="text" name="attendence.amonth"  value="${attendence.amonth}"/></td>
            </tr>
      
             <tr>
               <td >
                   部门：</td>
                <td>
                   <input type="text" name="attendence.dept"  value="${attendence.dept}"/></td>
                <td>
                    缺勤天数：</td>
                <td>
                    <input type="text" name="attendence.queqinday" value="${attendence.queqinday}" /></td>
               
            </tr>
                
             <tr>
                <td>
                    扣款每次：</td>
                <td>
                    <input type="text" name="attendence.koukuanmeici" value="${attendence.koukuanmeici}" /></td>
               <%--  <td>
                    应扣：</td>
                 <td>
                     <input type="text" name="attendence.yinkou" value="${attendence.yinkou}" /></td> --%>
            </tr>
                  
            <tr>
                <td >&nbsp;
                </td>
                <td>
                    &nbsp;</td>
                <td align="right">&nbsp;
                   </td>
                <td align="left">
                 	<input type="submit" value="修改" class="buttonBack"/>
                 	&nbsp;&nbsp;&nbsp;<!-- <input type="button" value="返  回" onclick="location='/SalayManageSys/a2/findAttendence.action'" class="buttonBack"/> -->
                </td>
            </tr>
        </table>
        </form>
	</fieldset>
</div>
</div>
</body>

</html>