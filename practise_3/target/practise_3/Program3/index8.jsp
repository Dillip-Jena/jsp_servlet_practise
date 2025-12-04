<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
    <head>
        <title>Page-8</title>
    </head>
    <body>
        <c:set var="temp" value="Temporary" />
        <p>Before Remove: <c:out value="${temp}"/></p>

        <c:remove var="temp" />
        <p>After Remove: <c:out value="${temp}" default="(Remove)"/></p>
    </body>
</html>