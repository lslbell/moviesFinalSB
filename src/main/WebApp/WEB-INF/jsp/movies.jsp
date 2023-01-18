<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">

<head>
    <title>Best Movies</title>
    <link rel="stylesheet" href="globalStyles.css">
</head>

<body>
    <h1>List Of Movies</h1>
    <link rel="stylesheet" href="globalStyles.css">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>ISBN</th>
            <th>TITLE</th>
            <th>Genre</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${movies}" var="movie">
            <tr>
                <td><a href = "
                    <c:url value = "/browseMovies/edit">
                        <c:param name="id" value="${movie.id}" />
                    </c:url>
                ">${movie.id}</a>
                </td>
                <td>${movie.isbn}</td>
                <td>${movie.title}</td>
                <td>${movie.movieType.type}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>

</html>