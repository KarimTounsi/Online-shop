<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">


    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<jsp:include page="fragments/main-menu.jsp"/>

<section class="jumbotron text-center cart-title">
    <div class="container">
        <h1 class="jumbotron-heading">Zamówienie</h1>
    </div>

</section>
<div class="container mb-4 cart">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">Produkt</th>
                        <th scope="col">Status</th>
                        <th scope="col" class="text-center">Ilość</th>
                        <th scope="col" class="text-right">Cena</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="item"
                               items="${cart}">
                        <tr>
                            <td><img src="https://dummyimage.com/50x50/55595c/fff"/></td>
                            <td>${item.key.name}</td>
                            <td><c:choose>
                                <c:when test="${item.key.quantity > 1}">
                                    <p class="text-success">Dostępny</p>
                                </c:when>
                                <c:otherwise>
                                    <p class="text-danger">Nie dostępny</p>
                                </c:otherwise>
                            </c:choose></td>

                            <td>
                                        <input type="text" readonly class="form-control-plaintext text-center bg-white"
                                               value="${item.value}" min="1" max="100" size="5" >
                            </td>

                            <td class="text-right">${item.key.price} PLN</td>
                            <td class="text-right">
                            </td>
                        </tr>

                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Cena produktów</td>
                        <td class="text-right">${cartSum} PLN</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>transport</td>
                        <td class="text-right">${transport} PLN</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><strong>Suma zamówienia</strong></td>
                        <td class="text-right"><strong>${cartSum + transport} PLN</strong></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <c:choose>
            <c:when test="${transport > 16}">
                <form method="post" action="" id="buttonOrder">
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="validationDefault01">Email</label>
                            <input type="text" class="form-control"  name="email" id="validationDefault01" value="${user.email}"  placeholder="Podaj Email" required/>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationDefault02">Imię</label>
                            <input type="text" class="form-control" name="firstName" id="validationDefault02"  value="${user.firstName}" placeholder="Podaj imię" required/>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationDefault03">Nazwisko</label>
                            <input type="text" class="form-control"  name="lastName" id="validationDefault03" placeholder="Podaj nazwisko" value="${user.lastName}"  required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault04">Adres</label>
                            <input type="text" class="form-control" name="Address"  placeholder="Podaj Adres" id="validationDefault04" required>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="validationDefault05">Kraj</label>
                            <input type="text" class="form-control" name="country" id="validationDefault05" placeholder="Podaj nazwę Kraju" required>

                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="validationDefault06">województwo</label>
                            <input type="text" class="form-control" name="voivodeship" id="validationDefault06" placeholder="Podaj nazwę województwa" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault07">Miasto</label>
                            <input type="text" class="form-control" name="City"  placeholder="Podaj nazwę miasta" id="validationDefault07"  required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault08">Kod pocztowy</label>
                            <input type="text" class="form-control" name="postcode" placeholder="Podaj kod pocztowy" id="validationDefault08" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
                            <label class="form-check-label" for="invalidCheck2">
                                Zgadzam się z warunkami
                            </label>
                        </div>
                    </div>
                </form>
            </c:when>
            <c:otherwise>
        <form method="post" action="" id="buttonOrder">
            <div class="form-row">
                <div class="col-md-4 mb-3">
                    <label for="validationDefault01">Email</label>
                    <input type="text" class="form-control"  name="email" id="validationDefault09" value="${user.email}"  placeholder="Podaj Email" required/>
                </div>
                <div class="col-md-4 mb-3">
                    <label for="validationDefault02">Imię</label>
                    <input type="text" class="form-control" name="firstName" id="validationDefault10"  value="${user.firstName}" placeholder="Podaj imię" required/>
                </div>
                <div class="col-md-4 mb-3">
                    <label for="validationDefault03">Nazwisko</label>
                    <input type="text" class="form-control"  name="lastName" id="validationDefault11" placeholder="Podaj nazwisko" value="${user.lastName}"  required>
                </div>
            </div>
            <sec:csrfInput/>
        </form>
            </c:otherwise>
        </c:choose>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <form class="form-inline my-2 my-lg-0" method="get" action="/cart">
                    <button class="btn btn-block btn-light">Powróć</button>
                        <sec:csrfInput/>
                    </form>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                    <button class="btn btn-lg btn-block btn-success text-uppercase" form="buttonOrder">Zamów</button>
                </div>
            </div>
        </div>
    </div>
</div>
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