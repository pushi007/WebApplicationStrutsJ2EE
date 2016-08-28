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
<title>Business Customer Details</title>
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
											<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Business Account Creation</b></p>
											<hr></hr>
											<br>
											<h4><a href="/NBG/SearchCustomerServlet?action=searchCustomer"><b style="font-family: Arial; font-size: 12px;">Create Account</b></a></h4>
											<h4><a href="<%=request.getContextPath() %>/jsp/SearchRelationshipManager.jsp"><b style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
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
                                    <center><h2>Business Customer Details</h2></center>
                                    <%NonPersonalParty nonpersonal=(NonPersonalParty)request.getAttribute("nonpersonal");%>
                                    <%Branch b=(Branch)request.getAttribute("branchName");%>
                                    <%Branch br=(Branch)request.getAttribute("brName"); %>
                                    <%ArrayList<RelationshipManager> rmList=(ArrayList<RelationshipManager>)request.getAttribute("RMList"); %>
                                   <%RelationshipManager rmanager =(RelationshipManager)request.getAttribute("rm"); %>
                                    <form id="contacts-form1" name="UpdateManager" action="/NBG/AssignRelationshipManagerServlet">
                                   <input type="hidden" name="action" value="continue"></input>
                                    
                                   <table align="center" cellspacing="10">
                                  
                                   <tr>
                                   <th><b>NonPersonalId</b></th>
                                   <th><b>Business<br> Name</b></th>
                                   <th><b>Trading<br> Name</b></th>
                                   <th><b>Branch </b></th>
                                   <th><b>Relationship<br>Manager<br>from Branch<br>(<%=br.getBranchName()%>)</b></th>
                                   </tr>
                                   <tr>
                                 
                                   <td><input type="text" title="Please Enter Non Personal ID" name="nonpersonalid" radonly="readonly" value="<%=nonpersonal.getNonPersonalId()%>"></input></td>
                                   <td ><label  for="businessName"><%=nonpersonal.getBusinessName() %></label></td>
                                  <td><label  for="tradingName"><%=nonpersonal.getTradingName()%></label></td>
                                   <td ><input type="text" title="Please Enter Branch Name" name="branchName" readonly="readonly" value="<%=b.getBranchName()%>"></input></td>
                                   <td ><label><%=rmanager.getTitle() %><%=rmanager.getFirstName() %><%=rmanager.getLastName() %></label></td>
                                   </tr>
                                   </table>
                                  
                                   <table align="center" cellspacing="10">
                                   <tr>
                                   <td>List of Relationship Manager <b><%=b.getBranchName()%></b></td>
                                   <td><select name="listOfManager">
                                   <option value="<---------SELECT---------->"><---------SELECT----------></option>
                                   <%for(RelationshipManager rm:rmList){ %>
                                   <option value="<%=rm.getRmId()%>"><%=rm.getTitle()%> <%=rm.getFirstName()%> <%=rm.getLastName()%></option>
                                   <%} %>
                                   </select></td>
                                   </tr>
                                   <tr> <td colspan="1" ><center><a href="/NBG/AssignRelationshipManagerServlet?action=change&&nonpersonalid=<%=nonpersonal.getNonPersonalId() %>" class="button" onclick="document.getElementById('contacts-form').submit()"><em><b>Change</b></em></a></center></td>
                                   
                                    <td colspan="2" ><center><a href="#"class="button" onclick="document.getElementById('contacts-form1').submit()"><em><b>Continue</b></em></a></center></td>
                                    <td colspan="2" ><center><a href="/NBG/AssignRelationshipManagerServlet?action=cancel&&nonpersonalid=<%=nonpersonal.getNonPersonalId() %>"class="button" onclick="document.getElementById('contacts-form').submit()"><em><b>Cancel</b></em></a></center></td>
                                     
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