<%@ page language="java" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description"
	content="Consulting page - free business website template from Template Monster is awating for you to download." />

<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>

<!--[if lt IE 7]>
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
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
<h2>Forgot Password?</h2>
<hr />
<form name="forgotPwd" action="/NBG/LoginServlet" method=post>
<input type="hidden" name="action" value="forgotPwdQ"></input>
<table width=60%>
<tr>
<td>
<img src="<%=request.getContextPath()%>/images/forgotPwd.png"></img>
</td>

<td>
<table width=100% border=0>
	<tr><td><br></br></td>
	</tr>
	<tr>
	<td colspan=2 class="label"><%if(request.getAttribute("msg")!=null){ out.println(request.getAttribute("msg"));} %><label id="err_empId"></label></td></tr>
<tr><td><br/></td></tr>	
	<tr>
		<td colspan="2"><b>Employee Id</b>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="empId" tabindex=1 size=10></td></tr>
		<tr><td><br/></td></tr>
		</table>
		<table width=60%>
		<tr>
		<td style="width: 65%; align: center; padding: 5px"><a
			type="submit" class="button" tabindex=2 onclick="validateEmpId();"
><em><b>Get Question</b></em></a></td>
<td style="width: 30%; align: center; padding: 5px"><a
			 class="button" tabindex=3 href="/NBG/EmployeeManagementServlet?action=home&&role=null" 
><em><b>&nbsp;&nbsp;Cancel&nbsp;&nbsp;</b></em></a></td>
	</tr>
	</table>
</td></tr>
</table>
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