<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css">
    <style>
    </style>
    <!-- Custom styles for this template -->
    <%--    <link href="jumbotron.css" rel="stylesheet">--%>
</head>
<body>
<jsp:include page="fragments/main-menu.jsp"/>
<div class="container-fluid info-list">
    <div class="row">
        <div class="col-sm-6 mx-auto">
            <h2 class="text-center">Dane konta</h2>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"> <span class="font-weight-bold">Nazwa użytkownika:</span> ${user.username}</li>
                <li class="list-group-item"> <span class="font-weight-bold">Imię:</span> ${user.firstName}</li>
                <li class="list-group-item"> <span class="font-weight-bold">Nazwisko:</span> ${user.lastName}</li>
                <li class="list-group-item"> <span class="font-weight-bold">Email:</span> ${user.email}</li>
            </ul>
            <form class="form-inline my-2 my-lg-0 py-2" method="get" action="/edit">
                <button class="btn btn-primary my-2 my-sm-0 mr-sm-2" type="submit" value="${user.id}">Edytuj</button>
                <sec:csrfInput/>
            </form>
            <form class="form-inline my-2 my-lg-0 py-2" method="get" action="/edit-password">
                <button class="btn btn-primary my-2 my-sm-0 mr-sm-2" type="submit" value="${user.id}">Zmień hasło</button>
                <sec:csrfInput/>
            </form>
        </div>
    </div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>

</body>
</html>
