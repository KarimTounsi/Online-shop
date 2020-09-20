<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Witamy na stronie startowej
<h1><spring:message code="homepage.welcome"/></h1>


<h1><spring:message code="app.title"/></h1>

<h3><spring:message code="hello.message" arguments="${person.firstName}"/></h3>
</body>
</html>
