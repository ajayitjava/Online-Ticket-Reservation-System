<%@page import="com.tbs01.dao.UserDao"%>
<%@page import="com.tbs01.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	List<User> ulist = new UserDao().getUserList();
	User user = (User)session.getAttribute("user");
	%>
	
	
	 <jsp:include page="sidebar.jsp"></jsp:include>

	<div id="main">  

	<form action="BookingServlet" method="post">
	
	<input type="hidden" name="action" value="addIncome">

	<input type="hidden" name="userId" value="<%=user.getId()%>">

		<table border="1" cellspacing="10">

			<tr>
				<td>Bus ID</td>
				<td><input type="number" name="busid"></td>
			</tr>
			<tr>
				<td>Source</td>
				<td><input type="text" name="source"></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><input type="text" name="destination"></td>
			</tr>
			<tr>
				<td>Fare</td>
				<td><input type="number" name="fare"></td>
			</tr>
			<tr>
				<td>Pay Amount</td>
				<td><input type="number" name="pay"></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text"  value="<%=user.getEmail()%>"></td>
			</tr>


			<tr>
				<td><input type="submit" value="Save"></td>
				<td><input type="Reset" value="Reset"></td>
			</tr>

		</table>
	</form>
	</div>

</body>
</html>