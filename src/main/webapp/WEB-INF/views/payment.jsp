<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: barti
  Date: 25.05.2022
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Payment View</title>
</head>
<body>
<c:if test="${not empty errors}">
    <c:forEach var="error" items="${errors}">
        <span>${error}</span>
    </c:forEach>
</c:if>

<form action="<c:url value="/user/payment"/>" method="post">
    <label>
        Enter coins:
        <input name="amount" type="number" min="0.01" step="0.01">
    </label>

    <input type="submit">
</form>
</body>
</html>
