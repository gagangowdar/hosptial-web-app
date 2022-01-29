<%@page import="com.ty.dto.Person"%>
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

<%  String status=(String)session.getAttribute("status");
if(status == null){ %>

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
    

<%

	List<Person> persons = (List<Person>)request.getAttribute("myPerson");
%>

<%@ include file="person_navbar.jsp" %>

<table border="3">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th>Gender</th>
		<th>Age</th>
		<th>Encounter</th>
		<th>View Encounter</th>
		

	</tr>
	
	<%
		for(Person person : persons) {
	%>
		
			<tr>
				<td><%=person.getId() %></td>
				<td><%=person.getName() %></td>
				<td><%=person.getEmail() %></td>
				<td><%=person.getPhone() %></td>
				<td><%=person.getGender() %></td>
				<td><%=person.getAge() %></td>
				<td>
					<a href="create_encounter.jsp?personid=<%=person.getId() %>">Create</a>
				</td>
				<td>
					<a href="displayencounter?personid=<%=person.getId() %>">View</a>
				</td>

			</tr>			
	<%
		}
	%>		
</table>

	<%} 
 else 
{ %>
<%@include file="login.jsp" %>
<%} %>
</body>
</html>