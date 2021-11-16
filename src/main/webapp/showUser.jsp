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

    <c:out value="Hello : ${sessionScope.userName}"></c:out>

    <br><br>
<h3>Add a Book</h3>

    <form method="post" action="BookController">
    Title:    <input type="text" name="bookTitle"/><br>
    Author:   <input type="text" name="bookAuthor"/><br>
              <input type="hidden" value="${sessionScope.userEmail}" name="userEmail"/>
              <input type="submit" value="Add Book">
    </form>

<br><br>

<h3>View your books</h3>
    <form method="post" action="BookController">
        <input type="hidden" name="bookTitle"/><br>
        <input type="hidden" name="bookAuthor"/><br>
        <input type="hidden" value="${sessionScope.userEmail}" name="userEmail"/>
        <input type="submit" value="Show Books">
    </form>



<h3>Book to delete</h3>
<form method="get" action="BookController">
Book Title: <input type="text" name="bookToDelete"/><br>
    <input type="hidden" value="${sessionScope.userEmail}" name="userEmail"/>
<input type="submit" value="submit form"/>
</form>



<h3>Click this button to delete your account</h3>
<form method="get" action="UserController">
        <input type="hidden" value="${sessionScope.userEmail}" name="userEmailToDelete"/>
    <input type="submit" value="Delete User"/>
</form>






</body>
</html>
