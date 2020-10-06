<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html lang="en">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Produkt</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css">

</head>

<body>
<jsp:include page="fragments/main-menu.jsp"/>


<div class="container product">
    <div class="card">
        <div class="container-fluid">
            <div class="wrapper row">
                <div class="preview col-md-6">
                    <div class="preview-pic tab-content">
                        <div class="tab-pane active" id="pic-1">
                            <c:forEach varStatus="theCount" items="${product.images}" var="image">
                                <img title="${image.imageName}" src="/image/view/${image.id}" width="400" height="252" class="pt-2"/>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="details col-md-6 ">
                    <h3 class="product-title text-center">${product.name}</h3>

                    <h5 class="product-description"> ${product.description} </h5>
                    <h4 class="price">Cena produktu: <span class="text-dark">${product.price} PLN</span></h4>

                    <sec:authorize access="!isAuthenticated()">
                        <span>Zaloguj się na konto aby dodać do koszyka</span>
                    </sec:authorize>

                    <sec:authorize access="isAuthenticated()">
                        <c:choose>
                            <c:when test="${product.quantity > 1}">
                                <div class="action">
                                    <form class="form-inline my-2 my-lg-0" method="post" action="/product/add/cart">
                                        <button class="add-to-cart btn btn-success" type="submit" name="id"
                                                value="${product.id}">dodaj do koszyka
                                        </button>
                                        <sec:csrfInput/>
                                    </form>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="action">
                                    <form class="form-inline my-2 my-lg-0" method="post" action="/product/add/cart">
                                        <button class="add-to-cart btn btn-success" type="submit" name="id"
                                                value="${product.id}" disabled>dodaj do koszyka
                                        </button>
                                        <sec:csrfInput/>
                                    </form>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </sec:authorize>
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

