<%--
  Created by IntelliJ IDEA.
  User: barti
  Date: 26.05.2022
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment Confirmation View</title>
</head>
<body>
<div>
    <h2>Transaction ended</h2>

    <label>
        Date of purchase:
        <input disabled value="${purchase.dateTime.format(formatter)}">
    </label>
    <br>

    <label>
        Product name:
        <input disabled value="${purchase.stockItem.product.name}">
    </label>
    <br>

    <label>
        Amount:
        <input disabled value="${purchase.price}">
    </label>
    <br>

    <label>
        Order status:
        <input disabled value="${purchase.status}">
    </label>
    <br>

    <label>
        Payment method:
        <input disabled value="${purchase.paymentMethod}">
    </label>
</div>
</body>
</html>
