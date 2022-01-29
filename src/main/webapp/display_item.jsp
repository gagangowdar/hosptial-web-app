<%@page import="com.ty.dto.Items"%>
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

<%@ include file="person_navbar.jsp" %>
<%  String status=(String)session.getAttribute("status");
if(status == null){ %>
<table border="2">
<tr>
<th>ID</th>
<th>NAME</th>
<th>QUANTITY</th>
<th>PRICE</th>
<th>MESSAGE</th>
<th>ORDER_ID</th>
</tr>

<%
for(Items items:(List<Items>)session.getAttribute("orders"))
{
%>
<tr>
<td><%=items.getId() %></td>
<td><%=items.getName() %></td>
<td><%=items.getQuantity() %></td>
<td><%=items.getPrice() %></td>
<td><%=items.getMessage() %></td>
<td><%=request.getParameter("orderId") %></td>
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