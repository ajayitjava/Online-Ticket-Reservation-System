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
	
		<h1 style="color: blue;">LogIn Form</h1>

		<%
		String lmsg = (String) request.getAttribute("lmsg");
		if (lmsg != null) {
		%>



		<h1 style="color: red"><%=lmsg%>
		</h1>

		<%
		}
		%>

		<form action="LoginServlet" method="post">



			<table border="1" cellspacing="10">

				<tr>
					<td>Email</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="passw"></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Login"></td>
					<td><a href ="adduser.jsp">Click Here For Register</a></td>
				</tr>


			</table>
		</form>

	</div>





</body>
</html>