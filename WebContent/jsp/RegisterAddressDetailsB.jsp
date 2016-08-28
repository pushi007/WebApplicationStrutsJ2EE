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
<title>Nexus Banking Group</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description"
	content="Consulting page - free business website template from Template Monster is awating for you to download." />
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/registration.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/AddressValidation.js" type="text/javascript"></script>
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
	<br/>
	
	
	
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
<%
List<Country> countryList=new ArrayList<Country>(); 


countryList=(List<Country>)session.getAttribute("countryList");%>
<form name="regcoraddress_form"
	action="/NBG/CustomerManagementServlet"
	method="post" onSubmit="return  validateform();">
<hr>
<input type="hidden"  name="action" value="registerAddressCorrespondence"/>

<br>

<h3 ><font color="#8A3E08"><b>Capture Correspondence
Address</b><br>
</font></h3>
<span style="align: right"><b>Fields marked with<span
	style="color: red;">*</span> are mandatory</b> &nbsp;&nbsp;&nbsp;</span><br></br>
<table  style="height: 100%;" cellpadding="5">



	<tr>
		<td><b>Building Number<sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="bnocor" tabindex="1"
		title="Enter Building Number " onblur="return validBuildingNoCorr();"/><label style="color:red;" id="err_bnocor"></label></td>
		
	</tr>
	<tr>
		<td><b>Building Name<sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="bnamecor" tabindex="2"
		title="Enter name of Building" onblur="return validBuildingNameCorr();" /><label style="color:red;" id="err_bnamecor"></label></td>
		
	</tr>
	
	<tr>
		<td><b>Street Name<sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="snamecor" tabindex="3"
		title="Enter Street Name " onblur="return validStreetNameCorr();"/><label style="color:red;" id="err_snamecor"></label></td>
		
	</tr>
	
	<tr>
		<td><b>Town</b></td>
		<td><input type="text" name="towncor" tabindex="4"
		title="Enter name of town" onblur="return validTownCorr();"/><label style="color:red;" id="err_towncor"></label></td>
		
	</tr>
	
	<tr>
		<td><b>City<sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="citycor" tabindex="5"
		title="Enter name of city " onblur="return validCityCorr();"/><label style="color:red;" id="err_citycor"></label></td>
		
	</tr>
	<tr>
		<td><b>Country<sup><font color="red">*</font></sup></b></td>
		<td><select id="creg" name="countrycor" tabindex="6" onblur="return validcountryCorr();">
			<option value="0" selected="selected">Please Select</option>
			<%for(Country country:countryList) {%>
			<option value="<%=country.getCountryName()%>"><%=country.getCountryName()%></option>
		<%} %>
			
		</select><label style="color:red;" id="error_countrycor"></label></td>
		
	</tr>
	<!--<tr>
		<td><b>Country<sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="countrycor"
		title="Enter name of country " /></td>
		<td><label id="err_countrycor"></label></td>
	</tr>
	
	--><tr>
		<td><b>Postal Code<sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="pcodecor"
		title="Enterm Postal code " onblur="return validPostalCodeCorr();"/><label style="color:red;" id="err_pcodecor"></label></td>
		
	</tr>




	
</table>

<table >
	<tr>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a type="submit"
			class="button" tabindex="7" onclick="return validateCorrAddres();"><em><b>Continue</b></em></a>
		</td>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a
			 class="button" tabindex="8"
			onclick="document.regcoraddress_form.reset();"><em><b>Reset</b></em></a></td>
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