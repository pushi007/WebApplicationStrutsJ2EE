<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tvm.ilp.t154.cao.model.NonPersonalCustomer"%>
<%@page import="com.tvm.ilp.t154.cao.model.Branch"%>
<%@page import="com.tvm.ilp.t154.cao.model.NPAddress"%>
<%@page import="com.tvm.ilp.t154.cao.model.NPContacts"%>
<%@page import="com.tvm.ilp.t154.cao.model.NPProofOfDocument"%>
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

<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/UpdateContactDetailsValidation.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/registration.js" type="text/javascript"></script>
<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->
<title>Insert title here</title>
</head>
<body id="page5" >
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
<a href="#" onclick="return validateMyPortal();" style="font-size-adjust: inherit"><span style="font-size:12px">My Portal</span></a>
	<br /><br />
	<a href="#" onclick="return validateFind();" style="font-size-adjust: inherit"><span style="font-size:12px">Find
	Business</span></a><br /><br />
	<a href="/NBG/AccountPartyManagementServlet?action=Display_Business_Cust_Detail" style="font-size-adjust: inherit"><span style="font-size:12px">Account Parties</span></a>
<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br/>
	<br>
	</br>
	
	
	
	
	
	
<input type="hidden" />	

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
<h2>Business Customer Profile Updation</h2>
<form name="updateContactDetails_form"
	action="/NBG/CustomerManagementServlet" method="post">


<hr/>
<input type="hidden" name="action" value="updateworkdatacontact" />
<%NonPersonalCustomer npCustomer=(NonPersonalCustomer)session.getAttribute("npCustomer"); %>
<h3 style="align:center"><font color="#8A3E08"><b> Contact
Details</b><br/>
</font></h3>

<span style="align:right"><b>Fields marked with <span
	style="color: red;">*</span> are mandatory</b>&nbsp;&nbsp;&nbsp;</span>
	
<br />
<br />
<table style="align:center" style="height: 100%;" cellpadding="5">

	<%for(NPContacts npContacts:npCustomer.getNpContactList()){ %>
	<%if(npContacts.getContactType().equalsIgnoreCase("work")){ %>
	<tr>
		<td><b>Contact No</b>(Landline)<sup><span style="color:red">*</span></sup></td>
		<td><input type="text" name="concountrycode" onblur="return validWorkCountryCode();"
			value=<%=npContacts.getCountryCode()%> size=3 /> <input type="text"
			onblur="return validWorkCityCode();" name="conareacode" value=<%=npContacts.getAreaCode() %> size=6 />
		<input type="text" name="conno" value=<%=npContacts.getContactNo() %>
			title="Business name should contain only alphabets" size="15"
			onblur="return validWorkTelephoneNumber();" /><label style="color:red;" id="error_contact"></label></td>
	</tr>
	<%} %>
	<%if(npContacts.getContactType().equalsIgnoreCase("fax")){ %>
	<tr>
		<td><b>FAX No<sup><span style="color:red">*</span></sup></b></td>

		<td><input type="text" name="faxcountrycode" onblur="return validFaxCountryCode();"
			value=<%=npContacts.getCountryCode() %> size=3 /> <input type="text"
			name="faxareacode" onblur="return validFaxCityCode();" value=<%=npContacts.getAreaCode() %> size=6 /> <input
			type="text" name="faxno" value=<%=npContacts.getContactNo() %>
			title="Business name should contain only alphabets" size="15"
			onblur="return validFaxTelephoneNumber();" /><label style="color:red;" id="error_fax"></label></td>


	</tr>
	<%} %>
	<%} %>
	<tr>
		<td><b>Business Email Address<sup><span style="color:red">*</span></sup></b></td>
		<td><input type="text" onblur="return validEmail();" name="bemail" value=<%=npCustomer.getEmail()%> title="Business name should contain only alphabets" onblur="validateBusinessEmail() ;" /><label style="color:red;" id="error_bemail"></label></td>
		
	</tr>
</table>

<table style="align:center;">
	<tr>
		<td colspan="2" style="align: center; width: 30%; padding: 10px;"><a
			type="submit" class="button"
			onclick="return validateContactDetails();"><em><b>Continue</b></em></a>
		</td>
		<td colspan="2" style="align: center; width: 30%; padding: 10px;"><a href="/NBG/CustomerManagementServlet?action=viewdetails&&id=<%=npCustomer.getBusinessId() %>" class="button"><em><b>Cancel</b></em></a></td>
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
<!-- box end --></div>
</div>

<!-- footer -->
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>

</html>