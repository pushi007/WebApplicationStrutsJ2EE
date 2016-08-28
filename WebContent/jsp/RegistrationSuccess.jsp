<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="com.tvm.ilp.t154.cao.model.*"%>

<%@ page import="static com.tvm.ilp.t154.cao.constants.CAOConstants.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
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
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

</head>

<body id="page5" onload="new ElementMaxHeight();">

<!-- header -->
<jsp:include page="./layout/header.jsp"></jsp:include>
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
<a href="/NBG/CustomerManagementServlet?action=accopenerportal" style="font-size-adjust: inherit"><span style="font-size:12px">My Portal</span></a>
	<br /><br />
	<a href="/NBG/CustomerManagementServlet?action=find" style="font-size-adjust: inherit"><span style="font-size:12px">Find
	Business </span></a><br /><br />
	<a href="/NBG/CustomerManagementServlet?action=registersuccess" style="font-size-adjust: inherit"><span style="font-size:12px">Business Summary</span></a><br/><br/>
	<a href="/NBG/AccountPartyManagementServlet?action=Display_Business_Cust_Detail" style="font-size-adjust: inherit"><span style="font-size:12px">Account Party</span></a>


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
<h3
	style="align: center; font-family: Arial, Verdana; font-size: 16px; color: #000">Business
Customer Profile</h3>




<%NonPersonalCustomer npCustomer=(NonPersonalCustomer)session.getAttribute("npCustomer"); 
 String message=(String)session.getAttribute("message");  
  %>



<!--<%if(npCustomer.getBusinessId()!=0){ %>
<h5 style="text-align:center">Business Id - <%=npCustomer.getBusinessId() %></h5>
<% }%>
<h5 style="text-align:center">Business Name - <%=npCustomer.getBusinessName() %></h5>
<h5 style="text-align:center">Branch Name - <%=npCustomer.getBranch().getBranchName()%></h5>

--><table width="90%"
	style="align: center; font-family: Arial, Verdana; font-size: 13px; color: #8A3E08">
	<tr>
		<%if(npCustomer.getBusinessId()!=0){ %>
<td><h5 style="text-align:left">Business Id - <%=npCustomer.getBusinessId() %></h5></td>
<% }%>
		<td align="center"><b>Business Name - <%=npCustomer.getBusinessName() %></b></td>
	
		<td align="right"><b>Branch Name - <%=npCustomer.getBranch().getBranchName()%></b></td>
	</tr>
</table>
<br/>
<hr></hr>
<%

if(message!=null){
	
	out.println(message);
	
}


%>




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
</div>
</div>
<!-- footer -->
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>















