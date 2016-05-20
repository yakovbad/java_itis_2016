<%--
  Created by IntelliJ IDEA.
  User: yakov
  Date: 05.04.2016
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
${message}
<a href="<c:url value="/customer/all"/>">All customers</a>
<a href="<c:url value="/orders/all"/>">All orders</a>
</body>
</html>
