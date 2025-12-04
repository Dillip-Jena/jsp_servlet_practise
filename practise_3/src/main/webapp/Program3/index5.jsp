<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
    <head>
        <title>Page-5</title>
    </head>
    <body>
        <c:forEach var="n" begin="1" end="10" varStatus="s">
            Number: ${n} | index: ${s.index} | <c:out value="${n%2 == 0 ? 'Even' : 'Odd'}" />
            <br>
        </c:forEach>
    </body>
</html>