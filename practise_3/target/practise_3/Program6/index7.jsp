<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<html>
    <head>
        <title>Page-7</title>
    </head>
    <body>
        <form method="post">
            <label for="password">Input a password: </label>
            <input type="password" id="password" name="password">
            <button type="submit">Check</button>
        </form>

        <c:set var="upass" value="${param.password}" />

        <c:choose>
            <c:when test="${
                fn:length(upass) >= 8
                and fn:contains(upass, '@')
                and (fn:contains(upass, '0') 
                    or fn:contains(upass, '1')
                    or fn:contains(upass, '2')
                    or fn:contains(upass, '3')
                    or fn:contains(upass, '4')
                    or fn:contains(upass, '5')
                    or fn:contains(upass, '6')
                    or fn:contains(upass, '7')
                    or fn:contains(upass, '8')
                    or fn:contains(upass, '9')
                )
            }">
                <p>Strong Password</p>
            </c:when>
            <c:otherwise>
                <p>Weak Password</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>