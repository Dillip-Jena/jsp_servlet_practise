<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
    <head>
        <title>Page-9</title>
    </head>
    <body>
        <form method="post">
            <label for="num">Enter Dividend: </label>
            <input type="number" id="num" name="num">
            <label for="den">Enter Divisor: </label>
            <input type="number" id="den" name="den">
            <button type="submit">Divide</button>
        </form>

        <!-- catch will catch error occurs in the code block and store it in var -->
        <c:catch var="err">
            <%
                int num = Integer.parseInt(request.getParameter("num"));
                int den = Integer.parseInt(request.getParameter("den"));
                int result = num/den;
                out.println("Result: " + result);
            %>
        </c:catch>

        <c:if test="${not empty err}">
            <p style="color: red;">Error: ${err.message}</p>
        </c:if>
    </body>
</html>