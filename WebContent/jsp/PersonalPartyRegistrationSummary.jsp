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
                                               <h3  style="align:center;font-family:Arial,Verdana;font-size:16px;color:#000">Personal Party Registration Summary</h3>

<form name="Account_party_details_Summary" action="/NBG/AccountPartyManagementServlet">
<input type="hidden" name=action value="Party_details_Summary"></input>

<% String BusinessName=(String)request.getAttribute("BusinessName"); %>
<% String BusinessBranch=(String)request.getAttribute("BusinessBranch"); %>

<% 
	PersonalParty personalPartyObject=new PersonalParty();
	personalPartyObject=(PersonalParty)request.getSession().getAttribute("PartyObject");
	
	PersonalPartyAddress PartyPresentAddressObject=new PersonalPartyAddress();
	PartyPresentAddressObject=(PersonalPartyAddress)request.getSession().getAttribute("PartyPresentAddressObject");
	
	PersonalPartyAddress PartyPreviousAddressObject=new PersonalPartyAddress();
	PartyPreviousAddressObject=(PersonalPartyAddress)request.getSession().getAttribute("PartyPreviousAddressObject");
	
	PersonnalPartyContactDetails pPartyContactDetails = new PersonnalPartyContactDetails();
	pPartyContactDetails=(PersonnalPartyContactDetails)request.getSession().getAttribute("PersonalPartyContactDetails");

%>

<table width="90%" style="align:center;font-family:Arial,Verdana;font-size:13px;color:#8A3E08">
 <tr>
 <td align="left"><b>Business Name - <%=BusinessName %></b></td>
 <td align="right"><b>Branch Name - <%=BusinessBranch %></b></td>
 </tr>
 </table>

<hr></hr>


<table width="95%">
<tr width="100%">
<td width="80%" style="font-family:Arial,Verdana;font-size:16px;color:#8A3E08;align:left"><b> Personal Details</b></td>
<td width="20%" style="align:center;padding:10px"><a href="/NBG/AccountPartyManagementServlet?action=UpadtePersonalPartyCoreDetails" class="button" ><em><b>Edit</b></em></a></td>
</tr>
</table>

<table cellpadding=10 cellspacing=10>
<tr>
<td align="left"><b>Name</b></td>
<td align="left">
<%if(personalPartyObject.getMiddleName().equals("")) {%>
<%=personalPartyObject.getTitle()+" "+personalPartyObject.getFirstName()+" "+personalPartyObject.getSurName()%>
<%} else { %>
<%=personalPartyObject.getTitle()+" "+personalPartyObject.getFirstName()+" "+personalPartyObject.getMiddleName()+" "+personalPartyObject.getSurName()%>
<%} %>
</td>
</tr>

<tr >
<td align="left"><b>Relationship with Business</b></td>
<td align="left"><%=personalPartyObject.getRelationshipType()%></td>
</tr>

<tr>
<td align="left"><b>Date of Birth(in yyyy/mm/dd)</b></td>
<td align="left"><%=personalPartyObject.getDateOfBirth()%></td>
</tr>

<tr>
<td align="left"><b>Is key Party</b></td>
<td align="left"><%=personalPartyObject.getKeyParty()%></td>
</tr>

<%if(personalPartyObject.getAccountNumber()>0){ %>
<tr>
<td align="left"><b>Is Existing Customer</b></td>
<td align="left"><%=personalPartyObject.getIsExistingCustomer()%></td>
</tr>

<tr>
<td align="left"><b>Account number</b></td>
<td align="left"><%=personalPartyObject.getAccountNumber()%></td>
</tr>

<tr>
<td align="left"><b>Branch name</b></td>
<td align="left"><%=personalPartyObject.getBranchId()%></td>
</tr>
<%} %>
</table>
<hr></hr>


<table width="95%">
<td style="width:80%;font-family:Arial,Verdana;font-size:16px;color:#8A3E08;align:left"><b> Present Address Details</b></td>
<td colspan="1" width="20%" style="align:center;padding:10px"><a href="/NBG/AccountPartyManagementServlet?action=UpadtePersonalPartyPresentAddress" class="button" ><em><b>Edit</b></em></a></td>
</table>

<table cellpadding=10 cellspacing=10>
<tr>
<td align="left"><b>House No. and Name</b></td>
<td align="left"><%=PartyPresentAddressObject.getHouseNo()+", "+PartyPresentAddressObject.getHouseName()%></td>
</tr>

