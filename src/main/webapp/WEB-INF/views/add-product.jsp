<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<jsp:include page="fragments/one-button-menu.jsp"/>
<div class="container add-product">
    <div class="row" style="margin-top: 40px">
        <div class="col-1"></div>
        <div class="col-10" style="padding-bottom: 20px"><h2>Nowy produkt</h2></div>
        <div class="col-1"></div>
    </div>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-6">
            <form:form method="post" action="/admin/add" modelAttribute="product">
                <div class="form-group">
                    <label for="name">Nazwa Produktu</label>
                    <input type="text" required name="name" id="name" class="form-control"
                           placeholder="Podaj nazwę Produktu"/>
                    <form:errors path="name" cssClass="error"/><br>
                </div>
                <div class="form-group">
                    <label for="description">Opis produktu</label>
                    <input type="text" required name="description" id="description" class="form-control"
                           placeholder="Wpisz opis produktu"/>
                    <form:errors path="description" cssClass="error"/><br>
                </div>
                <div class="form-group">
                    <label for="quantity">Ilość produktu</label>
                    <input type="text" required name="quantity" id="quantity" class="form-control"
                           placeholder="Wpisz ilość"/>
                    <form:errors path="quantity" cssClass="error"/><br>
                </div>
                <div class="form-group">
                    <label for="price">Cena</label>
                    <input type="text" required name="price" id="price" class="form-control"
                           placeholder="Podaj cenę produktu"/>
                    <form:errors path="price" cssClass="error"/><br>
                </div>
                <button class="btn btn-primary" type="submit">Zapisz</button>
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
