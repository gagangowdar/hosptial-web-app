<%@page import="com.ty.dto.Branch"%>
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

<br><br><br>

 <table border="2">
   <tr>
   <th>Id</th>
   <th>Name</th>
   <th>Phone</th>
   <th>Email</th>
     <th>create adress</th>
     <th>View adress</th>
   </tr>
   
       <%
       for(Branch branch:(List<Branch>)session.getAttribute("branches")) {
		%>
			
			<tr>
				<td><%=branch.getId()%></td>
				<td><%=branch.getName()%></td>
				<td><%=branch.getPhone()%></td>
				<td><%=branch.getEmail()%></td>
				<td><a href="create_adress.jsp?branchid=<%=branch.getId()%>">Create</a>
				<td><a href="displayadress?branchId=<%=branch.getId() %>">view_adress</a></td>
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