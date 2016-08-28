<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nexus Banking Group</title>

</head>

<body>
<%String role=(String)session.getAttribute("role");
String usernm=(String)session.getAttribute("usernm");%>
<!-- footer -->
   <div id="footer">
   	<div class="container">
      	<ul class="nav" style="font-size:12px;">
         	<li><a href="/NBG/EmployeeManagementServlet?action=home&&role=<%=role%>"><%String home=(String) session.getAttribute("homeFooter");if(home!=null){out.println(home);}else{ %>Home<%} %></a>|</li>
            <li><a href="/NBG/EmployeeManagementServlet?action=aboutUs"><%String aboutUs=(String) session.getAttribute("aboutusFooter");if(aboutUs!=null){out.println(aboutUs);}else{ %>About Us<%} %></a>|</li>
            <li><a href="/NBG/EmployeeManagementServlet?action=contactUs"><%String contacUs=(String) session.getAttribute("contactusFooter");if(contacUs!=null){out.println(contacUs);}else{ %>Contact Us<%} %></a>|</li>
            <li><a href="/NBG/EmployeeManagementServlet?action=help"><%String help=(String) session.getAttribute("helpFooter");if(help!=null){out.println(help);}else{ %>Help<%} %></a></li>
         </ul>
         <div class="wrapper" style="font-size:12px;">
         	<div class="fleft">Copyright &copy; Nexus Banking Group 2013</div>
            <div class="fright"><%String designedBy=(String)session.getAttribute("designedBy");if(designedBy!=null){out.println(designedBy);}else{ %>Designed by Project Team 2<%} %></div>
         </div>
      </div>
   </div>
</body>
</html>