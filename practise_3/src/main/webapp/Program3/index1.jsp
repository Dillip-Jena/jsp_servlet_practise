<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
    <head>
        <title>Page-1</title>
    </head>
    <body>
        <!-- c:set set the variable in page scope and c:out safely print the value -->
        <c:set var="name" value="Dillip Kumar Jena" />
        <p>Name: <c:out value="${name}" /></p>
    </body>
</html>