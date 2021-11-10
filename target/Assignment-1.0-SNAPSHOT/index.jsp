<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form method="post" action="UserController">
    Email: <input type="email" name="userEmail"/><br>
    Name: <input type="text" name="userName"/> <br>
    Address: <input type="text" name="userAddress"/> <br>
    <input type="submit" value="submit form"/>
</form>
<br><br><br><br>
<form method="post" action="BookController">
    Title: <input type="text" name="bookTitle"/><br>
    Author: <input type="text" name="bookAuthor"/><br>
    <input type="submit" value="show books"/>
</form>
</body>
</html>