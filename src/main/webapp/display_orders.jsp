<%@page import="com.ty.dto.Orders"%>
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
<% List<Orders> orders=(List<Orders>)request.getAttribute("orderList");%>
<br><br><br>

 <table border="2">
   <tr>
   <th>Id</th>
   <th>Creator Name</th>
   <th>DateTime</th>
   <th>Message</th>
   <th>Encounter_Id</th>
   <th>Create_Item</th>
   <th>View_Item</th>
   </tr>   
       <%
       for(Orders order:(List<Orders>)session.getAttribute("orders")){
		%>
			
			<tr>
				<td><%=order.getId()%></td>
				<td><%=order.getCreaterName()%></td>
				<td><%=order.getDateTime()%></td>
				<td><%=order.getMessage()%></td>
				<td><%=request.getParameter("encounterId") %></td>
				<td><a href="create_item.jsp?orderId=<%=order.getId() %>">create</a></td>
				<td><a href="getallItems?orderId=<%=order.getId() %>">view</a></td>
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