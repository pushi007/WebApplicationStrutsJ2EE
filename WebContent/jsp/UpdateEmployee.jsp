<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tvm.ilp.t154.cao.model.Employee"%>
<%@ page import="static com.tvm.ilp.t154.cao.constants.CAOConstants.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
	response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
	if (request.getSession() == null
			|| request.getSession().getAttribute("UID") == null) {
		response.sendRedirect(request.getContextPath()
				+ "/jsp/HomeLogin.jsp");
		return;
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description"
	content="Consulting page - free business website template from Template Monster is awating for you to download." />

<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/EmpUpdationValidation.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/maxheight.js"
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

<body id="page5"
	onload="new ElementMaxHeight(); onload=setJoiningDate();">
<!-- header -->
<jsp:include page="layout/header.jsp"></jsp:include>
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
<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Employee</b></p><hr>
<h4><a href="/NBG/EmployeeManagementServlet?action=closeSession"><b
	style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
<h4><a href="#" onclick="return Confirm()"><b style="font-family: Arial; font-size: 13px;">Register</b></a></h4>
<h4><a href="#" onclick="return Confirm()"><b style="font-family: Arial; font-size: 12px;">View Employees</b></a></h4>
	
	<!--<br/><br/>
<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Product Management</b></p><hr>
<h4> <a href="#" onclick="return Confirm()"><b style="font-family: Arial; font-size: 12px;">Add Product(s)</b></a></h4>
<h4><a href="#" onclick="return Confirm()"><b style="font-family: Arial; font-size: 12px;">View Products</b></a></h4>
<h4><a href="#" onclick="return Confirm()"><b style="font-family: Arial; font-size: 12px;">Product Report</b></a></h4>
<br/>
<p style="font-family: Arial, Verdana; font-size: 13px;"><b>Additional Products</b><br></p>
<h4><a href="#"onclick="return Confirm()" ><b style="font-family: Arial; font-size: 12px;">Add Additional Product</b></a></h4>
<h4><a href="#" onclick="return Confirm()"><b style="font-family: Arial; font-size: 12px;">Update/Delete Additional Product</b></a></h4>
<h4><a href="#" onclick="return Confirm()"><b style="font-family: Arial; font-size: 12px;">Additional Product Report</b></a></h4>

--><br/><br/>
<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Password Management</b></p><hr>
<h4><a href="#" onclick="return Confirm()"><b  style="font-family: Arial; font-size: 12px;">Change Password</b></a></h4>
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
<h2>Update Employee</h2>
<hr />
<%
	Employee emp = (Employee) (session.getAttribute("emp"));

	List<String> branchList = new ArrayList<String>();
	branchList = (List<String>) request.getAttribute("branchList");

	List<String> desigList = new ArrayList<String>();
	desigList = (List<String>) request.getAttribute("desigList");
%> <span
	style="align: right"><b>Fields marked with <span
	style="color: red;">*</span> are mandatory&nbsp;&nbsp;&nbsp;</b></span>
<form name="Update_Employee"
	action="/NBG/EmployeeManagementServlet" method=post
	onSubmit="return validateform();">

<table cellpadding=10 cellspacing=10>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<%
		if (emp.getEmpId() != 0) {
	%>
	<tr>
		<td><b>Employee Id</b></td>
		<td><input type="text" name="empId" size=6
			value=<%=emp.getEmpId()%> readonly /></td>
	</tr>
	<%
		}
	%>
	<tr>
		<td><b>Title<span style="color: red;">*</span></b></td>
		<td><select name="title" tabindex=1
			title="Please select title of Employee"
			onmousemove="validateDateB(); validateAge();"
			onblur="validateTitle();">
			<option value="NoTitle"
				<%if (emp.getTitle().equals("NoTitle"))
				out.println("selected");%>>Select</option>
			<option value="Mr"
				<%if (emp.getTitle().equals("Mr"))
				out.println("selected");%>>Mr</option>
			<option value="Ms"
				<%if (emp.getTitle().equals("Ms"))
				out.println("selected");%>>Ms</option>
			<option value="Mrs"
				<%if (emp.getTitle().equals("Mrs"))
				out.println("selected");%>>Mrs</option>
		</select> <label class="label" id="err_title"></label></td>
	</tr>

	<tr>
		<td><b>First Name<span style="color: red;">*</span></b></td>
		<td><input type="text" tabindex=2 name="firstnm"
			title="Please enter First name"
			onmousemove="validateDateB(); validateAge();" maxlength=20
			value=<%=emp.getFirstNm()%> onblur="validatefirstnm();"></input> <label
			class="label" id="err_firstnm"></label></td>
	</tr>

	<tr>
		<td><b>Middle Name</b></td>
		<td><input type="text" name="middlenm" tabindex=3
			title="Please enter Middle name"
			onmousemove="validateDateB(); validateAge();" maxlength=20
			onblur="validatemiddlenm();" value=<%=emp.getMiddleNm()%>></input> <label
			class="label" id="err_middlenm"></label></td>
	</tr>

	<tr>
		<td><b>Last Name<span style="color: red;">*</span></b></td>
		<td><input type="text" name="lastnm" tabindex=4
			title="Please enter Last name"
			onmousemove="validateDateB(); validateAge();" maxlength=20
			value=<%=emp.getLastNm()%> onblur="validatelastnm();"></input> <label
			class="label" id="err_lastnm"></label></td>
	</tr>

	<tr>
		<td><b>Date of Birth<span style="color: red;">*</span></b><br>
		(yyyy/mm/dd)</td>
		<td><input type="text" name="dob" readonly="readonly"
			title="Please select Date of Birth" tabindex=5 size=12
			value=<%=emp.getDateOfBirth()%> onblur="validateDOB();"><a
			href="#" onclick="return getCalendar(document.Update_Employee.dob);"><img
			src="<%=request.getContextPath()%>/images/calendar.png"
			style="border: 0" onmousemove="validateDateB(); validateAge();"/></a> <!--  <input name = "dob" type="text" />  --> <label
			class="label" id="err_dob"></label><label style="color: red"
			id="err_dob1"></label></td>
	</tr>

	<tr>
		<td><b>Address<span style="color: red;">*</span></b></td>
		<td><textarea rows="3" cols="30" tabindex=6 name="address"
			onmousemove="validateDateB(); validateAge();"
			title="Please enter Address of Employee" id="address"
			onblur="validateAddress();"><%=emp.getAddress()%></textarea></td>
		<td><label class="label" id="err_address"></label></td>
	</tr>

	<tr>
		<td><b>Contact Number<span style="color: red;">*</span></b></td>
		<td><input type="text" name="contactno"
			onmousemove="validateDateB(); validateAge();" tabindex=7 size=12
			title="Please enter Contact No" maxlength="10" id="contactno"
			value=<%=emp.getContactno()%> onblur="validateContactNo();"></input>
		<label class="label" id="err_contact"></label></td>
	</tr>

	<tr>
		<td><b>Alternate Contact Number</b></td>
		<td>
		<%
			if (emp.getAltContactNo() > 0) {
		%><input type="text" name="altcontactno"
			onmousemove="validateDateB(); validateAge();" tabindex=8 size=12
			maxlength="10" title="Please end alternate Contact Number"
			id="altcontactno" value=<%=emp.getAltContactNo()%>
			onblur="validateAltContact();"></input>
		<%
			} else {
		%><input type="text" name="altcontactno" tabindex=8 size=12
			maxlength="10" title="Please end alternate Contact Number"
			id="altcontactno" value="" onblur="validateAltContact();"></input>
		<%
			}
		%> <label class="label" id="err_altcontact"></label></td>
	</tr>


	<tr>
		<td><b>Email Id<span style="color: red;">*</span></b></td>
		<td><input type="text" name="email" tabindex=9 maxlength=50
			onmousemove="validateDateB(); validateAge();"
			title="Please enter email Id" id="email" value=<%=emp.getEmailId()%>
			onblur="validateEmail();"></input> <label class="label"
			id="err_email"></label></td>
	</tr>

	<tr>
		<td><b>Date of Joining</b><span style="color: red;">*</span><br/>(yyyy/mm/dd)</td>
		<td><input type="text" title="Please select Date of Joining" name="doj" tabindex=10 size=12 onblur="validateDOJ();" value=<%=emp.getDateOfJoin()%> readonly="readonly" /><a href="#"
			onclick="return getCalendar(document.Update_Employee.doj);"><img
			src="<%=request.getContextPath() %>/images/calendar.png"
			style="border: 0" onmousemove=""/></a>
		<label class="label" id="err_doj"></label></td>
	</tr>

	<tr>
		<td><b>Designation<span style="color: red;">*</span></b></td>

		<td><select name="designation" id="designation"
			title="Please select Designation" onmousemove="validateDateB();"
			onblur="validateDesig();" tabindex=11>
			<option value="unselected">Select</option>
			<%
				for (String desig : desigList) {
			%>
			<option value="<%=desig%>"
				<%if (emp.getDesignation().equals(desig))
					out.println("selected");%>><%=desig%></option>
			<%
				}
			%>
		</select> <label class="label" id="err_designation"></label></td>
	</tr>
	<tr>
		<td></td>
	</tr>

	<tr>
		<td><b>Branch Name<span style="color: red;">*</span></b></td>
		<td><select name="branch_nm" id="branch_nm"
			title="Please select Branch name"
			onmousemove="validateDateB(); validateAge();"
			onblur="validateBranch();" tabindex=12>
			<option value="unselected">Select</option>
			<%
				for (String branchNm : branchList) {
			%>
			<option value="<%=branchNm%>"
				<%if (emp.getBranchName().equals(branchNm))
					out.println("selected");%>><%=branchNm%></option>
			<%
				}
			%>
		</select> <label class="label" id="err_branchnm"></label></td>
	</tr>

	<tr>
		<td></td>
	</tr>

	<tr>
		<td valign="top"><b>User Groups<span style="color: red;">*</span></b></td>
		<td><input type="checkbox" name="groups" tabindex=13
			value="Admin" id="admin"
			<%for (String groupName : emp.getGroups()) {
				if (groupName.equals("Admin"))
					out.println("checked");
			}%>>Admin<br></br>
		<input type="checkbox" name="groups" tabindex=14 value="BB_CAO_Comm"
			id="comm"
			<%for (String groupName : emp.getGroups()) {
				if (groupName.equals("BB_CAO_Comm"))
					out.println("checked");
			}%>>BB_CAO_Common<br></br>
		<input type="checkbox" name="groups" tabindex=15 value="BB_CAO_Prod"
			id="prod"
			<%for (String groupName : emp.getGroups()) {
				if (groupName.equals("BB_CAO_Prod"))
					out.println("checked");
			}%>>BB_CAO_Prod<br></br>
		<input type="checkbox" name="groups" tabindex=16 value="BB_CAO_Main"
			id="main"
			<%for (String groupName : emp.getGroups()) {
				if (groupName.equals("BB_CAO_Main"))
					out.println("checked");
			}%>>BB_CAO_Main<br></br>
		<input type="checkbox" name="groups" tabindex=17 value="BB_CAO_HDesk"
			id="hdesk"
			<%for (String groupName : emp.getGroups()) {
				if (groupName.equals("BB_CAO_HDesk"))
					out.println("checked");
			}%>>BB_CAO_HDesk<br></br>

		</td>

		<td><label class="label" id="err_groups"></label></td>
	</tr>

	<tr>
		<td></td>
	</tr>
	<tr>
		<td></td>
	</tr>
</table>

<table width=50%>
	<tr>
		<td colspan="2" width=30% style="align: center; padding: 10px"><a
			type="submit" tabindex=18 class="button"
			onclick="return validateform();"><em><b>&nbsp;&nbsp;Update&nbsp;&nbsp;</b></em></a></td>
		<td colspan="2" width=30% style="align: center; padding: 10px"><a
			href="/NBG/EmployeeManagementServlet?action=viewDetails&&empId=<%=emp.getEmpId()%>"
			tabindex=19 class="button" onclick="return Confirm()"><em><b>&nbsp;&nbsp;Cancel&nbsp;&nbsp;</b></em></a></td>
		<td><input type="hidden" name="action" value="updateEmployee"></input>
		</td>
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
</div>
</div>
<!-- footer -->
<div style="margin-top: 15px"></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>