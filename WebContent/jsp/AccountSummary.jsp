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
<%@ page import= "com.tvm.ilp.t154.cao.model.NonPersonalAccount "%>
<%@ page import="com.tvm.ilp.t154.cao.services.AccountServices" %>

<%@page import="com.tvm.ilp.t154.cao.model.BusinessCustomer"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Summary</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"  />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/layout.css"  />
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>
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
											<!--<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">Open Account</b></a></h4>-->
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
                                             <center><h2>Business Account Summary</h2></center>


<%NonPersonalAccount npa=(NonPersonalAccount) request.getAttribute("accNo"); %>
<%long accNo=npa.getAccNumber(); %>
<% AccountServices accService=new AccountServices();%>
<%NonPersonalAccount npa1=new NonPersonalAccount(); %>
<%BusinessCustomer bc=(BusinessCustomer)request.getSession().getAttribute("bc");  %>
<%String pName=(String)request.getSession().getAttribute("pName"); %>
                                              
<table width="90%" style="align:center;font-family:Arial,Verdana;font-size:13px;color:#8A3E08">
 <tr>
 <td align="left"><b>Business Name - <%=bc.getBusinessName()%></b></td>
 <td align="right"><b>Branch Name - <%=bc.getBranchName()%></b></td>
 </tr></table>
<hr></hr>
<form id="contacts-form3" action="/NBG/AdditionalProductConfigServlet">
<input type="hidden" name="action" value="searchAccount"></input>

<input type="hidden" name="acc_number" value="<%=npa.getAccNumber()%>"></input>


<table align="center" cellspacing="10">


<tr> 
<td align="left"><b>Account Number</b></td>
<td><label for="Account Number"><%=npa.getAccNumber()%></label></td>
</tr>


<tr> 
<td align="left"><b>Non Personal Account ID</b></td>
<td><label for="Account Number"><%=npa.getNpId()%></label></td>
</tr>

<tr> 
<td align="left"><b>Product Name</b></td>
<td><label for="Account Number"><%=pName%></label></td>
</tr>

<tr> 
<td align="left"><b>Product Intention</b></td>
<td><label for="Account Number"><%=npa.getAccountType()%></label></td>
</tr>




<tr> 
<td align="left"><b>Status</b></td>
<td><label for="Status"><%=npa.getStatus()%></label></td>
</tr>


<tr></tr>

<tr><td  align="center" colspan="2"><a class="button" onclick="document.getElementById('contacts-form3').submit()"><em><b><small>Add Additional Product</small></b></em></a></td>
<td></td>
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