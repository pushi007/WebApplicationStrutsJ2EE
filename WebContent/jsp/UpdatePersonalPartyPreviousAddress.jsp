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
<script src="<%=request.getContextPath() %>/js/AccountPartyUpdateValidation.js"
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
<a href="#" style="font-size-adjust: inherit" onclick="return cancelPartyAdditiontoMyPortal();"><span style="font-size:15px">My Portal</span></a>
<br /><br />
<a href="#" style="font-size-adjust: inherit" onclick="return cancelPartyAdditiontoFindCustomer();"><span style="font-size:15px">Find Business</span></a>
<br /><br />
<a href="#" style="font-size-adjust: inherit" onclick="return cancelPartyAdditiontoBusiSummary();"><span style="font-size:15px">Business Summary</span></a>
<br /><br />
<a href="#" style="font-size-adjust: inherit" onclick="return cancelPartyAddition();"><span style="font-size:15px">Account Parties</span></a>
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
                                               <h3  style="align:center;font-family:Arial,Verdana;font-size:16px;color:#000">Account Party Registration</h3>

<% PersonalPartyAddress PartyPreviousAddressObject=new PersonalPartyAddress();
	PartyPreviousAddressObject=(PersonalPartyAddress)request.getSession().getAttribute("PartyPreviousAddressObject"); %>

<form name="Update_Account_party_previous_address_details" action="/NBG/AccountPartyManagementServlet" method="post">
<input type="hidden" name=action value="Update_Account_party_previous_address_detail"></input>
<%List<Country> countryList=new ArrayList<Country>(); 
countryList=(List<Country>)request.getAttribute("countryList");%>
<% String BusinessName=(String)request.getAttribute("BusinessName"); %>
<% String BusinessBranch=(String)request.getAttribute("BusinessBranch"); %>

<table width="90%" style="align:center;font-family:Arial,Verdana;font-size:13px;color:#8A3E08">
 <tr>
 <td align="left"><b>Business Name - <%=BusinessName %></b></td>
 <td align="right"><b>Branch Name - <%=BusinessBranch %></b></td>
 </tr></table>

<hr></hr>

<h4  style="align:left;font-family:Arial,Verdana;font-size:16px;color:#8A3E08">Update Previous Address Details</h4>
<span style="align: right"><b>Fields marked with<span
	style="color: red;">*</span> are mandatory</b> &nbsp;&nbsp;&nbsp;</span>
<table align="left" cellpadding=10 cellspacing=10 width="95%">
<tr>
<td align="left" width="20%">House No<sup><font color="red">*</font></sup></td>
<td align="left" width="20%"><input type="text" name="previousHouseNo" id="previousHouseNo" value="<%=PartyPreviousAddressObject.getHouseNo() %>" maxlength="10" onblur="return validHouseNoPr();"/></td>
<td align="left" width="60%"><label id="err_msg1" style="color: red;"></label></td>
</tr>
<tr>
<td align="left">House Name<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" name="previousHouseName" id="previousHouseName" value="<%=PartyPreviousAddressObject.getHouseName() %>" maxlength="30" onblur="return validHouseNamePr();"/></td>
<td align="left"><label id="err_msg2" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Building No<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" name="previousBuildingNo" id="previousBuildingNo" value="<%=PartyPreviousAddressObject.getBuildingNo() %>" maxlength="10" onblur="return validBuildingNoPr();""/></td>
<td align="left"><label id="err_msg3" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Street Name<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" name="previousStreet" id="previousStreet" value="<%=PartyPreviousAddressObject.getStreetName() %>" maxlength="40" onblur="return validStreetNamePr();"/></td>
<td align="left"><label id="err_msg4" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">City<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" name="previousCity" id="previousCity" value="<%=PartyPreviousAddressObject.getCityName() %>" maxlength="30" onblur="return validCityPr();"/></td>
<td align="left"><label id="err_msg5" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Town</td>
<td align="left"><input type="text" name="previousTown" id="previousTown" value="<%=PartyPreviousAddressObject.getTownName() %>" maxlength="30" onblur="return validTownPr();"></td>
<td align="left"><label id="err_msg6" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Country<sup><font color="red">*</font></sup></td>
<td align="left"><select id="previousCountry" name="previousCountry" value="<%=PartyPreviousAddressObject.getCountryName() %>">
			<%for(Country country:countryList) {%>
			<OPTION VALUE="<%=country.getCountryName()%>"><%=country.getCountryName()%></OPTION>
			<% }%>
		</select></td>
</tr>

<tr>
<td align="left">Postal Code<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" name="previousPostalCode" id="previousPostalCode" value="<%=PartyPreviousAddressObject.getPostalCode() %>" maxlength="10" onblur="return validPostalCodePr();"/></td>
<td align="left"><label id="err_msg8" style="color: red;"></label></td>
</tr>

<tr></tr>
<tr></tr>
<tr>
<td colspan="1" style="align:center;padding:10px"><a href="#" class="button" onclick="return validatePreviousAddresUpdate();"><em><b>Save</b></em></a></td>
<td colspan="1" style="align:center;padding:10px"><a href="/NBG/AccountPartyManagementServlet?action=Cancel_party_updation" class="button"><em><b>Cancel</b></em></a></td>

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
