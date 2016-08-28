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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.tvm.ilp.t154.cao.model.Product"%>
<%@ page import="com.tvm.ilp.t154.cao.model.BusinessType"%>
<%@ page import="com.tvm.ilp.t154.cao.model.AdditionalProduct"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>

<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js" ></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/js/productScript.js"></script>
<script src="<%=request.getContextPath() %>/js/ProductDscription.js"type="text/javascript"></script>

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
<body id="page5" onload="new ElementMaxHeight();">
   <!-- header -->
   <jsp:include page="../jsp/layout/header.jsp"></jsp:include>
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
											<!--<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Employee</b></p><hr/>
<h4><a href="/NBG/EmployeeManagementServlet?action=register"><b style="font-family: Arial; font-size: 12px;">Register</b></a></h4>
<h4><a href="/NBG/EmployeeManagementServlet?action=view"><b>View Employees</b></a></h4>
	
	<br/><br/>
--><p style="font-family: Arial, Verdana; font-size: 15px;"><b>Product Management</b></p><hr/>
<h4><a href="/NBG/EmployeeManagementServlet?action=closeSession"><b
	style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
<h4> <a href="/NBG/ProductManagementServlet?action=addProduct"><b style="font-family: Arial; font-size: 12px;">Add Product(s)</b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=ViewProduct"><b style="font-family: Arial; font-size: 12px;">View Products</b></a></h4>
<!--<h4><a href="/NBG/ProductManagementServlet?action=viewp"><b style="font-family: Arial; font-size: 12px;">Product Report</b></a></h4>
--><br/>
<p style="font-family: Arial, Verdana; font-size: 13px;"><b>Additional Products</b><br/></p>
<h4><a href="/NBG/ProductManagementServlet?action=additionalProduct" ><b style="font-family: Arial; font-size: 12px;">Add Additional Product</b></a></h4>
<h4><a href="/NBG/ProductManagementServlet?action=uordap" ><b style="font-family: Arial; font-size: 12px;">Update/Delete Additional Product</b></a></h4>
<!--<h4><a href="/NBG/ProductManagementServlet?action=viewap"><b style="font-family: Arial; font-size: 12px;">Additional Product Report</b></a></h4>

--><br/><br/>
<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Password Management</b></p><hr/>
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
                                          <center><h2>Product Details</h2></center><hr/>
<span align=right>Fields marked with <span style="color:red;">*</span> are mandatory&nbsp;&nbsp;&nbsp;</span>
<%Product p=new Product();%>
<%p=(Product) request.getSession().getAttribute("product");%>

<%List<BusinessType> bList=new ArrayList<BusinessType>(); %>
<%bList=(List<BusinessType>) request.getSession().getAttribute("businessList"); %>

<%List<BusinessType> businessList=new ArrayList<BusinessType>(); %>
<%businessList=(List<BusinessType>) request.getSession().getAttribute("bList"); %>

<%List<AdditionalProduct> pList=new ArrayList<AdditionalProduct>(); %>
<%pList=(List<AdditionalProduct>) request.getSession().getAttribute("Additional"); %>

<%List<AdditionalProduct> aplist=new ArrayList<AdditionalProduct>(); %>
<%aplist=(List<AdditionalProduct>) request.getSession().getAttribute("apd"); %>

<form id="contacts-form2"  name="Add_Product" action="/NBG/ProductManagementServlet" method="post" onSubmit="return validateformation();">
<input type="hidden" name="action" value="TotalProductDetails"></input>
<table  align="left"  cellpadding=10 cellspacing=10>

<tr> 
<td ><b>Product ID<sup style="color:red;">*</sup> </b></td>
<td><input id="ProductId" type="text" name="ProductId" value="<%=p.getProductID() %>"  readonly="readonly"  title="Please Enter Product ID" size='30' width='10' /></td>

</tr>

<tr>
<td ><b>Product Name<sup style="color:red;">*</sup></b></td>
<td><input type="text" name="ProductName" value="<%=p.getProductName() %>" maxlength="40" onblur="validateProductName();" title="Please Enter Product Name" id="ProductName" size='30' width='10'></td>
<td><label id="err_message1" style="color: red;"></label></td>
</tr>

