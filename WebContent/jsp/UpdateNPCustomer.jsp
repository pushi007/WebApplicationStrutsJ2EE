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
<title>Business Customer Registration Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />

<link href="<%=request.getContextPath() %>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/calender.css"
	rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath()%>/js/registration.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/updateCoreDetailsValidation.js"
	type="text/javascript"></script>
	
<script type="text/javascript" src="<%=request.getContextPath()%>/js/calender.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/calenderDateInput.js"></script>

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
<body id="page5">
<!-- header -->
<jsp:include page="layout/header.jsp" />
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
	Business</span></a><br /><br />
	<a href="/NBG/AccountPartyManagementServlet?action=Display_Business_Cust_Detail" style="font-size-adjust: inherit"><span style="font-size:12px">Account Parties</span></a>


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
	</br>
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
<h2>Business Customer Profile Updation</h2>
<form name="updateCore_form" method="post"
	action="/NBG/CustomerManagementServlet" method="post">
	<input type="hidden" name="action" value="updatecoredatadetails"  /> <font color="#8A3E08"></font>
<hr/>
<h3 ><font color="#8A3E08"><b>Update
Core Business Details</b></font></h3>
<br>
 <span style="align:right"><b>Fields marked with <span
	style="color: red;">*</span> are mandatory</b>&nbsp;&nbsp;&nbsp;</span><br>
<br>
<%NonPersonalCustomer npCustomer=(NonPersonalCustomer)session.getAttribute("npCustomer");
List<Branch> branch=new ArrayList<Branch>();
List<BusinessType> businessTypeList=new ArrayList<BusinessType>();
List<Country> countryList=new ArrayList<Country>(); 

