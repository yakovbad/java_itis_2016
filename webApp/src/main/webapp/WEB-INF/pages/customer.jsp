<%--
  Created by IntelliJ IDEA.
  User: yakov
  Date: 05.04.2016
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form</h1>
<form:form method="POST" action="/customer/add" modelAttribute="customer">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td><form:input path="lastname"/></td>
        </tr>
        <tr>
            <td><form:input path="firstname"/></td>
        </tr>
        <tr>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
