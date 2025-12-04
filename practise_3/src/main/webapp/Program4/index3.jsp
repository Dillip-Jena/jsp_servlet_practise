<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<html>
    <head>
        <title>Page-3</title>
    </head>
    <body>
        <fmt:setBundle basename="messages" />
        <h4><fmt:message key="welcome" /></h4>
        <h4>
            <fmt:message key="user.greeting">
                <fmt:param value="Dillip Jena" />
                <fmt:param value="4" />
            </fmt:message>
        </h4>
    </body>
</html>