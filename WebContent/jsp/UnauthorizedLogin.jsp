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
<link href="<%=request.getContextPath() %>/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/layout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/calender.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/maxheight.js" type="text/javascript"></script>

	
	<script src="<%=request.getContextPath()%>/js/registration.js"
	type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/registerCoreDetailsValidation.js"
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
      <div class="container">
      	<!-- main-banner-small begin -->
         <div class="main-banner-small">
         	<div class="inner">
            	<h1>The bank for a changing world.</h1>
            </div>
         </div>
         <!-- main-banner-small end -->
         <div class="section">
         	<!-- box begin -->
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
                                          <h2>Unauthorized User</h2><hr></hr>
											<h3>Sorry. You are not authorized to access this module.</h3>
                                         <pre>
                                         
                                         
                                         
                                         
                                         </pre>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
   
            <!-- box end -->

<!-- footer -->
 <div style="margin-top:15px" ></div>
<jsp:include page="layout/footer.jsp"></jsp:include>

</body>
</html>






