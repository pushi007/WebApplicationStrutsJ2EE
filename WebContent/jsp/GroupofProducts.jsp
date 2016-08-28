<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<%@ page import="com.tvm.ilp.t154.cao.model.BusinessType"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@page import="org.example.productdetails.Productdetails"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Products</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/productScript.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/maxheight.js"></script>
<script src="<%=request.getContextPath()%>/js/ProductDscription.js"
	type="text/javascript"></script>
	<script src="<%=request.getContextPath() %>/js/ProductDscription.js"type="text/javascript"></script>

<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

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
											<!--<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Employee</b></p><hr/>
<h4><a href="/NBG/EmployeeManagementServlet?action=register"><b style="font-family: Arial; font-size: 12px;">Register</b></a></h4>
<h4><a href="/NBG/EmployeeManagementServlet?action=view"><b>View Employees</b></a></h4>
	
	<br/><br/>
--><p style="font-family: Arial, Verdana; font-size: 15px;"><b>Product Management</b></p><hr/>
<h4><a href="/NBG/EmployeeManagementServlet?action=closeSession"><b
	style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
<h4> <a href="/NBG/ProductManagementServlet?action=addProduct"><b style="font-family: Arial; font-size: 12px;">Add Product(s)</b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=ViewProduct"><b style="font-family: Arial; font-size: 12px;">View Products</b></a></h4>
<!--<h4><a href="/NBG/ProductManagementServlet?action=viewp"><b style="font-family: Arial; font-size: 12px;">Product Report</b></a></h4>
--><br/>
<p style="font-family: Arial, Verdana; font-size: 13px;"><b>Additional Products</b><br/></p>
<h4><a href="/NBG/ProductManagementServlet?action=additionalProduct" ><b style="font-family: Arial; font-size: 12px;">Add Additional Product</b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=uordap" ><b style="font-family: Arial; font-size: 12px;">Update/Delete Additional Product</b></a></h4>
<!--<h4><a href="/NBG/ProductManagementServlet?action=viewap"><b style="font-family: Arial; font-size: 12px;">Additional Product Report</b></a></h4>

--><br/><br/>
<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Password Management</b></p><hr/>
<h4><a href="/NBG/EmployeeManagementServlet?action=changePwd"><b  style="font-family: Arial; font-size: 12px;">Change Password</b></a></h4>
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
<center>
<h2>Upload Products</h2>
</center>
<hr />
<span align=right>Fields marked with <span style="color: red;">*</span>
are mandatory&nbsp;&nbsp;&nbsp;</span><br>
<br>
<br>

<center>
<%
	String status = (String) request.getAttribute("status");
	boolean flag = false;
	boolean flagInner = true;
	if (status != null) {
%> <b><font color="red"><%=status%></font></b> <%
 	}
 %>
</center>
<br>



<form id="contacts-form5"
	action="/NBG/FileUploadServlet"
	method="post" enctype="multipart/form-data">
<table align="center" cellpadding=10 cellspacing=3 >
	<tr>
		<td><font color="black">Upload XML file :<sup style="color: red;">*</sup>&nbsp;</font>
		<input type="file" name="xml" width="50"></td>
	</tr>

</table>
<br>
<table align="center" cellspacing="5">
	<tr>
		<td colspan="1"><a href="#" class="button"
			onclick="document.getElementById('contacts-form5').submit()"><em><b>Upload</b></em></a></td>
		<td colspan="1"><a type="submit" class="button"
			onclick="return cancelEditValidation();" href="#"><em><b>Cancel</b></em></a></td>
	</tr>
</table>

</form>
<br></br>


<form action="<%=request.getContextPath()%>/FileController"
	method="post">
<table id="table1"  border="1" bordercolor="#D8D8D8"align="left">


	<%
		List<Productdetails.Productdetail> list = (List<Productdetails.Productdetail>) session.getAttribute("list");
		String cnt = (String) session.getAttribute("count");
		if (cnt == null) {
			request.getSession().setAttribute("count", "2");
			int i = 1;
			if (list != null) {
	%>
	<tr><center>Add Products</center></tr>
	<tr style="background-color: #D8D8D8; height: 30px;">
		<th align="center"><b>Serial Number</b></th>
		<th align="center"><b>Product Id</b></th>
		<th align="center"><b>Product Name</b></th>
		<th align="center"><b>product description</b></th>
		<th align="center"><b>account type</b></th>
		<th align="center"><b>product status</b></th>
		<th align="center"><b>valid From</b></th>
	</tr>
	<%
		for (Productdetails.Productdetail c : list) {
	%>
	<tr>
		<td><font color="black"><%=i%></font></td>
		<td><font color="black"><%=c.getproductid()%></font></td>
		<td><font color="black"><%=c.getProductname()%></font></td>
		<td><font color="black"><%=c.getProductdescription()%></font></td>
		<td><font color="black"><%=c.getAccounttype()%></font></td>
		<td><font color="black"><%=c.getProductstatus()%></font></td>
		<td><font color="black"><%=c.getValidFrom()%></font></td>
	</tr>
	<%
		i++;
				}
	%><tr>
		<td  colspan="7" align="center"><input type="submit" value="submit"    onclick="return confirm('Are you sure you want to submit')" /></td>
	</tr>
	<%
		}
		}
	%>



</table>
<input type="hidden" name="action" <%if (flagInner) {%>
	value="submitdetails" <%} else {%> value="nosubmitdetails" <%}%> /> <%
 	if (list != null) {
 %>
<div style="cursor: pointer">
<div id="pageNavPosition"><script type="text/javascript">
	        	var pager = new Pager('table1',6); 
	        	pager.init(); 
	        	pager.showPageNav('pager','pageNavPosition'); 
	        	pager.showPage(1);
				</script></div>
</div>
<%
	}
%>
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
<div style="margin-top: 15px"></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>