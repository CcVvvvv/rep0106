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
				<td class="td_top"><b>当前位置:</b>&nbsp;学校各部门>>新增业绩</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<fieldset style="width:98%">
			<legend>业绩详情如下：</legend>
			
			<form action="salary!add.action" method="post"><%-- 
			
			<input type="hidden" name="salary.sid" value="${salary.sid}"/> --%>
		<table border="0" cellpadding="0" cellspacing="15">
            <tr>
             <td>
                    工号：</td>
                 <td >
                    <input type="text" name="salary.sid" /></td>
                    
             <td>
                    业绩编号：</td>
                 <td >
                    <input type="text" name="salary.uid" /></td>
               
               
            </tr>
            <tr>
             <td >
                    部门：</td>
                <td><select name="salary.dept">
						<option value="财务处">财务处</option>
						<option value="机械">机械</option>
						<option value="计算机">计算机</option>
						<option value="教务处">教务处</option>
						<option value="人事处">人事处</option>
						<option value="电子">电子</option>
						<option value="化工">化工</option>
					</select></td>
            <td>
                    年份：</td>
                <td>
                    <select name="salary.syear">
						<option value="2014">2014</option>
						<option value="2013">2013</option>
						<option value="2012">2012</option>
						<option value="2011">2011</option>
						<option value="2010">2010</option>
						<option value="2009">2009</option>
						<option value="2008">2008</option>
					</select></td>
            </tr>
            <tr>
                     <td >姓名 <td>
                     <input type="text" name="salary.struename" /></td>
               
                      <td>
                  科研：</td>
                 <td>
                     <input type="text" name="salary.keyan" /></td>
            </tr>
          <tr>
    
    
            <td>
                   教研：</td>
                <td>
                    <input type="text" name="salary.jiaoyan"  /></td>
                <td >考核结果 <td>
                     <input type="text" name="salary.zuizhongyeji" /></td>
            </tr>
            
            <tr>
               <td>
                    教学工作量：</td>
                 <td>
                     <input type="text" name="salary.gongzuoliang"  /></td>
              
             
                <td align="right">&nbsp;
                   </td>
                <td align="left">
                 	<input type="submit" value="新增" class="buttonBack"/>
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