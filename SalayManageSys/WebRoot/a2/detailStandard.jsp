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
<body style="overflow-y:scroll">
              
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;人事部管理</a>>>工资标准设定</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<fieldset style="width:98%">
			<legend>设定详情如下：</legend>
			
			<form action="salaryStandardTwo!update.action" method="post">
			
			<input type="hidden" name="salaryStandard.did" value="${salaryStandard.did}"/>
		<table border="0" cellpadding="0" cellspacing="15">
             <tr>
                <td >
                
                   岗位：</td>
                 <td >
                    <input type="text" name="salaryStandard.zhiwei" value="${ salaryStandard.zhiwei}" /></td>
               <td>取暖补</td>
                 <td >
                    <input type="text" name="salaryStandard.qunuanbu" value="${ salaryStandard.qunuanbu}" /></td>
          </tr>

          <tr>
                   <td>
                    基本工资：</td>
                 <td >
                    <input type="text" name="salaryStandard.dbasesalary" value="${ salaryStandard.dbasesalary}" /></td>
                   <td>
                   薪级工资：</td>
                 <td >
                    <input type="text" name="salaryStandard.baoliu" value="${ salaryStandard.baoliu}" /></td>
          </tr>
          <tr>
                   <td>
                    基础绩效：</td>
                 <td >
                    <input type="text" name="salaryStandard.jixiao" value="${ salaryStandard.jixiao}" /></td>
                   <td>
                    公积金减：</td>
                 <td >
                    <input type="text" name="salaryStandard.gongjijinjian" value="${ salaryStandard.gongjijinjian}" /></td>
                  <%--  <td>
                    补发资：</td>
                 <td >
                    <input type="text" name="salaryStandard.bufazi" value="${ salaryStandard.bufazi}" /></td> --%>
          </tr>
          <tr>
                   <td>
                    独子补：</td>
                 <td >
                    <input type="text" name="salaryStandard.duzibu" value="${ salaryStandard.duzibu}" /></td>
                   <td>
                    公积金补：</td>
                 <td >
                    <input type="text" name="salaryStandard.gongjijin" value="${ salaryStandard.gongjijin}" /></td>
          </tr>
          <tr>
                   <td>
                   医疗险：</td>
                 <td >
                    <input type="text" name="salaryStandard.yiliaoxian" value="${ salaryStandard.yiliaoxian}" /></td>
                  
          </tr>
         
            <tr>
                <td >&nbsp;
                </td>
                <td>
                    &nbsp;</td>
                <td align="right">&nbsp;
                   </td>
                <td align="left">
                 	<input type="submit" value="修 改" class="buttonBack"/>
                 	&nbsp;&nbsp;&nbsp;<input type="button" value="返  回" onclick="location='../a2/salaryStandardList.action'" class="buttonBack"/>
                </td>
            </tr>
        </table>
        </form>
	</fieldset>
</div>
</div>
</body>

</html>