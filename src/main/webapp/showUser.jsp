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
</c:forEach>
<br>
<h3>Add a Book</h3>



//Form to add new book
<form method="post" action="BookController">
    <c:forEach items="${userList}" var="user">
    Title: <input type="text" name="bookTitle"/><br>
    Author: <input type="text" name="bookAuthor"/><br>
 <input type="hidden" value="${user.email}" name="userEmail"/>
    </c:forEach>
    <input type="submit" value="Add Book">
</form>

<br><br>
//Form to view all books for logged in user.
<form method="post" action="BookController">
<c:forEach items="${userList}" var="user">
    <input type="hidden" name="bookTitle"/><br>
    <input type="hidden" name="bookAuthor"/><br>
    <input type="hidden" value="${user.email}" name="userEmail"/>
</c:forEach>
    <input type="submit" value="Show Books">
</form>



<h3>Book to delete</h3>
<form method="get" action="BookController">
<c:forEach items="${userList}" var="user">
Book Title: <input type="text" name="bookToDelete"/><br>
    <input type="hidden" value="${user.email}" name="userEmail"/>
</c:forEach>
<input type="submit" value="submit form"/>
</form>



<h3>Click this button to delete your account</h3>
<form method="get" action="UserController">
    <c:forEach items="${userList}" var="user">

        <input type="hidden" value="${user.email}" name="userEmailToDelete"/>
    </c:forEach>
    <input type="submit" value="Delete User"/>
</form>






</body>
</html>
