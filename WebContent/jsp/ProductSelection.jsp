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

<%@page import="com.tvm.ilp.t154.cao.model.BusinessCustomer"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tvm.ilp.t154.cao.model.Product"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Business Account Creation</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"  />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/layout.css"  />
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/maxheight.js"></script>
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js"></script>
<script language="javascript">
function validateProduct(){
	var sel=document.account_creation.ProductId.selectedIndex;
	if((sel==0)){
		document.getElementById("err_message").innerHTML="Please select the product";
		return false;
	}
	else{
		document.account_creation.submit();
		return true;
	}	
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
											<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Commercial Account Opening</b></p>
											<hr></hr>
											<br>
											<!--<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">Open Account</b></a></h4>-->
											<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
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
                                             <center><h2>Create Business Account</h2></center>



<%BusinessCustomer bc=new BusinessCustomer(); %>
<%bc=(BusinessCustomer)request.getSession().getAttribute("bc"); %>

<%String accType=(String)request.getSession().getAttribute("AccountType"); %>


<%List<Product> pList=new ArrayList<Product>(); %>
<%pList=(List<Product>)request.getSession().getAttribute("ProductList"); %>

<table width="90%" style="align:center;font-family:Arial,Verdana;font-size:13px;color:#8A3E08">
 <tr>
 <td align="left"><b>Business Name - <%=bc.getBusinessName()%></b></td>
 <td align="right"><b>Branch Name - <%=bc.getBranchName()%></b></td>
 </tr></table>
<hr></hr>

<form id="contacts-form3" name="account_creation" action="/NBG/AccountCreationServlet" method="post" onsubmit="return  validateProduct();">
<input type="hidden" name="action" value="CreateAccount"></input>
<table align="center" cellspacing="10">



<tr>
<span align=right>Fields marked with <span style="color:red;">*</span> are mandatory&nbsp;&nbsp;&nbsp;</span>
</tr>

<tr> 
<td align="left"><b>Business Name</b></td>
<td><label for="BusinessType"><%=bc.getBusinessName()%></label></td>
</tr>

<tr> 
<td align="left"><b>Account Type</b></td>
<td><label for="AccountType"><%=accType%></label></td>
</tr>


<tr>
<td align="left"><b>Select Product<sup style="color:red;">*</sup></b></td>
<td>&nbsp;<select name='ProductId' >
<option value="select">----------Select----------</option>
<%for(Product pr:pList){ %>
<option  value="<%=pr.getProductID()%>"><%=pr.getProductName()%></option>
<%} %>
</select></td>
<td><label id="err_message" style="color:red;"></label></td>
</tr>







<tr><td colspan="1" style="padding:10px;"><a href="#" class="button" onclick="return  validateProduct();"><em><b>Submit</b></em></a></td>
<td style="padding:10px;"><a href="#" class="button" onclick="document.getElementById('contacts-form3').reset();"><em><b>Reset</b></em></a>
</td></tr>
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
			<!-- box end -->
            </div>
         </div>
      </div>
   <!-- footer -->
	<jsp:include page="../jsp/layout/footer.jsp"></jsp:include>
</body>
</html>