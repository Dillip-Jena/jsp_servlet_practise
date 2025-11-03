package in.app2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "firstServlet", urlPatterns = {"/firstservlet2"})
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
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
                                <h3>Hidden Form Field Example</h3>
                                <hr>
                                <form action="firstservlet2" method="post">
                                    <label for="name">Input your name: </label>
                                    <input type="text" name="name" id="name">
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
        String name = req.getParameter("name");
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
                                    hr{
                                        margin-bottom: 20px;
                                    }
                                </style>
                            </head>
                            <body>
                                <h3>Welcome, %s !</h3>
                                <p>Your name will be passed to the next servlet using a hidden form field.</p>
                                <hr>
                                <form action="secondservlet2" method="post">
                                    <input type="hidden" name="hiddenname" id="name" value="%s" >
                                    <button type="submit">Go to Second Servlet</button>
                                </form>
                            </body>
                        </html>
                """, name, name);

        out.flush();
    }
}
