<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tvm.ilp.t154.cao.model.NonPersonalCustomer" %>
    <%@page import="java.util.List" %>
    <%@page import="java.util.ArrayList" %>
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
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />


<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>

<!--[if lt IE 7]>
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->


</head>
<body id="page5" onload="new ElementMaxHeight();">
<!-- header -->
<jsp:include page="layout/header.jsp" />
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
<table  width=70% cellspacing=10 cellpadding=10 align="center">
<%NonPersonalCustomer npCustomer=(NonPersonalCustomer)request.getAttribute("npCustomer"); %>
<tr>
<td>
Business ID
</td>
<td>
<%=npCustomer.getBusinessId() %>
</td>
</tr>
<tr>
<td>
Business Name
</td>
<td>
<%=npCustomer.getBusinessName() %>
</td>
</tr>
<tr>
<td>
Trading Name
</td>
<td>
<%=npCustomer.getTradingName() %>
</td>
</tr>
<tr>
<td>
Branch ID
</td>
<td>
<%=npCustomer.getBranch().getBranchId() %>
</td>
</tr>
<tr>
<td>
Business Status
</td>
<td>
<%=npCustomer.getBusinessStatus() %>
</td>
</tr>
<tr>
<td>
Business Type
</td>
<td>
<%=npCustomer.getBusinessType() %>
</td>
</tr>
<tr>
<td>
Country of Registration
</td>
<td>
<%=npCustomer.getCountryOfRegistration() %>
</td>
</tr>
<tr>
<td>
Is Startup Business
</td>
<td>
<%=npCustomer.getIsStartUpBusiness() %>
</td>
</tr>
<tr>
<td>
No. of Employees
</td>
<td>
<%=npCustomer.getNoOfEmployees() %>
</td>
</tr>
<tr>
<td>
Tell me more about your Business
</td>
<td>
<%=npCustomer.getTellMoreAboutYourBusiness() %>
</td>
</tr>


</table>
<br>
<br>

<table align="center">
	<tr>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a href="/NBG/CustomerManagementServlet?action=update&&id=<%=npCustomer.getBusinessId() %>"
			class="button" ><em><b>Update</b></em></a>
		</td>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a
			href="/NBG/CustomerManagementServlet?action=delete&&id=<%=npCustomer.getBusinessId() %>" class="button"
			><em><b>Delete</b></em></a></td>
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
<!-- box end --></div>
</div>

<!-- footer -->
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>