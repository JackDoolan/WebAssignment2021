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
<c:forEach items="${myList}" var="book">
  Book ID: <c:out value="${book.ID}"/><br>
  Book Title: <c:out value="${book.title }"/><br>
  Book Author: <c:out value="${book.author}"/><br>
  <br><br>
</c:forEach>
<br>

<form method="post" action="UpdateController">
  <h4>Id of Book you wish to update</h4>
  ID <input type="text" name="bookID"/><br>
  Update Name <input type="text" name="bookUpdateName"/> <br>
  Update Author <input type="text" name="bookUpdateAuthor"/> <br>
  <input type="hidden" value="${sessionScope.userEmail}" name="bookUpdateEmail"></br>
  <input type="submit" value="Update"/>
</form>


</body>
</html>