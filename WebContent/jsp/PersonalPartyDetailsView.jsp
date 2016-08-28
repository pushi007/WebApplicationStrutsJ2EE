<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="com.tvm.ilp.t154.cao.model.*"%>

<%@ page import="static com.tvm.ilp.t154.cao.constants.CAOConstants.*" %>
<%@ page import="java.util.*" %>
<html>
<head>
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description" content="Consulting page - free business website template from Template Monster is awating for you to download."/>

<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath()%>/js/maxheight.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/AccountPartyCoreDetailsValidation.js"
	type="text/javascript"></script>
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
<a href="#" style="font-size-adjust: inherit" onclick="return cancelPartyAdditiontoMyPortal();"><span style="font-size:12px">My Portal</span></a>
<br /><br />
<a href="#" style="font-size-adjust: inherit" onclick="return cancelPartyAdditiontoFindCustomer();"><span style="font-size:12px">Find Business</span></a>
<br /><br />
<a href="#" style="font-size-adjust: inherit" onclick="return cancelPartyAdditiontoBusiSummary();"><span style="font-size:12px">Business Summary</span></a>
<br /><br />
<a href="#" style="font-size-adjust: inherit" onclick="return cancelPartyAddition();"><span style="font-size:12px">Account Parties</span></a>
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
                                               <h3  style="align:center;font-family:Arial,Verdana;font-size:16px;color:#000">Account Party Details</h3>

<form name="Account_party_details_Summary" action="/NBG/AccountPartyManagementServlet">
<input type="hidden" name=ACTION value="Party_details_Summary"></input>

<% String BusinessName=(String)request.getAttribute("BusinessName"); %>
<% String BusinessBranch=(String)request.getAttribute("BusinessBranch"); %>

<% 
	PersonalPartyCoreAddressContactDetails partyDetails=new PersonalPartyCoreAddressContactDetails();
	partyDetails=(PersonalPartyCoreAddressContactDetails)request.getAttribute("PartyDetails"); %>


<table width="90%" style="align:center;font-family:Arial,Verdana;font-size:13px;color:#8A3E08">
 <tr>
 <td align="left"><b>Business Name - <%=BusinessName %></b></td>
 <td align="right"><b>Branch Name - <%=BusinessBranch %></b></td>
 </tr>
 </table>

<hr></hr>


<table width="80%">
<tr width="100%">
<td width="80%" style="font-family:Arial,Verdana;font-size:16px;color:#8A3E08;align:left"><b> Personal Details</b></td>
</tr>
</table>

<table cellpadding=10 cellspacing=10>
<tr>
<td align="left"><b>Name</b></td>
<%if(partyDetails.getpPartyCoreDetails().getMiddleName()==null) {%>
<td align="left"><%=partyDetails.getpPartyCoreDetails().getTitle()+" "+partyDetails.getpPartyCoreDetails().getFirstName()+" "+partyDetails.getpPartyCoreDetails().getSurName()%></td>
<%} else { %>
<td align="left"><%=partyDetails.getpPartyCoreDetails().getTitle()+" "+partyDetails.getpPartyCoreDetails().getFirstName()+" "+partyDetails.getpPartyCoreDetails().getMiddleName()+" "+partyDetails.getpPartyCoreDetails().getSurName()%></td>
<% }%>
</tr>

<tr>
<td align="left"><b>Party ID</b></td>
<td align="left"><%=partyDetails.getpPartyCoreDetails().getPartyId()%></td>
</tr>

<tr >
<td align="left"><b>Relationship with Business</b></td>
<td align="left"><%=partyDetails.getpPartyCoreDetails().getRelationshipType()%></td>
</tr>

<tr>
<td align="left"><b>Date of Birth(in yyyy/mm/dd)</b></td>
<td align="left"><%=partyDetails.getpPartyCoreDetails().getDateOfBirth()%></td>
</tr>

<tr>
<td align="left"><b>Is key Party</b></td>
<td align="left"><%=partyDetails.getpPartyCoreDetails().getKeyParty()%></td>
</tr>

<tr>
<td align="left"><b>Is Existing Customer</b></td>
<td align="left"><%=partyDetails.getpPartyCoreDetails().getIsExistingCustomer()%></td>
</tr>

<%if(partyDetails.getpPartyCoreDetails().getAccountNumber()>0){ %>
<tr>
<td align="left"><b>Account No.</b></td>
<td align="left"><%=partyDetails.getpPartyCoreDetails().getAccountNumber()%></td>
</tr>

<tr>
<td align="left"><b>Branch Name</b></td>
<td align="left"><%=partyDetails.getpPartyCoreDetails().getBranchId()%></td>
</tr>
<%} %>
</table>
<hr></hr>


