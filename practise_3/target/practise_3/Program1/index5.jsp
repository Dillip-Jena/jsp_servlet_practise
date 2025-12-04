<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Page-5</title>
    </head>
    <body>
        <h4>Welcome to program-5</h4>
        <%!
            String[] courses = {"Java", "Python", "Spring", "Hibernate"};
        %>

        <table border="1" cellpadding="8">
            <tr>
                <th>Course</th>
            </tr>
            <%
                for(String c : courses){
            %>
                <tr>
                    <td><%= c %></td>
                </tr>
            <%
                }
            %>
        </table>
    </body>
</html>