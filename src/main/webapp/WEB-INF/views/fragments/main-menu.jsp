<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>




<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="/">ImStore</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/all">Lista produktów<span class="sr-only">(current)</span></a>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Kategorie</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="#">Artykuły Spożywcze</a>
                    <a class="dropdown-item" href="#">Kosmetyki</a>
                    <a class="dropdown-item" href="#">inne</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <ul class="navbar-nav mr-auto">
            <sec:authorize access="!isAuthenticated()">

                <li class="nav-item">
                    <form class="form-inline my-2 my-lg-0" method="get" action="/login">
                        <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Zaloguj</button>
                        <sec:csrfInput/>
                    </form>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <form class="form-inline my-2 my-lg-0" method="post" action="/logout">
                        <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Wyloguj</button>
                        <sec:csrfInput/>
                    </form>
                </li>
            </sec:authorize>
            <li class="nav-item">
                <form class="form-inline my-2 my-lg-0" method="get" action="/register">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Zarejestruj</button>
                    <sec:csrfInput/>
                </form>
                <sec:authorize access="!isAuthenticated()">
            <li class="nav-item">
                <div style=" color: antiquewhite;margin-right: 20px" class="nav-div" > Witaj, <strong style="color: antiquewhite">nieznajomy</strong></div>
            </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <div style="color: antiquewhite;margin-right: 20px"   class="nav-div" > Witaj, <strong style="color: antiquewhite">${pageContext.request.userPrincipal.principal.username}</strong></div>
                </li>
            </sec:authorize>
        </ul>

    </div>
</nav>