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

<section>
    <ul class="member-list">
        <li>
            <a href="<c:url value="/admin/list?mode=I"/>">Zarządzanie fundacjami</a>
        </li>
        <li>
            <a href="<c:url value="/admin/list?mode=A"/>">Zarządzanie administratorami</a>
        </li>
        <li>
            <a href="<c:url value="/admin/list?mode=U"/>">Zarządzanie użytkownikami</a>
        </li>
    </ul>
</section>

<script src="<c:url value="../static/js/app.js"/>"></script>
</body>
</html>