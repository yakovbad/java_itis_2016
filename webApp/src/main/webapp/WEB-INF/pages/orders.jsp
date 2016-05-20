<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Customer</th>
        <th>Product</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete?</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td><a href="/webApp/customer/edit/${order.customer.id}">${order.customer.lastname} ${order.customer.firstname}</a></td>
            <td>${order.product}</td>
            <td>${order.price}</td>
            <td><a href="/webApp/order/edit/${order.id}">Edit</a></td>
            <td><a href="/webApp/order/delete/${order.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="add">Add order</a>
</body>
</html>