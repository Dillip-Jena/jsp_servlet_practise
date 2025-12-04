<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Page-10</title>
    </head>
    <body>
        <h4>Welcome to program-10</h4>

        <%!
            public String divide(int a, int b){
                try{
                    return "Result: " + (a/b);
                }catch(Exception e){
                    return "Error: Divide by Zero!";
                }
            }
        %>

        <form method="post">
            <label for="num1">Input first number: </label>
            <input type="number" id="num1" name="num1">
            <br><br>
            <label for="num2">Input second number: </label>
            <input type="number" id="num2" name="num2">
            <br><br>
            <button type="submit">Divide</button>
        </form>

        <%
            String sn1 = request.getParameter("num1");
            String sn2 = request.getParameter("num2");

            if(sn1 != null && sn2 != null){
                int n1 = Integer.parseInt(sn1);
                int n2 = Integer.parseInt(sn2);
                out.print("<h4> " + divide(n1, n2) + " </h4>");
            }
        %>
    </body>
</html>