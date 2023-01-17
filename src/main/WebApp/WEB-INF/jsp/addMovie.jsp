<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Poster</title>

    <link rel="stylesheet" type="text/css" href="styles.css" />

</head>
    <body>
        <h1>We are on the poster page!</h1>

        <c:if test="${addMovieSuccess}">
            <div>Successfully added Book with Title: ${addMovieTitle}</div>
        </c:if>

        <form:form action="/movie" method="post" modelAttribute="movie">
            <form:errors path="*" ccsClass="errorblock" element="div" />
            <form:label path="id">ID: </form:label> <form:input path="id" type="text"/>
            <form:label path="isbn">ISBN: </form:label> <form:input path="isbn" type="text"/>
            <form:label path="title">TITLE: </form:label> <form:input path="title" type="text"/>
            <form:label path="title" ccsErrorClass="error">TITLE </form:label> <form:input path="title" type="text" cssErrorClass="error"/>
            <input type="submit" value="submit">
        </form:form>
    </body>
</html>