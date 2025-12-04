<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
    <head>
        <title>Page-3</title>
    </head>
    <body>
        <form method="post">
            <label for="marks">Input your marks: </label>
            <input type="number" id="marks" name="marks">
            <button type="submit">Grade</button>
        </form>

        <!-- c:choose is like switch statement with multiple case c:when -->
        <c:choose>
            <c:when test="${param.marks >= 90}"><p>Grade: A</p></c:when>
            <c:when test="${param.marks >= 75}"><p>Grade: B</p></c:when>
            <c:when test="${param.marks >= 60}"><p>Grade: C</p></c:when>
            <c:when test="${param.marks >= 40}"><p>Grade: D</p></c:when>
            <c:otherwise>Fail</c:otherwise>
        </c:choose>
    </body>
</html>