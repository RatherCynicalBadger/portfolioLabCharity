<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sec:authorize access="!isAuthenticated()">
    <ul class="nav--actions">
        <li><a href="<c:url value="/login"/>" class="btn btn--small btn--without-border">Zaloguj</a></li>
        <li><a href="<c:url value="/register"/>" class="btn btn--small btn--highlighted">Załóż konto</a></li>
    </ul>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <ul class="nav--actions">
        <li><a href="<c:url value="/user_details"/>" class="btn btn--small btn--without-border">Witaj <sec:authentication property="principal.username"/></a></li>
        <li>
            <form:form action="/logout" method="post">
                <button type="submit" class="btn btn--small btn--highlighted">Wyloguj</button>
            </form:form>
        </li>
    </ul>
</sec:authorize>
