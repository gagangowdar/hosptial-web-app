<%@page import="com.ty.dto.Adress"%>
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
<% String status =(String)session.getAttribute("status");
	if(status==null){
	%>

<style>
          body{
            background-color: rgb(227, 148, 111);
        }
        table,
        th,
        td {
            border-collapse: collapse;
        }

        th,
        td {
            padding: 15px;
        }
    </style>



<%@ include file="admin_navbar.jsp" %>

<table border="3">
	<tr>
		<th>ID</th>
		<th>Adress</th>
		<th>Pin</th>
		<th>State</th>
		

	</tr>
	
	<%
for(Adress adress:(List<Adress>)session.getAttribute("adresses"))
{
%>
		
			<tr>
				<td><%=adress.getId() %></td>
				<td><%=adress.getAdress()%></td>
				<td><%=adress.getPin()%></td>
				<td><%=adress.getState()%></td>

			</tr>			
	<%
		}
	%>		
</table>

<%}
	else
	{%>
	<%@include file="login.jsp"%>
	<%} %>
</body>
</html>