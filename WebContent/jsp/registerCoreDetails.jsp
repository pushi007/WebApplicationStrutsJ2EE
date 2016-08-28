<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@page import="static com.tvm.ilp.t154.cao.constants.CAOConstants.*"%>
<%@page import="com.tvm.ilp.t154.cao.model.*"%>
<%@page import="java.util.*"%>

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
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<link href="<%=request.getContextPath() %>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css"
	rel="stylesheet" type="text/css" />


	<script src="<%=request.getContextPath()%>/js/registration.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/registerCoreDetailsValidation.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/j/maxheight.js"
	type="text/javascript"></script>
<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
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
var calendarWeekdays = new Array('S', 'M', 'T', 'W', 'T', 'F', 'S', 'S');
var calendarUseToday = true;
var calendarFormat = 'y/m/d';
var calendarStartMonday = true;
var calendarScreenX = 100; // either 'auto' or numeric
var calendarScreenY = 100; // either 'auto' or numeric

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
<body id="page5" >
<!-- header -->
<jsp:include page="./layout/header.jsp" />
<!-- content -->
<div id="content">
<div class="container"><!-- main-banner-small begin -->
<div class="main-banner-small">
<div class="inner">
<h1>The bank for a changing world.</h1>
</div>
</div>
<!-- main-banner-small end -->
<div class="wrapper">
<div class="col-1 maxheight"><!-- box begin -->
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
	Business</span></a>
	<br/><br/><br/><br/>
	<br/>
	<br/>
	<br/>
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
	<br/><br/><br/>	
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
<!-- box end --></div>
<div class="col-2 maxheight"><!-- box begin -->
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
<h2>Business Customer Registration</h2>
<hr/>
<form name="reg_form" method="post" action="/NBG/CustomerManagementServlet">





<h3 style="text-align: left"><font color="#8A3E08"><b>
Capture Core Business Details</b></font></h3>
<br/>
<span style="text-align: right"><b>Fields marked with are mandatory&nbsp;&nbsp;&nbsp;</b></span><br/>
<br/>
<%List<Branch> branch=new ArrayList<Branch>();
List<BusinessType> businessTypeList=new ArrayList<BusinessType>();
List<Country> countryList=new ArrayList<Country>(); 

