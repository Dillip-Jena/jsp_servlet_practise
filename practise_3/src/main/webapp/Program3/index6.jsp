<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="in.app.Employee" %>
<%@ page import="java.util.List, java.util.Arrays" %>

<html>
    <head>
        <title>Page-6</title>
    </head>
    <body>
        <%
            Employee e1 = new Employee(1, "Jagad Guru", 23000.0);
            Employee e2 = new Employee(2, "Nirmala Ranjan", 30000.0);
            Employee e3 = new Employee(3, "Hardik Pandey", 50000.0);
            List<Employee> employees = Arrays.asList(e1, e2, e3);

            request.setAttribute("emps", employees);
        %>

        <table border="1" cellpadding="8">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Salary</th>
            </tr>

            <c:forEach items="${emps}" var="e">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.name}</td>
                    <td>${e.salary}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>