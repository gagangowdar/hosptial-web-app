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
body {
	background-color: rgb(210, 190, 150);
}

td {
	font-size: large;
}

form {
	border: 3px solid #f1f1f1;
	background-color: rgb(130, 218, 200)
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 10px 10px;
	margin: 20px 5px;
	display: inline-block;
	border: 3px solid #ccc;
	box-sizing: border-box;
}
</style>
	<center><h2>Login Form</h2></center>
	<form action="login" method="post">
		<center>
			<i>
				<table>
					</i>
					</center>
					<tr>
						<td>Email</td>
						<td><input type="text" placeholder="Enter Email" name="mail" /></td>
					</tr>

					<tr>
						<td>Password</td>
						<td><input type="password" placeholder="Enter Password"
							name="password" /></td>
					</tr>
				</table> <br> <input type="submit" value="Login" />
	</form>
</body>
</html>