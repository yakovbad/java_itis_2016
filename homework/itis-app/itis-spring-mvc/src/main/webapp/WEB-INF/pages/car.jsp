<%--
  Created by IntelliJ IDEA.
  User: Yakov
  Date: 07.04.2016
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1>Form</h1>
<form:form method="POST" action="/car/add" modelAttribute="car">

    Brand<br />
    <form:select path="brandId">
        <form:options items="${brandList}" itemLabel="name" itemValue="id" />
    </form:select>
    <br /><br />
    Model<form:errors path="model" cssClass="error"/><br />
    <form:input path="model"/><br /><br />

    Price<form:errors path="price" cssClass="error"/><br />
    <form:input path="price"/><br /><br />

    <input type="submit" value="Submit">
</form:form>
</body>
</html>
