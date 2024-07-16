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

<%--<c:set var="variant" value=""/>--%>

<%--<c:choose>--%>
<%--    <c:when test="${mode == 'I'}">--%>
<%--        <c:set var="variant" value="/admin/institutions"/>--%>
<%--    </c:when>--%>
<%--    <c:when test="${mode == 'A'}">--%>
<%--        <c:set var="variant" value="/admin/admins"/>--%>
<%--    </c:when>--%>
<%--    <c:when test="${mode == 'U'}">--%>
<%--        <c:set var="variant" value="/admin/users"/>--%>
<%--    </c:when>--%>
<%--</c:choose>--%>

<section>
    <form action="<c:url value="/admin/edit"/>" method="get">
        <input type="hidden" name="id" value="0">
        <input type="hidden" name="mode" value="${mode}">
        <button type="submit">ADD NEW</button>
    </form>
    <br><br>
    <ul>
        <jsp:useBean id="list" scope="request" type="java.util.List"/>
        <c:forEach var="entry" items="${list}">
            <li value="${entry.id}">
                <form:form action="/admin/edit" method="get">
                    <input type="hidden" name="id" value="${entry.id}">
                    <input type="hidden" name="mode" value="${mode}">
                    <button type="submit" class="edit">EDIT</button>
                </form:form>
                <form:form action="/admin/delete" method="post">
                    <input type="hidden" name="id" value="${entry.id}">
                    <input type="hidden" name="mode" value="${mode}">
                    <button type="submit" class="delete">DELETE</button>
                </form:form>
                <span>${entry}</span>
            </li>
        </c:forEach>
    </ul>
</section>

<script src="<c:url value="../static/js/app.js"/>"></script>
</body>
</html>