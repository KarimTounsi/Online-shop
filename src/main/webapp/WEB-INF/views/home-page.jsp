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
    <link rel="stylesheet" href="css/main.css">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

<%--    Custom styles for this template --%>
<%--      <link href="jumbotron.css" rel="stylesheet">--%>

</head>
<body>

<jsp:include page="fragments/main-menu.jsp"/>
<main role="main">
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container text-center bigLogo">
            <img src="/img/logo.png" width="300" height="300"/><h1 class="display-3"> ImStore</h1>
        </div>
    </div>
    <div class="container-fluid">
        <!-- Example row of columns -->
        <div class="row">
            <c:forEach varStatus="theCount" items="${LastSixProducts}" var="product">
            <div class="col-md-4 col-xl-2 text-center">
                    <h2>${product.name}</h2>
                    <p>
                        <c:forEach varStatus="theCount" items="${product.images}" var="image" end="0">
                            <img  src="/image/view/${image.id}" width="200" height="200"/>
                        </c:forEach>
                    </p>
                    <p><a class="btn btn-secondary" href="/product/${product.id}" role="button">Pokaż szczegóły &raquo;</a></p>
            </div>
            </c:forEach>
        </div>
    </div> <!-- /container -->
</main>

<footer class="container-fluid">
</footer>
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
