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
				<td class="td_top"><b>当前位置:</b>&nbsp;<a href="deptList.action.action">学校部门管理</a>>>增加出勤</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<fieldset style="width:98%">
			<legend>出勤详情如下：</legend>
			
			<form action="attendence!add.action" method="post">
			
			<%-- <input type="hidden" name="attendence.aid" value="${attendence.aid}"/> --%>
		<table border="0" cellpadding="0" cellspacing="15">
            <tr>
                <td >
                    出勤ID：</td>
                <td>
                   <input type="text" name="attendence.aid" /></td>
                
                <td>
                    工号：</td>
                 <td >
                    <input type="text" name="attendence.aempid" /></td>
            </tr>
            <tr>
                <td>
                    年份：</td>
                <td>
                    <select name="attendence.ayear">
						<option value="2015">2015</option>
						<option value="2014">2014</option>
						<option value="2013">2013</option>
						<option value="2012">2012</option>
						<option value="2011">2011</option>
						<option value="2010">2010</option>
						<option value="2009">2009</option>
						<option value="2008">2008</option>
					</select></td>
                <td>
                    月份：</td>
                 <td>
                    <select name="attendence.amonth">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						
					</select></td>
            </tr>
      
             <tr>
               <td >
                   部门：</td>
                <td>
                  <select name="attendence.dept">
						<option value="财务处">财务处</option>
						<option value="机械">机械</option>
						<option value="计算机">计算机</option>
						<option value="教务处">教务处</option>
						<option value="人事处">人事处</option>
						<option value="电子">电子</option>
						<option value="化工">化工</option>
					</select></td>
                
               <td >
                    姓名：</td>
                <td>
                   <input type="text" name="attendence.atruename" /></td>
            </tr>
                
             <tr>
                <td>
                    缺勤次数：</td>
                <td>
                    <input type="text" name="attendence.anegletwork"  /></td>
                <td>
                    请假次数：</td>
                 <td>
                     <input type="text" name="attendence.aleave"  /></td>
            </tr>
                  <tr>
               <td>
                    早退次数：</td>
                 <td>
                     <input type="text" name="attendence.aearlyleave"/></td>
                <td>
                    加班时数：</td>
                 <td>
                     <input type="text" name="attendence.aovertime" /></td>
            </tr>
            <tr>
                <td>
                    迟到次数：</td>
                <td>
                    <input type="text" name="attendence.alatecome"  /></td>
                
               </tr>
               
               <tr>
               
               <td></td><td></td>
                <td align="right">&nbsp;
                   </td>
                <td align="left">
                 	<input type="submit" value="新增" class="buttonBack"/>
                 	&nbsp;&nbsp;&nbsp;
                 	
                 	<!-- <input type="button" value="返  回" onclick="location='/SalayManageSys/a2/findAttendence.action'" class="buttonBack"/> -->
                </td>
            </tr>
        </table>
        </form>
	</fieldset>
</div>
</div>
</body>

</html>