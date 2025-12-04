<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
    <head>
        <title>Page-4</title>
    </head>
    <body>
        <%
            String[] fruits = {"apple", "mango", "orange", "guava", "litchi"};
            request.setAttribute("fruits", fruits);
        %>

        <table border="1" cellpadding="8">
            <tr><th>Fruits</th></tr>

            <!-- we use forEach to traverse through each element in array -->
            <c:forEach items="${fruits}" var="f">
                <tr><td>${f}</td></tr>
            </c:forEach>
        </table>
    </body>
</html>