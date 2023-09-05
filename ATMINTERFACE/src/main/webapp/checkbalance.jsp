<%@page import="Dto.BankAccount"%>
<%@page import="Dao.BankDao"%>
<%@page import="Dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Balance</title>
</head>
<body>

	<%UserDto customer1 =(UserDto)session.getAttribute("customer"); 
		if(customer1==null){
			response.getWriter().print("<h1>Session Expired Login Again</h1>");
			request.getRequestDispatcher("Login.html").include(request, response);
		}else{%>
	<%
		long acno =(Long) session.getAttribute("acno");
		BankDao bankDao = new BankDao();
		BankAccount account = bankDao.find(acno);
		UserDto userDto=account.getUserDto();
	%>

	<h1>Hello <%if(userDto.getGender().equals("male")) {%>Mr. <%}else{%>Ms. <%} %> <%=userDto.getName() %></h1>
	<h1>Your <%=account.getType() %> account balance is <%=account.getAmount() %></h1>
	<br><br>
	<a href="AccountHome.jsp"><button>Back</button></a>
	<%} %>
</body>
</html>