<tr align="left" valign="top"> 
<td ><b>Product Description<sup style="color:red;">*</sup> </b></td>
<td><textarea  id="ProductDescription"   name="ProductDescription" onblur="validateProductDescription();" cols='35' rows='4' title="Please Enter Product Discription" ><%=p.getProductDescription()%></textarea></td>
<td width="50px"><label id="err_message2" style="color: red;"></label></td>
</tr>

<tr align="left"> 
<td ><b>Account Type<sup style="color:red;">*</sup>  </b></td>
<td><select id="AccoutnType" name="AccoutnType" title="Please Select Account Type" onblur="validateAccountType();" colspan='2'><option value='select'>---------------Select---------------</option>
<option  value="Savings Account" <%if(p.getAccountType().equals("Savings Account")){out.println("selected");} %>>Savings Account</option>
<option  value="Current Account" <%if(p.getAccountType().equals("Current Account")){out.println("selected");} %>>Current Account</option>
</select></td><td><label id="err_message3" style="color: red;"></label></td>
</tr>


<tr align="left"> 
<td ><b>Product Status<sup style="color:red;">*</sup> </b></td>
<td><select id="ProductStatus" name="ProductStatus" title="Please Select Product Status"  onblur="validateProductStatus();"  colspan='2' ><option value='select' >---------------Select---------------</option>
<option  value="Active" <%if(p.getProductStatus().equals("Active")){out.println("selected");} %>>Active</option>
<option  value="Inactive" <%if(p.getProductStatus().equals("Inactive")){out.println("selected");} %>>Inactive</option>
</select></td><td><label id="err_message4" style="color: red;"></label></td>
</tr>


<tr align="left"> 
<td ><b>Valid From<i></b><sup style="color:red;">*</sup>&nbsp;&nbsp;</td>
<td><input type="text" id="ValidFrom" onblur="validateDate();" title="Please Select Business Type" name="ValidFrom"  readonly="readonly" value="<%=p.getProductValidFrom()%>" title="Please Enter the date" size='30' width='10'  />
<a href="#" onclick="return getCalendar(document.Add_Product.ValidFrom);"><img src="<%=request.getContextPath() %>/images/calendar.png" style="border:0" /></a></td> 
<td><label id="err_message5" style="color: red;"></label></td>
</tr>


<tr><td><b>Business Type<sup style="color:red;">*</sup></b></td>
<td><select multiple name="BusinessType"  title="Please Select Business Type" onblur="validateBusinessType();" >
<option value="select" >---------------Select---------------</option>
<%for(BusinessType bt:bList) {%>
<option style="font-size:13px" value="<%=bt.getBusinessType_name() %>"
<% for(BusinessType business:businessList){  if(bt.getBusinessType_name().equals(business.getBusinessType_name())){out.println("selected");} }%>>
<%=bt.getBusinessType_name() %></option>
<%}%>
</select></td>
<td><label id="err_message6" style="color: red;"></label>
</td></tr>

<tr>
<tr><td><b>Additional Products</b></td><td></td><td><center><label id="err_message7" style="color:red;"></label></center></td></tr>
<%for(AdditionalProduct aproduct:pList){ %>
<tr><td></td><td><input type="checkbox" onblur="validationofAdditionalProduct();" name="AdditionalProduct" <% for(AdditionalProduct aprod:aplist){  if(aproduct.getName().equals(aprod.getName())){out.println("checked");} }%>
value="<%=aproduct.getName()%>" /><%=aproduct.getName()%>
</td>
<%} %>
</tr>
<tr></tr>

<tr><td colspan="1" ><a href="#" class="button" onClick="return validateformation();"><em><b>Save</b></em></a></td>
<td style="align: center;"><a type="submit" class="button" onclick="return cancelEditValidation();"  href="#"  ><em><b>Cancel</b></em></a></td>
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
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>