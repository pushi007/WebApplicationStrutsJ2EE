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
<%@ page import="com.tvm.ilp.t154.cao.model.Product"%>
<%@ page import="com.tvm.ilp.t154.cao.model.AdditionalProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="com.tvm.ilp.t154.cao.model.BusinessType"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Static Details</title>
<link href="<%= request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%= request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" />

<script  type="text/javascript" src="<%=request.getContextPath() %>/js/maxheight.js"></script>
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js"></script>
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
      <div class="container">
      	<!-- main-banner-small begin -->
         <div class="main-banner-small">
         	<div class="inner">
            	<h1>The bank for a changing world.</h1>
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
                                          <h3 align="center" style="font-family:Arial,Verdana;font-size:16px;color:#000">Product Details</h3><hr/>

<%Product p=(Product) request.getSession().getAttribute("products"); %>
<%ArrayList<BusinessType> bList=(ArrayList<BusinessType>) request.getSession().getAttribute("busines"); %>
<%ArrayList<AdditionalProduct> apList=(ArrayList<AdditionalProduct>) request.getSession().getAttribute("AddProducts"); %>


<form id="contacts-form2"  name="singleProduct" action="/NBG/ProductManagementServlet" method="post" onsubmit="return validation();">
<input type="hidden" name="action" value="updatedProductDetailsList"></input>
<input type="hidden" name="selectedSingleProduct"></input>
<input type="hidden" name="productId" value="<%=p.getProductID() %>"></input>


<table align="left" cellpadding=10 cellspacing=10>
 
<tr> 
<td ><b>Product ID :</b></td>
<td><%=p.getProductID() %></td>
</tr>

<tr>
<td ><b>Product Name :</b></td>
<td><%=p.getProductName() %></td>
</tr>

<tr > 
<td ><b>Product Description :</b></td>
<td><%=p.getProductDescription()%></td>
</tr>

<tr> 
<td ><b>Account Type : </b></td>
<td><%=p.getAccountType() %></td>
</tr>


<tr> 
<td ><b>Product Status :</b></td>
<td><%=p.getProductStatus() %></td>
</tr>


<tr> 
<td ><b>Valid From :</b></td>
<td><%=p.getProductValidFrom() %></td> 
</tr>

<tr>
<td valign="top"><b>Business Type :</b></td><td>
<%for(BusinessType pst:bList){ %>
<%=pst.getBusinessType_name()%> <br/>
<%} %>
</td></tr>
<tr>
<td valign="top"><b>Additional Product :</b></td><td>
<%for(AdditionalProduct pt:apList){ %>
<%=pt.getName()%><br/>
<%} %>
</td></tr>

<%String flag=(String)request.getAttribute("flag");
if(flag=="true"){%>
<tr><td></td></tr><tr><td></td></tr>
<tr align="center"><td colspan="1"><a href="/NBG/ProductManagementServlet?action=confirm" class="button"><em><b>Confirm</b></em></a></td>
<td style="align: center;"><a type="submit" class="button"  href="/NBG/ProductManagementServlet?action=reason" ><em><b>Delete</b></em></a></td>
<td style="align: center;"><a type="submit" class="button"  href="/NBG/ProductManagementServlet?action=ViewProduct"  ><em><b>Cancel</b></em></a></td>
	
<%} else{%>	
<tr><td></td></tr><tr><td></td></tr>
<tr align="center"><td colspan="1"><a type="submit" class="button" onclick="return selectSingleUpdate();"><em><b>Update</b></em></a></td>
<td style="align: center;"><a type="submit" class="button"  href="/NBG/ProductManagementServlet?action=reason" ><em><b>Delete</b></em></a></td>
<td style="align: center;"><a type="submit" class="button"  href="/NBG/ProductManagementServlet?action=ViewProduct"  ><em><b>Cancel</b></em></a></td>
<%} %>
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