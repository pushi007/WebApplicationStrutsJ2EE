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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description" content="Consulting page - free business website template from Template Monster is awating for you to download."/>

<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>
<script src="../js/registration1.js" type="text/javascript"></script>
<!--[if lt IE 7]>
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

</head>

<body id="page5" onload="new ElementMaxHeight();">
   <!-- header -->
   <jsp:include page="layout/header.jsp"></jsp:include>
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
                                          
<h4><a href="/NBG/CustomerManagementServlet?action=find" ><b style="font-family: Arial; font-size: 12px;"><%String keyFindBusiness=(String)session.getAttribute("keyFindBusiness");
if(keyFindBusiness!=null){out.println(keyFindBusiness);}else {%>Find Business<%} %></b></a></h4>

   <br/><br/>

<p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String keyComAccOpening=(String)session.getAttribute("keyComAccOpening");
if(keyComAccOpening!=null){out.println(keyComAccOpening);}else {%>Commercial Account Opening<%} %></b></p><hr/>
    <h4><a href="/NBG/SearchCustomerServlet?action=searchCustomer"><b style="font-family: Arial; font-size: 12px;"><%String keyOpenAcc=(String)session.getAttribute("keyOpenAcc");
if(keyOpenAcc!=null){out.println(keyOpenAcc);}else {%>Open Account<%} %></b></a></h4>
	<h4><a href="<%=request.getContextPath() %>/jsp/SearchRelationshipManager.jsp"><b style="font-family: Arial; font-size: 12px;"><%String keyAssignRelMgr=(String)session.getAttribute("keyAssignRelMgr");
if(keyAssignRelMgr!=null){out.println(keyAssignRelMgr);}else {%>Assign Relationship Manager<%} %></b></a></h4>
<br/><br/>
<p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String keychart=(String)session.getAttribute("keychart");

if(keychart!=null){out.println(keychart);}else {%>Reports<%} %></b></p><hr/>
<!--<h4><a href="/NBG/ChartController?action=viewPie"><b style="font-family: Arial; font-size: 12px;"><%String keyPie=(String)session.getAttribute("keyPie");
if(keyPie!=null){out.println(keyPie);}else {%>Textual Reports<%} %></b></a></h4>
	--><h4><a href="/NBG/ChartController?action=viewChart"><b style="font-family: Arial; font-size: 12px;"><%String keyvchart=(String)session.getAttribute("keyvchart");
if(keyvchart!=null){out.println(keyvchart);}else {%>Customer Report<%} %></b></a></h4>

	
											
 
<br/><br/>
<p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String keyPasswordManagementwa=(String)session.getAttribute("keyPasswordManagementwa");
if(keyPasswordManagementwa!=null){out.println(keyPasswordManagementwa);}else {%>Password Management<%} %></b></p><hr/>
<h4><a href="/NBG/EmployeeManagementServlet?action=changePwd"><b  style="font-family: Arial; font-size: 12px;"><%String keyChangePasswordwa=(String)session.getAttribute("keyChangePasswordwa");
if(keyChangePasswordwa!=null){out.println(keyChangePasswordwa);}else {%>Change Password<%} %></b></a></h4>
 
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
                                         
                      <h2><%String keyWelcomeAC=(String)session.getAttribute("keyWelcomeAC");
if(keyWelcomeAC!=null){out.println(keyWelcomeAC);}else {%>Welcome Account Opener<%} %></h2>
<hr/>
<marquee scrolldelay="150" onmouseOver="this.stop();" onmouseOut="this.start();" behavior="scroll" direction="left" scrollamount="9"/>
<table cellspacing="10"><tr align="center"><td><b><%String keyATMServiceswa=(String)session.getAttribute("keyATMServiceswa");
if(keyATMServiceswa!=null){out.println(keyATMServiceswa);}else {%>ATM Services<%} %></b></td><td></td><td><b><%String keyDebitCardwa=(String)session.getAttribute("keyDebitCardwa");
if(keyDebitCardwa!=null){out.println(keyDebitCardwa);}else {%>Debit Card<%} %></b></td><td><b><%String keyInternetBankingServicewa=(String)session.getAttribute("keyInternetBankingServicewa");
if(keyInternetBankingServicewa!=null){out.println(keyInternetBankingServicewa);}else {%>Internet Banking Service<%} %></b></td><td><b><%String keyMobileBankingServicewa=(String)session.getAttribute("keyMobileBankingServicewa");
if(keyMobileBankingServicewa!=null){out.println(keyMobileBankingServicewa);}else {%>Mobile Banking Service<%} %></b></td></tr><tr><td><img src="<%=request.getContextPath() %>/images/ATM.jpg" alt="" width="200" height="150" border="0"></td><td></td><td><img src="<%=request.getContextPath() %>/images/credit.jpg" alt="" width="200" height="150" border="0"></td><td><img src="<%=request.getContextPath() %>/images/ebanking.jpg" alt="" width="200" height="150" border="0"></td><td><img src="<%=request.getContextPath() %>/images/mobile.jpg" alt="" width="200" height="150" border="0"></td></tr></table>

</marquee>

<br/><br/>
<p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String keydeshead=(String)session.getAttribute("keydeshead");
if(keydeshead!=null){out.println(keydeshead);}else {%>As an Account Opener you can,<%} %></b><br></p>

<ul style="font-family: Arial, Verdana; font-size: 13px;" >
<li><%String keydesl1=(String)session.getAttribute("keydesl1");
if(keydesl1!=null){out.println(keydesl1);}else {%>Create Account for the Business Customer.<%} %> </li><li><%String keydesl2=(String)session.getAttribute("keydesl2");
if(keydesl2!=null){out.println(keydesl2);}else {%>Configure the product and additional products to the account.<%} %></li><li><%String keydesl3=(String)session.getAttribute("keydesl3");if(keydesl3!=null){out.println(keydesl3);}else {%>Assign an Relationship Manager to the customer depending on the branch.<%} %></li><li><%String keydesl4=(String)session.getAttribute("keydesl4");
if(keydesl4!=null){out.println(keydesl4);}else {%> Change Relationship Manager in the later stage according to the customer's request.<%} %></li>


<li><%String keydesl5=(String)session.getAttribute("keydesl5");
if(keydesl5!=null){out.println(keydesl5);}else {%>Register a new Business Customer<%} %></li>
<li><%String keydesl6=(String)session.getAttribute("keydesl6");
if(keydesl6!=null){out.println(keydesl6);}else {%>Add Account Party/parties to a registered customer<%} %></li>
<li><%String keydesl7=(String)session.getAttribute("keydesl7");
if(keydesl7!=null){out.println(keydesl7);}else {%>View profile of a Customer/Account Party<%} %></li>
<li><%String keydesl8=(String)session.getAttribute("keydesl8");
if(keydesl8!=null){out.println(keydesl8);}else {%>Update profile of a Customer/Account Party<%} %></li>
<li><%String keydesl9=(String)session.getAttribute("keydesl9");
if(keydesl9!=null){out.println(keydesl9);}else {%>Delete profile of a Customer/Account Party<%} %></li>




</ul>

<%String message=(String)session.getAttribute("msg");
if(message!=null){
out.println(message);
}
%>

</div></div></div></div></div></div></div></div></div></div></div></div>
<!-- footer -->

 <div style="margin-top:15px" ></div>
  <jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>