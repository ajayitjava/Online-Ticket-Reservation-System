<%@page import="com.tbs01.dao.AmountDao"%>
<%@page import="com.tbs01.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%User user = (User)session.getAttribute("user");%>
	
	<jsp:include page="sidebar.jsp"></jsp:include>
	
	<div id="main">

		<h1 style="color: blue;">Welcome To Online Ticket Booking System</h1>
		
		<% if(user!=null){
			//double bal = (double)session.getAttribute("bal");
			double bal = new AmountDao().getBalance(user.getId());
		%>
		
		<h2> Welcome User : <span style="color: red"> <%=user.getEmail() %> </span></h2>
		<h2> Your Wallet Balance is : <span style="color: blue"> <%=bal %> </span></h2>
		
		<%} %>

	</div>

</body>
</html>