<%--
  Created by IntelliJ IDEA.
  User: barti
  Date: 19.05.2022
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Keypad View</title>
</head>
<body>
<form action="<c:url value="/user/keypad"/>" method="post">
    <label>
        Type item's number to select it:
        <input name="itemNumber" type="number">
    </label>

    <input type="submit">
</form>
</body>
</html>
