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
<script src="<%=request.getContextPath() %>/js/AccountPartyUpdateAfterRegValidation.js"
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
                                               <h3  style="align:center;font-family:Arial,Verdana;font-size:16px;color:#000">Update Account Party</h3>

<form name="Update_Account_party_contact_details" action="/NBG/AccountPartyManagementServlet" method="post">
<input type="hidden" name=action value="Update_Account_party_contact_detail_after_reg"></input>

<% String BusinessName=(String)request.getAttribute("BusinessName"); %>
<% String BusinessBranch=(String)request.getAttribute("BusinessBranch"); %>
<%PersonnalPartyContactDetails pPartyContactDetails = new PersonnalPartyContactDetails();
	pPartyContactDetails=(PersonnalPartyContactDetails)request.getAttribute("pPartyContactDetails");
%> 

<table width="90%" style="align:center;font-family:Arial,Verdana;font-size:13px;color:#8A3E08">
 <tr>
 <td align="left"><b>Business Name - <%=BusinessName %></b></td>
 <td align="right"><b>Branch Name - <%=BusinessBranch %></b></td>
 </tr></table>

<hr></hr>

<h4  style="align:left;font-family:Arial,Verdana;font-size:16px;color:#8A3E08">Update Contact Details</h4>
<span style="align: right"><b>Fields marked with<span
	style="color: red;">*</span> are mandatory</b> &nbsp;&nbsp;&nbsp;</span>
<table align="left" cellpadding=10 cellspacing=10 width="95%">

<tr>
<td align="left" width="20%">Email address<sup><font color="red">*</font></sup></td>
<td align="left" width="40%"><input type="text" name="eMailAddress" value="<%=pPartyContactDetails.geteMailAddress() %>" size="35"  maxlength="40" onblur="return validEmail();" title="Please enter email address"/></td>
<td width="35%"><label id="err_msg1" style="color: red;"></label></td>
</tr>

<tr>
	<td align="left">Mobile No.<sup><font color="red">*</font></sup></td>	
	<td align="left"><input type="text" name="mobileNo" title="Please enter mobile number" value="<%=pPartyContactDetails.getMobileNumber() %>" title="Please enter country code" size=15 maxlength="13" onblur="return validmobile1();"/></td>
	<td><label id="err_msg2" style="color: red;"></label></td>
</tr>

<tr>
	<td align="left">Home Contact No.<sup><font color="red">*</font></sup></td>	
	<td align="left"><input type="text" name="HomeNo" title="Please enter home contact no." value="<%=pPartyContactDetails.getHomeNumber() %>" title="Please enter country code" size=22 maxlength="13" onblur="return validhomeCountryCode();"/></td>
	<td><label id="err_msg3" style="color: red;"></label></td>
</tr>

<tr>
	<td align="left"> Office Contact No.<sup><font color="red">*</font></sup></td>	
	<td align="left"><input type="text" name="OfficNo" title="Please enter office contact no." value="<%=pPartyContactDetails.getOfficeNumber() %>" title="Please enter country code" size=22 maxlength="13" onblur="return validofficeCountryCode();"/></td>
 	<td><label id="err_msg4" style="color: red;"></label></td>
</tr>
<!--<tr><td></td></tr>
<tr><td></td></tr>
<tr>
	<td align="left">Id Proof<sup><font color="red">*</font></sup></td>
	<td align="left">
	<select id="idProofType" name="idProofType">
	<option value="Bank Account Statement" <%if (pPartyContactDetails.getIdProofType().equalsIgnoreCase("Bank Account Statement")){out.println("selected");} %>>Bank Account Statement</option>
	<option value="Driving License" <%if (pPartyContactDetails.getIdProofType().equalsIgnoreCase("Driving License")){out.println("selected");} %>>Driving License</option>
	<option value="Electricity Bill" <%if (pPartyContactDetails.getIdProofType().equalsIgnoreCase("Electricity Bill")){out.println("selected");} %>>Electricity Bill</option>
	<option value="Employer Certificate" <%if (pPartyContactDetails.getIdProofType().equalsIgnoreCase("Employer Certificate")){out.println("selected");} %>>Employer Certificate</option>
	<option value="Passport" <%if (pPartyContactDetails.getIdProofType().equalsIgnoreCase("Passport")){out.println("selected");} %>>Passport</option>
	<option value="Telephone Bill" <%if (pPartyContactDetails.getIdProofType().equalsIgnoreCase("Telephone Bill")){out.println("selected");} %>>Telephone Bill</option>
	<option value="Voters Identity Card" <%if (pPartyContactDetails.getIdProofType().equalsIgnoreCase("Voters Identity Card")){out.println("selected");} %>>Voters Identity Card</option>
	</select>
	</td>
	<td><label id="err_msg5" style="color: red;"></label></td>
</tr>

<tr>
	<td align="left">Attach Id Proof <sup><font color="red">*</font></sup></td>
    <td align="left">
	<input type="file" name="idProofFile" id="idProofFile" title="Upload a pdf file" value="<%=pPartyContactDetails.getIdProofFile()%>">
	<br>Upload Proof document in .pdf format 
	</td>
	<td><label id="err_msg6" style="color: red;"></label></td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr>
	<td align="left">Address Proof<sup><font color="red">*</font></sup></td>
	<td align="left">
	<select id="addressProofType" name="addressProofType">
	<option value="Bank Account Statement" <%if (pPartyContactDetails.getAddressProofType().equalsIgnoreCase("Bank Account Statement")){out.println("selected");} %>>Bank Account Statement</option>
	<option value="Driving License" <%if (pPartyContactDetails.getAddressProofType().equalsIgnoreCase("Driving License")){out.println("selected");} %>>Driving License</option>
	<option value="Electricity Bill" <%if (pPartyContactDetails.getAddressProofType().equalsIgnoreCase("Electricity Bill")){out.println("selected");} %>>Electricity Bill</option>
	<option value="Employer Certificate" <%if (pPartyContactDetails.getAddressProofType().equalsIgnoreCase("Employer Certificate")){out.println("selected");} %>>Employer Certificate</option>
	<option value="Passport" <%if (pPartyContactDetails.getAddressProofType().equalsIgnoreCase("Passport")){out.println("selected");} %>>Passport</option>
	<option value="Voters Identity Card" <%if (pPartyContactDetails.getAddressProofType().equalsIgnoreCase("Voters Identity Card")){out.println("selected");} %>>Voters Identity Card</option>
	</select>
	</td>
	<td><label id="err_msg7" style="color: red;"></label></td>
</tr>

<tr>
	<td align="left">Attach Address Proof<sup><font color="red">*</font></sup> </td>
    <td align="left">
	<input type="file" name="addressProofFile" id="addressProofFile" title="Upload a pdf file" value="<%=pPartyContactDetails.getAddressProofFile()%>">
	<br>Upload Proof document in .pdf format 
	</td>
	<td><label id="err_msg8" style="color: red;"></label></td>
</tr>

--><tr></tr>
<tr></tr>

<tr>
<td colspan="1" style="align:center;padding:10px"><a href="#" class="button" onclick="return validatePartyContactsUpdate();"><em><b>Save</b></em></a></td>
<td>
<table>
<tr>
<td width="40%"><a href="/NBG/AccountPartyManagementServlet?action=Cancel_party_updationAftReg" class="button"><em><b>Cancel</b></em></a></td>
</tr>
</table>
</td>
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

