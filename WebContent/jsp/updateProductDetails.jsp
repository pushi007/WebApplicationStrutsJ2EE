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
    <%@page import="java.util.ArrayList"%>
<%@page import="com.tvm.ilp.t154.cao.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product Details</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"  />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/layout.css"  />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/maxheight.js" ></script>
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js"></script>
<script language="javascript">
function validateAdditionalProduct(){
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
											<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Commercial Account Opening</b></p>
											<hr></hr>
											<br>
											<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">Create Account</b></a></h4>
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
                                       <center><h2>Additional Product Configuration</h2></center>
                                       <%BusinessCustomer bc=(BusinessCustomer)request.getSession().getAttribute("bc"); %>
                                              
<table width="90%" style="align:center;font-family:Arial,Verdana;font-size:13px;color:#8A3E08">
 <tr>
 <td align="left"><b>Business Name - <%=bc.getBusinessName()%></b></td>
 <td align="right"><b>Branch Name - <%=bc.getBranchName()%></b></td>
 </tr></table>
                                       <hr>
                                       <%String acc_number=(String) request.getAttribute("AccountNumber"); %>
                                       <%String productId=(String) request.getSession().getAttribute("productId"); %>
                                       <%ArrayList<AdditionalProduct> pList=(ArrayList<AdditionalProduct>)request.getSession().getAttribute("productList"); %>
                                       <%String[] product=(String[])request.getSession().getAttribute("productName"); %>
                                       <table align="center">
                                             <tr>
                                             <td style="padding:15px;">Account Number:</td>
                                             <td><%=acc_number %></td>
                                             </tr>
                                             <tr>
                                             <td style="padding:15px;">Product ID:</td>
                                             <td><%=productId %></td>
                                             </tr>
                                             </table>
                                      <center><h5>Select the additional product(s) from following list:</h5></center>
                                      <center><label id="err_message" style="color:red;"></label></center>
                                      <form id="contacts-form2" name="additional_product" method="post" action="/NBG/AdditionalProductConfigServlet">
						<input type="hidden" name="action" value="UpdatedAdditionalProduct"></input>
						<input type="hidden" name="account_Number" value="<%=acc_number %>"></input>
						<input type="hidden" name="product_Id" value="<%=productId %>"></input>
						<table align="center">
						<%for(AdditionalProduct p:pList){ %>
						<tr><td style="padding:15px;"><input type="checkbox" name="additionalProduct" <%for(int i=0;i<product.length;i++){if(p.getName().equals(product[i])){out.println("checked");}} %> value="<%=p.getName()%>"/><%=p.getName()%>
						</td><td></td></tr>
						<%} %>
						<tr><td colspan="2" style="padding:10px;"><a href="#" class="button" onclick="return validateAdditionalProduct();"><em><b>Apply</b></em></a></td>
						<td style="padding:10px;"><a href="#" class="button" onclick="document.getElementById('contacts-form2').reset();"><em><b>Reset</b></em></a>
						</td></tr>
						</table><br>
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