<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Page-2</title>
    </head>
    <body>
        <h3>Welcome to program-2</h3>

        <%!
            int counter = 0;
            public int increaseCount(){
                return ++counter;
            }
        %>

        <p>Page visited: <%= increaseCount() %> times.</p>
    </body>
</html>