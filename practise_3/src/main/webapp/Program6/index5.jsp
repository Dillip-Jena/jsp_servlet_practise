<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<html>
    <head>
        <title>Page-5</title>
    </head>
    <body>
        <form method="post">
            <label for="user">Input user name: </label>
            <input type="text" id="user" name="user">
            <button type="submit">Check</button>
        </form>

        <c:set var="uname" value="${param.user}" />

        <c:choose>
            <c:when test="${fn:contains(uname, '@') or fn:contains(uname, '!') or fn:contains(uname, '#') or fn:contains(uname, '%')}">
                <p>Invalid Username</p>
            </c:when>
            <c:otherwise>
                <p>Valid Username</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>