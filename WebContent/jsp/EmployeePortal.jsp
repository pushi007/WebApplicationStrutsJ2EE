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
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

</head>

<body id="page5" onload="new ElementMaxHeight();">
<!-- header -->
<jsp:include page="layout/header.jsp"></jsp:include>
<!-- content -->
<div id="content">
<div class="container"><!-- main-banner-small begin -->
<div class="main-banner-small">
<div class="inner">
<h1><%String tagLinehl=(String)session.getAttribute("tagLinehl");if(tagLinehl!=null){out.println(tagLinehl);}else{ %>The bank for a changing world.<%} %></h1>
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

<p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String keyEmployeewa=(String)session.getAttribute("keyEmployeewa");if(keyEmployeewa!=null){out.println(keyEmployeewa);}else{ %>Employee<%} %></b></p>
<hr>
<h4><a href="/NBG/EmployeeManagementServlet?action=register"><b
	style="font-family: Arial; font-size: 13px;"><%String keyRegisterLinkwa=(String)session.getAttribute("keyRegisterLinkwa");if(keyRegisterLinkwa!=null){out.println(keyRegisterLinkwa);}else{ %>Register<%} %></b></a></h4>
<h4><a href="/NBG/EmployeeManagementServlet?action=view"><b style="font-family: Arial; font-size: 12px;"><%String keyViewEmployeewa=(String)session.getAttribute("keyViewEmployeewa");if(keyViewEmployeewa!=null){out.println(keyViewEmployeewa);}else{ %>View Employees<%} %></b></a></h4>


<br />
<br />
<p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String keyProductwa=(String)session.getAttribute("keyProductwa");if(keyProductwa!=null){out.println(keyProductwa);}else{ %>Product
Management<%} %></b></p>
<hr>
<h4><a href="/NBG/ProductManagementServlet?action=addProduct"><b
	style="font-family: Arial; font-size: 12px;"><%String keyAddProductswa=(String)session.getAttribute("keyAddProductswa");if(keyAddProductswa!=null){out.println(keyAddProductswa);}else{ %>Add Product(s)<%} %></b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=ViewProduct"><b
	style="font-family: Arial; font-size: 12px;"><%String keyViewProductswa=(String)session.getAttribute("keyViewProductswa");if(keyViewProductswa!=null){out.println(keyViewProductswa);}else{ %>View Products<%} %></b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=viewp"><b
	style="font-family: Arial; font-size: 12px;"><%String keyProductReportwa=(String)session.getAttribute("keyProductReportwa");if(keyProductReportwa!=null){out.println(keyProductReportwa);}else{ %>Product Report<%} %></b></a></h4>
<br />

<h4><a
	href="/NBG/ProductManagementServlet?action=additionalProduct"><b
	style="font-family: Arial; font-size: 12px;"><%String keyAddAdditionalProductwa=(String)session.getAttribute("keyAddAdditionalProductwa");if(keyAddAdditionalProductwa!=null){out.println(keyAddAdditionalProductwa);}else{ %>Add Additional Product<%} %></b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=uordap"><b
	style="font-family: Arial; font-size: 12px;"><%String keyUpdateDeleteAdditionalProductwa=(String)session.getAttribute("keyUpdateDeleteAdditionalProductwa");if(keyUpdateDeleteAdditionalProductwa!=null){out.println(keyUpdateDeleteAdditionalProductwa);}else{ %>Update/Delete
Additional Product<%} %></b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=viewap"><b
	style="font-family: Arial; font-size: 12px;"><%String keyAdditionalProductReportwa=(String)session.getAttribute("keyAdditionalProductReportwa");if(keyAdditionalProductReportwa!=null){out.println(keyAdditionalProductReportwa);}else{ %>Additional Product
Report<%} %></b></a></h4>

<br />
<br />

<p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String keychart=(String)session.getAttribute("keychart");
if(keychart!=null){out.println(keychart);}else {%>Reports<%} %></b></p><hr/>
<h4><a href="/NBG/ChartController?action=viewChartEmp&&type=textualreport"><b style="font-family: Arial; font-size: 12px;"><%String keyPie=(String)session.getAttribute("keyPie");
if(keyPie!=null){out.println(keyPie);}else {%>Textual Reports<%} %></b></a></h4>
	<h4><a href="/NBG/ChartController?action=viewChartEmp"><b style="font-family: Arial; font-size: 12px;"><%String keyvchart=(String)session.getAttribute("keyvchart");
if(keyvchart!=null){out.println(keyvchart);}else {%>Graphical Reports<%} %></b></a></h4>

	
											
 
<br/><br/>

<p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String keyPasswordManagementwa=(String)session.getAttribute("keyPasswordManagementwa");if(keyPasswordManagementwa!=null){out.println(keyPasswordManagementwa);}else{ %>Password
Management<%} %></b></p>
<hr>
<h4><a href="/NBG/EmployeeManagementServlet?action=changePwd"><b
	style="font-family: Arial; font-size: 12px;"><%String keyChangePasswordwa=(String)session.getAttribute("keyChangePasswordwa");if(keyChangePasswordwa!=null){out.println(keyChangePasswordwa);}else{ %>Change Password<%} %></b></a></h4>
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

