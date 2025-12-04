<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<html>
    <head>
        <title>Page-6</title>
    </head>
    <body>
        <c:set var="csv" value="apple,banana,mango,guava,litchi" />

        <c:set var="items" value="${fn:split(csv,',')}" />
        <c:forEach var="item" items="${items}" varStatus="i">
            <p>${i.count} - ${item}</p>
        </c:forEach>
    </body>
</html>