<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="com.tvm.ilp.t154.cao.model.*"%>

<%@ page import="static com.tvm.ilp.t154.cao.constants.CAOConstants.*"%>
<%@ page import="java.util.*"%>
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
<html>
<head>
<title>Business Account Parties Registration</title>

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
	<script src="<%=request.getContextPath()%>/js/registration.js"
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
<a href="#" onclick="return validateMyPortal();" style="font-size-adjust: inherit"><span style="font-size:12px">My Portal</span></a>
	<br /><br />
	<a href="#" onclick="return validateFindSummary();" style="font-size-adjust: inherit"><span style="font-size:12px">Find
	Business</span></a><br /><br />
	<a href="/NBG/AccountPartyManagementServlet?action=Display_Business_Cust_Detail" style="font-size-adjust: inherit"><span style="font-size:12px">Account Parties</span></a>


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
 Customers customer = (Customers) request.getSession().getAttribute("npCustomerDetails");
Customers customers = (Customers) request.getSession().getAttribute("CustomerId");
  %>



<!--<%if(npCustomer.getBusinessId()!=0){ %>
<h5 style="text-align:center">Business Id - <%=npCustomer.getBusinessId() %></h5>
<% }%>
<h5 style="text-align:center">Business Name - <%=npCustomer.getBusinessName() %></h5>
<h5 style="text-align:center">Branch Name - <%=npCustomer.getBranch().getBranchName()%></h5>

--><table width="90%"
	style="align: center; font-family: Arial, Verdana; font-size: 13px; color: #8A3E08">
	<tr>
		<td align="left"><b>Business Name - <%=npCustomer.getBusinessName() %></b></td>
		<td align="right"><b>Branch Name - <%=npCustomer.getBranch().getBranchName()%></b></td>
	</tr>
</table>
<br/>
<hr></hr>

<table  width="100%" >
	<tr>
		<td
			style="width: 80%; font-family: Arial, Verdana; font-size: 16px; color: #8A3E08; align: left"><b>Core
		Details</b></td>
		<%if(!npCustomer.isHasAccount()) {%>
		<td colspan="1"  style="align: right; width:20%; padding: 10px"><a
			href="/NBG/CustomerManagementServlet?action=updatecoredetails" class="button"><em><b>Edit</b></em></a></td>
	<%} %>
	</tr>
</table>

<table  cellpadding=10 cellspacing=10>
	<tr>
		<td align="left"><b>Business Name</b></td>
		<td align="left"><%=npCustomer.getBusinessName()%></td>
	</tr>

	<tr>
		<td align="left"><b>Trading Name</b></td>
		<td align="left"><%=npCustomer.getTradingName()%></td>
	</tr>

	<tr>
		<td align="left"><b>Business Type</b></td>
		<td align="left"><%=npCustomer.getBusinessType()%></td>
	</tr>
	<tr>
		<td align="left"><b>Total business capital</b>(in million pounds)</td>
		<td align="left"><%=npCustomer.getTotalBusinessCapital()%></td>
	</tr>
	<tr>
		<td align="left"><b>Annual turn over</b>(in million pounds)</td>
		<td align="left"><%=npCustomer.getExpectedAnnualTurnover()%></td>
	</tr>
	<%if(npCustomer.getNoOfEmployees()!=0){ %>
	<tr>
		<td align="left"><b>No of employees</b></td>
		<td align="left"><%=npCustomer.getNoOfEmployees()%></td>
	</tr>
	<%} %>
</table>
<hr></hr>


<table  width="100%">
	<tr>
		<td
			style="width: 80%; font-family: Arial, Verdana; font-size: 16px; color: #8A3E08; align: left"><b>
		 Additional Details</b></td>
		 <%if(!npCustomer.isHasAccount()) {%>
		<td colspan="1"  style="align: right; width:20%; padding: 10px"><a
			href="/NBG/CustomerManagementServlet?action=updateadditionaldetails" class="button"><em><b>Edit</b></em></a></td>
	<%} %>
	</tr>
</table>

