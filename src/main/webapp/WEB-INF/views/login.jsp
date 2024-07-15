<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header-simple.jsp" %>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <form:form action="/login" method="post">
        <div class="form-group">
            <label>
                <input type="email" name="username" placeholder="Email"/>
            </label>
        </div>
        <div class="form-group">
            <label>
                <input type="password" name="password" placeholder="Hasło"/>
            </label>
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
    </form:form>
</section>

<%@include file="footer.jsp" %>