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


<% String status =(String)session.getAttribute("status");
	if(status==null){
	%>

<%@ include file="person_navbar.jsp" %>
<%String id=request.getParameter("encounterId"); %>
  <form action="createorder" method="post">
        <table>
         <tr><td>Encounter Id: </td> 
		<td><input type="text" name="encounterId" value="<%=id%>" readonly="readonly"></td></tr>
		
				<tr><td>DateTime:</td> 
		 <td><input type="datetime-local" name="DateTime" placeholder="Date And Time"></td> </tr>
		 
		 <tr><td>Message:</td> 
		 <td><input type="text" name="message" placeholder="Enter Message"></td> </tr>
		 
		
		 <tr><td colspan="2" align="center"><input type="submit" value="create Order"></td></tr>
     </table>
	</form>
	
	<%}
	else
	{%>
	<%@include file="login.jsp"%>
	<%} %>
</body>
</html>