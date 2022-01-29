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

<%@ include file="admin_navbar.jsp" %>

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
			String id = request.getParameter("hospitalid");
	%>

        <h2>CREATE BRANCH</h2>
        <form action="createbranch" method="post">
            <table>
            <tr>
            	<td>
            	<label for="hospitalid">Id</label>
            	</td>
            	<td>
            	<input type="number" name="hospitalid" value="<%=id%>" readonly="readonly">

				</td>
			</tr>
                <tr>
                    <td>
                        <label for="name">Name:</label>
                    </td>
                    <td><input type="text" id="name" name="name"></td>
                </tr>

                <tr>
                    <td><label for="phone">Phone:</label></td>
                    <td><input type="number" id="phone" name="phone"></td>
                </tr>
                
                <tr>
                    <td>
                        <label for="email">Email:</label>
                    </td>
                    <td><input type="text" id="email" name="email"></td>
                </tr>
				<tr>
				<td>
				<input type="submit" value="Create Branch">
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