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
				<td class="td_top"><b>当前位置:</b>&nbsp;<a href="deptList.action.action">考勤管理</a>>>业绩</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<fieldset style="width:98%">
			<legend>考勤详情如下：</legend>
			
			<form action="salary1!update.action" method="post">
			
			<input type="hidden" name="salary.uid" value="${salary.uid}"/>
		<table border="0" cellpadding="0" cellspacing="15">
            <tr>
             <td>
                    工号：</td>
                 <td >
                    <input type="text" name="salary.sid" value="${salary.sid}" /></td>
                <td >
                  姓名：</td>
                <td>
                   <input type="text" name="salary.struename"  value="${salary.struename}"/></td>
               
            </tr>
            <tr>
                <td>
                    年份：</td>
                <td>
                    <input type="text" name="salary.syear" value="${salary.syear}"/></td>
                <td>
                    教学工作量：</td>
                 <td>
                     <input type="text" name="salary.gongzuoliang"  value="${salary.gongzuoliang}"/></td>
            </tr>
          <tr>
    
    
            <td>
                   教研：</td>
                <td>
                    <input type="text" name="salary.jiaoyan" value="${salary.jiaoyan}" /></td>
                <td>
                  科研：</td>
                 <td>
                     <input type="text" name="salary.keyan" value="${salary.keyan}" /></td>
            </tr>
            
            <tr>
                <td >考核结果 <td>
                     <input type="text" name="salary.zuizhongyeji" value="${salary.zuizhongyeji}" /></td>
                 <td >
                    部门：</td>
                <td>
                   <input type="text" name="salary.dept"  value="${salary.dept}"/></td>
               
             </tr><tr>
             <td></td> <td></td>
                <td align="right">&nbsp;
                   </td>
                <td align="left">
                 	<input type="submit" value="修改" class="buttonBack"/>
                 	&nbsp;&nbsp;&nbsp;<!-- <input type="button" value="返  回" onclick="location='/SalayManageSys/a4/findAttendence.action'" class="buttonBack"/> -->
                </td>
            </tr>
        </table>
        </form>
	</fieldset>
</div>
</div>
</body>

</html>