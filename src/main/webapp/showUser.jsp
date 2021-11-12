<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<c:forEach items="${userList}" var="user">
    <c:out value="Hello :"></c:out>
    <c:out value="${user.name}"/>
</c:forEach>

</body>
</html>