<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
if(request.getSession()==null || request.getSession().getAttribute("UID")==null){
     response.sendRedirect(request.getContextPath()+"/jsp/HomeLogin.jsp");
     return;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<link href="<%=request.getContextPath() %>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/ChangePwdValidation.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/maxheight.js"
	type="text/javascript"></script>

<!--[if lt IE 7]>
	<link href="../CSS/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

</head>

<body id="page5" onload="new ElementMaxHeight();">
<!-- header -->
<jsp:include page="layout/header.jsp"></jsp:include>
<!-- content -->
<div id="content">
<div class="container"><!-- main-banner-small begin -->
<div class="main-banner-small">
<div class="inner">
<h1>The bank for a changing world.</h1>
</div>
</div>
<!-- main-banner-small end --> <!-- box begin -->
<div class="box">
<div class="border-top">
<div class="border-right">
<div class="border-bot">
<div class="border-left">
<div class="left-top-corner">
<div class="right-top-corner">
<div class="right-bot-corner">
<div class="left-bot-corner">
<div class="inner">
<table width=100%>
	<tr>
		<td>
		<h2>Change Password</h2>
		</td>
	</tr>
</table>
<hr/>
<%int empId=(Integer)session.getAttribute("UID"); %>
<span style="align:right"><b>Fields marked with <span style="color: red;">*</span> are mandatory&nbsp;&nbsp;&nbsp;</b></span>
<form name="Change_Pwd"
	action=/NBG/LoginServlet>
	<input type="hidden" name=action value=changePwd></input>
<table border=0 width=85%>
<tr>
<td>	
<table cellpadding=10 cellspacing=10>
	<tr>
		<td><br>
		</td>
		<td><br>
		</td>
	</tr>
	<tr>
		<td><b>Current Password</b><span style="color: red;">*</span></td>
		<td><input type="password" name="currPwd" onblur="validateCurrPwd();">
		<span class="label"><label id="err_currPwd"></label></span></td>
	</tr>
	<tr>
		<td><b>New Password</b><span style="color: red;">*</span></td>
		<td><input type="password" name="newPwd" id="newPwd" onblur="validatePwd();">
		<span class="label"><label id="err_newPwd"></label></span></td>
	</tr>
	<tr>
		<td><b>Confirm Password</b><span style="color: red;">*</span></td>
		<td><input type="password" name="confPwd" id="confPwd" onblur="validateConfPwd();">
		<span class="label"><label id="err_confPwd"></label></span></td>
	</tr>
	<tr>
		<td><b>Security Question</b><span style="color: red;">*</span></td>
		<td><select name="securityQues" id="securityQues" onblur="validateSecQ();">
			<option value="unselected">Select</option>
			<option value="What is your maternal grandmother's maiden name?">What is your maternal grandmother's maiden name?</option>
			<option value="What was the last name of your third grade teacher?">What was the last name of your third grade teacher?</option>
			<option value="What was your childhood nickname?">What was your childhood nickname?</option>
			<option value="In what city or town was your first job?">In what city or town was your first job?</option>
		</select>
		<span class="label"><label id="err_ques"></label></span></td>
	</tr>
	<tr>
		<td><b>Answer</b><span style="color: red;">*</span></td>
		<td><input type="text" name="answer" id="answer" onblur="validateAnswer();">
		<span class="label"><label id="err_answer"></label></span></td>
	</tr>
	<tr>
		<td><br>
		</td>
		<td><br>
		</td>
	</tr>
</table>
<table>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td colspan="2" width=40% style="align: center; padding: 5px"><a
			type="submit" class="button" onclick="return validateform();"
><em><b>&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;</b></em></a></td>
		<td colspan="2" width=40% style="align: center; padding: 10px"><a
			class="button" href="/NBG/EmployeeManagementServlet?action=home&&role=<%=session.getAttribute("role") %>"
><em><b>&nbsp;&nbsp;&nbsp;&nbsp;Cancel&nbsp;&nbsp;&nbsp;&nbsp;</b></em></a></td>
		<td><input type="hidden" name="action" value="changePasswd"></input></td>
	</tr>
</table>
</td>
<td>
<img src="<%=request.getContextPath()%>/images/changePwd4.jpg"></img>
</td></tr></table>
</form>

</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<!-- box end -->

<!-- footer -->
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>