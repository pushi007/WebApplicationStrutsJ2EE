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

<%@page import="com.tvm.ilp.t154.cao.model.NonPersonalCustomer"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Nexus Banking Group</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description" content="Consulting page - free business website template from Template Monster is awating for you to download."/>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/registration.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/updateAdditionalValidation.js" type="text/javascript"></script>
<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

</head>
<body id="page5" >
   <!-- header -->
   <jsp:include page="layout/header.jsp" />
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
                                        <a href="#" onclick="return validateMyPortal();" style="font-size-adjust: inherit"><span style="font-size:12px">My Portal</span></a>
	<br /><br />
	<a href="#" onclick="return validateFind();" style="font-size-adjust: inherit"><span style="font-size:12px">Find
	Business</span></a><br /><br />
	<a href="/NBG/AccountPartyManagementServlet?action=Display_Business_Cust_Detail" style="font-size-adjust: inherit"><span style="font-size:12px">Account Parties</span></a>
                                            
                                            
                                            <br>
	
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br>
	</br>
	<br/>
	<br>
	</br>
	<br/>
	<br/>
	
<input type="hidden" />	
                                            
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
                                             <h2>Business Customer Profile Updation</h2>
                                             <form name="updateAdditional_form"  action="/NBG/CustomerManagementServlet" method="post"onSubmit="return  validateform();">
                                             <input type="hidden" name="action" value="updateadditionaldatadatadetails"/>
 <%NonPersonalCustomer npCustomer=(NonPersonalCustomer)session.getAttribute("npCustomer"); %>                                           
<font color="#8A3E08"> <h3 align="center"><B></B></h3></font>
<hr>
<font color="#8A3E08"><h3><b>Update Additional Details</b></h3><br></font>
<span align=right><b>Fields marked with <span style="color:red;">*</span> are mandatory</b>&nbsp;&nbsp;&nbsp;</span><br><br>
 <input type="hidden" name="action" value="registerAdditional"/> 
<table  style="height: 100%;" cellpadding="5">

<tr>
<td><b>Industry Sector<sup><font color="red">*</font></sup></b></td>
<td>
<select id="edate" name="industrySector" onchange="return validateIndustrySec();">
<option value="0" selected>Please select</option>
<option <%if(npCustomer.getIndustrySector().equalsIgnoreCase("Primary(Extractive)")){out.println("selected");} %> value="Primary(Extractive)">Primary(Extractive)</option> 
<option <%if(npCustomer.getIndustrySector().equalsIgnoreCase("Secondary(Manufacturing)")){out.println("selected");} %> value="Secondary(Manufacturing)">Secondary(Manufacturing)</option> 
<option <%if(npCustomer.getIndustrySector().equalsIgnoreCase("Tertiary(Service)")){out.println("selected");} %> value="Tertiary(Service)">Tertiary(Service)</option> 
</select>
<label style="color:red" id="error_industrysector"></label>
</td>
</tr>



<tr>
	<td><b>Main Activity <sup><font color="red">*</font></sup></b></td>
   	 <td><input type="text" name="mainActivity" tabindex="1" title="Enter Main Activity of Business"  value=<%=npCustomer.getMainActivity() %> onblur="return validateMainActivity();"/></td>
   	 <td><label style="color:red" id="error_mainActivity"></label></td>
</tr>

<tr>
	<td><b>Precise Activity <sup><font color="red">*</font></sup></b></td>
   	 <td><input type="text" name="preciseActivity" tabindex="2" value=<%=npCustomer.getPreciseActivity() %>
   	  title="Enter Precise Activity of Business" onblur="return validatePreciseActivity();"/></td>
   	  <td><label style="color:red" id="error_preciseActivity"></label></td>
</tr>

<tr>
<td><b>Do you Import or Export Goods?<sup><font color="red">*</font></sup></b></td>
<td><input type="radio" name="importExport" tabindex="3" onblur="return doImportExport();" value="Yes" <%if(npCustomer.getImportExport().equalsIgnoreCase("yes")){out.println("checked");} %> >Yes</input>
<input type="radio" name="importExport" tabindex="4"  value="No" <%if(npCustomer.getImportExport().equalsIgnoreCase("no")){out.println("checked");} %> >No</input><label  style="color:red;"  id="error_importExport"></label></td>
</tr>

<tr>
<td><b>Does your Business require Funding?<sup><font color="red">*</font></sup></b></td>
<td><input type="radio" id="yes" name="requireFunding" tabindex="5" onblur="return doRequireFund();" onclick="reg();" value="Yes" <%if(npCustomer.getRequireFunding().equalsIgnoreCase("yes")){out.println("checked");} %> >Yes</input>
<input type="radio" id="no" name="requireFunding" tabindex="6" onclick="reg();" value="No" <%if(npCustomer.getRequireFunding().equalsIgnoreCase("no")){out.println("checked");} %> >No</input>
<label style="color:red;" id="error_fund"></label></td>
</tr>

<tr>
<td><b>How much Funding do you require?</b>(in Thousand Pounds )<sup>*</sup></td>
<td>
<input type="text" title="Enter Funding Amount required" onchange="return validateFundingAmount();"  value=<%=npCustomer.getFundAmount() %> name="fundAmount" tabindex="7"/>
<label style="color:red;" id="error_fundamount"></label>
</td>

</tr>



<tr>
<td><b>Are you a part of a Group or a Franchise?<sup><font color="red">*</font></sup></b></td>
<td><input type="radio" id="partFranchiseYes" name="partOfGroup"  tabindex="8" onblur="return arePartOfGroup();" onclick="reg();" value="Yes" <%if(npCustomer.getPartOfGroup().equalsIgnoreCase("yes")){out.println("checked");} %> onchange="reg();">Yes</input>
<input type="radio" id="partFranchiseNo" name="partOfGroup"  tabindex="9" onblur="return arePartOfGroup();" onclick="reg();" value="No" <%if(npCustomer.getPartOfGroup().equalsIgnoreCase("no")){out.println("checked");} %> >No</input><label style="color:red;" id="error_part"></label></td>
</tr>

<tr>
	<td><b>Franchise Details</b></td>
	<td><textarea  rows="5"  cols="25" onchange="return validatePartGroup();" name="franchiseDetails" tabindex="10" title=""><%=npCustomer.getFranchiseDetails() %></textarea>
	<label style="color:red;" id="error_groupdetails"></label></td>
</tr>

</table>
<table>
<tr>
<td>
*could be upto 5 Million Pounds depending on factors under consideration.
</td>
</tr>
</table>
<table >
	<tr>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a type="submit"
			class="button" tabindex="11" onclick="return validateRegAdditionalForm();"><em><b>Continue</b></em></a>
		</td>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a
			href="/NBG/CustomerManagementServlet?action=viewdetails&&id=<%=npCustomer.getBusinessId() %>" class="button" tabindex="12"><em><b>Cancel</b></em></a></td>
	</tr>
</table>
</form>                                          </div>
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
         </div>
   
   <!-- footer -->
    <div style="margin-top:15px" ></div>
   <jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>