<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">

<head>
    <title>Best Movies</title>
</head>

<body>
    <h1>> List Of Movies</h1>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>ISBN</th>
            <th>TITLE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${movies}" var="movie">
            <tr>
                <td>${movie.id}</td>
                <td>${movie.isbn}</td>
                <td>${movie.title}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>

</html>