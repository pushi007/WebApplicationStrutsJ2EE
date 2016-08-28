<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
    <%@page import="static com.tvm.ilp.t154.cao.constants.CAOConstants.*"%>
<%@page import="com.tvm.ilp.t154.cao.model.*"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Search Customer</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />

<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/registration.js" type="text/javascript"></script>
<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
<![endif]--></head>
<body id="page5" onload="new ElementMaxHeight();">
   <!-- header -->
 <jsp:include page="layout/header.jsp"/>
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
                                            
                                             <a href="/NBG/CustomerManagementServlet?action=accopenerportal" style="font-size-adjust: inherit"><span style="font-size:12px"><%String keymyportal=(String)session.getAttribute("keymyportal");
if(keymyportal!=null){out.println(keymyportal);}else {%>My Portal<%} %></span></a>
                                           
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
                                            <h2><%String keysearchbusinesscustomer=(String)session.getAttribute("keysearchbusinesscustomer");
if(keysearchbusinesscustomer!=null){out.println(keysearchbusinesscustomer);}else {%>Search Business Customer<%} %></h2>
                                            <form name="search_form" method="post"action="/NBG/CustomerManagementServlet"> 
<input type="hidden" name="action" value="search" ></input>
<%List<Branch> branch=new ArrayList<Branch>();

String message=(String)request.getAttribute("message");
String messageDelete=(String)request.getAttribute("msg");
branch=(List<Branch>)session.getAttribute("branchList");
%>


<hr>
<% if(messageDelete!=null){ 
	out.println(messageDelete);
	messageDelete="";
	} %>
<b style="color:red;">

<%if(message!=null){
	out.println(message);
	message="";
}%>
</b>
<span >
<br/><br/><b><%String keyfields=(String)session.getAttribute("keyfields");
if(keyfields!=null){out.println(keyfields);}else {%>Fields marked with <%} %><span style="color:red;">*</span><%String keymandatory=(String)session.getAttribute("keymandatory");
if(keymandatory!=null){out.println(keymandatory);}else {%> are mandatory</b>&nbsp;&nbsp;&nbsp;<%} %></span>
<br/>



<table border="0"  style="height: 30%;" cellpadding="10" cellspacing="10">


<tr></tr><tr></tr>

<tr>
<td><b><%String keysearchby=(String)session.getAttribute("keysearchby");
if(keysearchby!=null){out.println(keysearchby);}else {%>Search By<%} %></b><sup><font color="red">*</font></sup></td>
<td><select name="searchBy" tabindex="1" onchange="f();" >
<option value="0">Please Select</option>  
<option value="businessName">Business Name and Branch</option>
<option value="tradingName">Trading Name and Branch</option>
<option value="accountNumber">Account Number</option>
</select>
<label style="color:red" id="error_searchby"></label>
</td>

</tr>

<tr>
<td><b><%String keybusinessname=(String)session.getAttribute("keybusinessname");
if(keybusinessname!=null){out.println(keybusinessname);}else {%>Business Name<%} %> </b></td>
<td> <input type="text" name="businessName" tabindex="2" onblur="return searchBusinessName();" disabled="disabled"
title="Enter Business Name." /><label style="color:red" id="error_businessName"></label></td>

</tr>
<tr>
<td><b><%String keytradingname=(String)session.getAttribute("keytradingname");
if(keytradingname!=null){out.println(keytradingname);}else {%>Trading Name<%} %> </b></td>
<td> <input type="text" name="tradeName" tabindex="3" disabled="disabled" onblur="return searchTradeName();" title="Please Trading Name." /><label style="color:red" id="error_tradeName"></label></td>
<td class="label"></td>
</tr>
<tr>
<td><b><%String keybranch=(String)session.getAttribute("keybranch");
if(keybranch!=null){out.println(keybranch);}else {%>Branch<%} %> <sup><font color="red">*</font></sup></b></td>
<td>
 <select name="branch" tabindex="4" disabled="disabled" onblur="return validateBranch();">
<option value="0">Please Select</option>  
<%for(Branch brnch:branch) {%>
			<option value="<%=brnch.getBranchName()%>"><%=brnch.getBranchName()%></option>
			<% }%>
  
  
  </select>
  <label style="color:red" id="error_branch"></label>
</td>

</tr>
<tr>
<td><b><%String keyaccountno=(String)session.getAttribute("keyaccountno");
if(keyaccountno!=null){out.println(keyaccountno);}else {%>Account Number<%} %> </b></td>
<td> <input type="text" name="accountNo" tabindex="5" onblur="return searchAccount();" disabled="disabled" 
title="Enter the Account Number."/><label style="color:red" id="error_account"></label></td>

</tr>

</table>
<table >
	<tr>
<td width=50% colspan="2" style="align: left; padding: 10px;"><a class="button"  tabindex="6" onclick="return validateSearchForm();"><em><b><%String keysearch=(String)session.getAttribute("keysearch");
if(keysearch!=null){out.println(keysearch);}else {%>Search<%} %></b></em></a></td>
<%if(message!=null) {%>
<td width=50% colspan="2" style="align: left; padding: 10px;"><a href="/NBG/CustomerManagementServlet?action=register" class="button" tabindex="7" ><em><b>&nbsp;Create Business&nbsp;</b></em></a></td>
<%} %>
</tr>
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
               <!-- box end -->
            </div>
         </div>
     
   <!-- footer -->
    <div style="margin-top:15px" ></div>
   <jsp:include page="layout/footer.jsp"></jsp:include>
</body>

</html>