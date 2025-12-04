<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<html>
    <head>
        <title>Page-9</title>
    </head>
    <body>
        <c:set var="var1" value="java" />
        <c:set var="var2" value="Java" />

        <c:if test="${fn:toLowerCase(var1) == fn:toLowerCase(var2)}">
            <p>Strings are equal (ignore case)</p>
        </c:if>
    </body>
</html>