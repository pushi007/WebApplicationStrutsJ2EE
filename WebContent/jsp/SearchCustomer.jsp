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
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.tvm.ilp.t154.cao.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Business Customer</title>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/SearchBusinessCustomer.js" type="text/javascript"></script>
<script type="text/javascript">

function selectRadio()
{	
	
	var a=document.BusinessCustomer.bName1.value;
	var b=document.BusinessCustomer.bbrName.value;
	var c=document.BusinessCustomer.tName1.value;
	var d=document.BusinessCustomer.tbrName.value;
	var e=document.BusinessCustomer.accno.value;
	var exp=/^([\!a-zA-Z])([0-9a-zA-Z\s@$&.]){0,28}$/;
	if(document.BusinessCustomer.radio[0].checked==false && document.BusinessCustomer.radio[1].checked==false && document.BusinessCustomer.radio[2].checked==false ){
		alert("Please select radio button for search business customer");	
		return false;		
	}	
	else if(document.BusinessCustomer.radio[0].checked==true && document.BusinessCustomer.radio[1].checked==false && document.BusinessCustomer.radio[2].checked==false){
		if(a=="" || a==null){
			document.getElementById("err_message").innerHTML="Please enter Business Name";
			return false;
		}
		else if(!a.match(exp)){
			document.getElementById("err_message").innerHTML="Please enter alphabets, numbers and .@$!& special characters only";
			return false;
		}
			
		else if(b=="select"){
			document.getElementById("err_message1").innerHTML="Please select Branch Name";
			return false;
		}
		else{
			document.getElementById("err_message").innerHTML="";
			document.getElementById("err_message1").innerHTML="";
			document.BusinessCustomer.submit();
			return true;
		}			
	}
	else if(document.BusinessCustomer.radio[0].checked==false && document.BusinessCustomer.radio[1].checked==true && document.BusinessCustomer.radio[2].checked==false){
		if(c=="" || c==null){
			document.getElementById("err_message2").innerHTML="Please enter Trading Name";
			return false;
		}
		else if(!c.match(exp)){
			document.getElementById("err_message2").innerHTML="Please enter alphabets, numbers and .@$!& special characters only";
			return false;
		}
		else if(d=="select"){
			document.getElementById("err_message3").innerHTML="Please select Branch Name";
			return false;
		}
		else{
			document.BusinessCustomer.submit();
			return true;
		}			
	}
	else if(document.BusinessCustomer.radio[0].checked==false && document.BusinessCustomer.radio[1].checked==false && document.BusinessCustomer.radio[2].checked==true){

		var exp=/^[0-9]+$/;
		var exp1=/^[1-9][0-9]+$/;
		if(e=="" || e==null){
			document.getElementById("err_message4").innerHTML="Please enter an Account Number";
			return false;
		}else if(!e.match(exp1)){
			document.getElementById("err_message4").innerHTML="Account Number should not start with zero";
			return false;
		}	
		else if(e.length!=14){
			document.getElementById("err_message4").innerHTML="Please enter 14 digit account number";
			return false;
		}else if(!e.match(exp)){
			document.getElementById("err_message4").innerHTML="Please enter numeric value";
			return false;
		}		
		else{
			document.BusinessCustomer.submit();
			return true;
		}			
	}
	 
}
function validateReset()
{
	
	document.getElementById("err_message").innerHTML="";
	document.getElementById("err_message1").innerHTML="";
	document.getElementById("err_message2").innerHTML="";
	document.getElementById("err_message3").innerHTML="";
	document.getElementById("err_message4").innerHTML="";
	document.getElementById("contacts-form2").reset();
	
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
											<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Commercial Account Opening</b></p>
											<hr></hr>
											<br>
										
											<h4><a href="<%=request.getContextPath() %>/jsp/RegistrationPortal.jsp"><b style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
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
                                              <center><h2>Search for Business Customer</h2></center>
                                              <hr>
											<%List<Branch> bList=(ArrayList<Branch>)request.getSession().getAttribute("branchList"); %>


<%String message=(String)request.getAttribute("msg") ;%>

<%if(message!=null) {%>


<center><b><font style="color:red;" id="message"><%=message %></font></b></center>

<%} %>
<form id="contacts-form2" name="BusinessCustomer" action="/NBG/SearchCustomerServlet?action=SearchDetails"   >
<input type="hidden" name="action" value="SearchDetails"></input>
<span align=right>Fields marked with <span style="color:red;">*</span> are mandatory&nbsp;&nbsp;&nbsp;</span>

<table align="left" cellspacing="10">
<tr></tr>

<tr> 
<td><input type="radio" name="radio" id="radio" onclick="return businessName()" ></td>
<td align="left"><b>Business Name<sup style="color:red;">*</sup></b></td>
<td>&nbsp;<input type='text' title="Please Enter Business Name" id="bName1" name="bName1" size='30' maxlength="30" width='10' disabled=true></td>
<td><label id="err_message" style="color: red;"></label></td>
</tr>

<tr> 
<td></td>
<td align="left"><b>Branch Name<sup style="color:red;">*</sup></b></td>
<td>&nbsp;<select name='bbrName' disabled=true>
<option value="select">-------------Select------------</option>
<%for(Branch b:bList){ %>
<option  value="<%=b.getBranchName()%>"><%=b.getBranchName()%></option>
<%} %>
</select>
</td>
<td><label id="err_message1" style="color: red;"></label></td>
</tr>

<tr>

<td></td>
<td align="center">OR<td>

</tr>

<tr> 
<td><input type="radio" name="radio" id="radio"  onclick="return tradingName()"></td>
<td align="left"><b>Trading Name<sup style="color:red;">*</sup></b></td>

<td>&nbsp;<input type='text' title="Please Enter Trading Name" name='tName1' id="tName1" size='30' maxlength="30" width='10' disabled=true></td>

<td><label id="err_message2" style="color: red;"></label></td>

</tr>

<tr> 
<td></td>
<td align="left"><b>Branch Name<sup style="color:red;">*</sup></b></td>
<td>&nbsp;<select name='tbrName' disabled=true>
<option value="select">-------------Select------------</option>
<%for(Branch b:bList){ %>
<option  value="<%=b.getBranchName()%>"><%=b.getBranchName()%></option>
<%} %>
</select>
</td>
<td><label id="err_message3" style="color: red;"></label></td>
</tr>


<tr>

<td></td>
<td align="center">OR<td>

</tr>

<tr> 
<td><input type="radio" name="radio" id="radio" onclick="return accountNumber()"></td>
<td align="left"><b>Account Number<sup style="color:red;">*</sup></b></td>
<td>&nbsp;<input type='text' title="Please Enter the Account Number" name='accno' size='30' maxlength="15" width='10' disabled=true></td>
<td><label id="err_message4" style="color: red;"></label></td>
</tr>






<tr>
<td></td>
<td colspan="1" style="padding:10px;" align="center"><a  class="button" onclick="return selectRadio();"><em><b>Search</b></em></a></td>
<td  align="left"><a href="#" class="button" onclick="return validateReset();"><em><b>Reset</b></em></a>
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
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>