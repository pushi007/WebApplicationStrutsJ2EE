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
<script src="<%=request.getContextPath() %>/js/SelectedPartyAction.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/AccountPartyCoreDetailsValidation.js"
	type="text/javascript"></script>

<!--[if lt IE 7]>
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

<script>
// }}}
// {{{ settings (Editable)

var calendarWindow = null;
var calendarColors = new Array();
calendarColors['bgColor'] = '#BDC5D0';
calendarColors['borderColor'] = '#333366';
calendarColors['headerBgColor'] = '#143464';
calendarColors['headerColor'] = '#FFFFFF';
calendarColors['dateBgColor'] = '#8493A8';
calendarColors['dateColor'] = '#004080';
calendarColors['dateHoverBgColor'] = '#FFFFFF';
calendarColors['dateHoverColor'] = '#8493A8';
var calendarMonths = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December');
var calendarWeekdays = new Array('Sun', 'Mon', 'Tue', 'Wed', 'Thur', 'Fri', 'Sat', 'Sun');
var calendarUseToday = true;
var calendarFormat = 'y/m/d';
var calendarStartMonday = true;
var calendarScreenX = 100; // either 'auto' or numeric
var calendarScreenY = 50; // either 'auto' or numeric

// }}}
// {{{ getCalendar()

function getCalendar(in_dateField) 
{
    if (calendarWindow && !calendarWindow.closed) {
        alert('Calendar window already open.  Attempting focus...');
        try {
            calendarWindow.focus();
        }
        catch(e) {}
        
        return false;
    }

    var cal_width = 415;
    var cal_height = 310;

    // IE needs less space to make this thing
    if ((document.all) && (navigator.userAgent.indexOf("Konqueror") == -1)) {
        cal_width = 410;
    }

    calendarTarget = in_dateField;
    calendarWindow = window.open('<%=request.getContextPath()%>/jsp/calendar.jsp', 'dateSelectorPopup','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=0,dependent=no,width='+cal_width+',height='+cal_height + (calendarScreenX != 'auto' ? ',screenX=' + calendarScreenX : '') + (calendarScreenY != 'auto' ? ',screenY=' + calendarScreenY : ''));

    return false;
}

// }}}
// {{{ killCalendar()

function killCalendar() 
{
    if (calendarWindow && !calendarWindow.closed) {
        calendarWindow.close();
    }
}

// }}}

</script>


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
                                               <h3  style="align:center;font-family:Arial,Verdana;font-size:16px;color:#000">Account Party Registration</h3>

<form name="Account_party_contact_details" action="/NBG/AccountPartyManagementServlet" method="post">
<input type="hidden" name=action value="Account_party_contact_detail"></input>

<% String BusinessName=(String)request.getAttribute("BusinessName"); %>
<% String BusinessBranch=(String)request.getAttribute("BusinessBranch"); %>

<table width="90%" style="align:center;font-family:Arial,Verdana;font-size:13px;color:#8A3E08">
 <tr>
 <td align="left"><b>Business Name - <%=BusinessName %></b></td>
 <td align="right"><b>Branch Name - <%=BusinessBranch %></b></td>
 </tr></table>

<hr></hr>

<h4  style="align:left;font-family:Arial,Verdana;font-size:16px;color:#8A3E08"> Contact Details and Document Proofs</h4>
<span style="align: right"><b>Fields marked with<span
	style="color: red;">*</span> are mandatory</b> &nbsp;&nbsp;&nbsp;</span>
<table align="left" cellpadding=10 cellspacing=10 width="95%">

<tr>
<td width="25%" align="left">Email address<sup><font color="red">*</font></sup></td>
<td width="40%" align="left"><input type="text" name="eMailAddress" id="eMailAddress" size="35"  maxlength="40" onblur="return validEmail();" title="Please enter email address"></td>
<td width="35%"><label id="err_msg1" style="color: red;"></label></td>
</tr>

<tr>
	<td align="left">Mobile No.<sup><font color="red">*</font></sup></td>	
	<td align="left"><input type="text" name="mobileCountryCode" id="mobileCountryCode" title="Please enter country code" size=3 maxlength="3" value="+" onblur="return validmobile1();"></input>
	<input type="text" name="mobileTelephoneNumber" id="mobileTelephoneNumber" title="Please enter mobile number" size="14" maxlength="10" onblur="return validmobile2();"></input></td>
	<td><label id="err_msg2" style="color: red;"></label></td>
