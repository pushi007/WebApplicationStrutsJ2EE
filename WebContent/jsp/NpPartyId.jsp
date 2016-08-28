<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%@ page import="static com.tvm.ilp.t154.cao.constants.CAOConstants.*" %>
<head>
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description" content="Consulting page - free business website template from Template Monster is awating for you to download."/>

<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/layout.css" rel="stylesheet" type="text/css" />

<script src="../js/maxheight.js" type="text/javascript"></script>
<script src="../js/AccountPartyAddressvalidation.js" type="text/javascript"></script>

<!--[if lt IE 7]>
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

</head>

<body id="page5" onload="new ElementMaxHeight();">

   <!-- header -->
   <jsp:include page="/jsp/layout/header.jsp"></jsp:include>
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
 	<li style="font-family:Arial,Verdana;font-size:14px;color:#000"><a href="/NBG/CustomerManagementServlet?ACTION=REGISTER" >Business Customer</a></li>
	<li><br/></li>
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
                                               <h3  style="align:center;font-family:Arial,Verdana;font-size:16px;color:#000">Account Party Registration</h3>
<hr></hr>
<form name="AccountPartyAddress" action="/NBG/AccountPartyManagementServlet" onSubmit="return validateform();">
<input type="hidden" name=ACTION value="Business_Id_Name"></input>
<span align=right><b>Fields marked with <span style="color:red;">*</span> are mandatory&nbsp;&nbsp;&nbsp;</span>
<table align="center" cellpadding=10 cellspacing=10 style="position:relative;top:-35px;">
<br><br></br>
<td align="left" width=50%><b>NON PERSONNAL PARTY ID</b><sup><font color="red">*</font></sup></td>
<td width=50%><input type="text" name="BuildingNo" title="Please Enter Building No" /></td>
<tr>
<td align="left"><b>DOCUMENT TYPE</b><sup><font color="red">*</font></sup></td>
<td><input type="text" name="BuildingName" title="Please Enter building name"/></td>
</tr>

<tr>
<td align="left"><b>DOCUMENT</b><sup><font color="red">*</font></sup></td>
<td><input type="text" name="StreetName" title="Please Enter Street name"/></td>
</tr>

<tr>
<td align="left"><b>DATE OF SUBMISSION</b><sup><font color="red">*</font></sup></td>
<td><input type="text" name="CityName" title="Please Enter City name"/></td>
</tr>

<tr>
<td align="left"><b>STATUS</b><sup><font color="red">*</font></sup></td>
<td><input type="text" name="TownName" title="Please Enter Town name"/></td>
</tr>
</table>

<table align="center">
<tr>
<td colspan="2" width=30% style="align:center;padding:10px"><a href="#" class="button" onclick="return validateform();"><em><b>Submit</b></em></a></td>

<td colspan="2" width=30% style="align:center;padding:10px"><a href="#" class="button" onclick="return validateform();"><em><b>Reset</b></em></a></td>
</tr>
</table>
</form>

</div>
</div></div></div></div></div></div></div></div></div></div></div></div></div>
<!-- footer -->
   <jsp:include page="/jsp/layout/footer.jsp"></jsp:include>
</body>
</html>