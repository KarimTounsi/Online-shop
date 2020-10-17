<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<jsp:include page="../fragments/main-menu.jsp"/>


<div class="container registration">
    <div class="row" style="margin-top: 40px">
        <div class="col-1"></div>
        <div class="col-10" style="padding-bottom: 20px"><h2>Edycja danych</h2></div>
        <div class="col-1"></div>
    </div>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-6">
            <form:form method="post" action="/edit"  modelAttribute="user">
<%--                <input type="text" required name="id" id="id" value="${user.id}" hidden />--%>
                <div class="form-group">
                    <label for="username">Nazwa użytkownika</label>
                    <input type="text" required name="username" id="username" class="form-control" value="${user.username}"
                           placeholder="Podaj nazwę użytkownika"/>
                    <form:errors path="username" cssClass="error"/><br>
                </div>
                <div class="form-group">
                    <label for="username">Email</label>
                    <input type="text" required name="email" id="email" class="form-control" value="${user.email}"
                           placeholder="Podaj Email"/>
                    <form:errors path="email" cssClass="error"/><br>
                </div>
                <div class="form-group">
                    <label for="firstName">Imię</label>
                    <input type="text" required name="firstName" id="firstName" class="form-control" value="${user.firstName}"
                           placeholder="Podaj imię"/>
                    <form:errors path="firstName" cssClass="error"/><br>
                </div>
                <div class="form-group">
                    <label for="lastName">Nazwisko</label>
                    <input type="text" required name="lastName" id="lastName" class="form-control" value="${user.lastName}"
                           placeholder="Podaj nazwisko"/>
                    <form:errors path="lastName" cssClass="error"/><br>
                </div>
                <div class="form-group">
                    <input type="text" required name="password" id="password" class="form-control" value="${user.password}"
                           placeholder="password" hidden/>
                    <form:errors path="password" cssClass="error"/><br>
                </div>
                <button class="btn btn-primary" type="submit">Potwierdź</button>
                <button class="btn btn-secondary" type="reset">Wyczyść dane</button>
                <sec:csrfInput/>
            </form:form>
        </div>
        <div class="col-5"></div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
</body>
</html>