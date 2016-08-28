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

<%@page import="com.tvm.ilp.t154.cao.model.NonPersonalCustomer"%><html>
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
<!--[if lt IE 7]>
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

<script>
function validateSrch()
{
	if(document.viewform.chart[0].checked==false && document.viewform.chart[1].checked==false && document.viewform.chart[2].checked==false)
	{
		document.getElementById("err_cri").innerHTML="Please select criteria";
		document.viewform.chart[0].focus();
		return false;
	}
	else if(document.viewform.chart[0].checked==true && document.viewform.bname.value=="unselected")
	{
		document.getElementById("err_cri").innerHTML="";
		document.getElementById("err_ft").innerHTML="Please select business name";
		document.viewform.chart[0].focus();
		return false;
	}
	else if(document.viewform.chart[1].checked==true)
	{
		/*if(document.viewform.bname2.value=="unselected")
		{
		document.getElementById("err_sd").innerHTML="Please select business name";
		document.viewform.chart[0].focus();
		return false;
		}
		else*/ if(document.viewform.month.value=="unselectedM")
		{
			document.getElementById("err_sd1").innerHTML="Please select year";
			document.viewform.chart[0].focus();
			return false;
		}
		else
		{
		document.getElementById("err_cri").innerHTML="";
		document.viewform.submit();
		return true;
		}
		
	}
	else if(document.viewform.chart[2].checked==true)
	{
		/*if(document.viewform.bname3.value=="unselected")
		{
		document.getElementById("err_td").innerHTML="Please select business name";
		document.viewform.chart[0].focus();
		return false;
		}
		else */if(document.viewform.monthY.value=="unselectedM")
		{
			document.getElementById("err_td2").innerHTML="Please select month";
			document.viewform.chart[0].focus();
			return false;
		}
		else if(document.viewform.year.value=="unselectedY")
		{
			document.getElementById("err_td3").innerHTML="Please select year";
			document.viewform.chart[0].focus();
			return false;
		}
		else
		{
		document.getElementById("err_cri").innerHTML="";
		document.viewform.submit();
		return true;
		}
	}
	else
	{
	document.getElementById("err_cri").innerHTML="";
	document.viewform.submit();
	return true;
	}
}

function removeErr()
{
	if(document.viewform.chart[0].checked==true || document.viewform.chart[1].checked==true || document.viewform.chart[2].checked==true)
	{
		document.getElementById("err_cri").innerHTML="";
	}
	if(document.viewform.chart[0].checked==true && document.viewform.bname.value!="unselected")
	{
		document.getElementById("err_ft").innerHTML="";
	}
	 if(document.viewform.chart[1].checked==true)
		{
		 document.getElementById("err_ft").innerHTML="";
			/*if(document.viewform.bname2.value!="unselected")
			{
			document.getElementById("err_sd").innerHTML="";
			
			}*/
		    if(document.viewform.month.value!="unselectedM")
			{
				document.getElementById("err_sd1").innerHTML="";
				
			}
		}
	 if(document.viewform.chart[2].checked==true)
		{
			/*if(document.viewform.bname3.value!="unselected")
			{
			document.getElementById("err_td").innerHTML="";
			
			}
			else*/ if(document.viewform.monthY.value!="unselectedM")
			{
				document.getElementById("err_td2").innerHTML="";
				
			}
			else if(document.viewform.year.value!="unselectedY")
			{
				document.getElementById("err_td3").innerHTML="";
				
			}
		}
		
}
</script>


<%List<NonPersonalCustomer> bnames=new ArrayList<NonPersonalCustomer>();
 bnames=(List<NonPersonalCustomer>)session.getAttribute("bnames");%>
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


<h4><a href="/NBG/EmployeeManagementServlet?action=closeSession"><b
	style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>



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


<%String type=(String)session.getAttribute("type");  
String msg=(String)request.getAttribute("msg");
%>
<%if(type!=null){ %>
<h2>Generate Report</h2><hr></hr>
<font style="color:black;size:15px;">Select one of the criteria below to generate report</font>
<br/><br/><%if(msg!=null){ %>
<font style="color:red;"><%=msg%></font>
<%} %>
<form method="post" name="viewform" action="/NBG/EmployeeManagementServlet">
<%}else{ %>
<h2>Generate Chart</h2><hr></hr>
<font style="color:black;size:15px;">Select one of the criteria below to generate Graph</font>
<form method="post" name="viewform" action="/NBG/ChartController">
<%} %>
<input type="hidden" name=action value="generatePieCAO" ></input>
<label class="label" id="err_cri"></label>
<br></br>

