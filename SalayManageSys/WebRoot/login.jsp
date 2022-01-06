<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>工资管理系统</TITLE>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<LINK href="images/public.css" type=text/css rel=stylesheet>
		<LINK href="images/login.css" type=text/css rel=stylesheet>
		<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
		<script language="javascript">
		var username_flag=false;
		var password_flag=false;
		var number_flag=false;
		$(function (){
			$("#txtUsername").blur(function (){
				username_flag=false;
				$("#usernameMsg").html("");
				var username = $("#txtUsername").val();
				if (username == "") {
							$("#usernameMsg").html("用户名不能为空");
							return;
				}
				username_flag=true;
			});
		});
		$(function (){
			$("#txtPassword").blur(function (){
				password_flag=false;
				$("#passwordMsg").html("");
				var password = $("#txtPassword").val();
				if (password == "") {
							$("#passwordMsg").html("密码不能为空");
							return;
				}
				password_flag=true;
			});
			
		});
			$(function(){
	$("#imageCode").blur(function(){

		password_flag=false;
				$("#passwordMsg").html("");
				var password = $("#txtPassword").val();
				if (password == "") {
							$("#passwordMsg").html("密码不能为空");
							return;
				}
				password_flag=true;
		
		});
		});
	/* $(function(){
	$("#imageCode").blur(function(){

		number_flag=false;
		$("#numberMsg").html("");
		var number=$("#imageCode").val();
		if(number==""){
		$("#numberMsg").html("验证码不能为空");
		return;
		}
		
		$.post("checkcode.action",
		{"number":number},
		function(data){
			if(data){
					$("#numberMsg").html("验证码正确");
					number_flag=true;
				}else{
					$("#numberMsg").html("验证码错误");
				}
		}
		);
		});
		});
	$(function(){
	$("#change").click(function(){
		//修改src属性
		$("#imgCode").attr("src","image.action?dt="+new Date().getTime());
		return false;//阻止href动作
	});
	});*/
	$(function(){
	$("#login_form").submit(function(){
				if(!username_flag){
				alert("用户名不能为空...");
				return false;
				}
				if(!password_flag){
				alert("密码不能为空...");
				return false;
				}
				/*if(!number_flag){
				alert("表单验证码信息有错");
				return false;
				}*/
				return true;
	});
	});
 </script>
		<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
	</HEAD>
	<BODY>
		<DIV id=div1>
		<form name="login" method="POST" action="login.action" id="login_form">
			<TABLE id=login height="100%" cellSpacing=0 cellPadding=0 width=800
				align=center>
				<TBODY>
					<TR id=main>
						<TD>
							<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
								<TBODY>
									<TR>
										<TD colSpan=4>
											&nbsp;
										</TD>
									</TR>
									<TR height=30>
										<TD width=350>
											&nbsp;
										</TD>
										<TD>
											&nbsp;
										</TD>
										<TD>
											&nbsp;
										</TD>
										<TD>
											&nbsp;
										</TD>
									</TR>
									<TR height=40>
										<TD rowSpan=4>
											&nbsp;
										</TD>
										<TD>
											用户名：
										</TD>
										<TD>
											<input class=textbox type="text" name="username" id="txtUsername"  />
											<span  id="usernameMsg" style="color:red">${username_error}</span>
										</TD>
										<TD width=120>
											&nbsp;
										</TD>
										
									</TR>
									<TR height=40>
										<TD>
											密 码：
										</TD>
										<TD>
												<input class=textbox type="password" name="password" id="txtPassword" />
												&nbsp;<span id="passwordMsg" style="color:red">${password_error}</span>
										</TD>
										<TD width=120>
											&nbsp;
										</TD>
									</TR>
									
									<!-- <TR height=40>
										<TD>
											验证码：
										</TD>
										<TD vAlign=center colSpan=2>
											 <input type="text" size=5 name="number" id="imageCode" /> 
											
											<img id='imgCode' src="image.action" 
												width="100" height="25" />
												<span id="numberMsg" style="color:red"></span>
											<a href="#" id="change">看不清楚？换个图片</a>
											
										</TD>
									</TR> -->
									<TR>
										
									</TR>
									<TR height=40>
										<TD>权限：</TD>
										<TD >
											<select id="usertype" name="usertype" style="width: 107px; ">&nbsp;&nbsp;										
												<option value="admin">系统管理员</option>
												<option value="renshichu">人事处人员</option>
												<option value="caiwuchu">财务处人员</option>
												<option value="xuexiaobumen">学校部门</option>
												<option value="jiaozhigong">教职工</option>
										</select>&nbsp;&nbsp;&nbsp;<input type="submit" id="login" value="登 录" />
										</TD>
										<TD width=120>
											&nbsp;
										</TD>
									</TR>
									<TR height=110>
										<TD colSpan=4>
											&nbsp;
										</TD>
									</TR>
								</TBODY>
							</TABLE>
						</TD>
					</TR>
					<TR id=root height=104>
						<TD>
							&nbsp;
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			
			</form>
		</DIV>
		<DIV id=div2 style="DISPLAY: none"></DIV>
		</CONTENTTEMPLATE>
	</BODY>
</HTML>
