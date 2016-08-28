<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<s:form action="login.action" name="Login" method="post">
<table width=25% " cellspacing=5 cellpadding=10>
	
	<tr>
		<td class="label" colspan=2><label id="err_Login"></label></td>
	</tr>
<tr><td>

</td></tr>
	<tr>
		<td><b><%String username=(String)session.getAttribute("userName");if(username!=null){out.println(username);}else{ %>Username<%} %></b></td>
		<td><s:textfield name="UID" tooltip="Please enter Username" key="label.usrname"
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
		<td><s:password name="pwd" tooltip="Please enter Password" key="label.password"/></td>
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
		<td width=90% colspan="2" style="align: center; padding: 10px;">
		<s:a href="#" cssClass="button" key="label.login" 
			onclick="document.Login.submit();"><em><b><%String loginButton=(String)session.getAttribute("loginButton");if(loginButton!=null){out.println(loginButton);}else{ %>Login<%} %> </b></em></s:a>
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



</s:form>
</body>
</html>