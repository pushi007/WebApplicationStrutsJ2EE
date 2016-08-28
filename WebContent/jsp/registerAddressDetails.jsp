<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.tvm.ilp.t154.cao.model.*"%>
<%@page import="java.util.*"%>
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
<title>Address Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />

<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/registration.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/AddressValidation.js" type="text/javascript"></script>
<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->
<title>Nexus Banking Group</title>
</head>
<body id="page5">
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
	Business</span></a>

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
	<br>
	</br>
	<br/>
	<br>
	
	
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
<h2>Business Customer Registration</h2>
<hr/>
<%
List<Country> countryList=new ArrayList<Country>(); 


countryList=(List<Country>)session.getAttribute("countryList");%>
<form name="regperaddress_form" method="post"
	action="/NBG/CustomerManagementServlet"
	onsubmit="return  validateform();">


<input type="hidden" name="action" value="registerAddressPermanent" ></input>

<h3 align="left"><font color="#8A3E08"><b>Capture Business
Address</b><br>
</font></h3>
<span style="align: right"><b>Fields marked with <span
	style="color: red;">*</span> are mandatory</b>&nbsp;&nbsp;&nbsp;</span><br></br>
<table style="height: 100%;" cellpadding="5">

	<tr>
		<td><b>Building Number<sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="bnoper" tabindex="1" title="Enter Building Number "
			onblur="return validateBuildingNoPermanent();" /></td>
			<td class="label"><label id="err_bnoper"></label></td>
	</tr>
	<tr>
		<td><b>Building Name<sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="bnameper" tabindex="2" 
			title="Enter name of Building "
			onblur="return validateBuildingNamePermanent();" /></td>
		<td class="label"><label id="err_bnameper"></label></td>
	</tr>

	<tr>
		<td><b>Street Name<sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="snameper" tabindex="3" 
			title="Enter name of Street "
			onblur="return validateStreetNamePermanent();" /></td>
		<td class="label"><label id="err_snameper"></label></td></tr>
	<tr>

		<td><b>Town</b></td>
		<td><input type="text" name="townper" title="Enter name of Town" tabindex="4" 
			onblur="return validateTownPermanent();" /></td>
		<td class="label"><label id="err_townper"></label></td>
	</tr>

	<tr>
		<td><b>City<sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="cityper" title="Enter name of city " tabindex="5" 
			onblur="return validateCityPermanent()" /></td>
		<td class="label"><label id="err_cityper"></label></td>
	</tr>

	<!--<tr>
		<td><b>Country<sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="countryper"
			title="Enter name of country" onblur="validateCountryPermanent();" /></td>
		<td class="label"><label id="err_countryper"></label></td>
	</tr>
	--><tr>
		<td><b>Country<sup><font color="red">*</font></sup></b></td>
		<td><select id="creg" name="countryper" tabindex="6"  onblur="return validateCountryPermanent();">
			<option value="0" selected="selected">Please Select</option>
			<%for(Country country:countryList) {%>
			<option value="<%=country.getCountryName()%>"><%=country.getCountryName()%></option>
		<%} %>
			
		</select></td>
		<td class="label"><label id="error_country"></label></td>
	</tr>
	<tr>
		<td><b>Postal Code<sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="pcodeper" tabindex="7"  title="Enter postal code"
			onblur="return validatePostalCodePermanent();" /></td>
		<td class="label"><label id="err_pcodeper"></label></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<td>Is your Registered Address same as your Business Address?
		<font color="red">*</font></td>
		<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="radio" name="simcheckpresent" tabindex="8"  value="Yes"></input>Yes <input
			type="radio" name="simcheckpresent" tabindex="9"  value="No"></input>No</td>
			<td class="label"><label id="err_simchkpresent"></label></td>
	</tr>
</table>
<table>
	<tr>
		<td>Is your Correspondence Address same as your Business
		Address?<font color="red">*</font></td>
		<td colspan="2"><input type="radio" id="corpersameyes" name="simcheckcorr" tabindex="10" 
			value="Yes"></input>Yes <input type="radio" name="simcheckcorr" tabindex="11"
			value="No"></input>No</td>
			<td class="label"><label id="err_simchkcorr"></label></td>
	</tr>
</table>
<table >
	<tr>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a
			type="submit" class="button" tabindex="12"  onclick="return validateformper();"
><em><b>Continue</b></em></a>
		</td>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a
		 class="button" tabindex="13"  onclick="document.regperaddress_form.reset();"
><em><b>Reset</b></em></a></td>
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