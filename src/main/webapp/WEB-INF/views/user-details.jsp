<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="currentUser" scope="request" type="pl.coderslab.charity.dto.LoggedUserInformation"/>

<%@include file="header-simple.jsp"%>

<section>
    <h2>Szczegóły konta</h2>
    <ul>
        <li>Email: ${currentUser.email}</li>
        <li>First name: ${currentUser.firstName}</li>
        <li>Last name: ${currentUser.lastName}</li>
    </ul>
</section>

<%@include file="footer.jsp" %>