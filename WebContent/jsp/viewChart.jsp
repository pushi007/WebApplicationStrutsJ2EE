<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description"
	content="Consulting page - free business website template from Template Monster is awating for you to download." />

<link href="<%=request.getContextPath() %>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css"
	rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath() %>/js/maxheight.js"
	type="text/javascript"></script>
<script src="../js/registration1.js" type="text/javascript"></script>
<script language="javascript">
function validateChart(){
	var sel=document.report.month.selectedIndex;
	var sel1=document.report.year.selectedIndex;
	if((sel=="")){
		document.getElementById("err_message").innerHTML="Please select the Month";
		return false;
	}
	else if(sel1=="")
	{
		document.getElementById("err_message1").innerHTML="Please select the Year";
		return false;
	} 
	else if(document.report.choice[0].checked==false && document.report.choice[1].checked==false && document.report.choice[2].checked==false ){
		alert("Please select radio button for Generating Report");	
		return false;		
	}
	else{
		document.report.submit();
		return true;
	}	
}
</script>
<!--[if lt IE 7]>
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->
<%List<String> bnames=new ArrayList<String>();
                                      bnames=(List<String>)request.getAttribute("bnames");%>
</head>

<body id="page5" onload="new ElementMaxHeight();">
<!-- header -->
<jsp:include page="layout/header.jsp"></jsp:include>
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


<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Chart</b></p>
<hr />
<!-- <h4><a href="/NBG/ChartController?action=viewPieCAO"><b style="font-family: Arial; font-size: 12px;">View Chart</b></a></h4> -->
<h4><a href="/NBG/AccountCreationServlet?action=closeSession"><b style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>



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
	<center><h2>Graphical Report</h2></center>
	<hr/>
	<h4 style="color:#8A3E08"> 
	Click on respective link to view location wise percentage of customers:-</h4>
	
	<form id="contacts-form2" name="report"  action="/NBG/ChartController" method="post">
	<input type="hidden" name="action" value="chart"/>
	<span style="align: right">Fields marked with<span
	style="color: red;">*</span> are mandatory &nbsp;&nbsp;&nbsp;</span>
	<table width="90%" style="align:center;font-family:Arial,Verdana;font-size:13px;" cellspacing="10" cellpadding="10">
	<tr>
<td align="left">Month <sup><b><font color="red">*</font></b></sup></td>
<td align="left"><select name="month" id="month" style="width:150px">
<option value="">
Select month

</option>
<option value="1">
January
</option>
<option value="2">
February
</option>
<option value="3">
March
</option>
<option value="4">
April
</option>
<option value="5">
May
</option>
<option value="6">
June
</option>
<option value="7">
July
</option>
<option value="8">
August
</option>
<option value="9">
September
</option>
<option value="10">
October
</option>
<option value="11">
November
</option>
<option value="12">
December
</option>
</select></td>
<td><label id="err_message" style="color:red;"></label></td>
</tr>

<tr>
<td align="left">
Year<sup><b><font color="red">*</font></b></sup>
</td>
<td align="left">
<select name="year" id="year"  style="width:150px">
<option value="">
Select year
</option>
<option value="2012">
2012
</option>
<option value="2013">
2013
</option>

</select>
</td>
<td><label id="err_message1" style="color:red;"></label></td>
</tr>


<tr>
<td align="left">
 Type of Report <sup><b><font color="red">*</font></b></sup>
</td>
<td align="left">
<input type="radio" name="choice" value="pie" id="pie">Pie Chart</input>
<input type="radio" name="choice" value="bar" id="bar">Bar Chart</input>
<input type="radio" name="choice" value="pdf" id="pdf">PDF Report</input>
</td>
</tr>
<tr></tr>
<tr><td  align="center" colspan="2"><a class="button" onclick="return  validateChart();"><em><b>Generate</b></em></a></td>
<td></td>
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
</div>
</div>
</div>
<!-- footer -->

<div style="margin-top: 15px"></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>