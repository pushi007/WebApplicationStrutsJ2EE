<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Business Account Confirmation</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/maxheight.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/javascript.js"></script>
</head>
<body id="page5" onload="new ElementMaxHeight();">

<!-- header -->
<jsp:include page="../jsp/layout/header.jsp"></jsp:include>
<!-- content -->

<div id="content">
<div class="container"><!-- main-banner-small begin -->
<div class="main-banner-small">
<div class="inner">
<h1>The bank for a changing world.</h1>
</div>
</div>
<!-- main-banner-small end -->
<div class="wrapper">
<div class="col-1 maxheight">
<!-- box begin -->
<div class="box maxheight">
<div class="border-top maxheight">
<div class="border-right maxheight">
<div class="border-bot maxheight">
<div class="border-left maxheight">
<div class="left-top-corner maxheight">
<div class="right-top-corner maxheight">
<div class="right-bot-corner maxheight">
<div class="left-bot-corner maxheight">
<div class="inner">
											<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Commercial Account Opening</b></p>
											<hr></hr>
											<br>
											<!--<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">Open Account</b></a></h4>-->
											<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">Assign Relationship Manager</b></a></h4>
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
<!-- box end --></div>
<div class="col-2 maxheight"><!-- box begin -->
<div class="box maxheight">
<div class="border-top maxheight">
<div class="border-right maxheight">
<div class="border-bot maxheight">
<div class="border-left maxheight">
<div class="left-top-corner maxheight">
<div class="right-top-corner maxheight">
<div class="right-bot-corner maxheight">
<div class="left-bot-corner maxheight">



<div class="inner">


<h3 align="center"
	style="font-family: Arial, Verdana; font-size: 16px; color: #000"></h3>

<%
	String message = (String) request.getAttribute("msg");
%>
<table  align="center" cellpadding=10 cellspacing=10>
	<tr>
		<%
			if (message != null) {
		%>
		<td align="center"><%=message%></td>
		<%
			}
		%>
	</tr>
</table>
<hr></hr>
<form id="contacts-form2" name="confirmationPage" method="post">
<table align="center">
	<tr>
		<td><b>Do you want to have more Accounts?</b></td>
	</tr>
	<tr>
		<td colspan="2" style="padding: 10px;"><a
			href="/NBG/AccountCreationServlet?action=CreateAccountPage"
			class="button"><em><b>Yes</b></em></a></td>
		<td style="padding: 10px;"><a
			href="/NBG/AssignRelationshipManagerServlet?action=RMassign"
			class="button"><em><b>No</b></em></a></td>
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
</div>
</div>

<!-- footer -->
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>