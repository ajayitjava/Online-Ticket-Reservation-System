<%@page import="com.tbs01.pojo.Amount"%>
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



<%
	
	User user = (User)session.getAttribute("user");
	Amount amt = (Amount)session.getAttribute("inc");
	%>
	
	
	 <jsp:include page="sidebar.jsp"></jsp:include>

	<div id="main">  
	
	<h1>Income Update Form</h1>

	<form action="IncomeServlet" method="post">
	
	<input type="hidden" name="id" value="<%=amt.getId()%>">
	
	<input type="hidden" name="action" value="updateIncome">

	<input type="hidden" name="userId" value="<%=user.getId()%>">

		<table border="1" cellspacing="10">

			<tr>
				<td>Income</td>
				<td><input type="number" name="income" value="<%=amt.getAmount()%>"></td>
			</tr>
			<tr>
				<td>IncomeType</td>
				<td><select name="incomeType">
						<option><%=amt.getAmount_type() %></option>
						<option>------Select-------</option>
						<option>Salary</option>
						<option>Collection</option>
						<option>Other</option>
				</select></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea rows="3" cols="20" name="description"><%=amt.getDescription() %></textarea>
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