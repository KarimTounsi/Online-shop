<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand-xl navbar-light fixed-top bg-nav">
    <a class="navbar-brand" href="/">
        <img src="/img/logo.png" width="30" height="30" class="d-inline-block mr-1 align-bottom" alt="">
        ImStore</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">

        <ul class="navbar-nav ">
            <li class="nav-item ">
                <a class="nav-link" href="/all">Lista produktów<span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Kategorie</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <c:forEach varStatus="theCount" items="${categories}" var="category">
                        <a class="dropdown-item" href="/products-from-category/${category.id}"> ${category.name} </a>
                    </c:forEach>
                </div>
                <%--                <div class="dropdown-divider"></div>--%>
            </li>

        </ul>
        <form:form class="form-inline my-2 my-lg-0 mr-auto" action="/search" method="post">
            <input class="form-control mr-sm-2" type="search" placeholder="Wyszukaj" aria-label="Wyszukaj"
                   name="search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Znajdź</button>
        </form:form>
        <sec:authorize access="isAuthenticated()">
        <ul class="navbar-nav ">
            <li class="nav-item ">
                <a class="nav-link" href="/cart"><c:choose>
                    <c:when test="${ProductsInCart > 0}">
                        <span class="badge badge-light">${ProductsInCart}</span>
                    </c:when>
                </c:choose><svg width="2em" height="2em" viewBox="0 0 16 16" class="bi bi-cart4" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
                    </svg>
                    </a>
            </li>

            <li class="nav-item ">
                <a class="nav-link" href="/user/orders">Zamówienia</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/info">Konto</a>
            </li>
            </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Strony admina
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdown02">
                    <a class="dropdown-item" href="/admin/orders/all">Zamówienia użytkowników</a>
                    <a class="dropdown-item" href="/admin/category/all">Lista kategorii</a>
                    <a class="dropdown-item" href="/admin/category/add">Dodaj kategorie</a>
                    <a class="dropdown-item" href="/admin/category/all/deleted">Lista usuniętych kategorii</a>
                    <a class="dropdown-item" href="/admin/image/image-without-relations">Lista zdjęć <br> nie dodanych do produktu</a>
                    <a class="dropdown-item" href="/admin/image/add">Dodaj zdjęcie</a>
                    <a class="dropdown-item" href="/admin/product/add">Dodaj produkt</a>
                    <a class="dropdown-item" href="/admin/product/all/deleted">Lista usuniętych produktów</a>
                </div>
            </li>
        </sec:authorize>
        </ul>
        <sec:authorize access="!isAuthenticated()">
            <form class="form-inline my-2 my-lg-0" method="get" action="/login">
                <button class="btn btn-primary my-2 my-sm-0 mr-sm-2" type="submit">Zaloguj</button>
                <sec:csrfInput/>
            </form>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">

            <form class="form-inline my-2 my-lg-0" method="post" action="/logout">
                <button class="btn btn-primary my-2 my-sm-0 mr-sm-2" type="submit">Wyloguj</button>
                <sec:csrfInput/>
            </form>

        </sec:authorize>
        <form class="form-inline my-2 my-lg-0" method="get" action="/register">
            <button class="btn btn-success my-2 my-sm-0 mr-sm-2" type="submit">Zarejestruj</button>
            <sec:csrfInput/>
        </form>
        <%--            <sec:authorize access="!isAuthenticated()">--%>
        <%--            <div style=" margin-right: 20px" class="nav-div " > Witaj, <strong>nieznajomy</strong></div>--%>
        <%--        </sec:authorize>--%>
        <%--        <sec:authorize access="hasRole('ROLE_ADMIN')">--%>
        <%--            MAM ROLE ADMIN--%>
        <%--        </sec:authorize>--%>
        <%--        <sec:authorize access="isAuthenticated()">--%>
        <%--            <p>Zalogowany jako: <sec:authentication property="name"/></p>--%>
        <%--            <p>Posiada role: <sec:authentication property="authorities"/></p>--%>
        <%--        </sec:authorize>--%>
        <sec:authorize access="isAuthenticated()">
            <div style="margin-right: 20px" class="nav-div"> Witaj,
                <strong>${pageContext.request.userPrincipal.principal.username}</strong></div>
        </sec:authorize>


        </ul>

    </div>
</nav>