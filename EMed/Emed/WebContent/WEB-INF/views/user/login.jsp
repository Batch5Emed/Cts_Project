<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<h1>Login Here !</h1>
<br>
<br>
<body>

	<table>
		<form method="POST">
			<tr>
				<td>Enter Email</td>
				<td><input type="text" name="em"></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="pwd"></td>
			</tr>
	
			<tr>
				<td><button type="submit">Login</td>
			</tr>
		</form>
	</table>
	<h2><a href='<spring:url value="/user/register"></spring:url>'>Register Here</a></h2>
</body>
</html>