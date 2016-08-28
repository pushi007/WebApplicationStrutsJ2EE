<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
	if (request.getSession() == null
			|| request.getSession().getAttribute("UID") == null) {
		response.sendRedirect(request.getContextPath()
				+ "/jsp/HomeLogin.jsp");
		return;
	}
%>
<%@ page import="java.awt.*"%>
<%@ page import="java.io.*"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="org.jfree.chart.labels.*"%>
<%@ page import="java.text.*"%>
<%@ page import="org.jfree.chart.plot.*"%>
<%@ page import="org.jfree.chart.entity.*"%>
<%@ page import="org.jfree.chart.renderer.category.*"%>
<%@ page import="org.jfree.data.general.*"%>
<%@ page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@ page import="org.jfree.chart.axis.NumberAxis"%>
<%@ page import="org.jfree.chart.axis.CategoryAxis"%>
<%@ page import="org.jfree.chart.axis.CategoryLabelPositions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bar Chart</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/layout.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/maxheight.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/javascript.js"></script>
<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>
<body id="page5" onload="new ElementMaxHeight();">
<!-- header -->
<jsp:include page="../jsp/layout/header.jsp"></jsp:include>
<!-- content -->
<div id="content">
<div class="container"><!-- main-banner-small begin -->
<div class="main-banner-small">
<div class="inner">
<h1>The bank for a changing world.</h1>
</div>
</div>
<!-- main-banner-small end -->
<div class="wrapper">
<div class="col-1 maxheight"><!-- box begin -->
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
<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Commercial
Account Opening</b></p>
<hr></hr>
<br>
<!--<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">Open Account</b></a></h4>-->
<h4><a href="/NBG/EmployeeManagementServlet?action=closeSession"><b
	style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
<h4><a href="/NBG/ChartController?action=generatePieCAONew"><b
	style="font-family: Arial; font-size: 12px;">Pie Chart</b></a></h4>
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
<div class="col-2 maxheight"><!-- box begin -->
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

<h2>Bar chart</h2><hr></hr>
<%String bname=(String)session.getAttribute("bname");
String chart=(String)session.getAttribute("chart");
String name=(String)session.getAttribute("name");
String month=null;
String year=null;

if("second".equalsIgnoreCase(chart))
{
	month=(String)session.getAttribute("month");
	session=request.getSession();
	session.setAttribute("bname",bname);
	session.setAttribute("month",month);
}
else if("third".equalsIgnoreCase(chart))
{
	month=(String)session.getAttribute("month");
	year=(String)session.getAttribute("year");
	session=request.getSession();
	session.setAttribute("bname",bname);
	session.setAttribute("month",month);
	session.setAttribute("year",year);
}
else
{
	session=request.getSession();
	session.setAttribute("bname",bname);
}

%>
<br></br>
<center>
<b style="font-family: Arial; font-size: 25px;">
<%
if(name!=null)
{
	out.println("For "+name);
}

%>
</b>

<br></br>
<IMG SRC="/NBG/ChartController?action=viewBarCAO" WIDTH="600"
	HEIGHT="400" BORDER="0" onerror="this.src='<%=request.getContextPath() %>/images/NoRecordFound.JPG'">
	
	<br></br>
	</center>
	<a href="/NBG/ChartController?action=viewChartEmp"><b>Back to Search</b></a>
	
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

<!-- footer -->
<div style="margin-top: 15px"></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>