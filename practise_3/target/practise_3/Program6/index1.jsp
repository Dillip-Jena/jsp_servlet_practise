<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<html>
    <head>
        <title>Page-1</title>
    </head>
    <body>
        <c:set var="text" value="  Java        Server  Pages  " />

        <!--Trim the leading spaces-->
        <c:set var="trim" value="${fn:trim(text)}" />

        <!--Replace multiple space with single space-->
        <c:set var="single" value="${fn:replace(text, '  ', ' ')}" />

        <p>Final Output: ${trim}</p>
        <p>Single Space: ${single}</p>
    </body>
</html>