<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<html>
    <head>
        <title>Page-2</title>
        <style>
            #green {
                color: green;
            }
            #red {
                color: red;
            }
        </style>
    </head>
    <body>
        <form method="post">
            <label for="email">Input email: </label>
            <input type="text" id="email" name="email">
            <button type="submit">Validate</button>
        </form>

        <p id="green">
            <c:if test="${fn:contains(param.email, '@') and fn:contains(param.email, '.')}">
                Valid Email
            </c:if>
        </p>
        <p id="red">
            <c:if test="${not (fn:contains(param.email, '@') and fn:contains(param.email, '.'))}">
                Invalid Email
            </c:if>
        </p>
    </body>
</html>