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
        <h1 class="jumbotron-heading">Koszyk</h1>
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
                                <%--                            <td><input class="form-control" type="text" value=""/></td>--%>

                            <td>
                                <div>
                                    <div class="input-group">
          <span class="input-group-btn">
                     <form class="form-inline my-2 my-lg-0" method="post" action="/product/subtract/cart">
              <button type="submit" class="btn btn-danger btn-number mr-1" value="${item.key.id}" name="id">
               <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-dash-square-fill" fill="currentColor"
                    xmlns="http://www.w3.org/2000/svg">
                   <path fill-rule="evenodd"
                         d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm2.5 7.5a.5.5 0 0 0 0 1h7a.5.5 0 0 0 0-1h-7z"/>
                </svg>
              </button>
                                                          <sec:csrfInput/>
                </form>
          </span>
                                        <input type="text" readonly class="form-control-plaintext text-center bg-white"
                                               value="${item.value}" min="1" max="100" size="5">


                                        <span class="input-group-btn">
                                             <form class="form-inline my-2 my-lg-0" method="post"
                                                   action="/product/add/cart">
              <button type="submit" class="btn btn-success btn-number  ml-1" value="${item.key.id}" name="id">
 <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-plus-square-fill" fill="currentColor"
      xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
        d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3v-3z"/>
</svg>
              </button>
                                                   <sec:csrfInput/>
                </form>
          </span></div>
                                </div>
                            </td>
                            <td class="text-right">${item.key.price} PLN</td>
                            <td class="text-right">
                                <form class="form-inline my-2 my-lg-0" method="post" action="/product/remove/cart">
                                    <button class="btn btn-sm btn-danger" type="submit" value="${item.key.id}"
                                            name="id"><i class="fa fa-trash"></i></button>
                                    <sec:csrfInput/>
                                </form>

                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>
                            <form action="/cart/confirm" method="get" id="buttonClick">
                                <div class="form-group">
                                    <label for="exampleFormControlSelect1">Forma przesyłki</label>
                                    <select class="form-control" id="exampleFormControlSelect1" name="transport">
                                        <option value="14">Paczkomat inpost - 14 PLN</option>
                                        <option value="16.5">Kurier inpost 16,5 PLN</option>
                                        <option value="17">Kurier DPD - 17 PLN</option>
                                    </select>
                                </div>
                            </form>
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><strong>Suma zamówienia</strong></td>
                        <td class="text-right"><strong>${cartSum} PLN</strong>

                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <form class="form-inline my-2 my-lg-0" method="get" action="/all">
                        <button class="btn btn-block btn-light">Kontynuuj zakupy</button>
                        <sec:csrfInput/>
                    </form>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                    <button class="btn btn-lg btn-block btn-success text-uppercase" form="buttonClick">Potwierdź
                    </button>


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