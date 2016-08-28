<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.tvm.ilp.t154.cao.model.*" %>

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
<%Employee emp=(Employee)session.getAttribute("emp"); %>
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
<h2>Answer Security Question</h2>
<hr />
<form name="resetPasswd" action="/NBG/LoginServlet" method=post>
<input type="hidden" name="action" value="resetPwd"></input>
<table>
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
	<td colspan=2 class="label"><label id="err_empId"></label></td></tr>
	<tr>
		<td><b>Employee Id</b></td>
		<td><%=emp.getEmpId() %></td>
		
	</tr>
	<tr>
		<td><b>Security Question</b></td>
		<td><%=emp.getSecurityQues() %></td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td><b>Answer</b></td>
		<td><input type="text" name="ans"></td>
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
		
		<td colspan="2" style="width: 40%; align: center; padding: 5px"><a
			type="submit" class="button" tabindex=18 onclick="document.resetPasswd.submit();"
><em><b>&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;</b></em></a></td>
		<td colspan="2" style="width: 40%; align: center; padding: 10px"><a
			class="button" tabindex=19 href="/NBG/EmployeeManagementServlet?action=home&&role=null"
><em><b>&nbsp;&nbsp;&nbsp;&nbsp;Cancel&nbsp;&nbsp;&nbsp;&nbsp;</b></em></a></td>
		
	</tr>
</table>
</td>
<td>
<img src="<%=request.getContextPath()%>/images/resetPwd.jpg"></img>
</td>
</tr>
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