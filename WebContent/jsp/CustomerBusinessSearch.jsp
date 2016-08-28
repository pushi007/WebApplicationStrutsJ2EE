<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="com.tvm.ilp.t154.cao.model.*"%>

<%@ page import="static com.tvm.ilp.t154.cao.constants.CAOConstants.*" %>
<%@ page import="java.util.*" %>
<html>
<head>
<title>Nexus Banking Group</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />


<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath()%>/js/maxheight.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/AccountPartyScript.js" type="text/javascript"></script>

<!--[if lt IE 7]>
	<link href="../css/ie_style.css" rel="stylesheet" type="text/css" />
<![endif]-->

</head>

<body id="page5" onload="new ElementMaxHeight();">

   <!-- header -->
   <jsp:include page="layout/header.jsp"></jsp:include>
   <!-- content -->
   <div id="content">
      <div class="container">
      	<!-- main-banner-small begin -->
         <div class="main-banner-small">
         	<div class="inner">
            	<h1>The bank for a changing world.</h1>
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
<ul>
<li><b style="font-family:Arial,Verdana;font-size:16px;color:#000">Registration</b><br/><br/></li>
</ul>

<ul>
    <li style="font-family:Arial,Verdana;font-size:14px;color:#000"><a href="/NBG/AccountPartyManagementServlet?ACTION=REGISTER" >Account Parties</a></li>
 </ul>
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
                                               <h3  style="align:center;font-family:Arial,Verdana;font-size:16px;color:#000">Account Party Registration</h3>
<hr></hr>
<form name="Get_AP_Business" action="/NBG/AccountPartyManagementServlet">
<input type="hidden" name=ACTION value="Business_Id_Name"></input>
<!--<%List<Branch> branch=new ArrayList<Branch>();
branch=(List<Branch>)request.getAttribute("branchList");%>
--><table cellpadding=10 cellspacing=10 style="position:relative;top:-35px;">
<tr>
<td align="left" width=50%><b>Business ID</b></td>
<td width=50%><input type="text" name="businessId" title="Please Enter business ID" onclick="return(validate_Acc_Id())"/></td>
</tr>
<tr><td></td></tr>
<tr>
<td align="center"><b>  OR<span style="align:right;"></span></b></td>
<br><br>
</tr>
<tr><td></td></tr>
<tr>
<td align="left"><b>Business Name</b></td>
<td><input type="text" name="businessName" title="Please Enter business name" onclick="return(validate_Acc_Name_Branch())"/></td>
</tr>

<tr>
<td align="left"><b>Branch</b></td>
<td width=50%><input type="text" name="businessBranch" title="Please Enter business ID" onclick="return(validate_Acc_Id())"/></td>

<tr></tr>
<tr></tr>
<tr>
<td colspan="1" width=50% style="align:center;padding:10px"><a href="#" class="button" onclick="document.Get_AP_Business.submit();"><em><b>Search</b></em></a></td>

<td colspan="1" width=50% style="align:center;padding:10px"><a href="#" class="button" onclick="document.Get_AP_Business.reset();"><em><b>Reset</b></em></a></td>
</tr>
</table>
</form>

</div>
</div></div></div></div></div></div></div></div></div></div></div></div></div>
<!-- footer -->
   <jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>