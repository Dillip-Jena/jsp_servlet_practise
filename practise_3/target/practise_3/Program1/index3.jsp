<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Page-3</title>
    </head>
    <body>
        <!--Validate email using declare method-->
        <h3>Welcome to program-3</h3>
        <%!
            public boolean isValidEmail(String email){
                return email!=null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
            }
        %>

        <form method="post">
            <label for="email">Input email: </label>
            <input type="text" name="email" id="email">
            <button type="submit">Check</button>
        </form>

        <%
            String email = request.getParameter("email");
            if(email!=null){
                if(isValidEmail(email)){
                    out.print("<h4 style='color: green;'>Valid Email</h4>");
                }else{
                    out.print("<h4 style='color: red;'>Invalid Email</h4>");
                }
            }
        %>
    </body>
</html>