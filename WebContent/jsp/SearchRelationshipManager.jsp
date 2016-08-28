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
<title>Search for Business Customer's Details</title>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js"></script>

<script language="javascript">

function disableTrading(){
	document.searchManager.businessName.disabled=false;
	document.searchManager.tradingName.disabled=true;
	return true;
}
function disableBusiness(){
	document.searchManager.businessName.disabled=true;
	document.searchManager.tradingName.disabled=false;
	return true;
}


function selectRadio()
{	
	
	var a=document.searchManager.businessName.value;
	var b=document.searchManager.tradingName.value;
	

	if(document.searchManager.radio[0].checked==false && document.searchManager.radio[1].checked==false ){
		alert("Please select radio button for searching business customer");	
		return false;		
	}	
	else if(document.searchManager.radio[0].checked==true && document.searchManager.radio[1].checked==false){
		if(a=="" || a==null){
			document.getElementById("err_message").innerHTML="Please enter Business Name";
			return false;
		}
		else{
			document.getElementById("err_message").innerHTML="";
			
			document.searchManager.submit();
			return true;
		}			
	}
	else if(document.searchManager.radio[0].checked==false && document.searchManager.radio[1].checked==true){
		if(b=="" || b==null){
			document.getElementById("err_message2").innerHTML="Please enter Trading Name";
			return false;
		}
		else{
			document.searchManager.submit();
			return true;
		}			
	}
	
	 
}
function validateReset()
{
	
	document.getElementById("err_message").innerHTML="";
	document.getElementById("err_message2").innerHTML="";
	document.getElementById('contacts-form2').reset();
	return true;
	
}

</script><!--[if lt IE 7]>
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
            	<h1><%String  tagLinehl=(String)session.getAttribute("tagLinehl");if(tagLinehl!=null){out.println(tagLinehl);}else{ %>The bank for a changing world.<%} %></h1>
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
											<p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String  keyCommercial=(String)session.getAttribute("keyCommercial");if(keyCommercial!=null){out.println(keyCommercial);}else{ %>Commercial Account Opening<%} %></b></p>
											<hr></hr>
											<br>
											<!--<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">Open Account</b></a></h4>-->
											<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;"><%String  keyMyPortal=(String)session.getAttribute("keyMyPortal");if(keyMyPortal!=null){out.println(keyMyPortal);}else{ %>My Portal<%} %></b></a></h4>
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
                                    <center><h2><%String  keySearchforBusinessCustomersDetails=(String)session.getAttribute("keySearchforBusinessCustomersDetails");if(keySearchforBusinessCustomersDetails!=null){out.println(keySearchforBusinessCustomersDetails);}else{ %>Search for Business Customer's Details<%} %></h2></center>
                                    <hr>
                                     <%String message=(String)request.getAttribute("msg");%>
                                      <%if((message)!=null) {%>
                                    <label style="color:red"><center><h4><%=message%></h4></center></label>
                                         <%} %>
                                         
                                   <form id="contacts-form2" name="searchManager" action="/NBG/AssignRelationshipManagerServlet" onsubmit="return bname();">
                                   <input type="hidden" name="action" value="BusinessDetails"></input>
                                     
                                   
                                    
                                   <table align="center" cellspacing="6">
                                 <tr><span align=right><%String keyfieldsmarkedwith=(String)session.getAttribute("keyfieldsmarkedwith");if(keyfieldsmarkedwith!=null){out.println(keyfieldsmarkedwith);}else{ %>Fields marked with <%} %><span style="color:red;">*</span> <%String keyaremandatory=(String)session.getAttribute("keyaremandatory");if(keyaremandatory!=null){out.println(keyaremandatory);}else{ %>are mandatory<%} %>&nbsp;&nbsp;&nbsp;</span></tr>
                                       <tr>
                                         
                                        <td><input type="radio" name="radio" onclick="return disableTrading();"></td>
                                         <td><b> <%String keyEnterBusinessName=(String)session.getAttribute("keyEnterBusinessName");if(keyEnterBusinessName!=null){out.println(keyEnterBusinessName);}else{ %>Enter Business Name<%} %><sup style="color:red;">*</sup></b></td>
                                         <td style="padding:15px;"><input type="text" name="businessName" id="businessName"  disabled=true >
                                         </td>
                                         <td><label id="err_message" style="color: red;"></label></td>
                                         </tr>
                                         <tr>

                                         <td></td>
                                         <td align="center"><%String keyOR=(String)session.getAttribute("keyOR"); if(keyOR!=null){out.println(keyOR);}else{ %>OR<%} %></td>

                                         </tr>
                                         <tr>
                                          <td><input type="radio" name="radio" onclick="return disableBusiness();"></td>
                                         <td ><b><%String keyEnterTradingName=(String)session.getAttribute("keyEnterTradingName");if(keyEnterTradingName!=null){out.println(keyEnterTradingName);}else{ %> Enter Trading Name<%} %><sup style="color:red;">*</sup></b></td>
                                         <td style="padding:15px;"><input type="text" name="tradingName" id="tradingName" disabled=true ></td>
                                         <td><label id="err_message2" style="color: red;"></label></td>
                                         </tr>
                                         <tr><td></td>
                                     
                                          <td colspan="2" ><center><a href="#" class="button" onclick="return selectRadio();" ><em><b><%String keysearchbutton=(String)session.getAttribute("keysearchbutton");if(keysearchbutton!=null){out.println(keysearchbutton);}else{ %>Search<%} %></b></em></a></center></td>
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
			<!-- box end -->
            </div>
         </div>
      </div>
   <!-- footer -->
	<jsp:include page="../jsp/layout/footer.jsp"></jsp:include>
</body>
</html>