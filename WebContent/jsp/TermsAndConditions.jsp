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
<title>Terms and Conditions</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"  />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/layout.css"  />
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/maxheight.js"></script>
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js"></script>
<script language="javascript">
function validateAccept(){
	var chk=document.getElementsByName("iAgree");
	var flag=0;
	for(var i=0;i<chk.length;i++){
		if(chk[i].checked==true){
			flag=1;
			break;
		}	
	}
	if(flag==0){
		alert("Please select 'I agree' to accept Terms and Conditions");
		return false;
	}
	else{
		document.termsAndConditions.submit();
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
											<!--<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">Create Account</b></a></h4>
											--><h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
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
                                       <center><h2>Terms and Conditions</h2></center>
                                       <p>These terms and conditions apply to and regulate the operation of the Current and Savings (the "Account") offered by Nexus Bank. 
These terms and conditions shall be in addition to any other terms as stipulated by Nexus Bank from time to time. </p>
<p><b>1. Definitions</b><br>
In these terms and conditions, the following words and phrases have the meaning stated here under unless indicated otherwise: 
<br>a)"Account Opening Form"(AOF) refers to the relationship form for Savings Account. 
<br>b)"Customer" refers to any person holding an Account with Nexus Bank. 
<br>c)"Services" shall mean the services provided by Nexus Bank in connection with the Saving Account and more particularly described in these Terms. 
<br>d)"Website" refers to the website owned, established and maintained by Nexus Bank at the URL www.nbg.com.
<br>e)"Nexus Bank 24-Hour Customer Care Centre" refers to Nexus Bank - Phone Banking Service provided by Nexus Bank to the Customer. </p>
<p><b>Interpretation:</b>
<br>a)All references to singular include plural and vice versa and the word "includes" should be construed as "without limitation". 
<br>b)Words importing any gender include the other gender. 
<br>c)Reference to any statute, ordinance or other law includes all regulations and other instruments and all consolidations, amendments, re-enactments or replacements for the time being in force. 
<br>d)All headings, bold typing and italics (if any) have been inserted for convenience of reference only and do not define limit or affect the meaning or interpretation of these Terms. 
<br>e)Words "Nexus Bank", "the Bank", refer to Nexus Bank Limited having its registered office at Landmark, Race Course Circle, City of London 390007. </p>
<br></br>
<p><b>2. Applicability of Terms:</b> <br>
These terms and conditions form the contract between the Customer and Nexus Bank. The Customer shall apply to Nexus Bank in the prescribed form for operation of the Account and availing of the related Services. 
By applying for opening the Account, the Customer acknowledges that he / she has /have read understood and accepted these terms and conditions. </p>
<p><b>3. Account Opening:</b><br>
The account opening formalities are governed by the policies of Nexus Bank and may be revised from time to time. It may require customer/s to submit duly filled application form/s along with the prescribed set of documents stipulated including Permanent Account No. (PAN) or Form 60/61 from time to time, to the satisfaction of the Bank. The Account cannot be opened for business purposes. 
In case the Account is opened with an account opening cheque, Nexus Bank reserves the right not to open/activate the Account in the event the account opening cheque is dishonored. 
Any transactions undertaken from this account, shall be in compliance of all the FEMA rules, regulations or notifications thereunder. </p>
<p><b>4. Operating Accounts: </b><br>
<br>a)An Account may be opened in the names of: 
<br>->An individual in his/her own name. 
<br>->Two or more persons in their joint names. </p>

<form name="termsAndConditions" id='contacts-form2' method="post" action="/NBG/AdditionalProductConfigServlet" onsubmit="return validate();">
<input type="hidden" name="action" value="applyForProduct"></input>
<input type="checkbox" name="iAgree" value="I agree"/>I agree<br></br>
<table align="center">
<tr><td colspan="2" style="padding:10px;"><a href="#" class="button" onclick="return validateAccept();"><em><b>Accept</b></em></a></td>
<td style="padding:10px;"><a href="#" class="button" onclick="return validateReject();"><em><b>Reject</b></em></a>
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
</div>
</div>
</div>

<!-- footer -->
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>