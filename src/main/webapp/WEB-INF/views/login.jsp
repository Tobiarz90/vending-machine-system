<%--
  Created by IntelliJ IDEA.
  User: barti
  Date: 27.05.2022
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login View</title>
</head>
<body>
<form method="post">
    <div><label> Username : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <%-- '_csrf' - zawiera automatycznie wygenerowany klucz --%>
</form>
</body>
</html>
