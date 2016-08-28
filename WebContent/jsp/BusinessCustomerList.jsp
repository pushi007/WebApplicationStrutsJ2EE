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
<%@page import="com.tvm.ilp.t154.cao.model.AddressDetails"%>
<%@page import="java.util.List"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Business Customer Summary</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"  />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/layout.css"  />
<script src="<%=request.getContextPath() %>/js/javascript.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>

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
                                             <center><h2>Business Search Result</h2></center>



<hr>
<form id="contacts-form3">

<%List<BusinessCustomer>list=(ArrayList<BusinessCustomer>)request.getAttribute("blist");%>


<table align="center" cellspacing="12" border="0">


<tr> 
<td align="left"><b>Business Name</b></td>
<td align="center"><b>Address</b></td>
<td align="left"><b>Business Email</b></td>
</tr>

<%for (BusinessCustomer b:list){ %>
<tr>
<td><label for="Status"><a href="/NBG/SearchCustomerServlet?action=bcsearch&&bn=<%=b.getBusinessName()%>&&brn=<%=b.getBranchName()%>&&tr=<%=b.getTradingName() %>&&email=<%=b.getEmail() %>&&bt=<%=b.getBusinessType() %>&&npid=<%=b.getNpId()%>&&country=<%=b.getCountry()%>"><%=b.getBusinessName()%></a></label></td>

<td><label for="Address"><%=b.getCountry()%> ,<%=b.getBusinessName() %></label></td>
<td><label for="Email Address"><%=b.getEmail()%></label></td>


</tr>

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