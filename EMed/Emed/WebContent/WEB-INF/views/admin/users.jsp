<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users List</title>
</head>

<body>
<h2>All Current Users</h2>
<br>
<br>
<table border="1">
    <th>Name</th>
    <th>Email</th>
    <th>Contact</th>
    <th>Gender</th>
    <c:forEach var="d" items="${sessionScope.allusers}">
     <tr>
          <td>${d.userNanme}</td>
        <td>${d.email}</td>
        <td>${d.contact}</td>
        <td>${d.gender}</td>
         </tr>
          </c:forEach>
    </table>
   <h2><a href='<spring:url value="/admin/addDoctor"></spring:url>'>Add Doctor</a></h2> 

</body>
</html>