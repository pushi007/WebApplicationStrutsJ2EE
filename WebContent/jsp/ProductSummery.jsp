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
<%@ page import="com.tvm.ilp.t154.cao.model.BusinessType"%>
<%@ page import="com.tvm.ilp.t154.cao.model.AdditionalProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Summary</title>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js" ></script>


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
                                          <center><h2>Product Summary</h2></center>
<hr/><br>
<%String message=(String) request.getAttribute("msg"); %>
<h4  style="align:left;font-family:Arial,Verdana;font-size:16px;color:#8A3E08"><%=message %></h4>
<span align=right><b>Details of the product you have added.</b></span> 
<%Product p=new Product();%>
<%p=(Product) request.getSession().getAttribute("product");%>
<%List<BusinessType> bList=null; %>
<%bList=(ArrayList<BusinessType>) request.getSession().getAttribute("bList"); %>
<%ArrayList<AdditionalProduct> apList=(ArrayList<AdditionalProduct>) request.getSession().getAttribute("apd"); %>



<form id="contacts-form2"  name="product" action="#" >
<table  align="left" cellpadding=10 cellspacing=10>
<tr>
<tr></tr>
<td><b>Product Id :</b></td>
<td><%=p.getProductID()%></td>  
</tr>
<tr>
<td><b>Product Name :</b></td>
<td><%=p.getProductName()%></td> 
</tr>

<tr>
<td><b>Product Description :</b></td>
<td><%=p.getProductDescription()%></td> 
</tr>

<tr>
<td><b>Account Type :</b></td>
<td><%=p.getAccountType()%></td> 
</tr>

<tr>
<td><b>Product Status :</b></td>
<td><%=p.getProductStatus()%></td> 
</tr>


<tr>
<td><b>Valid From :</b></td>
<td><%=p.getProductValidFrom()%></td> 
</tr>
<tr></tr>

<tr>
<td valign="top"><b>Business Type :</b></td>
<td>
<%for(BusinessType pst:bList){ %>
<%=pst.getBusinessType_name()%><br></br>
<%} %>
</td></tr>


<tr>
<td valign="top"><b>Additional Product :</b></td>
<td>
<%for(AdditionalProduct pt:apList){ %>
<%=pt.getName()%><br></br> 
<%} %>
</td></tr>

<tr>
<td style="align: center;"><a type="submit" class="button"  href="/NBG/ProductManagementServlet?action=home"  ><em><b>Exit</b></em></a></td>
<td style="align: center;"><a type="submit" class="button"  href="/NBG/ProductManagementServlet?action=AdditionalProductListDetails"  ><em><b>Edit</b></em></a></td>
</tr>
</table></form>
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