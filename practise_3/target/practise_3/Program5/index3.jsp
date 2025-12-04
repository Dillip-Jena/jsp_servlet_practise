<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>

<html>
    <head>
        <title>Page-3</title>
        <style>
            h3 {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h3>Insert Record into Table</h3>
        <form method="post">
            <label for="empId">Input Id: </label>
            <input type="number" name="empId" id="empId">
            <br><br>
            <label for="empName">Input Name: </label>
            <input type="text" name="empName" id="empName">
            <br><br>
            <label for="empSalary">Input Salary: </label>
            <input type="text" name="empSalary" id="empSalary" >
            <br><br>
            <button type="submit">Add Employee</button>
        </form>

        <c:if test="${not empty param.empId and not empty param.empName and not empty param.empSalary}">
            <%@ include file="db-config.jsp" %>
            
            <sql:update dataSource="${db}" var="count">
                INSERT INTO employees(id, name, salary)
                VALUES (?, ?, ?)
                <sql:param value="${param.empId}" />
                <sql:param value="${param.empName}" />
                <sql:param value="${param.empSalary}" />
            </sql:update>

            <p>${count} employee(s) inserted successfully!</p>
        </c:if>
    </body>
</html>