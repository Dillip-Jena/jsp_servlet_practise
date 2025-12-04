<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Page-9</title>
    </head>
    <body>
        <h4>Welcome to program-9</h4>

        <%!
            public String getGrade(int marks){
                if(marks<0 || marks>100){
                    return "Invalid Marks";
                }

                if(marks>90){
                    return "A";
                }else if(marks>=75){
                    return "B";
                }else if(marks>=60){
                    return "C";
                }else if(marks>=40){
                    return "D";
                }else{
                    return "Fail";
                }
            }
        %>

        <form method="post">
            <label for="marks">Input marks: </label>
            <input type="number" id="marks" name="marks">
            <button type="submit">Calculate Grade</button>
        </form>

        <%
            String strMarks = request.getParameter("marks");
            if(strMarks!=null){
                int marks = Integer.parseInt(strMarks);
                out.print("<h4>Grade: "+ getGrade(marks) +"</h4>");
            }
        %>
    </body>
</html>