<table  cellpadding=10 cellspacing=10>
	<tr>
		<td align="left"><b>Industry Sector</b></td>
		<td align="left"><%=npCustomer.getIndustrySector()%></td>
	</tr>

	<tr>
		<td align="left"><b>Main Activity</b></td>
		<td align="left"><%=npCustomer.getMainActivity() %></td>
	</tr>

	<tr>
		<td align="left"><b>Precise Activity</b></td>
		<td align="left"><%=npCustomer.getPreciseActivity() %></td>
	</tr>
	<%if(npCustomer.getRequireFunding().equalsIgnoreCase("yes")){ %>
    <tr>
		<td align="left"><b>Fund Amount</b>(in thousand pounds)</td>
		<td align="left"><%=npCustomer.getFundAmount()%></td>
	</tr>
	<%} %>
	<tr>
		<td align="left"><b>Are part of any group/franchise</b></td>
		<td align="left"><%=npCustomer.getPartOfGroup()%></td>
	</tr>
	<%if(npCustomer.getPartOfGroup().equalsIgnoreCase("yes")){ %>
	<tr>
		<td align="left"><b>Detail of group/franchise</b></td>
		<td align="left"><%=npCustomer.getFranchiseDetails()%></td>
	</tr>
	<%} %>
</table>
<hr/>

<%for(NPAddress npAdd:npCustomer.getNpAddressList()) {%>
<table  width="100%">

	<tr>
		<td
			style="width: 80%; font-family: Arial, Verdana; font-size: 16px; color: #8A3E08; align: left"><b>
		<%=npAdd.getAddressType() %> Address Details</b></td>
		<%if(!npCustomer.isHasAccount()) {%>
		<%if(!npAdd.getAddressType().equalsIgnoreCase("registered")){ %>
		<td colspan="1"  style="align: right; width:20%; padding: 10px"><a
			href="/NBG/CustomerManagementServlet?action=<%="update"+npAdd.getAddressType()+"address" %>" class="button"><em><b>Edit</b></em></a></td>
         <%} %><%} %>
	</tr>
</table>

<table  cellpadding=10 cellspacing=10>
	<tr>
		<td align="left"><b>Building No. and Name</b></td>
		<td align="left"><%=npAdd.getBuildingNo()+","+npAdd.getBuildingName()%></td>
	</tr>

<tr>
		<td align="left"><b>Address</b></td>
		<td align="left"><%=npAdd.getStreetName()+", "+npAdd.getCity()+", "%><br/>
		<%=npAdd.getPostalCode()%><br/><%=npAdd.getCountry() %>
		</td>
	</tr>

	
</table>
<%} %>
<hr/>
<%int i=0;
for(NPContacts npCon:npCustomer.getNpContactList()){i++; %>
<table width="100%">

	<tr>
		<td
			style="width: 80%; font-family: Arial, Verdana; font-size: 16px; color: #8A3E08; align: left"><b>
	<%if(i<=1) {%> Contact Details</b></td>
	<%if(!npCustomer.isHasAccount()) {%>
		<td colspan="1"  style="align: right; width:20% padding: 10px"><a
			href="/NBG/CustomerManagementServlet?action=<%= "update"+npCon.getContactType()+"contact" %>" class="button"><em><b>Edit</b></em></a></td>
	<%} %>
	<%} %>
	</tr>
</table>

<table  cellpadding=10 cellspacing=10>
	
	<tr>
		<td align="left"><b><%=npCon.getContactType() %> <%if(npCon.getContactType().equalsIgnoreCase("work")){ %>Contact<%} %> No.</b></td>
		<td align="left"><%=npCon.getCountryCode()+ Integer.parseInt(npCon.getAreaCode())+npCon.getContactNo()%></td>
	</tr>

	<%if(i<=1){ %>
	<tr>
		<td align="left"><b>Email Address</b></td>
		<td align="left"><%=npCustomer.getEmail()%></td>
	</tr>
<% }%>

</table>
<%} %>


