<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="../static/css/style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="../static/css/list.css"/>"/>
</head>
<body>
<header>
    <nav class="container container--70">
        <%@include file="top-actions-panel.jsp" %>
    </nav>
</header>

<h4>
    <a href="<c:url value="/admin/panel"/>">Return to main panel</a>
</h4><br><br>

<c:choose>
    <c:when test="${mode == 'I'}">
            <%--@elvariable id="inst" type="pl.coderslab.charity.entity.Institution"--%>
            <form:form modelAttribute="inst" action="/admin/edit" method="post" >
                <label>Institution name:
                    <form:input path="name" placeholder="${inst.name}"/>
                </label>
                <label>Institution description:
                    <form:textarea path="description" placeholder="${inst.description}" cols="50" rows="4"/>
                </label>
                <input type="hidden" name="id" value="${inst.id}">
                <input type="hidden" name="mode" value="${mode}">
                <button type="submit">Save changes</button>
            </form:form>
    </c:when>
    <c:otherwise>
        <%--@elvariable id="user" type="pl.coderslab.charity.entity.UserEntity"--%>
        <form:form modelAttribute="user" action="/admin/edit" method="post" >
            <label>Email:
                <form:input path="email" value="${user.email}"/>
            </label>
            <label>First name:
                <form:input path="firstName" value="${user.firstName}"/>
            </label>
            <label>Last name:
                <form:input path="lastName" value="${user.lastName}"/>
            </label>
            <label>Password:
                <form:input path="password" value="${user.password}"/>
            </label>
            <input type="hidden" name="id" value="${user.id}">
            <input type="hidden" name="mode" value="${mode}">
            <button type="submit">Save changes</button>
        </form:form>
    </c:otherwise>
</c:choose>

<script src="<c:url value="../static/js/app.js"/>"></script>
</body>
</html>