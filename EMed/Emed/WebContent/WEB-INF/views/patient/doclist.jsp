<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctors List</title> 
<h1>Available Doctors List</h1>
<br>
<br>
</head>

</script>
<body>
<table border="1">
    <th>Name</th>
    <th>Specialiasation</th>
    <th>Contact</th>
    <th>Gender</th>
    <th>Set Date</th>
    <c:forEach var="d" items="${sessionScope.doclist}">
     <tr>
          <td>${d.userNanme}</td>
        <td>${d.specialisation}</td>
        <td>${d.contact}</td>
        <td>${d.gender}</td>
        <td>
        <form method="POST">
        <input type="text" name="docid" value="${d.userId}" hidden="true">
        <br>
    
        <input type="date" name="appdate" value="">
        <br>
        <button type="submit">Request</button>
        <br>
        </form>
        </td>
        
     </tr>
    
    </c:forEach>
    </table>

</body>
</html>