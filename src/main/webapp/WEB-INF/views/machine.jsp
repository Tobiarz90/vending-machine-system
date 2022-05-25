<%--
  Created by IntelliJ IDEA.
  User: barti
  Date: 16.05.2022
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Machine View</title>
</head>
<body>
<table>
    <c:set var="counter" value="0"/>
    <c:forEach begin="1" end="${rows}" var="i">
        <tr>
            <c:forEach begin="1" end="${columns}" var="j">
                <c:set var="counter" value="${counter + 1}"/>
                <c:set var="content" value="empty"/>

                <c:if test="${not empty stock[(i - 1).intValue()]}">
                    <c:if test="${not empty stock[(i - 1).intValue()][(j - 1).intValue()]}">
                        <c:set var="item"
                               value="${stock[(i - 1).intValue()][(j - 1).intValue()][(0).intValue()]}"/>
                        <c:set var="content"
                               value="${item.product.name} - ${item.product.price} PLN (${item.quantity} pcs.)"/>
                    </c:if>
                </c:if>

                <td>${counter}. ${content}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
