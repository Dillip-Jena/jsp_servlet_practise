<%@ page errorPage="error.jsp" %>

<html>
    <head>
        <title>Page-5</title>
    </head>
    <body>
        <h4>Welcome to program-5</h4>

        <form method="post">
            Input numerator: <input type="number" name="numerator"><br>
            Input denominator: <input type="number" name="denominator"><br>
            <button type="submit">Divide</button>
        </form>

        <%
            String numStr = request.getParameter("numerator");
            String numDen = request.getParameter("denominator");
            int result = 0;

            if(numStr!=null && numDen!=null){
                int num = Integer.parseInt(numStr);
                int den = Integer.parseInt(numDen);

                result = num / den;
            }
        %>
        <p>Result: <%= result %></p>
    </body>
</html>