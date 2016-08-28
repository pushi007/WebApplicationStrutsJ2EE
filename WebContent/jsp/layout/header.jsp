<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nexus Banking Group</title>
<script src="<%=request.getContextPath() %>/js/maxheight.js"
	type="text/javascript"></script>
</head>

<body id="page5" >
 <%String role=(String)session.getAttribute("role");
String usernm=(String)session.getAttribute("usernm");%>
   <!-- header -->
   <div id="header">
      <div class="container">
         <div class="row-1">
            <div class="logo"><table cellspacing=0 cellpadding=0 ><tr><td><img alt="" src="<%=request.getContextPath()%>/images/logo.jpg" /></td><td style="background-image:url('<%=request.getContextPath()%>/images/logo1.jpg');width:100%"><center><%if (usernm!=null){out.println("Username : "+usernm);} %><br><%if(role!=null){out.println("Role : "+role);} %><br></br><%if(role!=null) {%><a href="/NBG/LoginServlet?action=logout">Logout</a><%}%></center></td></tr></table></div>
           


            </div>
         <div class="row-2">
         	<!-- nav box begin -->
            <div class="nav-box">
            	<div class="left">
               	<div class="right">
                  	<ul>
                     	<li><a href="/NBG/EmployeeManagementServlet?action=home&&role=<%=role%>" class="first"><em><b>HOME</b></em></a></li>
                        <li><a href="/NBG/EmployeeManagementServlet?action=aboutUs"><em><b>ABOUT US</b></em></a></li>
                        <li><a href="/NBG/EmployeeManagementServlet?action=contactUs"><em><b>CONTACT US</b></em></a></li>
                        <li><a href="/NBG/EmployeeManagementServlet?action=help" class="last"><em><b>HELP</b></em></a></li>
                     </ul>
                  </div>
               </div>
            </div>
            <!-- nav box end -->
         </div>
      </div>
   </div>
</body>
</html>