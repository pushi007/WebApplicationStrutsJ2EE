<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<%@page import="java.util.*"%>
<%@page import="com.tvm.ilp.t154.cao.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Relationship Manager</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/maxheight.js"
	type="text/javascript"></script>
	<script  type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js"></script>
<script language="javascript">

function validateProduct(){
	var sel=document.account_creation.listOfManager.selectedIndex;
	if((sel==0)){
		document.getElementById("err_message").innerHTML="Please select the Relationship Manager";
		return false;
	}
	else{
		document.account_creation.submit();
		return true;
	}	
}
</script>
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
											<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Commercial Account Opening</b></p>
											<hr></hr>
											<br>
											<!--<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">Open Account</b></a></h4>-->
											<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">My Portal</b></a></h4>
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
<center>
<h2>Assign Relationship Manager</h2>
</center>
<%Branch b=new Branch();%> <% String branchName=(String)request.getAttribute("bname"); %>
<%b.setBranchName(branchName);%> 
<% ArrayList<RelationshipManager>rmList=(ArrayList<RelationshipManager>)request.getAttribute("rmList");%>
<% int npid=(Integer)request.getAttribute("npid");%> 
<hr></hr>
<form id="contacts-form1" name="account_creation"
	action="/NBG/AssignRelationshipManagerServlet">
<input type="hidden" name="action" value="complete">
 <input type="hidden" name="nonpersonalid" value="<%=npid%>">
  <input type="hidden" name="branchName" value="<%=b.getBranchName()%>">
<table align="center">

	<tr>
		<td style="padding: 15px;"><b> Customer Id</b></td>
		<td style="padding:15px;"><label  for="nonpersonalid"><%=npid%></label></td> 
	</tr>
	<tr>
		<td style="padding: 15px;"><b>BranchName</b></td>
		<td style="padding:15px;"><label  for="branchName"><%=b.getBranchName()%></label></td> 
	</tr>
	<tr>
		<td><b>List of Relationship Managers from <%=b.getBranchName()%><sup style="color:red">*</sup></b></td>
		<td style="padding: 15px;"><select name="listOfManager">
			<option value="select">---------SELECT----------</option>
			<%for(RelationshipManager rm:rmList){ %>
			<option value="<%=rm.getRmId()%>"><%=rm.getTitle()%> <%=rm.getFirstName()%>
			<%=rm.getLastName()%></option>
			<%} %>
		</select></td>
		<td><label id="err_message" style="color: red;"></label></td>
	</tr>


	<tr>
		
		<td colspan="1" style="padding: 10px;" align="center"><a href="#"
			class="button" onclick="return  validateProduct();"><em><b>&nbsp;&nbsp;&nbsp;Continue</b></em></a></td>




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
			<!-- box end -->
            </div>
         </div>
      </div>
   <!-- footer -->
	<jsp:include page="../jsp/layout/footer.jsp"></jsp:include>

</body>
</html>
