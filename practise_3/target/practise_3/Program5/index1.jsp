<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>

<html>
    <head>
        <title>Page-1</title>
    </head>
    <body>
        <fmt:setBundle basename="db" />

        <!--Load the properties into a variable-->
        <fmt:message key="db.driver" var="dbDriver" />
        <fmt:message key="db.url" var="dbUrl" />
        <fmt:message key="db.user" var="dbUser" />
        <fmt:message key="db.password" var="dbPassword" />

        <!--Configure the data source-->
        <sql:setDataSource var="db"
            driver="${dbDriver}" 
            url="${dbUrl}"
            user="${dbUser}"
            password="${dbPassword}"
        />

        <!-- Run Select query -->
        <sql:query var="result" dataSource="${db}">
            SELECT * FROM employees;
        </sql:query>

        <table border="1" cellpadding="8">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Salary</th>
            </tr>

            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td>${row.id}</td>
                    <td>${row.name}</td>
                    <td>${row.salary}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>