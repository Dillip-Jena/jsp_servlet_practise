package in.app0;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String username = req.getParameter("username");
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("""
                    <html>
                        <head>
                            <title>Page-2</title>
                            <style>
                                body{
                                    font-family: Arial, Helvetica, sans-serif;
                                }
                            </style>
                        </head>
                        <body>
                """);
        
        if (username != null && !username.isEmpty()) {
            out.printf("<h3>Hello again, %s!</h3>%n", username);
        } else {
            out.println("<h3>Hello, Guest!</h3>");
        }

        out.println("""
                            <p>Because HTTP is stateless - the server forget your name.</p>
                            <p><a href="login1">Go back to Login</a></p>
                        </body>
                    </html>
                """);

        out.flush();
    }
}
