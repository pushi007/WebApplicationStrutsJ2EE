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
<title>Search Account Number</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"  />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/layout.css"  />
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/maxheight.js"></script>
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js"></script>

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
											<ul>                                             
<li><b style="font-family:Arial,Verdana;font-size:16px;color:#000">Commercial Product Configuration</b><br/><br/></li>

            <li style="font-family:Arial,Verdana;font-size:14px;color:#000"><a href="/NBG/AdditionalProductConfigServlet?action=applyForProduct" >Apply for Additional Product</a></li>
			<li><br/></li>
			<li style="font-family:Arial,Verdana;font-size:14px;color:#000"><a href="#" >My Portal</a></li>
<li><br/></li>
 </ul>
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
                                       <center><h2>Search Account Number</h2></center>
                                      
						<center><h5>Please enter Account Number:</h5></center>
						<form name="search_acc_number" id='contacts-form' method="post" action="/NBG/AdditionalProductConfigServlet" onsubmit="return validate();">
						<input type="hidden" name="action" value="searchAccount"></input>
						<table align="center" cellspacing="10">
						<tr> 
						<td style="padding:15px;"><b>Account Number<sup style="color:red;">*</sup></b></td>
						<td>&nbsp;<input type='text' name="acc_number" title="Account Number" id='bname' size="30" width="10" onblur="validateAccountNumber();"></td>
						<td style="padding:10px;"><a class="button" onclick="return validate();"><em><b>Search</b></em>
						</a>
						</td>
						</tr>
						</table>
						</form>
						<center><label id="err_message" style="color:red;"></label></center>
						
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
               <!-- box end -->
            </div>
         </div>
      </div>

   <!-- footer -->
	<jsp:include page="../jsp/layout/footer.jsp"></jsp:include>

</body>
</html>