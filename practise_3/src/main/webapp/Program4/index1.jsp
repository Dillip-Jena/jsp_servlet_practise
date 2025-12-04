<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fn" %>

<jsp:useBean id="now" class="java.util.Date" />

<html>
    <head>
        <title>Page-1</title>
    </head>
    <body>
        <h4>Display the date format</h4>
        <fn:formatDate value="${now}" type="date" dateStyle="full" /> 
        <br>
        <fn:formatDate value="${now}" type="date" dateStyle="long" />
        <br>
        <fn:formatDate value="${now}" type="date" dateStyle="short" />
        <br>
        <hr>
        <h4>Display the time format</h4>
        <fn:formatDate value="${now}" pattern="hh:mm:ss a" />
        <br>
        <fn:formatDate value="${now}" pattern="HH:mm:ss" />
        <br>
        <h4>Convert String to Date</h4>
        <fn:parseDate var="parseDate" value="2025-10-15" pattern="yyyy-MM-dd" />
        Formatted: 
        <fn:formatDate value="${parseDate}" dateStyle="long" />
    </body>
</html>