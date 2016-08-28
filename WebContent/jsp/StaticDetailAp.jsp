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

<%@page import="com.tvm.ilp.t154.cao.model.AdditionalProduct"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AP Static Details</title>
<link href="<%= request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%= request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>

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
<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Product Management</b><br></p><hr><br/>
<h4><a href="/NBG/EmployeeManagementServlet?action=closeSession"><b
	style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
<h4> <a href="/NBG/ProductManagementServlet?action=addProduct"><b style="font-family: Arial; font-size: 12px;">Add Product(s)</b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=ViewProduct"><b style="font-family: Arial; font-size: 12px;">View Products</b></a></h4>

<!--<h4><a href="/NBG/ProductManagementServlet?action=viewp"><b style="font-family: Arial; font-size: 12px;">Product Report</b></a></h4>

--><p style="font-family: Arial, Verdana; font-size: 13px;"><b>Additional Products</b><br></p>
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
                                          <center><h2>Additional Product Details</h2></center>
<hr/>
                                          
<%AdditionalProduct ap=(AdditionalProduct)request.getAttribute("apsearch"); %>
   <form id="contacts-form6"  action="" >

<!--<input type="hidden" name="action" value="deleteap"></input>
<input type="hidden" name="action" value="uap"></input>


--><input type=hidden name="apid" value="<%=ap.getAdditionalProductId() %>"></input>

<table  align="left" cellpadding=10 cellspacing=10>
<tr>
<td colspan="2"><b>Additional Product ID:</b></td>
<td><%=ap.getAdditionalProductId()%></td>
<td></td>
</tr>

<tr>
<td colspan="2"><b>Additional Product Name:</b></td>
<td><%=ap.getName()%></td><td></td>
</tr>
<tr></tr>


<tr><td  colspan="1" align="left" width="100px"><a href="/NBG/ProductManagementServlet?action=uap&&apid=<%=ap.getAdditionalProductId()%>&&apname=<%=ap.getName()%>" class="button" ><em><b>Update</b></em></a></td>
<td width="100px"><a href="/NBG/ProductManagementServlet?action=deleteap&&apid=<%=ap.getAdditionalProductId() %>" class="button" ><em><b>Delete</b></em></a></td>
<td style="align: center;" width="100px"><a type="submit" class="button"  href="/NBG/ProductManagementServlet?action=uordap"  ><em><b>Cancel</b></em></a></td>
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