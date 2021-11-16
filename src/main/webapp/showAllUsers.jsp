<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${myUserList}" var="user">
    User Name: <c:out value="${user.email}"/><br>
    User Email: <c:out value="${user.name}"/><br>
 <br><br><br>
</c:forEach>

</body>
</html>
