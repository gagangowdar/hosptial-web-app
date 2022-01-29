<%@page import="com.ty.dto.Person"%>
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
			String id = request.getParameter("personid");
	%>

        <h2>CREATE ENCOUNTER</h2>
        <form action="createencounter" method="post">
            <table>
            <tr>
            	<td>
            	<label for="personid">Id</label>
            	</td>
            	<td>
            	<input type="number" name="personid" value="<%=id%>" readonly="readonly">

				</td>
			</tr>
                <tr>
                    <td>
                        <label for="dateTime">Date_Time:</label>
                    </td>
                    <td><input type="datetime-local" name="dateTime"></td>
                </tr>

                <tr>
                    <td><label for="reason">Reason:</label></td>
                    <td><input type="text" id="email" name="reason"></td>
                </tr>
				<tr>
				<td>
				<input type="submit" value="Create Encounter">
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