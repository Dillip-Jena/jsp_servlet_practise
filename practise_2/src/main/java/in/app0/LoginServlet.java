package in.app0;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("""
                    <html>
                        <head>
                            <title>Page-1</title>
                            <style>
                                body{
                                    font-family: Arial, Helvetica, sans-serif;
                                }
                                hr{
                                    margin-bottom: 20px;
                                }
                            </style>
                        </head>
                        <body>
                            <h2>Simple login (without session)</h2>
                            <hr>
                            <form action="login1" method="post">
                                <label for="name">Enter Name: </label>
                                <input id="name" name="username" type="text">
                                <button type="submit">Login</button>
                            </form>
                        </body>
                    </html>
                """);

        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        //get the parameter
        String username = req.getParameter("username");
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.printf("""
                    <html>
                        <head>
                            <title>Page-1</title>
                            <style>
                                body{
                                    font-family: Arial, Helvetica, sans-serif;
                                }
                            </style>
                        </head>
                        <body>
                            <h3>Welcome, %s !</h3>
                            <p><a href="dashboard1">Go to Dashboard</a></p>
                        </body>
                    </html>
                """, username);

        out.flush();
    }
}
