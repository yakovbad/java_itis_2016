<%--
  Created by IntelliJ IDEA.
  User: yakov
  Date: 05.04.2016
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
${error}
<c:if test="${customer != null}">
<form:form method="POST" action="/webApp/customer/add" modelAttribute="customer">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td><label>Last name: </label></td>
            <td><form:input path="lastname"/></td>
            <td><form:errors path="lastname" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>First name: </label></td>
            <td><form:input path="firstname"/></td>
            <td><form:errors path="firstname" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Age: </label></td>
            <td><form:input path="age"/></td>
            <td><form:errors path="age" cssClass="error"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form:form>

    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Customer</th>
            <th>Product</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customer.orders}" var="order">
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
</c:if>
</body>
</html>
