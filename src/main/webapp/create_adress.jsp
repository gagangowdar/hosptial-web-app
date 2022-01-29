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



    </head>

    <body>
    <%
			String id = request.getParameter("branchid");
	%>

        <h2>CREATE ADRESS</h2>
        <form action="createadress" method="post">
            <table>
            <tr>
            	<td>
            	<label for="branchid">Id</label>
            	</td>
            	<td>
            	<input type="number" name="branchid" value="<%=id%>" readonly="readonly">

				</td>
			</tr>
                <tr>
                    <td>
                        <label for="adress">Adress:</label>
                    </td>
                    <td><input type="text" name="adress"></td>
                </tr>
                
                <tr>
                    <td>
                        <label for="state">State:</label>
                    </td>
                    <td><input type="text" name="state"></td>
                </tr>

                <tr>
                    <td><label for="pin">PIN:</label></td>
                    <td><input type="number" id="pin" name="pin"></td>
                </tr>
				<tr>
				<td>
				<input type="submit" value="Create Adress">
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