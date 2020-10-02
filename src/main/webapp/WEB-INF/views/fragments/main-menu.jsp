<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand-xl navbar-light fixed-top bg-nav">
    <a class="navbar-brand" href="/">
        <img src="/img/logo.png" width="30" height="30" class="d-inline-block mr-1 align-bottom" alt="">
        <%--            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-shop" fill="currentColor" xmlns="http://www.w3.org/2000/svg">--%>
        <%--        <path fill-rule="evenodd" d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z"/>--%>
        <%--    </svg>--%>
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
                <a class="nav-link" href="/cart">

                    <c:choose>
                    <c:when test="${ProductsInCart > 0}">
                    <span class="badge badge-light">${ProductsInCart}</span>
                    </c:when>
                    </c:choose>
                    Koszyk</a>

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
                    <a class="dropdown-item" href="/admin/product/add">Dodaj produkt</a>
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