<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header-simple.jsp" %>

<section class="login-page">
    <h2>Załóż konto</h2>

    <%--@elvariable id="user" type="pl.coderslab.charity.entity.UserEntity"--%>
    <form:form action="/register" method="post" modelAttribute="user">
        <div class="form-group">
            <form:input type="email" name="email" placeholder="Email" path="email" />
        </div>
        <div class="form-group">
            <form:input type="text" name="first_name" placeholder="Imię" path="firstName" />
        </div>
        <div class="form-group">
            <form:input type="text" name="last_name" placeholder="Nazwisko" path="lastName" />
        </div>
        <div class="form-group">
            <form:input type="password" name="password" placeholder="Hasło" path="password" />
        </div>
<%--        TODO - verify password --%>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@include file="footer.jsp" %>