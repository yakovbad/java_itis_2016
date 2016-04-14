<%--
  Created by IntelliJ IDEA.
  User: Yakov
  Date: 06.04.2016
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Car List</title>
</head>
<body>
  <c:forEach items="${listCar}" var="car">
    ${car.brand.name} ${car.model}: ${car.price}
    <br/>
  </c:forEach>

<a href="/car/add">Add card</a>
</body>
</html>
