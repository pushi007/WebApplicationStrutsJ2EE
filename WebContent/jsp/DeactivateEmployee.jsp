<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tvm.ilp.t154.cao.model.Employee" %>
    <%@ page import="static com.tvm.ilp.t154.cao.constants.CAOConstants.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description" content="Consulting page - free business website template from Template Monster is awating for you to download."/>

<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/EmpDeactivateValidation.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>

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

<body id="page5" onload="new ElementMaxHeight(); setCurrentDate();">
   <!-- header -->
   <jsp:include page="layout/header.jsp"></jsp:include>
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
                                             <p style="font-family: Arial, Verdana; font-size: 15px;"><b>
                                          Employee</b></p><hr>
                                          <h4><a href="/NBG/EmployeeManagementServlet?action=closeSession"><b
	style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
<h4><a href="/NBG/EmployeeManagementServlet?action=register"><b style="font-family: Arial; font-size: 13px;">Register</b></a></h4>
<h4><a href="/NBG/EmployeeManagementServlet?action=view"><b style="font-family: Arial; font-size: 12px;">View Employees</b></a></h4>
	
	<!--<br/><br/>
<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Product Management</b></p><hr>
<h4> <a href="/NBG/ProductManagementServlet?action=addProduct"><b style="font-family: Arial; font-size: 12px;">Add Product(s)</b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=ViewProduct"><b style="font-family: Arial; font-size: 12px;">View Products</b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=viewp"><b style="font-family: Arial; font-size: 12px;">Product Report</b></a></h4>
<br/>
<p style="font-family: Arial, Verdana; font-size: 13px;"><b>Additional Products</b><br></p>
<h4><a href="/NBG/ProductManagementServlet?action=additionalProduct" ><b style="font-family: Arial; font-size: 12px;">Add Additional Product</b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=uordap" ><b style="font-family: Arial; font-size: 12px;">Update/Delete Additional Product</b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=viewap"><b style="font-family: Arial; font-size: 12px;">Additional Product Report</b></a></h4>

--><br/><br/>
<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Password Management</b></p><hr>
<h4><a href="/NBG/EmployeeManagementServlet?action=changePwd"><b  style="font-family: Arial; font-size: 12px;">Change Password</b></a></h4>
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
                                               <h2>Deactivate Employee</h2>
<hr/>
<% 
Employee emp=(Employee)(session.getAttribute("emp"));

List<String> branchList=new ArrayList<String>();
branchList=(List<String>)request.getAttribute("branchList");

List<String> desigList=new ArrayList<String>();
desigList=(List<String>)request.getAttribute("desigList");%>

<span style="align:right"><b>Fields marked with <span style="color:red;">*</span> are mandatory&nbsp;&nbsp;&nbsp;</b></span>
<form name="Deactivate_Employee" action="/NBG/EmployeeManagementServlet" method="post" onSubmit="return validateform();">

<table cellpadding=10 cellspacing=10>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td><b>Employee Id</b></td>
<td><%=emp.getEmpId() %></td></tr>


<tr>
<td><b>First Name</b></td>
<td><%=emp.getFirstNm() %></td>
</tr>

<tr>
<td><b>Last Name</b></td>
<td><%=emp.getLastNm() %></td>
</tr>

<tr>
<td><b>Address</b></td>
<td><%=emp.getAddress() %></td>
</tr>

<tr>
<td><b>Contact Number</b></td>
<td><%=emp.getContactno() %></td>
</tr>

<tr>
<td><b>Email Id</b></td>
<td><%=emp.getEmailId() %></td>
</tr>

<tr>
<td><b>Date of Joining</b></td>
<td><%=emp.getDateOfJoin() %></td>
</tr>

<tr><td><b>Designation</b>
</td>                                    
<td><%=emp.getDesignation() %></td>
</tr>

<tr><td><b>Branch Name</b>
</td>                                    
<td><%=emp.getBranchName() %></td>
</tr>

<tr>
<td><b>Date of Deactivation</b><span style="color:red;">*</span><br>(yyyy/mm/dd)</td>
<td>
<label id="dol"></label> 
<span class="label"><label id="err_dol"></label></span></td></tr>

<tr>
<td><b>Reason for Deactivation<span style="color:red;">*</span></b></td>
<td><textarea cols=35 rows=4 title="Please enter reason for Deactivation" name="reasonOfLeave" tabindex=2 onblur="validateReason();"></textarea>
<span class="label"><label id="err_reasonOfLeaving"></label></span></td></tr>

<tr>
<td><b>Status<span style="color:red;">*</span></b></td>
<td>
<select name="status" id="status" title="Please select status" onblur="validateStatus();" tabindex=3>
<option value="unselected">Select</option>
<option value="VRS">VRS</option>
<option value="Leave">On Leave</option>
<option value="suspended">Suspended</option>
<option value="Retired">Retired</option>
</select>

<span class="label"><label id="err_status"></label></span></td>
</tr>


<tr><td></td></tr>
<tr><td></td></tr>
</table>

<table>
<tr>
<td colspan="2" width=40% style="align:center;padding:10px"><a type="submit" tabindex=4 class="button" onclick="return validateform();"><em><b>&nbsp;&nbsp;Deactivate&nbsp;&nbsp;</b></em></a></td>
<td colspan="2" width=40% style="align:center;padding:10px"><a href="/NBG/EmployeeManagementServlet?action=viewDetails&&empId=<%=emp.getEmpId() %>" tabindex=5 class="button" ><em><b>&nbsp;&nbsp;Cancel&nbsp;&nbsp;</b></em></a></td>
<td><input type="hidden" name="action" value="deactivateEmployee"></input>
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