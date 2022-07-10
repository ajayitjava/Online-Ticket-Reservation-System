<%@page import="com.tbs01.pojo.Bus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%Bus bus = (Bus)session.getAttribute("bus"); %>

	<form action="BusServlet" method="post">
	
	<input type="hidden" name="action" value="updatebus"> 
	
		<table cellspacing="10" border="1">
			
			<tr>
				<td>Bus ID</td>
				<td><input type="number" value="<%=bus.getId() %>" name="id"></td>
			</tr>
			<tr>
				<td>Bus Number</td>
				<td><input type="text" value="<%=bus.getBus_number() %>" name="busno"></td>
			</tr>
			<!-- Bus Name Field -->
			<tr>
				<td>Source</td>
				<td><input type="text" value="<%=bus.getSource() %>" name="source"></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><input type="text" value="<%=bus.getDestination() %>" name="desti"></td>
			</tr>
			<tr>
				<td>Distance</td>
				<td><input type="text" value="<%=bus.getDistance() %>" name="dist"></td>
			</tr>
			<tr>
				<td>Fare</td>
				<td><input type="number" value="<%=bus.getFare()%>" name="fare"></td>
			</tr>
		</table>
	</form>
</body>
</html>