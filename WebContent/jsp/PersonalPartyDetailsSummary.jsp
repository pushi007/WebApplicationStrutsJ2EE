<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="com.tvm.ilp.t154.cao.model.*"%>

<%@ page import="static com.tvm.ilp.t154.cao.constants.CAOConstants.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description"
	content="Consulting page - free business website template from Template Monster is awating for you to download." />

<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/SelectedPartyAction.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/maxheight.js"
	type="text/javascript"></script>
	<script src="<%=request.getContextPath() %>/js/AccountPartyCoreDetailsValidation.js"
	type="text/javascript"></script>


<style type="text/css" title="currentStyle">
			@import "<%=request.getContextPath() %>/css/demo_page.css";
			@import "<%=request.getContextPath() %>/css/jquery.dataTables_themeroller.css";
			@import "<%=request.getContextPath() %>/css/jquery-ui-1.8.4.custom.css";
			
	</style>
<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
<script>$(document).ready(function(){

	var oTable	= $('#st').dataTable( {	"sScrollX": "100%",
		"aaSorting": [[ 1, "asc" ]],
		"bJQueryUI": true,
		"sPaginationType": "full_numbers",
		"bAutoWidth": false,
		"autoHeight": true,
		"bStateSave": false,
		"aoColumns": [ null, null,null,null,null,null,null]  			
	} );

});
	</script>
<!--[if lt IE 7]>
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>

<body id="page5" onload="new ElementMaxHeight();">

<!-- header -->
<jsp:include page="./layout/header.jsp"></jsp:include>
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
<a href="/NBG/CustomerManagementServlet?action=find" style="font-size-adjust: inherit"><span style="font-size:12px">Find Business</span></a>
<br /><br />
<a href="./jsp/NonPersonalRegistraionSummary.jsp" style="font-size-adjust: inherit"><span style="font-size:12px">Business Summary</span></a>
<br /><br />
<a href="/NBG/AccountPartyManagementServlet?action=Display_Business_Cust_Detail" style="font-size-adjust: inherit"><span style="font-size:12px">Account Parties</span></a>

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
<!-- box end -->
</div>
<div class="col-2 maxheight">
<!-- box begin -->
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
<h3
	style="align: center; font-family: Arial, Verdana; font-size: 16px; color: #000">Business
Account Parties Summary</h3>

<% ArrayList<PersonalParty> ppList=(ArrayList<PersonalParty>)request.getAttribute("acc_Party_List"); %>

<form name="Acc_Party_Details_Summary" action="/NBG/AccountPartyManagementServlet">
<input type="hidden" name=action value="Acc_Party_Selected_Operation"></input>
<input type="hidden" name="selectedPartyAction"></input>
<% String msg=(String)request.getAttribute("msg");%>
<input type="hidden" name="partySelected" value="No"></input>

<% String BusinessName=(String)request.getAttribute("BusinessName"); %>
<% String BusinessBranch=(String)request.getAttribute("BusinessBranch"); %>
<table width="90%"
	style="align: center; font-family: Arial, Verdana; font-size: 13px; color: #8A3E08">
	<tr>
		<td align="left"><b>Business Name - <%=BusinessName %></b></td>
		<td align="right"><b>Branch Name - <%=BusinessBranch %></b></td>
	</tr>
</table>
<hr></hr>
<b><label id="err_msg" style="color: red;"></label></b>
<%if(msg!=null) {%>
<b><label style="color: green;"><%=msg %></label></b>
<%} %>
<br></br>

<%if(ppList.size()>0){ %>
<%! int partyId; %> 
<table id="st" align="center" border="2px solid black">
<thead>
	<tr>
		<td>Select</td>
		<td>Name</td>
		<td>Relationship with Business</td>
		<td>Is Key Party</td>
		<td>Is Existing Customer</td>
		<td>Account Number</td>
		<td>Date of Birth(in yyyy/mm/dd)</td>
	</tr>
	</thead>
	<tbody>
	<%for(PersonalParty p:ppList){ %>
	<tr>
		<%String partyId=((Long)p.getPartyId()).toString(); %>
		<td><input type="radio" name="selectParty" value=<%=partyId%> id="selectParty"></input></td>
		<td><%=p.getTitle()+" "+p.getFirstName()+" "+p.getSurName() %></td>
		<td><%=p.getRelationshipType() %></td>
		<td><%=p.getKeyParty()%></td>
		<td><%=p.getIsExistingCustomer() %></td>
		<td><%if(p.getAccountNumber()>0){%>
			<%=p.getAccountNumber()%>
			<%}else{%>
			 NA
			<%} %>
		</td>
		<td><%=p.getDateOfBirth() %></td>
	</tr>
	<%} %>
	</tbody>
</table>
<br></br>
<table align="center" width=80%>
	<tr>
		<td width=15% style="align: left; padding: 10px"><a type="submit" class="button" onclick="return selectOperationView();" ><em><b>View</b></em></a></td>
		<td width=15% style="align: left; padding: 10px"><a type="submit" class="button" onclick="return selectOperationUpdate();"><em><b>Update</b></em></a></td>
		<td width=15% style="align: left; padding: 10px"><a type="submit" class="button" onclick="return selectOperationDelete();"><em><b>Delete</b></em></a></td>
		<td width=15%></td>
		<td width=40% style="align: right; padding: 10px"><a href="/NBG/AccountPartyManagementServlet?action=Add_Account_Party"
			class="button"><em><b>Add Account Party</b></em></a></td>
	</tr>
</table>
<%}else{ %>
<center>
<b>No account party added</b>
<br></br>
<table width="30%"><tr><td>
<a href="/NBG/AccountPartyManagementServlet?action=Add_Account_Party" class="button"><em><b>Add Account Party</b></em></a>
<%} %>
</td></tr></table></center>
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
<div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>