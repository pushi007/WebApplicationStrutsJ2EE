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
    <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%><html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Letter</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"  />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/layout.css"  />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/maxheight.js" ></script>
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js"></script>
<style type="text/css" media="print">
    @media print
    {
    #non-printable { display: none; }
    #printable {
    display: block;
    width: 100%;
    height: 100%; 
     }
    }
    </style>

<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>
<body id="page5" onload="new ElementMaxHeight();">
   <!-- header -->
   <div id="non-printable">
   <jsp:include page="../jsp/layout/header.jsp"></jsp:include>
   </div>
   <!-- content -->
   <div id="content">
      <div class="container">
      	<!-- main-banner-small begin -->
         <div class="main-banner-small">
         	<div class="inner">
         	<div id="non-printable">
            	<h1>The bank for a changing world.</h1>
            	</div>
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
										<div id="non-printable">
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
                                       <div id="printable" >
                                       <center><h2>Welcome Letter</h2></center>
                                             <hr></hr>
                                             <%List<NonPersonalAccountInProgress> npaList=(ArrayList<NonPersonalAccountInProgress>)request.getSession().getAttribute("InProgressAccounts");%>
                                             <%BusinessCustomer bc=(BusinessCustomer)request.getSession().getAttribute("bc"); %>
                                             <%AddressDetails ad=(AddressDetails)request.getSession().getAttribute("address"); %>
<br>

<!-- address -->
<b><%=bc.getBusinessName() %></b>,<br>
Customer ID: <%=bc.getNpId() %><br>
Business Address:<br>
 <%=ad.getBuildingNo()%>, <%=ad.getBuildingName()%>, <%=ad.getStreetName()%>,<br>
<%=ad.getTownName()%> <%=ad.getCityName()%>, <br>
<%=ad.getCountry()%> - <%=ad.getPostalCode()%><br>
Contact Number: <%=ad.getCountryCode()%>-<%=ad.getContactNumber() %>
<br>
<br>
Thank you for choosing Nexus Banking Group for your Commercial
account. We are confident that you will be satisfied with the
services that we offer.The information enclosed will help you
to make the most of our banking services.<br><br>

Account Details:<br>
<table align="left" cellspacing="10" cellpadding="0">
<tr>
<th align="left">Account Number</th>
<th align="left">Account Type</th>
<th align="left">Product Name</th>
<th align="left">Branch</th>
</tr>

<%for(NonPersonalAccountInProgress npa:npaList){ %>
<tr>
<td><%=npa.getAccNumber() %></td>
<td><%=npa.getAccountType() %></td>
<td><%=npa.getProductName() %></td>
<td><%=npa.getBranch()%></td>
<%} %>
</tr>
</table>
<%for(NonPersonalAccountInProgress npa:npaList){ %>
</br></br>
<%} %>
</br></br>
When you call us, 
please have it with you so that we can accelerate your requests. 
If your banking needs any change, we will be happy to help you assess
those needs and offer you the banking services that will help you achieve 
your new goals.<br><br>
If you have questions, please feel free contact us.<br><br>
Sincerely,<br><br>
<img src="<%=request.getContextPath()%>/images/signature.gif" width="120px" height="65px"></img><br/>
(Signature)<br>
Mr.Andrew Brien<br>
Branch Manager<br>
Nexus Banking Group

</div>
<form id="contacts-form2" name="additional_product" method="post" action="/NBG/AccountCreationServlet">
<input type="hidden" name="action" value="saveaspdf"></input>
<div id="non-printable">
<table align="center">
<tr><td colspan="2" style="padding:10px;"><a href="#" class="button" onclick="JavaScript:window.print();" ><em><b>Print</b></em></a></td>
						<td style="padding:10px;"><a href="/NBG/AccountCreationServlet?action=rejecttandc" class="button" ><em><b>Exit</b></em></a>
						<td style="padding:10px;"><a href="#" class="button" onclick="document.additional_product.submit()"><em><b>Save as pdf</b></em></a>
						</td></tr>
</table>
</div>
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
</div>
</div>
<!-- footer -->
<div id="non-printable">
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</div>
</body>
</html><!--





select distinct NP_ID from NON_PERSONAL_ACCOUNT where to_char(ACCOUNT_OPEN_DATE,'YYYY')='2013';
select distinct NP_ID from NON_PERSONAL_ACCOUNT where to_char(ACCOUNT_OPEN_DATE,'Mon')='May';-->