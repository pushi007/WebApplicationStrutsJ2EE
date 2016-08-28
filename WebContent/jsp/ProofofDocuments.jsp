<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Address Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description"
	content="Consulting page - free business website template from Template Monster is awating for you to download." />
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/maxheight.js"></script>
<link href="<%=request.getContextPath()%>/css/layout.css"
	rel="stylesheet" type="text/css" />

<script
	src="<%=request.getContextPath()%>/js/ContactDetailsRegValidation.js"
	type="text/javascript"></script>
	
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
<div class="inner"><a href="#"
	onclick="return validateMyPortal();" style="font-size-adjust: inherit"><span
	style="font-size: 12px">My Portal</span></a> <br />
<br />
<a href="#" onclick="re
	turn validateFind();;
le="font-size-adjust:inherit"><span
	style="font-size: 12px">Find Business</span></a> <br> </br>
<br> </br>
<br> </br>
<br> </br>
<br> </br>
<br> </br>
<br> </br>
<br> </br>
<br> </br>
<br />
<br> </br>
<br />
<br> </br>




<input type="hidden" /></div>
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

<hr></hr>
<h3><font color="#8A3E08"><b>Upload Documents</b><br />
</font></h3>
<span style="align: right"><b>Fields marked with <span
	style="color: red;">*</span> are mandatory</b>&nbsp;&nbsp;&nbsp;</span><br />
<br />
<form name="uploadImage" id="contacts-form5"
	action="<%=request.getContextPath()%>/ImageControllerServlet"
	method="post" enctype="multipart/form-data"
	>
<input type="hidden" name="action" value="uploadimg"></input>
<table style="height: 100%;" cellpadding="10" cellspacing="10">


	<tr>
		<td><font color="black">Proof of identity<sup
			style="color: red;">*</sup></font></td>
		<td><select name="idproof" id="idproof">
			<option value="Select">-select-</option>
			<option value="ITR Return Statement">ITR Return Statement</option>
			<option value="Utility Bill">Utility Bill</option>
			</select></td>
			<td style="color:red; " id="error_idtype"></td>
			
	</tr>


	<tr>
		<td><font color="black">Proof of ID (Image)<sup
			style="color: red;">*</sup></font></td>
		<td><input type="file" name="image" id="image" /></td>
		<td style="color:red; " id="error_id"></td>
	</tr>


	<tr>
		<td><font color="black">Proof of address<sup
			style="color: red;">*</sup></font></td>
		<td><select name="addproof" id="addproof">
			<option value="Select">-select-</option>
			<option value="ITR Return Statement">ITR Return Statement</option>
			<option value="Utility Bill">Utility Bill</option>

		</select></td>
		<td style="color:red;" id="error_addtype"></td>
			
	</tr>

	<tr>
		<td><font color="black">Proof of address (Image)<sup
			style="color: red;">*</sup></font></td>
		<td><input type="file" name="image1" id="image1"></input></td>
		<td style="color:red; " id="error_address"></td>
	</tr>


	<tr>
		<td></td>

		<tr>
			<td colspan="1" style="padding: 10px;"><a href="#"
				class="button" onclick="return formValidator();"><em><b>Upload</b></em></a></td>
			<td align="left"><a href="#" class="button"
				onclick="document.getElementById('contacts-form5').reset();"><em><b>Reset</b></em></a></td>
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
<div style="margin-top: 15px"></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>

</html>