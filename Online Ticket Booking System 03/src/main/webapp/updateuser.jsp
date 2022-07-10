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

<jsp:include page="sidebar.jsp"></jsp:include>

<div id="main">

		<%User u = (User)session.getAttribute("user"); %>

		<form action="UserServlet" method="post">
	
			<input type="hidden" name="action" value="updateuser"> 


			<table border="1" cellspacing="10">
				
				<tr>
					<td>Id</td>
					<td><input type="text" name="id" value="<%=u.getId() %>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="<%=u.getName() %>" required="required"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" value="<%=u.getEmail() %>" required="required"></td>
				</tr>
				<tr>
					<td>Contact</td>
					<td><input type="text" name="contact" value="<%=u.getContact() %>" required="required"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" value="<%=u.getAddress() %>" required="required"></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="number" name="age" value="<%=u.getAge() %>" required="required"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="passw1" value="<%=u.getPassword() %>" required="required"></td>
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