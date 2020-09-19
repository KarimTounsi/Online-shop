<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
            integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
            integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="fragments/main-menu.jsp"/>
<div class="container">
    <sec:authorize access="isAuthenticated()">
    <div class="row" style="margin-top: 40px; margin-bottom: 10px">
        <div class="col-1"></div>
        <div class="col-6"><h2>Dodaj ogłoszenie</h2></div>
        <div class="col-5"></div>
    </div>

    <div class="row">
        <div class="col-2"></div>
        <div class="col-8">
            <form method="post" action="/add-advert">
                <div class="form-group">
                    <label for="title">Tytuł ogłoszenia:</label>
                    <input type="text" required name="title" id="title" class="form-control"
                           placeholder="Podaj tytuł ogłoszenia"/>
                </div>
                <div class="form-group">
                    <label for="description">Opis ogłoszenia</label>
                    <textarea name="description" id="description"
                              class="form-control"
                              placeholder="Uzupełnij opis ogłoszenia"></textarea>
                </div>
                <button class="btn btn-primary" type="submit">Dodaj</button>
                <button class="btn btn-secondary" type="reset">Wyczyść dane</button>
                <sec:csrfInput/>
            </form>
                <%-- Tutaj formularz dodawania nowego ogłoszenia (PÓŹNIEJ) --%>

                <%-- Treść strony tylko dla zalogowanych użytkowników --%>
            </sec:authorize>

        </div>
        <div class="col-2"></div>
    </div>

    <div class="row" style="margin-top: 40px; margin-bottom: 10px">
        <div class="col-1"></div>
        <div class="col-6"><h2>Lista ogłoszeń</h2></div>
        <div class="col-5"></div>
    </div>

    <div class="row">
        <div class="col-12" style="padding-bottom: 20px">
            <sec:authorize access="isAuthenticated()">
                <a href=/user-adverts> Lista ogłoszeń na koncie</a> <br>
                <a href=/User-followed-adverts-page>Lista obserwowanych ogłoszeń</a>
            </sec:authorize>
            <table>
                <tr>
                    <th>Lp.</th>
                    <th>Tytuł</th>
                    <th>Treść</th>
                    <th>Autor</th>
                    <th>Data dodania</th>
                </tr>
                <c:forEach items="${adverts}" var="advert" varStatus="stat">
                    <tr>
                        <td>${stat.count}</td>
                        <td><b>${advert.title}</b></td>
                        <td>${advert.description}</td>
                        <td>${advert.user.username}</td>
                        <td>${advert.posted}</td>
                        <sec:authorize access="isAuthenticated()">
                            <td>
                                <a href=/user-adverts/${advert.user.id}>Lista ogłoszeń danego użytkownika</a>
                            </td>
                            <td>
                                <form method="post" action="/add-advert-to-observed">
                                    <input type="text" required name="advertId" id="advertId" value="${advert.id}"
                                           class="form-control" hidden/>
                                    <button class="btn btn-primary" type="submit">obserwuj</button>
                                    <sec:csrfInput/>
                                </form>
                            </td>
                            <td>
                                <form method="post" action="/subtract-advert-to-observed">
                                    <input type="text" required name="advertId" id="advertId" value="${advert.id}"
                                           class="form-control" hidden/>
                                    <button class="btn btn-primary" type="submit">nie obserwuj</button>
                                    <sec:csrfInput/>
                                </form>
                            </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
            </table>
            <%-- Tutaj tabela z ogłoszeniami --%>
        </div>
    </div>

</div>
</body>
</html>
