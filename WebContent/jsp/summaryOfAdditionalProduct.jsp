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
<%@page import="com.tvm.ilp.t154.cao.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Summary Of Additional Product</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"  />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/layout.css"  />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/maxheight.js" ></script>
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js"></script>
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
											<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Commercial Account Opening</b></p>
											<hr></hr>
											<br>
											<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">Create Account</b></a></h4>
											<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
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
                                       <center><h2>Summary of Additional Product</h2></center>
                                       <%BusinessCustomer bc=(BusinessCustomer)request.getSession().getAttribute("bc"); %>
                                              
<table width="90%" style="align:center;font-family:Arial,Verdana;font-size:13px;color:#8A3E08">
 <tr>
 <td align="left"><b>Business Name - <%=bc.getBusinessName()%></b></td>
 <td align="right"><b>Branch Name - <%=bc.getBranchName()%></b></td>
 </tr></table>
                                       <hr></hr>
                                       <%String acc_number=(String) request.getAttribute("AccountNumber"); %>
                                       <%String productId=(String) request.getSession().getAttribute("productId"); %>
                                       <%String[] product=(String[])request.getSession().getAttribute("productName"); %>
                                      
                                       
                        <table align="center" cellspacing="10">
                                       
						<tr>
                        <td style="padding:15px;">Account Number</td>
						<%if(acc_number!=null){ %>
						<td style="padding:15px;"><b><%=acc_number %></b></td>
						<%} %>
						</tr>
						</table>
						<center><h4><b>You have applied for the following product(s):</b></h4></center>
						<div>
						<%for(int i=0;i<product.length;i++){ %>
						<center><%=product[i] %></center>
						<br>
						<%} %>
						</div>
						<form id="contacts-form2" name="additional_product" method="post">
						<table align="center">
						<tr><td colspan="2" style="padding:10px;"><a href="/NBG/AdditionalProductConfigServlet?action=editDetails&&acc_Number=<%=acc_number %>&&productId=<%=productId %>" class="button"><em><b>Edit</b></em></a></td>
						<td style="padding:10px;"><a href="/NBG/AdditionalProductConfigServlet?action=submitDetails&&acc_Number=<%=acc_number %>" class="button"><em><b>Continue</b></em></a>
						</td></tr>
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