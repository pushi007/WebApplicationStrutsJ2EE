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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/js/productScript.js"></script>

<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>
<body id="page5" onload="new ElementMaxHeight();">
   <!-- header -->
   <jsp:include page="../jsp/layout/header.jsp"></jsp:include>
   <!-- content -->
   <div id="content">
      <div class="container">
      	<!-- main-banner-small begin -->
         <div class="main-banner-small">
         	<div class="inner">
            	<h1>
<%String headerMesg=(String)session.getAttribute("tagLinehl");
if(headerMesg!=null){out.println(headerMesg);}else {%>
The bank for a changing world.<%} %></h1>
            </div>
         </div>
         <!-- main-banner-small end -->
         <div class="wrapper">
         	<div class="col-1 maxheight">
            	<!-- box begin -->
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
											<!--<p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String keyEmployeewa=(String)session.getAttribute("keyEmployeewa");if(keyEmployeewa!=null){out.println(keyEmployeewa);}else{ %>Employee<%} %></b></p><hr/>
<h4><a href="/NBG/EmployeeManagementServlet?action=register"><b style="font-family: Arial; font-size: 12px;"><%String keyRegisterLinkwa=(String)session.getAttribute("keyRegisterLinkwa");if(keyRegisterLinkwa!=null){out.println(keyRegisterLinkwa);}else{ %>Register<%} %></b></a></h4>
<h4><a href="/NBG/EmployeeManagementServlet?action=view"><b><%String keyViewEmployeewa=(String)session.getAttribute("keyViewEmployeewa");if(keyViewEmployeewa!=null){out.println(keyViewEmployeewa);}else{ %>View Employees<%} %></b></a></h4>
	
	<br/><br/>
--><p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String keyProductwa=(String)session.getAttribute("keyProductwa");if(keyProductwa!=null){out.println(keyProductwa);}else{ %>Product Management<%} %></b></p><hr/>
<h4><a href="/NBG/EmployeeManagementServlet?action=closeSession"><b
	style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
<!--<h4><a href="/NBG/ProductManagementServlet?action=addProduct"><b
	style="font-family: Arial; font-size: 12px;"><%String keyAddProductswa=(String)session.getAttribute("keyAddProductswa");if(keyAddProductswa!=null){out.println(keyAddProductswa);}else{ %>Add Product(s)<%} %></b></a></h4>
--><h4><a href="/NBG/ProductManagementServlet?action=ViewProduct"><b
	style="font-family: Arial; font-size: 12px;"><%String keyViewProductswa=(String)session.getAttribute("keyViewProductswa");if(keyViewProductswa!=null){out.println(keyViewProductswa);}else{ %>View Products<%} %></b></a></h4>
<!--<h4><a href="/NBG/ProductManagementServlet?action=viewp"><b
	style="font-family: Arial; font-size: 12px;"><%String keyProductReportwa=(String)session.getAttribute("keyProductReportwa");if(keyProductReportwa!=null){out.println(keyProductReportwa);}else{ %>Product Report<%} %></b></a></h4>
--><br />

<h4><a
	href="/NBG/ProductManagementServlet?action=additionalProduct"><b
	style="font-family: Arial; font-size: 12px;"><%String keyAddAdditionalProductwa=(String)session.getAttribute("keyAddAdditionalProductwa");if(keyAddAdditionalProductwa!=null){out.println(keyAddAdditionalProductwa);}else{ %>Add Additional Product<%} %></b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=uordap"><b
	style="font-family: Arial; font-size: 12px;"><%String keyUpdateDeleteAdditionalProductwa=(String)session.getAttribute("keyUpdateDeleteAdditionalProductwa");if(keyUpdateDeleteAdditionalProductwa!=null){out.println(keyUpdateDeleteAdditionalProductwa);}else{ %>Update/Delete
Additional Product<%} %></b></a></h4>
<!--<h4><a href="/NBG/ProductManagementServlet?action=viewap"><b
	style="font-family: Arial; font-size: 12px;"><%String keyAdditionalProductReportwa=(String)session.getAttribute("keyAdditionalProductReportwa");if(keyAdditionalProductReportwa!=null){out.println(keyAdditionalProductReportwa);}else{ %>Additional Product
Report<%} %></b></a></h4>

--><br />
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
               <!-- box end -->
               </div>
               <div class="col-2 maxheight">
            	<!-- box begin -->
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
                                           <center><h2><%String keyh=(String)session.getAttribute("keyh");if(keyh!=null){out.println(keyh);}else{ %>Add new product(s)<%} %></h2></center><hr/>
<br><br>
<span><b><%String keysh=(String)session.getAttribute("keysh");if(keysh!=null){out.println(keysh);}else{ %>Please select any one of the options to add product(s).<%} %></b> </span>
<form id="contacts-form2"  name="Product" action="/NBG/ProductManagementServlet" onSubmit="return validationform();">
<input type="hidden" name="action" value="ProductLi"></input>
<table  cellpadding=10  cellspacing=10>
<tr></tr>
<tr>
<td><input type="radio" name="Products"  onclick="priority_on_single();" value="Single product"/> <%String keysp=(String)session.getAttribute("keysp");if(keysp!=null){out.println(keysp);}else{ %>Single Product <%} %>
<input type="radio" name="Products"  value="Group of Products" onclick="priority_on_groups();" /><%String keymp=(String)session.getAttribute("keymp");if(keymp!=null){out.println(keymp);}else{ %>Group of Products<%} %>
</td><td width="100px"><label id="err_message7" style="color: red;"></label></td></tr><tr>
</tr>

<tr><td  align="left"><a href="#" type="submit" class="button" onClick="return validationform();"><em><b><%String keysubmit=(String)session.getAttribute("keysubmit");if(keysubmit!=null){out.println(keysubmit);}else{ %>Submit<%} %></b></em></a>
</td>
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
</div>
</div>

<!-- footer -->
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>