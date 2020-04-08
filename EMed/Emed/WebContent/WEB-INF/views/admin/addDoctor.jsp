<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration for Doctor</title>
</head>
<body>
<h2>Doctors Registration</h2>
<table>
		<form method="POST">
			<tr>
				<td>Enter User Name</td>
				<td><input type="text" name="userNanme"></td>
			</tr>
			<tr>
				<td>Enter Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
			<td>Enter Contact number</td>
			<td><input type="text" name="contact"></td>
			</tr>
		
			<tr>
			<td>Select Gender</td>
			<td>
			     <input type="radio" name="gender"  value="male"> Male
     <input type="radio" name="gender"  value="female"> Female
     <input type="radio" name="gender" value="other"> Other
			</td>
			</tr>
			<tr>
			<td>Select Specialisation</td>
			<td>
			<select name="specialisation" id="">
      <option value="EYE">Eye</option>
      <option value="DENTAL">Dental</option>
      <option value="Cardiac">Cardiac</option>
      <option value="ENT">ENT</option>
      <option value="ORTHO">Ortho</option>
      </select>
			</td>
			</tr>
			<tr>
			<td><button type="submit">Register</button></td>
			</tr>
		</form>
	</table>
</body>
</html>