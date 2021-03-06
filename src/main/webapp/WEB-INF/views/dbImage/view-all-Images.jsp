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
<jsp:include page="../fragments/main-menu.jsp"/>
<table class="table view-all-products">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Nazwa</th>
            <th scope="col">Edycja</th>
            <th scope="col"><button type="button" class="btn btn-primary button-delete-all" data-toggle="modal" data-target="#exampleModalCenter">
                Usuwanie
                (Usuń wszystko)</button>
                <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" >
                    <div class="modal-dialog modal-dialog-centered" role="document" >
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Uwaga</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Czy na pewno chcesz usunąć wszystkie kategorie ?
                            </div>
                            <div class="modal-footer" >
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Zamknij</button>
                                <form class="form-inline my-2 my-lg-0" method="post" action="/admin/image/delete/all">
                                    <button type="submit" class="btn btn-primary">Potwierdź</button>
                                    <sec:csrfInput/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="theCount" items="${images}" var="image">
        <tr>
            <th scope="row">${theCount.index +1}</th>
            <td>${image.imageName}</td>
            <td> <img title="${image.imageName}" src="/image/view/${image.id}"  width="250" height="160"/></td>
                <td>
                    <form class="form-inline my-2 my-lg-0" method="get" action="/admin/image/edit">
                        <button class="btn btn-primary my-2 my-sm-0 mr-sm-2" name="id" value="${image.id}" type="submit">Edytuj</button>
                        <sec:csrfInput/>
                    </form>
                </td>
                <td>
                    <form class="form-inline my-2 my-lg-0" method="post" action="/admin/image/delete">
                        <button class="btn btn-danger my-2 my-sm-0 mr-sm-2" name="id" value="${image.id}" type="submit">Usuń</button>
                        <sec:csrfInput/>
                    </form>
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
