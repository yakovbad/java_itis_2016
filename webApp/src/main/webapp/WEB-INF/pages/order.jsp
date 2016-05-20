<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<c:if test="${order != null}">
    <form:form method="POST" action="/webApp/order/add" modelAttribute="order">
        <table>
            <tr>
                <td><form:hidden path="id"/></td>
            </tr>
            <tr>
                <td><label>Customer: </label></td>
                <td>
                <form:select path="customerId">
                    <form:options items="${customers}" itemLabel="lastname" itemValue="id" />
                </form:select>
                </td>
                <td><form:errors path="customerId" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>Product</label></td>
                <td><form:input path="product"/></td>
                <td><form:errors path="product" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>Price: </label></td>
                <td><form:input path="price"/></td>
                <td><form:errors path="price" cssClass="error"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save"/></td>
            </tr>
        </table>
    </form:form>
</c:if>
</body>
</html>