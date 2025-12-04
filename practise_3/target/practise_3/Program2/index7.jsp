<%@ page buffer="16kb" %>

<html>
    <head>
        <title>Page-7</title>
    </head>
    <body>
        <%
            for(int i=1; i<=1000; i++){
                out.println("Line" + i + "<br>");
            }
        %>
    </body>
</html>