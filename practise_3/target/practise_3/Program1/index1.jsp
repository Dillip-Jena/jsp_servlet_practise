<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.lang.Math" %>

<html>
    <head>
        <title>Page-1</title>
    </head>
    <body>
        <h3>Welcome to program-1</h3>
        <!-- Declaration tag in jsp : used to declare variable and method that can be use anywhere inside the jsp page-->
        <%!
            public double calculateArea(double radius){
                return Math.PI * Math.pow(radius, 2);
            }

            public double calculateArea(double length, double width){
                return length * width;
            }
        %>

        <form method="post">
            <h3>Calculate Area</h3>

            <label for="shape">Shape: </label>
            <select name="shape" id="shape">
                <option value="circle">Circle</option>
                <option value="rectangle">Rectangle</option>
            </select>
            <br><br>
            <label for="v1">Value 1: </label>
            <input type="number" name="v1" id="v1" step="any">
            <br><br>
            <label for="v2">Value 2: </label>
            <input type="number" name="v2" id="v2" step="any">
            <br><br>
            <button type="submit">Calculate</button>
        </form>

        <%
            String shape = request.getParameter("shape");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");

            if(shape!=null && !v1.isEmpty()){
                if(shape.equals("circle")){
                    double radius = Double.parseDouble(v1);
                    out.print("<h4>Area of Circle: " +calculateArea(radius)+ "</h4>");
                }else{
                    if(!v2.isEmpty()){
                        double length = Double.parseDouble(v1);
                        double width = Double.parseDouble(v2);
                        out.print("<h4>Area of Rectangle: " +calculateArea(length, width)+ "</h4>");
                    }
                }
            }
        %>
    </body>
</html>