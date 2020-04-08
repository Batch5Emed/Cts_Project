<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appointment List</title> 
<h1>Requested Appointments</h1>
<br>
<br>
</head>


<body>
<table border="1">
    <th>Status</th>
    <th>Requested Date</th>
    <th>Patient Name</th>
    <th>Patient Contact</th>
   
    <c:forEach var="a" items="${sessionScope.applist}">
     <tr>
          <td>${a.appstatus}</td>
        <td>${a.apdate}</td>
        <td>${a.user.userNanme}</td>
        <td>${a.user.contact}</td>
        <td><a href='<spring:url value="/doctor/acceptapp?appid=${a.appid}"></spring:url>'>Accept</a>
        <a href='<spring:url value="/doctor/declineapp?appid=${a.appid}"></spring:url>'>Reject</a>
        </td>


        
     </tr> 
    </c:forEach>
    </table>

</body>
</html>