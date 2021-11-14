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

<br><br>
<c:forEach items="${userList}" var="user">
    <c:out value="Hello :"></c:out>
    <c:out value="${user.name}"/><br>
    <c:out value="${user.email}"/>
</c:forEach>
<br>
<h3>Add a Book</h3>

<form method="post" action="BookController">
    Title: <input type="text" name="bookTitle"/><br>
    Author: <input type="text" name="bookAuthor"/><br>

    //GET THE USER EMAIL INTO HERE
    Email: <input type="text" name="userEmail"/>
    <input type="submit" value="show books"/>
</form>

<br><br>
<h2></h2>

</body>
</html>