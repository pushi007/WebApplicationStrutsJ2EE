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
<title>Assign Relationship Manager</title>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/maxheight.js" type="text/javascript"></script>
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
											<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Business Account Creation</b></p>
											<hr></hr>
											<br>
											<h4><a href="/NBG/SearchCustomerServlet?action=searchCustomer"><b style="font-family: Arial; font-size: 12px;">Create Account</b></a></h4>
											<h4><a href="<%=request.getContextPath() %>/jsp/SearchRelationshipManager.jsp"><b style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
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
                                       		<center><h2>Relationship Manager Assigned</h2></center>
                                       		
                                       		<% String branch=(String)request.getAttribute("bname"); %>
                                       		
                                            <%long rmid=(Long)request.getAttribute("rm"); %>
                                             <% int npid=(Integer)request.getAttribute("npid");%> 
                                       		
                                       	

                                       		
                                    
                                       		<form id="contacts-form1" action="">
                                       		<input type="hidden" name="action" value="">
                                       		
                                       		<table align="center">

<tr>
<td style="padding:15px;"><b>Customer ID</b></td>
<td style="padding:15px;"><label id="nonpersonalid" for="nonpersonalid" ><%=npid%></label></td> 
</tr>
<tr>
<td style="padding:15px;"><b>BranchID</b></td>
<td style="padding:15px;"><label for="branchId"><%=branch%></label></td>                                   		
<tr></tr>
<tr>
<td style="padding:15px;"><b>Relationship Manager</b></td>
<td style="padding:15px;"><label for="manager"><%=rmid%></label></td>                                   		
<tr></tr>

<tr>

<td colspan="1" align="center"><a href="/NBG/AssignRelationshipManagerServlet?action=complete&&nonpersonalid=<%=npid%>&&branchId=<%=branch%>&&manager=<%=rmid%>" class="button"><em><b>Continue</b></em></a></td>




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