<%--
  Created by IntelliJ IDEA.
  User: yakov
  Date: 31.03.2016
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Last Name</th>
            <th>First Name</th>
            <th>Age</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.lastname}</td>
            <td>${customer.firstname}</td>
            <td>${customer.age}</td>
            <td><a href="/customer/edit/${customer.id}">Edit</a></td>
            <td><a href="/customer/delete/${customer.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