<table border=0 cellspacing=5 cellpadding=5>

<tr>
<td valign="top"><input type="radio" name="chart" value="first"></input></td>
<td>
<b>Business Name</b>&nbsp;&nbsp;&nbsp;&nbsp;<select name="bname" title="Please select Business Name" onmouseover="removeErr();">
	<option value="unselected">Select</option>
	<%for(NonPersonalCustomer businame:bnames) {%>
	<option value="<%=businame.getBusinessId()%>"><%=businame.getBusinessName()+"("+businame.getBusinessId()+")"%></option>
	<% }%>
</select>
<label class="label" id="err_ft"></label>
</td>
</tr>
<tr><td><br/><br/></td></tr>
<tr>
<td valign="top" ><input type="radio" name="chart" value="second"></input></td>
<!--<td>
<b>Business Name</b>&nbsp;&nbsp;&nbsp;&nbsp;<select name="bname2" title="Please select Business Name" onmouseover="removeErr();">
	<option value="unselected">Select</option>
	<%for(NonPersonalCustomer businame:bnames) {%>
	<option value="<%=businame.getBusinessId()%>"><%=businame.getBusinessName()+"("+businame.getBusinessId()+")"%></option>
	<% }%>
</select><label class="label" id="err_sd"></label>
</td>
</tr>
<tr>
<td></td>-->
<td>

<b>Year</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="month" title="Please select Business Name" onmouseover="removeErr();">
	<option value="unselectedM">Select</option>
	
	<option value="2002">2002</option>
	<option value="2003">2003</option>
	<option value="2004">2004</option>
	<option value="2005">2005</option>
	<option value="2006">2006</option>
	<option value="2007">2007</option>
	<option value="2008">2008</option>
	<option value="2009">2009</option>
	<option value="2010">2010</option>
	<option value="2011">2011</option>
	<option value="2012">2012</option>
	<option value="2013">2013</option>

</select><label class="label" id="err_sd1"></label>
</td></tr>

<tr><td><br/><br/></td></tr>
<tr><td valign="top"><input type="radio" name="chart" value="third"></input></td>
<td>
<!--<b>Business Name</b>&nbsp;&nbsp;&nbsp;&nbsp;<select name="bname3" title="Please select Business Name" onmouseover="removeErr();">
	<option value="unselected">Select</option>
	<%for(NonPersonalCustomer businame:bnames) {%>
	<option value="<%=businame.getBusinessId()%>"><%=businame.getBusinessName()+"("+businame.getBusinessId()+")"%></option>
	<% }%>
</select><label class="label" id="err_td"></label>
</td>
</tr>
<tr><td></td><td>-->

<b>Month</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="monthY" title="Please select Business Name" onmouseover="removeErr();">
	<option value="unselectedM">Select</option>
	
	<option value="01">Jan</option>
	<option value="02">Feb</option>
	<option value="03">Mar</option>
	<option value="04">Apr</option>
	<option value="05">May</option>
	<option value="06">Jun</option>
	<option value="07">July</option>
	<option value="08">Aug</option>
	<option value="09">Sep</option>
	<option value="10">Oct</option>
	<option value="11">Nov</option>
	<option value="12">Dec</option>

</select><label class="label" id="err_td2"></label>
</td></tr>
<tr><td></td><td>

<b>Year</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="year" title="Please select Business Name" onmouseover="removeErr();">
	<option value="unselectedY">Select</option>
	
	<option value="2002">2002</option>
	<option value="2003">2003</option>
	<option value="2004">2004</option>
	<option value="2005">2005</option>
	<option value="2006">2006</option>
	<option value="2007">2007</option>
	<option value="2008">2008</option>
	<option value="2009">2009</option>
	<option value="2010">2010</option>
	<option value="2011">2011</option>
	<option value="2012">2012</option>
	<option value="2013">2013</option>

</select><label class="label" id="err_td3"></label>
</td>

</tr>



</table>
<br></br>
<br></br>
<table width=20%>

	<tr>
		
		<% if(type!=null){%>	
			<td colspan="2" style="width: 40%; align: center; padding: 5px"><a
			onclick="return validateSrch();" onmouseover="removeErr();"
			class="button" tabindex=18><em><b>&nbsp;&nbsp;Show Report&nbsp;&nbsp;</b></em></a>
			
			</td>
			<%} else{ %><td colspan="2" style="width: 40%; align: center; padding: 5px"><a
			onclick="return validateSrch();" onmouseover="removeErr();"
			class="button" tabindex=18><em><b>&nbsp;&nbsp;Show Chart&nbsp;&nbsp;</b></em></a></td>
			<%} %>
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