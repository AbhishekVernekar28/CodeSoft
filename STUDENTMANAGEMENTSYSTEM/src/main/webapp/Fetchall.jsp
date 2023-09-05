<%@page import="dto.Studentdto"%>
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
	<%List<Studentdto> list = (List<Studentdto>) request.getAttribute("list");%>

	<table border="1">
		<tr>
			<th>RollNumber</th>
			<th>Name</th>
			<th>Grade</th>
		</tr>

		<%for (Studentdto studentdto : list){ %>
		<tr>
			<th><%=studentdto.getRollnumber()%></th>
			<th><%=studentdto.getName()%></th>
			<th><%=studentdto.getGrade()%></th>
		</tr>
		<%}%>
	</table>
</body>
</html>