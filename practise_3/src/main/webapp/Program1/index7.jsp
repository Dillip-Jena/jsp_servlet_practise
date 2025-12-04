<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Page-7</title>
    </head>
    <body>
        <h4>Welcome to program-7</h4>
        <%!
            public int factorial(int n){
                if(n==0 || n==1){
                    return 1;
                }
                return n * factorial(n-1);
            }
        %>

        <form method="post">
            <label for="num">Input a number: </label>
            <input type="number" id="num" name="num">
            <button type="submit">Calculate</button>
        </form>

        <%
            String strNum = request.getParameter("num");
            if(strNum!=null && !strNum.isEmpty()){
                int num = Integer.parseInt(strNum);
                out.print("<h4>Factorial: "+ factorial(num) +"</h4>");
            }
        %>
    </body>
</html>