branch=(List<Branch>)session.getAttribute("branchList");
businessTypeList=(List<BusinessType>)session.getAttribute("businessList");
countryList=(List<Country>)session.getAttribute("countryList");%>
<table  style="height: 100%;" cellpadding="5">

	<tr>
		<td><b>Business Name <sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="bname" tabindex="1"
			title="Enter Business name"
			value="<%=npCustomer.getBusinessName()%>"
			onblur="return validateBusinessName();" /><label style="color:red;" id="error_bname"></label></td>
			</tr>
	<tr>
		<td><b>Trading Name <sup><font color="red">*</font></sup></b></td>
		<td><input type="text" name="trdname" tabindex="2"
			title="Enter Trading name"
			value="<%=npCustomer.getTradingName()%>"
			onblur="return validateTradeName();" /><label style="color:red;" id="error_trdname"></label></td>
			</tr>

	<tr>
		<td><b>Business Type<sup><font color="red">*</font></sup></b></td>
		<td><select id="btype" name="btype"  tabindex="3" onblur="return validateBusinessType();">
			<option value="0" selected="selected">Please Select</option>
			<%for(BusinessType businessType:businessTypeList) {%>
			<option <%if(npCustomer.getBusinessType().equalsIgnoreCase(businessType.getBusinessType())){out.print("selected");} %> value="<%=businessType.getBusinessType()%>"><%=businessType.getBusinessType()%></option>
			<% }%>
		</select><label style="color:red;" id="error_btype"></label></td>
		
	</tr>
	
	<tr>
		<td><b>Bank Branch Name<sup><font color="red">*</font></sup></b></td>
		<td><select id="bbname" name="bbname" tabindex="4" onblur="return validateBankBranch();">
			<option value="0" selected="selected">Please Select</option>
			<%for(Branch brnch:branch) {%>
			<option
				<%if(npCustomer.getBranch().getBranchName().equalsIgnoreCase(brnch.getBranchName())){out.println("selected");} %>
				value="<%=brnch.getBranchName()%>"><%=brnch.getBranchName()%></option>

			<%  
			}%>
		</select><label style="color:red;" id="error_branch"></label></td>
	</tr>
	
	<tr>
		<td><b>Are you a Start Up Business?<sup><font color="red">*</font></sup></b></td>
		<td><input type="radio" id="isStart" name="startup" tabindex="5" value="Yes" onblur="return isStartUpBusiness();" onclick="enableDate();"
			<%if(npCustomer.getIsStartUpBusiness().equalsIgnoreCase("yes")){out.println("checked");} %>
			 />Yes <input type="radio" onclick="enableDate();"
			name="startup" tabindex="1" value="No" 
			<%if(npCustomer.getIsStartUpBusiness().equalsIgnoreCase("no")){out.println("checked");} %> />No<label style="color:red" id="error_isstart"></label></td>
	</tr>

	<tr>
		<td><b>Date of Establishment</b><br>(yyyy/mm/dd)</td>
		<td><label for="doe"><%=npCustomer.getDateEstablished() %></label></td>
		</tr>
	<tr>
		<td><b>Date of Registration</b><br>(yyyy/mm/dd)</td>
		<td><label for="dor"><%=npCustomer.getDateOfRegistration()%></label> </td>

	</tr>
	<tr>
		<td><b>Country of Registration <sup><font color="red">*</font></sup></b></td>
		<td><select id="creg" name="country" tabindex="8" onblur="return validateCountry();">
			<option value="0" selected="selected">Please Select</option>
			<%for(Country country:countryList) {%>
			<option
				<%if(npCustomer.getCountryOfRegistration().equalsIgnoreCase(country.getCountryName())){out.println("selected");} %>
				value="<%=country.getCountryName()%>"><%=country.getCountryName()%></option>
			<% }%>
		</select><label style="color:red;" id="error_country"></label></td>
	</tr>
	<tr>
		<td><b>Expected Annual Turnover </b>(in Million Pounds)<sup><font
			color="red">*</font></sup></td>
		<td><input type="text"
			value=<%=npCustomer.getExpectedAnnualTurnover()%> name="turnover" tabindex="9"  title="Enter Expected Annual Turnover"  onblur="return annualTurnOver();"></input><label style="color:red" id="error_turnover"></label></td>
	</tr>
	<tr>
		<td><b>Total Business Capital</b>(in Million Pounds)<sup><font
			color="red">*</font></sup></td>
		<td><input type="text"
			value=<%=npCustomer.getTotalBusinessCapital() %> name="capital"  tabindex="10" title="Enter Total Business Capital" onblur="return validateBusinessCapital();" ></input><label style="color:red" id="error_capital"></label></td>
	</tr>

	<tr>
		<td><b>Business Status <sup><font color="red">*</font></sup></b></td>
		<td><input type="radio" name="bstatus" tabindex="11" onblur="return validateBStatus();"
			<%if(npCustomer.getBusinessStatus().equalsIgnoreCase("active")){out.println("checked");} %>
			value="Active" />Active <input type="radio" name="bstatus"
			<%if(npCustomer.getBusinessStatus().equalsIgnoreCase("hold")){out.println("checked");} %>
			value="Hold" />Hold <label style="color:red;" id="error_bstatus"></label></td>
	</tr>



	<tr>
		<td><b>Number of Employees(Including Yourself)</b></td>
		<td><input type="text" name="noemp" tabindex="12" onchange="return validateNoOfEmployee();"
			value=<%=npCustomer.getNoOfEmployees() %>
			title="Enter number of employees " onblur="validateNoOfEmployee();" ></input><label style="color:red;" id="error_noemp"></label></td>
	</tr>


	<tr>
		<td><b>Tell More About Your Business</b></td>
		<td><textarea rows="5" cols="25" name="bdet" tabindex="13"
			title="Tell more about your business"><%=npCustomer.getTellMoreAboutYourBusiness() %></textarea><label style="color:red;" id="error_bdet"></label></td>
	</tr>

</table>
<table >
	<tr>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a class="button" tabindex="14" onclick="return validateCoreUpdationForm();"><em><b>Continue</b></em></a></td>
		<%if(npCustomer.getBusinessId()!=0){ %>
		<td width=30% colspan="2" style="align: center; padding: 10px;"><a
			href="/NBG/CustomerManagementServlet?action=viewdetails&&id=<%=npCustomer.getBusinessId() %>" class="button" ><em><b>Cancel</b></em></a></td>
	<%} else{%>
	<td width=30% colspan="2" style="align: center; padding: 10px;"><a
			href="/NBG/jsp/NonPersonalRegistraionSummary.jsp" class="button" tabindex="15" ><em><b>Cancel</b></em></a></td>
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
<!-- box end --></div>
</div>

<!-- footer -->
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>