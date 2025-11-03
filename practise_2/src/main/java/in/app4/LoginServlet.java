package in.app4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginservlet4")
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
                                <h3>HttpSession Example</h3>
                                <hr>
                                <form action="loginservlet4" method="post">
                                    <label for="name">Enter your name: </label>
                                    <input id="name" name="name" type="text">
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
        String username = req.getParameter("name");
        res.setContentType("text/html");

        //create httpSession object and store data in session
        HttpSession session = req.getSession();
        session.setAttribute("user", username);

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
                                <p>Session created successfully !</p>
                                <hr>
                                <a href="dashboardservlet4">Go to Dashboard</a>
                            </body>
                        </html>
                """, username);
        out.flush();
    }
}
