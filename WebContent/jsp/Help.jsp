<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="static com.tvm.ilp.t154.cao.constants.CAOConstants.*"%>
<%@page import="com.tvm.ilp.t154.cao.model.*"%>
<%@page import="java.util.*"%>


<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />


<title>Nexus Banking Group</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/calender.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/maxheight.js"
	type="text/javascript"></script>


<script src="<%=request.getContextPath()%>/js/registration.js"
	type="text/javascript"></script>

<script
	src="<%=request.getContextPath()%>/js/registerCoreDetailsValidation.js"
	type="text/javascript"></script>
<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

</head>

<body id="page5" onload="new ElementMaxHeight();">
<!-- header -->
<jsp:include page="layout/header.jsp"></jsp:include>
<!-- content -->
<div id="content">
<div class="container"><!-- main-banner-small begin -->
<div class="main-banner-small">
<div class="inner">
<h1><%String headerMesg=(String)session.getAttribute("tagLinehl");
if(headerMesg!=null){out.println(headerMesg);}else {%>
The bank for a changing world.<%} %></h1>
</div>
</div>
<!-- main-banner-small end -->
<div class="section"><!-- box begin -->
<div class="box">
<div class="border-top">
<div class="border-right">
<div class="border-bot">
<div class="border-left">
<div class="left-top-corner">
<div class="right-top-corner">
<div class="right-bot-corner">
<div class="left-bot-corner">
<div class="inner">
<h2><%String keyHelp= (String)session.getAttribute("keyHelp");if(keyHelp!=null){out.println(keyHelp);}else{%>>Help<%} %></h2>
<hr></hr>
<table width=100%>
	<tr>
		<td width=30% align="center"><img src="<%=request.getContextPath()%>/images/help2.jpg "
			width="880" height="250"></img></td>

	</tr>
</table>
<br></br>
<br></br>
<ul>
<li><strong style="color: #2cb6e9;"><%String keyTop5questions= (String)session.getAttribute("keyTop5questions");if(keyTop5questions!=null){out.println(keyTop5questions);}else{%>>Top 8 questions<%} %></strong></li>
	
</ul>
<br></br>

<p style="align: justify"><span style="color: #2cb6e9"><%String keyQuestion1=(String)session.getAttribute("keyQuestion1");if(keyQuestion1!=null){out.println(keyQuestion1);}else {%>Can I
request copies of statements online?<%} %></span><br/>
<%String keyAnswer1=(String)session.getAttribute("keyAnswer1");if(keyAnswer1!=null){out.println(keyAnswer1);}else {%>
You can view, print and archive up to 24 months of your statements
online.To receive a copy by mail, call Customer Care at 877 422 6569
available Monday - Friday, 8 a.m. - 8 p.m. We may assess a small fee for
mailed statements. <%} %><br></br>

<span style="color: #2cb6e9"><%String keyQuestion2=(String)session.getAttribute("keyQuestion2");if(keyQuestion2!=null){out.println(keyQuestion2);}else {%>How many months of transaction
history can be viewed?<%} %></span><br/>
<%String keyAnswer2=(String)session.getAttribute("keyAnswer2");if(keyAnswer2!=null){out.println(keyAnswer2);}else {%>Your transaction history builds day by day from the date of enrollment.
It holds 3 months of recent account activity. <%} %> <br></br>

<span style="color: #2cb6e9"><%String keyQuestion3=(String)session.getAttribute("keyQuestion3");if(keyQuestion3!=null){out.println(keyQuestion3);}else {%>How can I confirm registration at
the bank?<%} %></span><br/>
<%String keyAnswer3=(String)session.getAttribute("keyAnswer3");if(keyAnswer3!=null){out.println(keyAnswer3);}else {%>Once the process of registration is complete, we generate a unique
Business Id to each customer.From then on, you can always approach an
account opener to view your profile.The profile also includes details of
account parties. <%} %> <br></br>


<span style="color: #2cb6e9"><%String keyQuestion4=(String)session.getAttribute("keyQuestion4");if(keyQuestion4!=null){out.println(keyQuestion4);}else {%>Why is a constraint laid on the age
of an account party?<%} %></span><br/>
<%String keyAnswer4=(String)session.getAttribute("keyAnswer4");if(keyAnswer4!=null){out.println(keyAnswer4);}else {%>This constraint is not confined to the bank, but, a policy of the Bank
Proceedings Authorization Committee,UK. <%} %> <br></br>



<span style="color: #2cb6e9"><%String keyQuestion5=(String)session.getAttribute("keyQuestion5");if(keyQuestion5!=null){out.println(keyQuestion5);}else {%>How to add multiple products?<%} %></span><br/>
<%String keyAnswer5=(String)session.getAttribute("keyAnswer5");if(keyAnswer5!=null){out.println(keyAnswer5);}else {%>Click on group of products and upload XML file having the details of the products. <%} %> <br></br>




<span style="color: #2cb6e9"><%String keyQuestion6=(String)session.getAttribute("keyQuestion6");if(keyQuestion6!=null){out.println(keyQuestion6);}else {%>Does Business Customer have the privilege to change assigned Relationship Manager?<%} %></span><br/>
<%String keyAnswer6=(String)session.getAttribute("keyAnswer6");if(keyAnswer6!=null){out.println(keyAnswer6);}else {%>Yes,Business Customer can change the Relationship Manager depending on the branch. <%} %> <br></br>



<span style="color: #2cb6e9"><%String keyQuestion7=(String)session.getAttribute("keyQuestion7");if(keyQuestion7!=null){out.println(keyQuestion7);}else {%>Is it necessary to assign Relationship Manager during account creation phase?<%} %></span><br/>
<%String keyAnswer7=(String)session.getAttribute("keyAnswer7");if(keyAnswer7!=null){out.println(keyAnswer7);}else {%>No,it is not necessary to assign Relationship Manager during account creation phase. <%} %> <br></br>

<span style="color: #2cb6e9"><%String keyQuestion8=(String)session.getAttribute("keyQuestion8");if(keyQuestion8!=null){out.println(keyQuestion8);}else {%>What is the Turn Around Time for
processing key customer requests?<%} %></span><br/>
<%String keyAnswer8=(String)session.getAttribute("keyAnswer8");if(keyAnswer8!=null){out.println(keyAnswer8);}else {%>We always ensure the satisfaction of our customers.However, the Turn
Around Time depends on the request made. To know the same for specific
processes, <a href="#">click here</a>. <%} %> <br></br>





<%String keybottomline=(String)session.getAttribute("keybottomline");if(keybottomline!=null){out.println(keybottomline);}else {%>
For any other queries, feel free to mail us to <a href="#">queriesnbg@nbg.com</a>
or call us at any of our helplines. <%} %></p>


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

<!-- box end --> <!-- footer -->
 <div style="margin-top:15px" ></div>
  <jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>