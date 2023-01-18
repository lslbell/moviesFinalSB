<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Add Movie</title>
    <link rel="stylesheet" href="globalStyles.css">
</head>
    <body>
        <h1>Add Movie to DB</h1>

        <c:if test="${addMovieSuccess}">
            <div>Successfully added Movie with Title: ${addMovieTitle}, ${addMovieTitle}, ${addMovieTitle}</div>
        </c:if>

        <form:form action="/browseMovies" method="post" modelAttribute="movie">
            <form:errors path="*" ccsClass="errorblock" element="div" />
            <form:label path="id">ID: </form:label> <form:input path="id" type="text"/>
            <form:label path="isbn">ISBN: </form:label> <form:input path="isbn" type="text"/>
            <form:label path="title">TITLE: </form:label> <form:input path="title" type="text"/>
            <form:label path="title" ccsErrorClass="error">TITLE </form:label> <form:input path="title" type="text" disabled="true" cssErrorClass="error"/>
            <form:select path="movieType">
                 <form:options items="${movieTypeList}" itemLabel="type" itemValue="id" />
            </form:select>
            <input type="submit" value="submit">
        </form:form>
    </body>
</html>