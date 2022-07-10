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

	<form action="AmountServlet" method="post">
	
	<input type="hidden" name="action" value="addIncome">

	<input type="hidden" name="userId" value="<%=user.getId()%>">

		<table border="1" cellspacing="10">

			<tr>
				<td>Amount</td>
				<td><input type="number" name="income"></td>
			</tr>
			<tr>
				<td>AmountType</td>
				<td><select name="amountType">
						<option>------Select-------</option>
						<option>CreditCard</option>
						<option>DebitCard</option>
						<option>Other</option>
				</select></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea rows="3" cols="20" name="description"></textarea>
				</td>
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