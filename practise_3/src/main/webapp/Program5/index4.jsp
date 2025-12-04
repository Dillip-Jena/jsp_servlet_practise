<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>

<html>
    <head>
        <title>Page-4</title>
        <style>
            p{
                color: red;
            }
        </style>
    </head>
    <body>
        <h3>Testing SQL Exception Handling</h3>

        <%@ include file="db-config.jsp" %>

        <c:catch var="err">
            <sql:query var="badQuery" dataSource="${db}">
                SELECT * FROM nonexistentTable;
            </sql:query>
        </c:catch>

        <c:if test="${not empty err}">
            <p>Database error: ${err}</p>
        </c:if>
    </body>
</html>