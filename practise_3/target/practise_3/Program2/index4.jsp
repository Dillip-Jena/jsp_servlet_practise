<%@ page session="false" %>

<html>
    <head>
        <title>Page-4</title>
    </head>
    <body>
        <%
            try{
                session.setAttribute("user", "admin");
            }catch(Exception e){
                out.print("Session is disabled!");
            }
        %>
    </body>
</html>