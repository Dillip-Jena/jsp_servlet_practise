<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<html>
    <head>
        <title>Page-4</title>
    </head>
    <body>
        <form method="post">
            <label for="integer">Input an integer: </label>
            <input type="number" name="integer" id="integer" step="0.001">
            <button type="submit">OK</button>
        </form>

        <fmt:formatNumber value="${param.integer}" minIntegerDigits="3" maxFractionDigits="4"/>
    </body>
</html>