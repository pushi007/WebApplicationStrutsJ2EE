<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>


<%@page import="java.util.ArrayList"%>
<%@page import="javax.xml.datatype.XMLGregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="org.example.productdetails.Productdetails"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload Page</title>


</head>
<body bgcolor="aliceblue">



<center>
<div id="div4" style="color: red; text-align: center"></div>

  <table bgcolor="aliceblue">
<tr>
<td></td></tr></table>  <table bgcolor="aliceblue">
<tr>
<td></td></tr></table>  <table bgcolor="aliceblue">
<tr>
<td></td></tr></table>  <table bgcolor="aliceblue">
<tr>
<td></td></tr></table>
  <table bgcolor="aliceblue">
<tr>
<td></td></tr></table>
 
    <center><h3><b><font color="black" size=5px>Upload Call Details</font></b></h3></center>
      <table bgcolor="aliceblue">
<tr>
<td></td></tr></table>  <table bgcolor="aliceblue">
<tr>
<td></td></tr></table>  <table bgcolor="aliceblue">
<tr>
<td></td></tr></table>  <table bgcolor="aliceblue">
<tr>
<td></td></tr></table>  <table bgcolor="aliceblue">
<tr>
<td></td></tr></table>  <table bgcolor="aliceblue">
<tr>
<td></td></tr></table>
   <%
   	String status = (String)request.getAttribute("status");
      boolean flag=false;
      boolean flagInner=true;
       if(status!=null){
   %>
      <b><font color="red"><%=status%></font></b>
    <%
    	}
    %>
    
     
    <form action="/NBG/FileUploadServlet" method="post" enctype="multipart/form-data">
    
    <table align="center" bgcolor=#ededed border="solid thin black">
 
     <tr>
     <td><font color="black">Upload Xml : </font><input type="file" name="xml"></td>
     <td ><input type="submit" value="UPLOAD"></td>
     </table>   
    
    </form>
    
    <form action="<%=request.getContextPath()%>/FileController" method="post" >
<table id="table1" border="2" bgcolor=#ededed>
      
       
    <%
                 	List<Productdetails.Productdetail> list = (List<Productdetails.Productdetail>)session.getAttribute("list");
                     String cnt=(String)session.getAttribute("count");
                    if(cnt==null)
                     {
                     	request.getSession().setAttribute("count","2");
                     int i=1;
                     if(list!=null){
                 %>
    	<tr bgcolor="#218df2">
       	  <th align="center" ><font color="white"><b>Serial Number</b></font></th>
          <th  align="center" ><font color="white"><b>Product Id</b></font></th>
           <th  align="center" ><font color="white"><b>Product Name</b></font></th>
            <th align="center" ><font color="white"><b>product description</b></font></th>
             <th  align="center" ><font color="white"><b>account type</b></font></th>
             <th  align="center" ><font color="white"><b>product status</b></font></th>
             <th  align="center" ><font color="white"><b>valid From</b></font></th>
       </tr>
    	<%
    		for(Productdetails.Productdetail c:list){
    	%>
      <tr>
       	<td><font color="black"><%= i %></font></td>
         <td><font color="black"><%= c.getproductid() %></font></td>
         <td><font color="black"><%= c.getProductname() %></font></td>
         <td><font color="black"><%= c.getProductdescription() %></font></td>
         <td><font color="black"><%= c.getAccounttype()%></font></td>
         <td><font color="black"><%= c.getProductstatus() %></font></td>
         <td><font color="black"><%= c.getValidFrom() %></font></td>			
       </tr>    
    <%i++;} %><tr>
	<td colspan="7" align="center"><input type="submit" value="submit" onclick="return confirm('Are you sure you want to submit')"/></td>
    </tr>
    <% }}%>
    
        
    
    </table>
  <input type="hidden" name="action" <%if(flagInner){%>value="submitdetails"<%}else{%>value="nosubmitdetails"<%}%>/>
     	
     	<% if(list!=null){ %>
     	<div style="cursor:pointer">
       <div id="pageNavPosition">
				<script type="text/javascript">
	        	var pager = new Pager('table1',6); 
	        	pager.init(); 
	        	pager.showPageNav('pager','pageNavPosition'); 
	        	pager.showPage(1);
				</script>
			</div> 
	</div>
     <%} %>
    </form>
</center>
     

</body>
</html>