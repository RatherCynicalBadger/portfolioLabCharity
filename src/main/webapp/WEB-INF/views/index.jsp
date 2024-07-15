<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp" %>

<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Zacznij pomagać!<br/>
            Oddaj niechciane rzeczy w zaufane ręce
        </h1>
    </div>
</div>
</header>

<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em>${all_bags}</em>

            <h3>Oddanych worków</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <em>${all_donations}</em>
            <h3>Przekazanych darów</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>

    </div>
</section>

<section id="steps" class="steps">
    <h2>Wystarczą 4 proste kroki</h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3>Wybierz rzeczy</h3>
            <p>Ubrania, zabawki, sprzęt i inne</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3>Spakuj je</h3>
            <p>Skorzystaj z worków na śmieci</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3>Zdecyduj komu chcesz pomóc</h3>
            <p>Wybierz zaufane miejsce</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3>Zamów kuriera</h3>
            <p>Kurier przyjedzie w dogodnym terminie</p>
        </div>
    </div>

    <a href="#" class="btn btn--large">Załóż konto</a>
</section>

<section id="about-us" class="about-us">
    <div class="about-us--text">
        <h2>O nas</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
        <img src="<c:url value="static/images/signature.svg"/>" class="about-us--text-signature" alt="Signature"/>
    </div>
    <div class="about-us--image"><img src="<c:url value="static/images/about-us.jpg"/>" alt="People in circle"/>
    </div>
</section>

<section id="help" class="help">
    <h2>Komu pomagamy?</h2>

    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
            Możesz sprawdzić, czym się zajmują.</p>

        <ul class="help--slides-items">

            <li>
                <c:forEach var="inst" items="${institutions_1}" varStatus="i">
                    <div class="col">
                        <div class="title">${inst.name}</div>
                        <div class="subtitle">${inst.description}</div>
                    </div>
                </c:forEach>
            </li>

            <li>
                <c:forEach var="inst" items="${institutions_2}" varStatus="i">
                    <div class="col">
                        <div class="title">${inst.name}</div>
                        <div class="subtitle">${inst.description}</div>
                    </div>
                </c:forEach>
            </li>
        </ul>
    </div>

</section>

<%@include file="footer.jsp" %>