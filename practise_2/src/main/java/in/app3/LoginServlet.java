package in.app3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", urlPatterns = {"/loginservlet3"})
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
                                <h3>URL Rewritting Example</h3>
                                <hr>
                                <form action="loginservlet3" method="post">
                                    <label for="name">Input your name: </label>
                                    <input name="name" id="name" type="text">
                                    <button type="submit">Submit</button>
                                </form>
                            </body>
                        </html>
                """);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        //get the parameter
        String userName = req.getParameter("name");
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.printf("""
                        <html>
                            <head>
                                <title>Page-2</title>
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
                                <h3>Welcome, %s !</h3>
                                <p>Data will now be sent to the next servlet via URL Rewritting.</p>
                                <hr>
                                <a href="welcome3?user=%s">Go to Welcome Page</a>
                            </body>
                        </html>
                """, userName, userName);
        out.flush();
    }
}
