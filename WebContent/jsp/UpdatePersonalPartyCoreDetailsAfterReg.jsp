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

<form name="Account_party_core_details_update" action="/NBG/AccountPartyManagementServlet" method="post">
<input type="hidden" name=action value="Update_Account_party_core_detail_update_after_reg"></input>

<% PersonalParty personalPartyObject=new PersonalParty(); 
	personalPartyObject=(PersonalParty)request.getAttribute("PartyCoreDetails");%>
<% String BusinessName=(String)request.getAttribute("BusinessName"); %>
<% String BusinessBranch=(String)request.getAttribute("BusinessBranch"); %>
<% String UpdateType=(String)request.getAttribute("updateType"); %>

<table width="90%" style="align:center;font-family:Arial,Verdana;font-size:13px;color:#8A3E08">
 <tr>
 <td align="left"><b>Business Name - <%=BusinessName %></b></td>
 <td align="right"><b>Branch Name - <%=BusinessBranch %></b></td>
 </tr></table>

<hr></hr>

<h4  style="align:left;font-family:Arial,Verdana;font-size:16px;color:#8A3E08">Update Personal Details</h4>
<span style="align: right"><b>Fields marked with<span
	style="color: red;">*</span> are mandatory</b> &nbsp;&nbsp;&nbsp;</span>
<table align="left" cellpadding=10 cellspacing=10 width="95%">
<tr>
<td align="left" width="20%">Title<sup><font color="red">*</font></sup></td>
<td align="left" width="20%"><select name="title" <%if(UpdateType.equals("AccountCreated")) { out.println("disabled");} %>>
<option value="Mr." <%if(personalPartyObject.getTitle().equals("Mr.")){out.println("selected");} %>>Mr.</option>
<option value="Ms." <%if(personalPartyObject.getTitle().equals("Ms.")){out.println("selected");} %>>Ms.</option>
<option value="Mrs." <%if(personalPartyObject.getTitle().equals("Mrs.")){out.println("selected");} %>>Mrs.</option>
</select></td>
<td><label id="err_msg1" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">First Name<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" maxlength="20" name="firstName" value="<%=personalPartyObject.getFirstName()%>" <%if(UpdateType.equals("AccountCreated")) { out.println("readonly");} %> onblur="return validFName();"></input></td>
<td><label id="err_msg2" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Middle Name</td>
<%if(personalPartyObject.getMiddleName()==null) {%>
<td align="left"><input type="text" maxlength="20" name="middleName" <%if(UpdateType.equals("AccountCreated")) { out.println("readonly");} %> onblur="return validMName();"></input></td>
<%} else {%>
<td align="left"><input type="text" maxlength="20" name="middleName" value="<%=personalPartyObject.getMiddleName()%>" <%if(UpdateType.equals("AccountCreated")) { out.println("readonly");} %> onblur="return validMName();"></input></td>
<%}%>
<td ><label id="err_msg3" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Last Name<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" maxlength="20" name="lastName" value="<%=personalPartyObject.getSurName() %>" <%if(UpdateType.equals("AccountCreated")) { out.println("readonly");} %> onblur="return validLName();"></input></td>
<td><label id="err_msg4" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Relationship  Type<sup><font color="red">*</font></sup></td>
<td align="left"><select name="relationshipType">
<option value="Director" <%if(personalPartyObject.getRelationshipType().equals("Director")){out.println("selected");} %>>Director</option>
<option value="Owner" <%if(personalPartyObject.getRelationshipType().equals("Owner")){out.println("selected");} %>>Owner</option>
<option value="Partner" <%if(personalPartyObject.getRelationshipType().equals("Partner")){out.println("selected");} %>>Partner</option>
<option value="Trustee" <%if(personalPartyObject.getRelationshipType().equals("Trustee")){out.println("selected");} %>>Trustee</option>
<option value="Other" <%if(personalPartyObject.getRelationshipType().equals("Other")){out.println("selected");} %>>Other</option>
</select></td>
</tr>

<tr>
<td align="left">Date of Birth(in yyyy/mm/dd)<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" name="dateOfBirth" value="<%=personalPartyObject.getDateOfBirth() %>" readonly="readonly"></td>
<td width="60%"><label id="err_msg6" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Is Key Party<sup><font color="red">*</font></sup></td>
<td align="left">
<input type="radio" name="keyParty" value="Yes" <%if(personalPartyObject.getKeyParty().equals("Yes")) { out.println("checked");} %> >Yes</input>
<input type="radio" name="keyParty" value="No" <%if(personalPartyObject.getKeyParty().equals("No")) { out.println("checked");} %>>No</input>
</td></tr>

<tr>
<tr>
<td colspan="1" style="align:center;padding:10px"><a href="#" class="button" onclick="return validateCoreDetailsUpdateForm();"><em><b>Save</b></em></a></td>
<td colspan="1" style="align:center;padding:10px"><a href="/NBG/AccountPartyManagementServlet?action=Cancel_party_updationAftReg" class="button"><em><b>Cancel</b></em></a></td>

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















