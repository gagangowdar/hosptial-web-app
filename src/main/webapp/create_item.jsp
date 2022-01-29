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

<%@ include file="person_navbar.jsp" %>

    <style>
          body{
            background-color: rgb(191, 226, 226);
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



    </head>

    <body>
    <%
			String id = request.getParameter("orderid");
	%>

        <h2>CREATE ITEM</h2>
        <form action="createitem" method="post">
            <table>
            <tr>
            	<td>
            	<label for="id">Id</label>
            	</td>
            	<td>
            	<input type="number" name="orderid" value="<%=id%>" readonly="readonly">

				</td>
			</tr>
                <tr>
                    <td>
                        <label for="name">Name:</label>
                    </td>
                    <td><input type="text" name="name"></td>
                </tr>
                
                <tr>
                    <td>
                        <label for="message">Message:</label>
                    </td>
                    <td><input type="text" name="message"></td>
                </tr>
                
                <tr>
                    <td><label for="quantity">Quantity:</label></td>
                    <td><input type="number" id="quantity" name="quantity"></td>
                </tr>

                <tr>
                    <td><label for="price">PRICE:</label></td>
                    <td><input type="number" id="price" name="price"></td>
                </tr>
				<tr>
				<td>
				<input type="submit" value="Create Item">
				</td>
				</tr>

            </table>

        </form>
<%}
	else
	{%>
	<%@include file="login.jsp"%>
	<%} %>

    </body>

</html>