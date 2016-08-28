<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="com.tvm.ilp.t154.cao.model.NonPersonalCustomer"%>

<%@ page import="static com.tvm.ilp.t154.cao.constants.CAOConstants.*" %>
<head>
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description" content="Consulting page - free business website template from Template Monster is awating for you to download."/>

<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath()%>/js/maxheight.js" type="text/javascript"></script>

<!--[if lt IE 7]>
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

</head>

<body id="page5" onload="new ElementMaxHeight();">

   <!-- header -->
   <jsp:include page="./layout/header.jsp"></jsp:include>
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
<ul>
<li><b style="font-family:Arial,Verdana;font-size:16px;color:#000">Registration</b><br/><br/></li>
</ul>

<ul>
    <li style="font-family:Arial,Verdana;font-size:14px;color:#000"><a href="/NBG/AccountPartyManagementServlet?ACTION=REGISTER" >Account Parties</a></li>
 </ul>
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
                                               <h3  style="align:center;font-family:Arial,Verdana;font-size:16px;color:#000">Business Details</h3>

<hr></hr>

<%NonPersonalCustomer npParty=(NonPersonalCustomer)request.getAttribute("Business_Costomer_Details"); %>

<form width="100%" name="Display_Business_Cust_Details" action="/NBG/AccountPartyManagementServlet">
<input type="hidden" name=ACTION value="Display_Business_Cust_Detail"></input>

<table align="left" cellpadding=10 cellspacing=10 style="position:relative;top:-10px;">

<tr>
<td align="left" width=50%><b>Business ID</b></td>
<td><%=npParty.getBusinessId() %></input></td>
</tr>

<tr>
<td align="left" width=50%><b>Business Name</b></td>
<td><%=npParty.getBusinessName() %></td>
</tr>

<tr>
<td align="left" width=50%><b>Trading Name</b></td>
<td><%=npParty.getTradingName() %></td>
</tr>
<tr>

<td align="left" width=50%><b>Business Type</b></td>
<td><%=npParty.getBusinessType() %></td>
</tr>

<tr>
<td align="left" width=50%><b>Branch</b></td>
<td><%=npParty.getBranch().getBranchName() %></td>
</tr>

<tr>
<td align="left" width=50%><b>Expected Annual Turnover</b></td>
<td><%=npParty.getExpectedAnnualTurnover() %></td>
</tr>

<tr>
<td align="left" width=50%><b>Business Status</b></td>
<td><%=npParty.getBusinessStatus() %></td>
</tr>

<tr>
<td align="left" width=50%><b>No of employees</b></td>
<td><%=npParty.getNoOfEmployees() %></td>
</tr>

<tr>
<td align="left" width=50%><b>Country of Registration</b></td>
<td><%=npParty.getCountryOfRegistration() %></td>
</tr>

<tr>
<td align="left" width=50%><b>Email Address</b></td>
<td><%=npParty.getBusinessEmailAddress() %></td>
</tr>

<tr><td></td></tr>

<tr>

<td colspan="1" width=50% style="align:center;padding:10px"><a href="#" class="button" onclick="document.Display_Business_Cust_Details.submit();"><em><b>Continue</b></em></a></td>

<td colspan="1" width=50% style="align:center;padding:10px"><a href="/NBG/jsp/RegistrationPortal.jsp" class="button" ><em><b>Cancel</b></em></a></td>

</tr>
</table>

</form>

</div>
</div></div></div></div></div></div></div></div></div></div></div></div></div>
<!-- footer -->
   <jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>



