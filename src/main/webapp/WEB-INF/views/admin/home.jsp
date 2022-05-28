<%--
  Created by IntelliJ IDEA.
  User: barti
  Date: 27.05.2022
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home View</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <p>Signed in as: <sec:authentication property="principal.username"/></p>
    <p>User roles: <sec:authentication property="authorities"/></p>
</sec:authorize>

<ul>
    <li>
        <h3>
            <a href="<c:url value="/admin/stock"/>">Stock Edit</a>
        </h3>
    </li>
    <li>
        <h3>
            <a href="<c:url value="/admin/product"/>">Product Edit</a>
        </h3>
    </li>
    <li>
        <h3>
            <a href="<c:url value="/admin/purchase"/>">Purchase View</a>
        </h3>
    </li>
</ul>

<form action="<c:url value="/logout"/>" method="post">
    <input class="fa fa-id-badge" type="submit" value="Sign out">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
