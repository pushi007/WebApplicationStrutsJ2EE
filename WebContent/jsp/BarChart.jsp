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
<% String month= (String)request.getAttribute("month");
String year= (String)request.getAttribute("year");
String ticketMonth=null;
if(month.equals("1"))
		ticketMonth="January";
else if(month.equals("2"))
	ticketMonth="February";
else if(month.equals("3"))
	ticketMonth="March";
else if(month.equals("4"))
	ticketMonth="April";
else if(month.equals("5"))
	ticketMonth="May";
else if(month.equals("6"))
	ticketMonth="June";
else if(month.equals("7"))
	ticketMonth="July";
else if(month.equals("8"))
	ticketMonth="August";
else if(month.equals("9"))
	ticketMonth="September";
else if(month.equals("10"))
	ticketMonth="October";
else if(month.equals("11"))
	ticketMonth="November";
else if(month.equals("12"))
	ticketMonth="December";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bar Chart</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"  />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/layout.css"  />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/maxheight.js" ></script>
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
											<p style="font-family: Arial, Verdana; font-size: 15px;"><b>Commercial Account Opening</b></p>
											<hr></hr>
											<br>
											<!--<h4><a href="#" onclick="return validateConfirm();"><b style="font-family: Arial; font-size: 12px;">Open Account</b></a></h4>-->
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
                                       <center><h2><font color=black size="5pt">Location wise report of Business Customer for
							<%=ticketMonth %> <%=year %></font></h2></center>
                                       <hr></hr>
                                       <img src="/NBG/ChartController?action=viewBar&&month=<%=month %>&&year=<%=year %>"  onerror="this.src = 'images/error.JPG'">
                                       <br/>
                                        <a href="<%=request.getContextPath()%>/jsp/viewChart.jsp">Back</a> 
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