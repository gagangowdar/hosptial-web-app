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
<%@ include file="admin_navbar.jsp" %>

        <h2 style="font-style:;">CREATE HOSPITAL</h2>
        <form action="createhospital" method="post">
            <table>

                <tr>
                    <td>
                        <label for="name">Name:</label>
                    </td>
                    <td><input type="text" id="name" name="name"></td>
                </tr>

                <tr>
                    <td><label for="gst">GST:</label></td>
                    <td><input type="text" id="gst" name="gst"></td>
                </tr>

                <tr>
                    <td><label for="website">Web Site:</label></td>
                    <td><input type="text" id="website" name="website"></td>
                </tr>

				<tr>
                    <td colspan="2" > <input type="submit" value="submit"> </td>
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