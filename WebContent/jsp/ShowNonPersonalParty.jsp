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
    <%@page import="com.tvm.ilp.t154.cao.model.*" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Relationship Manager</title>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js" ></script>
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
                                    <center><h2>Change Relationship Manager</h2></center>
                                    <%NonPersonalParty nonpersonal=(NonPersonalParty)request.getAttribute("nonpersonal");%>
                                    <%Branch b=(Branch)request.getAttribute("branchName");%>
                                    <%Branch br=(Branch)request.getAttribute("brName"); %>
                                    
                                   <%RelationshipManager rmanager =(RelationshipManager)request.getAttribute("rm"); %><hr></hr>
                                    <form id="contacts-form1" name="UpdateManager" action="/NBG/AssignRelationshipManagerServlet">
                                   <input type="hidden" name="action" value="continue"></input>
                                    <input type="hidden" name="nonpersonalid" value="<%=nonpersonal.getNonPersonalId()%>">
                                    <input type="hidden" name="branchName" readonly="readonly" value="<%=b.getBranchName()%>">
                                   <table align="center"  border="2">
                                  
                                   <tr>
                                   <th><b>Customer ID</b></th>
                                   <th><b>Business Name</b></th>
                                   <th><b>Trading Name</b></th>
                                   <th><b>Branch </b></th>
                                   <th><b>Relationship Manager from <br><%if(br.getBranchName()!=null){ %>(<%=br.getBranchName()%>)<%} %>Branch</b></th>
                                   </tr>
                             
                                   <tr>
                                 
                                   <td><center><label  for="nonpersonalid"><%=nonpersonal.getNonPersonalId()%></label></center></td>
                                   <td ><label  for="businessName"><%=nonpersonal.getBusinessName() %></label></td>
                                  <td><label  for="tradingName"><%=nonpersonal.getTradingName()%></label></td>
                                   <td ><label for="branchName"><%=b.getBranchName()%></label></td>
                                   <td ><%if(rmanager.getTitle()!=null&& rmanager.getFirstName()!=null && rmanager.getLastName()!=null ){ %>
                                   <label><%=rmanager.getTitle() %>&nbsp;<%=rmanager.getFirstName() %>&nbsp;<%=rmanager.getLastName() %></label></td>
                                   <% } else{%>
                                   <%out.println("-------------"); %>
                                   <%} %>
                                   </tr>
                                   </table>
                                  
                                   <table align="center" cellspacing="10">
                                   
                                   <tr> <td colspan="1" ><center><a href="/NBG/AssignRelationshipManagerServlet?action=change&&nonpersonalid=<%=nonpersonal.getNonPersonalId()%>" class="button" onclick="document.getElementById('contacts-form1').submit()"><em><b>Change</b></em></a></center></td>
                                   
                                    <td colspan="2" ><center><a href="/NBG/AssignRelationshipManagerServlet?action=done&&nonpersonalid=<%=nonpersonal.getNonPersonalId()%>&&rmanager=<%=rmanager.getTitle() %>&nbsp;<%=rmanager.getFirstName() %>&nbsp;<%=rmanager.getLastName() %>&&businessName=<%=nonpersonal.getBusinessName() %>&&tradingName=<%=nonpersonal.getTradingName()%>&&branchname=<%=b.getBranchName()%>"class="button" ><em><b>Continue</b></em></a></center></td>
                                    
                                     
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