branch=(List<Branch>)session.getAttribute("branchList");
businessTypeList=(List<BusinessType>)session.getAttribute("businessList");
countryList=(List<Country>)session.getAttribute("countryList");%>
<input type="hidden" name="action" value="add" />
<table style="height: 100%;" cellpadding="10" cellspacing="10">

	<tr>
		<td><b>Business Name <sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="bname" tabindex="1" onblur="return validateBusinessName();"
			title="Enter Business Name" /><label style="color:red;" id="error_bname"></label></td></tr>
	<tr>
		<td><b>Trading Name <sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="trdname"  tabindex="2" title="Enter Trading Name" onblur="return validateTradeName();"/><label style="color:red;" id="error_trdname"></label></td>
		
	</tr>

	<tr>
		<td><b>Business Type<sup><font color="red">*</font></sup></b></td>
		<td><select id="btype" name="btype" tabindex="3"  onblur="return validateBusinessType();">
			<option value="0" selected="selected">Please Select</option>
			<%for(BusinessType businessType:businessTypeList) {%>
			<option value="<%=businessType.getBusinessType()%>"><%=businessType.getBusinessType()%></option>
			<% }%>
		</select><label style="color:red;" id="error_btype"></label></td>
		
	</tr>

	<tr>
		<td><b>Bank Branch Name<sup><font color="red">*</font></sup></b></td>
		<td><select  name="bbname" tabindex="4"  onblur="return validateBankBranch();">
			<option value="0" selected="selected">Please Select</option>
			<%for(Branch brnch:branch) {%>
			<option value="<%=brnch.getBranchName()%>"><%=brnch.getBranchName()%></option>
			<%} %>


		</select><label style="color:red;" id="error_branch"></label></td>
		
	</tr>

	<!--<tr>
		<td><b>Bank Branch ID </b></td>
		<td><input type="text" name="bbid" />
			</td>


	</tr>
	<tr>
		<td><b>Bank Branch Address</b></td>
		<td>
		<textarea rows="5" cols="25" name="bbadd" readonly></textarea>
		</td>
	</tr>




	--><tr>
		<td><b>Are you a Start Up Business?<sup><font color="red">*</font></sup></b></td>
		<td><input type="radio" id="isStart" name="startup" value="Yes"  onblur="return isStartUpBusiness();" onclick="enableDate();"/>Yes <input type="radio"
			name="startup"  tabindex="5" value="No" onclick="enableDate();"/>No <label style="color:red" id="error_isstart"></label></td>
			
	</tr>

	<tr>
		<td><b>Date of Establishment</b><br>(yyyy/mm/dd)</td>
		<td><input type="text"  name="doe" tabindex="6" readonly="readonly" title="Enter Date of Establishment"  onchange="return validateDateForValue();" disabled="disabled" onblur="return validateDate();"/><a id="doe" href="#"
			onclick="return getCalendar(document.reg_form.doe);"><img id="doeimage"
			src="<%=request.getContextPath() %>/images/calendar.png"
			style="border: 0" /></a><label style="color:red;" id="error_doe"> </label></td>

	</tr>
	<tr>
		<td><b>Date of Registration</b><br>(yyyy/mm/dd)</td>
		<td><input type="text" name="dor" tabindex="7" readonly="readonly" title="Enter Date of Registration" onchange="return validateDateForValue();" disabled="disabled" onblur="return validateDate();"/><a id="dor" href="#"
			onclick="return getCalendar(document.reg_form.dor);"><img id="dorimage"
			src="<%=request.getContextPath() %>/images/calendar.png"
			style="border: 0" /></a> <label style="color:red;" id="error_dor"></label></td>

	</tr>
	<tr>
		<td><b>Country of Registration <sup><font color="red">*</font></sup></b></td>
		<td><select id="creg" name="country"  tabindex="8" onblur="return validateCountry();">
			<option value="0" selected>Please Select</option>
			<%for(Country country:countryList) {%>
			<OPTION VALUE="<%=country.getCountryName()%>"><%=country.getCountryName()%></OPTION>
		<%} %>
			
		</select><label style="color:red;" id="error_country"></label></td>
		
	</tr>
	<tr>
		<td><b>Expected Annual Turnover</b> <br/>(in Million Pounds)<sup><font
			color="red">*</font></sup></td>
		<td><input type="text" name="turnover" tabindex="9" title="Enter Expected Annual Turnover" onblur="return annualTurnOver();"></input><label style="color:red" id="error_turnover"></label></td>
		<td class="label"></td>
	</tr>
	<tr>
		<td><b>Total Business Capital</b>(in Million Pounds)<sup><font
			color="red">*</font></sup></td>
		<td><input type="text" name="capital" tabindex="10" title="Enter Total Business Capital" onblur="return validateBusinessCapital();"/><label style="color:red" id="error_capital"></label></td>
		
	</tr>

	<tr>
		<td><b>Business Status <sup><font color="red">*</font></sup></b></td>
		<td><input type="radio" name="bstatus" tabindex="11"  value="Active" onblur="return validateBStatus();">Active</input>
		<input type="radio" name="bstatus" value="Hold"/>Hold <label style="color:red" id="error_bstatus"></label></td>
		
	</tr>



	<tr>
		<td><b>Number of Employees</b>(including yourself)</td>
		<td><input type="text" name="noemp" tabindex="12"
			title="Enter number of employees "  onchange="return validateNoOfEmployee();"/><label style="color:red;" id="error_noemp"></label></td>
			
	</tr>


	<tr>
		<td><b>Tell More About Your Business</b></td>
		<td><textarea rows="5" cols="25" name="bdet" tabindex="13"
			title="Tell more about your business"></textarea><label style="color:red;" id="error_bdet"></label></td>
	</tr>

</table>
<table >
	<tr>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a
			type="submit" class="button"  tabindex="14" onclick="return validateCoreRegistrationForm();"><em><b>Continue</b></em></a>
		</td>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a
			 class="button" tabindex="15"
			onclick="document.reg_form.reset();"><em><b>Reset</b></em></a></td>
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
<!-- box end --></div>
</div>

<!-- footer -->
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>


</body>
</html>