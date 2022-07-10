<%@page import="com.tbs01.pojo.Amount"%>
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
	List<Amount> inclist = (List<Amount>) session.getAttribute("inclist");
	int count = 1;
	%>

	 <jsp:include page="sidebar.jsp"></jsp:include>

<div id="main"> 

	<br>
	
	<form action="AmountServlet?action=srch" method="post">
	
	<textarea rows="3" cols="70" name="search"></textarea>
	<input type="submit" value="Search">
	
	</form>
	
	<br> 
	<table border="1" cellspacing="10">

		<tr>
			<th>ID</th>
			<th>AMOUNT</th>
			<th>AMOUNT TYPE</th>
			<th>AMOUNT DATE</th>
			<th>DESCRIPTION</th>
			<th>USER ID</th>

		 	<th colspan="2">ACTION</th> 

		</tr>

		<%
		for (Amount i : inclist) {
		%>
		<tr>
			<td><%=count++%></td>
			<td><%=i.getAmount()%></td>
			<td><%=i.getAmount_type()%></td>
			<td><%=i.getAmount_date()%></td>
			<td><%=i.getDescription()%></td>
			<td><%=i.getUser_id()%></td>
			<td><a href="AmountServlet?action=delete&id=<%=i.getId()%>">Delete</a></td>  
		  	<td><a href="AmountServlet?action=edit&id=<%=i.getId()%>">Edit</a></td>  
			
		</tr>
		<%
		}
		%>
	</table>
	</div>
	
	
	
	<div id="rside">
	
	<h2> Sort By Income Type </h2>
	
	<ol>
	
	<li><h4><a href="AmountServlet">All</a></h4></li>
	<li><h4><a href="AmountServlet?action=searchByIncType&type=creditcard">CreditCard</a></h4></li>
	<li><h4><a href="AmountServlet?action=searchByIncType&type=debitcard">DebitCard</a></h4></li>
	<li><h4><a href="AmountServlet?action=searchByIncType&type=other">Other</a></h4></li>
	
	</ol>
	
	</div>

</body>
</html>