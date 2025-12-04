<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map, java.util.HashMap" %>

<html>
    <head>
        <title>Page-6</title>
    </head>
    <body>
        <h4>Welcome to program-6</h4>
        <%!
            static Map<String, String> schedule = new HashMap<>();

            static{
                schedule.put("monday", "Gym");
                schedule.put("tuesday", "Study");
                schedule.put("wednesday", "Project Work");
                schedule.put("thursday", "Workshop");
                schedule.put("saturday", "Movie");
            }
        %>

        <form method="post">
            <label for="day">Input day: </label>
            <input type="text" id="day" name="day">
            <button type="submit">Submit</button>
        </form>

        <%
            String day = request.getParameter("day");
            if(day != null){
                String task = schedule.get(day.toLowerCase());
                out.print("<h4>Task: "+ (task!=null ? task : "No Task Found") +"</h4>");
            }
        %>
    </body>
</html>