<table width="80%">
<td style="width:80%;font-family:Arial,Verdana;font-size:16px;color:#8A3E08;align:left"><b> Present Address Details</b></td>
</table>

<table cellpadding=10 cellspacing=10>
<tr>
<td align="left"><b>House No. and Name</b></td>
<td align="left"><%=partyDetails.getpPartyPresentAddress().getHouseNo()+", "+partyDetails.getpPartyPresentAddress().getHouseName()%></td>
</tr>

<tr>
<td align="left"><b>Address</b></td>
<td align="left"><%=partyDetails.getpPartyPresentAddress().getBuildingNo()+","+partyDetails.getpPartyPresentAddress().getStreetName()+","+partyDetails.getpPartyPresentAddress().getCityName() %></td>
</tr>

<%if(partyDetails.getpPartyPresentAddress().getTownName()==null) {%>
<tr>
<td align="left"><b></b></td>
<td align="left"><%=partyDetails.getpPartyPresentAddress().getPostalCode() %></td>
</tr>
<%} else { %>
<tr>
<td align="left"><b></b></td>
<td align="left"><%=partyDetails.getpPartyPresentAddress().getTownName()+"-"+partyDetails.getpPartyPresentAddress().getPostalCode() %></td>
</tr>
<%} %>

<tr>
<td align="left"><b></b></td>
<td align="left"><%=partyDetails.getpPartyPresentAddress().getCountryName()+"."%></td>
</tr>
</table>
<hr></hr>

<table width="80%">
<td style="width:80%;font-family:Arial,Verdana;font-size:16px;color:#8A3E08;align:left"><b> Previous Address Details</b></td>
</table>

<table cellpadding=10 cellspacing=10>
<tr>
<td align="left"><b>House No. and Name</b></td>
<td align="left"><%=partyDetails.getpPartyPreviousAddress().getHouseNo()+", "+partyDetails.getpPartyPreviousAddress().getHouseName()%></td>
</tr>

<tr>
<td align="left"><b>Address</b></td>
<td align="left"><%=partyDetails.getpPartyPreviousAddress().getBuildingNo()+","+partyDetails.getpPartyPreviousAddress().getStreetName()+","+partyDetails.getpPartyPreviousAddress().getCityName() %></td>
</tr>

<%if(partyDetails.getpPartyPresentAddress().getTownName()==null) {%>
<tr>
<td align="left"><b></b></td>
<td align="left"><%=partyDetails.getpPartyPresentAddress().getPostalCode() %></td>
</tr>
<%} else { %>
<tr>
<td align="left"><b></b></td>
<td align="left"><%=partyDetails.getpPartyPresentAddress().getTownName()+"-"+partyDetails.getpPartyPresentAddress().getPostalCode() %></td>
</tr>
<%} %>

<tr>
<td align="left"><b></b></td>
<td align="left"><%=partyDetails.getpPartyPreviousAddress().getCountryName()+"."%></td>
</tr>
</table>
<hr></hr>

<table width="80%">
<td style="width:80%;font-family:Arial,Verdana;font-size:16px;color:#8A3E08;align:left"><b> Contact Details</b></td>
</table>

<table cellpadding=10 cellspacing=10>
<tr>
<td align="left"><b>Email Address</b></td>
<td align="left"><%=partyDetails.getpPartyContactDetails().geteMailAddress()%></td>
</tr>

<tr>
<td align="left"><b>Mobile No.</b></td>
<td align="left"><%=partyDetails.getpPartyContactDetails().getMobileNumber()%></td>
</tr>

<tr>
<td align="left"><b>House Contact No.</b></td>
<td align="left"><%=partyDetails.getpPartyContactDetails().getHomeNumber() %></td>
</tr>

<tr>
<td align="left"><b>Office Contact No.</b></td>
<td align="left"><%=partyDetails.getpPartyContactDetails().getOfficeNumber()%></td>
</tr>

<tr>
<td align="left"><b>Id proof</b></td>
<td align="left"><%=partyDetails.getpPartyContactDetails().getIdProofType()%></td>
</tr>

<tr>
<td align="left"><b>Address proof</b></td>
<td align="left"><%=partyDetails.getpPartyContactDetails().getAddressProofType()%></td>
</tr>
</table>


<table cellpadding=10 cellspacing=10>
<tr>
<td colspan="2" width=30% style="align:center;padding:10px"><a href="/NBG/AccountPartyManagementServlet?action=Display_Business_Cust_Detail" class="button" ><em><b>OK</b></em></a></td>
</tr>
</table>

</form>

</div>
</div></div></div></div></div></div></div></div></div></div></div>
<!-- footer -->
<div style="margin-top:15px" ></div>
   <jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>