</tr>

<tr>
	<td align="left">Home Contact No.<sup><font color="red">*</font></sup></td>	
	<td align="left"><input type="text" name="homeCountryCode" id="homeCountryCode" title="Please enter country code" size=3 maxlength="3" onblur="return validhomeCountryCode();" value="+"></input>
	<input type="text" name="homeCityCode" id="homeCityCode" title="Please enter city code" size=9 maxlength="6" onblur="return validhomeCityCode();" ></input>
	<input type="text" name="homeTelephoneNumber" id="homeTelephoneNumber" title="Please enter telephone number" maxlength="8" size="9" onblur="return validhomeTelephoneNumber();"></input></td>
	<td><label id="err_msg3" style="color: red;"></label></td>
</tr>

<tr>
	<td align="left"> Office Contact No.<sup><font color="red">*</font></sup></td>	
	<td align="left"><input type="text" name="officeCountryCode" id="officeCountryCode" title="Please enter country code" size=3 maxlength="3" onblur="return validofficeCountryCode();" value="+"></input>
	<input type="text" name="officeCityCode" id="officeCityCode" title="Please enter city code" size=9 maxlength="6"  onblur="return validofficeCityCode();"></input>
	<input type="text" name="officeTelephoneNumber" id="officeTelephoneNumber" title="Please enter telephone number" size="9" maxlength="8" onblur="return validofficeTelephoneNumber();"></input></td>
	<td><label id="err_msg4" style="color: red;"></label></td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr>
	<td align="left">Id Proof<sup><font color="red">*</font></sup></td>
	<td align="left">
	<select id="idProofType" name="idProofType" onblur="return valididprooftype();">
	<option value="select">Please Select</option>
	<option>Bank Account Statement</option>
	<option>Driving License</option>
	<option>Electricity Bill</option>
	<option>Employer Certificate</option>
	<option>Passport</option>
	<option>Telephone Bill</option>
	<option>Voters Identity Card</option>
	</select>
	</td>
	<td><label id="err_msg5" style="color: red;"></label></td>
</tr>

<tr>
	<td align="left">Attach Id Proof<sup><font color="red">*</font></sup> </td>
    <td align="left">
	<input type="file" accept="application/pdf" name="idProofFile" id="idProofFile" title="Upload a pdf file" value="idProofFile.pdf" onblur="return valididprooffile();" ></input>
	<br>Upload Proof document in .pdf/.jpg/.bmp format 
	</td>
	<td><label id="err_msg6" style="color: red;"></label></td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr>
	<td align="left">Address Proof<sup><font color="red">*</font></sup></td>
	<td align="left">
	<select id="addressProofType" name="addressProofType" onblur="return validaddressprooftype();">
	<option value="select">Please Select</option>
	<option>Bank Account Statement</option>
	<option>Driving License</option>
	<option>Electricity Bill</option>
	<option>Employer Certificate</option>
	<option>Passport</option>
	<option>Voters Identity Card</option>
	</select>
	</td>
	<td><label id="err_msg7" style="color: red;"></label></td>
</tr>

<tr>
	<td align="left">Attach Address Proof <sup><font color="red">*</font></sup></td>
    <td align="left">
	<input type="file" name="addressProofFile" id="addressProofFile" title="Upload a pdf file" value="addressProofFile.pdf" onblur="return validaddressprooffile();">
	<br>Upload Proof document in .pdf/.jpg/.bmp format 
	</td>
	<td><label id="err_msg8" style="color: red;"></label></td>
</tr>

<tr></tr>
<tr></tr>

<tr>
<td colspan="1" style="align:center;padding:10px"><a href="#" class="button" onclick="return validateContactDetails();"><em><b>Continue</b></em></a></td>
<td><table width="60%">
<tr>
<td style="align:center;padding:10px"><a class="button" onclick="document.Account_party_contact_details.reset()"><em><b>Reset</b></em></a></td>
</tr>
</table>
</tr>
</table></td>

</form>

</div>
</div></div></div></div></div></div></div></div></div></div></div>
<!-- footer -->
<div style="margin-top:15px" ></div>
   <jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>















