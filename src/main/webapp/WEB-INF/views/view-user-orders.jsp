<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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


<table class="table table-sm view-all-orders">
    <thead>
    <tr>
        <th scope="col">#</th>

        <th scope="col">Adres</th>
        <th scope="col">Produkty</th>
        <th scope="col">Transport</th>
        <th scope="col">Cena transportu</th>
        <th scope="col">Suma zamówienia</th>
        <th scope="col">Metoda płatności</th>
        <th scope="col">Data utworzenia</th>
        <th scope="col">
            Status realizacji
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="theCount" items="${userOrders}" var="order">
        <tr>
            <th scope="row">${theCount.index +1}</th>
            <td>

                Imię: ${order.address.firstName} <br>
                Nazwisko: ${order.address.lastName} <br>
                Email: ${order.address.email} <br>
                Kraj: ${order.address.country} <br>
                Miasto: ${order.address.city} <br>
                Ulica: ${order.address.streetHome} <br>
                Województwo: ${order.address.voivodeship} <br>
                Kod pocztowy: ${order.address.postcode}

            </td>
            <td>

        <c:forEach var="item" items="${order.products}">

            Nazwa: ${item.key.name} <br>
            Ilość: ${item.value} <br>
              </c:forEach>
            </td>
            <td>${order.transportType}</td>
            <td>${order.transportPrice}</td>
            <td>${order.orderSum}</td>
            <td>${order.paymentMethod}</td>
            <td>${order.created}</td>
            <td>
                <c:choose>
                    <c:when test="${order.realized eq true}">
                        <p class="text-success">Zrealizowane</p>
                    </c:when>
                    <c:otherwise>
                        <p class="text-secondary">Oczekuje</p>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


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
