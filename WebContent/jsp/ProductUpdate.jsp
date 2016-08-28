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
<%@page import="java.util.ArrayList"%>
<%@page import="com.tvm.ilp.t154.cao.model.*" %>

<%@page import="java.util.List"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product</title>
<link href="<%= request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%= request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" />
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/maxheight.js"></script>
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js"></script>
<script src="<%=request.getContextPath() %>/js/ProductDscription.js"type="text/javascript"></script>

<style type="text/css" title="currentStyle">
			@import "<%=request.getContextPath() %>/css/demo_page.css";
			@import "<%=request.getContextPath() %>/css/jquery.dataTables_themeroller.css";
			@import "<%=request.getContextPath() %>/css/jquery-ui-1.8.4.custom.css";
			
</style>
<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
<script>$(document).ready(function(){

	var oTable	= $('#mt').dataTable( {
		"sScrollX": "100%",
		"aaSorting": [[ 1, "asc" ]],
		"bJQueryUI": true,
		"sPaginationType": "full_numbers",
		"bAutoWidth": false,
		"autoHeight": true,
		"bStateSave": false,
		"aoColumns": [null,null,null,null,null,null]  			
	} );

});
	</script>

<!--<style>

th{
	background-color:#D8D8D8;
	color:black;
	text-align:center;
	height: 23px;
	

}

</style>

-->
<script language="javascript">

function searchId()
{
	var product_id=document.ProductList.productid.value;
	var alphaExpample =/^[0-9]+$/;

	if (product_id==null || product_id=="")
	{
		document.getElementById("err_message").innerHTML="Please enter product id";
		return false; 		
	}
	else if(isNaN(product_id)){
		document.getElementById("err_message").innerHTML="Please enter only numbers for Product ID";
		return false;
	}
	else if(product_id.length!=4){
		document.getElementById("err_message").innerHTML="Please enter 4 digit Product ID";
		return false;
	}
	else if(!product_id.match(alphaExpample))
	{
		document.getElementById("err_message").innerHTML="Please enter only numbers for Product ID";
		return false;
	}
	else
	{
		document.getElementById("err_message").innerHTML="";
		return true;
	}
	

}

function searchProduct()
{

	if(searchId()==false)
	{
		document.ProductList.productid.focus();
		return false;
	}
	else
	{
		document.ProductList.submit();
		return true;
	}
	
}

function validateProduct()
{
	var chk=document.getElementsByName("additionalProduct");
	var flag=0;
	for(var i=0;i<chk.length;i++){
		if(chk[i].checked==true){
			flag=1;
			break;
		}
	}
	if(flag==0){
		document.getElementById("err_message").innerHTML="Please select atleast one additional product";
	}
	else{
		document.additional_product.submit();
	}
	return true;
}

function resetValidate() 
{
	document.getElementById("err_message").innerHTML="";
	document.ProductList.reset();
	return true;
}

</script>


<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->
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
<!--<h4><a href="/NBG/ProductManagementServlet?action=ViewProduct"><b style="font-family: Arial; font-size: 12px;">View Products</b></a></h4>
-->
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
                                          <h3 align="center" style="font-family:Arial,Verdana;font-size:16px;color:#000">View Products</h3><hr/>
<%List<Product>plist=(ArrayList<Product>) request.getAttribute("plist"); %>
<center><label id="err_message" style="color: red;"></label></center>

<form id="contacts-form1"  name="ProductList" action="/NBG/ProductManagementServlet" method="post" onSubmit="return searchProduct();">
<input type="hidden" name="action" value="searchProductId"></input>
<table  align="left" cellpadding=10 cellspacing=10 >
<tr><td></td><td><b>Enter product ID </b></td>
<td><input id="productid" name= "productid" type="text" title="Please Enter Product ID"  size='30' width='10' maxlength="6"/></td><td colspan='1' style="padding:10px;" align="right">
<a href="#" type="submit" class="button" onClick="return searchProduct();"><em><b>Search</b></em></a></td>
<td ><a href="#" class="button" onclick="return resetValidate();"><em><b>Reset</b></em></a>
</tr>
</table>
</form>

<form id="contacts-form2"  name="ViewProductList" action="/NBG/ProductManagementServlet" >
<input type="hidden" name="action" value="UpdateProductList"></input>
<input type="hidden" name="selectedProduct"></input>


<div id="" style="width:600px;">
<table id="mt" border="1" cellspacing=0 align="left">
<thead>
<tr>
<th></th>
<th><b>Product ID</b></th>
<th><b>Product Name</b></th>
<th><b>Product Description</b></th>
<th><b>Account Type</b></th>
<th><b>Product Status</b></th>
</tr>
</thead>
<tbody>
<%for(Product p:plist){ %>
<%String productId=((Long)p.getProductID()).toString(); %>
<tr>
<td><input type="checkbox" name="ProductIdList" value="<%=productId %>"/></td>
<td><%=p.getProductID() %></td>
<td><%=p.getProductName() %></td>
<td><%=p.getProductDescription() %></td>
<td><%=p.getAccountType()%></td>
<td><%=p.getProductStatus()%></td>
</tr>
<%} %>
</tbody>
</table>
</div>

<center>
<table border=0 width=70%>
<tr><td colspan=2><br/></td></tr>
<tr>		<td width=20% style="align: center; padding: 10px"><a type="submit" class="button" onclick="return selectOperationUpdate();"><em><b>Edit</b></em></a></td>
		<td width=20% style="align: center; padding: 10px"><a type="submit" class="button" onclick="return selectOperationDelete();"><em><b>Delete</b></em></a></td>
		<td width=20%><a href="#" class="button" onclick="document.getElementById('contacts-form2').reset()"><em><b>Reset</b></em></a></td>
	</tr>
</table>
</center>
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