<h2><%String keyWelcomeAdministratorwa=(String)session.getAttribute("keyWelcomeAdministratorwa");if(keyWelcomeAdministratorwa!=null){out.println(keyWelcomeAdministratorwa);}else{ %>Welcome Administrator<%} %></h2>
<hr>
<marquee scrolldelay="150" onmouseOver="this.stop();" onmouseOut="this.start();" behavior="scroll" direction="left" scrollamount="9"/>
<table cellspacing="10"><tr align="center"><td><b><%String keyATMServiceswa=(String)session.getAttribute("keyATMServiceswa");
if(keyATMServiceswa!=null){out.println(keyATMServiceswa);}else {%>ATM Services<%} %></b></td><td></td><td><b><%String keyDebitCardwa=(String)session.getAttribute("keyDebitCardwa");
if(keyDebitCardwa!=null){out.println(keyDebitCardwa);}else {%>Debit Card<%} %></b></td><td><b><%String keyInternetBankingServicewa=(String)session.getAttribute("keyInternetBankingServicewa");
if(keyInternetBankingServicewa!=null){out.println(keyInternetBankingServicewa);}else {%>Internet Banking Service<%} %></b></td><td><b><%String keyMobileBankingServicewa=(String)session.getAttribute("keyMobileBankingServicewa");
if(keyMobileBankingServicewa!=null){out.println(keyMobileBankingServicewa);}else {%>Mobile Banking Service<%} %></b></td></tr><tr><td><img src="<%=request.getContextPath() %>/images/ATM.jpg" alt="" width="200" height="150" border="0"></td><td></td><td><img src="<%=request.getContextPath() %>/images/credit.jpg" alt="" width="200" height="150" border="0"></td><td><img src="<%=request.getContextPath() %>/images/ebanking.jpg" alt="" width="200" height="150" border="0"></td><td><img src="<%=request.getContextPath() %>/images/mobile.jpg" alt="" width="200" height="150" border="0"></td></tr></table>

</marquee>
<br/><br/><br/><br/><br/><br/><br/><br/><br/>
<table align="left">
	<tr >
		<td><p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String keyasAnAdministratorHwa=(String)session.getAttribute("keyasAnAdministratorHwa");if(keyasAnAdministratorHwa!=null){out.println(keyasAnAdministratorHwa);}else{ %>As an Administrator you may, <%} %></b></p></td>
	</tr>
	<tr style="font-family: Arial, Verdana; font-size: 13px;">
		<td><%String keyasAnAdministratorL1wa=(String)session.getAttribute("keyasAnAdministratorL1wa");if(keyasAnAdministratorL1wa!=null){out.println(keyasAnAdministratorL1wa);}else{ %>Register a new Employee <%} %><br>

		<%String keyasAnAdministratorL2wa=(String)session.getAttribute("keyasAnAdministratorL2wa");if(keyasAnAdministratorL2wa!=null){out.println(keyasAnAdministratorL2wa);}else{ %>Update an Employee's Profile<%} %> <br>
		<%String keyasAnAdministratorL3wa=(String)session.getAttribute("keyasAnAdministratorL3wa");if(keyasAnAdministratorL3wa!=null){out.println(keyasAnAdministratorL3wa);}else{ %>Activate/Deactivate an Employee from Bank Service <%} %><br>
		<%String keyasAnAdministratorL4wa=(String)session.getAttribute("keyasAnAdministratorL4wa");if(keyasAnAdministratorL4wa!=null){out.println(keyasAnAdministratorL4wa);}else{ %>Add a new product to the bank<%} %> <br>
		<%String keyasAnAdministratorL5wa=(String)session.getAttribute("keyasAnAdministratorL5wa");if(keyasAnAdministratorL5wa!=null){out.println(keyasAnAdministratorL5wa);}else{ %>Add Product(s).<%} %><br>
		<%String keyasAnAdministratorL6wa=(String)session.getAttribute("keyasAnAdministratorL6wa");if(keyasAnAdministratorL6wa!=null){out.println(keyasAnAdministratorL6wa);}else{ %>Update Product details.<%} %><br>
		<%String keyasAnAdministratorL7wa=(String)session.getAttribute("keyasAnAdministratorL7wa");if(keyasAnAdministratorL7wa!=null){out.println(keyasAnAdministratorL7wa);}else{ %>Delete Products.<%} %><br>
		<%String keyasAnAdministratorL8wa=(String)session.getAttribute("keyasAnAdministratorL8wa");if(keyasAnAdministratorL8wa!=null){out.println(keyasAnAdministratorL8wa);}else{ %>View Product Report.<%} %><br>
		<%String keyasAnAdministratorL9wa=(String)session.getAttribute("keyasAnAdministratorL9wa");if(keyasAnAdministratorL9wa!=null){out.println(keyasAnAdministratorL9wa);}else{ %>Add Additional Product.<%} %><br>
		<%String keyasAnAdministratorL10wa=(String)session.getAttribute("keyasAnAdministratorL10wa");if(keyasAnAdministratorL10wa!=null){out.println(keyasAnAdministratorL10wa);}else{ %>Update or Delete Additional Products.<%} %><br>
		<%String keyasAnAdministratorL11wa=(String)session.getAttribute("keyasAnAdministratorL11wa");if(keyasAnAdministratorL11wa!=null){out.println(keyasAnAdministratorL11wa);}else{ %>View Additional Product Report.<%} %></td>
	</tr>
	<tr> <td><br/></td></tr>
<tr>

<td>
<b style="color:green; font-size: 104px"> <%
 	String message = (String) request.getAttribute("msg");
 	if (message != null) {
 		out.println(message);
 	}
 %> </b>
 </td>
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
<div style="margin-top: 15px"></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>