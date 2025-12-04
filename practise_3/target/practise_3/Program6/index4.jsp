<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<html>
    <head>
        <title>Page-4</title>
    </head>
    <body>
        <c:set var="filename" value="report.zip" />

        <!--find the last index of '.'-->
        <c:set var="lastDot" value="${fn:length(filename) - fn:length(fn:substringAfter(filename, '.')) - 1}" />

        <!--extract extension-->
        <c:set var="extension" value="${fn:substring(filename, lastDot+1, fn:length(filename))}" />

        <p>Extension: ${extension}</p>
    </body>
</html>