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


<form name="Account_party_present_address_details" action="/NBG/AccountPartyManagementServlet" method="post">
<input type="hidden" name=action value="Account_party_present_address_detail"></input>

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

<h4  style="align:center;font-family:Arial,Verdana;font-size:16px;color:#8A3E08"> Present Address Details</h4>
<span style="align: right"><b>Fields marked with<span
	style="color: red;">*</span> are mandatory</b> &nbsp;&nbsp;&nbsp;</span>
	
<table align="left" cellpadding=10 cellspacing=10 width="95%">
<tr>
<td align="left" width="20%">House No<sup><font color="red">*</font></sup></td>
<td align="left" width="20%"><input type="text" name="presentHouseNo" id="presentHouseNo" maxlength="10" onblur="return validHouseNo();"/>
<td align="left" width="60%"><label id="err_msg1" style="color: red;"></label></td>
</tr>
<tr>
<td align="left">House Name<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" name="presentHouseName" id="presentHouseName" maxlength="30" onblur="return validHouseName();"/>
<td><label id="err_msg2" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Building No<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" name="presentBuildingNo" id="presentBuildingNo" maxlength="10" onblur="return validpresentBuildingNo();"/>
<td><label id="err_msg3" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Street Name<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" name="presentStreet" id="presentStreetName" maxlength="40" onblur="return validpresentStreetName();"/>
<td><label id="err_msg4" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">City<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" name="presentCity" id="presentCity" maxlength="30" onblur="return validpresentCity();"/>
<td><label id="err_msg5" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Town</td>
<td align="left"><input type="text" name="presentTown" id="presentTown" maxlength="30" onblur="return validpresentTown();"/>
<td><label id="err_msg6" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Country<sup><font color="red">*</font></sup></td>
<td><select id="presentCountry" name="presentCountry" onblur="return validcountry();" >
			<option value="select">-- Please Select --</option>
			<%for(Country country:countryList) {%>
			<OPTION VALUE="<%=country.getCountryName()%>"><%=country.getCountryName()%></OPTION>
			<% }%>
		</select></td>
		<td><label id="err_msg7" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Postal Code<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" name="presentPostalCode" id="presentPostalCode" maxlength="10" onblur="return validPostalCode();"/></td>
<td><label id="err_msg8" style="color: red;"></label></td>
</tr>

<tr>
<td align="left">Date from which residing at present address(in yyyy/mm/dd)<sup><font color="red">*</font></sup></td>
<td align="left"><input type="text" name="presentAddressDate" id="presentAddressDate" size="12" readonly="readonly"/>
<a href="#"
			onclick="return getCalendar(Account_party_present_address_details.presentAddressDate);"><img
			src="<%=request.getContextPath() %>/images/calendar.png"
			style="border: 0" /></a></td>
<td><label id="err_msg9" style="color: red;"></label></td>
</tr>
<tr><td></td></tr>
 <tr></tr>
 <tr></tr>

<tr>
<td colspan="1" style="align:center;padding:10px"><a href="#" class="button" onclick="return validatePresentAddres();"><em><b>Continue</b></em></a></td>
<td style="align:center;padding:10px"><a class="button" onclick="document.Account_party_present_address_details.reset()"><em><b>Reset</b></em></a></td>

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
