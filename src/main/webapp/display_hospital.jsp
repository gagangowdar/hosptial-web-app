<%@page import="com.ty.dto.Hospital"%>
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

<%

	List<Hospital> hospitals = (List<Hospital>)request.getAttribute("myHospital");
%>

<%@ include file="admin_navbar.jsp" %>

<table border="3">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>GST</th>
		<th>WEBSITE</th>
		<th>ADD_BRANCH</th>
		<th>VIEW_BRANCH</th>
		

	</tr>
	
	<%
		for(Hospital hospital : hospitals) {
	%>
		
			<tr>
				<td><%=hospital.getId() %></td>
				<td><%=hospital.getName() %></td>
				<td><%=hospital.getGst() %></td>
				<td><%=hospital.getWebsite() %></td>
				<td>
					<a href="create_branch.jsp?hospitalid=<%=hospital.getId() %>">Create</a>
				</td>
				<td>
					<a href="getallbranches?hospitalId=<%=hospital.getId() %>">View</a>
				</td>

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