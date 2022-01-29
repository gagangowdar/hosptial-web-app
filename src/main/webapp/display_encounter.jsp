<%@page import="java.util.List"%>
<%@page import="com.ty.dto.Encounter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


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
<% String status =(String)session.getAttribute("status");
	if(status==null){
	%>

<%@ include file="person_navbar.jsp" %>
<% List<Encounter> encounters=(List<Encounter>)request.getAttribute("encounterList");%>
<br><br><br>

 <table border="2">
   <tr>
   <th>Id</th>
   <th>DateAndTime</th>
   <th>CreatorName</th>
   <th>Reason</th>
   <th>Branch_id</th>
     <th>Person_id</th>
     <th>create Order</th>
     <th>View Order</th>
   </tr>
   
       <%
       int branchId=(Integer)session.getAttribute("branchId");
       String personId=request.getParameter("personId");
		for(Encounter encounter:encounters) {
		%>
			
			<tr>
				<td><%=encounter.getId()%></td>
				<td><%=encounter.getDateTime()%></td>
				<td><%=encounter.getCreaterName()%></td>
				<td><%=encounter.getReason()%></td>
				<td><%=encounter.getBranch().getId()%></td>
				<td><%=encounter.getPerson().getId()%></td>
				<td><a href="create_orders.jsp?encounterId=<%=encounter.getId()%>">create</a>
				<td><a href="getallorders?encounterId=<%=encounter.getId() %>">view</a>
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