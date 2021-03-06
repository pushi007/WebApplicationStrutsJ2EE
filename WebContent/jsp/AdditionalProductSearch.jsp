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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Additional Product Search</title>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>


<script language="javascript">
function searchAdditionalId()
{
	var Aproduct_id=document.searchProduct.apid.value;
	var alphaExpample =/^[0-9]+$/;

	if (Aproduct_id==null || Aproduct_id=="")
	{
		document.getElementById("err_message").innerHTML="Please enter Additional product id";
		return false; 		
	}
	else if(isNaN(Aproduct_id)){
		document.getElementById("err_message").innerHTML="Please enter only numbers for Additional Product ID";
		return false;
	}
	else if(Aproduct_id.length!=3)
	{
		document.getElementById("err_message").innerHTML="Please enter 3 digit Additional Product ID";
		return false;
	}
	else if(Aproduct_id==0)
	{
		document.getElementById("err_message").innerHTML="Please enter valid Additional Product ID";
		return false;

	}
	else if(!Aproduct_id.match(alphaExpample))
	{
		document.getElementById("err_message").innerHTML="Please enter only numbers for Additional Product ID";
		return false;
	}
	
	
	else
	{
		document.getElementById("err_message").innerHTML="";
		return true;
	}
	
}
function additionalProductSearch()
{
	if(searchAdditionalId()==false)
	{
		document.searchProduct.apid.focus();
		return false;
	}
	else
	{
		document.searchProduct.submit();
		return true;
	}
	
}
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
                                          <center><h2>Search for Additional Product</h2></center>
<hr/>
 <form id="contacts-form9" name="searchProduct" action="/NBG/ProductManagementServlet?" onsubmit="return additionalProductSearch();">
<input type="hidden" name="action" value="searchap" ></input>
<table  align="left" cellpadding=10 cellspacing=10>

<tr></tr><tr>
<tr><td>Enter Additional Product ID :</td>
<td><input id="apid" name= "apid" type="text" title="Please Enter Additional product ID" maxlength="5" onblur="searchAdditionalId();" size='30' width='10' /></td>
<td><label id="err_message" style="color: red;"></label></td>
</tr>
<tr><td></td><td colspan='1' style="padding:10px;" align="left">
<a  class="button" onclick="return additionalProductSearch();"><em><b>Search</b></em></a></td>
</tr>
</table></form>
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