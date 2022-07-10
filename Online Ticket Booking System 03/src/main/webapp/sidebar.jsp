<%@page import="com.tbs01.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Resources/CSS/app.css">
</head>
<body>

<!-- get "user" from LoginServlet setAttribute("user",u) -->
<%User user = (User)session.getAttribute("user"); %>

<div id="sidebar">

<h2><a href="index.jsp">Home</a></h2>

<%if(user!=null){ %>  <!-- if user value is not null then given items -->

<h2><a href="updateuser.jsp">EditProfile</a></h2>
<h2><a href="addamount.jsp">AddAmount</a></h2>

<h2><a href="BusServlet">BusDetailsList</a></h2>
<h2><a href="bookticket.jsp">BookTicket</a></h2>
<h2><a href="BookingServlet">BookTicketList</a></h2>
<h2><a href="AmountServlet">AmountList</a></h2>
<h2><a href="LoginServlet">Logout</a></h2>
<h2><a href="#">About-Us</a></h2>


<%} if(user==null){ %> <!-- If user value is null then show given items -->

<h2><a href="adduser.jsp">Register</a></h2>
<h2><a href="login.jsp">Login</a></h2>
<h2><a href="#">About-Us</a></h2>

<% }%>







</div>

</body>
</html>