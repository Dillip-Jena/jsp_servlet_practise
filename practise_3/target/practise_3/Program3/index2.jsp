<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
    <head>
        <title>Page-2</title>
    </head>
    <body>
        <form method="post">
            <label for="num">Input a number: </label>
            <input type="number" id="num" name="num" >
            <button type="submit">Check</button>
        </form>

        <!-- c:if check condition if true then execute the block -->
         <c:if test="${not empty param.num}">
            <c:if test="${param.num%2 == 0}">
                <p>${param.num} is Even.</p>
            </c:if>

            <c:if test="${param.num%2 != 0}">
                <p>${param.num} is Odd.</p>
            </c:if>
         </c:if>
    </body>
</html>