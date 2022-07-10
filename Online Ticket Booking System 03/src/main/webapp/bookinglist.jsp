<%@page import="com.tbs01.pojo.Ticket"%>
<%@page import="com.tbs01.pojo.Bus"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

#rside{
	width : 220px;
	height : 100%;
	background: aqua;
	padding : 10px;
	margin : 10px;
	position : fixed;
	top : 0%;
	right : 0%;
}

</style>
</head>
<body>

	<%
	List<Ticket> inclist = (List<Ticket>) session.getAttribute("tick");
	int count = 1;
	%>

	 <jsp:include page="sidebar.jsp"></jsp:include>

<div id="main"> 

	<br>
	
	<!-- <form action="BusServlet?action=srch" method="post"> -->
		<form action="BookingServlet" method="post">
	
	<textarea rows="3" cols="70" name="search"></textarea>
	<input type="submit" value="Search">
	
	</form>
	
	<br> 
	<table border="1" cellspacing="10">

		<tr>
			<th>SR NO</th>
			<th>ID</th>
			<th>BUS NUMBER</th>
			<th>SOURCE</th>
			<th>DESTINATION</th>
			<th>DISTANCE</th>
			<th>FARE</th>

		 	<th colspan="2">ACTION</th> 

		</tr>

		<%
		for (Ticket i : inclist) {
		%>
		<tr>
		
			<td><%=count++ %></td>
			<td><%=i.getUserid() %></td>
			<td><%=i.getBusid() %></td>
			<td><%=i.getBookingdate()%></td>
			<td><%=i.getFare() %></td>
			
		  
			
			
			<td><a href="BusServlet?action=delete&id=<%=i.getId()%>">Delete</a></td>  
		  	<td><a href="BusServlet?action=edit&id=<%=i.getId()%>">Edit</a></td>  
			
		</tr>
		<%
		}
		%>
	</table>
	</div>
	
	
	
	<div id="rside">
	
	<h2> Sort By Income Type </h2>
	
	<ol>
	
	<li><h4><a href="BusServlet">All</a></h4></li>
	<li><h4><a href="BusServlet?action=searchByIncType&type=creditcard">CreditCard</a></h4></li>
	<li><h4><a href="BusServlet?action=searchByIncType&type=debitcard">DebitCard</a></h4></li>
	<li><h4><a href="BusServlet?action=searchByIncType&type=other">Other</a></h4></li>
	
	</ol>
	
	</div>

</body>
</html>