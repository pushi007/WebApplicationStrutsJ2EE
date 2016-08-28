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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.tvm.ilp.t154.cao.model.BusinessCustomer"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.tvm.ilp.t154.cao.bean.AccountcreationBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tvm.ilp.t154.cao.model.Branch"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Business Account Creation</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"  />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/layout.css"  />
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/maxheight.js"></script>
<script  type="text/javascript" src="<%=request.getContextPath() %>/js/javascript.js"></script>

<!--[if lt IE 7]>
	<link href="ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>

<body id="page5" onload="new ElementMaxHeight();">
   <!-- header -->
   <jsp:include page="../jsp/layout/header.jsp"></jsp:include>
   <!-- content -->
   <div id="content">
      <div class="container">
      	<!-- main-banner-small begin -->
         <div class="main-banner-small">
         	<div class="inner">
           <h1><%String  tagLinehl=(String)session.getAttribute("tagLinehl");if(tagLinehl!=null){out.println(tagLinehl);}else{ %>The bank for a changing world.<%} %></h1>
            </div>
         </div>
         <!-- main-banner-small end -->
         <div class="wrapper">
         	<div class="col-1 maxheight">
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
											<p style="font-family: Arial, Verdana; font-size: 15px;"><b><%String  keyCommercial=(String)session.getAttribute("keyCommercial");if(keyCommercial!=null){out.println(keyCommercial);}else{ %>Commercial Account Opening<%} %></b></p>
											<hr></hr>
											<br>
											<!--<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">Open Account</b></a></h4>-->
											<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;"><%String  keyMyPortal=(String)session.getAttribute("keyMyPortal");if(keyMyPortal!=null){out.println(keyMyPortal);}else{ %>My Portal<%} %></b></a></h4>
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
                                             <center><h2><%String keycreateh=(String)session.getAttribute("keycreateh");
if(keycreateh!=null){out.println(keycreateh);}else {%>Create Business Account<%} %></h2></center>
<%BusinessCustomer bc=(BusinessCustomer)request.getSession().getAttribute("bc");  %>
                                              
<table width="90%" style="align:center;font-family:Arial,Verdana;font-size:13px;color:#8A3E08">
 <tr>
 <td align="left"><b><%String keybusinessname=(String)session.getAttribute("keybusinessname");
if(keybusinessname!=null){out.println(keybusinessname);}else {%>Business Name <%} %>-<%=bc.getBusinessName()%></b></td>
 <td align="right"><b><%String keybrname=(String)session.getAttribute("keybrname");
if(keybrname!=null){out.println(keybrname);}else {%>Branch Name  <%} %>-<%=bc.getBranchName()%></b></td>
 </tr></table>
<hr></hr>
<%List<Branch> bList=(ArrayList<Branch>)request.getSession().getAttribute("branchList"); %>

<%
   Map<String, String> errors = (HashMap<String,String>)request.getAttribute("errors");
AccountcreationBean bean = (AccountcreationBean)request.getAttribute("bean");

%>



<form id="contacts-form3" name="account_creation" method="post" action="/NBG/AccountCreationServlet">
<input type="hidden" name="action" value="CreateAccountNext"></input>
<input type="hidden" name="businessType" value="<%=bc.getBusinessType()%>"></input>


<table align="center" cellspacing="10">



<tr>
<span align=right><%String keyfields=(String)session.getAttribute("keyfields");
if(keyfields!=null){out.println(keyfields);}else {%>Fields marked with<%} %> <span style="color:red;">*</span> <%String keymandatory=(String)session.getAttribute("keymandatory");
if(keymandatory!=null){out.println(keymandatory);}else {%>are mandatory&nbsp;&nbsp;&nbsp;<%} %></span>
</tr>

<tr> 
<td align="left"><b><%String keybusinessname1=(String)session.getAttribute("keybusinessname");
if(keybusinessname1!=null){out.println(keybusinessname1);}else {%>Business Name<%} %></b></td>
<td><label for="BusinessType"><%=bc.getBusinessName()%></label></td>
</tr>

<tr> 
<td align="left"><b><%String keytradingname=(String)session.getAttribute("keytradingname");
if(keytradingname!=null){out.println(keytradingname);}else {%>Trading Name<%} %></b></td>
<td><label for="Trading Name"><%=bc.getTradingName()%></label></td>
</tr>


<tr> 
<td align="left"><b><%String keybranch1=(String)session.getAttribute("keybrname");
if(keybranch1!=null){out.println(keybranch1);}else {%>Branch Name<%} %><sup style="color:red;">*</sup></b></td>
<td>&nbsp;<select name='branch' >
<option value="<%=bc.getBranchName()%>"><%=bc.getBranchName()%></option>
<%for(Branch b:bList){ %>
<option  value="<%=b.getBranchName()%>"><%=b.getBranchName()%></option>
<%} %>
</select>
</tr>

<tr> 
<td align="left"><b><%String keybtype=(String)session.getAttribute("keybtype");
if(keybtype!=null){out.println(keybtype);}else {%>Business Type<%} %></b></td>
<td><label for="Branch Name"><%=bc.getBusinessType()%></label></td>
</tr>
<tr> 
<td align="left"><b><%String keyacctype=(String)session.getAttribute("keyacctype");
if(keyacctype!=null){out.println(keyacctype);}else {%>Account Type<%} %><sup style="color:red;">*</sup> : </b></td>
<td>
<input type="radio" name="AccountType" value="Current Account" <% if(bean!=null && bean.getAccountType()!=null && bean.getAccountType().equalsIgnoreCase("Current Account")){out.println("checked");} %>/><%String keycacc=(String)session.getAttribute("keycacc");
if(keycacc!=null){out.println(keycacc);}else {%> Current Account<%} %><br>
<input type="radio" name="AccountType" value="Savings Account" <% if(bean!=null && bean.getAccountType()!=null && bean.getAccountType().equalsIgnoreCase("Saving Account")){out.println("checked");} %>/><%String keysacc=(String)session.getAttribute("keysacc");
if(keysacc!=null){out.println(keysacc);}else {%>Savings Account<%} %><br>
</td>
<td><font color='red'><% if(errors!=null && errors.get("AccountType")!=null && !errors.get("AccountType").equals("")){out.println(errors.get("AccountType"));} %></font></td>
</tr>
<tr></tr>
<tr><td colspan="2" align="right"><a href="#" class="button" onclick="document.getElementById('contacts-form3').submit()"><em><b><%String keycontinue=(String)session.getAttribute("keycontinue");
if(keycontinue!=null){out.println(keycontinue);}else {%>Continue<%} %></b></em></a></td><td></td>


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