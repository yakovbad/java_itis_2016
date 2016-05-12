<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form</h1>
<c:if test="${order != null}">
    <form:form method="POST" action="/order/add" modelAttribute="order">
        <table>
            <tr>
                <td><form:hidden path="id"/></td>
            </tr>
            <tr>
                <form:select path="customerId">
                    <form:options items="${customers}" itemLabel="lastname" itemValue="id" />
                </form:select>
            </tr>
            <tr>
                <td><form:input path="product"/></td>
            </tr>
            <tr>
                <td><form:input path="price"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>
</c:if>
</body>
</html>