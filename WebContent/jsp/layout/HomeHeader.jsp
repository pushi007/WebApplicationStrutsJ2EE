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
           


            </div><!--
            <form name="h1" action="/NBG/LoginServlet">
            <input type="hidden" name="action" value="fr"></input>"
         -->
         <div class="row-2">
         	<!-- nav box begin -->
            <div class="nav-box">
            	<div class="left">
               	<div class="right">
                  	<ul>
                     	<li><a href="/NBG/EmployeeManagementServlet?action=home&&role=<%=role%>" class="first"><em><b><%String home=(String) session.getAttribute("homeaheader");if(home!=null){out.println(home);}else{ %>HOME<%} %></b></em></a></li>
                        <li><a href="/NBG/EmployeeManagementServlet?action=aboutUs"><em><b><%String aboutUs=(String) session.getAttribute("aboutusHeader");if(aboutUs!=null){out.println(aboutUs);}else{ %>ABOUT US<%} %></b></em></a></li>
                        <li><a href="/NBG/EmployeeManagementServlet?action=contactUs"><em><b><%String contacUs=(String) session.getAttribute("contactsHeader");if(contacUs!=null){out.println(contacUs);}else{ %>CONTACT US<%} %></b></em></a></li>
                        <li><a href="/NBG/EmployeeManagementServlet?action=help" ><em><b><%String help=(String) session.getAttribute("helpHeader");if(help!=null){out.println(help);}else{ %>HELP<%} %></b></em></a></li>
                        
                        <li><a href="#" class="last"><em><b>
                        <form action="/NBG/LoginServlet?action">
                        <input type="hidden" name="action" value="selectLanguage">
                        
                        <select name="language" style="margin-top: 0px" >
                        <option value="unselected" >Select Language</option>
                       <option value="English" <%if(("english".equalsIgnoreCase((String)session.getAttribute("lang")))){out.println("selected");} %>>English</option>
                        <option value="French" <%if(("french".equalsIgnoreCase((String)session.getAttribute("lang")))){out.println("selected");} %>>French</option>
                        <option value="Spanish" <%if(("spanish".equalsIgnoreCase((String)session.getAttribute("lang")))){out.println("selected");} %>>Spanish</option>
                        <option value="German" <%if(("german".equalsIgnoreCase((String)session.getAttribute("lang")))){out.println("selected");} %>>German</option>
                        
                        </select>
                        <input  type="submit" value="Go"/>
                        </form>
                        
                        
                        </b></em></a></li>
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