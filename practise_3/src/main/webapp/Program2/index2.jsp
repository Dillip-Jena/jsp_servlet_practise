<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>

<html>
    <head>
        <title>Page-2</title>
    </head>
    <body>
        <h4>Welcome to program-2</h4>
        <%
            Date currentDate = new Date();
            String date = currentDate.toString();
        %>
        <p>Current Date: <%= date %></p>
    </body>
</html>