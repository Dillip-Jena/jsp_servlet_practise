<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDateTime" %>

<html>
    <head>
        <title>Page-8</title>
    </head>
    <body>
        <h4>Welcome to program-8</h4>

        <%!
            public String getCurrentDateTime(){
                return LocalDateTime.now().toString();
            }
        %>

        <form method="post">
            <button type="submit">Show Current Time</button>
        </form>

        <%
            if(request.getMethod().equals("POST")){
                out.print("<h4>Current Time: " + getCurrentDateTime() + "</h4>");
            }
        %>
    </body>
</html>