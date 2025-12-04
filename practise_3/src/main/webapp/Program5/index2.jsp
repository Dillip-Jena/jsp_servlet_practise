<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>

<html>
    <head>
        <title>Page-2</title>
    </head>
    <body>
        <!--Input the id from the user-->
        <h3>Search employee by ID</h3>
        <form method="post">
            <label for="id">Enter Employee ID: </label>
            <input type="number" name="empId" id="id">
            <button type="submit">Submit</button>
        </form>

        <c:if test="${not empty param.empId}">
            <!--include the db file-->
            <%@ include file="db-config.jsp" %>

            <!--Run the query-->
            <sql:query var="res" dataSource="${db}">
                SELECT * FROM employees WHERE id=? 
                <sql:param value="${param.empId}" />
            </sql:query>

            <c:if test="${res.rowCount==0}">
                <p>No employee found.</p>
            </c:if>

            <c:forEach var="emp" items="${res.rows}">
                <p><b>ID: </b>${emp.id}</p>
                <p><b>Name: </b>${emp.name}</p>
                <p><b>Salary: </b>${emp.salary}</p>
            </c:forEach>
        </c:if>
        
    </body>
</html>