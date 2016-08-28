<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Address Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description" content="Consulting page - free business website template from Template Monster is awating for you to download."/>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/registration.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/ContactDetailsRegValidation.js" type="text/javascript"></script>
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/maxheight.js"></script>
<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->
<title>Nexus Banking Group</title>
</head>
<body id="page5" >
   <!-- header -->
   <jsp:include page="layout/header.jsp" />
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
<a href="#" onclick="return validateMyPortal();" style="font-size-adjust: inherit"><span style="font-size:12px">My Portal</span></a>
	<br /><br />
	<a href="#" onclick="return validateFind();" style="font-size-adjust: inherit"><span style="font-size:12px">Find
	Business</span></a>
	
	
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
	<br/>
	<br>
	</br>
	<br/>
	<br>
	</br>
	
	
	
	
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
                                             <h2>Business Customer Registration</h2>
                                             <form name="reg_form"  action="/NBG/CustomerManagementServlet" method="post"> 
                                             
<input type="hidden" name="action" value="registerContactDetails"/>

<hr/>
<h3 >
<font color="#8A3E08"><b>Capture Contact Details</b><br/></font></h3>

<span style="align:right"><b>Fields marked with <span style="color:red;">*</span> are mandatory</b>&nbsp;&nbsp;&nbsp;</span><br/>
<table  style="height: 100%;" cellpadding="5">


<tr>
	<td><b>Contact No</b>(Landline)<sup><font color="red">*</font></sup></td>	
	<td><input type="text" name="concountrycode" title="Country code" size=3 value="+" onblur="return validWorkCountryCode();"/>
	<input type="text" name="conareacode" title="Area code" size=6 onblur="return validWorkCityCode();"/>
	<input type="text" name="conno"  title="Landline Number" size="15" onblur="return validWorkTelephoneNumber();"/><label style="color:red;" id="error_contact"></label></td>
	
</tr>

<tr>
	<td><b>FAX No<sup><font color="red">*</font></sup></b>
	</td>	
	
	<td>
	<input type="text" name="faxcountrycode" title="Country code" size=3 value="+" onblur="return validFaxCountryCode();"/>
	<input type="text" name="faxareacode" title="Area code" size=6 onblur="return validFaxCityCode();"/> 
	<input type="text" name="faxno" title="FAX Number" size="15" onblur="return validFaxTelephoneNumber();"/><label style="color:red;" id="error_fax"></label></td>
	

</tr>

<tr>
	<td><b>Business Email Address<sup><font color="red">*</font></sup></b></td>	
	<td><input type="text" name="bemail" 
	title="Enter Business Email Address" 
	onblur="return validEmail();"/><label style="color:red;" id="error_bemail"></label></td>
	
</tr>
</table>
<br>
</br>
<table>
	<tr>
		<td width=30% colspan="2" tabindex="16" style="align: center; padding: 10px;"><a type="submit"
			class="button" onclick="return validateContactDetails();"><em><b>Submit</b></em></a>
		</td>
		<td width=30% colspan="2" tabindex="17" style="align: center; padding: 10px;"><a
			 class="button"
			onclick="document.reg_form.reset();"><em><b>Reset</b></em></a></td>
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
               <!-- box end -->
            </div>
         </div>
      
   <!-- footer -->
    <div style="margin-top:15px" ></div>
   <jsp:include page="layout/footer.jsp"></jsp:include>
</body>

</html>