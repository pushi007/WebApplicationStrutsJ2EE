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

<%@page import="java.util.ArrayList"%>
<%@page import="com.tvm.ilp.t154.cao.model.BusinessCustomer"%>
<%@page import="com.tvm.ilp.t154.cao.model.AddressDetails"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Business Customer Summary</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"  />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/layout.css"  />
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/javascript.js" type="text/javascript"></script>
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
                                             <center><h2>Business Customer Summary</h2></center>




<hr>
<form id="contacts-form3" name="Business Summary" method="post" action="/NBG/AccountCreationServlet">
<input type="hidden" name="action" value="CreateAccountPage"></input>
		
						
<%BusinessCustomer bc=(BusinessCustomer)request.getAttribute("bc"); %>

<%request.getSession().setAttribute("bc",bc); %>

<%AddressDetails ad =(AddressDetails)request.getSession().getAttribute("address"); %>

<%Boolean AreInProgressAccounts=(Boolean)request.getSession().getAttribute("AreInProgressAccounts"); %>

<input type="hidden" name="btype" value=<%=bc.getBusinessType()%>></input>
<table cellspacing="10">

<tr><h3>Business Details</h3></tr>

<tr> 
<td align="left"><b>Business Name</b></td>
<td><label for="Business Name"><%=bc.getBusinessName()%></label></td>
</tr>

<tr> 
<td align="left"><b>Trading Name</b></td>
<td><label for="Trading Name"><%=bc.getTradingName()%></label></td>
</tr>

<tr> 
<td align="left"><b>Branch Name</b></td>
<td><label for="Branch Name"><%=bc.getBranchName()%></label></td>
</tr>

<tr> 
<td align="left"><b>Business Type</b></td>
<td><label for="Business Type"><%=bc.getBusinessType()%></label></td>
</tr>

</table>

<hr>


<table cellspacing="10">
<tr><h3>Business Address Details</h3></tr>

<tr> 
<td align="left"><b>Building Number</b></td>
<td><label for="Email"><%=ad.getBuildingNo()%></label></td>
</tr>

<tr> 
<td align="left"><b>Building Name</b></td>
<td><label for="Email"><%=ad.getBuildingName()%></label></td>
</tr>

<tr> 
<td align="left"><b>Street Name</b></td>
<td><label for="Email"><%=ad.getStreetName()%></label></td>
</tr>
<tr> 
<td align="left"><b>City Name</b></td>
<td><label for="Email"><%=ad.getCityName()%></label></td>
</tr>
<tr> 
<td align="left"><b>Town Name</b></td>
<td><label for="Email"><%=ad.getTownName()%></label></td>
</tr>
<tr> 
<td align="left"><b>Area Code</b></td>
<td><label for="Email"><%=ad.getAreaCode()%></label></td>
</tr>
<tr> 
<td align="left"><b>Country Code</b></td>
<td><label for="Email"><%=ad.getCountryCode()%></label></td>
</tr>


<tr> 
<td align="left"><b>Country</b></td>
<td><label for="Email"><%=ad.getCountry()%></label></td>
</tr>
</table>
<br>
<hr>


<table cellspacing="10">
<tr><h3>Contact Details</h3></tr>
<tr> 
<td align="left"><b>Email Address</b></td>
<td><label for="Email"><%=bc.getEmail()%></label></td>
</tr>

<tr> 
<td align="left"><b>Contact Number</b></td>
<td><label for="Email"><%=ad.getContactNumber()%></label></td>
</tr>

</table>

<%if(AreInProgressAccounts==true) {%>
<br></br>

The business customer <%=bc.getBusinessName()%> is requested to accept Terms and Conditions of account(s) in progress.
<br/>
To activate these accounts click the link below.<br/>
<a href="/NBG/AccountCreationServlet?action=tandc"><b style="font-family: Arial; font-size: 12px;">Terms and Conditions</b></a>
<br></br>
<% }%>

<table>

<tr><td colspan="1" align="center"><a href="#" class="button" onclick="document.getElementById('contacts-form3').submit()"><em><b>Open Account</b></em></a></td>
<td align="left" style="padding:10px;" ><a href="/NBG/AccountCreationServlet?action=closeSession" class="button" ><em><b>Exit</b></em></a></td>
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