<%if (npCustomer.getBusinessId() == 0) {%>
<table>
	<tr>
		<td><%=customer.getProofOfId()%></td>
	</tr>
	<tr>
		<td><%=customer.getProofOfAddress()%></td>
	</tr>
</table>
<%}%> 
<%if (npCustomer.getBusinessId() != 0) { %>
<table>
	<tr>
		<td><%=customers.getProofOfId()%></td>
		<td><a href="/NBG/CustomerManagementServlet?action=viewimg&&id=<%=customers.getCustomerID() %>" target="_blank">View
		Image</a></td>
	</tr>
	<tr>
		<td><%=customers.getProofOfAddress()%></td>
		<td><a href="/NBG/CustomerManagementServlet?action=viewimg1&&id=<%=customers.getCustomerID() %>"" target="_blank">View
		Image</a></td>
	</tr>
</table>
<%}%> 

<%if(npCustomer.getBusinessId()==0){ %>
<table >

	<tr>
		<td colspan="2"  style="align: center; width:30%; padding: 10px"><a
			href="/NBG/CustomerManagementServlet?action=confirm" class="button"><em><b>Confirm</b></em></a></td>
		<td colspan="2"  style="align: center; width:30%; padding: 10px"><a
			href="/NBG/CustomerManagementServlet?action=find" class="button"><em><b>Cancel</b></em></a></td>
	</tr>
	
	</table>
	<%} %>
	
<%if(npCustomer.getBusinessId()!=0){ %>
<%if(!npCustomer.isHasAccount()) {%>
<table width=100%>
	<tr>
		<td  style="align: left; padding: 10px;width:10%"><a type="submit" class="button" href="/NBG/CustomerManagementServlet?action=update"><em><b>&nbsp;&nbsp;Save&nbsp;&nbsp;</b></em></a></td>
		<td style="align: left; padding: 10px;width:10%"><a type="submit" class="button" href="/NBG/CustomerManagementServlet?action=delete&&id=<%=npCustomer.getBusinessId() %>" onclick="return validateDelete();"><em><b>&nbsp;&nbsp;Delete&nbsp;&nbsp;</b></em></a></td>
		<td  style="align: left; padding: 10px;width:10%"><a type="submit" class="button" href="/NBG/jsp/searchBusinessCustomer.jsp"><em><b>&nbsp;&nbsp;Cancel&nbsp;&nbsp;</b></em></a></td>
			<td  style="align: right; padding: 10px;width:10%"><a href="/NBG/AccountPartyManagementServlet?action=Display_Business_Cust_Detail"
			class="button"><em><b>
		&nbsp;&nbsp;Continue&nbsp;&nbsp;</b></em></a></td>
		</tr>
		</table>
		
		<%} else{%>
		<table width=30%>
	<tr>
		
			<td  style="align: right; padding: 10px;width:10%"><a href="/NBG/AccountPartyManagementServlet?action=Display_Business_Cust_Detail"
			class="button"><em><b>
		&nbsp;&nbsp;Continue&nbsp;&nbsp;</b></em></a></td>
		</tr>
		</table>
		<%} %>
		
	
<%} %><!--	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<table >
	
	<tr>
		<td width="20%"colspan="2" style="align: center; width:30%; padding: 10px"><a
			href="/NBG/CustomerManagementServlet?action=update" class="button"><em><b>Confirm</b></em></a></td>
		
		<td width="20%" colspan="2"  style="align: center; width:30%; padding: 10px"><a
			href="/NBG/CustomerManagementServlet?action=delete&&id=<%=npCustomer.getBusinessId() %>" class="button"><em><b>Delete</b></em></a></td>
		
		<td width="20%"colspan="2"  style="align: center; width:30%; padding: 10px"><a
			href="/NBG/jsp/RegistrationPortal.jsp" class="button"><em><b>Cancel</b></em></a></td>
	
	<td  width="30%" colspan="2"  style="align: center; width:30%; padding: 10px"><a
			href="/NBG/AccountPartyManagementServlet?action=Display_Business_Cust_Detail" class="button"><em><b>Account Parties</b></em></a></td>
	
	</tr>

</table>




--></div>
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















