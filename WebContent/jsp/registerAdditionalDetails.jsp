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

<script src="<%=request.getContextPath()%>/js/regadditional.js"
	type="text/javascript"></script>
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
	</br>
	<br/>
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
<form name="regadditional_form" method="post""
	action="/NBG/CustomerManagementServlet"
	onSubmit="return  validateform();">


<hr>
<h3 ><font color="#8A3E08"><b>
Capture Additional Details</b><br>
</font></h3>
<span style="align: right;"><b>Fields marked with <span
	style="color: red;">*</span> are mandatory</b>&nbsp;&nbsp;&nbsp;</span><br>
<br>
<input type="hidden" name="action" value="registerAdditional" />
<table  style="height: 100%;" cellpadding="5">

	<tr>
		<td><b>Industry Sector<sup><font color="red">*</font></sup></b></td>
		<td><select id="edate" name="industrySector" tabindex="1" onblur="return validateIndustrySec();">
			<option value="0" selected>Please Select</option>
			<option value="Primary(Extractive)">Primary(Extractive)</option>
			<option value="Secondary(Manufacturing)">Secondary(Manufacturing)</option>
			<option value="Tertiary(Service)">Tertiary(Service)</option>
		</select><label style="color:red;" id="error_industrysector"></label></td>
	
	</tr>



	<tr>
		<td><b>Main Activity <sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="mainActivity" tabindex="2" title="Enter Main Activity of Business" onblur="return validateMainActivity();"/><label style="color:red;" id="error_mainActivity"></label></td>
		
	</tr>

	<tr>
		<td><b>Precise Activity <sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="preciseActivity" tabindex="3"
			 title="Enter Precise Activity of Business" onblur="return validatePreciseActivity();"/><label style="color:red;"  id="error_preciseActivity"></label></td>
		
	</tr>

	<tr>
		<td><b>Do you Import or Export Goods?<sup><font
			color="red">*</font></sup></b></td>
		<td><input type="radio" name="importExport" tabindex="4"  value="Yes" onblur="return doImportExport();"/>Yes <input
			type="radio" name="importExport" value="No" />No<label  style="color:red;"  id="error_importExport"></label></td>
			
	</tr>

	<tr>
		<td><b>Does your Business require Funding?</b><sup><font color="red">*</font></sup></td>
		<td><input type="radio" id="yes" name="requireFunding" tabindex="5" value="Yes" onblur="return doRequireFund();" onclick="reg();">Yes </input><input type="radio" id="no" name="requireFunding" tabindex="6" value="No" onblur="return doRequireFund();" onclick="reg();">No</input>
		<label style="color:red;" id="error_fund"></label></td>
		
	</tr>

	<tr>
		<td><b>How much Funding do you require?</b><br/>(in Thousand Pounds )<sup>*</sup></td>
		<td><input type="text" name="fundAmount"  title="Enter Funding Amount required"  tabindex="7" disabled="disabled" onchange="return validateFundingAmount();" /><label style="color:red;" id="error_fundamount"></label></td>
	</tr>



	<tr>
		<td><b>Are you a part of a Group or a Franchise?</b><sup><font
			color="red">*</font></sup></td>
		<td><input type="radio" id="partFranchiseYes" name="partOfGroup" tabindex="8" value="Yes" onblur="return arePartOfGroup();" onclick="reg();"/>Yes <input
			type="radio" id="partFranchiseNo" name="partOfGroup" value="No" onblur="return arePartOfGroup();" onclick="reg();"/>No<label style="color:red;" id="error_part"></label></td>
	</tr>

	<tr>
		<td><b>Franchise Details</b></td>
		<td><textarea rows="5" cols="25" name="franchiseDetails" tabindex="8"  title="Enter Franchise Details" onchange="return validatePartGroup();"></textarea><label style="color:red;" id="error_groupdetails"></label></td>
	</tr>
</table>
<table>
<tr>
<td>
*could be upto 5 Million Pounds depending on conditions.
</td>
</tr>
</table>



<table>
	<tr>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a
			type="submit" class="button" tabindex="9"
			onclick="return validateRegAdditionalForm();"><em><b>Continue</b></em></a>
		</td>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a
			href="/NBG/" class="button" tabindex="10"
			onclick="document.regadditional_form.reset();"><em><b>Reset</b></em></a></td>
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