<tr>
<td align="left"><b>Address</b></td>
<td align="left"><%=PartyPresentAddressObject.getBuildingNo()+","+PartyPresentAddressObject.getStreetName()+","+PartyPresentAddressObject.getCityName() %></td>
</tr>

<%if(PartyPresentAddressObject.getTownName().equals("")){ %>
<tr>
<td align="left"><b></b></td>
<td align="left"><%=PartyPresentAddressObject.getPostalCode() %></td>
</tr>
<%} else { %>
<tr>
<td align="left"><b></b></td>
<td align="left"><%=PartyPresentAddressObject.getTownName()+"-"+PartyPresentAddressObject.getPostalCode() %></td>
</tr>
<%} %>

<tr>
<td align="left"><b></b></td>
<td align="left"><%=PartyPresentAddressObject.getCountryName()+"."%></td>
</tr>
</table>
<hr></hr>

<table width="95%"><tr>
<td style="width:80%;font-family:Arial,Verdana;font-size:16px;color:#8A3E08;align:left"><b> Previous Address Details</b></td>
<td colspan="1" width="20%" style="align:center;padding:10px"><a href="/NBG/AccountPartyManagementServlet?action=UpdatePersonalPartyPreviousAddress" class="button" ><em><b>Edit</b></em></a></td>
</tr>
</table>

<table cellpadding=10 cellspacing=10>
<tr>
<td align="left"><b>House No. and Name</b></td>
<td align="left"><%=PartyPreviousAddressObject.getHouseNo()+", "+PartyPreviousAddressObject.getHouseName()%></td>
</tr>

<tr>
<td align="left"><b>Address</b></td>
<td align="left"><%=PartyPreviousAddressObject.getBuildingNo()+","+PartyPreviousAddressObject.getStreetName()+","+PartyPreviousAddressObject.getCityName() %></td>
</tr>

<%if(PartyPreviousAddressObject.getTownName().equals("")){ %>
<tr>
<td align="left"><b></b></td>
<td align="left"><%=PartyPreviousAddressObject.getPostalCode() %></td>
</tr>
<%} else { %>
<tr>
<td align="left"><b></b></td>
<td align="left"><%=PartyPreviousAddressObject.getTownName()+"-"+PartyPreviousAddressObject.getPostalCode() %></td>
</tr>
<%} %>

<tr>
<td align="left"><b></b></td>
<td align="left"><%=PartyPreviousAddressObject.getCountryName()+"."%></td>
</tr>
</table>
<hr></hr>

<table width="95%"><tr>
<td style="width:80%;font-family:Arial,Verdana;font-size:16px;color:#8A3E08;align:left"><b> Contact Details</b></td>
<td colspan="1" width="20%" style="align:center;padding:10px"><a href="/NBG/AccountPartyManagementServlet?action=UpadtePersonalPartyContactDetails" class="button" ><em><b>Edit</b></em></a></td>
</tr>
</table>

<table cellpadding=10 cellspacing=10>
<tr>
<td align="left"><b>Email Address</b></td>
<td align="left"><%=pPartyContactDetails.geteMailAddress()%></td>
</tr>

<tr>
<td align="left"><b>Mobile No.</b></td>
<td align="left"><%=pPartyContactDetails.getMobileNumber()%></td>
</tr>

<tr>
<td align="left"><b>House Contact No.</b></td>
<td align="left"><%=pPartyContactDetails.getHomeNumber() %></td>
</tr>

<tr>
<td align="left"><b>Office Contact No.</b></td>
<td align="left"><%=pPartyContactDetails.getOfficeNumber()%></td>
</tr>

<tr>
<td align="left"><b>Id proof</b></td>
<td align="left"><%=pPartyContactDetails.getIdProofType()%></td>
</tr>

<tr>
<td align="left"><b>Address proof</b></td>
<td align="left"><%=pPartyContactDetails.getAddressProofType()%></td>
</tr>
</table>


<table cellpadding=10 cellspacing=10>
<tr>	
<td colspan="2" width=30% style="align:center;padding:10px"><a href="/NBG/AccountPartyManagementServlet?action=Party_details_Summary" class="button" ><em><b>Confirm</b></em></a></td>
<td colspan="2" width=30% style="align:center;padding:10px"><a href="/NBG/AccountPartyManagementServlet?action=Display_Business_Cust_Detail" class="button" ><em><b>Cancel</b></em></a></td>
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












