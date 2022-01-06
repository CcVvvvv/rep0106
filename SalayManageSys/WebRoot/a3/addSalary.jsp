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
				<td class="td_top"><b>当前位置:</b>财务处</a>>>增加工资</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<fieldset style="width:98%">
			<legend>填写工资详情如下：</legend>
			
			<form action="addSalary!add.action" method="post">
			

		<table border="0" cellpadding="0" cellspacing="15">
            <tr>
                <td >
                    工资编号：</td>
                <td>
                   <input type="text" name="salary.sid" /></td>
                    <td>
                    工号：</td>
                 <td>
                     <input type="text" name="salary.sempid"  /></td>
              
            </tr>
           
            <tr>
                <td >
                    年份：</td>
                <td>
                   <input type="text" name="salary.syear" /></td>
                    <td>
                    月份：</td>
                 <td>
                     <input type="text" name="salary.smonth"  /></td>
              
            </tr>
           
            <tr>
                <td >
                    部门：</td>
                <td>
                   <input type="text" name="salary.dept" /></td>
                    <td>
                    基本工资：</td>
                 <td>
                     <input type="text" name="salary.sbasesalary"  /></td>
              
            </tr>
           
            <tr>
                <td >
                    薪资：</td>
                <td>
                   <input type="text" name="salary.xinji" /></td>
                    <td>
                    基础绩效：</td>
                 <td>
                     <input type="text" name="salary.gongjijin"  /></td>
              
            </tr>
           
            <tr>
                <td >
                    津贴：</td>
                <td>
                   <input type="text" name="salary.jintie" /></td>
                    <td>
                    独子补：</td>
                 <td>
                     <input type="text" name="salary.dushengzibu"  /></td>
              
            </tr>
           
            <tr>
                <td >
                    考勤奖罚：</td>
                <td>
                   <input type="text" name="salary.kaoqin" /></td>
                    <td>
                    业绩奖罚：</td>
                 <td>
                     <input type="text" name="salary.kaohe"  /></td>
              
            </tr>
            <tr>
                <td >
                    公积金补：</td>
                <td>
                   <input type="text" name="salary.gongjijinbu" /></td>
                    <td>
                    公积金减：</td>
                 <td>
                     <input type="text" name="salary.gongjijinjian"  /></td>
              
            </tr>
            <tr>
                <td >
                  医疗险：</td>
                <td>
                   <input type="text" name="salary.yiliaoxian" /></td>
                    <td>
                    取暖补：</td>
                 <td>
                     <input type="text" name="salary.qunuanbu"  /></td>
              
            </tr>
            <tr>
                <td >
                    计税项目：</td>
                <td>
                   <input type="text" name="salary.jishuixiangmu" /></td>
                    <td>
                    所得税：</td>
                 <td>
                     <input type="text" name="salary.suodeshui"  /></td>
              
            </tr>
           
        
            <tr>
                <td >&nbsp;
                </td>
                <td>
                    &nbsp;</td>
                <td align="right">&nbsp;
                   </td>
                <td align="left">
                 	<input type="submit" value="添加" class="buttonBack"/>
                 
                </td>
            </tr>
        </table>
        </form>
	</fieldset>
</div>
</div>
</body>

</html>