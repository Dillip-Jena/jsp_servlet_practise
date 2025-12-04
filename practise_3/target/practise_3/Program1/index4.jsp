<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Page-4</title>
    </head>
    <body>
        <h4>Welcome to program-4</h4>

        <%!
            public boolean isPrime(int n){
                if(n<=1){
                    return false;
                }else{
                    for(int i=2; i<=Math.sqrt(n); i++){
                        if(n%i==0){
                            return false;
                        }
                    }
                }
                return true;
            }
        %>

        <form method="post">
            <h3>Prime Number Checker</h3>
            <label for="num">Input a number: </label>
            <input type="number" name="num" id="num">
            <button type="submit">Check</button>
        </form>

        <%
            String strNum = request.getParameter("num");
            if(strNum!=null && !strNum.isEmpty()){
                int num = Integer.parseInt(strNum);
                out.print(isPrime(num) ? "<h4>Is a Prime</h4>" : "<h4>Not a prime</h4>");
            }
        %>
    </body>
</html>