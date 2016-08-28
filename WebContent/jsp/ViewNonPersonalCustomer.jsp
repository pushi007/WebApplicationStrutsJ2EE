<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tvm.ilp.t154.cao.model.NonPersonalCustomer" %>
    <%@page import="com.tvm.ilp.t154.cao.model.Branch" %>
    <%@page import="java.util.List" %>
    <%@page import="java.util.ArrayList" %>
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


<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css" rel="stylesheet" type="text/css" />
<style type="text/css" title="currentStyle">
			@import "<%=request.getContextPath() %>/css/demo_page.css";
			@import "<%=request.getContextPath() %>/css/jquery.dataTables_themeroller.css";
			@import "<%=request.getContextPath() %>/css/jquery-ui-1.8.4.custom.css";
			
	</style>
<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
<script>$(document).ready(function(){

	var oTable	= $('#npt').dataTable( {
		"sScrollX": "100%",
		"aaSorting": [[ 1, "asc" ]],
		"bJQueryUI": true,
		"sPaginationType": "full_numbers",
		"bAutoWidth": false,
		"autoHeight": true,
		"bStateSave": false,
		"aoColumns": [ null,null, null,null]  			
	} );

});
	</script>
<script src="<%=request.getContextPath() %>/js/maxheight.js" type="text/javascript"></script>

<%List<Branch> branchList=(List<Branch>)session.getAttribute("branchList");
List<NonPersonalCustomer> npList=(List<NonPersonalCustomer>)request.getAttribute("npList");
%>
<!--[if lt IE 7]>
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->


</head>
<body id="page5" onload="new ElementMaxHeight();">
<!-- header -->
<jsp:include page="layout/header.jsp" />
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


<a href="/NBG/CustomerManagementServlet?action=accopenerportal" style="font-size-adjust: inherit"><span style="font-size:12px">My Portal</span></a>
<br /><br />
<a href="/NBG/CustomerManagementServlet?action=find" style="font-size-adjust: inherit"><span style="font-size:12px">Find
Business</span></a>
</div>

<input type="hidden" /></div>
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

 <h2>Business Customer Details</h2>
<table  id="npt" width=90% border=1>
<thead>
<tr style="background-color:#2cb6e9;height:30px;">
<th>Business Id</th>
<th>Business Name</th>
<th>Trading Name</th>
<th>Branch</th>
</tr>
</thead>
<tbody>
<%
for(NonPersonalCustomer npCustomer:npList){%>
	<tr>
	<td align="center"><a href="/NBG/CustomerManagementServlet?action=viewdetails&&id=<%=npCustomer.getBusinessId() %>"><%=npCustomer.getBusinessId()%></a></td>
	<td align="center"><%=npCustomer.getBusinessName()%></td>
	<td align="center"><%=npCustomer.getTradingName()%></td>
	<%for(Branch branch:branchList){if(branch.getBranchId().equalsIgnoreCase(npCustomer.getBranch().getBranchId())) {npCustomer.getBranch().setBranchName(branch.getBranchName());%>
	
	<td align="center"><%=branch.getBranchName()%></td>
	<%} }%>
	</tr>
	
<% }
%>
</tbody>
</table>

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
</div>

<!-- footer -->
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>