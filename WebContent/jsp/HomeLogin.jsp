<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description"
	content="Consulting page - free business website template from Template Monster is awating for you to download." />

<link href="<%=request.getContextPath()%>/css/style1.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/EmpRegiValidation.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/j/maxheight.js"
	type="text/javascript"></script>

<!--[if lt IE 7]>
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

</head>

<body id="page5" onload="new ElementMaxHeight();">
<jsp:include page="layout/HomeHeader.jsp" />
<!-- content -->
<div id="content">
<div class="container"><!-- main-banner-small begin -->
<div class="main-banner-small">
<div class="inner">
<h1>
<%String headerMesg=(String)session.getAttribute("tagLinehl");
if(headerMesg!=null){out.println(headerMesg);}else {%>
The bank for a changing world.<%} %></h1>
</div>
</div>
<!-- main-banner-small end -->
<div class="wrapper">
<div class="col-3 maxheight"><!-- box begin -->
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

<form name="Login" id="contacts-form1" action="/NBG/LoginServlet" id="Login" method=post>
<input type="hidden" name="action" value="login"></input>
<div style="margin-top: 3px;">
<h2><%String login=(String)session.getAttribute("loginHeading");if(login!=null){out.println(login);}else{ %>Login<%} %></h2>
<span style="color:red;font-family: Arial, Verdana; font-size:12px">
<%
	if (request.getParameter("msg") != null) {
		String errMsg = (String) request.getParameter("msg");

		out.println(errMsg);
	}
%>
</span>

<table width=25% " cellspacing=5 cellpadding=10>
	
	<tr>
		<td class="label" colspan=2><label id="err_Login"></label></td>
	</tr>
<tr><td>

</td></tr>
	<tr>
		<td><b><%String username=(String)session.getAttribute("userName");if(username!=null){out.println(username);}else{ %>Username<%} %></b></td>
		<td><input type="text" name="UID" title="Please enter Username"
			onblur="chkLogin();" /></td>
	</tr>

	<tr>
		<td><br>
		</td>
		<td><br>
		</td>
	</tr>

	<tr>
		<td><b><%String pass=(String)session.getAttribute("passWord");if(pass!=null){out.println(pass);} else{%>Password<%} %></b></td>
		<td><input type="password" name="pwd" title="Please enter Password"></td>
	</tr>
	<tr>
		<td><br>
		</td>
		<td><br>
		</td>
	</tr>
</table>


<table align="center">
	<tr>
		<td width=90% colspan="2" style="align: center; padding: 10px;"><a
			href="#" class="button"
			onclick="document.Login.submit();"><em><b><%String loginButton=(String)session.getAttribute("loginButton");if(loginButton!=null){out.println(loginButton);}else{ %>Login<%} %> </b></em></a>
		</td>
	</tr>

	<tr>
		<td><br>
		</td>
		<td><br>
		</td>
	</tr>

	<tr>
		<td colspan=2 align="center"><a
			href="/NBG/LoginServlet?action=forgotPwd"><%String fgtPass=(String)session.getAttribute("forgotaPassword");if(fgtPass!=null){out.println(fgtPass);}else{ %>Forgot
		Password?<%} %></a></td>
	</tr>
</table>
</div>
</form>

<br/><br/>
  <h2><span><small><center><%String newsUpdt=(String)session.getAttribute("newsAndUpdates");if(newsUpdt!=null){out.println(newsUpdt);} else{%>News and Updates<%} %></center></small></span></h2>
<marquee direction="up" scrollamount=2 scrolldelay=2% onmouseover="this.scrollAmount=0" onmouseout="this.scrollAmount=2">
<center><font color="#2D333A"><b><%String impUpdt=(String)session.getAttribute("importantUpdates");if(impUpdt!=null){out.println(impUpdt);} else{%>Important Updates!!<%} %></b></font></center><br>
<div align="left"><font color="#0088FF"><font size=2>
<%String frPolicy=(String)session.getAttribute("update1");if(frPolicy!=null){out.println(frPolicy);}else{ %>According to new Foreign Account Policy, only one commercial account can be provided for non-UK business customers.
<%} %></font></font></div>
<br><font color="#2D333A"><div align="center">* * *<font size=2></div></font>
<div align="left"><font color="#0088FF"><font size=2>
<%String nbgWins=(String)session.getAttribute("update2"); if(nbgWins!=null){out.println(nbgWins);}else{%>Nexus Banking Group wins 'Business Banking Excellence' award on 1st Jan,2013 among 20 other banks.
<%} %></font></font></div>
<br><font color="#2D333A"><div align="center">* * *<font size=2></div></font>
<font color="#0088FF"><font size=2><div align="left">
<%String newEHelp=(String)session.getAttribute("update3");if(newEHelp!=null){out.println(newEHelp);}else{ %>New:e-help for our employees to use new online portal. You can call to the employee helpdesk for more information.<%} %> </div>
</font></font>
<br><font color="#2D333A"><div align="center">* * *<font size=2></div></font>
<font color="#0088FF"><font size=2><div align="left">
</div>
</font></font>
<br><font color="#2D333A"><div align="center"><font size=2></div></font>
</marquee>
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
<!-- box end --></div>
<div class="col-4 maxheight"><!-- box begin -->
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

<hr>
<br>


<img src="<%=request.getContextPath() %>/images/image.png" height="190" width="560"></img><br><br>
<hr><br><br>
<p style="font-family: Arial, Verdana; font-size: 15px;">
<%String message=(String)session.getAttribute("messageContent"); 
if(message!=null){
	out.println(message);
} else{%>
We began to operate in United Kingdom with a simple mission, to be one of the best banks here. 
We realized that only a single-minded focus on product quality and service excellence would help us get there.
Today, we are proud to say that we are well on our way towards that goal.
It is extremely gratifying that our efforts towards providing customer convenience have been appreciated both nationally and internationally.
    <%} %></p>                    


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


 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>