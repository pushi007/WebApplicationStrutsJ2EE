<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tvm.ilp.t154.cao.model.*"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
	if (request.getSession() == null
			|| request.getSession().getAttribute("UID") == null) {
		response.sendRedirect(request.getContextPath()
				+ "/jsp/HomeLogin.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description"
	content="Consulting page - free business website template from Template Monster is awating for you to download." />

<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css"
	rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath()%>/js/maxheight.js"
	type="text/javascript"></script>

<!--[if lt IE 7]>
	<link href="<%=request.getContextPath()%>/css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->


</head>

<body id="page5" onload="new ElementMaxHeight(); setJoiningDate();">
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
<!-- main-banner-small end -->
<div class="wrapper">
<div class="col-1 maxheight"><!-- box begin -->
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
<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Employee</b></p><hr>
<h4><a href="/NBG/EmployeeManagementServlet?action=closeSession"><b
	style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
<h4><a href="#" onclick="return validateConfirmEmp();"><b style="font-family: Arial; font-size: 13px;">Register</b></a></h4>
<h4><a href="#" onclick="return validateConfirmEmp();"><b>View Employees</b></a></h4>
	
	<!--<br/><br/>
<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Product Management</b></p><hr>
<h4> <a href="#" onclick="return validateConfirmEmp();"><b style="font-family: Arial; font-size: 12px;">Add Product(s)</b></a></h4>
<h4><a href="#" onclick="return validateConfirmEmp();"><b style="font-family: Arial; font-size: 12px;">View Products</b></a></h4>
<h4><a href="#" onclick="return validateConfirmEmp();"><b style="font-family: Arial; font-size: 12px;">Product Report</b></a></h4>
<br/>
<p style="font-family: Arial, Verdana; font-size: 13px;"><b>Additional Products</b><br></p>
<h4><a href="#" onclick="return validateConfirmEmp();"><b style="font-family: Arial; font-size: 12px;">Add Additional Product</b></a></h4>
<h4><a href="#" onclick="return validateConfirmEmp();"><b style="font-family: Arial; font-size: 12px;">Update/Delete Additional Product</b></a></h4>
<h4><a href="#" onclick="return validateConfirmEmp();"><b style="font-family: Arial; font-size: 12px;">Additional Product Report</b></a></h4>

-->
<br/><br/>
<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Password Management</b></p><hr>
<h4><a href="#" onclick="return validateConfirmEmp();" ><b  style="font-family: Arial; font-size: 12px;">Change Password</b></a></h4>
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

		<h2>Employee Summary</h2>
	
<hr>

<%
	Employee emp = new Employee();
	emp = (Employee) (session.getAttribute("emp"));
%>

<table width=70% cellpadding=10 cellspacing=10 border=0>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td></td>
	</tr>


	<tr>
		<td><b>Title</b></td>
		<td><%=emp.getTitle()%></td>
	</tr>

	<tr>
		<td><b>Name</b></td>
		<td><%=emp.getFirstNm()%>&nbsp;&nbsp;<%=emp.getLastNm()%></td>
	</tr>

	<tr>
		<td><b>Date of Birth</b><br/>(yyyy/mm/dd)</td>
		<td><%=emp.getDateOfBirth()%></td>
	</tr>

	<tr>
		<td><b>Address</b></td>
		<td><%=emp.getAddress()%></td>
	</tr>

	<tr>
		<td><b>Contact Number</b></td>
		<td><%=emp.getContactno()%></td>
	</tr>

	<tr>
		<td><b>Email Id</b></td>
		<td><%=emp.getEmailId()%></td>
	</tr>

	<tr>
		<td><b>Date of Joining</b><br/>(yyyy/mm/dd)</td>
		<td><%=emp.getDateOfJoin()%></td>
	</tr>

	<tr>
		<td><b>Designation</b></td>
		<td><%=emp.getDesignation()%></td>
	</tr>

	
	<tr>
		<td><b>Branch Name</b></td>
		<td><%=emp.getBranchName()%></td>
	</tr>

	
	<tr>
		<td valign="top"><b>User Groups</b></td>
		<td>
		<% int i=1;
			for (String groupName : emp.getGroups()) {
				if(emp.getGroups().size()>1){
		out.println(i+".");}%> <%=groupName%><br/>
		<%
			i++;}
		%>
		</td>
	</tr>

	<tr>
		<td></td>
	</tr>
</table>


<table>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td colspan="2" width=30% style="align: center; padding: 10px"><a
			type="submit"
			href="/NBG/EmployeeManagementServlet?action=updateReg"
			class="button"><em><b>Change</b></em></a></td>
		<td colspan="2" width=30% style="align: center; padding: 10px"><a
			class="button" type="submit"
			href="/NBG/EmployeeManagementServlet?action=confirm"><em><b>Confirm</b></em></a></td>
		<td colspan="2" width=30% style="padding: 10px"><a href="/NBG/EmployeeManagementServlet?action=cancelReg"
			class="button" onclick="return validateConfirmEmp();"><em><b>&nbsp;&nbsp;Cancel&nbsp;&nbsp;</b></em></a></td>
	</tr>
</table>
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