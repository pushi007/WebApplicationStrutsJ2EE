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
    <%@page import="java.util.*" %>
     <%@page import="com.tvm.ilp.t154.cao.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relationship Manager Details</title>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/maxheight.js" type="text/javascript"></script>
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
                                       		<center><h2>Relationship Manager Details </h2></center>
                                       		
                                       		<% String branch=(String)request.getAttribute("branchname"); %>
                                       		
                                            <%String rmanager=(String)request.getAttribute("rmanager"); %>
                                            <%String npid=(String)request.getAttribute("npid"); %>
                                             <% int npId=Integer.parseInt(npid);%> 
                                       		<%request.getSession().setAttribute("assignRM",rmanager); %>
                                       		<%String businessName=(String)request.getAttribute("businessName"); %>
                                     <%NonPersonalParty npp=(NonPersonalParty)request.getAttribute("tradingName"); %>
<%String route=(String)request.getSession().getAttribute("route"); %>
                                       		
                                    <hr></hr>
                                       		<form id="contacts-form1" action="">
                                       		<input type="hidden" name="action" value="">
                                       		
                                       		<table align="center">

<tr>
<td style="padding:15px;"><b>Customer ID</b></td>
<td style="padding:15px;"><label id="nonpersonalid" for="nonpersonalid" ><%=npId%></label></td> 
</tr>
<tr>
<td style="padding:15px;"><b>Business Name</b></td>
<td style="padding:15px;"><label for="businessName"><%=businessName%></label></td></tr>
<tr>
<td style="padding:15px;"><b>Trading Name</b></td>
<td style="padding:15px;"><label for="tradingName"><%=npp.getTradingName()%></label></td></tr>                                   		
<tr></tr>
<tr>
<td style="padding:15px;"><b>Branch Name</b></td>
<td style="padding:15px;"><label for="branchName"><%=branch%></label></td></tr>
<tr>
<td style="padding:15px;"><b>Relationship Manager</b></td>
<td style="padding:15px;"><label for="manager"><%=rmanager %></label></td>                                   		
</tr>

<tr>


<td align="center" style="padding:5px;" colspan="2">
<%if(route.equals("route1")){ %>
<a href="/NBG/AssignRelationshipManagerServlet?action=termsAndConditions" class="button"><em><b>Continue</b></em></a>
<%}else if(route.equals("route2")){ %><a href="/NBG/AssignRelationshipManagerServlet?action=termsAndConditions" class="button"><em><b>Ok</b></em></a>
<%} %>
</td>
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
